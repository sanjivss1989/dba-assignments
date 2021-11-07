package com.groomerx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonPropertyOrder({"appointmentID", "scheduledBy","assignedTo","clientName", "scheduledAt"})
public class AppointmentViewResponseDTO {

    @JsonProperty("appointmentID")
    private String appointmentID;

    @JsonProperty("scheduledBy")
    private String scheduledBy;

    @JsonProperty("assignedTo")
    private String assignedTo;

    @JsonProperty("clientName")
    private String clientName;

    @JsonProperty("scheduledAt")
    private String scheduledAt;
}
