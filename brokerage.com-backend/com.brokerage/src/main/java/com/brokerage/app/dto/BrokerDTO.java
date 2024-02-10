package com.brokerage.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BrokerDTO {

    @JsonProperty(value = "firstName")
    private String firstName;

    @JsonProperty(value = "lastName")
    private String lastName;

    @JsonProperty(value = "mobileNumber")
    private Long mobileNumber;

    @JsonProperty(value = "email")
    private String emailId;

    @JsonProperty(value = "password")
    private String password;
}
