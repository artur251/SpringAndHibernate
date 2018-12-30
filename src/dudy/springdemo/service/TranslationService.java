package dudy.springdemo.service;

import dudy.springdemo.entity.Translation;

import java.util.List;

/**
 * Created by admin on 12.11.2018.
 */
public interface TranslationService {
    public List<Translation> getWords();
    public List<Translation> getWord(String item);
/*
    void addCustomer(Customer theCustomer);
    Customer getCustomer(int theId);
    void deleteCustomer(int theId);
    List<Customer> getCustomer(String theName);
*/
}
