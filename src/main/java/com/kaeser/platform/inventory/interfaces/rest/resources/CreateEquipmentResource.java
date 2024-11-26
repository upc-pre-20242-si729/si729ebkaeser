package com.kaeser.platform.inventory.interfaces.rest.resources;

/**
 * Resource class for creating equipment in the inventory.
 * @summary
 * This class is used to create equipment in the inventory.
 * @param model the model of the equipment
 * @param equipmentType the type of the equipment
 */
public record CreateEquipmentResource(
       String model, String equipmentType) {
}
