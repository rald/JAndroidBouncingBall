package com.example.bouncingball;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new BouncingBallView(this));
    }

    private class BouncingBallView extends View {
        private float x = 50, y = 50;
        private float dx = 10, dy = 15;
        private int radius = 30;
        private Paint paint = new Paint();

        public BouncingBallView(Context context) {
            super(context);
            paint.setColor(Color.RED);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            int width = getWidth();
            int height = getHeight();

            // Bounce off edges
            if ((x + dx) > width - radius || (x + dx) < radius) {
                dx = -dx;
            }
            if ((y + dy) > height - radius || (y + dy) < radius) {
                dy = -dy;
            }

            x += dx;
            y += dy;

            canvas.drawCircle(x, y, radius, paint);

            // Invalidate to request redraw next frame
            postInvalidateDelayed(30);
        }
    }
}
