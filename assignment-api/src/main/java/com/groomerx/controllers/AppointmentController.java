package com.groomerx.controllers;

import com.groomerx.dto.*;
import com.groomerx.service.IAppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/groomerx/api")
@RestController
@Slf4j
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

    public ResponseEntity<AppointmentCreatedResponseDTO> createAppointment(AppointmentDTO appointmentDTO){
        return ResponseEntity.ok(null);
    }
}
