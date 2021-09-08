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
* Nombre de archivo: CompoundInterestCalculatorImpl.java
* Autor: rolaguil
* Fecha de creación: 8 sep 2021
*/


package mx.tis.com.application.service.impl;


import mx.tis.com.application.service.CompoundInterestCalculator;
import mx.tis.com.application.dto.InitialInvestmentDto;
import mx.tis.com.application.dto.InvestmentYieldDto;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;


/**
 * The Class CompoundInterestCalculatorImpl.
 */
public class CompoundInterestCalculatorImpl implements CompoundInterestCalculator {

  /**
   * Creates the revenue grid.
   *
   * @param initialInvestmentDto the initial investment dto
   * @return the list
   */
  @Override
  public List<InvestmentYieldDto> createRevenueGrid(InitialInvestmentDto initialInvestmentDto) {
    List<InvestmentYieldDto> investmentYieldDtos = new ArrayList<>();
    List<InvestmentYieldDto> aux = Stream.generate(InvestmentYieldDto::new)
        .limit(initialInvestmentDto.getInvestmentYears()).collect(Collectors.toList());
    AtomicInteger year = new AtomicInteger(1);
    aux.stream().map(investment -> {
      if (year.get() == 1) {
        return new InvestmentYieldDto(year.getAndIncrement(),

            initialInvestmentDto.getInitialInvestment(),

            initialInvestmentDto.getYearlyInput(),

            (initialInvestmentDto.getInitialInvestment() + initialInvestmentDto.getYearlyInput())
                * (initialInvestmentDto.getInvestmentYield().doubleValue() / 100.00),

            initialInvestmentDto.getInitialInvestment() + initialInvestmentDto.getYearlyInput()
                + ((initialInvestmentDto.getInitialInvestment()
                    + initialInvestmentDto.getYearlyInput())
                    * (initialInvestmentDto.getInvestmentYield().doubleValue() / 100.00)));
      } else {
        return new InvestmentYieldDto(year.getAndIncrement(),

            investmentYieldDtos.get(investmentYieldDtos.size() - 1).getFinalBalance(),

            investmentYieldDtos.get(investmentYieldDtos.size() - 1).getYearlyInput()
                * (1 + (initialInvestmentDto.getYearlyInputIncrement().doubleValue() / 100.00)),

            (investmentYieldDtos.get(investmentYieldDtos.size() - 1).getFinalBalance()
                + (investmentYieldDtos.get(investmentYieldDtos.size() - 1).getYearlyInput()
                    * (1 + (initialInvestmentDto.getInvestmentYield().doubleValue() / 100d))))
                * (initialInvestmentDto.getInvestmentYield() / 100f),

            (investmentYieldDtos.get(investmentYieldDtos.size() - 1).getFinalBalance())
                + (investmentYieldDtos.get(investmentYieldDtos.size() - 1).getYearlyInput()
                    * (1 + (initialInvestmentDto.getYearlyInputIncrement().doubleValue() / 100.00)))
                + ((investmentYieldDtos.get(investmentYieldDtos.size() - 1).getFinalBalance()
                    + (investmentYieldDtos.get(investmentYieldDtos.size() - 1).getYearlyInput()
                        * (1 + (initialInvestmentDto.getInvestmentYield().doubleValue() / 100d))))
                    * (initialInvestmentDto.getInvestmentYield() / 100f)));
      }
    }).forEachOrdered(investmentYieldDtos::add);
    return investmentYieldDtos;
  }

  /**
   * Validate input.
   *
   * @param input the input
   * @return true, if successful
   */
  @Override
  public boolean validateInput(InitialInvestmentDto input) {
    if (input.getInitialInvestment() >= 1000.00 && input.getInitialInvestment() != null) {
      if (input.getInvestmentYears() >= 1 && input.getInvestmentYears() != null) {
        if (input.getInvestmentYield() > 0 || input.getInvestmentYield() != null) {
          Float res = input.getInvestmentYield() == null ? 0 : input.getInvestmentYield();
          input.setInvestmentYield(res);
          if (input.getYearlyInput() == null) {
            input.setYearlyInput(0d);
          }
          return true;
        } else {
          return false;
        }
      } else {
        return false;
      }
    } else {
      return false;
    }
  }


}
