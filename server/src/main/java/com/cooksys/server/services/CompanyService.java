package com.cooksys.server.services;

import java.util.List;

import com.cooksys.server.models.CompanyRequestDto;
import com.cooksys.server.models.CompanyResponseDto;

public interface CompanyService {

    List<CompanyResponseDto> getCompanies();

    List<CompanyResponseDto> getCompanyByValue(CompanyRequestDto companyRequestDto);

    CompanyResponseDto createCompany(CompanyRequestDto companyRequestDto);

}
