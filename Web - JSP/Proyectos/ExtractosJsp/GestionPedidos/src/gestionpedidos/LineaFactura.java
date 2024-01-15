package gestionpedidos;

/**
 * <p>Título: LineaFactura</p>
 * <p>Descripción: Porque toda factura está formada por... Líneas de factura</p>
 * <p>Copyright: Copyleft (c) 2006</p>
 * <p>Empresa: iToSoft</p>
 * @author Álvaro Alcedo Moreno
 * @version 1.0
 * Fecha de inicio: 26 / XI / 2006
 * Fecha de finalización: 26 / XI / 2006
 */


public class LineaFactura {

  private String articulo;
  private int unidades;
  private float precio;

  public LineaFactura(){}

  public LineaFactura(String articulo, int unidades, float precio) {
    this.articulo = articulo;
    this.unidades = unidades;
    this.precio   = precio;
  }


  ///////////////////////////////// GETTERS Y SETTERS //////////////////////////
  public String getArticulo() {
    return articulo;
  }
  public float getPrecio() {
    return precio;
  }
  public int getUnidades() {
    return unidades;
  }
  public void setUnidades(int unidades) {
    this.unidades = unidades;
  }
  public void setPrecio(float precio) {
    this.precio = precio;
  }
  public void setArticulo(String articulo) {
    this.articulo = articulo;
  }

  // Funcion que devuelve el String de unidades
  public String StringDeUnidades(){
    return String.valueOf(unidades);
  }

  // Funcion que devuelve el String del Precio
  public String StringDePrecio(){
    return String.valueOf(precio);
  }

  // Funcion que devuelve el String de Unidades * precio
  public String StringDeImporte(){
    return String.valueOf(precio * unidades);
  }

  // Funcion que devuelve el float de Unidades * precio
  public float IntDeImporte(){
    return (precio*unidades);

  }


}
