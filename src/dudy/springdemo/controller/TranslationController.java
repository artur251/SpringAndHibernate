package dudy.springdemo.controller;

import dudy.springdemo.entity.Translation;
import dudy.springdemo.entity.Word;
import dudy.springdemo.service.TranslationService;
import dudy.springdemo.service.WordService;

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

        //xxList<WordTranslation> wordTranslationsAll =  new ArrayList<WordTranslation>();
        //xxList<WordTranslation> wordTranslations =  new ArrayList<WordTranslation>();
        List<Word> wordTranslationsAll =  new ArrayList<Word>();


        for (String wordi:sentenceWords
        ) {
            System.out.println("Dla getWordTranslations wordi="+wordi);
            List<Word> wordArrayList= new ArrayList<Word>();
            wordArrayList=wordService.getWord(wordi);

            Word wordt = new Word();
            //List<Translation> translationsT = new ArrayList<Translation>();

            if (!wordArrayList.isEmpty()) {
                wordt=wordArrayList.get(0);
                //xxtranslationsT = wordArrayList.get(0).getTranslations();


                //wordt.setTranslations(wordt.getTranslations());
            }
            else
            {
                wordt.setWord(wordi);
                //translationsT.add(new Translation(" szukaj w Google"));
                //translationsT=null;
                //System.out.println(wordi+" -> " + GoogleTranslate.translate("pl", wordi));
            }

            //xxwordTranslationsAll.add(new WordTranslation(wordt,translationsT));
            wordTranslationsAll.add(wordt);



        }
        for (Word wtt:wordTranslationsAll
        ) {
            System.out.println("LOOP TEST wordTranslationsAll="+wtt);
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

    @PostMapping("/saveTranslation")
    public String processForm(@ModelAttribute("translation") Translation theTranslation){
    //public String processForm(@ModelAttribute("word") Word theWord, @ModelAttribute("translation") Translation theTranslation){
        System.out.println("+++ w saveTranslation +++ theTranslation="+theTranslation);

        System.out.println("+++ w saveTranslation +++ theTranslation.getIdWord()="+theTranslation.getIdWord());

//        if (theTranslation.getIdWord()!=0)
//        {
//            System.out.println("+++ w saveTranslation +++ kolejne tłumaczenie do word theTranslation.getIdWord()="+theTranslation.getIdWord());
//        }
//        else //trzeba dodać word
//        {
//            Word theWord = new Word();
//            theWord.setWord("Strauss");
//            theWord.setLanguage("eng");
//            System.out.println("+++ w saveTranslation +++ pierwsze trzeba dodać word theWord="+theWord);
//            wordService.addWord(theWord);
//            System.out.println("+++ w saveTranslation +++ pierwsze trzeba dodać word theWord, pododaniu theWord.getId()="+theWord.getId());
//            theTranslation.setIdWord(theWord.getId());
//        }

        translationService.addTranslation(theTranslation);
        return "redirect:/word/list";
    }

    @RequestMapping("/showFormForAddTranslation")
    public String formForAddTranslation(@RequestParam("idWord") int idWord, @RequestParam("theSentence") String theSentence, Model model){
//      public String formForAdd(@RequestParam("theWord") Word theWord, @RequestParam("theSentence") String theSentence, Model model){
        System.out.println("++++ w showFormForAdd theTranslation ++++ idWord="+idWord);
        Translation theTranslation = new Translation();
        theTranslation.setIdWord(idWord);
        theTranslation.setSentence(theSentence);


        //TODO
        theTranslation.setLanguage("eng");
        theTranslation.setIdSource(1);


        System.out.println("++++ w showFormForAdd theTranslation ++++ ="+theTranslation);
        model.addAttribute("translation", theTranslation);
        return "translation-form";
    }


    @RequestMapping("/showFormForAddWord")
    //public String formForAddWord(@RequestParam("idWord") int idWord, @RequestParam("theSentence") String theSentence, Model model){
    public String formForAdd(@RequestParam("theWord") Word theWord, Model model){
        System.out.println("++++ w showFormForAdd theTranslation ++++ theWord="+theWord);
        //Translation theTranslation = new Translation();
        //theTranslation.setIdWord(idWord);
        //theTranslation.setSentence(theSentence);


        //TODO
        //theTranslation.setLanguage("eng");
        //theTranslation.setIdSource(1);


        //System.out.println("++++ w showFormForAdd theTranslation ++++ ="+theTranslation);
        model.addAttribute("word", theWord);
        return "word-form";
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
