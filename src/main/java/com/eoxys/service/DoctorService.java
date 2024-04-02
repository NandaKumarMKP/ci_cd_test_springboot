package com.eoxys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.eoxys.dto.APIResponse;
import com.eoxys.model.Doctor;
import com.eoxys.repository.DoctorRepository;

@Service
public class DoctorService {

//	@Autowired
//	private WebSocketHandler webSocketHandler;

	@Autowired
	private DoctorRepository doctorRepo;
	
	@Autowired
	SimpMessagingTemplate template;

	public ResponseEntity<APIResponse> getAllDoctors() {
		List<Doctor> doctorList = doctorRepo.findAll();
		APIResponse apiResponse = new APIResponse();
		apiResponse.setData(doctorList);
		apiResponse.setStatus(true);
		apiResponse.setMessage("Successfully Queried");
//		template.convertAndSend("/topic/doctors", doctorList);
//		webSocketHandler.broadcastMessage("Entity update message");
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}
	
	public ResponseEntity<APIResponse> addDoctor(Doctor doctor) {
		APIResponse apiResponse = new APIResponse();
		try {
			Doctor savedDoctor = doctorRepo.save(doctor);
			apiResponse.setData(savedDoctor);
			apiResponse.setStatus(true);
			apiResponse.setMessage("Doctor Added succesfully");
			List<Doctor> doctorList = doctorRepo.findAll();
			template.convertAndSend("/topic/doctors", doctorList);// Customize message as needed
//			template.convertAndSend("/topic/message", "Entity update message");
//			webSocketHandler.broadcastMessage("Entity update message");
			return new ResponseEntity<APIResponse>(apiResponse,HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("error" + e);
			apiResponse.setStatus(false);
			apiResponse.setMessage("Doctor Not Added succesfully");
			return new ResponseEntity<APIResponse>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
