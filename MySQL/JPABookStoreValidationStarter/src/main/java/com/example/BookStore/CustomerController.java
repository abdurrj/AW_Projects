package com.example.BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/customers")
    public String customers(Model model) {
        List<Customer> customers = (List<Customer>)repository.findAll();
        model.addAttribute("customers", customers);

        return "customers";
    }

    @GetMapping("/addCustomer")
    public String add(Model model) {
        model.addAttribute("customer", new Customer());
        return "customerForm";
    }

    @PostMapping("/saveCustomer")
    public String set(@Valid @ModelAttribute Customer customer, BindingResult result) {
        if(result.hasErrors()){
            return "customerForm";
        }
        repository.save(customer);
        return "redirect:/customers";
    }
}
