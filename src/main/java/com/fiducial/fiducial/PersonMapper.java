package com.fiducial.fiducial;

/**
 * this mapper will be responsable for the entity and dto @Person.
 */
public class PersonMapper {
    
    public static Person getEntity(PersonDto dto){

        return new Person(dto.getId(), dto.getName());
    }

    public static PersonDto getDto(Person entity){

        return new PersonDto(entity.getId(), entity.getName());
    }
}
