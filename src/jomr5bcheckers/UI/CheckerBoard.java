/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jomr5bcheckers.UI;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Jared
 */
public class CheckerBoard 
{
    private GridPane _board = null;
    private int _numRows;
    private int _numCols;
    private int _width;
    private int _height;
    private Color _lightColor;
    private Color _darkColor;
    private int _squareWidth;
    private int _squareHeight;
    
    public GridPane getBoard()
    {
        return _board;
    }
    
    public int getNumRows()
    {
        return _numRows;
    }
    
    public int getNumCols()
    {
        return _numCols;
    }
    
    public int getWidth()
    {
        return _width;
    }
    
    public int getHeight()
    {
        return _height;
    }
    
    public Color getLightColor()
    {
        return _lightColor;
    }
    
    public Color getDarkColor()
    {
        return _darkColor;
    }
    
    public int getSquareWidth()
    {
        return _squareWidth;
    }
    
    public int getSquareHeight()
    {
        return _squareHeight;
    }
    
    public CheckerBoard(int numRows, int numCols, int boardWidth, int boardHeight)
    {
        this(numRows, numCols, boardWidth, boardHeight, Color.RED, Color.BLACK);
    }
    
    public CheckerBoard(int numRows, int numCols, int boardWidth, int boardHeight, Color lightColor, Color darkColor)
    {
        this._numRows = numRows;
        this._numCols = numCols;
        this._width = boardWidth;
        this._height = boardHeight;
        this._squareWidth = _width / _numCols;
        this._squareHeight = _height / _numRows;
        this._lightColor = lightColor;
        this._darkColor = darkColor;
    }
    
    public GridPane build()
    {
        //create the board
        this._board = new GridPane();
        
        for (int r = 0; r < this._numRows; r++)
        {
            for (int c = 0; c < this._numCols; ++c)
            {
                //Create cell
                Rectangle rec = new Rectangle();
                rec.setWidth(this._squareWidth);
                rec.setHeight(this._squareHeight);
                               
                //Calculate color
                Color col = ((r + c) % 2 == 0) ? _lightColor : _darkColor;
                rec.setFill(col);

                //Add cell to board
                this._board.add(rec, c, r);
            }
        }
        
        return _board;
    }
}