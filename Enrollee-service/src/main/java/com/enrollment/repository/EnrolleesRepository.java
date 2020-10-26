package com.enrollment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enrollment.entity.Enrollees;

public interface EnrolleesRepository extends JpaRepository<Enrollees, Integer> {

}
