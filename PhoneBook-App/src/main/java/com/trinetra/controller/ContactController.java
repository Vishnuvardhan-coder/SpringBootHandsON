package com.trinetra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trinetra.entity.Contact;
import com.trinetra.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/loadForm")
	public String loadForm(Model model) {

		model.addAttribute("contact", new Contact());

		return "index";
	}

	@PostMapping("/saveContact")
	public String handleSaveContactBtn(Contact contact, Model model) {

		String msgTxt = null;
		if (contact.getContactId() == null) {
			msgTxt = "Contact Saved Successfully";

		} else {
			msgTxt = "Contact Updated Successfully";
		}

		boolean isSaved = contactService.save(contact);

		if (isSaved) {

			model.addAttribute("succMsg", msgTxt);
		} else {
			model.addAttribute("errMsg", "Failed to Save Contact");
		}

		return "index";

	}

	@GetMapping("/viewContacts")
	public String handleViewContactHyperLink(Model model) {
		List<Contact> contactsList = contactService.getAllContacts();
		model.addAttribute("contacts", contactsList);
		return "viewContacts";
	}

	@GetMapping("/edit")
	public String handleEditClick(@RequestParam("cid") Integer cid, Model model) {

		Contact contactObj = contactService.getContactById(cid);
		model.addAttribute("contact", contactObj);
		return "index";

	}
	
	@GetMapping("/delete")
	public String handleDeleteClick(@RequestParam("cid") Integer cid) {
		
		contactService.deleteContactById(cid);
		
		return "redirect:/viewContacts";
		
	}

}
