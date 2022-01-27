package nl.sogyo.javaopdrachten.RoboRally;

import java.util.ArrayList;

public class Robot{
    heading facing = heading.north;
    Integer xPosition = 0;
    Integer yPosition = 0;
    Integer speed = 1;
    
    public Robot(heading facingInput, int xPositionInput, int yPositionInput){
        if(facingInput != null){
            facing = facingInput;
        }
        xPosition = xPositionInput;
        yPosition = yPositionInput;
    }
    
    enum heading {
        north,
        east,
        south,
        west
    }

    public interface command {
        void makeRobotDoStuff();            
    }
    
    ArrayList<command> commandsList = new ArrayList<command>();
    
    void printRobotState(){
        commandsList.add(() -> doPrintRobotState());
    }
    void doPrintRobotState(){
        System.out.println("This robot is facing " + facing + " at (" + xPosition + "," + yPosition + ").");
    }
    
    void turnRight(){
        commandsList.add(() -> doTurnRight());
    }
    void doTurnRight(){
        switch(facing){
            case north:
            facing = heading.east;
            break;
            case east:
            facing = heading.south;
            break;
            case south:
            facing = heading.west;
            break;
            case west:
            facing = heading.north;
            break;
        }
    }
    
    void turnLeft(){
        commandsList.add(() -> doTurnLeft());
    }
    void doTurnLeft(){
        switch(facing){
            case north:
            facing = heading.west;
            break;
            case east:
            facing = heading.north;
            break;
            case south:
            facing = heading.east;
            break;
            case west:
            facing = heading.south;
            break;
        }
    }
    
    void forward(){
        commandsList.add(() -> doForward());
    }
    void doForward(){
        moveRobot(this.speed);
    }

    void forward(int inputSpeed){
        if (inputSpeed >= 1 && inputSpeed <=3){
            for (int count = 0; count < inputSpeed; count ++){
                commandsList.add(() -> doForward());
            }
        } else {
            System.out.println("The speed parameter is invalid, please specify speed as 1, 2 or 3.");
        }
    }
    // void doForward(int inputSpeed){
    //     if(inputSpeed <= 3 && inputSpeed >=1){
    //         moveRobot(inputSpeed);
    //     } else {
    //         System.out.println("The speed parameter is invalid, please specify speed as 1, 2 or 3.");
    //     }
    // }
    
    void backward(){
        commandsList.add(() -> doBackward());
    }
    void doBackward(){
        moveRobot(-1);
    }
    
    void moveRobot(int moveSpeed){
        switch(facing){
            case north:
            yPosition += moveSpeed;
            break;
            case east:
            xPosition += moveSpeed;
            break;
            case south:
            yPosition -= moveSpeed;
            break;
            case west:
            xPosition -= moveSpeed;
            break;
        }
    }
    
    public void execute() {
        for (int i = 0; i < commandsList.size(); i++) {	
            commandsList.get(i).makeRobotDoStuff();			
        }
    }

    public static void main(String[] args) {
        Robot firstRobot = new Robot(heading.east, 5, 6);
        firstRobot.printRobotState();
        firstRobot.forward(3);
        firstRobot.turnLeft();
        firstRobot.backward();
        firstRobot.forward();
        firstRobot.forward();
        firstRobot.printRobotState();
        // firstRobot.execute();
        Robot secondRobot = new Robot(heading.south, 0, 1);
        secondRobot.backward();
        secondRobot.turnLeft();
        secondRobot.turnLeft();
        secondRobot.printRobotState();
        secondRobot.execute();
    }
}
