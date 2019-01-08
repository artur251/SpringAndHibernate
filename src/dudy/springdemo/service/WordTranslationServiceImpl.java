package dudy.springdemo.service;

import dudy.springdemo.dao.TranslationDao;
import dudy.springdemo.dao.WordDao;
import dudy.springdemo.entity.Translation;
import dudy.springdemo.entity.Word;
import dudy.springdemo.entity.WordTranslation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 12.11.2018.
 */
@Service
public class WordTranslationServiceImpl implements WordTranslationService {
    @Autowired
    private WordDao wordDao;
    @Autowired
    private TranslationDao translationDao;

    @Override
    public ArrayList<WordTranslation> getWordTranslations(Word word) {

        ArrayList<WordTranslation> result = null; // = new List<WordTranslation>();

        //wyszukanie słowa
        List<Word> words = wordDao.getWord(word.getWord());


        for (Word item : words
             ) {
            //wyszukanie jego tłumaczeń
            List<Translation> translations = translationDao.getTranslationsForIdWord(item.getId());
            //utworzenie instancji
            WordTranslation wordTranslation = new WordTranslation(item, translations);
            //dodanie do listy wynikowej
            result.add(wordTranslation);
        }
        return result;
    }

    @Override
    public ArrayList<WordTranslation> getWordTranslations(String word) {
        System.out.println("Jestem w getWordTranslations(String word):");

        //List<WordTranslation> result = new ArrayList<WordTranslation>();
        ArrayList<WordTranslation> result = null; ///new ArrayList<WordTranslation>();

        //wyszukanie słowa
        System.out.println("Jestem w getWordTranslations(String word): przed wordDao.getTranslationsForIdWord dla word="+word);
        List<Word> words = wordDao.getWord(word);
        System.out.println("Jestem w getWordTranslations(String word): po wordDao.getTranslationsForIdWord words.size()="+words.size());

        if (!words.isEmpty())
        {
//            for (Word item : words
//            ) {
//                //wyszukanie jego tłumaczeń
//                List<Translation> translations = translationDao.getTranslationsForIdWord(item.getId());
//                System.out.println("Jestem w getWordTranslations(String word): po translationDao.getTranslationsForIdWord translations.size()="+translations.size());
//                //utworzenie instancji
//                //WordTranslation wordTranslation = new WordTranslation(item, translations);
//                //dodanie do listy wynikowej
//
//                if (!translations.isEmpty()) {
//                    System.out.println("Jestem w getWordTranslations(String word): item="+item);
//                    System.out.println("Jestem w getWordTranslations(String word): translations="+translations);
//
//
//                    result.add(new WordTranslation(item, translations));
//                }
//            }


                List<Translation> translations = translationDao.getTranslationsForIdWord(words.get(0).getId());
                System.out.println("Jestem w getWordTranslations(String word): po translationDao.getTranslationsForIdWord translations.size()="+translations.size());
                //utworzenie instancji
                //WordTranslation wordTranslation = new WordTranslation(item, translations);
                //dodanie do listy wynikowej

                if (!translations.isEmpty()) {
                    System.out.println("Jestem w getWordTranslations(String word): words.get(0)="+words.get(0));
                    System.out.println("Jestem w getWordTranslations(String word): translations="+translations);
                    System.out.println("Jestem w getWordTranslations(String word): translations.size()="+translations.size());


                    result.add(new WordTranslation(words.get(0), translations));
                }




    }
        return result;
    }





    /*
    @Override
    @Transactional
    public List<Translation> getTranslations() {
        return translationDao.getTranslations();
    }

    @Override
    @Transactional
    public List<Translation> getTranslationsForIdWord(String item) {
        return translationDao.getTranslationsForIdWord(item);
    }
*/
/*
    @Override
    @Transactional
    public void addCustomer(Customer theCustomer) {
        customerDao.addCustomer(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        Customer customer = customerDao.getCustomer(theId);
        return customer;
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
        customerDao.deleteCustomer(theId);
    }

    @Override
    @Transactional
    public List<Customer> getCustomer(String theName) {
        List<Customer> list = customerDao.getCustomer(theName);
        return list;
    }
*/
}
