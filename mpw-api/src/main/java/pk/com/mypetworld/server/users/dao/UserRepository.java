/**
 * 
 */
package pk.com.mypetworld.server.users.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import pk.com.mypetworld.server.users.model.User;

/**
 * @author Ali
 *
 */
public interface UserRepository extends PagingAndSortingRepository<User, String> {

	public List<User> findByUserId(String userid); 
	
	public List<User> findByEmailAddress(String emailaddress); 
	
	public List<User> findByEmailAddressAndPassword(String emailAddress, String password);
}
