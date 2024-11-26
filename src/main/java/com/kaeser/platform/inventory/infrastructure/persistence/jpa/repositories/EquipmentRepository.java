package com.kaeser.platform.inventory.infrastructure.persistence.jpa.repositories;

import com.kaeser.platform.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.inventory.domain.model.valueobjects.MaterialSerialNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EquipmentRepository
 * @summary
 * JPA Repository for Equipment entity
 */
@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    /**
     * @summary
     * Check if an equipment with the given serial number exists
     * @param materialSerialNumber The serial number of the equipment
     * @return True if an equipment with the given serial number exists, false otherwise
     */
    boolean existsByMaterialSerialNumber(MaterialSerialNumber materialSerialNumber);
}
