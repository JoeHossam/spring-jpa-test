package com.joehossam.springjpatest.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    private Long courseId;
    private String title;
    private Integer credit;

    @OneToOne(mappedBy = "course", fetch = FetchType.LAZY)
    private CourseMaterial courseMaterial;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
    private Teacher teacher;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course_map", joinColumns = @JoinColumn(referencedColumnName = "courseId", name = "course_id"), inverseJoinColumns = @JoinColumn(referencedColumnName = "studentId", name = "student_id"))
    private List<Student> students;
}
