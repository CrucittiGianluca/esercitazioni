package org.crucitti.pdm.esercitazione1_1;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;

public class RisorseXMLActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        XmlResourceParser parser = getResources().getXml(R.xml.compilation);
        try{
        	int eventType = parser.getEventType();
        while (eventType != XmlResourceParser.END_DOCUMENT){
        	if (eventType == XmlResourceParser.START_TAG){
        		String tagName = parser.getName();
        		if("brano".equals(tagName)){
        			String id = parser.getAttributeValue(0);
        		}
        	} else if (eventType == XmlResourceParser.TEXT){
        		String elementValue =parser.getText();
        	}
		eventType = parser.next();
        }
        
        }catch (XmlPullParserException e) {
			e.printStackTrace();
		}catch (IOException e) {
		 e.printStackTrace();
		}
    String str1="BeL programma .... Mah proprio un bell programma di ......";
    Log.d("XML PARSER",str1);
    }
}