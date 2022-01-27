package DecisionTree;

public class Node {
    String name;
    String questionOrOutcome;

    public Node(String nodeName, String nodeQuestionOrOutcome) {
        name = nodeName.trim();
        questionOrOutcome = nodeQuestionOrOutcome.trim();
    }
}

