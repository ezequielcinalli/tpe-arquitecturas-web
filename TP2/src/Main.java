
import java.util.List;

import Dtos.CareerWithInscriptionsDto;
import Dtos.StudentDto;
import Factories.Factory;
import Interfaces.IStudentCareerRepository;
import Interfaces.IStudentRepository;
import Models.Genre;
import Models.Student;

public class Main {

	public static void main(String[] args) {
		
		var factory = Factory.getFactory(Factory.MYSQL);
		//var factory = Factory.getFactory(Factory.DERBY);

		IStudentRepository studentRepository = factory.getStudentRepository();
		IStudentCareerRepository studentCareerRepository = factory.getStudentCareerRepository();
		
		//Code for services 
		System.out.println("--------------Dar de alta un estudiante--------------") ;
	
		System.out.println("--------------Matricular un estudiante en una carrera--------------") ;

		System.out.println("--------------Recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.(Apellido, nombre)--------------") ;
		List<Student> res = studentRepository.getStudentsOrderBySurname() ;
		//res.forEach(d -> System.out.println(d));

		System.out.println("--------------Recuperar un estudiante, en base a su número de libreta universitaria.--------------") ;
		System.out.println(studentRepository.get(1));

		System.out.println("--------------Recuperar todos los estudiantes, en base a su género.--------------") ;
		//Genre newGenre = Genre.Femenino;
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
	}

}
