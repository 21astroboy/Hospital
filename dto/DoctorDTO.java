package com.example.hospital.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class DoctorDTO {
    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[А-Яа-яЁ\\-]+$\n")
    private String fullname;
    @NotNull
    @NotEmpty
    private String position;
    private Integer experience;
    private Boolean isDirector;
    @Pattern(regexp = "^(\\+7|7|8)?[\\s\\-]?\\(?[489][0-9]{2}\\)?[\\s\\-]?[0-9]{3}[\\s\\-]?[0-9]{2}[\\s\\-]?[0-9]{2}$")
    private String workNumber;

}
