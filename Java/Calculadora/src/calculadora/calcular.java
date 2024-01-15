package calculadora;

/**
 * <p>T�tulo: Calculadora de �lvaro</p>
 * <p>Descripci�n: Peque�o proyecto de Bienvenida, construyendo una calculadora b�sica</p>
 * <p>Copyright: CopyLeft (l) 2006 por WwW . AlvaRiTo . NeT</p>
 * <p>Empresa: iToSoFt</p>
 * @author �lvaro Alcedo Moreno
 * @version 0.5
 */


public class calcular {
  public calcular() {
  }//constructor vac�o

  public String Suma(float numero1, String numero2){
    float resultado = numero1 + new Float(numero2).floatValue();
    return Float.toString(resultado);
  }//m�todo Suma

  public String Resta(float numero1, String numero2){
    float resultado = numero1 - new Float(numero2).floatValue();
    return Float.toString(resultado);
  }//m�todo Resta

  public String Multiplica(float numero1, String numero2){
  String multiplica="";
  float resultado=0;
  resultado = numero1 * new Float(numero2).floatValue();
  multiplica= Float.toString(resultado);
  return multiplica;
}//m�todo Multiplica

public String Divide(float numero1, String numero2){
  String divide="";
  float resultado=0;
  resultado = numero1 / new Float(numero2).floatValue();
  divide= Float.toString(resultado);
  return divide;
}//m�todo Divide

public String Eleva(float numero1, String numero2){
  double result=1;
  float contador=0;

// en numero2entero meto el string transformado
  float numero2entero = new Float(numero2).floatValue();

//hago un bucle
  for (contador=0;contador<numero2entero;contador++)
    result*=numero1;

  return Double.toString(result);
}//m�todo Eleva





}//class
