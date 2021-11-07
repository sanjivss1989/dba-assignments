package com.groomerx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@Data
@NoArgsConstructor
@JsonPropertyOrder({"appointments"})
public class AppointmentListViewDTO {

    @JsonProperty("appointments")
    private List<AppointmentViewResponseDTO> appointmentViewResponseDTOList;
}
