package com.constro.insyghts.Service;

import com.constro.insyghts.Dto.ConstructionSiteDto;

import java.util.Optional;

public interface ConstructionSiteService {
    ConstructionSiteDto getSiteById(Long id);

    ConstructionSiteDto createSite(ConstructionSiteDto siteDto);

    ConstructionSiteDto updateSite(Long id, ConstructionSiteDto siteDto);

    void deleteSite(Long id);

    Optional<ConstructionSiteDto> findByName(String name);
}
