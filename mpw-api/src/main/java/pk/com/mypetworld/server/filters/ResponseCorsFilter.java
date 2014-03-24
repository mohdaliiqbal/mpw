/**
 * 
 */
package pk.com.mypetworld.server.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;




/**
 * @author Ali
 *
 */
@Provider
@PreMatching
public class ResponseCorsFilter implements ContainerResponseFilter{

	private final static Logger log = Logger.getLogger( ResponseCorsFilter.class.getName() );
		
	 
    @Override
    public void filter(ContainerRequestContext requestContext,
            ContainerResponseContext responseContext) throws IOException {
    	
    	
    	log.debug("Response filter entered...");
           responseContext.getHeaders()
                .putSingle("Access-Control-Allow-Origin","*");
           responseContext.getHeaders()
                 .putSingle("Access-Control-Allow-Methods",
                     "GET, POST, PUT, DELETE");
           List<String> reqHead=requestContext.getHeaders()
                     .get("Access-Control-Request-Headers");
           if(null != reqHead){
                responseContext.getHeaders()
                   .put("Access-Control-Allow-Headers", 
                        new ArrayList<Object>(reqHead));
           }
           
        log.debug("Response filter exit...");
    }
}