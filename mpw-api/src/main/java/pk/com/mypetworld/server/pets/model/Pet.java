package pk.com.mypetworld.server.pets.model;

import java.util.Calendar;
import java.util.Date;

import pk.com.mypetworld.server.common.UtilityMethods;

/**
 * Basic pet entity that defines a system pet. All fields should only be relevant to identify 
 * pet of the system.
 * @author Ali
 *
 */
public class Pet {
	
	String id;
	String petId;
	String emailAddress;
	String firstName;
	String lastName;
	String password;
	Date registrationDate;
	Date birthdate;
	boolean active = true;
	
	
	int age;
	String gender;
	String country;
	
	
	
	
	
	public Pet(String petId, String emailAddress)
	{
		this.setPetId(petId);
		
		this.setEmailAddress(emailAddress);
		
	}
	
	public Pet()
	{
		
	}
	
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.pets.model.IPet#getPetId()
	 */
	public String getPetId() {
		return petId;
	}
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.pets.model.IPet#setPetId(java.lang.String)
	 */
	public void setPetId(String petId) {
		this.petId = petId;
	}
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.pets.model.IPet#getEmailAddress()
	 */
	
	public String getEmailAddress() {
		return emailAddress;
	}
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.pets.model.IPet#setEmailAddress(java.lang.String)
	 */
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.pets.model.IPet#getRegistrationDate()
	 */
	
	public Date getRegistrationDate() {
		return registrationDate;
	}
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.pets.model.IPet#setRegistrationDate(java.util.Date)
	 */
	
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.pets.model.IPet#getAccountState()
	 */
	
	public boolean isActive() {
		//every account is true right now
		return true;
	}
	/* (non-Javadoc)
	 * @see pk.com.mypetworld.server.pets.model.IPet#setAccountState(pk.com.mypetworld.server.pets.model.PetAccountState)
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
		
		UtilityMethods.getDiffYears(birthdate, Calendar.getInstance().getTime());
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
}
