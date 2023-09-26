package com.joehossam.springjpatest.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.joehossam.springjpatest.entity.Course;
import com.joehossam.springjpatest.entity.Guardian;
import com.joehossam.springjpatest.entity.Student;
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

    @Test
    public void findAllPagination() {
        PageRequest pageable = PageRequest.of(0, 2);
        // PageRequest pageable2 = PageRequest.of(1, 2);

        Page<Course> page = courseRepository.findAll(pageable);
        List<Course> pageContent = page.getContent();
        // List<Course> page2 = courseRepository.findAll(pageable2).getContent();

        Long totalElements = page.getTotalElements();
        int totalPages = page.getTotalPages();

        System.out.println(pageContent);
        System.out.println(totalElements);
        System.out.println(totalPages);
        // System.out.println(page2);
    }

    @Test
    public void findAllWithSorting() {
        PageRequest sortByTtile = PageRequest.of(0, 3, Sort.by("title").and(Sort.by("credit").descending()));

        Page<Course> pageTitle = courseRepository.findAll(sortByTtile);

        System.out.println(pageTitle.getContent());
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Guardian guardian = Guardian
                .builder()
                .name("Joe")
                .email("email")
                .mobile("123123")
                .build();

        Student student = Student
                .builder()
                .emailId("youssefhossamtestemailwithstuendetcoursemapper@gmail.com")
                .firstName("Joe")
                .lastName("Hossam")
                .guardian(guardian)
                .build();

        Teacher teacher = Teacher.builder().firstName("fnt1").lastName("lnt1").build();

        Course course = Course
                .builder()
                .title("New Course 4")
                .credit(123)
                .teacher(teacher)
                .students(List.of(student))
                .build();

        courseRepository.save(course);
    }
}
