package com.xidian.edu.Dao;

import com.xidian.edu.model.Customer;

public interface ICustomerDao {
    public void insert(Customer customer);
    public Customer findByCustomerId(int custId);
}
