package gestionpedidos;

/**
 * <p>Título: Articulos</p>
 * <p>Descripción: Clase que guarda un articulo</p>
 * <p>Copyright: Copyleft (c) 2006</p>
 * <p>Empresa: iToSoft</p>
 * @author Álvaro Alcedo Moreno
 * @version 1.35
 * Fecha de inicio: 22 / XI / 2006
 * Fecha de finalización: 26 / XI / 2006
 */

public class Articulo {

  private String codigo;
  private String descripcion;
  private int stock;
  private int stockminimo;
  private float preciocompra;
  private float precioventa;

  //Constructor vacío
  public Articulo(){
    codigo=null;
  }

  //Constructor de Stock y código
  public Articulo(String codigo, int stock){
    this.codigo=codigo;
    this.stock=stock;
  }


  // Constructor de parámetros
  public Articulo(String codigo, String descripcion,int stock,int stockminimo,float preciocompra, float precioventa) {

    this.codigo=codigo;
    this.descripcion=descripcion;
    this.stock=stock;
    this.stockminimo=stockminimo;
    this.preciocompra=preciocompra;
    this.precioventa=precioventa;
  }// fin del constructor

  // GETTERS
  public String getCodigo() {
    return codigo;
  }
  public String getDescripcion() {
    return descripcion;
  }
  public float getPreciocompra() {
    return preciocompra;
  }
  public float getPrecioventa() {
    return precioventa;
  }
  public void setStock(int stock) {
    this.stock = stock;
  }
  public int getStockminimo() {
  return stockminimo;
}
public int getStock() {
  return stock;
}

 // SETTERS
  public void setPrecioventa(float precioventa) {
    this.precioventa = precioventa;
  }
  public void setPreciocompra(float preciocompra) {
    this.preciocompra = preciocompra;
  }
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
  public void setStockminimo(int stockminimo) {
    this.stockminimo = stockminimo;
  }


}//class
