package it.polito.tdp.PremierLeague.model;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import it.polito.tdp.PremierLeague.db.PremierLeagueDAO;

public class Model {
	
	private Graph<Team, DefaultWeightedEdge> grafo;
	private Map<Integer, Team> teamsMap;
	private PremierLeagueDAO dao;
	
	public Model() {
		dao = new PremierLeagueDAO();
		teamsMap = new HashMap<>();
	}
	
	public void creaGrafo() {
		
		grafo = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		
		//Vertici
		dao.listAllTeams(teamsMap);
		Graphs.addAllVertices(grafo, teamsMap.values());
	}
	
	
	
	
}
