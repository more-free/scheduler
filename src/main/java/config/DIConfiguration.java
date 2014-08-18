package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import rest.*;

// this is equivalent to a spring.xml 
@Configuration
@ComponentScan(value={"rest"})
public class DIConfiguration {
 
  //  @Bean
  //  public SomeService getSomeService(){
  //      return new SomeService();
  //  }
}
