
import java.sql.Date;
import java.util.List;

import Dtos.CareerWithInscriptionsDto;
import Dtos.StudentDto;
import Factories.Factory;
import Interfaces.ICareerRepository;
import Interfaces.ICityRepository;
import Interfaces.IStudentCareerRepository;
import Interfaces.IStudentRepository;
import Models.*;
import org.hibernate.internal.build.AllowSysOut;

public class Main {

	public static void main(String[] args) {
		var factory = Factory.getFactory(Factory.MYSQL);
		//var factory = Factory.getFactory(Factory.DERBY);

		IStudentRepository studentRepository = factory.getStudentRepository();
		ICityRepository cityRepository = factory.getCityRepository();
		ICareerRepository careerRepository = factory.getCareerRepository();
		IStudentCareerRepository studentCareerRepository = factory.getStudentCareerRepository();
		
		//Code for services 
		System.out.println("--------------Dar de alta un estudiante--------------") ;
		City cityNewStudent = cityRepository.getAll().get(0);
		Student newStudent = new Student("Name", "Surname", new Date(2000, 01, 01), Genre.Masculino, 30100200, cityNewStudent);
		studentRepository.save(newStudent);
	
		System.out.println("--------------Matricular un estudiante en una carrera--------------") ;
		Student studentService2 = studentRepository.getAll().get(0);
		Career careerService2 = careerRepository.getAll().get(0);
		StudentCareer studentCareer = new StudentCareer(studentService2, careerService2, new Date(2000,1,1), new Date(2005,1,1));
		//studentCareerRepository.save(studentCareer);

		System.out.println("--------------Recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.(Apellido, nombre)--------------") ;
		List<Student> res = studentRepository.getStudentsOrderBySurname() ;
		res.forEach(d -> System.out.println(d));

		System.out.println("--------------Recuperar un estudiante, en base a su número de libreta universitaria.--------------") ;
		System.out.println(studentRepository.get(1));

		System.out.println("--------------Recuperar todos los estudiantes, en base a su género.--------------") ;
		Genre newGenre = Genre.Masculino;
		System.out.println(studentRepository.getStudentsByGenre(newGenre));

		System.out.println("--------------Recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.--------------") ;
		List<CareerWithInscriptionsDto> r = studentCareerRepository.careersSortedByStudents();
		r.forEach(d -> System.out.println(d));

		System.out.println("--------------Recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia--------------") ;
		List<StudentDto> studentDtos = studentRepository.getStudentsByCityAndCareer(1, 1);
		studentDtos.forEach(x -> System.out.println(x));
		
		System.out.println("-------------- Generar un reporte de las carreras, que para cada carrera incluya información de los\n"
				+ "inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar\n"
				+ "los años de manera cronológica.--------------") ;
		System.out.println(studentCareerRepository.careersInformationInscriptionsAndGraduates());
	}

}
