package com.uxwill.imageeffect;

        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.Button;
        import android.widget.GridView;
        import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button scanButton;

    public static final int REQUEST_SCAN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(HelloGridView.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        scanButton = (Button) findViewById(R.id.scanButton);

        scanButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v == scanButton) {


            Intent intent = new Intent(MainActivity.this, com.uxwill.imageeffect.scanCode.class);
            startActivity(intent);

        }

    }






}



