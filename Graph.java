package es.upm.dit.adsw.ej2;
import java.util.*;

/**
	 * Graph: nodes + links.
	 * @author Jesús Miguel García Sánchez 
	 * @author Javier García Cotarelo 
	 * @author Javier Sendra Ramos
	 * @version 06/03/2019
	 * 
	 */

public class Graph {
private List<Link>links;
private List<Node>nodes;
private Map<String, Node> nodeMap;
private Map<Node, List<Link>> linkMap;
/* 
 * Constructor
 */
	public Graph() {
		links=new ArrayList<Link>();
	    nodes=new ArrayList<Node>();
	    nodeMap = new HashMap<String, Node>();
		linkMap = new HashMap<Node, List<Link>>();
	}
	/*
	 * Add a Link 
	 * @param link -Link to be added
	 */
	
	public void addLink(Link link) {
		
          links.add(link);
          
          Node source = nodeMap.get(link.getSrc());
  		if (linkMap.containsKey(getNode(link.getSrc()))) {
  			List<Link> auxList = linkMap.get(source);
  			auxList.add(link);
  			linkMap.put(source, auxList);
  		}
  		else {
  			List<Link> newLink = new ArrayList<>();
  			newLink.add(link);
  			linkMap.put(source, newLink);
  		}
	}
	/*
	 * Add a bidirectional link. A to B, and B to A.
	 * @param a - one node
	 * @param b -another node
	 * @param w -link weight
	 */
	
	public void addLink2D (String a, String b, int w) {
		
		Link ard=new Link(a,b,w);
		links.add(ard);
		 Node source = nodeMap.get(ard.getSrc());
	  		if (linkMap.containsKey(getNode(ard.getSrc()))) {
	  			List<Link> auxList = linkMap.get(source);
	  			auxList.add(ard);
	  			linkMap.put(source, auxList);
	  		}
	  		else {
	  			List<Link> newLink = new ArrayList<>();
	  			newLink.add(ard);
	  			linkMap.put(source, newLink);
	  		}
			Link bard=new Link(b,a,w);
			links.add(bard);
			 Node source2 = nodeMap.get(bard.getSrc());
		  		if (linkMap.containsKey(getNode(bard.getSrc()))) {
		  			List<Link> auxList2 = linkMap.get(source2);
		  			auxList2.add(bard);
		  			linkMap.put(source2, auxList2);
		  		}
		  		else {
		  			List<Link> newLink2 = new ArrayList<>();
		  			newLink2.add(bard);
		  			linkMap.put(source2, newLink2);
		  		}
			
		}


	/*
	 * Add a Node 
	 * @param node -Node to be added
	 */
	
	public void addNode(Node node) {
		nodes.add(node);	
		nodeMap.put(node.getName(), node);
	}
	/*
	 * Getter
	 * @returns list of nodes. The empty list if there are none.
	 */
	public List<Node> getNodes(){
		return nodes;
	}
	/*
	 * Getter Get a node by name 
	 * @returns null if not such node.
	 */
	
	public Node getNode(String name) {
		return nodeMap.get(name);
		}
	/*
	 * Getter Links in the graph
	 * @returns The empty list if there are none. 
	 */
	public List<Link> getLinks(){
		return links;
	}
	/*
	 * Getter Links from a given node
	 * @param node -source node. 
	 * @returns list of links starting at the given node. The empty list if there is none. 
	 */
	
	public List<Link> getLinks (Node node) {
		 List<Link> linksA = new ArrayList<Link>();
		 if(linkMap.get(node)==null)
			 return linksA;
	    
		return linkMap.get(node);
	    
	}
/*
 * Get link from a source to a destination node.
 * @param src-source node
 * @param dst- destination node
 * @returns- link from src to dst. null if no link.
 */
	
	public Link getLink(Node src, Node dst) {
		
		List<Link> list1 = linkMap.get(src);
	
		for(int i =0;i<list1.size();i++) 
			if(list1.get(i).getDst()==dst.getName())
				return list1.get(i);
		
			return null;
			
		
		}

	/*
	 * Aggregated weight of a list of nodes
	 * @param path - list of nodes.
	 * @returns - total weight. -1 if some link is missing.
	 */
	
	public int getWeight (List<Node> path) {
		if (path.size() == 0)
			return -1;
		int totalweight = 0;
		for (int i = 1; i < path.size(); i++) {
			if (getLink(path.get(i - 1), path.get(i)) != null)
				totalweight = totalweight + getLink(path.get(i - 1), path.get(i)).getWeight();
			else
				return -1;
		}
		return totalweight;
	}
	
	
}	
