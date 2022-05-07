### question

* if we use ribbon in gateway , one service will have one spring context. but if not gateway , just a normal app, ribbon will build one spring context for every ribbon client?, document describe like below
  * On demand, Spring Cloud creates a new ensemble as an ApplicationContext for each named client by using `RibbonClientConfiguration`.
### reference
[spring cloud ribbon document](!https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-ribbon.html)