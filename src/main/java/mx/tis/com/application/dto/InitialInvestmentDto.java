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
* Nombre de archivo: InitialInvestmentDto.java
* Autor: rolaguil
* Fecha de creación: 6 sep 2021
*/

package mx.tis.com.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

/**
 * Instantiates a new initial investment dto.
 *
 * @param initialInvestment the initial investment
 * @param yearlyInput the yearly input
 * @param investmentYield the investment yield
 * @param investmentYears the investment years
 */
@AllArgsConstructor
public class InitialInvestmentDto {

  /** The initial investment. */
  private Double initialInvestment;

  /** The yearly input. */
  private Double yearlyInput;

  /** The yearly input increment. */
  private Integer yearlyInputIncrement;

  /** The investment yield. */
  private Float investmentYield;

  /** The investment years. */
  private Integer investmentYears;
}
