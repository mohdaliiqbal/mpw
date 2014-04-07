/**
 * 
 */
package pk.com.mypetworld.server.pets.resource;

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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import pk.com.mypetworld.server.common.ErrorResponse;
import pk.com.mypetworld.server.security.TokenUtils;
import pk.com.mypetworld.server.security.transfer.TokenTransfer;
import pk.com.mypetworld.server.pets.exception.PetServiceException;
import pk.com.mypetworld.server.pets.model.Pet;
import pk.com.mypetworld.server.pets.service.api.PetService;


/**
 * @author Ali
 *
 */
@Path("/pets")
@Component
@Scope("request")
public class PetsResource {

	private final static Logger log = Logger.getLogger( PetsResource.class.getName() );
	

	@Autowired
	private UserDetailsService petsDetailsService;
	
	
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authManager;
	
	
    @Autowired
    private PetService service;
    
    @Context
    UriInfo  ui;

    @GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public Iterable<Pet> getAllPets() {
    	
    	log.debug("Get all pets service called..");
    	return service.getPets();
    }
    
    
    @GET
	@Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Pet getPetById(@PathParam("id") String petId) {
    	log.debug("Get pet by id service called.."+petId );
        return service.getPet(petId);
    }
   /**
    @POST
	@Produces(MediaType.APPLICATION_JSON)
    @Path("/authenticate")
    @Consumes(MediaType.APPLICATION_JSON)
    public Pet authenticatePet(String  jsonBodyStr) {
    	
    	JSONObject jsonBody = 	new JSONObject(jsonBodyStr);
    	log.debug("Authenitcate pet email and password.."+jsonBody.getString("email"));
    	
        return service.getPetByEmailAndPassword(jsonBody.getString("email"), jsonBody.getString("password"));
    }
    */
    

	/**
	 * Authenticates a pet and creates an authentication token.
	 * 
	 * @param email
	 *            The name of the pet.
	 * @param password
	 *            The password of the pet.
	 * @return A transfer containing the authentication token.
	 */
	@Path("authenticate")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public TokenTransfer authenticate(@FormParam("email") String email, @FormParam("password") String password) {

		try {
		
		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(email, password);
		Authentication authentication = this.authManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		/*
		 * Reload pet as password of authentication principal will be null after authorization and
		 * password is needed for token generation
		 */
		UserDetails petDetails = this.petsDetailsService.loadUserByUsername(email);
		Pet pet = this.service.getByEmailAddress(email);
		

		return new TokenTransfer(TokenUtils.createToken(petDetails), pet.getPetId());
		
		
		} catch (BadCredentialsException exception) {
			
			ErrorResponse response = new ErrorResponse();
			response.setError(Status.FORBIDDEN.getStatusCode());
			response.setMessage("Email address and password do not match.");
			
			//create a response wrapping the error response entity
			throw new WebApplicationException(Response.status(Status.FORBIDDEN).entity(response).build());
		}
	}
    
    
    @POST    
   	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean createPet(Pet pet) throws WebApplicationException {

    	try {
			
    	log.debug("register pet.."+pet);
    	
    	
        return service.createPet(pet);
        

		} catch (PetServiceException e) {

			ErrorResponse response = new ErrorResponse();
			response.setError(403);
			response.setMessage(e.getMessage());
			
			throw new WebApplicationException(Response.status(403).entity(response).build());
		}
    }
}
