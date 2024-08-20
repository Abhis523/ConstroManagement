package com.constro.insyghts.Repository;

import com.constro.insyghts.Entity.ConstructionSite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConstructionSiteRepository extends JpaRepository<ConstructionSite,Long> {
    Optional<ConstructionSite> findByName(String name);
}
