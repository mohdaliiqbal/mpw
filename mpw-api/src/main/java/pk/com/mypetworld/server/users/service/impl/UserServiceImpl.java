/**
 * 
 */
package pk.com.mypetworld.server.users.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pk.com.mypetworld.server.users.dao.UserRepository;
import pk.com.mypetworld.server.users.exception.UserServiceException;
import pk.com.mypetworld.server.users.model.User;
import pk.com.mypetworld.server.users.service.api.UserService;


/**
 * @author Ali
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired UserRepository userRepository;
	

	@Override
	public Iterable<User> getUsers() {
		
		Iterable<User> users =  userRepository.findAll();
		
		return (Iterable<User>) users;
				
	}


	@Override
	public boolean registerUser(User user) {

		List<User> userList	= userRepository.findByUserId(user.getUserId());
		
	
		if( userList != null && userList.size()>0)
			throw new UserServiceException("User id already exist in the system. Please use another user id.");
		
		userList	= userRepository.findByUserId(user.getUserId());
		if( userList != null && userList.size()>0 )
				throw new UserServiceException("Email id already exist in the system. Please use another email address.");
		
		//save the user in the system.
		userRepository.save(user);		
		
		return true;
	}


	@Override
	public User getUser(String userId) {
		
		List<User> userList = userRepository.findByUserId(userId);
		if( userList != null && userList.size() > 0)
			return userList.get(0);
		
		return null;
	}


	
	
	
	

}
