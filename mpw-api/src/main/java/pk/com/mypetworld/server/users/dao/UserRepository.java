/**
 * 
 */
package pk.com.mypetworld.server.users.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import pk.com.mypetworld.server.users.model.User;
import java.lang.String;
import java.util.List;

/**
 * @author Ali
 *
 */
public interface UserRepository extends PagingAndSortingRepository<User, String> {

	public List<User> findByUserId(String userid); 
	
	public List<User> findByEmailAddress(String emailaddress); 
}
