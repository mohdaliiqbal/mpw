/**
 * 
 */
package pk.com.mypetworld.server.pets.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import pk.com.mypetworld.server.pets.model.Pet;

/**
 * @author Ali
 *
 */
public interface PetRepository extends PagingAndSortingRepository<Pet, String> {

	public List<Pet> findByPetId(String petid); 
	
	public List<Pet> findByEmailAddress(String emailaddress); 
	
	public List<Pet> findByEmailAddressAndPassword(String emailAddress, String password);
}
