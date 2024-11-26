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
     */
    public MaterialSerialNumber() {
       this(UUID.randomUUID().toString());
    }
}
