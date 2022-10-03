
import java.sql.Date;
import java.util.List;

import Dtos.CareerReportDto;
import Dtos.CareerWithInscriptionsDto;
import Dtos.StudentDto;
import Factories.Factory;
import Interfaces.ICareerRepository;
import Interfaces.ICityRepository;
import Interfaces.IStudentCareerRepository;
import Interfaces.IStudentRepository;
import Models.Career;
import Models.City;
import Models.Genre;
import Models.Student;
import Models.StudentCareer;

public class Main {
	
	static Factory factory;
	static IStudentRepository studentRepository;
	static ICityRepository cityRepository;
	static ICareerRepository careerRepository;
	static IStudentCareerRepository studentCareerRepository;
	
	public static void main(String[] args) {
		initialize(Factory.MYSQL);
		//initialize(Factory.DERBY);
		factory.getEntityManager().getTransaction().begin();
		
		serviceA();
		serviceB();
		serviceC();
		serviceD();
		serviceE();
		serviceF();
		serviceG();
		service3();
		
		factory.getEntityManager().getTransaction().commit();
		factory.getEntityManager().close();	
	}
	
	public static void initialize(int whichFactory){
		factory = Factory.getFactory(whichFactory);
		studentRepository = factory.getStudentRepository();
		cityRepository = factory.getCityRepository();
		careerRepository = factory.getCareerRepository();
		studentCareerRepository = factory.getStudentCareerRepository();
	}
	
	@SuppressWarnings("deprecation")
	public static void serviceA(){
		System.out.println("--------------Dar de alta un estudiante--------------") ;
		City cityNewStudent = cityRepository.getAll().get(0);
		Student newStudent = new Student("Name", "Surname", new Date(2000, 01, 01), Genre.Masculino, 30100200, cityNewStudent);
		studentRepository.save(newStudent);
		System.out.println("Estudiante agregado con exito!");
	}
	
	@SuppressWarnings("deprecation")
	public static void serviceB(){
		System.out.println("--------------Matricular un estudiante en una carrera--------------") ;
		Student studentService2 = studentRepository.getAll().get(0);
		Career careerService2 = careerRepository.getAll().get(0);
		StudentCareer studentCareer = new StudentCareer(studentService2, careerService2, new Date(2000,1,1), new Date(2005,1,1));
		studentCareerRepository.save(studentCareer);
	}
	
	public static void serviceC(){
		System.out.println("--------------Recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.(Apellido, nombre)--------------") ;
		List<Student> res = studentRepository.getStudentsOrderBySurname() ;
		res.forEach(d -> System.out.println(d));
	}
	
	public static void serviceD(){
		System.out.println("--------------Recuperar un estudiante, en base a su número de libreta universitaria.--------------") ;
		System.out.println(studentRepository.get(1));
	}
	
	public static void serviceE(){
		System.out.println("--------------Recuperar todos los estudiantes, en base a su género.--------------") ;
		Genre newGenre = Genre.Masculino;
		//Genre newGenre = Genre.Femenino;
		//Genre newGenre = Genre.NosabeNocontesta;
		List<Student> res = studentRepository.getStudentsByGenre(newGenre) ; 
		res.forEach(d -> System.out.println(d));
	}
	
	public static void serviceF(){
		System.out.println("--------------Recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.--------------") ;
		List<CareerWithInscriptionsDto> r = studentCareerRepository.careersSortedByStudents();
		r.forEach(d -> System.out.println(d));
	}
	
	public static void serviceG(){
		System.out.println("--------------Recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia--------------") ;
		List<StudentDto> studentDtos = studentRepository.getStudentsByCityAndCareer(1, 101);
		studentDtos.forEach(x -> System.out.println(x));
	}
	
	public static void service3(){
		System.out.println("-------------- Generar un reporte de las carreras, que para cada carrera incluya información de los\n"
				+ "inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar\n"
				+ "los años de manera cronológica.--------------") ;
		List<CareerReportDto> list = studentCareerRepository.careersInformationInscriptionsAndGraduates() ;
		list.forEach(x -> System.out.println(x));
	}

}
