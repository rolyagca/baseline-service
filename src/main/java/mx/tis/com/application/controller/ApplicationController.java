/*
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * Nombre de archivo: ApplicationController.java Autor: rolaguil Fecha de creación: 8 sep 2021
 */

package mx.tis.com.application.controller;

import java.util.List;
import mx.tis.com.application.dto.InitialInvestmentDto;
import mx.tis.com.application.dto.InvestmentYieldDto;
import mx.tis.com.application.service.impl.CompoundInterestCalculatorImpl;

/**
 * The Class ApplicationController.
 */
public class ApplicationController {

  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
    InitialInvestmentDto initialInvestmentDto =
        new InitialInvestmentDto(5000.00, 3000.00, 1, 21f, 5);
    CompoundInterestCalculatorImpl calculator = new CompoundInterestCalculatorImpl();
    System.out.println(calculator.validateInput(initialInvestmentDto) + "\n");
    List<InvestmentYieldDto> investmentYieldDtos =
        calculator.createRevenueGrid(initialInvestmentDto);
    investmentYieldDtos.forEach(System.out::println);
  }

}
