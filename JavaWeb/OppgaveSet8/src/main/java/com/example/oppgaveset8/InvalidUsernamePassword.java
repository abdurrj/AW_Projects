package com.example.oppgaveset8;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class InvalidUsernamePassword extends Exception {
}
