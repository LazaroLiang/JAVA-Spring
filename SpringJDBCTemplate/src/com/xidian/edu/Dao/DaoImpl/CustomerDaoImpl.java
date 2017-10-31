package com.xidian.edu.Dao.DaoImpl;

import com.xidian.edu.Dao.ICustomerDao;
import com.xidian.edu.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoImpl implements ICustomerDao{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    public void setDataSource(DataSource dataSource){
        this.dataSource=dataSource;
    }

    @Override
    public void insert(Customer customer) {
        String sql="insert into customer (cust_id,name,age) values (?,?,?)";
        jdbcTemplate=new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{customer.getCust_id(),customer.getName(),customer.getAge()});
//        Connection conn=null;
//        try {
//            conn=dataSource.getConnection();
//            PreparedStatement ps=conn.prepareStatement(sql);
//            ps.setInt(1,customer.getCust_id());
//            ps.setString(2,customer.getName());
//            ps.setInt(3,customer.getAge());
//            ps.executeUpdate();
//            ps.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            if(conn!=null){
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }

    @Override
    public Customer findByCustomerId(int custId) {
        String sql="select * from customer where cust_id=?";
        Connection conn=null;
        try {
            conn=dataSource.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,custId);
            ResultSet rs=ps.executeQuery();
            Customer customer=null;
            if(rs.next()){
                customer=new Customer();
                customer.setCust_id(rs.getInt("cust_id"));
                customer.setName(rs.getString("name"));
                customer.setAge(rs.getInt("age"));
            }
            rs.close();
            ps.close();
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
