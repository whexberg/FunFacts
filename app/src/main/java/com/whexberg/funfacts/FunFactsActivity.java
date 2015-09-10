package com.whexberg.funfacts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FunFactsActivity extends Activity {

    public static final String TAG = FunFactsActivity.class.getSimpleName();

    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        final TextView factLabel = (TextView) findViewById( R.id.factTextView );
        final Button showFactButton = (Button) findViewById( R.id.showFactButton );
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        // Set random initial fact and color
        int firstColor= getColor();
        factLabel.setText(getFact());
        relativeLayout.setBackgroundColor(firstColor);
        showFactButton.setTextColor(firstColor);

        // Add onClick listener to button
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fact = getFact();
                factLabel.setText(fact);

                int color = getColor();
                //Toast.makeText(FunFactsActivity.this, "#" + Integer.toString(color).substring(1), Toast.LENGTH_SHORT).show();
                relativeLayout.setBackgroundColor(color);
                showFactButton.setTextColor(color);
            }
        };
        showFactButton.setOnClickListener(listener);

        //Toast.makeText(this, "Yay! Our Activity was created!", Toast.LENGTH_SHORT).show();
        //Log.d(TAG, "We're logging from the onCreate() method!");
    }

    protected String getFact() {
        return mFactBook.getFact();
    }

    protected int getColor() {
        return mColorWheel.getColor();
    }
}
