package org.crucitti.pdm.esercitazione6;


import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChatActivity extends Activity {
    /** Called when the activity is first created. */
	EditText et1 ;
    TextView tv ;
    Connection connection;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        et1 = (EditText) findViewById(R.id.editText1);
        tv = (TextView) findViewById(R.id.textView1);
        tv.setMovementMethod(new ScrollingMovementMethod());
        Button bottone = (Button)findViewById(R.id.button1);
        bottone.setOnClickListener(new OnClickListener(){
					
			
					public void onClick(View v) {
						// TODO Auto-generated method stub
						 tv.append("ME:"+et1.getText().toString()+"\n");
						 Message msg = new Message();
						 msg.setTo("loreti@ppl.eln.uniroma2.it");
						 msg.setBody(et1.getText().toString());
						 connection.sendPacket(msg);
					}
				});
        
        try {
        	ConnectionConfiguration config = new ConnectionConfiguration ("ppl.eln.uniroma2.it",5222);
        	config.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
        	connection = new XMPPConnection(config);
        	connection.connect();
        	connection.login("crucitti","crucitti");
        }
        catch (XMPPException e){
        	e.printStackTrace();
        }
       
        connection.addPacketListener(new PacketListener() {
			
			@Override
			public void processPacket(Packet pkt) {
				// TODO Auto-generated method stub
				Message msg = (Message) pkt;
				String from = msg.getFrom();
				String body = msg.getBody();
				tv.append(from+" : "+body+"\n");
			}
			
		}, new MessageTypeFilter(Message.Type.normal));
    }       
}