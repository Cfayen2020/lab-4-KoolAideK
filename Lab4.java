public class Lab4
{
    public static void turnRight()
    {
        Robot.turnLeft();
        Robot.turnLeft();
        Robot.turnLeft();
    }

    public static void turnAround()
    {
        Robot.turnLeft();
        Robot.turnLeft();
    }

    public static void backUp()
    {
        turnAround();
        Robot.move();
        turnAround();
    }
    //completes a column
    public static void darkenBar(){
        Robot.turnLeft();
        while(!Robot.onDark()){
            Robot.makeDark();
            Robot.move();
        }
    }
    //next bar
    public static void nextBar(){
        turnAround();
        while(Robot.frontIsClear()){
            Robot.move();
        }
        Robot.turnLeft();
        Robot.move();
    }
    //darkenboard()
    public static void darkenBoard(){
        while(Robot.frontIsClear()){
            darkenBar();
            nextBar();
        }
        darkenBar();
    }

    public static void completeBars()
    {
        //insert instructions below
        darkenBoard();

    }

    public static void testCompleteBars1()
    {
        Robot.load("bars1.txt");
        Robot.setDelay(0.025);
        completeBars();
    }

    public static void testCompleteBars2()
    {
        Robot.load("bars2.txt");
        Robot.setDelay(0.025);
        completeBars();
    }
    //move block
    public static void moveBlock(){
        if(Robot.onDark()){
            Robot.makeLight();
            turnRight();
            Robot.move();
            Robot.turnLeft();
            while(Robot.onDark()){
                Robot.move();
            }
            Robot.makeDark();
            Reset();
        }
    }
    //reset Robot position
    public static void Reset(){
        turnAround();
        while(Robot.frontIsClear()){
            Robot.move();
        }
        turnRight();
        Robot.move();
        turnRight();
    }
    //combine piles loop
    public static void singlePile(){
        while(Robot.frontIsClear()){
            moveBlock();
            Robot.move();
        }
        moveBlock();
    }

    public static void combinePiles()
    {
        //insert instructions below
        singlePile();

    }

    public static void testCombinePiles1()
    {
        Robot.load("piles1.txt");
        Robot.setDelay(0.025);
        combinePiles();
    }

    public static void testCombinePiles2()
    {
        Robot.load("piles2.txt");
        Robot.setDelay(0.025);
        combinePiles();
    }
    //Go back to dark space
    public static void returnToOrigin(){
        turnAround();
        Robot.move();
        Robot.move();
        turnRight();
    }
    //find next dot
    public static void findNextDot(){
        Robot.move();
        Robot.move();
        if(Robot.onDark()){
            turnAround();
            Robot.move();
            Robot.makeDark();
            turnAround();
            Robot.move();
        }else{
            turnAround();
            Robot.move();
            Robot.move();
            noMoreDots();
        }
    }
    //no more dots
    public static boolean noMoreDots(){
        Robot.move();
        Robot.move();
        if(Robot.onDark()){
            turnAround();
            Robot.move();
            Robot.move();
            turnAround();
            return false;
        }else{
            turnAround();
            Robot.move();
            Robot.move();
            turnRight();
            Robot.move();
            Robot.move();
            if(Robot.onDark()){
                turnAround();
                Robot.move();
                Robot.move();
                turnAround();
                return false;
            }else{
                turnAround();
                Robot.move();
                Robot.move();
                Robot.move();
                Robot.move();
                if(Robot.onDark()){
                    turnAround();
                    Robot.move();
                    Robot.move();
                    turnAround();
                    return false;
                }else{
                    turnAround();
                    Robot.move();
                    Robot.move();
                    Robot.turnLeft();
                    return true;
                }
            }
        }     
    }
    //connect all the dots
    public static void completePuzzle(){
        while(!noMoreDots()){
            findNextDot();
        }
    }

    public static void connectDots()
    {
        //insert instructions below
        //findNextDot();
        completePuzzle();
    }

    public static void testConnectDots1()
    {
        Robot.load("connect1.txt");
        Robot.setDelay(0.025);
        connectDots();
    }

    public static void testConnectDots2()
    {
        Robot.load("connect2.txt");
        Robot.setDelay(0.025);
        connectDots();
    }
}
