import java.util.Scanner;

//=================================================
// Katie Charubin
// Project 1: Recursive Maze Solver
// 9/13/2022
//
// The point class stores a maze coordinate. 
//=================================================
class Point{

    // data members
    int x;
    int y;

    // x holds x-coordinate, y hold y-coordinate

    // default constructor
    Point(){
        x = 0;
        y = 0;
    } 

    // overloaded constructor
    Point(int x_val, int y_val){
        x = x_val;
        y = y_val;
    }

    // copy constructor
    Point(Point other){
        x = other.x;
        y = other.y;
    }


    // getX method
    int getX(){
        return x;
    }


    // getY method
    int getY(){
        return y;
    }


    // setX method
    public void setX(int newX){
        x = newX;
    }


    // setY method
    public void setY(int newY){
        y = newY;
    }


    // isEqual method
    public boolean isEqual(Point p){
        if (p.getX() == x && p.getY() == y){
            return true;
        } else {
            return false;
        }
    }


    // read method
    public static Point read(Scanner s){
        
        int tempX = s.nextInt();
        int tempY = s.nextInt();
        Point p = new Point(tempX, tempY);
        return p;
    }


    // print method
    public String print(){
        int xVal = x;
        int yVal = y;
        String s = "(" + xVal + "," + yVal + ")";
        return s;
    }


}