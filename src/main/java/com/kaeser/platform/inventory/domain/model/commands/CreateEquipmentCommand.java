package com.kaeser.platform.inventory.domain.model.commands;

public record CreateEquipmentCommand(String materialSerialNumber, String model, String equipmentType) {
}
