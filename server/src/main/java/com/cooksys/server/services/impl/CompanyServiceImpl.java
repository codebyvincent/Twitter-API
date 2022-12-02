package com.cooksys.server.services.impl;

import com.cooksys.server.controllers.exceptions.NotFoundException;
import com.cooksys.server.controllers.exceptions.BadRequestException;
import com.cooksys.server.controllers.exceptions.NotAuthorizedException;
import com.cooksys.server.entities.Company;
import com.cooksys.server.mappers.CompanyMapper;
import com.cooksys.server.models.CompanyRequestDto;
import com.cooksys.server.models.CompanyResponseDto;
import com.cooksys.server.repositories.CompanyRepository;
import com.cooksys.server.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    private final CompanyMapper companyMapper;

    @Override
    public List<CompanyResponseDto> getCompanies() {
        return companyMapper.entitiesToDtos(companyRepository.findAll());
    }

    @Override
    public List<CompanyResponseDto> getCompanyByValue(CompanyRequestDto companyRequestDto) {

        Company company = companyRepository.findCompanyByName(companyRequestDto.getCompanyData().getName()).orElseThrow(() -> new NotFoundException("Company not found."));
        return companyMapper.entitiesToDtos(List.of(company));
    }

    @Override
    public CompanyResponseDto createCompany(CompanyRequestDto companyRequestDto) {
        // Check if admin
        if (!companyRequestDto.isAdmin()) {
            throw new NotAuthorizedException("You must be an Administrator to perform the requested operation.");
        }
        // check for company data
        if (!validateCompanyRequestDto(companyRequestDto)) {
            throw new BadRequestException("Please fill out company name and description before submitting.");
        }

        Company newCompany = companyMapper.requestEntity(companyRequestDto);
        newCompany.setDescription(companyRequestDto.getCompanyData().getDescription());
        newCompany.setName(companyRequestDto.getCompanyData().getName());

        return companyMapper.entityToDto(companyRepository.saveAndFlush(newCompany));

    }

    public Company getCompanyByName(String name) {
        return companyRepository.findCompanyByName(name).orElseThrow(() -> new NotFoundException("No company found with the given id."));
    }

    public boolean validateCompanyRequestDto(CompanyRequestDto companyRequestDto) {
        String companyName = companyRequestDto.getCompanyData().getName();
        String companyDescription = companyRequestDto.getCompanyData().getDescription();
        if (companyName.isEmpty() || companyName == null) {
            return false;
        }
        if (companyDescription.isEmpty() || companyDescription == null) {
            return false;
        }
        return true;
    }
}
