package com.example.gestion_employer1.dao.implementation;

import com.example.gestion_employer1.dao.interfaces.RoleDao;
import com.example.gestion_employer1.entity.EmployerEntity;
import com.example.gestion_employer1.entity.RoleEntity;
import com.example.gestion_employer1.utils.PersistenceManager;
//import org.hibernate.Session;

import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImp implements RoleDao {
    EntityManager entityManager = PersistenceManager.getInstance().getEntityManager();
    @Override
    public RoleEntity add(RoleEntity role) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(role);
            entityManager.getTransaction().commit();
            return role;
        }catch (Exception e){
            return null;
        }finally {
            entityManager.close();
        }
    }


    @Override
    public RoleEntity find(Long id) {
        try {
            entityManager.getTransaction().begin();
            RoleEntity role = entityManager.find(RoleEntity.class, id);
            return role;
        }catch (Exception e){
            return null;
        }finally {
            entityManager.close();
        }

    }
    @Override
    public ArrayList<RoleEntity> getAll() {
        try {
            entityManager.getTransaction().begin();
            ArrayList<RoleEntity> roleEntity = new ArrayList<>(entityManager.createQuery("SELECT e FROM RoleEntity e ").getResultList());
            return roleEntity;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            entityManager.close();
        }
    }


    @Override
    public RoleEntity update(RoleEntity role) {

        try{
            entityManager.getTransaction().begin();
            entityManager.merge(role);
            entityManager.getTransaction().commit();
            return role;

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
            RoleEntity role = entityManager.find(RoleEntity.class,id);
            entityManager.remove(role);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            return false;
        }finally {
            entityManager.close();
        }
    }
}
