package ru.gb.homework7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.hm7.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {}