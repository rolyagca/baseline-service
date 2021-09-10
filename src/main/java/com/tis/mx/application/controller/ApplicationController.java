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
* Nombre de archivo: ApplicationController.java
* Autor: rolaguil
* Fecha de creación: 9 sep 2021
*/



package com.tis.mx.application.controller;

import com.tis.mx.application.dto.InitialInvestmentDto;
import com.tis.mx.application.dto.InvestmentYieldDto;
import com.tis.mx.application.service.CompoundInterestCalculator;
import java.util.List;

/**
 * The Class ApplicationController.
 */
public class ApplicationController {

  /** The calculator. */
  private CompoundInterestCalculator calculator;

  /**
   * Instantiates a new application controller.
   *
   * @param calculator the calculator
   */
  public ApplicationController(CompoundInterestCalculator calculator) {
    this.calculator = calculator;
  }

  /**
   * Creates the table yield.
   *
   * @param initialInvestmentDto the initial investment dto
   * @return the list
   */
  public List<InvestmentYieldDto> createTableYield(InitialInvestmentDto initialInvestmentDto) {
    if (calculator.validateInput(initialInvestmentDto)) {
      return calculator.createRevenueGrid(initialInvestmentDto);
    }

    throw new RuntimeException("One or more values are invalid");
  }

}
