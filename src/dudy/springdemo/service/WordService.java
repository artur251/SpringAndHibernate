package dudy.springdemo.service;

import dudy.springdemo.entity.Customer;
import dudy.springdemo.entity.Word;

import java.util.List;

/**
 * Created by admin on 12.11.2018.
 */
public interface WordService {
    public List<Word> getWords();
    public List<Word> getWord(String item);
/*
    void addCustomer(Customer theCustomer);
    Customer getCustomer(int theId);
    void deleteCustomer(int theId);
    List<Customer> getCustomer(String theName);
*/
}
