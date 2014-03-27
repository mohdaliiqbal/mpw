/**
 * 
 */
package pk.com.mypetworld.server.users.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
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
	
	Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

	@Override
	public Iterable<User> getUsers() {
		
		Iterable<User> users =  userRepository.findAll();
		
		return (Iterable<User>) users;
				
	}


	@Override
	public boolean createUser(User user) {

		List<User> userList	= userRepository.findByUserId(user.getUserId());
		
	
		if( userList != null && userList.size()>0)
			throw new UserServiceException("User id already exist in the system. Please use another user id.");
		
		userList	= userRepository.findByEmailAddress(user.getEmailAddress());
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


	
	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		List<User> users = userRepository.findByEmailAddress(email);
		
		if( users != null && users.size() > 0)
		{
			logger.debug("Gets the user by email:"+email);
			
			return users.get(0);		
		}
		else {
			return null;
		}	
	}


	@Override
	public User getByEmailAddress(String emailaddress) {
		List<User> users = userRepository.findByEmailAddress(emailaddress);
		if( users != null && users.size()>0)
			return users.get(0);
		else 
			return null;
		
	}	

}
