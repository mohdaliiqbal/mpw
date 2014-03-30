/**
 * 
 */
package pk.com.mypetworld.server.security.providers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Ali
 *
 */
public class MpwDbAuthenticationProvider implements AuthenticationProvider {

	Logger logger = Logger.getLogger(MpwDbAuthenticationProvider.class);
	
	@Autowired
	UserDetailsService usersDetailsService;
	
	/* (non-Javadoc)
	 * @see org.springframework.security.authentication.AuthenticationProvider#authenticate(org.springframework.security.core.Authentication)
	 */
	 @Override
	    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		 
		 	logger.debug("ENTER");
	        String name = authentication.getName();
	        String password = authentication.getCredentials().toString();
	        
	        UserDetails userDetails =  usersDetailsService.loadUserByUsername(name);
	        if( userDetails != null && userDetails.getPassword().equals(password))
	        {   
	            Authentication auth = new UsernamePasswordAuthenticationToken(name, password, userDetails.getAuthorities());
	            logger.debug("authentication successful "+name);
	            return auth;
	        } else {
	        	
	        	logger.debug("authentication failed."+name);
	            return null;
	        }
	        
	        
	 }

	/* (non-Javadoc)
	 * @see org.springframework.security.authentication.AuthenticationProvider#supports(java.lang.Class)
	 */
	 @Override
	    public boolean supports(Class<?> authentication) {
	        return authentication.equals(UsernamePasswordAuthenticationToken.class);
	    }

	public UserDetailsService getUsersDetailsService() {
		return usersDetailsService;
	}

	public void setUsersDetailsService(UserDetailsService usersDetailsService) {
		this.usersDetailsService = usersDetailsService;
	}

}
