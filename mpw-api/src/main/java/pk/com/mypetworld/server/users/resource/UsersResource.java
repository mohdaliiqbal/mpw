/**
 * 
 */
package pk.com.mypetworld.server.users.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import pk.com.mypetworld.server.security.TokenUtils;
import pk.com.mypetworld.server.security.transfer.TokenTransfer;
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
	private UserDetailsService userService;
	
	
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authManager;
	
	
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
   /**
    @POST
	@Produces(MediaType.APPLICATION_JSON)
    @Path("/authenticate")
    @Consumes(MediaType.APPLICATION_JSON)
    public User authenticateUser(String  jsonBodyStr) {
    	
    	JSONObject jsonBody = 	new JSONObject(jsonBodyStr);
    	log.debug("Authenitcate user email and password.."+jsonBody.getString("email"));
    	
        return service.getUserByEmailAndPassword(jsonBody.getString("email"), jsonBody.getString("password"));
    }
    */
    

	/**
	 * Authenticates a user and creates an authentication token.
	 * 
	 * @param email
	 *            The name of the user.
	 * @param password
	 *            The password of the user.
	 * @return A transfer containing the authentication token.
	 */
	@Path("authenticate")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public TokenTransfer authenticate(@FormParam("email") String email, @FormParam("password") String password) {

		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(email, password);
		Authentication authentication = this.authManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		/*
		 * Reload user as password of authentication principal will be null after authorization and
		 * password is needed for token generation
		 */
		UserDetails userDetails = this.userService.loadUserByUsername(email);

		return new TokenTransfer(TokenUtils.createToken(userDetails));
	}
    
    
    @POST    
   	@Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean createUser(User user) throws WebApplicationException {
    	
    	log.debug("register user.."+user);
    	
    	
        return service.createUser(user);
    }
}
