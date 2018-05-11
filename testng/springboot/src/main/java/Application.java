import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
/*
 * springboot自动配置了支持mongodb。在启动springboot时会自动实例化一个mongo实例。 
 *	现在要禁用自动配置 
 *	@SpringBootApplication(exclude = MongoAutoConfiguration.class)
 */
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@ComponentScan("org.springboot")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class,args);
	}
}

