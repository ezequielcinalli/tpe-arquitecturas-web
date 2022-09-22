package Connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MySql");
	static EntityManager entityManager;

	public static EntityManager getConnection() {
		if (entityManager != null) {
			return entityManager;
		}
		EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
}
