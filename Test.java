import java.util.ArrayList;

import junit.framework.TestCase;

public class Test extends TestCase {
	private Grafo grafo;
	
	public void escenario() {
		grafo= new Grafo(3);
	
		
	}
	 public void testDevolver(){
	       escenario();
	       assertEquals(grafo.devolver(0,0),0);
	    }
	 
	 public void testnuevaCiudad() {
		  escenario();
		  grafo.nuevaCiudad(0, 0);
	       assertEquals(grafo.devolver(0,0),1);
		 
	 }
	 public void testEliminarCiudad() {
		  escenario();
		  grafo.nuevaCiudad(0, 0);
		  grafo.eliminarCiudad(0, 0);
	       assertEquals(grafo.devolver(0,0),0);
		 
	 }
	 
	
	    

}
