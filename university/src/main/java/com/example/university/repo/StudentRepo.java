package com.example.university.repo;

import com.example.university.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

  //Simple Query By Attribute
  List<Student> findByFullTime(boolean fullTime);

  List<Student> findByAge(Integer age);

  //Query by nested attribute
  List<Student> findByAttendeeLastName(String lastName);

}
