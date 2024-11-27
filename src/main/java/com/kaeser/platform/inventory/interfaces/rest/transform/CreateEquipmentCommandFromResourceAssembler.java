package com.kaeser.platform.inventory.interfaces.rest.transform;

import com.kaeser.platform.inventory.domain.model.commands.CreateEquipmentCommand;
import com.kaeser.platform.inventory.interfaces.rest.resources.CreateEquipmentResource;

import java.util.UUID;

/**
 * Create equipment command from resource assembler
 * @summary
 * This class is responsible for assembling a create equipment command from a create equipment resource.
 */
public class CreateEquipmentCommandFromResourceAssembler {

    /**
     * Assemble a create equipment command from a create equipment resource
     * @summary
     * This method assembles a create equipment command from a create equipment resource.
     * @param resource the create equipment resource
     * @return the create equipment command
     */
    public static CreateEquipmentCommand toCommandFromResource(CreateEquipmentResource resource) {
        return new CreateEquipmentCommand(
                resource.model(),
                resource.equipmentType()
        );
    }
}
