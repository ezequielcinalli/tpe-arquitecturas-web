package Factories;

import javax.persistence.EntityManager;

import Interfaces.ICareerRepository;
import Interfaces.ICityRepository;
import Interfaces.IStudentCareerRepository;
import Interfaces.IStudentRepository;

public abstract class Factory {
	
	public static final int MYSQL = 1;
	public static final int DERBY = 2;
	
	public static Factory getFactory(int whichFactory) {
		switch (whichFactory) {
			case MYSQL: 
				return new MySqlFactory();
			case DERBY: 
				return new DerbyFactory();
			default: return null;
		}
	}
    
	public abstract EntityManager getEntityManager();
	public abstract ICareerRepository getCareerRepository();
	public abstract ICityRepository getCityRepository();
	public abstract IStudentCareerRepository getStudentCareerRepository();
	public abstract IStudentRepository getStudentRepository();
    
}
