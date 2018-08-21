package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

  @Autowired
  CourseRepository courseRepository;

  @Test
  public void findCourse() {
    Course course1 = new Course();
    course1.setTitle("Math101");
    course1.setInstructor("Fi Hills");
    course1.setDescription("Here is the description");
    course1.setCredit(4);
    courseRepository.save(course1);
    assertEquals(courseRepository.findById(1L).get().getTitle()
            , "Math101");
  }

  @Test
  public void updateCourse() {
    Course course2 = new Course();
    course2.setTitle("Math102");
    course2.setInstructor("Dave Hills");
    course2.setDescription("Here is the description");
    course2.setCredit(3);
    courseRepository.save(course2);
    assertEquals(courseRepository.findAllById(1L).getId(), course2.getId());
  }

  @Test
  public void deleteCourse() {
    Course course3 = new Course();
    course3.setTitle("Math103");
    course3.setInstructor("Chi Hills");
    course3.setDescription("Here is the description");
    course3.setCredit(3);
    courseRepository.save(course3);
    courseRepository.deleteById(1L);
    assertEquals(courseRepository.findById(1L), Optional.empty());
  }

//  @Test
//  public void deleteCourse() {
//    Course course3 = new Course("Math103", "Alton Hills",
//            "Here is the " +
//                    "description", 4 );
//    courseRepository.save(course3);
//    courseRepository.deleteById(1L);
//    assertEquals(courseRepository.findById(1L), Optional.empty());
//  }

//  @Test
//  public void updateCourse() {
//    Course course2 = new Course("Math102", "Dave Hills",
//            "Here is the " +
//            "description", 3 );
//    courseRepository.save(course2);
//    assertEquals(courseRepository.findAllById(1L).getId(), course2.getId());
//  }




}
