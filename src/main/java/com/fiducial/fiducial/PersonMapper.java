package com.fiducial.fiducial;

public class PersonMapper {
    
    public static Person getEntity(PersonDto dto){

        return new Person(dto.getId(), dto.getName());
    }

    public static PersonDto getDto(Person entity){

        return new PersonDto(entity.getId(), entity.getName());
    }
}
