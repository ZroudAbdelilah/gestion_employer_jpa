package com.example.gestion_employer1.dao.implementation;

import com.example.gestion_employer1.dao.interfaces.RoleDao;
import com.example.gestion_employer1.entity.RoleEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RoleDaoImpTest {

    @Test
    void add() {
        RoleDao roleDao = new RoleDaoImp();
        RoleEntity role = new RoleEntity("employer");
        assertInstanceOf(RoleEntity.class,roleDao.add(role));
    }

    @Test
    void find() {
        RoleDao roleDao = new RoleDaoImp();
        assertInstanceOf(RoleEntity.class,roleDao.find(new Long(1)));
    }

    @Test
    void getAll() {
        ArrayList<RoleEntity> roles = new ArrayList<RoleEntity>();
        RoleDao roleDao = new RoleDaoImp();
        assertInstanceOf(roles.getClass(),roleDao.getAll());
    }

    @Test
    void update() {
        RoleDao roleDao = new RoleDaoImp();
        RoleEntity role = new RoleEntity(new Long(1),"employerUP");
        assertInstanceOf(RoleEntity.class,roleDao.update(role));

    }

    @Test
    void delete() {
        RoleDao roleDao = new RoleDaoImp();
        assertTrue(roleDao.delete(new Long(1)));
    }
}