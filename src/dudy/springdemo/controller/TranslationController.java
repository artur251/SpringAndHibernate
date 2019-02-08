package dudy.springdemo.controller;

import dudy.springdemo.entity.Translation;
import dudy.springdemo.entity.Word;
import dudy.springdemo.entity.WordTranslation;
import dudy.springdemo.service.TranslationService;
import dudy.springdemo.service.WordService;
import dudy.springdemo.service.WordTranslationService;
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
    TranslationService translationService;
    @Autowired
    WordTranslationService wordTranslationService;
    @Autowired
    WordService wordService;



    @GetMapping("/list")
    public String listWords(Model model){
        List<Translation> translations = translationService.getTranslations();

        for (Translation t :translations
        ) {
            System.out.println("test translations jest="+t);
        }




        String sentence = "Andrew Strauss book stepped down star from his position as room director of cricket with the England and Wales Cricket Board in October in order to spend more time with her as she fought the condition.";
        System.out.println("sentence="+sentence);
        Scanner scanner = new Scanner(sentence);
        ArrayList<String> sentenceWords = new ArrayList<>();
        while (scanner.hasNext()) {
            sentenceWords.add(scanner.next());
        }

        List<WordTranslation> wordTranslationsAll =  new ArrayList<WordTranslation>();
        List<WordTranslation> wordTranslations =  new ArrayList<WordTranslation>();
        for (String wordi:sentenceWords
        ) {
            System.out.println("Dla getWordTranslations wordi="+wordi);
            List<Word> wordArrayList= new ArrayList<Word>();
            wordArrayList=wordService.getWord(wordi);

            Word wordt = new Word();
            List<Translation> translationsT = new ArrayList<Translation>();

            if (!wordArrayList.isEmpty()) {
                wordt=wordArrayList.get(0);
                translationsT = wordArrayList.get(0).getTranslations();
            }
            else
            {
                wordt.setWord(wordi);
                translationsT.add(new Translation("Google:..."));


                //System.out.println(wordi+" -> " + GoogleTranslate.translate("pl", wordi));


            }
            wordTranslationsAll.add(new WordTranslation(wordt,translationsT));
        }
        for (WordTranslation wtt:wordTranslationsAll
        ) {
            System.out.println("wordTranslationsAll="+wtt);
        }




//        for (String item:sentenceWords
//             ) {
//            System.out.println("Dla sentenceWords="+item);
//            List<Translation> wordsInTable = translationService.getTranslationsForIdWord(item);
//            for (Translation www:wordsInTable
//                 ) {
//                System.out.println(" w tabeli jest="+www);
//            }
//            //System.out.println(item+" -> " + GoogleTranslate.translate("pl", item));
//        }



        model.addAttribute("sentence", sentence);
        model.addAttribute("sentenceWords", sentenceWords);
        model.addAttribute("translations", translations);


        model.addAttribute("wordTranslationsAll", wordTranslationsAll);



        return "list-words";
    }

    @GetMapping("/showFormForUpdate")
    public String formForUpdate(@RequestParam("wordId") int theId,
                                Model model){
        List<Translation> translations = translationService.getTranslationsForIdWord(theId);
        model.addAttribute("translations", translations);
        return "translations-form";
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
        translationService.deleteCustomer(theId);
        return "redirect:/customer/list";
    }
    @PostMapping("/saveCustomer")
    public String processForm(@ModelAttribute("customer")Customer theCustomer){
        translationService.addCustomer(theCustomer);
        return "redirect:/customer/list";
    }


    @PostMapping("/search")
    public String loadCustomerByName(@RequestParam("theSearchName")String theName, Model model){
        List<Customer> selectedCustomers = translationService.getCustomer(theName);
        model.addAttribute("customers", selectedCustomers);
        return "list-customers";
    }
*/
}
