package com.example.oppgset9;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "do bad stuff")
public class invalidProductIdException extends Exception{
}
