/**
 * 
 */
package pk.com.mypetworld.server.dao.app;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;

import com.mongodb.Mongo;

/**
 * @author Ali
 *
 */
public class AppConfig {
	
	/*
	 * Use the standard Mongo driver API to create a com.mongodb.Mongo instance.
	 */
	public @Bean Mongo mongo() throws UnknownHostException {
	      return new Mongo("localhost");
	}
}
