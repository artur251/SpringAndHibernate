package dudy.springdemo.dao;

import dudy.springdemo.entity.Translation;
import dudy.springdemo.entity.Word;

import java.util.List;

/**
 * Created by admin on 11.11.2018.
 */
public interface WordDao {
    List<Word> getWords();
    List<Word> getWord(String item);
/*
    void addCustomer(Customer customer);
    Customer getCustomer(int theId);
    void deleteCustomer(int theId);
    List<Customer> getCustomer(String theName);
*/
}