package com.groomerx.service;

import com.groomerx.dto.*;

import java.util.List;

public interface IAppointmentService {

    AppointmentCreatedResponseDTO scheduleAppointment(AppointmentDTO appointmentDTO);

    void addEmployeeSchedule(ScheduleDTO scheduleDTO);

    List<ScheduleViewResponseDTO> viewSchedules();

    List<AppointmentViewResponseDTO> browseAppointments();

    AppointmentViewResponseDTO searchAppointment(Integer id);
}
