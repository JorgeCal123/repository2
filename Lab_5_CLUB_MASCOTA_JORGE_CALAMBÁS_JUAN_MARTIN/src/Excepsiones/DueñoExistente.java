package Excepsiones;

public class Due�oExistente extends Exception {

	
	public Due�oExistente() {
		super("Ya existe alguien con esa misma cedula");
	}
}
