package connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaPersistence {

    private EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("exemplo_jpa");

    private EntityManager entityManager;

    public EntityManager getEntityManager() {
      if( entityManager == null){
          entityManager = entityManagerFactory.createEntityManager();
      }
        return entityManager;
    }
}
