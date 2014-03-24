/**
 * 
 */
package pk.com.mypetworld.server.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

/**
 * @author Ali
 *
 */
@PreMatching
public class RequestCorsFilter implements ContainerRequestFilter {

	 private final static Logger log = Logger.getLogger( RequestCorsFilter.class.getName() );
	 
	 	 
	   @Override
	 
	   public void filter( ContainerRequestContext requestCtx ) throws IOException {
		   log.debug("Request filter entered...");
	 
	 	 
	         // When HttpMethod comes as OPTIONS, just acknowledge that it accepts...
	 
	       if ( requestCtx.getRequest().getMethod().equals( "OPTIONS" ) ) {
	 
	           log.info( "HTTP Method (OPTIONS) - Detected!" );
	 
	  
	 
	            // Just send a OK signal back to the browser
	 
	            requestCtx.abortWith( Response.status( Response.Status.OK ).build() );
	 
	         }
	       
	       log.debug("Request filter entered...");
	     }
	
}
