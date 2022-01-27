import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            DecisionTree.createNodeOrEdgeInput(DecisionTree.readLinesFromFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DecisionTree.constructNodes(DecisionTree.nodesConstructorInput);
        DecisionTree.constructEdges(DecisionTree.edgesConstructorInput);
        DecisionTree.askQuestions();
	}
}
