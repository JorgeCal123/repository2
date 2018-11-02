package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Club;
import modelo.Due�o;
import modelo.Mascota;

class Due�oTest {

	private Mascota x,y,z,w;
	private Due�o a;
	private Club cm;
	
	@BeforeEach
	void setUp() {
		cm = new Club();
		a = new Due�o("321", "Andres", "Gomez", "2014-06-20");
		cm.setPrimerDue�o(a);
	}
	
	@BeforeEach
	void setUp2() {
		setUp();
		x = new Mascota("Teo", "2000-10-27", 1, 1);
		y = new Mascota("Puppy", "2005-06-06", 1, 1);
		z = new Mascota("Garfield", "2008-03-23", 1, 2);
		w = new Mascota("Firulais", "2007-02-14", 1, 1);
		a.setPrimeraMascota(x);
		x.setSiguiente(y);
		y.setSiguiente(z);
		z.setSiguiente(w);
	}

	@Test
	void testAgregarMascota() {
		try {
			setUp();
			Mascota una = new Mascota("Este", "", 1, 2);
			cm.getPrimerDue�o().agregarMascotaAlFinal(una);
			assertTrue(cm.getPrimerDue�o().getPrimeraMascota() == una);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testBuscarMascota() {
		try {
			setUp2();
			assertTrue(cm.getPrimerDue�o().buscarMascota("puppy") == cm.getPrimerDue�o().getPrimeraMascota().getSiguiente());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	void testEliminarMascota() {
		try {
			setUp2();
			cm.getPrimerDue�o().eliminarMascota("teo");
			assertTrue(cm.getPrimerDue�o().getPrimeraMascota() == y);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
