package Factories;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import Interfaces.ICareerRepository;
import Interfaces.ICityRepository;
import Interfaces.IStudentCareerRepository;
import Interfaces.IStudentRepository;
import Repositories.CareerRepository;
import Repositories.CityRepository;
import Repositories.StudentCareerRepository;
import Repositories.StudentRepository;

public class MySqlFactory extends Factory {
	
	private static EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		if (entityManager != null) {
			return entityManager;
		}
		var entityManagerFactory = Persistence.createEntityManagerFactory("MySql");
		entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
	}

	@Override
	public ICareerRepository getCareerRepository() {
		return new CareerRepository(this.getEntityManager());
	}

	@Override
	public ICityRepository getCityRepository() {
		return new CityRepository(this.getEntityManager());
	}

	@Override
	public IStudentCareerRepository getStudentCareerRepository() {
		return new StudentCareerRepository(this.getEntityManager());
	}

	@Override
	public IStudentRepository getStudentRepository() {
		return new StudentRepository(this.getEntityManager());
	}

}
