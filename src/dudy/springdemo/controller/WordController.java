package dudy.springdemo.controller;

import dudy.springdemo.entity.Customer;
import dudy.springdemo.entity.Word;
import dudy.springdemo.service.CustomerService;
import dudy.springdemo.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 11.11.2018.
 */
@Controller
@RequestMapping("/word")
public class WordController {
    @Autowired
    WordService service;
    @GetMapping("/list")
    public String listWords(Model model){
        List<Word> words = service.getWords();

        String zdanie = "Ala ma kota itd.";
        model.addAttribute("zdanie", zdanie);

        ArrayList<String> wordx = new ArrayList<>();
        wordx.add("Ala");
        wordx.add("ma");
        wordx.add("kota");
        wordx.add("i");
        wordx.add("kot");
        wordx.add("ma");
        wordx.add("też");
        wordx.add("Alę");
        model.addAttribute("wordx", wordx);

        model.addAttribute("words", words);
        return "list-words";
    }
/*
    @RequestMapping("/showFormForAdd")
    public String formForAdd(Model model){
        Customer theCustomer = new Customer();
        model.addAttribute("customer", theCustomer);
        return "customer-form";
    }
    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerToDeleteId")int theId){
        service.deleteCustomer(theId);
        return "redirect:/customer/list";
    }
    @PostMapping("/saveCustomer")
    public String processForm(@ModelAttribute("customer")Customer theCustomer){
        service.addCustomer(theCustomer);
        return "redirect:/customer/list";
    }
    @GetMapping("/showFormForUpdate")
    public String formForUpdate(@RequestParam("customerId") int theId,
                                Model model){
        Customer customer = service.getCustomer(theId);
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @PostMapping("/search")
    public String loadCustomerByName(@RequestParam("theSearchName")String theName, Model model){
        List<Customer> selectedCustomers = service.getCustomer(theName);
        model.addAttribute("customers", selectedCustomers);
        return "list-customers";
    }
*/
}
