package com.groomerx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@JsonPropertyOrder({"id","employeeID","fromTime","toTime"})
@NoArgsConstructor
public class ScheduleViewResponseDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("employeeID")
    private String employeeID;

    @JsonProperty("fromTime")
    private String fromTime;

    @JsonProperty("toTime")
    private String toTime;
}
