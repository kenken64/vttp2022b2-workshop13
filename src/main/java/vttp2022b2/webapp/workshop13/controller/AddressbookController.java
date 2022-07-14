package vttp2022b2.webapp.workshop13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp2022b2.webapp.workshop13.model.Contact;
import vttp2022b2.webapp.workshop13.util.Contacts;

@Controller
@RequestMapping(path = "/addressbook")
public class AddressbookController {

    @Autowired
    Contacts ctcz;

    @Autowired
    ApplicationArguments appArgs;

    @GetMapping
    public String showAddressbookForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "addressbook";
    }

    @PostMapping
    public String saveContact(@ModelAttribute Contact contact, Model model) {
        ctcz.saveContact(contact, model, appArgs);
        return "showContact";
    }
}
