import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;


public class MST 

{



	public static void main(String[] args)
	{
		Map<Node,ArrayList<Edge>> map = new HashMap<Node,ArrayList<Edge>>();
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(6);
		Node g = new Node(7);

		map.put(a, new ArrayList<Edge>());
		map.put(b, new ArrayList<Edge>());
		map.put(c, new ArrayList<Edge>());
		map.put(d, new ArrayList<Edge>());
		map.put(e, new ArrayList<Edge>());
		map.put(f, new ArrayList<Edge>());
		map.put(g, new ArrayList<Edge>());
		map.get(a).add(new Edge(a,b,1));
		map.get(a).add(new Edge(a,c,5));
		map.get(b).add(new Edge(b,a,1));
		map.get(b).add(new Edge(b,c,4));
		map.get(c).add(new Edge(c,b,4));
		map.get(c).add(new Edge(c,a,5));
		map.get(c).add(new Edge(c,d,1));
		map.get(c).add(new Edge(c,e,2));
		map.get(d).add(new Edge(d,f,5));
		map.get(d).add(new Edge(d,c,1));
		map.get(d).add(new Edge(d,e,2));
		map.get(d).add(new Edge(d,g,6));
		map.get(e).add(new Edge(e,d,2));
		map.get(e).add(new Edge(e,c,2));
		map.get(e).add(new Edge(e,f,3));
		map.get(f).add(new Edge(f,d,5));
		map.get(f).add(new Edge(f,e,3));
		map.get(g).add(new Edge(g,d,6));

		System.out.println(mstVal(map));

	}

	//prims algorithm 
	
	public static int mstVal(Map<Node,ArrayList<Edge>> map)
	{
		HashSet<Node> set = new HashSet<Node>();
		HashSet<Edge> edgeSet = new HashSet<Edge>();

		for(Map.Entry<Node, ArrayList<Edge>> entry: map.entrySet())
		{
			set.add(entry.getKey());
			break;
		}
		
		int edgesToLookFor = map.size()-1;
		int cost = 0; 
		int index = 0; 
		Edge dummyEdge = new Edge(new Node(1),new Node(2),Integer.MAX_VALUE);
		while(index < edgesToLookFor)
		{
			Edge min = dummyEdge; 
			
			for(Node n: set)
			{
				for(Edge e: map.get(n))
				{
					if(!set.contains(e.other))
					{
						if(e.weight < min.weight)
						{
							min = e; 
						}
					}
				}
			}
			
			edgeSet.add(min);
			cost+=min.weight; 
			set.add(min.other);
			index++;	
		}
		
		
		
		//int cost = 0; 
		
		for(Edge e: edgeSet)
		{
			System.out.println("Node in "+e.in.data+" Node out "+e.other.data);
		}
		
		return cost; 
	}


}



class Node
{
	int data; 

	public Node(int data)
	{
		this.data = data; 
	}
}

class Edge implements Comparable<Edge>
{
	int weight; 
	Node in; 
	Node other; 

	public Edge(Node in, Node out, int weight)
	{
		this.in = in; 
		this.weight = weight; 
		this.other = out; 
	}

	public int compareTo(Edge other)
	{
		if(this.weight > other.weight)
		{
			return 1;
		}
		else
		{
			return -1; 
		}
	}

}