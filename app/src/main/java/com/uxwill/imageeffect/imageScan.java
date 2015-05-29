package com.uxwill.imageeffect;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.util.Log;


public class imageScan extends AppCompatActivity {


    ImageView gauguinImageView;
    Drawable gauguinDraw;
    Bitmap bitmapImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_scan);


//        gauguinImageView = (ImageView) findViewById(R.id.gauguinImageView);


        //apply an image effect
//        gauguinDraw = getDrawable(R.drawable.gauguin);
//        bitmapImage = ((BitmapDrawable)gauguinDraw).getBitmap();
//        Bitmap newPhoto = invertImage(bitmapImage);
        //  gauguinImageView.setImageBitmap(newPhoto);

        //add layer on top of the image
//        Drawable[] layers = new Drawable[2];
//        layers[0] = getDrawable(R.drawable.gauguin);
//        layers[1] = getDrawable(R.drawable.noise1);
//        LayerDrawable layerDrawable = new LayerDrawable(layers);
//        gauguinImageView.setImageDrawable(layerDrawable);


        //Save the image to the users device
        //    MediaStore.Images.Media.insertImage(getContentResolver(), newPhoto, "title", "description");

    }


    public static Bitmap invertImage(Bitmap original) {

        Bitmap finalImage = Bitmap.createBitmap(original.getWidth(), original.getHeight(), original.getConfig());

        int A, R, G, B;
        int pixelColor;
        int height = original.getHeight();
        int width = original.getWidth();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixelColor = original.getPixel(x, y);
                A = Color.alpha(pixelColor);
                R = 255 - Color.red(pixelColor);
                G = 255 - Color.green(pixelColor);
                B = 255 - Color.blue(pixelColor);
                finalImage.setPixel(x, y, Color.argb(A, R, G, B));
            }
        }

        return finalImage;

    }

}

