/**
 * 
 */
package pk.com.mypetworld.server.users.model;

/**
 * Enum defines different of user accounts. 
 * @author Ali
 *
 */
public enum UserAccountState {

	/**
	 * When user registers and has not confirmed email address.
	 */
	INACTIVE,
	
	/**
	 * When user has confirmed registration and is an active user
	 */
	ACTIVE,
	
	/**
	 * When user was reported by other user, or for any other reason the account\
	 * was manually/automatically locked by system.
	 */
	LOCKED;

}
