package com.example;

import com.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeMain {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("/hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            // Create an employee object
            Employee employee = new Employee("John", "Doe", "MacroStrong");
            // save it to the database
            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }



    }
}
