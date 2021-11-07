package com.groomerx.service.mapper;

import com.groomerx.dto.*;
import com.groomerx.repository.entities.AppointmentEntity;
import com.groomerx.repository.entities.ClientEntity;
import com.groomerx.repository.entities.ScheduleEntity;
import com.groomerx.repository.entities.ServicesBookedEntity;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public static AppointmentEntity getAppointmentEntity(AppointmentDTO appointmentDTO){
        AppointmentEntity appointmentEntity = new AppointmentEntity();
        //appointmentEntity.setDate_created(new Timestamp(new Date().getTime()));
        appointmentEntity.setCreatedBy(Integer.parseInt(appointmentDTO.getEmployeeCreated()));
        appointmentEntity.setEmployeeID(Integer.parseInt(appointmentDTO.getEmployeeID()));
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setName(appointmentDTO.getClientName());
        clientEntity.setContact(appointmentDTO.getClientContact());
        clientEntity.setEmail(appointmentDTO.getClientEmail());
        appointmentEntity.setClientEntity(clientEntity);
        appointmentEntity.setClientName(appointmentDTO.getClientName());
        appointmentEntity.setClientContact(appointmentDTO.getClientContact());
        appointmentEntity.setServicesBookedEntityList(mapServicesBookedEntity(appointmentEntity,appointmentDTO.getServices()));
        appointmentEntity.setStartTime(parseDateTime(appointmentDTO.getStartTime()));
        appointmentEntity.setEndTime(parseDateTime(appointmentDTO.getEndTime()));
        appointmentEntity.setEndTimeExpected(parseDateTime(appointmentDTO.getEndTimeExpected()));
        appointmentEntity.setDiscount(Double.parseDouble(appointmentDTO.getDiscount()));
        appointmentEntity.setPriceExpected(calculateEstimatedPrice(appointmentDTO.getServices()));
        appointmentEntity.setPriceFull(calculateFullPrice(appointmentDTO.getServices()));
        appointmentEntity.setPriceFinal(calculateFinalPriceDiscounted(appointmentDTO.getServices(),appointmentEntity.getDiscount()));
        return appointmentEntity;
    }

    private static List<ServicesBookedEntity> mapServicesBookedEntity(AppointmentEntity appointmentEntity,List<ServicesDTO> servicesDTOList){
        List<ServicesBookedEntity> servicesBookedEntityList = new ArrayList<>();
        ServicesBookedEntity entity=null;
        for(ServicesDTO servicesDTO:servicesDTOList){
            entity = new ServicesBookedEntity();
            entity.setAppointmentEntity(appointmentEntity);
            entity.setServiceID(servicesDTO.getId());
            entity.setPrice(servicesDTO.getPrice());
           servicesBookedEntityList.add(entity);
        }
        return servicesBookedEntityList;
    }

    public static List<AppointmentViewResponseDTO> getAllAppointments(List<AppointmentEntity> entities){
        List<AppointmentViewResponseDTO> appointmentViewResponseDTOList = new ArrayList<>();
        AppointmentViewResponseDTO dto =null;
         for(AppointmentEntity entity: entities){
             dto = new AppointmentViewResponseDTO();
             dto.setAppointmentID(String.valueOf(entity.getId()));
             dto.setScheduledBy(String.valueOf(entity.getCreatedBy()));
             dto.setAssignedTo(String.valueOf(entity.getEmployeeID()));
             dto.setClientName(entity.getClientName());
             dto.setScheduledAt(entity.getStartTime().toString());
             appointmentViewResponseDTOList.add(dto);
         }
         return appointmentViewResponseDTOList ;
    }

    public static AppointmentViewResponseDTO getDetails(AppointmentEntity entity){
        AppointmentViewResponseDTO responseDTO = new AppointmentViewResponseDTO();
        responseDTO.setScheduledBy(String.valueOf(entity.getCreatedBy()));
        responseDTO.setAppointmentID(String.valueOf(entity.getId()));
        responseDTO.setAssignedTo(String.valueOf(entity.getEmployeeID()));
        responseDTO.setClientName(entity.getClientName());
        responseDTO.setScheduledAt(entity.getStartTime().toString());
        return responseDTO;
    }

    private static Double calculateFullPrice(List<ServicesDTO> servicesDTOList){
        Double sum = 0.0;
        for(ServicesDTO servicesDTO: servicesDTOList){
            sum = sum+servicesDTO.getPrice();
        }
        return sum;
    }

    private static Double calculateEstimatedPrice(List<ServicesDTO> servicesDTOList){
        Double roundedOff = 100.00;
        return calculateFullPrice(servicesDTOList)+roundedOff;
    }

    private static Double calculateFinalPriceDiscounted(List<ServicesDTO> servicesDTOList,Double discount){
       Double fullPrice = calculateFullPrice(servicesDTOList);
       Double finalPrice = fullPrice - (fullPrice*discount/100);
       return finalPrice;
    }
}
