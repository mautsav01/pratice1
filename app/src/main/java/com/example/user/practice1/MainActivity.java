package com.example.user.practice1;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public  class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener
{


  private  GestureDetectorCompat gestureDector;
    private TextView gesture;
    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //forlayout
        RelativeLayout rl = new RelativeLayout(this);
        rl.setBackgroundColor(Color.CYAN);
        //forcontentofpage
        TextView user = new TextView(this);
        TextView pass = new TextView(this);
        display=new TextView(this);
        gesture=new TextView(this);

        Button bn = new Button(this);
        user.setText("Username:");
        pass.setText("Password:");
        bn.setText("Clickme");
        //forinput

        final EditText username = new EditText(this);
        final EditText password = new EditText(this);
        String gesture1=gesture.getText().toString();
        //id
        user.setId(1);
        pass.setId(2);
        bn.setId(3);
        username.setId(4);
        password.setId(5);
        display.setId(6);
        gesture.setId(7);
        ///////////////////////////////////////////////////////
        //////////////////////////////////////////////////////

        //forplacingcontent--DEFINING POSITION
        RelativeLayout.LayoutParams btn = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        btn.addRule(RelativeLayout.CENTER_HORIZONTAL);
        btn.addRule(RelativeLayout.CENTER_VERTICAL);
////////////////////////////////////////////////////////////////
        RelativeLayout.LayoutParams userDetails = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        userDetails.addRule(RelativeLayout.ABOVE, pass.getId());
        userDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        userDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        userDetails.addRule(RelativeLayout.ABOVE, pass.getId());

        userDetails.setMargins(0, 0, 0, 100);
        ///////////////////////////////////////////////////////////
        RelativeLayout.LayoutParams passDetails = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        passDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        passDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        passDetails.addRule(RelativeLayout.ABOVE, bn.getId());
        passDetails.setMargins(0, 0, 0, 100);


/////////////////////////////////////////////////////////////////
        RelativeLayout.LayoutParams usernameDetails = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        usernameDetails.addRule(RelativeLayout.ABOVE, bn.getId());
        usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        usernameDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        usernameDetails.setMargins(0, 0, 0, 120);

////////////////////////////////////////////////////////////////////
        RelativeLayout.LayoutParams passwordDetails = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        passwordDetails.addRule(RelativeLayout.ABOVE, bn.getId());
        passwordDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        passwordDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        passwordDetails.setMargins(0, 0, 0, 10);
/////////////////////////////////////////////////////////////////
        RelativeLayout.LayoutParams displaydet = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displaydet.addRule(RelativeLayout.BELOW, bn.getId());
        displaydet.addRule(RelativeLayout.CENTER_HORIZONTAL);
        displaydet.addRule(RelativeLayout.CENTER_VERTICAL);

        displaydet.setMargins(0, 0, 0, 100);

//////////////////////////////////////////////////////////////

        RelativeLayout.LayoutParams gestureD = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
       gestureD.addRule(RelativeLayout.BELOW, display.getId());
        gestureD.addRule(RelativeLayout.CENTER_HORIZONTAL);
        gestureD.addRule(RelativeLayout.CENTER_VERTICAL);

        gestureD.setMargins(0, 0, 0, 100);

        this.gestureDector = new GestureDetectorCompat(this, this);




        //converting pixel to dp
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, r.getDisplayMetrics());
        username.setWidth(px);
        password.setWidth(px);

//to display contentt

        rl.addView(bn, btn);
        rl.addView(pass, passDetails);
        rl.addView(user, userDetails);
        rl.addView(password, passwordDetails);
        rl.addView(username, usernameDetails);
        rl.addView(display, displaydet);
       rl.addView(gesture,gestureD);
        setContentView(rl);

/////////////////////////////////////////////////////////////


        //make button responsive

        bn.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
              display =(TextView)findViewById(display.getId());

                if (username.getText().toString().equals("name") && password.getText().toString().equals("name")) {
                    gesture.setText("okay!!");

                }
                else {
                    gesture.setText("not okay!!");
                }
            }


        });



}

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
gesture.setText("singletap");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
      gesture.setText("ondoubletap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e)
    {

        gesture.setText("Doubletap");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {

        gesture.setText("ondown");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

        gesture.setText("press");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e)
    {

        gesture.setText("singletap");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

        gesture.setText("Scrooooollll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {

        gesture.setText("longPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        gesture.setText("filnggg");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}

