package modelo;

public class Club {
	

	private Dueño primerDueño;

 	public Club() {
 		primerDueño=null;
 	}

 	public void agregarDueñoAlPrincipio(Dueño nuevo) {
 		Dueño actual = primerDueño;
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
			primerDueño = nuevo;
		}
	}
	
	
 	
 	
 	public Dueño buscarDuenio(String b) {
		Dueño actual = primerDueño;
		Dueño esta = null;
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