package pk.com.mypetworld.server.users.model;

import java.util.Date;

public interface IUser {

	/**
	 * @return the userId
	 */
	public abstract String getUserId();

	/**
	 * @param userId the userId to set
	 */
	public abstract void setUserId(String userId);

	/**
	 * @return the emailAddress
	 */
	public abstract String getEmailAddress();

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public abstract void setEmailAddress(String emailAddress);


	/**
	 * @return the registrationDate
	 */
	public abstract Date getRegistrationDate();

	/**
	 * @param registrationDate the registrationDate to set
	 */
	public abstract void setRegistrationDate(Date registrationDate);

	/**
	 * @return the accountState
	 */
	public abstract UserAccountState getAccountState();

	/**
	 * @param accountState the accountState to set
	 */
	public abstract void setAccountState(UserAccountState accountState);

}