package com.example.gestion_employer1.dao.implementation;

import com.example.gestion_employer1.dao.interfaces.AdminDao;
import com.example.gestion_employer1.entity.AdminEntity;
import com.example.gestion_employer1.utils.PersistenceManager;


import javax.persistence.EntityManager;
import java.util.List;

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
        AdminEntity adminEntity = new AdminEntity();
        AdminEntity admin = entityManager.find(AdminEntity.class, adminEntity.getId_user());
        return admin;
        }catch (Exception e){
            return null;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public List<AdminEntity> getAll() {
        try {
        entityManager.getTransaction().begin();
        List<AdminEntity> adminEntity = entityManager.createQuery("SELECT e FROM UserEntity e ").getResultList() ;
        return adminEntity;
        }catch (Exception e){
            return null;
        }finally {
            entityManager.close();
        }
    }
    @Override
    public AdminEntity update(AdminEntity admin) {

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
            AdminEntity adminEntity = new AdminEntity();
            AdminEntity admin = entityManager.find(AdminEntity.class, adminEntity.getId_user());
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
