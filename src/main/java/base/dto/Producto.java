/*
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * Nombre de archivo: Producto.java Autor: salvgonz Fecha de creación: 6 sep. 2021
 */

package base.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * The Class Producto.
 */
@Getter
@Setter
/**
 * Instantiates a new producto.
 *
 * @param nombreDeProducto the nombre de producto
 * @param precio the precio
 * @param descripcion the descripcion
 * @param cantidadDisponible the cantidad disponible
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Producto {

  /** The nombre de producto. */
  private String nombreDeProducto;

  /** The precio. */
  private Double precio;

  /** The descripcion. */
  private String descripcion;

  /** The cantidad disponible. */
  private Integer cantidadDisponible;
}
