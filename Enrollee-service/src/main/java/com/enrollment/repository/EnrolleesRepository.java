package com.enrollment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enrollment.entity.Enrollees;

@Repository
public interface EnrolleesRepository extends JpaRepository<Enrollees, Integer> {

}
