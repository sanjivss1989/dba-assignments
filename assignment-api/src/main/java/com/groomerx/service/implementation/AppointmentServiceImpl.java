package com.groomerx.service.implementation;

import com.groomerx.dto.AppointmentCreatedResponseDTO;
import com.groomerx.dto.AppointmentDTO;
import com.groomerx.dto.ScheduleDTO;
import com.groomerx.dto.ScheduleViewResponseDTO;
import com.groomerx.repository.ScheduleRepository;
import com.groomerx.repository.entities.ScheduleEntity;
import com.groomerx.service.IAppointmentService;
import com.groomerx.service.mapper.DTOEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

    private ScheduleRepository scheduleRepository;

    @Autowired
    public AppointmentServiceImpl( ScheduleRepository scheduleRepository){
        this.scheduleRepository=scheduleRepository;
    }
    @Override
    public AppointmentCreatedResponseDTO scheduleAppointment(AppointmentDTO appointmentDTO) {

        return null;
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
