/**
 * 
 */
package ae.com.ali.poc.jjs.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ae.com.ali.poc.jjs.service.api.GreetingService;

/**
 * @author Ali
 *
 */
@Path("/greeting")
@Component
@Scope("request")
public class GreetingResource {

    @Autowired
    private GreetingService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return service.sayHello();
    }
}
