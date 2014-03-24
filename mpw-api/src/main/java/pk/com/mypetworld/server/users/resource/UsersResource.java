/**
 * 
 */
package pk.com.mypetworld.server.users.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pk.com.mypetworld.server.users.model.User;
import pk.com.mypetworld.server.users.service.api.UserService;


/**
 * @author Ali
 *
 */
@Path("/users")
@Component
@Scope("request")
public class UsersResource {

	private final static Logger log = Logger.getLogger( UsersResource.class.getName() );
	
	
    @Autowired
    private UserService service;
    
    @Context
    UriInfo  ui;

    @GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public Iterable<User> getAllUsers() {
    	
    	log.debug("Get all users service called..");
    	return service.getUsers();
    }
    
    
    @GET
	@Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public User getUserById(@PathParam("id") String userId) {
    	log.debug("Get user by id service called.."+userId );
        return service.getUser(userId);
    }
    
    @POST
	@Produces(MediaType.APPLICATION_JSON)
    @Path("/authenticate")
    @Consumes(MediaType.APPLICATION_JSON)
    public User authenticateUser(String  jsonBodyStr) {
    	
    	JSONObject jsonBody = 	new JSONObject(jsonBodyStr);
    	log.debug("Authenitcate user email and password.."+jsonBody.getString("email"));
    	
        return service.getUserByEmailAndPassword(jsonBody.getString("email"), jsonBody.getString("password"));
    }
    
    
    @POST    
   	@Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean registerUser(User user) throws WebApplicationException {
    	
    	log.debug("register user.."+user);
    	
    	
        return service.registerUser(user);
    }
}
