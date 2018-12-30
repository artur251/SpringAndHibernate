package dudy.springdemo.dao;

import dudy.springdemo.entity.Translation;
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
    public List<Translation> getWords() {
        Session session = sessionFactory.getCurrentSession();
        Query<Translation> query = session.createQuery("from Translation order by timestampUpdate", Translation.class);
        List<Translation> translations = query.getResultList();
        return translations;
    }

    @Override
    public List<Translation> getWord(String wordx) {
        Session session = sessionFactory.getCurrentSession();
        Query<Translation> query = session.createQuery("from Translation where word=:wordx order by timestampUpdate", Translation.class);
        query.setString("wordx", wordx);
//        query= session.createQuery("FROM Customer c where c.name LIKE CONCAT('%', :theName, '%')");
        List<Translation> translations = query.getResultList();
        return translations;
    }



    /*
    @Override
    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(customer);
        for (int i = 0; i < 11; i++)
        {
            Customer cust = new Customer();
            cust.setName(customer.getName()+"_"+i);
            cust.setLastName(customer.getLastName()+"_"+i);
            cust.setEmail(customer.getEmail()+"_"+i);
            session.saveOrUpdate(cust);
        }
    }

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
