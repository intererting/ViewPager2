package com.yuliyang.viewpager2

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup

class CstmViewGroup @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        println("r   $r")
        println("width  ${getChildAt(0).width}")
        getChildAt(0).layout(l, t, 100, b)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        println("getChildAt(0).measuredWidth   ${getChildAt(0).measuredWidth}")
        println("getChildAt(0).measuredHeight   ${getChildAt(0).measuredHeight}")
        measureChildren(widthMeasureSpec, heightMeasureSpec)
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}