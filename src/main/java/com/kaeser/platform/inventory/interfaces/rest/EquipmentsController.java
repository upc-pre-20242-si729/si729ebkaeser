package com.kaeser.platform.inventory.interfaces.rest;

import com.kaeser.platform.inventory.domain.services.EquipmentCommandService;
import com.kaeser.platform.inventory.interfaces.rest.resources.CreateEquipmentResource;
import com.kaeser.platform.inventory.interfaces.rest.resources.EquipmentResource;
import com.kaeser.platform.inventory.interfaces.rest.transform.CreateEquipmentCommandFromResourceAssembler;
import com.kaeser.platform.inventory.interfaces.rest.transform.EquipmentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="api/v1/equipments", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Equipments", description = "Endpoints for managing equipments")
public class EquipmentsController {


    /**
     * Equipment command service
     * @summary
     * This service provides the command operations for managing equipments.
     */
    private final EquipmentCommandService equipmentCommandService;

    /**
     * Constructor for injecting the equipment command service
     * @param equipmentCommandService the equipment command service
     */
    public EquipmentsController(EquipmentCommandService equipmentCommandService) {
        this.equipmentCommandService = equipmentCommandService;
    }

    /**
     * Create an equipment
     * @param resource the {@link CreateEquipmentResource} with the data to create the equipment
     * @return A {@link ResponseEntity} with the created equipment resource, or a bad request response if the data is invalid
     */
    @PostMapping
    @Operation(summary = "Create an equipment", description = "Create a new equipment with the given data")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Equipment created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    public ResponseEntity<EquipmentResource> createEquipment(@RequestBody CreateEquipmentResource resource) {
        var command = CreateEquipmentCommandFromResourceAssembler.toCommandFromResource(resource);

        var equipment = equipmentCommandService.handle(command);
        if (equipment.isEmpty())
            return ResponseEntity.badRequest().build();

        var equipmentCreated = equipment.get();
        var equipmentResource = EquipmentResourceFromEntityAssembler.toResourceFromEntity(equipmentCreated);

        return new ResponseEntity<>(equipmentResource, HttpStatus.CREATED);
    }
}
