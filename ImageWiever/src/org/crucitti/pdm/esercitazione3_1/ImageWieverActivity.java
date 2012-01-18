package org.crucitti.pdm.esercitazione3_1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageWieverActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ImageView image = (ImageView) findViewById(R.id.imageView1);
        image.setImageURI((Uri) getIntent().getExtras().get(Intent.EXTRA_STREAM)); 
    }
}