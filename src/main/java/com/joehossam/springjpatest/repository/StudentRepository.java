package com.joehossam.springjpatest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.joehossam.springjpatest.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String firstName);

    public List<Student> findByLastNameNotNull();

    public List<Student> findByGuardianName(String name);

    public List<Student> findByGuardianMobileNotNull();

    public List<Student> findByGuardianMobileIsNull();

    public List<Student> findByGuardianIsNull();

    @Query("select s from Student s where s.guardian.email like %?1% or s.emailId like %?1%")
    public List<Student> getStudentByEmailOrGuestEmail(String email);

    @Modifying
    @Query(value = "update tbl_student set first_name = ?1 where email_address = ?2", nativeQuery = true)
    @Transactional
    public int updateStudentNameByEmailId(String firstName, String emailId);
}
