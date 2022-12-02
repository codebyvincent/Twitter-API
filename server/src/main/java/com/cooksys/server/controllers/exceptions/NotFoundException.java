package com.cooksys.server.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = -3211745149012879095L;

    private String message;

}

