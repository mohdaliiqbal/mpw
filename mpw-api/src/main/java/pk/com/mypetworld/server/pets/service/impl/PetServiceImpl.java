/**
 * 
 */
package pk.com.mypetworld.server.pets.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pk.com.mypetworld.server.pets.dao.PetRepository;
import pk.com.mypetworld.server.pets.exception.PetServiceException;
import pk.com.mypetworld.server.pets.model.Pet;
import pk.com.mypetworld.server.pets.service.api.PetService;


/**
 * @author Ali
 *
 */
@Service
public class PetServiceImpl implements PetService {

	@Autowired PetRepository petRepository;
	
	Logger logger = Logger.getLogger(PetServiceImpl.class.getName());

	@Override
	public Iterable<Pet> getPets() {
		
		Iterable<Pet> pets =  petRepository.findAll();
		
		return (Iterable<Pet>) pets;
				
	}


	@Override
	public boolean createPet(Pet pet) {

		List<Pet> petList	= petRepository.findByPetId(pet.getPetId());
		
	
		if( petList != null && petList.size()>0)
			throw new PetServiceException( "Pet id already exist in the system. Please use another pet id.");
		
		petList	= petRepository.findByEmailAddress(pet.getEmailAddress());
		if( petList != null && petList.size()>0 )
				throw new PetServiceException("Email id already exist in the system. Please use another email address.");
		
		//save the pet in the system.
		petRepository.save(pet);		
		
		return true;
	}


	@Override
	public Pet getPet(String petId) {
		
		List<Pet> petList = petRepository.findByPetId(petId);
		if( petList != null && petList.size() > 0)
			return petList.get(0);
		
		return null;
	}


	
	@Override
	public Pet getPetByEmailAndPassword(String email, String password) {
		List<Pet> pets = petRepository.findByEmailAddress(email);
		
		if( pets != null && pets.size() > 0)
		{
			logger.debug("Gets the pet by email:"+email);
			
			return pets.get(0);		
		}
		else {
			return null;
		}	
	}


	@Override
	public Pet getByEmailAddress(String emailaddress) {
		List<Pet> pets = petRepository.findByEmailAddress(emailaddress);
		if( pets != null && pets.size()>0)
			return pets.get(0);
		else 
			return null;
		
	}	

}
