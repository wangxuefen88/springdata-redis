# springdata-redis
使用springboot连接到redis
前提
需要springboot框架
lombook
swagger2
redis
如果你想直接使用springboot的项目可以直接在官网上下载,都有哦,都看官网没差了
http://start.spring.io/


注解详解
springmvc中的@RestController,spring4的时候出来的

 使用它可以快速的构建一个Restful web Service从,并且返回的是xml或者是json的数据,可是比以前还用多了啊,以前还得使用@ResponseBody转换为json

你可能会想:为什么会这样啊?看看源码都使用了什么注解,看了之后就知道为什么他不用写responseBody原因是因为他自己本身就包含了

 @Target(*)
@Retention()
@Controller   //修饰class,用来修改创建的处理http请求的对象
@ResponseBody

springMvc中的@Requestmapping("/rest/user")
这个表示得的就是地址映射url,有类的也有方法(这个不用多说吧)

@Autowired
依赖注入,spring的依赖注入,其实就是spring替你

@PathVariable 
表示绑定到参数中,一般都是用在get请求中

@RequestParam
表示接受post中的请求的参数

@Value
springboot使用@Value来获取配置config中的数据
@Value("${Xxxx}") 加载xxx中对应属性的值,加载的是application.properties


@Bean
告诉spring容器你可以从下面这个方法中拿到bean

@Configuration(让spring加载该类资源)
告诉spring,spring容器应该怎么配置,怎么去注册bean,配置bean之间的关系,所以@Bean获取bean的时候会按照你配置的方式去得到bean

@EnableSwagger2
表示启用swagger2

@SpringBootApplication
表示启动springboot

下面是lonbook的注解
@Slf4j 使用log4j
@ Data 实现get和set
@ AllArgsConstructor 构造函数


配置文件


在application.properties中配置redis的地址
redis.host=192.168.XXX.XX
redis.port=6379


配置swagger
首先在pom文件下引入swagger
<dependency>
   <groupId>io.springfox</groupId>
   <artifactId>springfox-swagger2</artifactId>
   <version>2.9.2</version>
</dependency>
<dependency>
   <groupId>io.springfox</groupId>
   <artifactId>springfox-swagger-ui</artifactId>
   <version>2.6.1</version>
</dependency>

讲解swagger2

创建一个Docket createRestApi.用于指定扫描哪一个包
.apis(RequestHandlerSelectors.basePackage("com.example"))
.paths(PathSelectors.any())

创建一个private ApiInfo apiInfo() 用于描述swagger信息


spring-data
1首先通过@Value获取我们配置中的reids地址和端口号
2连接reids 使用JedisConnectionFactory
3使用RedisTemplate他是key value形式的,RedisTemplate<key ,value>,需要说明的是spring并不支持我们直接序列化所以需要我们自己实现序列化 RedisSerializer<T>,可以进行序列化和反序列化
4最后连接reids进行操作

RedisTemplate<String,User> template=new RedisTemplate<>();
template.setKeySerializer(new StringRedisSerializer());
template.setHashKeySerializer(new StringRedisSerializer());
template.setHashValueSerializer(new StringRedisSerializer());
template.setConnectionFactory(jedisConnectionFactory());
return template;

在我们存数据的时候使用的是HashOperation对象,由于我们前面使用的是Hash
HashOperation有3个参数,HashOperation<H,HK,Hv>
他可以实现基本上的增删改查,其实就是hash,哈哈哈,一样的
第一个是由来区分这个可以是存在于那个hashmap中的
