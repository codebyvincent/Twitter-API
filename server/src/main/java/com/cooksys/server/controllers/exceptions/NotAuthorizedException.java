package com.cooksys.server.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NotAuthorizedException extends RuntimeException {

    private static final long serialVersionUID = -5171048977309113872L;

    private String message;

}
