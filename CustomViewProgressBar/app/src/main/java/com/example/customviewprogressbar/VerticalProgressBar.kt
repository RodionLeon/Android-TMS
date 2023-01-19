package com.example.customviewprogressbar

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View

class VerticalProgressBar(context: Context, attrs: AttributeSet) : View(context, attrs) {

    companion object {
        private const val DEFAULT_CURRENT_VALUE = 50
        private const val DEFAULT_MAX_VALUE = 100
        private const val DEFAULT_MIN_VALUE = 0
        private const val DEFAULT_BORDER_WIDTH = 5f
        private const val DEFAULT_COLOR_PROGRESS = Color.BLUE
        private const val DEFAULT_COLOR_BAR = Color.GRAY
        private const val DEFAULT_COLOR_BORDER = Color.BLACK
    }

    private var borderWidth = DEFAULT_BORDER_WIDTH

    private var colorProgress = DEFAULT_COLOR_PROGRESS
    private var colorBar = DEFAULT_COLOR_BAR
    private var colorBorder = DEFAULT_COLOR_BORDER

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var pbWidth = 0
    private var pbHeight = 0

    var minValue = DEFAULT_MIN_VALUE
        set(state) {
            field = state
            invalidate()
        }
    var maxValue = DEFAULT_MAX_VALUE
        set(state) {
            field = state
            invalidate()
        }
    var currentValue = DEFAULT_CURRENT_VALUE
        set(state) {
            field = state
            invalidate()
        }

    init {
        setupAttributes(attrs)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawProgressBar(canvas)
        drawProgress(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        pbHeight = measuredHeight.coerceAtMost(measuredHeight)
        pbWidth = measuredWidth.coerceAtMost(measuredWidth)
    }

    override fun onSaveInstanceState(): Parcelable {
        val bundle = Bundle()
        bundle.putInt("min", minValue)
        bundle.putInt("max", maxValue)
        bundle.putInt("current", currentValue)
        bundle.putParcelable("superState", super.onSaveInstanceState())

        return bundle
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        var viewState = state

        if (viewState is Bundle) {
            minValue = viewState.getInt("min", DEFAULT_MIN_VALUE)
            maxValue = viewState.getInt("max", DEFAULT_MAX_VALUE)
            currentValue = viewState.getInt("current", DEFAULT_CURRENT_VALUE)
            viewState = viewState.getParcelable("superState")
        }
        super.onRestoreInstanceState(viewState)
    }

    private fun drawProgressBar(canvas: Canvas){
        paint.color = colorBar
        paint.style = Paint.Style.FILL
        val rectangle = Rect(0,0,pbWidth,pbHeight)
        canvas.drawRect(rectangle,paint)

        paint.color = colorBorder
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth
        val border = Rect(0,0,pbWidth,pbHeight)
        canvas.drawRect(border, paint)

    }
    private  fun drawProgress(canvas: Canvas){
        paint.color = colorProgress
        paint.style = Paint.Style.FILL

        val progressHeight= (pbHeight * (currentValue - minValue)) / (maxValue - minValue)

        val rect = Rect(0 , pbHeight - progressHeight, pbWidth, pbHeight)
        canvas.drawRect(rect, paint)

    }
    private fun setupAttributes(attrs: AttributeSet) {
        val typedArray =
            context.theme.obtainStyledAttributes(attrs, R.styleable.VerticalProgressBar, 0, 0)
        colorBar = typedArray.getColor(
            R.styleable.VerticalProgressBar_backgroundColor,
            DEFAULT_COLOR_BAR
        )
        colorProgress = typedArray.getColor(
            R.styleable.VerticalProgressBar_progressColor,
            DEFAULT_COLOR_PROGRESS)
        colorBorder = typedArray.getColor(
            R.styleable.VerticalProgressBar_borderColor,
            DEFAULT_COLOR_BORDER
        )
        borderWidth = typedArray.getDimension(
            R.styleable.VerticalProgressBar_borderWidth,
            DEFAULT_BORDER_WIDTH
        )

        minValue = typedArray.getInt(
            R.styleable.VerticalProgressBar_minValue,
            DEFAULT_MIN_VALUE)

        maxValue = typedArray.getInt(
            R.styleable.VerticalProgressBar_maxValue,
            DEFAULT_MAX_VALUE)

        currentValue = typedArray.getInt(
            R.styleable.VerticalProgressBar_currentValue,
            DEFAULT_CURRENT_VALUE)

        typedArray.recycle()
    }


}