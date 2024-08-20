package com.constro.insyghts.Controller;

import com.constro.insyghts.Dto.ConstructionSiteDto;
import com.constro.insyghts.Service.ConstructionSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/sites")
public class ConstructionSiteController {

        @Autowired
        private ConstructionSiteService siteService;

        // Get site by ID
        @GetMapping("/{id}")
        public ResponseEntity<ConstructionSiteDto> getSiteById(@PathVariable Long id) {
            ConstructionSiteDto siteDto = siteService.getSiteById(id);
            return ResponseEntity.ok(siteDto);
        }

        // Create a new site
        @PostMapping
        public ResponseEntity<ConstructionSiteDto> createSite(@RequestBody ConstructionSiteDto siteDto) {
            ConstructionSiteDto createdSite = siteService.createSite(siteDto);
            return ResponseEntity.ok(createdSite);
        }

        // Update an existing site
        @PutMapping("/{id}")
        public ResponseEntity<ConstructionSiteDto> updateSite(@PathVariable Long id, @RequestBody ConstructionSiteDto siteDto) {
            ConstructionSiteDto updatedSite = siteService.updateSite(id, siteDto);
            return ResponseEntity.ok(updatedSite);
        }

        // Delete a site (soft delete)
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteSite(@PathVariable Long id) {
            siteService.deleteSite(id);
            return ResponseEntity.noContent().build();
        }
    }
