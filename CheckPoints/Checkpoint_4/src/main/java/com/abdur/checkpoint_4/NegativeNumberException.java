package com.abdur.checkpoint_4;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "BobilOppNed?")
public class NegativeNumberException extends Exception{

}
