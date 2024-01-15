package calculadora;

/**
 * <p>Título: Calculadora de Álvaro</p>
 * <p>Descripción: Pequeño proyecto de Bienvenida, construyendo una calculadora básica</p>
 * <p>Copyright: CopyLeft (l) 2006 por WwW . AlvaRiTo . NeT</p>
 * <p>Empresa: iToSoFt</p>
 * @author Álvaro Alcedo Moreno
 * @version 0.5
 */


public class calcular {
  public calcular() {
  }//constructor vacío

  public String Suma(float numero1, String numero2){
    float resultado = numero1 + new Float(numero2).floatValue();
    return Float.toString(resultado);
  }//método Suma

  public String Resta(float numero1, String numero2){
    float resultado = numero1 - new Float(numero2).floatValue();
    return Float.toString(resultado);
  }//método Resta

  public String Multiplica(float numero1, String numero2){
  String multiplica="";
  float resultado=0;
  resultado = numero1 * new Float(numero2).floatValue();
  multiplica= Float.toString(resultado);
  return multiplica;
}//método Multiplica

public String Divide(float numero1, String numero2){
  String divide="";
  float resultado=0;
  resultado = numero1 / new Float(numero2).floatValue();
  divide= Float.toString(resultado);
  return divide;
}//método Divide

public String Eleva(float numero1, String numero2){
  double result=1;
  float contador=0;

// en numero2entero meto el string transformado
  float numero2entero = new Float(numero2).floatValue();

//hago un bucle
  for (contador=0;contador<numero2entero;contador++)
    result*=numero1;

  return Double.toString(result);
}//método Eleva





}//class
