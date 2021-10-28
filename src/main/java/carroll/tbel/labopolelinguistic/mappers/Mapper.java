package carroll.tbel.labopolelinguistic.mappers;

public interface Mapper<DTO, ENTITY> {

    DTO entityToDto(ENTITY entity);
    ENTITY dtoToEntity(DTO dto);

}
