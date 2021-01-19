package by.task.resliv.dto;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
public class CityDto {

    private Long id;

    @NotBlank
    @Size(min = 1, max = 50)
    private String city;

    @NotBlank
    @Size(min = 1, max = 50)
    private String recommendation;
}
