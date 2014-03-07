/**
 * 
 */
package pk.com.mypetworld.server.users.service.impl;

import org.springframework.stereotype.Service;

import pk.com.mypetworld.server.users.model.IUser;
import pk.com.mypetworld.server.users.model.User;
import pk.com.mypetworld.server.users.service.api.UserService;


/**
 * @author Ali
 *
 */
@Service
public class UserServiceImpl implements UserService {


	@Override
	public IUser getUsers() {
		// TODO Auto-generated method stub
		return new User("joe","joe@barton.champo");
	}

}
