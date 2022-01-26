package com.example.gestion_employer1.dao.implementation;

import com.example.gestion_employer1.dao.interfaces.AdminDao;
import com.example.gestion_employer1.entity.AdminEntity;
import com.example.gestion_employer1.utils.PersistenceManager;
import jakarta.persistence.EntityManager;


import java.util.ArrayList;

public class AdminDaoImp implements AdminDao {
    EntityManager entityManager = PersistenceManager.getInstance().getEntityManager();
    @Override
    public AdminEntity add(AdminEntity admin) {
        try {
        entityManager.getTransaction().begin();
        entityManager.persist(admin);
        entityManager.getTransaction().commit();
        return admin;
        }catch (Exception e){
            return null;
        }finally {
            entityManager.close();
        }
    }
    @Override
    public AdminEntity find(Long id) {
        try {
        entityManager.getTransaction().begin();
        AdminEntity admin = entityManager.find(AdminEntity.class,id);
        return admin;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public ArrayList<AdminEntity> getAll() {
        try {
        entityManager.getTransaction().begin();
        ArrayList<AdminEntity> adminEntity = new ArrayList<>(entityManager.createQuery("SELECT e FROM UserEntity e ").getResultList());
        return adminEntity;
        }catch (Exception e){
            return null;
        }finally {
            entityManager.close();
        }
    }
    @Override
    public AdminEntity update(AdminEntity admin) {
        System.out.println(admin);
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(admin);
            entityManager.getTransaction().commit();
            return admin;
        }catch (Exception e){
            return null;
        }finally {
            entityManager.close();
        }
    }
    @Override
    public boolean delete(Long id) {
        try {
            entityManager.getTransaction().begin();
            AdminEntity admin = entityManager.find(AdminEntity.class, id);
            entityManager.remove(admin);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            return false;
        }finally {
            entityManager.close();
        }
    }
}
