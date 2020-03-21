package com.example.memorycanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class TilesView extends View {
    int[][] tiles = new int[4][4];
    int darkColor = Color.GRAY;
    int brightColor = Color.YELLOW;

    int width, height; // ширина и высота канвы

    public TilesView(Context context) {
        super(context);
    }

    public TilesView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // 1) заполнить массив tiles случайными цветами

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = canvas.getWidth();
        height = canvas.getHeight();
        // 2) отрисовка плиток
        // задать цвет можно, используя кисть
        Paint p = new Paint();
        p.setColor(Color.GREEN);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 3) получить координаты касания
        int x = (int) event.getX();
        int y = (int) event.getY();
        // 4) определить тип события
        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
            // палец коснулся экрана
        }
        // 5) определить, какой из плиток коснулись
        // изменить её цвет на противоположный
        // 6) проверить, не выиграли ли вы (все плитки одного цвета)

        invalidate(); // заставляет экран перерисоваться
        return true;
    }
}