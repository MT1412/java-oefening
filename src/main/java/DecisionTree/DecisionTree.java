package DecisionTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DecisionTree {

    static ArrayList<String> readLinesFromFile() throws FileNotFoundException{
        ArrayList<String> fileLinesArray = new ArrayList<String>();
        File file = new File("src/main/resources/intermediate/decision-tree-data.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            String currentLine = scan.nextLine();
            fileLinesArray.add(currentLine);
        }
        return fileLinesArray;
    }

    static ArrayList<String[]> nodesConstructorInput = new ArrayList<String[]>();
    static ArrayList<String[]> edgesConstructorInput = new ArrayList<String[]>();
    static void createNodeOrEdgeInput(ArrayList<String> fileLinesArrayList){
        for(int i = 0; i < fileLinesArrayList.size(); i++){
            String str = fileLinesArrayList.get(i);
            String[] columnArray = str.split(",");
            if(columnArray.length == 2){
                nodesConstructorInput.add(columnArray);
            } else if (columnArray.length == 3) {
                edgesConstructorInput.add(columnArray);
            } else { 
                System.out.println("Something wrong here");
            }
        }
    }

    static ArrayList<Node> allNodes = new ArrayList<Node>();
    static void constructNodes(ArrayList<String[]> nodesConstructorInput){
        for (int i = 0; i < nodesConstructorInput.size(); i++){
            String name = nodesConstructorInput.get(i)[0];
            String questionOrOutcome = nodesConstructorInput.get(i)[1];
            allNodes.add(new Node(name, questionOrOutcome));
        }
    }

    static Node getNodeFromString(String input){
        String trimmedInput = input.trim();
        Node matchNode = null;
        for (int i = 0; i < allNodes.size(); i++){
            if(allNodes.get(i).name.equals(trimmedInput)){
                matchNode = allNodes.get(i);
            }
        }
        return matchNode;
    }

    static ArrayList<Edge> allEdges = new ArrayList<Edge>();
    static void constructEdges(ArrayList<String[]> edgesConstructorInput){
        for (int i = 0; i < edgesConstructorInput.size(); i++){
            Node origin = getNodeFromString(edgesConstructorInput.get(i)[0]);
            Node destination = getNodeFromString(edgesConstructorInput.get(i)[1]);
            String answerValue = edgesConstructorInput.get(i)[2];
            allEdges.add(new Edge(origin, destination, answerValue));
        }
    }

    static Node findStartNode(){
        ArrayList<Node> endNodes = new ArrayList<Node>();
        for(int i=0; i<allEdges.size(); i++){
            Node endNode = allEdges.get(i).destinationNode;
            endNodes.add(endNode);
        }
        ArrayList<Node> copyAllNodes = new ArrayList<Node>(allNodes);
        copyAllNodes.removeAll(endNodes);
        Node startNode = null;
        if (copyAllNodes.size() == 1){
            startNode = copyAllNodes.get(0);
        }
        return startNode;
    }

    static void askQuestions(){
        Node currentNode = findStartNode();
        boolean hasEdges = true;
        while(hasEdges){
            System.out.println(currentNode.questionOrOutcome);
            displayEdgeOptions(findEdgeOptions(currentNode));
            System.out.println(displayEdgeOptions(findEdgeOptions(currentNode)));
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Typ een van de bovenstaande antwoordopties.");
            String userSelectEdge = keyboard.nextLine();
            Edge edgeToFollow = matchEdgeOption(userSelectEdge, findEdgeOptions(currentNode));
            System.out.println("Je hebt \"" + edgeToFollow.answer + "\" geselecteerd.");
            currentNode = edgeToFollow.destinationNode;
            if(findEdgeOptions(currentNode).size() == 0){
                hasEdges = false;
                break;
            } else{
                hasEdges = true;
            }
        }
        System.out.println("De boom is een " + currentNode.questionOrOutcome + ".");
    }

    static ArrayList<Edge> findEdgeOptions(Node currentNode){
        ArrayList<Edge> edgeOptions = new ArrayList<Edge>();
        for(int i=0; i<allEdges.size(); i++){
            boolean originNodeIsCurrentNode= (allEdges.get(i).originNode==currentNode)?true:false;
            if(originNodeIsCurrentNode){
                edgeOptions.add(allEdges.get(i));
            }
        }
        return edgeOptions;
    }

    static ArrayList<String> displayEdgeOptions(ArrayList<Edge> edgeOptions){
        ArrayList<String> displayArray = new ArrayList<String>();
        for(int i=0; i<edgeOptions.size(); i++){
            String answer = edgeOptions.get(i).answer;
            displayArray.add(answer);
        }
        return displayArray;
    }

    static Edge matchEdgeOption(String userInput, ArrayList<Edge> edgeOptions){
        Edge selectedEdge = null;
        for(int i=0; i<edgeOptions.size(); i++){
            if(userInput.equalsIgnoreCase(edgeOptions.get(i).answer)){
                selectedEdge = edgeOptions.get(i);
            }
        }
        return selectedEdge;
    }
}
