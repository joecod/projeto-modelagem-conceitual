package com.joselemes.cursomc.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.joselemes.cursomc.service.exceptions.ObjectNotFoundException;


/* cursomc */
@ControllerAdvice
public class ResourceExcptionHandler {

	public ResponseEntity<StandartError> objectNotFoundException(ObjectNotFoundException e, HttpServletRequest request) {
		StandartError err = new StandartError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
