/**
 * 
 */
package pk.com.mypetworld.server.pets.service.api;

import pk.com.mypetworld.server.pets.model.Pet;


/**
 * @author Ali
 *
 */
public interface PetService {

	 
	public Iterable<Pet> getPets();
	
	
	public boolean createPet(Pet pet);
	
	
	public Pet getPet(String petId);
	
	
	public Pet getPetByEmailAndPassword(String email, String password);


	public Pet getByEmailAddress(String petname);
		
}
