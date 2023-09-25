package com.joehossam.springjpatest.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.joehossam.springjpatest.entity.Guardian;
import com.joehossam.springjpatest.entity.Student;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student
                .builder()
                .emailId("youssefhoss@gmail.com")
                .firstName("Joe")
                .lastName("Hossam")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardianDetails() {
        Guardian guardian = Guardian
                .builder()
                .name("Joe")
                .email("email")
                .mobile("123123")
                .build();

        Student student = Student
                .builder()
                .emailId("youssefhossamguardian@gmail.com")
                .firstName("Joe")
                .lastName("Hossam")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> student = studentRepository.findByFirstName("Joe");
        System.out.println(student);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> student = studentRepository.findByFirstNameContaining("J");
        System.out.println(student);
    }

    @Test
    public void printStudentByGuardianName() {
        List<Student> student = studentRepository.findByGuardianName("joe");
        System.out.println(student);
    }

    @Test
    public void printStudentByGuardianMobileNotNull() {
        List<Student> student = studentRepository.findByGuardianMobileNotNull();
        System.out.println(student);
    }

    @Test
    public void printStudentByGuardianMobileIsNull() {
        List<Student> student = studentRepository.findByGuardianMobileIsNull();
        System.out.println(student);
    }

    @Test
    public void getStudentByEmailOrGuestEmail() {
        List<Student> student = studentRepository.getStudentByEmailOrGuestEmail("@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentByGuardianIsNull() {
        List<Student> student = studentRepository.findByGuardianIsNull();
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId("new joe", "youssefhoss@gmail.com");
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("Students => " + studentList);
    }
}
