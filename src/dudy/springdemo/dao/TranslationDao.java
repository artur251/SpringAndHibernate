package dudy.springdemo.dao;

import dudy.springdemo.entity.Translation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 11.11.2018.
 */
public interface TranslationDao {
    List<Translation> getTranslations();
//    List<Translation> getTranslationsForIdWord(int idWordx);
    Translation getTranslationForIdTranslation (int idTranslation);
    void addTranslation(Translation theTranslation);
/*
    Customer getCustomer(int theId);
    void deleteCustomer(int theId);
    List<Customer> getCustomer(String theName);
*/
}
