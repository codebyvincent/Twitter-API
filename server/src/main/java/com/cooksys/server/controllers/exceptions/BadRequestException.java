package com.cooksys.server.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = -4126990538697933441L;

    private String message;

}
