package vttp2022b2.webapp.workshop13.controller;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import vttp2022b2.webapp.workshop13.model.Contact;
import vttp2022b2.webapp.workshop13.util.Contacts;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

@Controller
@RequestMapping(path = "/addressbook")
public class AddressbookController {

    @Autowired
    Contacts ctcz;

    @Autowired
    ApplicationArguments appArgs;

    @Value("${test.data.dir}")
    private String dataDir;

    @GetMapping
    public String showAddressbookForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "addressbook";
    }

    @PostMapping
    public String saveContact(@Valid Contact contact, BindingResult binding, Model model) {
        if (binding.hasErrors()) {
            return "addressbook";
        }
        System.out.println(checkAgeInBetween(contact));
        if (!checkAgeInBetween(contact)) {
            ObjectError err = new ObjectError("age", "Age must be between 10 and 100 years old");
            binding.addError(err);
            return "addressbook";
        }
        ctcz.saveContact(contact, model, appArgs, dataDir);
        return "showContact";
    }

    @GetMapping("{contactId}")
    public String getContactById(Model model, @PathVariable String contactId) {
        ctcz.getContactById(model, contactId, appArgs, dataDir);
        return "showContact";
    }

    private boolean checkAgeInBetween(Contact contact) {
        LocalDate dob = contact.getDateOfBirth();
        System.out.println("check age");
        int calculatedAge = 0;
        if ((dob != null)) {
            calculatedAge = Period.between(dob, LocalDate.now()).getYears();
        }
        System.out.println(calculatedAge);
        if (calculatedAge >= 10 && calculatedAge <= 100) {
            contact.setAge(calculatedAge);
            return true;
        }

        return false;

    }
}
