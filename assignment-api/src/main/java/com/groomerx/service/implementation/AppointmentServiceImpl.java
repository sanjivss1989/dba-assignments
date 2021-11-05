package com.groomerx.service.implementation;

import com.groomerx.dto.AppointmentCreatedResponseDTO;
import com.groomerx.dto.AppointmentDTO;
import com.groomerx.dto.ScheduleDTO;
import com.groomerx.dto.ScheduleViewResponseDTO;
import com.groomerx.repository.AppointmentRepository;
import com.groomerx.repository.ScheduleRepository;
import com.groomerx.repository.entities.AppointmentEntity;
import com.groomerx.repository.entities.ScheduleEntity;
import com.groomerx.service.IAppointmentService;
import com.groomerx.service.mapper.DTOEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

    private final ScheduleRepository scheduleRepository;
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(ScheduleRepository scheduleRepository, AppointmentRepository appointmentRepository){
        this.scheduleRepository=scheduleRepository;
        this.appointmentRepository = appointmentRepository;
    }
    @Override
    public AppointmentCreatedResponseDTO scheduleAppointment(AppointmentDTO appointmentDTO) {
        AppointmentEntity entity = appointmentRepository.save(DTOEntityMapper.getAppointmentEntity(appointmentDTO));
        AppointmentCreatedResponseDTO obj = new AppointmentCreatedResponseDTO();
        obj.setAppointmentID(String.valueOf(entity.getId()));
        return obj;
    }

    @Override
    public void addEmployeeSchedule(ScheduleDTO scheduleDTO) {
      scheduleRepository.save(DTOEntityMapper.getScheduleEntity(scheduleDTO));
    }

    @Override
    public List<ScheduleViewResponseDTO> viewSchedules() {
        List<ScheduleEntity> scheduleEntityList = scheduleRepository.findAll();
        List<ScheduleViewResponseDTO> scheduleViewResponseDTOS = new ArrayList<>();
        for(ScheduleEntity entity: scheduleEntityList){
            scheduleViewResponseDTOS.add(DTOEntityMapper.getScheduleDTO(entity));
        }
        return scheduleViewResponseDTOS;
    }
}
