package com.cooksys.server.mappers;

import com.cooksys.server.models.CompanyRequestDto;
import com.cooksys.server.models.CompanyResponseDto;
import com.cooksys.server.entities.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyResponseDto entityToDto(Company company);

    List<CompanyResponseDto> entitiesToDtos(List<Company> companies);

    @Mapping(source = "companyData.name", target = "name")
    @Mapping(source = "companyData.description", target = "description")
    Company requestEntity(CompanyRequestDto companyRequestDto);

}
