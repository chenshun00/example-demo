package io.github.chenshun00.springcloud.gateway;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.cache.CacheFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Signal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author chenshun00@gmail.com
 * @since 2022/7/9 2:00 PM
 */
public class ReactorDemo {

    final static Logger log = LoggerFactory.getLogger(ReactorDemo.class);
    private static final String CACHE_KEY = "routes";

    private static Flux<String> fetch() {
        System.out.println("111111");
        return Flux.fromIterable(Arrays.asList("11", "22", "33", "44"));
    }

    private static final Map<String, List> cache = new ConcurrentHashMap<>();

    static Flux<String> routes = lookup(cache, CACHE_KEY, String.class).onCacheMissResume(Flux.fromIterable(Arrays.asList("11", "22", "33", "44")));

    public static <KEY, VALUE> CacheFlux.FluxCacheBuilderMapMiss<VALUE> lookup(Map<KEY, ? super List> cacheMap, KEY key, Class<VALUE> valueClass) {

        new CacheFlux.FluxCacheBuilderMapMiss<VALUE>() {
            @Override
            public Flux<VALUE> onCacheMissResume(Supplier<Flux<VALUE>> otherSupplier) {
                return Flux.defer(() -> {
                    Object fromCache = cacheMap.get(key);
                    if (fromCache == null) {
                        return otherSupplier.get()
                                .materialize()
                                .collectList()
                                .doOnNext(signals -> cacheMap.put(key, signals))
                                .flatMapIterable(Function.identity())
                                .dematerialize();
                    } else if (fromCache instanceof List) {
                        List<Signal<VALUE>> fromCacheSignals = (List<Signal<VALUE>>) fromCache;
                        return Flux.fromIterable(fromCacheSignals).dematerialize();
                    } else {
                        return Flux.error(new IllegalArgumentException("Content of cache for key " + key + " is not a List"));
                    }
                });
            }
        };

        return otherSupplier -> Flux.defer(() -> {
            Object fromCache = cacheMap.get(key);
            if (fromCache == null) {
                return otherSupplier.get()
                        .materialize()
                        .collectList()
                        .doOnNext(signals -> cacheMap.put(key, signals))
                        .flatMapIterable(Function.identity())
                        .dematerialize();
            } else if (fromCache instanceof List) {
                try {
                    @SuppressWarnings("unchecked")
                    List<Signal<VALUE>> fromCacheSignals = (List<Signal<VALUE>>) fromCache;
                    return Flux.fromIterable(fromCacheSignals)
                            .dematerialize();
                } catch (Throwable cause) {
                    return Flux.error(new IllegalArgumentException("Content of cache for key " + key + " cannot be cast to List<Signal>", cause));
                }
            } else {
                return Flux.error(new IllegalArgumentException("Content of cache for key " + key + " is not a List"));
            }
        });
    }


    public static Flux<String> getRoutes(String s) {
        return Flux.just(s);
    }

    public static interface CC {
        String ff();
    }

    public static class FW implements CC {

        @Override
        public String ff() {
            System.out.println("调用fw.ff");
            return "fw";
        }
    }

    public static class FG implements CC {

        @Override
        public String ff() {
            System.out.println("调用fg.ff");
            return "fg";
        }
    }


    public static void main(String[] args) {

        List<CC> list = Lists.newArrayList(new FG(), new FW());
        final Flux<CC> stringFlux = Flux.fromIterable(list);

        final Flux<String> objectFlux = stringFlux.flatMapSequential(x -> Mono.just(x.ff()));

        final Mono<String> map = objectFlux.concatMap(x -> {
                    return Mono.just(x).filterWhen(r -> {
                        System.out.println("r:" + r);
                        return Mono.just(r.equals("fg"));
                    });
                }).next()
                .map(g -> g);

        final Flux<String> repeat = map.repeat(0);

        repeat.subscribe(System.out::println);

//        for (int i = 0; i < 10; i++) {
//            int finalI = i;
//            //每次都会进入onCacheMissResume
//            final Mono<String> map = routes
//                    .concatMap(x -> Mono.just(x).filterWhen(r -> Mono.just(r.equals(finalI + "" + finalI)))
//                            .doOnError(e -> log.error("ff"))
//                            .onErrorResume(e -> Mono.empty()))
//                    .next()
//                    .map(route -> route);
//            map.subscribe(System.out::println);
//        }

    }
}