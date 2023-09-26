package com.joehossam.springjpatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joehossam.springjpatest.entity.Contact;
import com.joehossam.springjpatest.repository.ContactRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class SpringJpaTestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaTestApplication.class, args);
	}

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public void run(String... args) throws Exception {
		saveContact();
	}

	@Transactional
	public void saveContact() {
		Contact contact = Contact.builder().name("joe 4").address("cairo 4").email("joe hossam 4").build();
		Contact persistedContact = contactRepository.save(contact);
		persistedContact.setAddress("new cairo");
	}

}
