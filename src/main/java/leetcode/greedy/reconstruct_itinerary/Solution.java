package leetcode.greedy.reconstruct_itinerary;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

	Map<String, PriorityQueue<String>> targets = new HashMap<>();

	List<String> route = new LinkedList<>();
	
	public List<String> findItinerary(List<List<String>> tickets) 
	{
		for(List<String> ticket : tickets)
		{
			targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
		}
		visit("JFK");
		return route;
	}

	private void visit(String airport) 
	{
		while(targets.containsKey(airport) && !targets.get(airport).isEmpty())
		{
			visit(targets.get(airport).poll());
		}

		route.add(0,airport);
	}
}
