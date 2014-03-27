package pk.com.mypetworld.server.users.model;

import java.util.Date;

/**
 * Basic user entity that defines a system user. All fields should only be relevant to identify 
 * user of the system.
 * @author Ali
 *
 */
public class User {
	
	String id;
	String userId;
	String emailAddress;
	String firstName;
	String lastName;
	String password;
	Date registrationDate;
	boolean active;
	
	
	int age;
	String sex;
	String country;
	
	
	
	
	
	public User(String userId, String emailAddress)
	{
		this.setUserId(userId);
		
		this.setEmailAddress(emailAddress);
		
	}
	
	public User()
	{
		
	}
	
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.users.model.IUser#getUserId()
	 */
	public String getUserId() {
		return userId;
	}
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.users.model.IUser#setUserId(java.lang.String)
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.users.model.IUser#getEmailAddress()
	 */
	
	public String getEmailAddress() {
		return emailAddress;
	}
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.users.model.IUser#setEmailAddress(java.lang.String)
	 */
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.users.model.IUser#getRegistrationDate()
	 */
	
	public Date getRegistrationDate() {
		return registrationDate;
	}
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.users.model.IUser#setRegistrationDate(java.util.Date)
	 */
	
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.users.model.IUser#getAccountState()
	 */
	
	public boolean isActive() {
		return active;
	}
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.users.model.IUser#setAccountState(pk.com.mypetworld.server.users.model.UserAccountState)
	 */
	
	public void setActive(boolean active) {
		this.active = active;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}	
}
