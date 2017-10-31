package com.xidian.edu.model;

public class Customer {
    int cust_id;
    int age;
    String name;
    public Customer(){

    }
    public Customer(int cust_id,int age,String name){
        this.cust_id=cust_id;
        this.age=age;
        this.name=name;
    }
    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return this.cust_id+" "+name+" "+age;
    }
}
