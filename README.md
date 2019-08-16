本demo从实践的角度出发，实现一个spring-boot的starter依赖包，为理解spring-boot的starter原理做好准备。

应用场景：
假如有一个开源库，为了顺应时代潮流，想方便使用spring-boot的开发者使用，就需要实现一个方便的依赖，让spring-boot自动加载，让用户以spring-boot的方式使用
这个库。这个依赖就是starter依赖。

例如：我们经常使用的中间件：redis、kafka、mybatis等，都有了官方的starter包。

现在，我们使用一个简单的网络工具为例，说明在自定义starter的过程中会遇到的情况和方法。

1. 使用EnableAutoConfiguration实现自动配置注入：spring.factories
2. 增加IDE配置提示

完整内容请移至[博客](https://jimolonely.github.io/2019/08/16/java/057-spring-boot-starter-demo)

