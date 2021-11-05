package com.groomerx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonPropertyOrder({"employeeCreated","employeeID","clientName","clientContact","clientEmail","services","startTime","endTime","endTimeExpected",
"discount"})
public class AppointmentDTO {

    @JsonProperty("employeeCreated")
    private String employeeCreated;

    @JsonProperty("employeeID")
    private String employeeID;

    @JsonProperty("clientName")
    private String clientName;

    @JsonProperty("clientContact")
    private String clientContact;

    @JsonProperty("clientEmail")
    private String clientEmail;

    @JsonProperty("services")
    private List<ServicesDTO> services;

    @JsonProperty("startTime")
    private String startTime;

    @JsonProperty("endTime")
    private String endTime;

    @JsonProperty("endTimeExpected")
    private String endTimeExpected;

    @JsonProperty("discount")
    private String discount;

}
