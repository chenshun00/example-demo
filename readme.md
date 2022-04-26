## demo project for SpringCloud

### install DB
* install docker
* docker pull chenshun00/mysqlutf8:0.0.1
  * more information @see mysql:5.7
* start docker

### spring-datasource-boot-starter
* find starter from [datasource-starter](!https://github.com/chenshun00/datasource-starter)

```shell
cd path
git clone https://github.com/chenshun00/datasource-starter.git
cd datasource-starter && mvn install
```

### install consul
* install
* start
  * consul agent -dev -bind 192.168.1.103 -server -bootstrap -data-dir /Users/chenshun/springcloud/consul

### reference
* https://www.cnblogs.com/wuzhenzhao/p/12835997.html
* https://segmentfault.com/a/1190000019284355
* https://spring-cloud-alibaba-group.github.io/github-pages/hoxton/zh-cn/index.html#_consumer_%E5%BA%94%E7%94%A8