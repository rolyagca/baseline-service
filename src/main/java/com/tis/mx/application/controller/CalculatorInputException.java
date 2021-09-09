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
* Nombre de archivo: CalculatorInputException.java
* Autor: rolaguil
* Fecha de creación: 9 sep 2021
*/

package com.tis.mx.application.controller;

/**
 * The Class CalculatorInputException.
 */
public class CalculatorInputException extends RuntimeException {


  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -6506558049330575989L;

  /**
   * Instantiates a new calculator input exception.
   *
   * @param message the message
   */
  public CalculatorInputException(String message) {
    super(message);
  }
}
