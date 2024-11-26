package com.kaeser.platform.inventory.interfaces.rest.resources;

/**
 * Resource class for equipment in the inventory.
 * @summary
 * This class is used to represent equipment in the inventory.
 * @param id the id of the equipment
 * @param materialSerialNumber the material serial number of the equipment
 * @param model the model of the equipment
 * @param equipmentType the type of the equipment
 */
public record EquipmentResource(
        Long id, String materialSerialNumber, String model, String equipmentType
) {
}
