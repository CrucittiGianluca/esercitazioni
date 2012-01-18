package org.crucitti.pdm.esercitazione4_2;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyPlayerActivity extends Activity {
	MediaPlayer mp ; 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mp = MediaPlayer.create(MyPlayerActivity.this, R.raw.dst);
        Button btn = (Button)findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mp.start();
			}
		});
        Button bnt = (Button)findViewById(R.id.button2);
        bnt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mp.pause();	
			}
		});   
		
    }
@Override
protected void onDestroy() {
	// TODO Auto-generated method stub
	super.onDestroy();
	mp.release();
	
}    
}
