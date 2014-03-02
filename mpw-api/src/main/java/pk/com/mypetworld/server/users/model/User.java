package pk.com.mypetworld.server.users.model;

import java.util.Date;

/**
 * Basic user entity that defines a system user. All fields should only be relevant to identify 
 * user of the system.
 * @author Ali
 *
 */
public class User implements IUser {

	String userId;
	String emailAddress;
	String password;
	Date registrationDate;
	UserAccountState accountState;
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.users.model.IUser#getUserId()
	 */
	@Override
	public String getUserId() {
		return userId;
	}
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.users.model.IUser#setUserId(java.lang.String)
	 */
	@Override
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.users.model.IUser#getEmailAddress()
	 */
	@Override
	public String getEmailAddress() {
		return emailAddress;
	}
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.users.model.IUser#setEmailAddress(java.lang.String)
	 */
	@Override
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.users.model.IUser#getPassword()
	 */
	@Override
	public String getPassword() {
		return password;
	}
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.users.model.IUser#setPassword(java.lang.String)
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.users.model.IUser#getRegistrationDate()
	 */
	@Override
	public Date getRegistrationDate() {
		return registrationDate;
	}
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.users.model.IUser#setRegistrationDate(java.util.Date)
	 */
	@Override
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.users.model.IUser#getAccountState()
	 */
	@Override
	public UserAccountState getAccountState() {
		return accountState;
	}
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.users.model.IUser#setAccountState(pk.com.mypetworld.server.users.model.UserAccountState)
	 */
	@Override
	public void setAccountState(UserAccountState accountState) {
		this.accountState = accountState;
	}
	
	
}
