// src/main/java/com/example/collegeapi/repository/CourseFeeRepository.java
package com.example.collegeapi.repository;

import com.example.collegeapi.model.CourseFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseFeeRepository extends JpaRepository<CourseFee, Long> {
}
