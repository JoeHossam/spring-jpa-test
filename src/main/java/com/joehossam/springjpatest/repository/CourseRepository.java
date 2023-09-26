package com.joehossam.springjpatest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.joehossam.springjpatest.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    public List<Course> findByTitle(String title);

    @Modifying
    @Query(value = "update", nativeQuery = true)
    public int assignTeacherToCourseById(Long teacherId);
}