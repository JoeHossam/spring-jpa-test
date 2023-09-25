package com.joehossam.springjpatest.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.joehossam.springjpatest.entity.Teacher;

@SpringBootTest
public class TeacherRepositoryTest {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void createTeacher() {
        Teacher teacher = Teacher.builder().firstName("fnt1").lastName("lnt1").build();
        teacherRepository.save(teacher);

    }
}
