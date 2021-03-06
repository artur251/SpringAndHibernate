package dudy.springdemo.service;

import dudy.springdemo.dao.TranslationDao;
import dudy.springdemo.entity.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 12.11.2018.
 */
@Service
public class TranslationServiceImpl implements TranslationService {
    @Autowired
    private TranslationDao translationDao;
    @Override
    @Transactional
    public List<Translation> getTranslations() {
        return translationDao.getTranslations();
    }

//    @Override
//    @Transactional
//    public List<Translation> getTranslationsForIdWord(int id) {
//        return translationDao.getTranslationsForIdWord(id);
//    }

    @Override
    @Transactional
    public Translation getTranslationForIdTranslation(int id) {
        return translationDao.getTranslationForIdTranslation(id);
    }


    @Override
    @Transactional
    public void addTranslation(Translation theTranslation) {
        translationDao.addTranslation(theTranslation);
    }



    /*

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
