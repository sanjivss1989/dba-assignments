package com.groomerx.service;

import com.groomerx.dto.AppointmentCreatedResponseDTO;
import com.groomerx.dto.AppointmentDTO;
import com.groomerx.dto.ScheduleDTO;
import com.groomerx.dto.ScheduleViewResponseDTO;

import java.util.List;

public interface IAppointmentService {

    AppointmentCreatedResponseDTO scheduleAppointment(AppointmentDTO appointmentDTO);

    void addEmployeeSchedule(ScheduleDTO scheduleDTO);

    List<ScheduleViewResponseDTO> viewSchedules();
}
