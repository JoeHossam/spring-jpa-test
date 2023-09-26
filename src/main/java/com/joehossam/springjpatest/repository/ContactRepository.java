package com.joehossam.springjpatest.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.joehossam.springjpatest.entity.Contact;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class ContactRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Contact save(Contact contact) {
        entityManager.persist(contact);
        return contact;
    }

}
