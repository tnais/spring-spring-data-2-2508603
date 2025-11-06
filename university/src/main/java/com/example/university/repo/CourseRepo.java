package com.example.university.repo;

import com.example.university.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {
  public Optional<Course> findByName(String name);

  public List<Course> findByPrerequisites(Course course);

  public List<Course> findByCredits(int credits);

  //Query from joined table field
  public List<Course> findByDepartmentChairMemberLastName(String chair);

}
