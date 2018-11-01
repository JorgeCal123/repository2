package application;

import java.time.LocalDate;

import Excepsiones.DueñoExistente;
import Excepsiones.DueñoNoEncontrado;
import Excepsiones.FechaNoEscrita;
import Excepsiones.MascotaNoEncontrado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Labeled;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.control.Alert.AlertType;
import modelo.Dueño;
import modelo.Mascota;

public class ControlInterfaz {
	
	@FXML
	private TabPane principal;
	@FXML
	private Pane editarDueno;
	
	@FXML
	private TextField nombreMascota;
	@FXML
	private DatePicker fechaNMascota;
	@FXML
	private MenuButton generoMascota;
	@FXML
	private MenuButton tipoMascota;
	
	@FXML
	private TextField cedulaDueno;
	@FXML
	private TextField nombreDueno;
	@FXML
	private TextField apellidoDueno;
	@FXML
	private DatePicker fechaNDueno;
	
	
	@FXML
	private DatePicker fecha;
	@FXML
	private TextArea infLista;
	
	private int gen;
	private int tip;
	private Main m;
	
	public void initialize(){
		m=new Main();
		m.iniciarClub();
		fechaNDueno.setEditable(false);		  
		MenuGeneroMascota();
		MenuTipoMascota();
		
		
	}
	
	public void registrarDuenos() {
		try {
			Dueño nuevo=new Dueño(cedulaDueno.getText(), nombreDueno.getText(), apellidoDueno.getText(), fechaNDueno.getValue().toString());
			
			if(cedulaDueno.getText().equals("")|| nombreDueno.getText().equals("")|| apellidoDueno.getText().equals("")|| fechaNDueno.getValue().toString().equals("")) {
			//	System.out.println("entra ni idea");
			}
			m.darClub().agregarDuenio(nuevo);
			mensajeDueñoRegistrado(nuevo);
		}
		
		catch(DueñoExistente e) {
			mensajeErrorDeDatos(e.getMessage());
		}
		
	}
	
	public void mensajeDueñoRegistrado(Dueño d) {
		Alert r=new Alert(AlertType.INFORMATION);
		r.setContentText("Se registro correctamente a "+d.getNombre()+ " con cedula " + d.getCedula() );
		r.showAndWait();
	}
	
	
	public void buscarDuenos() {
		String mensaje="";
		try {
		if(!cedulaDueno.getText().equals("")) {
			mensaje=cedulaDueno.getText();
			m.darClub().buscarDuenio(cedulaDueno.getText());
			mostrarDatosDueño(mensaje);
			}
		else if(!nombreDueno.getText().equals("")) {
				mensaje=nombreDueno.getText();
				m.darClub().buscarDuenio(mensaje);				
				mostrarDatosDueño(mensaje);
			}
		else {
				throw new NullPointerException();
			}
		}
		catch(NullPointerException e) {
			mensajeErrorDeDatos("Debe ingresar el nombre o la cedula del dueño");
		}
		catch(DueñoNoEncontrado e) {
			mensajeErrorDeDatos(e.getMessage());
		}
	
	}
	
	public void mostrarDatosDueño(String mensaje) throws DueñoNoEncontrado{
		nombreDueno.setText(m.darClub().buscarDuenio(mensaje).getNombre());
		apellidoDueno.setText(m.darClub().buscarDuenio(mensaje).getApellido());
		cedulaDueno.setText(m.darClub().buscarDuenio(mensaje).getCedula());
		String[] fechas=m.darClub().buscarDuenio(mensaje).getFechaNacimiento().split("-");
		LocalDate f=LocalDate.of(Integer.parseInt(fechas[0]), Integer.parseInt(fechas[1]), Integer.parseInt(fechas[2]));
		fechaNDueno.setValue(f);
	}
	
	
	public void mensajeErrorDeDatos(String mensaje) {
		Alert m=new Alert(AlertType.ERROR);
		m.setContentText(mensaje);
		m.showAndWait();
	}
	
	
	public void modificarDueno() {
		
		String mensaje="";
		try {
		if(!cedulaDueno.getText().equals("") ) {
			mensaje=cedulaDueno.getText();
			m.darClub().buscarDuenio(mensaje).setNombre(nombreDueno.getText());
			m.darClub().buscarDuenio(mensaje).setApellido(apellidoDueno.getText());	
			m.darClub().buscarDuenio(mensaje).setCedula(cedulaDueno.getText());
			m.darClub().buscarDuenio(mensaje).setFechaNacimiento(fechaNDueno.getValue().toString());
			mensajeDueñoModificado(m.darClub().buscarDuenio(mensaje));
		}
			else {
					mensajeErrorDeDatos("Debe ingresar la cedula del dueño para modificar");
				
			}	
		}
		catch(DueñoNoEncontrado e) {
			mensajeErrorDeDatos(e.getMessage());
		}
	
	}
	
	public void mensajeDueñoModificado(Dueño d) {
		Alert r=new Alert(AlertType.INFORMATION);
		r.setContentText("El dueño con cedula "+d.getCedula()+ " cambio sus datos" );
		r.showAndWait();
	}
	
	public void registrarMascota() {
		if(cedulaDueno.getText().equals("")) {
			mensajeErrorDeDatos("para registrar su mascota debe ingresar su cedula");
		}
		else {
		try {
			if(m.darClub().buscarDuenio(cedulaDueno.getText())!=null) {
				if(nombreMascota.getText().equals("")|| fechaNMascota.getValue().toString().equals("")) {
					mensajeErrorDeDatos("debe ingresar todos los datos de la mascota");
				}
				else {
				Mascota nuevo=new Mascota(nombreMascota.getText(), fechaNMascota.getValue().toString(), gen, tip);
					m.darClub().buscarDuenio(cedulaDueno.getText()).agregarMascotaAlFinal(nuevo);	
					mensajeMascotaRegistrada(nuevo);
				}
				}
			else {
				mensajeErrorDeDatos("escriba la cedula del deuño a registrar la mascota");

			}
		} catch (DueñoNoEncontrado e) {
			mensajeErrorDeDatos(e.getMessage());
		}
			
		}
}
	
	public void mensajeMascotaRegistrada(Mascota m) {
		Alert r=new Alert(AlertType.INFORMATION);
		r.setContentText("Se registro correctamente a "+m.getNombre());
		r.showAndWait();
	}
	
	public void buscarMascota() {
		String mensaje="";
		try {
		if(!cedulaDueno.getText().equals("")) {
			
				if(!nombreMascota.getText().equals("")) {
				m.darClub().buscarDuenio(cedulaDueno.getText()).buscarMascota(nombreMascota.getText());	
				mostrarDatosMascota(cedulaDueno.getText(), nombreMascota.getText());
				}
				else if(!fechaNMascota.getValue().toString().equals("")) {
				m.darClub().buscarDuenio(cedulaDueno.getText()).buscarMascota(fechaNMascota.getValue().toString());
				mostrarDatosMascota(cedulaDueno.getText(), fechaNMascota.getValue().toString());

				}
				else {
				throw new MascotaNoEncontrado();
				}
		}
		else {
				throw new NullPointerException();
			}
		
		}
		catch(NullPointerException e) {
			mensajeErrorDeDatos("Debe ingresar el nombre o la cedula del dueño");
		}
		catch(DueñoNoEncontrado e) {
			mensajeErrorDeDatos(e.getMessage());
		}
		catch(MascotaNoEncontrado e) {
			mensajeErrorDeDatos(e.getMessage());				
			}

		}
	public void mostrarDatosMascota(String dueño,String mascota) throws MascotaNoEncontrado, DueñoNoEncontrado{
		nombreMascota.setText(m.darClub().buscarDuenio(dueño).buscarMascota(mascota).getNombre());
		String[] fechas=m.darClub().buscarDuenio(dueño).buscarMascota(mascota).getFechaNacimiento().split("-");
		LocalDate f=LocalDate.of(Integer.parseInt(fechas[0]), Integer.parseInt(fechas[1]), Integer.parseInt(fechas[2]));
		fechaNMascota.setValue(f);
		
		if(m.darClub().buscarDuenio(dueño).buscarMascota(mascota).getGenero()==1) {
			generoMascota.setText("masculino");
		}
		else {
			generoMascota.setText("femenino");
		}
		if(m.darClub().buscarDuenio(dueño).buscarMascota(mascota).getTipo()==1) {
			tipoMascota.setText("Perro");
		}
		else {
			tipoMascota.setText("Gato");
		}
	}

	
public void modificarMascota() {
		
		try {
		if(!cedulaDueno.getText().equals("") ) {
			String mensaje=cedulaDueno.getText();
			Dueño dm=m.darClub().buscarDuenio(mensaje);
			if(dm.buscarMascota(nombreMascota.getText())!=null) {
				dm.buscarMascota(nombreMascota.getText()).setFechaNacimiento(fechaNMascota.getValue().toString());
				dm.buscarMascota(nombreMascota.getText()).setGenero(Integer.parseInt(generoMascota.getText()));
				dm.buscarMascota(nombreMascota.getText()).setTipo(Integer.parseInt(tipoMascota.getText()));
			mostrarDatosMascota(cedulaDueno.getText(), nombreMascota.getText());
			}
			else {
				throw new MascotaNoEncontrado();
			}
			
		}
			else {
					mensajeErrorDeDatos("Debe ingresar la cedula del dueño para modificar");
				
			}	
		}
		catch(DueñoNoEncontrado e) {
			mensajeErrorDeDatos(e.getMessage());
		
		} catch (MascotaNoEncontrado e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void fecha() {
		
		String fecha=fechaNMascota.getValue().toString();
		
		System.out.println(fecha);
		
		String fechas[]=fecha.split("-");
		
		LocalDate d=LocalDate.of(Integer.parseInt(fechas[0]), Integer.parseInt(fechas[1]), Integer.parseInt(fechas[2]));
		
		fechaNDueno.setValue(d);
	}
	
	public void MenuGeneroMascota() {
		MenuItem g1 = new MenuItem("Hembra");
		MenuItem g2 = new MenuItem("Macho");
	
		generoMascota.getItems().add(g1);
		generoMascota.getItems().add(g2);
		
		  javafx.event.EventHandler<ActionEvent> e1 = new javafx.event.EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					String opcion=((MenuItem) event.getSource()).getText();

				if(	((MenuItem)event.getSource()).getText().equals("Macho")) {
					generoMascota.setText(opcion);
					gen=1;
				}
				else {
					generoMascota.setText(opcion);
					gen=2;
				}
				}
			};
			g1.setOnAction(e1);
			g2.setOnAction(e1);
		
	        
	}
	public void MenuTipoMascota() {
		MenuItem tm1=new MenuItem("Perro");
		MenuItem tm2=new MenuItem("Gato");

		tipoMascota.getItems().add(tm1);
		tipoMascota.getItems().add(tm2);

		javafx.event.EventHandler<ActionEvent> e2 =new javafx.event.EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String opcion=((MenuItem) event.getSource()).getText();

				if(	((MenuItem)event.getSource()).getText().equals("Perro")) {
					tipoMascota.setText(opcion);
					tip=1;
				}
				else {
					tipoMascota.setText(opcion);
					tip=2;
				}				

			}
		};
		tm1.setOnAction(e2);
		tm2.setOnAction(e2);
			
		}
	
	public void mostrarListaDuenos2() {
		try {
			System.out.println("ingresa 1");
			if(!fecha.getValue().toString().equals("")) {
		infLista.setText(m.darClub().imprimirDuenio(fecha.getValue().toString()));
		}
			else {
				throw new FechaNoEscrita();
			}
		}
		
		catch(FechaNoEscrita e) {
			mensajeErrorDeDatos(e.getMessage());
		}
	}
	
		public void imprimir() {
			m.darClub().imprimir();
			
		//	System.out.println("encontrado 1 "+m.darClub().buscarDuenio("1").getNombre());
		}
		
		
		public void imprimir2() {
			m.darClub().imprimir2();
			
		//	System.out.println("encontrado 1 "+m.darClub().buscarDuenio("1").getNombre());
		}
		public void imprimir3() throws DueñoExistente, MascotaNoEncontrado {
			m.darClub().imprimir3();
			
		//	System.out.println("encontrado 1 "+m.darClub().buscarDuenio("1").getNombre());
		}

}