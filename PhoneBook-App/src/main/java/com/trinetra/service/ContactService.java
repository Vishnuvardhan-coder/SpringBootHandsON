package com.trinetra.service;

import java.util.List;

import com.trinetra.entity.Contact;

public interface ContactService {

	public boolean save(Contact contact);
	public List<Contact> getAllContacts();
	public Contact getContactById(Integer contactId);
	public boolean updateContact(Contact contact);
	public boolean deleteContactById(Integer contactId);
}
