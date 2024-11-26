package com.kaeser.platform.inventory.domain.services;


import com.kaeser.platform.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.inventory.domain.model.commands.CreateEquipmentCommand;

import java.util.Optional;

/**
 * EquipmentCommandService interface
 * @summary
 * This interface defines the contract for the EquipmentCommandService
 */
public interface EquipmentCommandService {

    /**
     * Handle CreateEquipmentCommand
     * @summary
     * This method handles the CreateEquipmentCommand and returns an Optional<Equipment>
     * @param command the CreateEquipmentCommand
     * @return Optional<Equipment> the Equipment created
     */
    Optional<Equipment> handle(CreateEquipmentCommand command);
}
