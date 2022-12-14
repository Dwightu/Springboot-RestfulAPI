package com.ltp.contacts.service;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.ltp.contacts.pojo.Contact;
import com.ltp.contacts.repository.ContactRepository;

@Repository
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;
    
    public ContactServiceImpl(){
        System.out.println("Created the contact service implementation");
    }


    @Override
    public Contact getContactById(String id) {
        // TODO Auto-generated method stub
        return contactRepository.getContact(findIndexById(id));
    }

    @Override
    public void saveContact(Contact contact) {
        // TODO Auto-generated method stub
        contactRepository.saveContact(contact);
        
    }

    @Override
    public void updateContact(String id, Contact contact) {
        // TODO Auto-generated method stub
        contactRepository.updateContact(findIndexById(id), contact);
    }

    @Override
    public void deleteContact(String id) {
        // TODO Auto-generated method stub
        contactRepository.deleteContact(findIndexById(id));
        
    }
    private int findIndexById(String id) {
        return IntStream.range(0, contactRepository.getContacts().size())
            .filter(index -> contactRepository.getContacts().get(index).getId().equals(id))
            .findFirst()
            .orElseThrow();
    }


    @Override
    public List<Contact> getContacts() {
        // TODO Auto-generated method stub
        return contactRepository.getContacts();
    }

}
