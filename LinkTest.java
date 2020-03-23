package es.upm.dit.adsw.ej2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Ejemplo de pruebas de la clase Link.
 * 
 * @author Javier Garcia Cotarelo
 * @author Jesús Miguel García Sanchez
 * @author Javier Sendra Ramos
 * @version 2019.02.15
 * 
 * 
 * 
 */
public class LinkTest {

	
	@Test
	public void test00() {
		Link link = new Link ("A", "B", 1);
		assertEquals ("A", link.getSrc());
		assertEquals ("B", link.getDst());
		assertEquals (1, link.getWeight());
	}

	 /**
     * Probamos los tres casos en los que debe saltar
     * una excepción.
     */
	@Test(expected=IllegalArgumentException.class)
	public void test01() {
	new Link(null,"B",2);
		
	}
	@Test(expected=IllegalArgumentException.class)
	public void test02() {
	new Link("a",null,4);
		
	}
	@Test(expected=IllegalArgumentException.class)
	public void test03() {
	new Link("A","B",-4);
		
	}
}

