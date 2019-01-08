package dudy.springdemo.service;

import dudy.springdemo.dao.TranslationDao;
import dudy.springdemo.dao.WordDao;
import dudy.springdemo.entity.Translation;
import dudy.springdemo.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by admin on 12.11.2018.
 */
@Service
public class WordServiceImpl implements WordService {
    @Autowired
    private WordDao wordDao;
    @Override
    @Transactional
    public List<Word> getWords() {
        return wordDao.getWords();
    }

    @Override
    @Transactional
    public List<Word> getWord(String item) {
        return wordDao.getWord(item);
    }
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
