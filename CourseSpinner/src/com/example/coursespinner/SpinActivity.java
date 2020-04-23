package com.example.coursespinner;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinActivity extends Activity {
	Spinner sp;
	TextView tv;
	ArrayAdapter<String> aa;
	String cl[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin);
        
        sp=(Spinner) findViewById(R.id.spinner1);
        tv=(TextView) findViewById(R.id.textView1);
        cl=getResources().getStringArray(R.array.Course);
        aa= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,cl);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(aa);
        sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				int ind=arg0.getSelectedItemPosition();
				if(cl[ind].equals("Select Course"))
					tv.setText(" ");
				else
					tv.setText(cl[ind]+" is selected");
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.spin, menu);
        return true;
    }
    
}
