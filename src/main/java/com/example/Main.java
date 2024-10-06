package com.example;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Graph graph = new SingleGraph("Réseau");
        System.setProperty("org.graphstream.ui", "swing");
        try {
            //graph.read("/home/etudiant/ca204216/Documents/Master/Graphe/demo/src/main/resources/TP1_ressources/mesamisimaginaires.dgs");
            graph.read("src\\main\\resources\\TP1_ressources/mesamisimaginaires.dgs");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        Node eric = graph.getNode("Eric");
        Graph graphEric = new SingleGraph("Graphe de Eric");
        // afficher le nombre
        System.out.println(eric.getDegree());
        graphEric.addNode("Eric");
        // afficher les amis de eric
        for(int i = 0; i<eric.getDegree();i++){
            Node friend = eric.getEdge(i).getOpposite(graph.getNode("Eric"));
            graphEric.addNode(friend.getId());
            graphEric.addEdge(eric.getId()+ friend.getId(), eric.getId(), friend.getId()); 
        }
        
    
        // Modifier la taille des sommets selon leurs degrés
        for (Node node : graph) {
            int degree = node.getDegree();
            node.setAttribute("ui.size", (degree + 1) * 5 + "px");
        }
        
        //graph.setAttribute("ui.stylesheet", "url('C:\\Users\\Amine\\OneDrive\\Bureau\\Cours Master 1\\Graph\\TP-1\\src\\main\\resources\\TP1_ressources\\style.css')");

        /*for (Edge edge : graph.edges().collect(java.util.stream.Collectors.toList())) {
            String reseau = edge.getAttribute("reseau").toString();
            edge.setAttribute("ui.class", "reseau_" + reseau.toLowerCase());
        }*/
        
        // Appliquer le style
        //graph.setAttribute("ui.stylesheet", "url('chemin/vers/ton/fichier.css')");
    
        //graph.display(false);
        graph.display();
       // graphEric.display();
    }
    
}