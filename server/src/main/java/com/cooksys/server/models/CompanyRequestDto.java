package com.cooksys.server.models;

import com.cooksys.server.models.data.CompanyData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embedded;

@NoArgsConstructor
@Getter
@Setter
public class CompanyRequestDto {

    private boolean admin;

    @Embedded
    private CompanyData companyData;

}
