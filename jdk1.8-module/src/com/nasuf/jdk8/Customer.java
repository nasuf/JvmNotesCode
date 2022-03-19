package com.nasuf.jdk8;

public class Customer {
    int id = 1001;
    String name;
    Account acct;

    {
        name = "anonymous client";
    }

    public Customer() {
        acct = new Account();
    }
}

class Account {}
