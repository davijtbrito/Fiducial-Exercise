package com.fiducial.fiducial;

import lombok.Data;

/**
 * Represents the entity {@link Person}. 
 */
@Data
public class PersonDto {        

    public PersonDto() {
    }

    public PersonDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    private Long id;
    private String name;
}
