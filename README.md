# Spring Cloud 组件练手

# 启动顺序

* eureka -> producer -> consumer -> config server -> zuul -> zipkin

* 启动方式： 直接运行对应模块main方法

# 访问地址
 * Eureka注册服务中心 http://localhost:8780/
 
 * Feign负载均衡客户端(Zipkin) http://localhost:8784/hi?name=xx
 
 * Ribbon负载均衡客户端 http://localhost:8783/hi?name=xx
    * Hystrix仪表盘 http://localhost:8783/hystrix/
 
 * Zuul路由网关(Bus自动配置)：
    * http://localhost:8785/api-a/hi?name=xx
    * http://localhost:8785/api-b/hi?name=xx
    
 * 配置服务器： http://localhost:8888/
    * 查看配置： http://localhost:8888/token/dev
 
 * Zipkin服务器： http://localhost:9411
 
# 注意事项

* Spring Cloud Bus 需要安装Rabbitmq。
 
 
# 架构图
    * 不会画。。¯\_(ツ)_/¯