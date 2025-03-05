// Name: Ulises Cantor
// Teacher: Mr. Menchukov
// Period: 2
// Program: This file should give proper instructions for how pieces move and work

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Piece {
    private final boolean color;
    private BufferedImage img;
    
    public Piece(boolean isWhite, String img_file) {
        this.color = isWhite;
        
        try {
            if (this.img == null) {
              this.img = ImageIO.read(getClass().getResource(img_file));
            }
          } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
          }
    }
    
    

    
    public boolean getColor() {
        return color;
    }
    
    public Image getImage() {
        return img;
    }
    
    public void draw(Graphics g, Square currentSquare) {
        int x = currentSquare.getX();
        int y = currentSquare.getY();
        
        g.drawImage(this.img, x, y, null);
    }
    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    public ArrayList<Square> getControlledSquares(Square[][] b, Square start) {
      ArrayList<Square> controlledSquares = new ArrayList<Square>();
      int sRow = start.getRow();
      int tempRow = sRow;
      int sCol = start.getCol();
      int tempCol = sCol;
      boolean available = true;
      while (available == true && (tempRow + 1 < 8) && (tempCol + 1 < 8)){
        tempRow++;
        tempCol++;
        if (b[tempRow][tempCol].isOccupied()==false){
          controlledSquares.add(b[tempRow][tempCol]);
        }
        else {
            controlledSquares.add(b[tempRow][tempCol]);
          
          available = false;
        }
      }
      tempRow = sRow;
      tempCol = sCol;
      available = true;
      while (available == true && (tempRow - 1 >= 0) && (tempCol + 1 < 8)){
        tempRow--;
        tempCol++;
        if (b[tempRow][tempCol].isOccupied()==false){
          controlledSquares.add(b[tempRow][tempCol]);
        }
        else {
            controlledSquares.add(b[tempRow][tempCol]);
          
          available = false;
        }
      }
      tempRow = sRow;
      tempCol = sCol;
      available = true;
      while (available == true && (tempRow - 1 >= 0) && (tempCol - 1 >= 0)){
        tempRow--;
        tempCol--;
        if (b[tempRow][tempCol].isOccupied()==false){
          controlledSquares.add(b[tempRow][tempCol]);
        }
        else {
            controlledSquares.add(b[tempRow][tempCol]);
          
          available = false;
        }
      }
      tempRow = sRow;
      tempCol = sCol;
      available = true;
      while (available == true && (tempRow + 1 < 8) && (tempCol - 1 >= 0)){
        tempRow++;
        tempCol--;
        if (b[tempRow][tempCol].isOccupied()==false){
          controlledSquares.add(b[tempRow][tempCol]);
        }
        else {
            controlledSquares.add(b[tempRow][tempCol]);
          
          available = false;
        }
      }
    	return controlledSquares;
    }
    
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.


    // Precondition: Piece selected is a bishop
    // Postcondition: The bishop moves diagonally, staying on the same colored square throughout the entire game. 
    // It has infinite range until the end of the board or until there is a piece in the way (if it is an opposite color piece, it can capture it)
    // and moves in all directions diagonal to it.
    public ArrayList<Square> getLegalMoves(Board b, Square start){
      ArrayList<Square> legalMoves = new ArrayList<Square>();
      int sRow = start.getRow();
      int tempRow = sRow;
      int sCol = start.getCol();
      int tempCol = sCol;
      boolean available = true;
      while (available == true && (tempRow + 1 < 8) && (tempCol + 1 < 8)){
        tempRow++;
        tempCol++;
        if (b.getSquareArray()[tempRow][tempCol].isOccupied()==false){
          legalMoves.add(b.getSquareArray()[tempRow][tempCol]);
        }
        else {
          if ((b.getSquareArray()[tempRow][tempCol].getOccupyingPiece().getColor()) != color){
            legalMoves.add(b.getSquareArray()[tempRow][tempCol]);
          }
          available = false;
        }
      }
      tempRow = sRow;
      tempCol = sCol;
      available = true;
      while (available == true && (tempRow - 1 >= 0) && (tempCol + 1 < 8)){
        tempRow--;
        tempCol++;
        if (b.getSquareArray()[tempRow][tempCol].isOccupied()==false){
          legalMoves.add(b.getSquareArray()[tempRow][tempCol]);
        }
        else {
          if ((b.getSquareArray()[tempRow][tempCol].getOccupyingPiece().getColor()) != color){
            legalMoves.add(b.getSquareArray()[tempRow][tempCol]);
          }
          available = false;
        }
      }
      tempRow = sRow;
      tempCol = sCol;
      available = true;
      while (available == true && (tempRow - 1 >= 0) && (tempCol - 1 >= 0)){
        tempRow--;
        tempCol--;
        if (b.getSquareArray()[tempRow][tempCol].isOccupied()==false){
          legalMoves.add(b.getSquareArray()[tempRow][tempCol]);
        }
        else {
          if ((b.getSquareArray()[tempRow][tempCol].getOccupyingPiece().getColor()) != color){
            legalMoves.add(b.getSquareArray()[tempRow][tempCol]);
          }
          available = false;
        }
      }
      tempRow = sRow;
      tempCol = sCol;
      available = true;
      while (available == true && (tempRow + 1 < 8) && (tempCol - 1 >= 0)){
        tempRow++;
        tempCol--;
        if (b.getSquareArray()[tempRow][tempCol].isOccupied()==false){
          legalMoves.add(b.getSquareArray()[tempRow][tempCol]);
        }
        else {
          if ((b.getSquareArray()[tempRow][tempCol].getOccupyingPiece().getColor()) != color){
            legalMoves.add(b.getSquareArray()[tempRow][tempCol]);
          }
          available = false;
        }
      }
    	return legalMoves;
    }
}