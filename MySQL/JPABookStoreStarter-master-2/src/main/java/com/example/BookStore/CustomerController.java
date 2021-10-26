package com.example.BookStore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    public String customers(Model model, @RequestParam(value="page", required=false, defaultValue="1") int page) {

        List<Customer> customers = (List<Customer>)customerRepository.findAll();
        model.addAttribute("customers", customers);

        return "customers";
    }

    @GetMapping("/customers/{id}")
    public String customerDetails(Model model, @PathVariable Long id){
        model.addAttribute("customer", customerRepository.findById(id).get());
        return "customer";
    }

    @GetMapping("/addnewcustomer")
    public String addNewCustomer(@ModelAttribute Customer customer){
        return "addcustomer";
    }

    @GetMapping("/addcustomer/{id}")
    public String editCustomer(@PathVariable Long id, Model model){
        Customer customer = customerRepository.findById(id).get();
        model.addAttribute("customer", customer);
        return "addcustomer";
    }


    @PostMapping("/editcustomer")
    public String saveCustomer(Customer customer){
        customerRepository.save(customer);
        return "redirect:/customers";
    }
}
