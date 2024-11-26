package com.kaeser.platform.inventory.interfaces.rest.transform;

import com.kaeser.platform.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.inventory.interfaces.rest.resources.EquipmentResource;

/**
 * Equipment resource from entity assembler
 * @summary
 * This class provides a static method to convert an equipment entity to an equipment resource.
 */
public class EquipmentResourceFromEntityAssembler {

    /**
     * Convert an equipment entity to an equipment resource
     * @param entity the equipment entity
     * @return the equipment resource
     */
    public static EquipmentResource toResourceFromEntity(Equipment entity) {
        return new EquipmentResource(
                entity.getId(),
                entity.getMaterialSerialNumber(),
                entity.getModel(),
                entity.getEquipmentType()
        );
    }
}
