package pk.com.mypetworld.server.rest.app;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import pk.com.mypetworld.server.users.resource.UsersResource;

public class MpwAPIv01 extends ResourceConfig {

    /**
	* Register JAX-RS application components.
	*/	
	public MpwAPIv01(){
		register(RequestContextFilter.class);
		register(UsersResource.class);
		register(JacksonFeature.class);		
	}
}