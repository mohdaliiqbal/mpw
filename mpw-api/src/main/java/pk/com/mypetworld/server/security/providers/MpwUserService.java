/**
 * 
 */
package pk.com.mypetworld.server.security.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pk.com.mypetworld.server.users.dao.UserRepository;
import pk.com.mypetworld.server.users.model.User;

/**
 * @author Ali
 *
 */
public class MpwUserService implements UserDetailsService {


	Logger logger = Logger.getLogger(MpwUserService.class);
	
	@Autowired UserRepository userRepository;
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
	
		logger.debug("ENTER");
		
		List<User> userList = userRepository.findByEmailAddress(username);
		
		if(userList != null && userList.size()>0)
		{
			logger.debug("User found by "+username);
			
			return new MpwUsersDetails(userList.get(0));
		}
		else {
			throw new UsernameNotFoundException("Email id or password do not match");
		}
		
		
		//return null;
	}

	/**
	 * This class is designed separately from user model class. This will allow us to move the user/password to a different encrypted space (table/file)
	 * without affecting the original model.
	 * @author Ali
	 *
	 */
	class MpwUsersDetails implements UserDetails {

		/**
		 * Unique id for the serialization.
		 */
		private static final long serialVersionUID = 1L;
		
		//the user model embedded into user details.
		User user = null;
		
		public MpwUsersDetails(User user) {
			this.user = user;
		}
		
		@Override
		public boolean isEnabled() {
			
			return user.isActive();
		}
		
		@Override
		public boolean isCredentialsNonExpired() {

			return user.isActive();
		}
		
		@Override
		public boolean isAccountNonLocked() {

			return user.isActive();
		}
		
		@Override
		public boolean isAccountNonExpired() {

			return user.isActive();
		}
		
		@Override
		public String getUsername() {

			return user.getEmailAddress();
		}
		
		@Override
		public String getPassword() {
			
			return user.getPassword();
		}
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			
			//currently only mpwuser is the role we are granting. Later this method could query the user repository and get more details.
			List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
	        grantedAuths.add(new SimpleGrantedAuthority("mpwuser"));
			return grantedAuths;
		}
	}

}
