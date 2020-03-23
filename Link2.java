package es.upm.dit.adsw.ej2;

	/**
	 * 
	 * @author Jesús Miguel García Sánchez 
     * @author Javier García Cotarelo 
     * @author Javier Sendra Ramos
	 * @version 12/02/2019
	 * Links in a graph
	 */
public class Link {
	private String src;
	private String dst;
	private int weight;
	/*Constructor
	 * @throws IllegalArgumentException - if src or dst is null, if weight is less than 0.
	 * @param src - Source node name.
	 * @param dst - Destination node name. 
	 * @param weight - Weight may model a transit delay, or a line capacity, or a transit cost...
	 */
	public Link(String src, String dst, int weight){
	if (src==null||dst==null||weight<0)
		throw new IllegalArgumentException();
		this.src = src;
		this.dst = dst;
		this.weight = weight;
	}
	/*
	 * String representation.
	 */
	public String toString() {
		return "Link [src=" + src + ", dst=" + dst + ", weight=" + weight + "]";
	}
	/*
	 * Getter
	 */
	public String getSrc() {
		return src;
	}
	/*
	 * Getter
	 */
	public String getDst() {
		return dst;
	}
	/*
	 * Getter
	 */
	public int getWeight() {
		return weight;
	}
	
	
	
}
