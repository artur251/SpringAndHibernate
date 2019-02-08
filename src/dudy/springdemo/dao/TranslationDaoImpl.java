package dudy.springdemo.dao;

import dudy.springdemo.entity.Translation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by admin on 11.11.2018.
 */
@Repository
public class TranslationDaoImpl implements TranslationDao {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<Translation> getTranslations() {
        //Session session = sessionFactory.getCurrentSession();
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        Query<Translation> query = session.createQuery("from Translation order by timestampUpdate", Translation.class);
        List<Translation> translations = query.getResultList();
        return translations;
    }

//    @Override
//    public List<Translation> getTranslationsForIdWord(int idWordx) {
//        //Session session = sessionFactory.getCurrentSession();
//        Session session;
//        try {
//            session = sessionFactory.getCurrentSession();
//        } catch (HibernateException e) {
//            session = sessionFactory.openSession();
//        }
//
//
//        Query<Translation> query = session.createQuery("from Translation where idWord=:idWordx order by timestampUpdate", Translation.class);
//        query.setInteger("idWordx", idWordx);
//        List<Translation> translations = query.getResultList();
//        return translations;
//    }

    @Override
    public Translation getTranslationForIdTranslation (int idTranslation)
    {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        Query<Translation> query = session.createQuery("from Translation where id=:idTranslation", Translation.class);
        query.setInteger("idTranslation", idTranslation);
        Translation translation = query.getResultList().get(0);
        System.out.println("getTranslationForIdTranslation ++++++++++++++++++ theTranslation="+translation);
        return translation;
    }

    @Override
    public void addTranslation(Translation theTranslation) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("addTranslation ++++++++++++++++++ theTranslation="+theTranslation);
        session.saveOrUpdate(theTranslation);

    }
/*
    @Override
    public Customer getCustomer(int theId) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class,theId);
        return customer;
    }

    @Override
    public void deleteCustomer(int theId) {
        Session session = sessionFactory.getCurrentSession();
        Customer customerToDelete = session.get(Customer.class, theId);
        session.delete(customerToDelete);
    }

    @Override
    public List<Customer> getCustomer(String theName) {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer>query = null;
        if(theName != null && theName.trim().length() > 0) {
            query= session.createQuery("FROM Customer c where c.name LIKE CONCAT('%', :theName, '%')");
            query.setString("theName", theName);
        }
        else{
            query = session.createQuery("from Customer order by lastName", Customer.class);
        }
        List<Customer> list = query.getResultList();
        return list;
    }
*/
}
