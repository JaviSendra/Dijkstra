package es.upm.dit.adsw.ej2;

/**
 * Nodes in a graph.
 * @author Javier García Cotarelo
 * @author Jesús Miguel García Sanchez
 * @author Javier Sendra Ramos
 * @version 06/03/2019
 */

public class Node {
	//atributos
	public String name;
	public int x;
	public int y;
	/**
	 * Constructor
	 * @throws IllegalArgumentException if name is null or empty. 
	 */
   public Node(String name,int x, int y) {
	   if(name==null || name.isEmpty())
		   throw new IllegalArgumentException("Error");
	   this.name= name;
	   this.x=x;
	   this.y=y;
   }
    
    /**
     * Getter.
     */
   public String getName() {
	return name;
}

   /**
    * Getter.
    */
   public int getX() {
	return x;
}

   /**
    * Getter.
    */
   public int getY() {
	return y;
}
   
   /**
    * String representation.
    */
    @Override
public String toString() {
	return "Node [name=" + name + ", x=" + x + ", y=" + y + "]";
}

 
}
