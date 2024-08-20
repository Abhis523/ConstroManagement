package com.constro.insyghts.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class ConstructionSiteDto {
    private Long id;
    private String name;
    private String location;
    private String description;
    private EmployeeDto siteInCharge;
}
