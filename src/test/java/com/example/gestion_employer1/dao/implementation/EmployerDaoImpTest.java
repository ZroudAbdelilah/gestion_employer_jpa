package com.example.gestion_employer1.dao.implementation;

import com.example.gestion_employer1.dao.interfaces.EmployerDao;
import com.example.gestion_employer1.entity.EmployerEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmployerDaoImpTest {

    @Test
    void add() {
        EmployerDao employerDao = new EmployerDaoImp();
        EmployerEntity employer = new EmployerEntity("employer","last_employer","employer@gamil","pasword",new RoleDaoImp().find(new Long(2)));
        assertInstanceOf(EmployerEntity.class,employerDao.add(employer));
    }

    @Test
    void find() {
        EmployerDao employerDao = new EmployerDaoImp();
        assertInstanceOf(EmployerEntity.class,employerDao.find(new Long(2)));
    }

    @Test
    void getAll() {
        EmployerDao employerDao = new EmployerDaoImp();
        ArrayList<EmployerEntity> employers = new ArrayList<EmployerEntity>();
        assertInstanceOf(employers.getClass(),employerDao.getAll());
    }

    @Test
    void update() {
        EmployerDao employerDao = new EmployerDaoImp();
        EmployerEntity employer = new EmployerEntity("employerUptest","last_employer","employer@gamil","pasword",new RoleDaoImp().find(new Long(2)),new Long(2));
        assertInstanceOf(EmployerEntity.class,employerDao.update(employer));
    }

    @Test
    void delete() {
        EmployerDao employerDao = new EmployerDaoImp();
        assertTrue(employerDao.delete(new Long(2)));
    }
}