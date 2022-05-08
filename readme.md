## demo project for SpringCloud

please install `docker` before start this.

### install DB
* docker pull chenshun00/mysqlutf8:0.0.1
  * more information @see mysql:5.7
* start docker
* execute below script

```mysql
create database test;

CREATE TABLE `book` (
                      `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
                      `author` varchar(16) NOT NULL DEFAULT '''''' COMMENT '作者',
                      `publish_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                      `name` varchar(12) NOT NULL DEFAULT '',
                      PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

INSERT INTO `book` (`id`, `author`, `publish_date`, `name`)
VALUES
  (1, 'cc', '2022-04-27 03:37:26', 'first book'),
  (2, 'cc', '2022-04-27 03:37:29', 'second book');
```

### install nacos
* docker pull nacos/nacos-server:1.4.2
* docker run --name nacos-quick -e MODE=standalone -p 8848:8848 -d nacos/nacos-server:1.4.2
  * more information @see [nacos/nacos-server](https://hub.docker.com/r/nacos/nacos-server)

### spring-datasource-boot-starter
* find starter from [datasource-starter](https://github.com/chenshun00/datasource-starter)

```shell
cd path
git clone https://github.com/chenshun00/datasource-starter.git
cd datasource-starter && mvn install
```



### operation
```shell
# browser->nacos-provider->db
curl 'http://127.0.0.1:8082/book?author=cc'
# browser->nacos-consumer(feign)-> nacos-provider->db
curl 'http://127.0.0.1:9082/feign'
```

### some problem for newbe
* feign convert GET to POST, result in `HTTP method not support POST` error
  * https://blog.csdn.net/qq_34129814/article/details/107935091
* feign lose parameter
  * https://blog.csdn.net/qq_17238449/article/details/109648994
* how to handle feign's exception 

### some question
* how to config feign's parameter, like http connection pool, pool size. sync or async, cache how to config or no cache.
* how to do service governance, monitor? metrics? logging?
* how to simplify development. what component is need 100%.
* etc.

### document
* [feign](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/#spring-matrixvariable-support)

### why switch consul to naocs
* because of company technology stack , I had to switch registries from consul to nacos.

### reference
* https://www.cnblogs.com/wuzhenzhao/p/12835997.html
* https://segmentfault.com/a/1190000019284355
* https://spring-cloud-alibaba-group.github.io/github-pages/hoxton/zh-cn/index.html#_consumer_%E5%BA%94%E7%94%A8
* https://www.skypyb.com/2021/06/jishu/1836/
* https://spring-cloud-alibaba-group.github.io/github-pages/hoxton/zh-cn/index.html#_%E4%BB%8B%E7%BB%8D
* [can't find nacos-provder,see here how to fix problem](https://github.com/alibaba/nacos/issues/2568)