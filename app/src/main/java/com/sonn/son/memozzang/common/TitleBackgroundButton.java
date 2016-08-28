package com.sonn.son.memozzang.common;



import com.sonn.son.memozzang.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by son on 2016-06-08.
 */


public class TitleBackgroundButton extends Button {
    /**
     * 기본 컨텍스트
     */
    Context context;

    /**
     * Paint instance
     */
    Paint paint;

    /**
     * Default Color
     */
    int defaultColor = 0xff333333;

    /**
     * Default Size
     */
    float defaultSize = 20F;

    /**
     * Default ScaleX
     */
    float defaultScaleX = 1.0F;

    /**
     * Default Typeface
     */
    Typeface defaultTypeface = Typeface.DEFAULT_BOLD;

    /**
     * Title Text
     */
    String titleText = "";

    /**
     * Flag for paint changed
     */
    boolean paintChanged = false;

    public TitleBackgroundButton(Context context) {
        super(context);

        this.context = context;
        init();
    }

    public TitleBackgroundButton(Context context, AttributeSet atts) {
        super(context, atts);

        this.context = context;
        init();
    }

    /**
     * 초기화
     */
    public void init() {
        setBackgroundResource(R.drawable.title_new);

        paint = new Paint();
        paint.setColor(defaultColor);
        paint.setAntiAlias(true);
        paint.setTextScaleX(defaultScaleX);
        paint.setTextSize(defaultSize);
        paint.setTypeface(defaultTypeface);

    }


    /**
     * Handles touch event, move to main screen
     */
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);

        int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_UP:

                break;

            case MotionEvent.ACTION_DOWN:
                Toast.makeText(context, "메모짱!", Toast.LENGTH_SHORT).show();
                break;

        }

        // repaint the screen
        invalidate();

        return true;
    }

    /**
     * Draw the text
     */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int curWidth = getWidth();
        int curHeight = getHeight();

        // apply paint attributes
        if (paintChanged) {
            paint.setColor(defaultColor);
            paint.setTextScaleX(defaultScaleX);
            paint.setTextSize(defaultSize);
            paint.setTypeface(defaultTypeface);
        }

        // calculate bounds
        Rect bounds = new Rect();
        paint.getTextBounds(titleText, 0, titleText.length(), bounds);
        float textWidth = ((float)curWidth - bounds.width())/2.0F;
        float textHeight = ((float)(curHeight) - bounds.height())/2.0F + bounds.height();

        // draw title text
        canvas.drawText(titleText, textWidth, textHeight, paint);

    }
}
