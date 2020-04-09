package com.example.task05a

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class GameView: View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
super(context, attrs, defStyleAttr)

    private val colCount = 7
    private val rowCount = 12

    private var mGridPaint: Paint
    private var mNoPlayerPaint: Paint

    init {
        mGridPaint = Paint().apply {
            style = Paint.Style.FILL
            color = Color.BLUE
        }

        mNoPlayerPaint = Paint().apply {
            style = Paint.Style.FILL
            color = Color.WHITE
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val chosenDiameter: Float
        var tokenAtPos: Int
        var paint: Paint

        val viewWidth: Float = width.toFloat()
        val viewHeight: Float = height.toFloat()

        val diameterX: Float = viewWidth / colCount.toFloat()
        val diameterY: Float = viewHeight / rowCount.toFloat()

        //To choose smallest of the 2:
        if (diameterX < diameterY)
            chosenDiameter = diameterX
        else
            chosenDiameter = diameterY

        //Draw the gameboard
        canvas.drawRect(0.toFloat(), 0.toFloat(), viewWidth, viewHeight, mGridPaint)

        val radius = chosenDiameter / 2

        //Draw the circles on gameboard
        for (col in 0 until colCount) {
            for (row in 0 until rowCount) {

                paint = mNoPlayerPaint

                //Calculate coords of the circle
                val cx = chosenDiameter * col + radius
                val cy = chosenDiameter * row + radius

                canvas.drawCircle(cx, cy, radius, paint)
            }
        }
    }
}