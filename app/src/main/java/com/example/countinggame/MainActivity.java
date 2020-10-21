package com.example.countinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
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
            // Get question text element
            TextView question = findViewById(R.id.question);

            // Set question text to display correct answer and change it to green
            question.setText("3 + 2 = 5");
            question.setTextColor(Color.parseColor("#52b465"));

            // Make number buttons, grey background, plate and apple images invisible
            findViewById(R.id.button0).setVisibility(View.INVISIBLE);
            findViewById(R.id.button1).setVisibility(View.INVISIBLE);
            findViewById(R.id.button2).setVisibility(View.INVISIBLE);
            findViewById(R.id.button3).setVisibility(View.INVISIBLE);
            findViewById(R.id.button4).setVisibility(View.INVISIBLE);
            findViewById(R.id.button5).setVisibility(View.INVISIBLE);
            findViewById(R.id.button6).setVisibility(View.INVISIBLE);
            findViewById(R.id.button7).setVisibility(View.INVISIBLE);
            findViewById(R.id.button8).setVisibility(View.INVISIBLE);
            findViewById(R.id.button9).setVisibility(View.INVISIBLE);
            findViewById(R.id.background).setVisibility(View.INVISIBLE);
            findViewById(R.id.plate).setVisibility(View.INVISIBLE);
            findViewById(R.id.apple1).setVisibility(View.INVISIBLE);
            findViewById(R.id.apple2).setVisibility(View.INVISIBLE);
            findViewById(R.id.apple3).setVisibility(View.INVISIBLE);
            findViewById(R.id.apple4).setVisibility(View.INVISIBLE);
            findViewById(R.id.apple5).setVisibility(View.INVISIBLE);
            findViewById(R.id.apple6).setVisibility(View.INVISIBLE);
            findViewById(R.id.apple7).setVisibility(View.INVISIBLE);
            findViewById(R.id.apple8).setVisibility(View.INVISIBLE);
            findViewById(R.id.apple9).setVisibility(View.INVISIBLE);

            // Make "play again" button visible
            findViewById(R.id.againButton).setVisibility(View.VISIBLE);

            // Get star image elements
            ImageView star1 = (ImageView)findViewById(R.id.star1);
            ImageView star2 = (ImageView)findViewById(R.id.star2);
            ImageView star3 = (ImageView)findViewById(R.id.star3);
            ImageView star4 = (ImageView)findViewById(R.id.star4);

            // Make star images visible
            star1.setVisibility(View.VISIBLE);
            star2.setVisibility(View.VISIBLE);
            star3.setVisibility(View.VISIBLE);
            star4.setVisibility(View.VISIBLE);

            // Define animations
            AlphaAnimation anim1 = new AlphaAnimation(0, 1);
            anim1.setDuration(2000);
            anim1.setRepeatCount(Animation.INFINITE);

            AlphaAnimation anim2 = new AlphaAnimation(0, 1);
            anim2.setDuration(2500);
            anim2.setRepeatCount(Animation.INFINITE);

            AlphaAnimation anim3 = new AlphaAnimation(0, 1);
            anim3.setDuration(1500);
            anim3.setRepeatCount(Animation.INFINITE);

            AlphaAnimation anim4 = new AlphaAnimation(0, 1);
            anim4.setDuration(2500);
            anim4.setRepeatCount(Animation.INFINITE);
            anim4.setStartOffset(1500); // Animation 4 gets set off after animation 3 has loaded

            // Set off animations for star images
            star1.startAnimation(anim1);
            star2.startAnimation(anim2);
            star3.startAnimation(anim3);
            star4.startAnimation(anim4);
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