package com.example.logic

import com.example.lib.GameInterface

class StudentGame (columns: Int = 7, rows: Int = 10
) : GameInterface {
    override val mColumns: Int = columns
    override val mRows: Int = rows

    //Set up two-dimensional array of integer,
    //of size columns x rows and fill it with zeroes
    override var mData: Array<IntArray> = Array(columns) {IntArray(rows, {0})}

    //Optional addition to the interface
    var playerTurn: Int = 1

    //Implement the getToken function:
    //Returns the game board state at a specified column and row number
    override fun getToken(column: Int, row: Int): Int {
        return mData[column][row]
    }

    //Implement the playToken function:
    //Changes the contents of the game board at a specified row and column
    override fun playToken(column: Int, player: Int): Boolean {
        if (player <= 0) {
            throw IllegalArgumentException("Player numbers start with 1")
        }

        for (row in 0 until mRows) {
            if (mData[column][row] === 0) {
                mData[column][row] = player
            return true
            }
        }
        return false      // illegal move
    }
}

