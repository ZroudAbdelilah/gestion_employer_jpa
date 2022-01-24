package com.example.gestion_employer1.utils;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceManager{

    public EntityManager getEntityManager(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionEmployer");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return  entityManager;
    }

    public  static PersistenceManager getInstance(){
        return new PersistenceManager();
    }
}