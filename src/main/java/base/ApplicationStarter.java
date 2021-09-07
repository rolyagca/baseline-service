package base;

import base.dto.Producto;

public class ApplicationStarter {

  public static void main(String[] args) {

    Producto producto = new Producto("nombre producto", 2000.00, "Descripcion", 100);
    Producto producto2 = new Producto();

    producto.getCantidadDisponible();

    System.out.println(producto);
  }
}
