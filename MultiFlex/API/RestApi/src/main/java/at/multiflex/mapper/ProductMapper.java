package at.multiflex.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "cdi",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public class ProductMapper {
    /**
     * Instance of the mapper
     */
    ObjectMapper MAPPER = Mappers.getMapper( ObjectMapper.class );


}
