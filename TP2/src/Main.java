import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Models.Student;
import Repositories.StudentRepository;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MySql");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		StudentRepository studentRepository = new StudentRepository(entityManager);

		//Code for services 
		System.out.println("--------------Dar de alta un estudiante--------------") ;
	
		System.out.println("--------------Matricular un estudiante en una carrera--------------") ;

		System.out.println("--------------Recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.(Apellido, nombre)--------------") ;
		List<Student> res = studentRepository.getStudentsOrderBySurname() ;
		res.forEach(d -> System.out.println(d));

		System.out.println("--------------Recuperar un estudiante, en base a su número de libreta universitaria.--------------") ;
		System.out.println(studentRepository.get(1));

		System.out.println("--------------Recuperar todos los estudiantes, en base a su género.--------------") ;

		System.out.println("--------------Recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.--------------") ;

		System.out.println("--------------Recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia--------------") ;

		System.out.println("-------------- Generar un reporte de las carreras, que para cada carrera incluya información de los\n"
				+ "inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar\n"
				+ "los años de manera cronológica.--------------") ;
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
