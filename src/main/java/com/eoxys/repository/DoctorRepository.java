package com.eoxys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eoxys.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {


}

