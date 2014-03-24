package pk.com.mypetworld.server.rest.app;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import pk.com.mypetworld.server.filters.RequestCorsFilter;
import pk.com.mypetworld.server.filters.ResponseCorsFilter;
import pk.com.mypetworld.server.users.resource.UsersResource;

public class MpwAPIv01 extends ResourceConfig {

    /**
	* Register JAX-RS application components.
	*/	
	public MpwAPIv01(){
		//register(RequestContextFilter.class);
		register(RequestCorsFilter.class);
		register(ResponseCorsFilter.class);
		register(UsersResource.class);
		register(JacksonFeature.class);		
	}
}	