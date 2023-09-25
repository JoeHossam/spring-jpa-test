package com.joehossam.springjpatest.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.joehossam.springjpatest.entity.Course;
import com.joehossam.springjpatest.entity.Teacher;

@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Test
    public void createNewCourse() {
        Course course = Course
                .builder()
                .title("New Course 2")
                .credit(12)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void printFindByTitle() {
        System.out.println(courseRepository.findByTitle("New Course 1"));
    }

    @Test
    public void printAll() {
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithCourseMaterial() {
        Teacher teacher = teacherRepository.findById(1L).get();

        Course course = Course
                .builder()
                .title("New Course 4")
                .credit(123)
                .teacher(teacher)
                .build();

        System.out.println(courseRepository.save(course));
    }
}
