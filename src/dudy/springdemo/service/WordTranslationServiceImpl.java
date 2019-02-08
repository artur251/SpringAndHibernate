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
            WordTranslation wordTranslation = new WordTranslation(item, item.getTranslations());
            //dodanie do listy wynikowej
            result.add(wordTranslation);
        }
        return result;
    }

    @Override
    public ArrayList<WordTranslation> getWordTranslations(String word) {
        //jak w funkcji jw.
        ArrayList<WordTranslation> result = null; // = new List<WordTranslation>();
        //wyszukanie słowa
        List<Word> words = wordDao.getWord(word);
        for (Word item : words
        ) {
            WordTranslation wordTranslation = new WordTranslation(item, item.getTranslations());
            //dodanie do listy wynikowej
            result.add(wordTranslation);
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
