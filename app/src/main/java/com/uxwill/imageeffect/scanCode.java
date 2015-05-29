package com.uxwill.imageeffect;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.util.Log;

import com.squareup.picasso.Picasso;

public class scanCode extends AppCompatActivity implements View.OnClickListener {
    Button sellButton;
    Button saveButton;
    ImageView img;
    private static final String TAG = "willMessage";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_code);

        sellButton = (Button) findViewById(R.id.sellButton);
        saveButton = (Button) findViewById(R.id.saveButton);
        img = (ImageView) findViewById(R.id.img);

        Intent data = new Intent("com.google.zxing.client.android.SCAN");
        data.putExtra("SCAN_MODE", "QR_CODE_MODE");
        startActivityForResult(data, 0);

        Log.i(TAG, "onCreate");

    }

        @Override
        public void onClick(View v) {


            Intent intent = new Intent();

            if (v == sellButton) {

                intent.putExtra("type", 1);
                setResult(RESULT_OK, intent);
                finish();
            } else if (v == saveButton){

                intent.putExtra("type", 2);
                setResult(RESULT_OK, intent);

                finish();

            }
        }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {

                String contents = data.getStringExtra("SCAN_RESULT");
                String format = data.getStringExtra("SCAN_RESULT_FORMAT");

                Picasso.with(this).load(contents).into(img);

                Log.i(TAG, "onActivityResult");

            } else if (resultCode == RESULT_CANCELED) {
                // Handle cancel
            }
        }
    }

}
