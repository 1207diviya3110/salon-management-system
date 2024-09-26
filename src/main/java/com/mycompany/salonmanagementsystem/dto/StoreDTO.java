package com.mycompany.salonmanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreDTO {
    private Long id;
    @NotEmpty(message = "Name should not be empty")
    @NotNull(message = "Name should not be null")
    private String name;
    @NotEmpty(message = "Email should not be empty")
    @NotNull(message = "Email should not be null")
    private String email;
    @NotEmpty(message = "Phone should not be empty")
    @NotNull(message = "Phone should not be null")
    private String phone;
    @NotEmpty(message = "Password should not be empty")
    @NotNull(message = "Password should not be null")
    private String password;
    @NotEmpty(message = "Street should not be empty")
    @NotNull(message = "Street should not be null")
    private String street;
    private String city;
    private String country;
    @NotEmpty(message = "Pincode should not be empty")
    @NotNull(message = "Pincode should not be null")
    private String pincode;
}
