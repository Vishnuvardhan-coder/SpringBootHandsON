package com.trinetra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trinetra.entity.Contact;
import com.trinetra.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;

	@Override
	public boolean save(Contact contact) {

		contact.setActiveSwitch("Y");
		Contact savedObj = contactRepo.save(contact);

		/*
		 * if(savedObj.getContactId()!=null) { return true;
		 * 
		 * }else { return false; }
		 */
		return savedObj.getContactId() != null;
	}

	@Override
	public List<Contact> getAllContacts() {

		//return contactRepo.findAll();
		return contactRepo.findByActiveSwitch("Y");
	}

	@Override
	public Contact getContactById(Integer contactId) {

		Optional<Contact> findById = contactRepo.findById(contactId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean updateContact(Contact contact) {

		try {
			Contact save = contactRepo.save(contact);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean deleteContactById(Integer contactId) {

		try {
			//contactRepo.deleteById(contactId);
			 Contact contact = contactRepo.findById(contactId).get();
			 contact.setActiveSwitch("N");
			 contactRepo.save(contact);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
