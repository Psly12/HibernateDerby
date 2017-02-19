package com.java;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class UserDao {
    
public static int register(User u){
    int i=0;
    Session session=null;
    session=new Configuration().configure().buildSessionFactory().openSession();
    Transaction t=session.beginTransaction();
    i=(Integer)session.save(u);
    t.commit();
    session.close();
    return i;
}    
    
}
