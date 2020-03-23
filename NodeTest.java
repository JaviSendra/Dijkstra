package es.upm.dit.adsw.ej2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Ejemplo de pruebas de la clase Node.
 * 
 * @author Jesús Miguel García Sánchez 
 * @author Javier García Cotarelo 
 * @author Javier Sendra Ramos
 * @version 2019.02.18
 * 
 * COMPLETAR HASTA CUBRIR TODOS LOS CASOS
 * 
 */
public class NodeTest {

	@Test
	public void test00() {
		Node node =  new Node("A",0,0);
		assertEquals("A",node.getName());
		assertEquals(0,node.getX());
		assertEquals(0,node.getY());
	}
	 /**
     * Probamos los dos casos en los que debe saltar
     * una excepción.
     */
	@Test(expected=IllegalArgumentException.class)
	public void test02() {
	new Node("",4,0);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test03() {
	new Node(null,4,0);
	}


}
