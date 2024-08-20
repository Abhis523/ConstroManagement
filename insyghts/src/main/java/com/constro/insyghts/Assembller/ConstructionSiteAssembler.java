package com.constro.insyghts.Assembller;

import com.constro.insyghts.Dto.ConstructionSiteDto;
import com.constro.insyghts.Dto.EmployeeDto;
import com.constro.insyghts.Entity.ConstructionSite;
import com.constro.insyghts.Entity.Employee;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
public class ConstructionSiteAssembler {
    @Autowired
    private EmployeeAssembler employeeAssembler;

    public ConstructionSiteDto toDto(ConstructionSite site) {
        ConstructionSiteDto siteDto = new ConstructionSiteDto();
        siteDto.setId(site.getId());
        siteDto.setName(site.getName());
        siteDto.setLocation(site.getLocation());
        siteDto.setDescription(site.getDescription());
        siteDto.setSiteInCharge(employeeAssembler.toDto(site.getSiteInCharge()));
        return siteDto;
    }

    public ConstructionSite toEntity(ConstructionSiteDto siteDto) {
        ConstructionSite site = new ConstructionSite(); // Use the no-argument constructor
        site.setName(siteDto.getName());
        site.setLocation(siteDto.getLocation());
        site.setDescription(siteDto.getDescription());

        // Convert siteInCharge back to entity if it is not null
        if (siteDto.getSiteInCharge() != null) {
            Employee siteInCharge = employeeAssembler.toEntity(siteDto.getSiteInCharge());
            site.setSiteInCharge(siteInCharge);
        }

        return site;
    }
}
