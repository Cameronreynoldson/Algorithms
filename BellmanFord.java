import java.util.*;



public class BellmanFord
{
	public void shortestPath(int[][] graph, int start, int end, int numEdges)
	{
		int v = graph.size();
		int e = numEdges; 
		int[] distance = new int[v+1];

		for(int i = 0; i < v; ++i)
		{
			distance[i] = Integer.MAX_VALUE; 
		}

		distance[start] = 0; 


		for(int i = 1; i < v; ++i) //n-1 iterations for algorithm 
		{
			for(int sourceNode = 1; sourceNode <= v; ++sourceNode) //iterate through all edges
			{
				for(int destinationNode = 1; destinationNode <= v; ++destinationNode)
				{
					if(graph[sourceNode][destinationNode] != Integer.MAX_VALUE)
					{
						if(distance[destinationNode] > distance[sourceNode] + graph[sourceNode][destinationNode])
						{
							distance[destinationNode] = distance[sourceNode] + graph[sourceNode][destinationNode];
						}
					}
				}
			}
		}

		for(sourceNode = 1; sourceNode <= v; ++sourceNode) //iterate through all edges
			{
				for(destinationNode = 1; destinationNode <= v; ++destinationNode)
				{
					if(graph[sourceNode][destinationNode] != Integer.MAX_VALUE)
					{
						if(distance[destinationNode] > distance[sourceNode] + graph[sourceNode][destinationNode])
						{
							System.out.println("Edges still updating, graph contains negative cycle");
						}
					}
				}
			}


	}
}