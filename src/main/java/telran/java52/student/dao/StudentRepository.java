package telran.java52.student.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Set;
import java.util.stream.Stream;

import telran.java52.student.model.Student;
 
public interface StudentRepository extends MongoRepository<Student, Long > { 
	 Stream<Student> getAllBy();
	 
	 Stream<Student> findByNameIgnoreCase(String name);
	 
	 Long countByNameIn(Set<String> names);
	 
	 @Query("{'scores.?0' : {$gt: ?1}}")
	 Stream<Student> findByExamAndScoreGreaterThan(String exam, int score);
}
