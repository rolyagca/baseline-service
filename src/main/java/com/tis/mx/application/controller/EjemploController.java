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
* Nombre de archivo: EjemploController.java
* Autor: rolaguil
* Fecha de creación: 10 sep 2021
*/

package com.tis.mx.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class EjemploController.
 */
@RestController
public class EjemploController {

  /**
   * Gets the message.
   *
   * @return the message
   */
  @GetMapping(value = "/mensaje")
  public String getMessage() {
    return "Hola Mundo!!";
  }
}
