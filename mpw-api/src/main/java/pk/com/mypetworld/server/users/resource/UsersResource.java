/**
 * 
 */
package pk.com.mypetworld.server.users.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pk.com.mypetworld.server.users.model.IUser;
import pk.com.mypetworld.server.users.service.api.UserService;


/**
 * @author Ali
 *
 */
@Path("/users")
@Component
@Scope("request")
public class UsersResource {

    @Autowired
    private UserService service;
    
    @Context
    UriInfo  ui;

    @GET
	@Produces(MediaType.APPLICATION_JSON)
    public IUser getAllUsers() {
        return service.getUsers();
    }
}
