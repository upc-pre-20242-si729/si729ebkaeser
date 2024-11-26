package com.kaeser.platform.inventory.application.internal.commandservices;

import com.kaeser.platform.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.inventory.domain.model.commands.CreateEquipmentCommand;
import com.kaeser.platform.inventory.domain.model.valueobjects.MaterialSerialNumber;
import com.kaeser.platform.inventory.domain.services.EquipmentCommandService;
import com.kaeser.platform.inventory.infrastructure.persistence.jpa.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the {@link EquipmentCommandService} interface.
 * @summary
 * This class is responsible for handling the commands related to Equipment aggregate.
 */
@Service
public class EquipmentCommandServiceImpl implements EquipmentCommandService {

    /**
     * EquipmentRepository instance to interact with the database
     */
    private final EquipmentRepository equipmentRepository;

    /**
     * Constructor
     * @param equipmentRepository the EquipmentRepository instance
     */
    public EquipmentCommandServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    /** inheritedDoc */
    @Override
    public Optional<Equipment> handle(CreateEquipmentCommand command) {
        if (equipmentRepository.existsByMaterialSerialNumber(new MaterialSerialNumber(command.materialSerialNumber())))
            throw new IllegalArgumentException("Equipment with the same serial number already exists");

        var equipment = new Equipment(command);
        equipmentRepository.save(equipment);

        return Optional.of(equipment);
    }
}
