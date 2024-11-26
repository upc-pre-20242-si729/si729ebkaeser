package com.kaeser.platform.inventory.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

/**
 * MaterialSerialNumber
 * @summary
 * Value Object for Material Serial Number
 * @param materialSerialNumber
 */
@Embeddable
public record MaterialSerialNumber(String materialSerialNumber) {

    /**
     * MaterialSerialNumber
     * @summary
     * Constructor for MaterialSerialNumber
     * @param materialSerialNumber the material serial number
     */
    public MaterialSerialNumber(String materialSerialNumber) {
       this.materialSerialNumber = UUID.fromString(materialSerialNumber).toString();
    }
}
