package com.groomerx.controllers;

import com.groomerx.dto.*;
import com.groomerx.service.IAppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping(value = "/groomerx/api")
@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentController {

    private IAppointmentService service;

    @Autowired
    public AppointmentController(IAppointmentService service) {
        this.service = service;
    }

    @PostMapping(value = "/v1/schedule")
    public ResponseEntity<String> addEmployeeSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        service.addEmployeeSchedule(scheduleDTO);
        return ResponseEntity.ok("Schedule Created successfully");
    }

    @GetMapping(value = "/v1/schedules")
    public ResponseEntity<SchedulesViewAPIResponse> viewSchedules(){
        SchedulesViewAPIResponse apiResponse = new SchedulesViewAPIResponse();
        apiResponse.setSchedules(service.viewSchedules());
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping(value = "/v1/appointment")
    public ResponseEntity<AppointmentCreatedResponseDTO> createAppointment(@RequestBody AppointmentDTO appointmentDTO){
        AppointmentCreatedResponseDTO responseDTO = service.scheduleAppointment(appointmentDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "/v1/appointments")
    public ResponseEntity<AppointmentListViewDTO> browseAppointments(){
        AppointmentListViewDTO apiResponse = new AppointmentListViewDTO();
        apiResponse.setAppointmentViewResponseDTOList(service.browseAppointments());
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping(value = "/v1/appointments/{id}")
    public ResponseEntity<AppointmentSingleViewDTO> searchAppointment(@PathVariable Integer id){
        System.out.println("integercc==>"+id);
        AppointmentSingleViewDTO apiResponse = new AppointmentSingleViewDTO();
        apiResponse.setAppointment(service.searchAppointment(id));
        return ResponseEntity.ok(apiResponse);
    }


}
