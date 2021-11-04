package com.groomerx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@JsonPropertyOrder({"employeeID","fromTime","toTime"})
public class ScheduleDTO {

    @JsonProperty("employeeID")
    private String employeeID;

    @JsonProperty("fromTime")
    private String fromTime;

    @JsonProperty("toTime")
    private String toTime;

}
