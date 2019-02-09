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
//@ControllerAdvice
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
                //translationsT.add(new Translation(" szukaj w Google"));
                translationsT=null;
                //System.out.println(wordi+" -> " + GoogleTranslate.translate("pl", wordi));
            }
            wordTranslationsAll.add(new WordTranslation(wordt,translationsT));
        }
        for (WordTranslation wtt:wordTranslationsAll
        ) {
            System.out.println("wordTranslationsAll="+wtt);
        }


        model.addAttribute("sentence", sentence);
        model.addAttribute("sentenceWords", sentenceWords);
        model.addAttribute("translations", translations);
        model.addAttribute("wordTranslationsAll", wordTranslationsAll);

        return "list-words";
    }

    @GetMapping("/showFormForUpdate")
    public String formForUpdate(@RequestParam("id") int id,
                                Model model){
        Translation translation = translationService.getTranslationForIdTranslation(id);
        System.out.println("+++ w showFormForUpdate +++ translation="+translation);
        model.addAttribute("translation", translation);
        return "translation-form";
    }

    @PostMapping("/saveTranslationX")
    public String processForm(@ModelAttribute("translation") Translation theTranslation){
        System.out.println("+++ w saveTranslationX +++ theTranslation="+theTranslation);
        translationService.addTranslation(theTranslation);
        return "redirect:/word/list";
    }

    @RequestMapping("/showFormForAdd")
    public String formForAdd(Model model){


        Translation theTranslation = new Translation();
        theTranslation.setIdWord(1);
        theTranslation.setTranslation("xxx");
        theTranslation.setWord(new Word("xxx"));

        //Translation theTranslation = translationService.getTranslationForIdTranslation(1);
        //theTranslation.setTranslation("test");

        System.out.println("++++ w showFormForAdd theTranslation ++++ ="+theTranslation);
        model.addAttribute("translationY", theTranslation);
        return "translation-form-add";
    }

    @PostMapping("/saveTranslationY")
    public String processFormY(@ModelAttribute("translationY") Translation theTranslation){
        System.out.println("+++ w saveTranslationY +++ theTranslation="+theTranslation);
        translationService.addTranslation(theTranslation);
        return "redirect:/word/list";
    }

    /*
    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerToDeleteId")int theId){
        translationService.deleteCustomer(theId);
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
