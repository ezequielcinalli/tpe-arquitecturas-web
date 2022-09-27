package Repositories;

import java.util.List;

import javax.persistence.EntityManager;

import Interfaces.ICityRepository;
import Models.City;

public class CityRepository implements ICityRepository {
	
EntityManager entityManager;
	
	
	public CityRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public City get(int id) {
		return entityManager.find(City.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<City> getAll() {
		return (List<City>) entityManager.createQuery("SELECT c FROM city c").getResultList();
	}

	@Override
	public void save(City t) {
		entityManager.persist(t);	
	}

	@Override
	public void update(City t) {
		entityManager.merge(t);
	}

	@Override
	public void delete(City t) {
		entityManager.remove(entityManager.contains(t) ? t : entityManager.merge(t));
	}

}
