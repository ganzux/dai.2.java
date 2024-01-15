package calculadora;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <p>Título: Calculadora de Álvaro</p>
 * <p>Descripción: Pequeño proyecto de Bienvenida, construyendo una calculadora básica</p>
 * <p>Copyright: CopyLeft (l) 2006 por WwW . AlvaRiTo . NeT</p>
 * <p>Empresa: iToSoFt</p>
 * @author Álvaro Alcedo Moreno
 * @version 0.5
 */

public class Marco1 extends JFrame {
  JPanel contentPane;
  JButton boton1 = new JButton();
  JButton boton2 = new JButton();
  JButton boton3 = new JButton();
  JButton boton4 = new JButton();
  JButton boton5 = new JButton();
  JButton boton6 = new JButton();
  JButton boton7 = new JButton();
  JButton boton8 = new JButton();
  JButton boton9 = new JButton();
  JButton boton0 = new JButton();
  JButton botonc = new JButton();
  JButton igual = new JButton();
  JButton mas = new JButton();
  JButton menos = new JButton();
  JButton por = new JButton();
  JButton entre = new JButton();
  JLabel visor = new JLabel();
  private float primernumero=0;
  private int operacion=0;//aqui guardaremos el numero de la operacion: 1 Suma, 2 resta...
  JButton raiz = new JButton();
  JButton elevado = new JButton();
  JButton elevadoamenos1 = new JButton();
  JButton elevadoamenos2 = new JButton();
  JButton elevadoamenos3 = new JButton();
  JButton elevadoamenos4 = new JButton();
  JButton elevadoamenos5 = new JButton();
  JButton exclamacion = new JButton();
  JButton del = new JButton();

  //Construir el marco
  public Marco1() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  //Inicialización de componentes
  private void jbInit() throws Exception  {
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(null);
    this.setResizable(false);
    this.setSize(new Dimension(300, 300));
    this.setTitle("Mi calculadora");
    contentPane.setBorder(null);

    boton1.setBounds(new Rectangle(10, 70, 42, 40));
    boton1.setFont(new java.awt.Font("Dialog", 1, 15));
    boton1.setMnemonic('1');
    boton1.setText("1");
    boton1.addActionListener(new Marco1_boton1_actionAdapter(this));

    boton2.setText("2");
    boton2.addActionListener(new Marco1_boton2_actionAdapter(this));
    boton2.setMnemonic('2');
    boton2.setFont(new java.awt.Font("Dialog", 1, 15));
    boton2.setBounds(new Rectangle(62, 70, 42, 40));

    boton3.setText("3");
    boton3.addActionListener(new Marco1_boton3_actionAdapter(this));
    boton3.setMnemonic('3');
    boton3.setFont(new java.awt.Font("Dialog", 1, 15));
    boton3.setBounds(new Rectangle(112, 70, 42, 40));

    boton4.setBounds(new Rectangle(10, 120, 42, 40));
    boton4.setFont(new java.awt.Font("Dialog", 1, 15));
    boton4.setMnemonic('4');
    boton4.setText("4");
    boton4.addActionListener(new Marco1_boton4_actionAdapter(this));

    boton5.setText("5");
    boton5.addActionListener(new Marco1_boton5_actionAdapter(this));
    boton5.setMnemonic('5');
    boton5.setFont(new java.awt.Font("Dialog", 1, 15));
    boton5.setBounds(new Rectangle(62, 120, 42, 40));

    boton6.setBounds(new Rectangle(112, 120, 42, 40));
    boton6.setFont(new java.awt.Font("Dialog", 1, 15));
    boton6.setMnemonic('6');
    boton6.setText("6");
    boton6.addActionListener(new Marco1_boton6_actionAdapter(this));

    boton7.setBounds(new Rectangle(10, 170, 42, 40));
    boton7.setFont(new java.awt.Font("Dialog", 1, 15));
    boton7.setMnemonic('7');
    boton7.setText("7");
    boton7.addActionListener(new Marco1_boton7_actionAdapter(this));

    boton8.setText("8");
    boton8.addActionListener(new Marco1_boton8_actionAdapter(this));
    boton8.setMnemonic('8');
    boton8.setFont(new java.awt.Font("Dialog", 1, 15));
    boton8.setBounds(new Rectangle(62, 170, 42, 40));

    boton9.setBounds(new Rectangle(112, 170, 42, 40));
    boton9.setFont(new java.awt.Font("Dialog", 1, 15));
    boton9.setMnemonic('9');
    boton9.setText("9");
    boton9.addActionListener(new Marco1_boton9_actionAdapter(this));

    boton0.setText("0");
    boton0.addActionListener(new Marco1_boton0_actionAdapter(this));
    boton0.setMnemonic('0');
    boton0.setFont(new java.awt.Font("Dialog", 1, 15));
    boton0.setActionCommand("0");
    boton0.setBounds(new Rectangle(10, 220, 42, 40));

    botonc.setText("c");
    botonc.addActionListener(new Marco1_botonc_actionAdapter(this));
    botonc.setMnemonic('C');
    botonc.setFont(new java.awt.Font("Dialog", 1, 15));
    botonc.setActionCommand("C");
    botonc.setBounds(new Rectangle(62, 220, 42, 40));

    igual.setText("=");
    igual.addActionListener(new Marco1_igual_actionAdapter(this));
    igual.setMnemonic('=');
    igual.setFont(new java.awt.Font("Dialog", 1, 14));
    igual.setFocusPainted(true);
    igual.setHorizontalTextPosition(SwingConstants.CENTER);
    igual.setMargin(new Insets(2, 14, 2, 14));
    igual.setBounds(new Rectangle(112, 220, 42, 40));
    igual.setEnabled(false);

    mas.setEnabled(false);
    mas.setBounds(new Rectangle(175, 70, 42, 40));
    mas.setMargin(new Insets(2, 14, 2, 14));
    mas.setHorizontalTextPosition(SwingConstants.CENTER);
    mas.setFocusPainted(true);
    mas.setFont(new java.awt.Font("Dialog", 1, 14));
    mas.setMnemonic('+');
    mas.setText("+");
    mas.addActionListener(new Marco1_mas_actionAdapter(this));

    menos.setEnabled(false);
    menos.setBounds(new Rectangle(175, 121, 42, 40));
    menos.setMargin(new Insets(2, 14, 2, 14));
    menos.setHorizontalTextPosition(SwingConstants.CENTER);
    menos.setFocusPainted(true);
    menos.setFont(new java.awt.Font("Dialog", 1, 14));
    menos.setMnemonic('-');
    menos.setText("-");
    menos.addActionListener(new Marco1_menos_actionAdapter(this));

    por.setText("*");
    por.addActionListener(new Marco1_por_actionAdapter(this));
    por.setMnemonic('*');
    por.setFont(new java.awt.Font("Dialog", 1, 14));
    por.setFocusPainted(true);
    por.setHorizontalTextPosition(SwingConstants.CENTER);
    por.setMargin(new Insets(2, 14, 2, 14));
    por.setBounds(new Rectangle(175, 171, 42, 40));
    por.setEnabled(false);

    entre.setText("/");
    entre.addActionListener(new Marco1_entre_actionAdapter(this));
    entre.setMnemonic('/');
    entre.setFont(new java.awt.Font("Dialog", 1, 14));
    entre.setFocusPainted(true);
    entre.setHorizontalTextPosition(SwingConstants.CENTER);
    entre.setMargin(new Insets(2, 14, 2, 14));
    entre.setBounds(new Rectangle(175, 221, 42, 40));
    entre.setEnabled(false);

    visor.setBackground(Color.black);
    visor.setFont(new java.awt.Font("Comic Sans MS", 1, 25));
    visor.setAlignmentX((float) 22.0);
    visor.setHorizontalAlignment(SwingConstants.RIGHT);
    visor.setText("0");
    visor.setBounds(new Rectangle(12, 8, 216, 49));

    raiz.setText("V");
    raiz.addActionListener(new Marco1_raiz_actionAdapter(this));
    raiz.setMnemonic('+');
    raiz.setFont(new java.awt.Font("Dialog", 1, 12));
    raiz.setActionCommand("V");
    raiz.setFocusPainted(true);
    raiz.setHorizontalTextPosition(SwingConstants.CENTER);
    raiz.setMargin(new Insets(2, 14, 2, 14));
    raiz.setBounds(new Rectangle(228, 70, 56, 40));
    raiz.setEnabled(false);

    elevado.setEnabled(false);
    elevado.setBounds(new Rectangle(228, 121, 56, 40));
    elevado.setMargin(new Insets(2, 14, 2, 14));
    elevado.setHorizontalTextPosition(SwingConstants.CENTER);
    elevado.setFocusPainted(true);
    elevado.setActionCommand("^");
    elevado.setFont(new java.awt.Font("Dialog", 1, 12));
    elevado.setMnemonic('+');
    elevado.addActionListener(new Marco1_elevado_actionAdapter(this));
    elevado.setText("X^Y");

    elevadoamenos1.setText("1/X");
    elevadoamenos1.addActionListener(new Marco1_elevadoamenos1_actionAdapter(this));
    elevadoamenos1.setMnemonic('.');
    elevadoamenos1.setFont(new java.awt.Font("Dialog", 1, 12));
    elevadoamenos1.setActionCommand("^");
    elevadoamenos1.setFocusPainted(true);
    elevadoamenos1.setHorizontalTextPosition(SwingConstants.CENTER);
    elevadoamenos1.setMargin(new Insets(2, 14, 2, 14));
    elevadoamenos1.setBounds(new Rectangle(228, 171, 56, 40));
    elevadoamenos1.setEnabled(false);

    exclamacion.setEnabled(false);
    exclamacion.setBounds(new Rectangle(228, 223, 56, 40));
    exclamacion.setMargin(new Insets(2, 14, 2, 14));
    exclamacion.setHorizontalTextPosition(SwingConstants.CENTER);
    exclamacion.setFocusPainted(true);
    exclamacion.setActionCommand("V");
    exclamacion.setFont(new java.awt.Font("Dialog", 1, 12));
    exclamacion.setMnemonic('!');
    exclamacion.addActionListener(new Marco1_exclamacion_actionAdapter(this));
    exclamacion.setText("X!");

    del.setBounds(new Rectangle(236, 13, 48, 46));
    del.setFont(new java.awt.Font("Dialog", 0, 15));
    del.setMnemonic('D');
    del.setText("<-");
    del.addActionListener(new Marco1_del_actionAdapter(this));
    contentPane.add(boton1, null);
    contentPane.add(boton2, null);
    contentPane.add(boton3, null);
    contentPane.add(boton4, null);
    contentPane.add(boton5, null);
    contentPane.add(boton6, null);
    contentPane.add(boton7, null);
    contentPane.add(boton9, null);
    contentPane.add(boton8, null);
    contentPane.add(boton0, null);
    contentPane.add(botonc, null);
    contentPane.add(igual, null);
    contentPane.add(mas, null);
    contentPane.add(menos, null);
    contentPane.add(por, null);
    contentPane.add(entre, null);
    contentPane.add(visor, null);
    contentPane.add(raiz, null);
    contentPane.add(elevado, null);
    contentPane.add(elevadoamenos1, null);
    contentPane.add(exclamacion, null);
    contentPane.add(del, null);
  }

  //Modificado para poder salir cuando se cierra la ventana
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }

// Función que sirve para desactivar botones, activar numeros y poner a cero
void desactivamosbotones(){
  mas.setEnabled(false);
  menos.setEnabled(false);
  por.setEnabled(false);
  entre.setEnabled(false);
  igual.setEnabled(false);
  raiz.setEnabled(false);
  elevadoamenos1.setEnabled(false);
  elevado.setEnabled(false);
  exclamacion.setEnabled(false);
  visor.setText("0");
  del.setEnabled(true);
  boton1.setEnabled(true);
  boton2.setEnabled(true);
  boton3.setEnabled(true);
  boton4.setEnabled(true);
  boton5.setEnabled(true);
  boton6.setEnabled(true);
  boton7.setEnabled(true);
  boton8.setEnabled(true);
  boton9.setEnabled(true);
  boton0.setEnabled(true);
}

// Método para Activar los operandos
void activarOperandos(){
// Si en la variable primernumero no tenemos nada metido (es cero), activamos
// los botones de operación.
if (primernumero==0){
    mas.setEnabled(true);
    menos.setEnabled(true);
    por.setEnabled(true);
    entre.setEnabled(true);
    raiz.setEnabled(true);
    elevado.setEnabled(true);
    elevadoamenos1.setEnabled(true);
    exclamacion.setEnabled(true);
  }
}

void escribir(String numero){
  // Escribimos el numero en pantalla; Si en principio es cero, substituimos

// Si el texto es distinto de cero, concatenamos
  if (visor.getText().compareTo("0")!=0)
    visor.setText(visor.getText() + numero);
// Si es cero, substituimos
  else
    visor.setText(numero);
}

void activarIgual(){
// Si tenemos algún numero en la variable primernumero, activamos el igual
  if (primernumero != 0)
    igual.setEnabled(true);
}

  void botonc_actionPerformed(ActionEvent e) {
    desactivamosbotones();
    primernumero=0;
  }

  void boton0_actionPerformed(ActionEvent e) {
    escribir("0");
  }

  void boton1_actionPerformed(ActionEvent e) {
    escribir("1");
    activarOperandos();
    activarIgual();
  }

  void boton2_actionPerformed(ActionEvent e) {
  escribir("2");
  activarOperandos();
  activarIgual();
}

void boton3_actionPerformed(ActionEvent e) {
  escribir("3");
  activarOperandos();
  activarIgual();
}

void boton4_actionPerformed(ActionEvent e) {
  escribir("4");
  activarOperandos();
  activarIgual();
}

void boton5_actionPerformed(ActionEvent e) {
  escribir("5");
  activarOperandos();
  activarIgual();
}

void boton6_actionPerformed(ActionEvent e) {
  escribir("6");
  activarOperandos();
  activarIgual();
}

void boton7_actionPerformed(ActionEvent e) {
  escribir("7");
  activarOperandos();
  activarIgual();
}

void boton8_actionPerformed(ActionEvent e) {
  escribir("8");
  activarOperandos();
  activarIgual();
}

void boton9_actionPerformed(ActionEvent e) {
  escribir("9");
  activarOperandos();
  activarIgual();
}

  void mas_actionPerformed(ActionEvent e) {
// Guardamos el número en una variable
    guardarnumero();
    operacion=1;
  }
  void guardarnumero(){
// Guardamos el numero en una variable de clase
   primernumero = new Float (visor.getText()).floatValue();
// Desactivamos los botones
   desactivamosbotones();
// ponemos a cero el visor
   visor.setText("0");
}

// metodo que desactiva todos los botones menos la tecla C
    private void activamossoloc(){
      boton1.setEnabled(false);
      boton2.setEnabled(false);
      boton3.setEnabled(false);
      boton4.setEnabled(false);
      boton5.setEnabled(false);
      boton6.setEnabled(false);
      boton7.setEnabled(false);
      boton8.setEnabled(false);
      boton9.setEnabled(false);
      boton0.setEnabled(false);
      mas.setEnabled(false);
      menos.setEnabled(false);
      por.setEnabled(false);
      entre.setEnabled(false);
      raiz.setEnabled(false);
      igual.setEnabled(false);
      elevado.setEnabled(false);
      elevadoamenos1.setEnabled(false);
      exclamacion.setEnabled(false);
      del.setEnabled(false);
    }

  void menos_actionPerformed(ActionEvent e) {
    guardarnumero();
    operacion=2;
  }

  void por_actionPerformed(ActionEvent e) {
    guardarnumero();
    operacion=3;
  }

  void entre_actionPerformed(ActionEvent e) {
    guardarnumero();
    operacion=4;
  }

  void raiz_actionPerformed(ActionEvent e) {
    guardarnumero();
    visor.setText(Double.toString(Math.sqrt(primernumero)));
    activamossoloc();
  }

  void elevado_actionPerformed(ActionEvent e) {
    guardarnumero();
    operacion=5;
  }

  void elevadoamenos1_actionPerformed(ActionEvent e) {
    guardarnumero();
    visor.setText(Double.toString(1/primernumero));
    activamossoloc();
  }

  void exclamacion_actionPerformed(ActionEvent e) {
    guardarnumero();
    double cont=0;
    for (cont=primernumero-1;cont>1;cont--)
      primernumero*=cont;
    visor.setText(Double.toString(primernumero));
    activamossoloc();
  }

  void igual_actionPerformed(ActionEvent e) {
    calcular resultado = new calcular();
    switch (operacion){
      case 1: visor.setText(resultado.Suma(primernumero,visor.getText())); break;
      case 2: visor.setText(resultado.Resta(primernumero,visor.getText())); break;
      case 3: visor.setText(resultado.Multiplica(primernumero,visor.getText())); break;
      case 4: visor.setText(resultado.Divide(primernumero,visor.getText())); break;
      case 5: visor.setText(resultado.Eleva(primernumero,visor.getText())); break;
    }//switch
    activamossoloc();//dejamos activo solo el boton C
  }

  void del_actionPerformed(ActionEvent e) {
// Si el numero que tenemos es distinto de cero
    if (visor.getText().compareTo("0")!=0){
      int var=new Float(visor.getText()).intValue();
// lo dividimos entre 10
      var=var/10;
      visor.setText(Float.toString(var));
    }
  }
}

class Marco1_botonc_actionAdapter implements java.awt.event.ActionListener {
  Marco1 adaptee;

  Marco1_botonc_actionAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.botonc_actionPerformed(e);
  }
}

class Marco1_boton0_actionAdapter implements java.awt.event.ActionListener {
  Marco1 adaptee;

  Marco1_boton0_actionAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.boton0_actionPerformed(e);
  }
}

class Marco1_boton1_actionAdapter implements java.awt.event.ActionListener {
  Marco1 adaptee;

  Marco1_boton1_actionAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.boton1_actionPerformed(e);
  }
}

class Marco1_boton2_actionAdapter implements java.awt.event.ActionListener {
  Marco1 adaptee;

  Marco1_boton2_actionAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.boton2_actionPerformed(e);
  }
}

class Marco1_boton3_actionAdapter implements java.awt.event.ActionListener {
  Marco1 adaptee;

  Marco1_boton3_actionAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.boton3_actionPerformed(e);
  }
}

class Marco1_boton4_actionAdapter implements java.awt.event.ActionListener {
  Marco1 adaptee;

  Marco1_boton4_actionAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.boton4_actionPerformed(e);
  }
}

class Marco1_boton5_actionAdapter implements java.awt.event.ActionListener {
  Marco1 adaptee;

  Marco1_boton5_actionAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.boton5_actionPerformed(e);
  }
}

class Marco1_boton6_actionAdapter implements java.awt.event.ActionListener {
  Marco1 adaptee;

  Marco1_boton6_actionAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.boton6_actionPerformed(e);
  }
}

class Marco1_boton7_actionAdapter implements java.awt.event.ActionListener {
  Marco1 adaptee;

  Marco1_boton7_actionAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.boton7_actionPerformed(e);
  }
}

class Marco1_boton8_actionAdapter implements java.awt.event.ActionListener {
  Marco1 adaptee;

  Marco1_boton8_actionAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.boton8_actionPerformed(e);
  }
}

class Marco1_boton9_actionAdapter implements java.awt.event.ActionListener {
  Marco1 adaptee;

  Marco1_boton9_actionAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.boton9_actionPerformed(e);
  }
}

class Marco1_mas_actionAdapter implements java.awt.event.ActionListener {
  Marco1 adaptee;

  Marco1_mas_actionAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.mas_actionPerformed(e);
  }
}

class Marco1_menos_actionAdapter implements java.awt.event.ActionListener {
  Marco1 adaptee;

  Marco1_menos_actionAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.menos_actionPerformed(e);
  }
}

class Marco1_por_actionAdapter implements java.awt.event.ActionListener {
  Marco1 adaptee;

  Marco1_por_actionAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.por_actionPerformed(e);
  }
}

class Marco1_entre_actionAdapter implements java.awt.event.ActionListener {
  Marco1 adaptee;

  Marco1_entre_actionAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.entre_actionPerformed(e);
  }
}

class Marco1_igual_actionAdapter implements java.awt.event.ActionListener {
  Marco1 adaptee;

  Marco1_igual_actionAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.igual_actionPerformed(e);
  }
}

class Marco1_raiz_actionAdapter implements java.awt.event.ActionListener {
  Marco1 adaptee;

  Marco1_raiz_actionAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.raiz_actionPerformed(e);
  }
}

class Marco1_elevado_actionAdapter implements java.awt.event.ActionListener {
  Marco1 adaptee;

  Marco1_elevado_actionAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.elevado_actionPerformed(e);
  }
}

class Marco1_elevadoamenos1_actionAdapter implements java.awt.event.ActionListener {
  Marco1 adaptee;

  Marco1_elevadoamenos1_actionAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.elevadoamenos1_actionPerformed(e);
  }
}

class Marco1_exclamacion_actionAdapter implements java.awt.event.ActionListener {
  Marco1 adaptee;

  Marco1_exclamacion_actionAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.exclamacion_actionPerformed(e);
  }
}

class Marco1_del_actionAdapter implements java.awt.event.ActionListener {
  Marco1 adaptee;

  Marco1_del_actionAdapter(Marco1 adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.del_actionPerformed(e);
  }
}
