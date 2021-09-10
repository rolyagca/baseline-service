/* 
* This program is free software: you can redistribute it and/or modify  
* it under the terms of the GNU General Public License as published by  
* the Free Software Foundation, version 3.
*
* This program is distributed in the hope that it will be useful, but 
* WITHOUT ANY WARRANTY; without even the implied warranty of 
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
* General Public License for more details.
*
* Nombre de archivo: GlobalExceptionHandler.java
* Autor: rolaguil
* Fecha de creación: 10 sep 2021
*/

package com.tis.mx.infrastructure.exception;

import com.tis.mx.application.controller.CalculatorInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The Class GlobalExceptionHandler.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
  
  /**
   * Bad request.
   *
   * @param calculatorInputException the calculator input exception
   * @return the response entity
   */
  @ExceptionHandler({CalculatorInputException.class})
  public ResponseEntity<ErrorResponse> badRequest(
      CalculatorInputException calculatorInputException) {
    return new ResponseEntity<>(new ErrorResponse(1001, calculatorInputException.getMessage(), 
        "input validation", "One or more values have mistakes"), 
        HttpStatus.BAD_REQUEST);
  }
  
  /**
   * Internal server exception.
   *
   * @param serverException the server exception
   * @return the response entity
   */
  @ExceptionHandler({Exception.class})
  public ResponseEntity<ErrorResponse> internalServerException(
      Exception serverException) {
    return new ResponseEntity<>(new ErrorResponse(9999, serverException.getMessage(), 
        "internal error", null), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
