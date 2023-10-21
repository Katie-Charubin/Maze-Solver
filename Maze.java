import java.util.Scanner;

//=================================================
// Katie Charubin
// Project 1: Recursive Maze Solver
// 9/13/2022
//
// The maze class holds the data structure for the maze. 
//=================================================
class Maze{

    // data members
    int r;
    int c;
    Point start;
    Point end;
    char[][] m;


    // member functions

    // default constructor
    Maze(){
        r = 0;
        c = 0;
        start = new Point(0,0);
        end = new Point(0,0);
        m = new char[r][c];

        //creates maze with 0 rows, 0 columns

    }


    // overloaded constructor
    Maze(int ro, int co){
        r = ro;
        c = co;

        //creates maze with specified number of rows and columns

    }

    // initialize method
    public void initialize(){
        
        m = new char[r][c];

        for(int i = 0; i < r; i++){
            for(int j = 0; j<c; j++){
                m[i][j] = '*';
            }
        }

    }
    //sets each point of maze to *


    // read method
    public void read(Scanner s){
        r = s.nextInt() + 2;
        c = s.nextInt() + 2;
        start = Point.read(s);
        end = Point.read(s);

        initialize();
       
        String line = s.nextLine();
        for(int i=1; i < r-1; i++){
            line = s.nextLine();
            for(int j = 1; j < c-1; j++){
                m[i][j] = line.charAt(j-1);
            }
        }

        //reads maze and creates 
    }


    // print method
    public void print(){
        for (int i = 1; i < r-1; i++){
            for (int j = 1; j < c-1; j++){
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }


    // printall method
    public void printall(){
        for(int i =0; i < r; i++){
            for(int j = 0; j <c; j++){
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }


    //findpath method
    public boolean findpath(Point p, char letter, boolean done){ 

        if(p.isEqual(end)){                 //maze solved if current point = end point
            m[p.getX()][p.getY()] = letter;
            done = true; 
        } else {
            done = false;
            m[p.getX()][p.getY()] = letter; //sets current point to current letter
            char nextL = getNextLetter(letter);
            if(!done){
                //check each direction to see if there is a path
                if( m[p.getX()+1][p.getY()] == '.'){
                    Point tempP = new Point((p.getX() + 1), p.getY());

                    if(findpath(tempP, nextL, done)){  
                        return true;
                    } else {
                        m[p.getX()+1][p.getY()] = '.';
                    } 
                    //calls method on new point, returns true if solved

                }
                if( m[p.getX()][p.getY()+1] == '.'){
                    Point tempP = new Point((p.getX()), p.getY()+1);

                    if(findpath(tempP, nextL, done)){
                        return true;
                    } else {
                        m[p.getX()][p.getY()+1] = '.';
                    } 
                }
                if( m[p.getX()-1][p.getY()] == '.'){
                    Point tempP = new Point((p.getX()-1), p.getY());

                    if(findpath(tempP, nextL, done)){
                        return true;
                    } else {
                        m[p.getX()-1][p.getY()] = '.';
                    } 
                }
                if( m[p.getX()][p.getY()-1] == '.'){
                    Point tempP = new Point((p.getX()), p.getY()-1);

                    if(findpath(tempP, nextL, done)){
                        return true;
                    } else {
                        m[p.getX()][p.getY()-1] = '.';
                    } 
                }
            }
        }
        return done; 
        //returns false if current point never = end point
    }

    public char getNextLetter(char l){
        String a = "abcdefghijklmnopqrstuvwxyz";
        int index = a.indexOf(l);
        if(index == 25){
            return 'a';
        } else {
            return a.charAt(index + 1);
        }
    }
    //method to get next letter in (a-z)


}