package com.xidian.edu.Dao.DaoImpl;

import com.xidian.edu.Dao.ICustomerDao;
import com.xidian.edu.model.Customer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class JdbcCustomerDaoImpl extends JdbcDaoSupport implements ICustomerDao{
    @Override
    public void insert(Customer customer) {
        String sql="insert into customer(cust_id,name,age) values(?,?,?)";
        getJdbcTemplate().update(sql,new Object[]{customer.getCust_id(),customer.getName(),customer.getAge()});
    }

    @Override
    public Customer findByCustomerId(int custId) {
        String sql="select * from customer where cust_id=?";
//        getJdbcTemplate().qu
        Customer customer=(Customer) getJdbcTemplate().queryForObject(sql,new Object[]{custId},new BeanPropertyRowMapper(Customer.class));
        return customer;
    }

    public List<Customer> findAll(){
        String sql = "select * from customer";
        List<Customer> allCustomers=getJdbcTemplate().query(sql,new BeanPropertyRowMapper(Customer.class));
        return  allCustomers;
    }

    public void setStringTest(String stringTest){
        System.out.println(stringTest);
    }
}
