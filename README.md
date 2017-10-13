# Spring-Rest-Exception-Handling-Documentation
In this example we will get clear cut idea how to handle Exception in Spring Rest API and how to generate documentation for it using JSONDocs


                            
Declare the dependency to spring-boot-starter-jsondoc:
<dependency>
        <groupId>org.jsondoc</groupId>
        <artifactId>spring-boot-starter-jsondoc</artifactId>
        <version>1.2.17</version>
</dependency>

Configure JSONDoc in application.properties file
# mandatory configuration
jsondoc.version=1.0
jsondoc.basePath=http://localhost:8080
jsondoc.packages[0]= com.spring.boot.data.jpa.api.controller
jsondoc.packages[1]= com.spring.boot.data.jpa.api.model
# optional configuration
jsondoc.playgroundEnabled=true
jsondoc.displayMethodAs=URI


Enable JSONDoc on you configuration class

@SpringBootApplication
@EnableJSONDoc
public class MyWebapp {
	public static void main(String[] args) {
		SpringApplication.run(MyWebapp.class, args);
	}
}

At this point it is possible to start up the application and go to http://localhost:8080/jsondoc to see the documentation (provided that you wrote the documentation on your services and objects), ready to be used with jsondoc-ui or with your custom documentation viewer.


Optional (but recomended): use jsondoc-ui-webjar to see the documentation
Declare the dependency to the jsondoc-ui-webjar project:

<dependency>
        <groupId>org.jsondoc</groupId>
        <artifactId>jsondoc-ui-webjar</artifactId>
        <version>1.2.17</version>
</dependency>

And now you can go to http://localhost:8080/jsondoc-ui.html, insert http://localhost:8080/jsondoc in the box and get the documentation.
In case you are using @EnableWebMvc annotation, then you need to also register resource handlers for static ui resources, in particular:

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
        
        @Override
        protected void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("**/*.css", "**/*.js", "**/*.map", "*.html").addResourceLocations("classpath:META-INF/resources/").setCachePeriod(0);
        }

}


