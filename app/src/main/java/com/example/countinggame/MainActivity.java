package com.example.countinggame;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    // Declare variable for the Java random class
    Random rand = new Random();

    // Declare variables for the math question values and answer
    int valueA, valueB, answer;

    // Declare variable for math question text element
    TextView question;

    // Declare variables for apple, plate, thumbs up and star image elements
    ImageView apple1, apple2, apple3, apple4, apple5, apple6, apple7, apple8, apple9, plate, thumbsUp, star1, star2, star3, star4;

    // Declare variables for number and "play again" button elements
    ImageButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, againButton;

    // Declare variable for background element
    View background;

    // Declare variables for animations
    AlphaAnimation anim1, anim2, anim3, anim4;

    // Declare variable for sound effect player
    MediaPlayer sound;

    // Declare variable for vibrator
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initiate number buttons, question text, background, apple, plate, thumbs up, star images and "play again" button
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        question = findViewById(R.id.question);
        background = findViewById(R.id.background);
        apple1 = findViewById(R.id.apple1);
        apple2 = findViewById(R.id.apple2);
        apple3 = findViewById(R.id.apple3);
        apple4 = findViewById(R.id.apple4);
        apple5 = findViewById(R.id.apple5);
        apple6 = findViewById(R.id.apple6);
        apple7 = findViewById(R.id.apple7);
        apple8 = findViewById(R.id.apple8);
        apple9 = findViewById(R.id.apple9);
        plate = findViewById(R.id.plate);
        thumbsUp = findViewById(R.id.thumbsUp);
        star1 = findViewById(R.id.star1);
        star2 = findViewById(R.id.star2);
        star3 = findViewById(R.id.star3);
        star4 = findViewById(R.id.star4);
        againButton = findViewById(R.id.againButton);

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

        generateQuestion(null);
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

    // Generate question function, called when app loads and when "play again" button is clicked
    public void generateQuestion(View v) {
        // Generate 2 values, each in range 0 - 4 so sum doesn't exceed 9 and work out answer
        valueA = rand.nextInt(5);
        valueB = rand.nextInt(5);
        answer = valueA + valueB;

        // Set question text to display math question and change colour to dark grey
        question.setText(String.valueOf(valueA) + " + " + String.valueOf(valueB) + " = ?");
        question.setTextColor(Color.parseColor("#5e5e5e"));

        // Stop star animations
        star1.clearAnimation();
        star2.clearAnimation();
        star3.clearAnimation();
        star4.clearAnimation();

        // Make "play again" button, thumbs up and star images invisible
        againButton.setVisibility(View.INVISIBLE);
        thumbsUp.setVisibility(View.INVISIBLE);
        star1.setVisibility(View.INVISIBLE);
        star2.setVisibility(View.INVISIBLE);
        star3.setVisibility(View.INVISIBLE);
        star4.setVisibility(View.INVISIBLE);

        // Make number buttons, background, apple and plate elements visible
        button0.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        button5.setVisibility(View.VISIBLE);
        button6.setVisibility(View.VISIBLE);
        button7.setVisibility(View.VISIBLE);
        button8.setVisibility(View.VISIBLE);
        button9.setVisibility(View.VISIBLE);
        background.setVisibility(View.VISIBLE);
        apple1.setVisibility(View.VISIBLE);
        apple2.setVisibility(View.VISIBLE);
        apple3.setVisibility(View.VISIBLE);
        apple4.setVisibility(View.VISIBLE);
        apple5.setVisibility(View.VISIBLE);
        apple6.setVisibility(View.VISIBLE);
        apple7.setVisibility(View.VISIBLE);
        apple8.setVisibility(View.VISIBLE);
        apple9.setVisibility(View.VISIBLE);
        plate.setVisibility(View.VISIBLE);

        // If sound effect is playing, stop it
        if (sound != null)
        {
            sound.stop();
        }
    }

    // Check button clicked was the right answer
    public void checkAnswer(View v) throws InterruptedException {
        // Declare button number variable to be used for comparison (has to be initialised so will just use 0 to begin with)
        int button = 0;

        if (v.getId() == R.id.button1) {
            button = 1;
        }
        else if (v.getId() == R.id.button2) {
            button = 2;
        }
        else if (v.getId() == R.id.button3) {
            button = 3;
        }
        else if (v.getId() == R.id.button4) {
            button = 4;
        }
        else if (v.getId() == R.id.button5) {
            button = 5;
        }
        else if (v.getId() == R.id.button6) {
            button = 6;
        }
        else if (v.getId() == R.id.button7) {
            button = 7;
        }
        else if (v.getId() == R.id.button8) {
            button = 8;
        }
        else if (v.getId() == R.id.button9) {
            button = 9;
        }

        if (button == answer)
        {
            // Set question text to display correct answer and change it to green
            question.setText(String.valueOf(valueA) + " + " + String.valueOf(valueB) + " = " + String.valueOf(answer));
            question.setTextColor(Color.parseColor("#52b465"));

            // Make number buttons, background, apple and plate elements invisible
            button0.setVisibility(View.INVISIBLE);
            button1.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.INVISIBLE);
            button3.setVisibility(View.INVISIBLE);
            button4.setVisibility(View.INVISIBLE);
            button5.setVisibility(View.INVISIBLE);
            button6.setVisibility(View.INVISIBLE);
            button7.setVisibility(View.INVISIBLE);
            button8.setVisibility(View.INVISIBLE);
            button9.setVisibility(View.INVISIBLE);
            background.setVisibility(View.INVISIBLE);
            apple1.setVisibility(View.INVISIBLE);
            apple2.setVisibility(View.INVISIBLE);
            apple3.setVisibility(View.INVISIBLE);
            apple4.setVisibility(View.INVISIBLE);
            apple5.setVisibility(View.INVISIBLE);
            apple6.setVisibility(View.INVISIBLE);
            apple7.setVisibility(View.INVISIBLE);
            apple8.setVisibility(View.INVISIBLE);
            apple9.setVisibility(View.INVISIBLE);
            plate.setVisibility(View.INVISIBLE);

            // Make "play again" button, thumbs up and star images visible
            againButton.setVisibility(View.VISIBLE);
            thumbsUp.setVisibility(View.VISIBLE);
            star1.setVisibility(View.VISIBLE);
            star2.setVisibility(View.VISIBLE);
            star3.setVisibility(View.VISIBLE);
            star4.setVisibility(View.VISIBLE);

            // Define animations
            anim1 = new AlphaAnimation(0, 1);
            anim1.setDuration(2000);
            anim1.setRepeatCount(Animation.INFINITE);

            anim2 = new AlphaAnimation(0, 1);
            anim2.setDuration(2500);
            anim2.setRepeatCount(Animation.INFINITE);

            anim3 = new AlphaAnimation(0, 1);
            anim3.setDuration(1500);
            anim3.setRepeatCount(Animation.INFINITE);

            anim4 = new AlphaAnimation(0, 1);
            anim4.setDuration(2500);
            anim4.setRepeatCount(Animation.INFINITE);
            anim4.setStartOffset(1500); // Animation 4 gets set off after animation 3 has loaded

            // Set off animations for star images
            star1.startAnimation(anim1);
            star2.startAnimation(anim2);
            star3.startAnimation(anim3);
            star4.startAnimation(anim4);

            // Set sound effect player to play applause sound and play it
            sound = MediaPlayer.create(MainActivity.this, R.raw.applause);
            sound.start();
        }
        else
        {
            // Set question text colour to red, indicating wrong answer
            question.setTextColor(Color.parseColor("#8b0000"));

            // Set sound effect player to play buzzer sound and play it
            sound = MediaPlayer.create(MainActivity.this, R.raw.buzzer);
            sound.start();

            // Set vibrator to use vibrator system service and vibrate for 500ms
            vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(500);
        }
    }
}