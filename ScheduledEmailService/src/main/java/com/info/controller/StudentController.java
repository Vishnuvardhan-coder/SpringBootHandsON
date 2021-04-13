package com.info.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.info.model.Student;
import com.info.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	public StudentService service;

	@Autowired
	public JavaMailSender mail;

	@Autowired
	private SpringTemplateEngine templateEngine;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String addRecord(Model model) {
		model.addAttribute("student", new Student());
		return "form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveRecord(Student student) {
		service.add(student);
		return "sucess";
	}

	@RequestMapping(path = "/get", method = RequestMethod.GET)
	public String showAll(Model model) {

		//model.addAttribute("students", service.getAll());
		
		model.addAllAttributes(service.getAll());
		
		return "mapex";
	}

	@RequestMapping(path = "/mail", method = RequestMethod.GET)
	public String sendMail() throws MessagingException, IOException {

		MimeMessage message = mail.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());

		Context context = new Context();
		context.setVariables(service.getAll());

		String html = templateEngine.process("mapex", context);

		helper.setTo("princevishnu777@gmail.com");
		helper.setSubject("Updated Data");
		helper.setText(html, true);
		mail.send(message);
		return "mapex";
	}

}
