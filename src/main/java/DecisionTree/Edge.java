package DecisionTree;

public class Edge {
    Node originNode;
    Node destinationNode;
    String answer;

    public Edge(Node origin, Node destination, String answerValue){
        originNode = origin;
        destinationNode = destination;
        answer = answerValue.trim();
    }
}