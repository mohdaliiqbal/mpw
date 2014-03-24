/**
 * 
 */
package pk.com.mypetworld.server.users.service.api;

import pk.com.mypetworld.server.users.model.User;


/**
 * @author Ali
 *
 */
public interface UserService {

	 
	public Iterable<User> getUsers();
	
	
	public boolean registerUser(User user);
	
	
	public User getUser(String userId);
	
	
	public User getUserByEmailAndPassword(String email, String password);
	
}
