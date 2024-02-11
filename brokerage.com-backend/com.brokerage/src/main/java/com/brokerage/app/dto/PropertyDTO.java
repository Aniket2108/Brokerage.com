package com.brokerage.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PropertyDTO {

    @JsonProperty(value = "address")
    private String address;

    @JsonProperty(value = "bathroom")
    private int bathroom;

    @JsonProperty(value = "bedroom")
    private int bedroom;

    @JsonProperty(value = "brokerage")
    private int brokerage;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "propertyType")
    private String propertyType;

    @JsonProperty(value = "rent")
    private int rent;

    @JsonProperty(value = "surface")
    private int surface;
}
