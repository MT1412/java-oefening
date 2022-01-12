import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DecisionTree {

    static ArrayList<String> readLines() throws FileNotFoundException{
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
    static void createNodeOrEdgeInput(ArrayList<String> fileLinesArrayList) throws FileNotFoundException {
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
            // System.out.println("constructed node: name is " + name + " and question/outcome is " + questionOrOutcome);
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
            // System.out.println("constructed edge: origin is " + origin.name + ", destination is " + destination.name + " and value is " + answerValue);
        }
    }

	public static void main(String[] args) throws IOException {
        createNodeOrEdgeInput(readLines());
        constructNodes(nodesConstructorInput);
        constructEdges(edgesConstructorInput);
	}
}
