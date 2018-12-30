package dudy.springdemo.controller;

import dudy.springdemo.entity.Translation;
import dudy.springdemo.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by admin on 11.11.2018.
 */
@Controller
@RequestMapping("/word")
public class TranslationController {
    @Autowired
    TranslationService service;
    @GetMapping("/list")
    public String listWords(Model model){
        List<Translation> translations = service.getWords();

        for (Translation t :translations
             ) {
            System.out.println("test translations jest="+t);
        }





        String sentence = "Andrew Strauss stepped down from his position as director of cricket with the England and Wales Cricket Board in October in order to spend more time with her as she fought the condition.";
        System.out.println("sentence="+sentence);
        Scanner scanner = new Scanner(sentence);
        ArrayList<String> sentenceWords = new ArrayList<>();
        while (scanner.hasNext()) {
            sentenceWords.add(scanner.next());
        }


        for (String item:sentenceWords
             ) {
            System.out.println("Dla sentenceWords="+item);
            List<Translation> wordsInTable = service.getWord(item);
            for (Translation www:wordsInTable
                 ) {
                System.out.println(" w tabeli jest="+www);
            }
            //System.out.println(item+" -> " + GoogleTranslate.translate("pl", item));
        }



        model.addAttribute("sentence", sentence);
        model.addAttribute("sentenceWords", sentenceWords);
        model.addAttribute("translations", translations);
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
