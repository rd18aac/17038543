package com.example.countinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get apple image elements
        ImageView apple1 = (ImageView) findViewById(R.id.apple1);
        ImageView apple2 = (ImageView) findViewById(R.id.apple2);
        ImageView apple3 = (ImageView) findViewById(R.id.apple3);
        ImageView apple4 = (ImageView) findViewById(R.id.apple4);
        ImageView apple5 = (ImageView) findViewById(R.id.apple5);
        ImageView apple6 = (ImageView) findViewById(R.id.apple6);
        ImageView apple7 = (ImageView) findViewById(R.id.apple7);
        ImageView apple8 = (ImageView) findViewById(R.id.apple8);
        ImageView apple9 = (ImageView) findViewById(R.id.apple9);

        // Tell apple images to listen for touch event
        apple1.setOnTouchListener(handleTouch);
        apple2.setOnTouchListener(handleTouch);
        apple3.setOnTouchListener(handleTouch);
        apple4.setOnTouchListener(handleTouch);
        apple5.setOnTouchListener(handleTouch);
        apple6.setOnTouchListener(handleTouch);
        apple7.setOnTouchListener(handleTouch);
        apple8.setOnTouchListener(handleTouch);
        apple9.setOnTouchListener(handleTouch);
    }

    // Touch event function
    private View.OnTouchListener handleTouch = new View.OnTouchListener() {
        float dX, dY;
        @Override
        public boolean onTouch(View view, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    dX = view.getX() - event.getRawX();
                    dY = view.getY() - event.getRawY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    view.animate().x(event.getRawX() + dX).y(event.getRawY() + dY).setDuration(0).start();
                    break;
                default:
                    return false;
            }
            return true;
        }
    };

    // Check button clicked was the right answer
    public void checkAnswer(View v) {
        if (v.getId() == R.id.button0) {
            Toast.makeText(this, "NOPE", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.button1) {
            Toast.makeText(this, "NOPE", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.button2) {
            Toast.makeText(this, "NOPE", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.button3) {
            Toast.makeText(this, "NOPE", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.button4) {
            Toast.makeText(this, "NOPE", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.button5) {
            Toast.makeText(this, "CORRECT!!!!!", Toast.LENGTH_SHORT).show(); // Correct answer = 5
        }
        else if (v.getId() == R.id.button6) {
            Toast.makeText(this, "NOPE", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.button7) {
            Toast.makeText(this, "NOPE", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.button8) {
            Toast.makeText(this, "NOPE", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.button9) {
            Toast.makeText(this, "NOPE", Toast.LENGTH_SHORT).show();
        }
    }
}