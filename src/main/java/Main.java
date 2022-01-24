import com.example.gestion_employer1.utils.PersistenceManager;

import jakarta.persistence.EntityManager;

public class Main {
    public static void main (String[] args){

        EntityManager entityManager = PersistenceManager.getInstance().getEntityManager();


    }
}
