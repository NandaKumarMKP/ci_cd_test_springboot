package com.eoxys.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eoxys.dto.APIResponse;
import com.eoxys.model.Doctor;
import com.eoxys.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@GetMapping("/doctors")
	public ResponseEntity<APIResponse> listAllDevices() throws IOException {
		return doctorService.getAllDoctors();
	}

	@PostMapping("/add")
	public ResponseEntity<APIResponse> addDoctor(@RequestBody Doctor doctor) {
		return doctorService.addDoctor(doctor);
	}

}
