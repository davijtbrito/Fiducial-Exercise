package com.fiducial.fiducial;

/**
 * {@summary this mapper will be responsable for the entity and dto.}
 * {@literal }
 * {@literal see also: } 
 * {@link PersonDto} and {@link Person}
 */
public class PersonMapper {
    
    /**
     * Returns the an Entity for the PersonDto.
     * @param dto {@link PersonDto}
     * @return {@link Person}
     */
    public static Person getEntity(PersonDto dto){

        return new Person(dto.getId(), dto.getName());
    }


    /**
     * Returns the a Dto for the Person.
     * @param dto {@link Person}
     * @return {@link PersonDto}
     */
    public static PersonDto getDto(Person entity){

        return new PersonDto(entity.getId(), entity.getName());
    }
}
