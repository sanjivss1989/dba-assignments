package com.groomerx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder("schedules")
@Data
public class SchedulesViewAPIResponse {

    @JsonProperty("schedules")
    private List<ScheduleViewResponseDTO> schedules;
}
