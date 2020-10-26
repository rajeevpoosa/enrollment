package com.enrollment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enrollment.entity.Dependents;

@Repository
public interface DependentsRepository extends JpaRepository<Dependents, Integer> {

}
