package Repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Dtos.CareerReportDto;
import Dtos.CareerWithInscriptionsDto;
import Interfaces.IStudentCareerRepository;
import Models.Career;
import Models.StudentCareer;

public class StudentCareerRepository implements IStudentCareerRepository {

	private EntityManager entityManager;
	
	public StudentCareerRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public StudentCareer get(int id) {
		return entityManager.find(StudentCareer.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentCareer> getAll() {
		return (List<StudentCareer>) entityManager.createQuery("SELECT sc FROM StudentCareer sc").getResultList();
	}

	@Override
	public void save(StudentCareer t) {
		entityManager.persist(t);
	}

	@Override
	public void update(StudentCareer t) {
		entityManager.merge(t);
	}

	@Override
	public void delete(StudentCareer t) {
		entityManager.remove(entityManager.contains(t) ? t : entityManager.merge(t));
	}
	

	public List<CareerWithInscriptionsDto> careersSortedByStudents(){
		TypedQuery<CareerWithInscriptionsDto> result =  entityManager.createQuery("SELECT new Dtos.CareerWithInscriptionsDto(c.name,COUNT(sc.student)) FROM StudentCareer sc JOIN sc.career c GROUP BY sc.career.id ORDER BY count(sc.student.id)",CareerWithInscriptionsDto.class);
		return result.getResultList();
	}

	public List<CareerReportDto> careersInformationInscriptionsAndGraduates(){
		
		List<CareerReportDto> careerReportDtos = new ArrayList<CareerReportDto>();
		
		@SuppressWarnings("unchecked")
		List<Integer> years = entityManager.createNativeQuery("""
			    SELECT DISTINCT YEAR(signUpDate) as yearOutput FROM StudentCareer
				UNION
				SELECT DISTINCT YEAR(graduationDate) as yearOutput FROM StudentCareer WHERE graduationDate is not null
				ORDER BY yearOutput
			    """)
			.getResultList();
		
		List<Career> careers = entityManager.createQuery("SELECT c FROM Career c order by c.name", Career.class).getResultList();
		
		for(int year: years) {
			for (Career career : careers) {
				CareerReportDto careerReportDto = new CareerReportDto(career.getName(), year);
				
				TypedQuery<String> enrolledStudentsQuery = entityManager.createQuery("""
						SELECT CONCAT(s.name, ' ', s.surname) 
						FROM Student s
						JOIN StudentCareer sc ON s.id = sc.key.studentId 
						WHERE sc.key.careerId = :careerId AND YEAR(sc.signUpDate) = :year
					""", String.class);
				enrolledStudentsQuery.setParameter("careerId", career.getId());
				enrolledStudentsQuery.setParameter("year", year);
				List<String> enrolledStudents = enrolledStudentsQuery.getResultList();
				
				TypedQuery<String> graduatedStudentsQuery = entityManager.createQuery("""
						SELECT CONCAT(s.name, ' ', s.surname) 
						FROM Student s
						JOIN StudentCareer sc ON s.id = sc.key.studentId 
						WHERE sc.key.careerId = :careerId AND YEAR(sc.graduationDate) = :year
					""", String.class);
				graduatedStudentsQuery.setParameter("careerId", career.getId());
				graduatedStudentsQuery.setParameter("year", year);
				List<String> graduatedStudents = graduatedStudentsQuery.getResultList();
				
				if(enrolledStudents.isEmpty() && graduatedStudents.isEmpty())
					continue;
				
				careerReportDto.setEnrolled(enrolledStudents);
				careerReportDto.setGraduated(graduatedStudents);
				
				careerReportDtos.add(careerReportDto);
			}
		}
		
		return careerReportDtos;
	}
}
