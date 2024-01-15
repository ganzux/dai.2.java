/*

	                   ÁLVARO ALCEDO MORENO   2º D.A.I.

Clase principal: Aquí se codificará el botón Actualizar, que lo único que hará
será crear un objeto de clase Fichero y llamr al método LeeClientes; he preferido
hacerlo por separado por comodidad y limpieza.

*/


/////////////////////// Código del proyecto /////////////////////////

// Cuando presiona el botón Actualizar...
void jButtonActualizar_actionPerformed(ActionEvent e) {

	// Creamos un objeto de la clase fichero
	Fichero Myfile = new Fichero();

	// Llamamos al método LeeClientes de Myfile
    Myfile.LeeClientes();

// Resto de operaciones del botón: Restaurar ventana, mensajes de confirmación...
  }
  
/////////////////////// Código del proyecto /////////////////////////