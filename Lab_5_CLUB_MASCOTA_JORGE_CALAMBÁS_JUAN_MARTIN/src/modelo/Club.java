package modelo;

import Excepsiones.DueñoExistente;
import Excepsiones.DueñoNoEncontrado;
import Excepsiones.MascotaNoEncontrado;

public class Club {
	

	private Dueño primerDueño;

 	public Club() {
 		primerDueño=null;
 	}

 	public void agregarDuenio(Dueño nuevo) throws DueñoExistente{
		Dueño actual = primerDueño;
		boolean condicion = false;
		if(primerDueño != null) {
			while(actual.getSiguiente() != null) {

				if(!actual.getCedula().equalsIgnoreCase(nuevo.getCedula())) {
					actual = actual.getSiguiente();
				} 
				else {
					condicion = true;
					throw new DueñoExistente();
				}
			}
			if(!condicion) {
				actual.setSiguiente(nuevo);
			} 
		} else {
			primerDueño = nuevo;
		}
		
	}
	
	
 	
 	
 	public Dueño buscarDuenio(String b) throws DueñoNoEncontrado{
		Dueño actual = primerDueño;
		Dueño esta = null;
		boolean encontrada = false;
			while(!encontrada && actual != null) {
				if(actual.getNombre().equalsIgnoreCase(b) || actual.getCedula().equalsIgnoreCase(b)) {
					encontrada = true;
					esta = actual;
				}
				actual = actual.getSiguiente();
			}
			if(esta==null) {
				throw new DueñoNoEncontrado();
			}
		
		return esta;
	}
 	
 	
 	
 	public String imprimirDuenio() {
 		Dueño actual = primerDueño;
		boolean terminar=false;
 		String mensaje="";
 		while(!terminar) {
			if(actual!=null) {	
					mensaje+="*El dueño "+actual.getNombre()+" nacio el "+actual.getFechaNacimiento()+" con cedula "+actual.getCedula()+"\n";
					actual = actual.getSiguiente();
			}
			else {
				terminar=true;
			}
	
		}
 		return mensaje;
 	}
 	
		
 	
 	public String imprimirDuenio(String f) {
 		Dueño actual = primerDueño;
		boolean terminar=false;
 		String mensaje="";
 		
 		while(!terminar) {
 	 		
 	 		if(actual.getSiguiente()==null) {
				terminar=true;
			}
					if(actual.getFechaNacimiento().equals(f)) {
						mensaje+="*El dueño "+actual.getNombre()+" nacio el "+f+"\n";
					}
					actual = actual.getSiguiente();
		}
 		return mensaje;
 	}
 	
 	
 	
 	public void imprimir() {
 		Dueño sig=primerDueño;
			System.out.println(sig.getNombre()+" "+sig.getApellido()+" "+sig.getCedula()+" "+sig.getFechaNacimiento());
 		while(sig.getSiguiente()!=null) {
 			sig=sig.getSiguiente();

 			System.out.println(sig.getNombre()+" "+sig.getApellido()+" "+sig.getCedula()+" "+sig.getFechaNacimiento());
 		}
 	}
 	
 	public void imprimir2() {
 		Dueño d1=new Dueño("1", "j", "c", "12-1");
 		Dueño d2=new Dueño("2", "a", "b", "12-1");
 		
 	//	agregarDuenio(d1);
 	//	agregarDuenio(d2);
 	}
 	
	public void imprimir3() throws DueñoExistente, MascotaNoEncontrado {
 		Dueño d1=new Dueño("1", "jorge", "c", "12-1");
 		Dueño d2=new Dueño("2", "ana", "b", "12-4");
 		Dueño d3=new Dueño("3", "pedro", "b", "12-1");
 		Dueño d4=new Dueño("4", "juan", "b", "12-1");

 		agregarDuenio(d1);
 		agregarDuenio(d2);
 		agregarDuenio(d3);
 		agregarDuenio(d4);
 		
 		Mascota m1=new Mascota("lulu", "18_jul", 1, 1);
 		Mascota m2=new Mascota("jerry", "20_jul", 2, 2);
 		Mascota m3=new Mascota("matias", "150_jul", 2, 2);
 		Mascota m4=new Mascota("kar", "25_jul", 2, 2);

 		d1.agregarMascotaAlFinal(m1);
 		d1.agregarMascotaAlFinal(m2);
 		d1.agregarMascotaAlFinal(m3);
 		d1.agregarMascotaAlFinal(m4);
 	//	System.out.println(imprimirDuenio());

 		System.out.println(imprimirDuenio("12-1"));
 		
 		
 	}
}