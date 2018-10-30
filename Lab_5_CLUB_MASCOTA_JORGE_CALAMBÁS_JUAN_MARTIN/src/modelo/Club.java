package modelo;

public class Club {
	

	private Due�o primerDue�o;

 	public Club() {
 		primerDue�o=null;
 	}

 	public void agregarDue�oAlPrincipio(Due�o nuevo) {
 		Due�o actual = primerDue�o;
		boolean condicion = false;
		if(actual != null) {
			while(actual.getSiguiente() != null) {
				if(!actual.getCedula().equalsIgnoreCase(nuevo.getCedula())) {
					actual = actual.getSiguiente();
				} else {
					condicion = true;
				}
				actual = actual.getSiguiente();
			}
			if(!condicion) {
				actual.setSiguiente(nuevo);
			} 
		} else {
			primerDue�o = nuevo;
		}
	}
	
	
 	
 	
 	public Due�o buscarDuenio(String b) {
		Due�o actual = primerDue�o;
		Due�o esta = null;
		boolean encontrada = false;
		if(actual != null) {
			while(!encontrada && actual.getSiguiente() != null) {
				if(actual.getNombre().equalsIgnoreCase(b) || actual.getCedula().equalsIgnoreCase(b)) {
					encontrada = true;
					esta = actual;
				}
				actual = actual.getSiguiente();
			}
		}
		return esta;
	}
 	
 	
 	
}