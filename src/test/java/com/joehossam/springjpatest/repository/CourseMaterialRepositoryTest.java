package com.joehossam.springjpatest.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.joehossam.springjpatest.entity.Course;
import com.joehossam.springjpatest.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder().title("test").credit(6).build();
        CourseMaterial courseMaterial = CourseMaterial.builder().url("www.google.com").course(course).build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterial() {
        System.out.println(courseMaterialRepository.findAll());
    }
}
