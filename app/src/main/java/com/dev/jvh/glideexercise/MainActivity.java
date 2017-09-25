package com.dev.jvh.glideexercise;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private EditText urlInput;
    private ImageView imageView;

    private static final String TAG = "MAIN_ACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlInput = (EditText) findViewById(R.id.urlTextInput);
        imageView = (ImageView) findViewById(R.id.imageView);

    }

    public void loadImage(View view)
    {
        String url = urlInput.getText().toString();
        try
        {
            Picasso.with(getApplicationContext())
                    .load(url)
/*                    .centerCrop()
                    .resize(imageView.getMaxWidth(),imageView.getMaxHeight())
                    .placeholder(R.drawable.loading)*/
                    .into(imageView);
        } catch(Exception e)
        {
            Log.e(TAG, "loadImage: " + e.getMessage());
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (imageView.getDrawable() == null){
                    urlInput.setText("No valid url");
                }else{
                    //Image Exists!.
                }
            }
        }, 500);

    }
}
