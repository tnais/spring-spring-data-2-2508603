package com.example.university.business;

import com.example.university.domain.Course;
import com.example.university.repo.CourseQueryDslRepo;
import com.example.university.repo.CourseRepo;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class DynamicQueryService {

  private final CourseQueryDslRepo courseQueryDslRepo;
  private CourseRepo courseRepo;

  public DynamicQueryService(CourseRepo courseRepo, CourseQueryDslRepo courseQueryDslRepo) {
        this.courseRepo = courseRepo;
    this.courseQueryDslRepo = courseQueryDslRepo;
  }

  public List<Course> filterBySpecification(CourseFilter filter) {
    return courseRepo.findAll(filter.getSpecification());
  }

  public List<Course> filterByQueryDsl(CourseFilter filter) {
    List<Course> courses = new LinkedList<>();
    courseQueryDslRepo.findAll(filter.getQueryDslPredicate()).forEach(courses::add);
    return courses;
  }
}
