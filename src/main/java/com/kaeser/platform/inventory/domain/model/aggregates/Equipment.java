package com.kaeser.platform.inventory.domain.model.aggregates;

import com.kaeser.platform.inventory.domain.model.commands.CreateEquipmentCommand;
import com.kaeser.platform.inventory.domain.model.valueobjects.EquipmentType;
import com.kaeser.platform.inventory.domain.model.valueobjects.MaterialSerialNumber;
import com.kaeser.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Equipment aggregate root entity
 * @summary
 * Equipment is a domain model aggregate root entity that represents a piece of equipment in the inventory domain.
 */
@Entity
public class Equipment extends AuditableAbstractAggregateRoot<Equipment> {

    /**
     * Serial version UID
     */
    @Embedded
    private MaterialSerialNumber materialSerialNumber;

    /**
     * Equipment model name
     */
    @NotBlank
    private String model;

    /**
     * Equipment type value object
     */
    @Enumerated(EnumType.STRING)
    @NotNull
    private EquipmentType equipmentType;

    /**
     * Default constructor
     */
    public Equipment() {
    }

    /**
     * Constructor
     * @param command the create equipment command
     */
    public Equipment(CreateEquipmentCommand command) {
        this.materialSerialNumber = new MaterialSerialNumber(command.materialSerialNumber());
        this.model = command.model();
        this.equipmentType = EquipmentType.valueOf(command.equipmentType());
    }
}
