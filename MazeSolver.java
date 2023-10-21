import java.util.Scanner;

//=================================================
// Katie Charubin
// Project 1: Recursive Maze Solver
// 9/13/2022
//
// The main program calls the maze class to read input and solve the maze.
// It then prints the solved maze or prints that there is no solution. 
//=================================================

class MazeSolver{
    
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for(int i = 0; i < n; i++){

            Maze m = new Maze();
            m.read(in);

            System.out.println();

            boolean solve = m.findpath(m.start, 'a', false);
            if(solve == true){
                m.print();
            } else {
                System.out.println("NO PATH EXISTS");
            }
       }
       System.out.println();
    }
}