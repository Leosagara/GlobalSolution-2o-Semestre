package com.fiap.app.app.models.dto;

import java.time.LocalDate;

import com.fiap.app.app.models.Drone;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GarbageDto {

    @NotBlank(message = "O ID do Lixo não pode estar em branco")
    private Long garbageId;

    @NotBlank(message = "A latitude não pode estar em branco")
    @Min(value = -90, message = "A latitude deve ser maior ou igual a -90")
    @Max(value = 90, message = "A latitude deve ser menor ou igual a 90")
    private double latitude;

    @NotBlank(message = "A longitude não pode estar em branco")
    @Min(value = -180, message = "A longitude deve ser maior ou igual a -180")
    @Max(value = 180, message = "A longitude deve ser menor ou igual a 180")
    private double longitude;

    @NotBlank(message = "A profundidade não pode estar em branco")
    @Min(value = 0, message = "A profundidade deve ser maior ou igual a 0")
    private double depth;

    @NotBlank(message = "A data não pode estar em branco")
    private LocalDate date;

    @NotBlank(message = "O Lixo deve estar vinculado a algum Drone")
    private Drone drone;
}
