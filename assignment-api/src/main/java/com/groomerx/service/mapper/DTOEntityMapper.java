package com.groomerx.service.mapper;

import com.groomerx.dto.ScheduleDTO;
import com.groomerx.dto.ScheduleViewResponseDTO;
import com.groomerx.repository.entities.ScheduleEntity;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class DTOEntityMapper {

    public static ScheduleEntity getScheduleEntity(ScheduleDTO scheduleDTO){
      ScheduleEntity scheduleEntity = new ScheduleEntity();
      scheduleEntity.setEmployeeID(Integer.parseInt(scheduleDTO.getEmployeeID()));
      scheduleEntity.setFromTime(parseDateTime(scheduleDTO.getFromTime()));
      scheduleEntity.setToTime(parseDateTime(scheduleDTO.getToTime()));
      return scheduleEntity;
    }

    private static Timestamp parseDateTime(String value){
        StringBuilder sb = new StringBuilder(value);
        sb.append(":00.12345678");
        return Timestamp.valueOf(sb.toString());
    }

    public static ScheduleViewResponseDTO getScheduleDTO(ScheduleEntity scheduleEntity){
        ScheduleViewResponseDTO scheduleDTO = new ScheduleViewResponseDTO();
        scheduleDTO.setId(String.valueOf(scheduleEntity.getId()));
        scheduleDTO.setEmployeeID(String.valueOf(scheduleEntity.getEmployeeID()));
        scheduleDTO.setFromTime(scheduleEntity.getFromTime().toString());
        scheduleDTO.setToTime(scheduleEntity.getToTime().toString());
        return scheduleDTO;
    }
}
