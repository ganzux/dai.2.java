/*

	                   �LVARO ALCEDO MORENO   2� D.A.I.

Clase principal: Aqu� se codificar� el bot�n Actualizar, que lo �nico que har�
ser� crear un objeto de clase Fichero y llamr al m�todo LeeClientes; he preferido
hacerlo por separado por comodidad y limpieza.

*/


/////////////////////// C�digo del proyecto /////////////////////////

// Cuando presiona el bot�n Actualizar...
void jButtonActualizar_actionPerformed(ActionEvent e) {

	// Creamos un objeto de la clase fichero
	Fichero Myfile = new Fichero();

	// Llamamos al m�todo LeeClientes de Myfile
    Myfile.LeeClientes();

// Resto de operaciones del bot�n: Restaurar ventana, mensajes de confirmaci�n...
  }
  
/////////////////////// C�digo del proyecto /////////////////////////