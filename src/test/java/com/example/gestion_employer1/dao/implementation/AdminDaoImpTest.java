package com.example.gestion_employer1.dao.implementation;

import com.example.gestion_employer1.dao.interfaces.AdminDao;
import com.example.gestion_employer1.entity.AdminEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdminDaoImpTest {

    @Test
    void add() {
        AdminDao adminDao = new AdminDaoImp();
        AdminEntity admin= new AdminEntity();
        admin.setEmail("email@emaoi.com");
        admin.setLast_name("dfqsf");
        admin.setLast_name("qsfdsdf");
        admin.setPassword("adsqf");
        admin.setRole(new RoleDaoImp().getAll().get(0));
        assertInstanceOf(AdminEntity.class,adminDao.add(admin));
    }

    @Test
    void find() {
        AdminDao adminDao = new AdminDaoImp();
        assertInstanceOf(AdminEntity.class,adminDao.find(new Long(1)));
    }

    @Test
    void getAll() {
        AdminDao adminDao = new AdminDaoImp();
        ArrayList<AdminEntity> admins = new ArrayList<AdminEntity>();
        assertInstanceOf(admins.getClass(),adminDao.getAll());

    }

    @Test
    void update() {
        AdminDao adminDao = new AdminDaoImp();
        AdminEntity admin = new AdminEntity("employer admin","last_name","emailup@gmail.com","pasword12",new RoleDaoImp().find(new Long(1)),(long)1);
        assertInstanceOf(AdminEntity.class,adminDao.update(admin));
    }

    @Test
    void delete() {
        AdminDao adminDao = new AdminDaoImp();
        assertTrue(adminDao.delete(new Long(1)));
    }
}