package org.crucitti.pdm.esercitazione3;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class TextDialerActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button bottone = (Button)findViewById(R.id.button1);
       bottone.setOnClickListener(new OnClickListener(){

	
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		EditText etext=(EditText) findViewById(R.id.button1);
		String telString=etext.getText().toString();
		String telUriString="tel:" + telString; 
		Uri telURI=Uri.parse(telUriString);	
		
	Intent intent = new Intent(Intent.ACTION_DIAL);
	intent.setData(telURI);
	startActivity(intent);
	
	
	Intent intentcall = new Intent(Intent.ACTION_CALL);
	intent.setData(telURI);
	startActivity(intent);
	}});
    

	   EditText etext =  (EditText) findViewById(R.id.editText1);
	   etext.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

      }

    }
