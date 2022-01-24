package com.example.gestion_employer1.dao.implementation;

import com.example.gestion_employer1.dao.interfaces.EmployerDao;
import com.example.gestion_employer1.entity.EmployerEntity;
import com.example.gestion_employer1.utils.PersistenceManager;
import jakarta.persistence.EntityManager;
import java.util.List;

public class EmployerDaoImp implements EmployerDao {
    EntityManager entityManager = PersistenceManager.getInstance().getEntityManager();
    @Override
    public EmployerEntity add(EmployerEntity employer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(employer);
            entityManager.getTransaction().commit();
            return employer;
        }catch (Exception e){
            return null;
        }finally {
            entityManager.close();
        }
    }
    @Override
    public EmployerEntity find(Long id) {
        try {
            entityManager.getTransaction().begin();
            EmployerEntity employerEntity = new EmployerEntity();
            EmployerEntity employer = entityManager.find(EmployerEntity.class, employerEntity.getId_user());
            return employer;
        }catch (Exception e){
            return null;
        }finally {
            entityManager.close();
        }

    }
    @Override
    public List<EmployerEntity> getAll() {

        try {
            entityManager.getTransaction().begin();
            List<EmployerEntity> employerEntity = entityManager.createQuery("SELECT e FROM UserEntity e ").getResultList() ;
            return employerEntity;
        }catch (Exception e){
            return null;
        }finally {
            entityManager.close();
        }
    }
    @Override
    public EmployerEntity update(EmployerEntity employer) {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(employer);
            entityManager.getTransaction().commit();
            return employer;

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
            EmployerEntity employerEntity = new EmployerEntity();
            EmployerEntity employer = entityManager.find(EmployerEntity.class, employerEntity.getId_user());
            entityManager.remove(employer);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            return false;
        }finally {
            entityManager.close();
        }
    }
}

