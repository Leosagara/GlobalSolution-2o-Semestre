package com.fiap.app.app.models.dto;

import java.util.List;

import com.fiap.app.app.models.Garbage;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DroneDto {

    @NotBlank(message = "O ID do drone não pode estar em branco")
    @Size(max = 10, message = "O ID do drone deve ter no máximo 10 caracteres")
    private Long droneId;
    
    @NotBlank(message = "O tipo do drone não pode estar em branco")
    @Size(max = 20, message = "O tipo do drone deve ter no máximo 20 caracteres")
    private String type;

    @NotBlank(message = "A localização do drone não pode estar em branco")
    @Size(max = 30, message = "A localização do drone deve ter no máximo 20 caracteres")   
    private String location;

    @OneToMany(mappedBy = "drone")
    private List<Garbage> garbageList;
}
