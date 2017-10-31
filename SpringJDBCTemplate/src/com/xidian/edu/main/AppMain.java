package com.xidian.edu.main;

import com.sun.scenario.effect.impl.state.LinearConvolveShadowPeer;
import com.xidian.edu.Dao.DaoImpl.CustomerDaoImpl;
import com.xidian.edu.Dao.DaoImpl.JdbcCustomerDaoImpl;
import com.xidian.edu.Dao.ICustomerDao;
import com.xidian.edu.model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AppMain {
    public static void main(String args[]){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerDaoImpl dao=(CustomerDaoImpl)context.getBean("customerDaoImpl");
//        Customer customer=new Customer(2,22,"Xiao Ming");
//        dao.insert(customer);

//        Customer customer1=dao.findByCustomerId(2);
//        System.out.println(customer1);
        JdbcCustomerDaoImpl jdbcCustomerDao=(JdbcCustomerDaoImpl)context.getBean("jdbcCustomerDaoImpl");
//        Customer customer1=new Customer(3,18,"Lao Wang");
//        jdbcCustomerDao.insert(customer1);
        Customer customer=jdbcCustomerDao.findByCustomerId(3);
        System.out.println(customer);

        List<Customer> customers=jdbcCustomerDao.findAll();
        System.out.println("All recording......");
        for(int i=0;i<customers.size();i++){
            System.out.println(customers.get(i));
        }
    }
}
