/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoe;
import java.util.Scanner;
/**
 *
 * @author Farhan
 */

public class Game

{
    //No need to convert int to string 
    private String[][] board; 

    public Game()
    {
        //A matrix of integers resulted in the ASCII number of the characters to appear
        board = new String[][]
        {
        {"0","0","0"},
        {"0","0","0"},
        {"0","0","0"},
        };
    }

   
    public String userInput(String symbol)
    {
        if (symbol.equals("Y")) //"O" is confusing 

        {
            return "Y";
        }
        return "X";
    }

   
    /**
     * Checks if there are any winners after a move is placed
     * @param symbol Y or X
     * @return true if there is a winner
     */
    public boolean winningCondition(String symbol)
    {
        boolean check = false;
        for (int i = 0; i < 3; i++)
        {            
            if (board[i][0].equals(symbol) && board[i][1].equals(symbol) && board[i][2].equals(symbol))
            {
                return true;
            }
            
            if (board[0][i].equals(symbol) && board[1][i].equals(symbol) && board[2][i].equals(symbol))
            {
                return true;
            }
            
        }
        
        if ((board[0][0].equals(symbol) && board[1][1].equals(symbol) && board[2][2].equals(symbol)) || 
            (board[0][2].equals(symbol) && board[1][1].equals(symbol) && board[2][0].equals(symbol)))
            {
                return true;
            }
        
        return false;
    }
    
    /**
     * Checks if the selected area is available to fill
     * @param row The row of the board
     * @param col The Column of the board
     * @return true if there is an empty field. false if there field is taken.
     */
    public boolean condition(int row, int col)
    {
        if(board[row][col].equals("0"))
        {
            return true;
        }
        
        return false;
    }
    
    /**
     * Checks if there are any open spaces for a symbol to fill 
     * @return true if the there is an empty field, else return false
     */
    public boolean gameCondition()
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j].equals("0"))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    /**
     * Places "Y" inside of the chosen field
     * @param row 
     * @param col
     * @return The field where the change is made
     */
    public String player1Input(int row, int col)
    {
        board[row][col] = userInput("Y");
       
        return board[row][col];
    }
    
     /**
     * Places "X" inside of the chosen field
     * @param row 
     * @param col
     * @return The field where the change is made
     */
    public String player2Input(int row, int col)
    {
        board[row][col] = userInput("X");
 
        return board[row][col];
    }
    
    /**
     * Updates board every time a symbol is placed
     */
    public void updateBoard()
    {
        //First Row
        for (int i = 0; i < 1; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                System.out.print(" " + board[i][j] + " | ");
            }
        }
        System.out.println(" ");
        System.out.println("---- ---- ----");
        
        //Second Row
        for (int i = 1; i < 2; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                System.out.print(" " + board[i][j] + " | ");
            }
        }
        System.out.println(" ");
        System.out.println("---- ---- ----");
        
        //Third Row
        for (int i = 2; i < 3; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                System.out.print(" " + board[i][j] + " | ");
            }
        }
        
        System.out.println(" ");
    }
    
    /**
     * Player 1 chooses a place 
     * Check condition, if true, continue. If false, try again 
     * Exit the inner loop, check if the winning condition is met.
     * Player 2 choose a place
     * Check condition 
     * Check if the winning condition is met
     * 
     */
    public void gameplay()
    {
        Scanner input = new Scanner(System.in);
        int [][] spot;
        while(true)
        {
            while(true)
            {
                System.out.println("Player 1: Choose a number from (0 - 2)");
                System.out.println("Which row: ");
                int row = input.nextInt();
                System.out.println("Which column: ");
                int col = input.nextInt();
                
                if (condition(row, col) == false)
                {
                    System.out.println("Spot taken. Try Again!");
                     continue;
                }
                else
                {
                    player1Input(row, col);
                    break;
                }
            }
            updateBoard();
            
            //Break if winning condition is met
            if (winningCondition("Y") == true)
            {
                System.out.println("Player 1 Wins!");
                break;
            }
            
            if (gameCondition() == false)
            {
                System.out.println("It's a draw!");
                break;
            }
            
            while (true)
            {
                System.out.println("Player 2: Choose a number from (0 - 2)");
                System.out.println("Which row: ");
                int row = input.nextInt();
                System.out.println("Which column: ");
                int col = input.nextInt();
                
                if (condition(row, col) == false)
                {
                    System.out.println("Spot taken. Try again!");
                    continue;
                }
                else
                {
                    player2Input(row, col);
                    break;
                }
            }
            
            updateBoard();
            if(winningCondition("X") == true)
            {
                System.out.println("Player 2 Wins");
                break;
            }
            
            if (gameCondition() == false)
            {
                System.out.println("It's a draw!");
                break;
            }
        }
    }
    
    
    
}

               