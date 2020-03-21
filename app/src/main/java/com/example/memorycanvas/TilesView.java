package com.example.memorycanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

class Card {
    Paint p = new Paint();

    public Card(float x, float y, float width, float height, int color) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    int color, backColor = Color.DKGRAY;
    boolean isOpen = false; // цвет карты
    float x, y, width, height;
    public void draw(Canvas c) {
        // нарисовать карту в виде цветного прямоугольника
        if (isOpen) {
            p.setColor(color);
        } else p.setColor(backColor);
        c.drawRect(x,y, x+width, y+height, p);
    }
    public boolean flip (float touch_x, float touch_y) {
        if (touch_x >= x && touch_x <= x + width && touch_y >= y && touch_y <= y + height) {
            isOpen = ! isOpen;
            return true;
        } else return false;
    }

}

public class TilesView extends View {
    Card[] cards = new Card[2];

    int width, height; // ширина и высота канвы

    public TilesView(Context context) {
        super(context);
    }

    public TilesView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // 1) заполнить массив tiles случайными цветами
        // сгенерировать поле 2*n карт, при этом
        // должно быть ровно n пар карт разных цветов
        cards[0] = new Card(0,0, 200, 300, Color.YELLOW);
        cards[1] = new Card(0+200+50, 0, 200 + 200 + 50, 300, Color.YELLOW);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = canvas.getWidth();
        height = canvas.getHeight();
        // 2) отрисовка плиток
        // задать цвет можно, используя кисть
        Paint p = new Paint();
        for (Card c: cards) {
            c.draw(canvas);
        }
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
            for (Card c: cards) {
                if (c.flip(x, y))
                    invalidate();
            }
        }


         // заставляет экран перерисоваться
        return true;
    }
}