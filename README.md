# feature-email
未来邮箱，寄现在的信，给未来的你
## 运行项目须知
> 首先项目基于redis集群、mysql，还集成了**_`<b>spring-boot-starter-security、jasypt-spring-boot-starter</b>`_**
>，可以看到用户名密码之类的数据都已进行加密，因此在使用之前需要自己加密用户名和密码

> 项目集成于redis集群，因此需要先搭一个redis集群，详见微信公众号:**_`feature社区`_**->
>docker搭建高可用redis集群或者加入QQ群:**_`875927261`_**->文件:**_`《基于Redis3.0(3.2.1)搭建redis集群(kepler.luo)》`_**

##### *_必要条件_*
* **_`redis`_** 集群(或者不用redis),因为集成了 **_`spring-session`_**,因此启动即需要连接redis
* **_`mysql`_** 数据库