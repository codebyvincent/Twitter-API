package com.cooksys.server.controllers;

import com.cooksys.server.models.CompanyRequestDto;
import com.cooksys.server.models.CompanyResponseDto;
import com.cooksys.server.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CompanyResponseDto> getCompanies() {
        return companyService.getCompanies();
    }
    
    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public List<CompanyResponseDto> getCompanyByValue(@RequestBody CompanyRequestDto companyRequestDto){
        return companyService.getCompanyByValue(companyRequestDto);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CompanyResponseDto createCompany(@RequestBody CompanyRequestDto companyRequestDto) {
		    return companyService.createCompany(companyRequestDto);
    }
}
