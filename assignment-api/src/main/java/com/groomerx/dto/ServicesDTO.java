package com.groomerx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@JsonPropertyOrder({"id","serviceName","duration","price"})
public class ServicesDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("serviceName")
    private String serviceName;

    @JsonProperty("duration")
    private int duration;

    @JsonProperty("price")
    private Double price;
}
