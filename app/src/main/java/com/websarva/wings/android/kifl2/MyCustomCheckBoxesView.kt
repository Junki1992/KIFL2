package com.websarva.wings.android.kifl2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.CheckBox
import android.widget.LinearLayout

/**
 * TODO: document your custom view class.
 */
class MyCustomCheckBoxesView : LinearLayout {

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        LayoutInflater.from(getContext()).inflate(R.layout.sample_my_custom_check_boxes_view, this);

    }
    fun getCheckList(): Array<String> {
        var list: Array<String> = arrayOf()

        val jobCheckBox = findViewById<CheckBox>(R.id.cbJob)
        if (jobCheckBox.isChecked) {
            list += jobCheckBox.text.toString()
        }

        val univCheckBox = findViewById<CheckBox>(R.id.cbSch)
        if (univCheckBox.isChecked) {
            list += univCheckBox.text.toString()
        }

        val stuabCheckBox = findViewById<CheckBox>(R.id.cbAbr)
        if (stuabCheckBox.isChecked) {
            list += stuabCheckBox.text.toString()
        }

        val otherCheckBox = findViewById<CheckBox>(R.id.cbOth)
        if (otherCheckBox.isChecked) {
            list += otherCheckBox.text.toString()
        }
        return list
    }
}
