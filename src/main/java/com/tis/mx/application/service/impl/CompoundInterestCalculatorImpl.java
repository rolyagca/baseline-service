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
* Fecha de creación: 10 sep. 2021
*/


package com.tis.mx.application.service.impl;



import com.tis.mx.application.service.CompoundInterestCalculator;
import com.tis.mx.application.dto.InitialInvestmentDto;
import com.tis.mx.application.dto.InvestmentYieldDto;
import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;


/**
 * The Class CompoundInterestCalculatorImpl.
 */
@Service
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

            this.calculateInvestmentYield(initialInvestmentDto.getInitialInvestment(),
                initialInvestmentDto.getYearlyInput(),
                initialInvestmentDto.getInvestmentYield().intValue()),

            this.calculateFinalBalance(initialInvestmentDto.getInitialInvestment(),
                initialInvestmentDto.getYearlyInput(),
                this.calculateInvestmentYield(initialInvestmentDto.getInitialInvestment(),
                    initialInvestmentDto.getYearlyInput(),
                    initialInvestmentDto.getInvestmentYield().intValue())));
      } else {
        return new InvestmentYieldDto(year.getAndIncrement(),

            investmentYieldDtos.get(investmentYieldDtos.size() - 1).getFinalBalance(),

            this.calculateYearlyInput(
                investmentYieldDtos.get(investmentYieldDtos.size() - 1).getYearlyInput(),
                initialInvestmentDto.getYearlyInputIncrement()),

            this.calculateInvestmentYield(
                investmentYieldDtos.get(investmentYieldDtos.size() - 1).getFinalBalance(),
                this.calculateYearlyInput(
                    investmentYieldDtos.get(investmentYieldDtos.size() - 1).getYearlyInput(),
                    initialInvestmentDto.getYearlyInputIncrement()),
                initialInvestmentDto.getInvestmentYield().intValue()),

            this.calculateFinalBalance(
                investmentYieldDtos.get(investmentYieldDtos.size() - 1).getFinalBalance(),
                this.calculateYearlyInput(
                    investmentYieldDtos.get(investmentYieldDtos.size() - 1).getYearlyInput(),
                    initialInvestmentDto.getYearlyInputIncrement()),
                this.calculateInvestmentYield(
                    investmentYieldDtos.get(investmentYieldDtos.size() - 1).getFinalBalance(),
                    this.calculateYearlyInput(
                        investmentYieldDtos.get(investmentYieldDtos.size() - 1).getYearlyInput(),
                        initialInvestmentDto.getYearlyInputIncrement()),
                    initialInvestmentDto.getInvestmentYield().intValue())));
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

    this.minValues(input);

    return (input.getInitialInvestment() >= 1000 && input.getYearlyInput() >= 0
        && input.getYearlyInputIncrement() >= 0 && input.getInvestmentYield() > 0
        && input.getInvestmentYears() >= 1);
  }

  /**
   * Min values.
   *
   * @param initialInvestment the initial investment
   */
  private void minValues(InitialInvestmentDto initialInvestment) {
    Double yearlyInput = initialInvestment.getYearlyInput();
    yearlyInput = yearlyInput == null ? 0.0 : yearlyInput;
    initialInvestment.setYearlyInput(yearlyInput);

    Integer yearlyInputIncrement = initialInvestment.getYearlyInputIncrement();
    yearlyInputIncrement = yearlyInputIncrement == null ? 0 : yearlyInputIncrement;
    initialInvestment.setYearlyInputIncrement(yearlyInputIncrement);

    Float investmentYield = initialInvestment.getInvestmentYield();
    investmentYield = investmentYield == null ? 0 : investmentYield;
    initialInvestment.setInvestmentYield(investmentYield);
  }

  /**
   * Calculate final balance.
   *
   * @param initialBalance the initial balance
   * @param yearlyInput the yearly input
   * @param investmentYield the investment yield
   * @return the double
   */
  private Double calculateFinalBalance(Double initialBalance, Double yearlyInput,
      Double investmentYield) {
    return (initialBalance + yearlyInput + investmentYield);
  }

  /**
   * Calculate investment yield.
   *
   * @param initialBalance the initial balance
   * @param yearlyInput the yearly input
   * @param investmentYield the investment yield
   * @return the double
   */
  private Double calculateInvestmentYield(Double initialBalance, Double yearlyInput,
      Integer investmentYield) {
    return ((initialBalance + yearlyInput) * (investmentYield.doubleValue() / 100d));
  }

  /**
   * Calculate yearly input.
   *
   * @param yearlyInput the yearly input
   * @param yearlyInputIncrement the yearly input increment
   * @return the double
   */
  private Double calculateYearlyInput(Double yearlyInput, Integer yearlyInputIncrement) {
    return (yearlyInput * (1 + ((double) yearlyInputIncrement / 100.00)));
  }


}
