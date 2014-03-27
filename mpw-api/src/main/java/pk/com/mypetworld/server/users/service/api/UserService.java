/**
 * 
 */
package pk.com.mypetworld.server.users.service.api;

import org.springframework.security.core.userdetails.UserDetails;

import pk.com.mypetworld.server.users.model.User;


/**
 * @author Ali
 *
 */
public interface UserService {

	 
	public Iterable<User> getUsers();
	
	
	public boolean createUser(User user);
	
	
	public User getUser(String userId);
	
	
	public User getUserByEmailAndPassword(String email, String password);


	public User getByEmailAddress(String username);
		
}
