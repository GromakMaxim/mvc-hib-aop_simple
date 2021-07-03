package com.gromak.spr_mvc_hib_aop.dao;

import com.gromak.spr_mvc_hib_aop.entity.Employee;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private SessionFactory sessionFactory;

    //DI
    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        var session = sessionFactory.getCurrentSession();
        var allEmployees = session
                .createQuery("from Employee", Employee.class)
                .getResultList();
        return allEmployees;
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        var session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        var session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int id) {
        var session = sessionFactory.getCurrentSession();
        var e = session.get(Employee.class, id);
        session.delete(e);
    }
}
