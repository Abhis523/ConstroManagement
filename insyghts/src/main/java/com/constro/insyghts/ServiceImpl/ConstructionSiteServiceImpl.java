package com.constro.insyghts.ServiceImpl;

import com.constro.insyghts.Assembller.EmployeeAssembler;
import com.constro.insyghts.Dto.ConstructionSiteDto;
import com.constro.insyghts.Entity.ConstructionSite;
import com.constro.insyghts.Entity.Employee;
import com.constro.insyghts.Repository.ConstructionSiteRepository;
import com.constro.insyghts.Repository.EmployeeRepository;
import com.constro.insyghts.Service.ConstructionSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.constro.insyghts.Assembller.ConstructionSiteAssembler;

import java.util.Optional;

@Service
public class ConstructionSiteServiceImpl implements ConstructionSiteService {

    @Autowired
    private ConstructionSiteRepository siteRepository;

    @Autowired
    private ConstructionSiteAssembler siteAssembler;

    @Autowired
    private EmployeeAssembler employeeAssembler;

    @Override
    public ConstructionSiteDto getSiteById(Long id) {
        ConstructionSite site = siteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Site not found"));
        return siteAssembler.toDto(site);
    }

    @Override
    public ConstructionSiteDto createSite(ConstructionSiteDto siteDto) {
        if (siteRepository.findByName(siteDto.getName()).isPresent()) {
            throw new RuntimeException("Site already exists with this name");
        }
        ConstructionSite site = siteAssembler.toEntity(siteDto);
        ConstructionSite savedSite = siteRepository.save(site);
        return siteAssembler.toDto(savedSite);
    }

    @Override
    public ConstructionSiteDto updateSite(Long id, ConstructionSiteDto siteDto) {
        ConstructionSite existingSite = siteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Site not found"));

        existingSite.setName(siteDto.getName());
        existingSite.setLocation(siteDto.getLocation());
        existingSite.setDescription(siteDto.getDescription());
        if (siteDto.getSiteInCharge() != null) {
            Employee siteInCharge = employeeAssembler.toEntity(siteDto.getSiteInCharge());
            existingSite.setSiteInCharge(siteInCharge);
        }

        ConstructionSite updatedSite = siteRepository.save(existingSite);
        return siteAssembler.toDto(updatedSite);
    }

    @Override
    public void deleteSite(Long id) {
        ConstructionSite site = siteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Site not found"));

        site.setDeleted(true);
        siteRepository.save(site);
    }

    @Override
    public Optional<ConstructionSiteDto> findByName(String name) {
        return siteRepository.findByName(name).map(siteAssembler::toDto);
    }
}
