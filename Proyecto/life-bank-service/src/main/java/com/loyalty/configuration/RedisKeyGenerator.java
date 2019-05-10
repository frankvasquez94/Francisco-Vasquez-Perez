package com.loyalty.configuration; 
 
import java.lang.reflect.Method; 
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.cache.interceptor.KeyGenerator; 
import org.springframework.core.env.Environment; 
import org.springframework.stereotype.Component;

@Component("keyGenBean") 
public class RedisKeyGenerator implements KeyGenerator {
	private String env; 
	 
	@Autowired 
	public RedisKeyGenerator(Environment env){ 
		this.env = env.getProperty("spring.profiles.active");
	} 
	 
	public Object generate(Object target, Method method, Object... params) { 
	      StringBuilder sb = new StringBuilder(env);  
	      if (params != null) { 
	          for (Object param : params) { 
	              sb.append("-") 
	                .append(param); 
	          } 
	      } 
	      return sb.toString(); 
	  } 

}
