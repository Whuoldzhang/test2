package com.example.helloandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	//private Button gomap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button hellobtn = (Button)findViewById(R.id.hellobutton);
        Button gomap = (Button) findViewById(R.id.go_map);
               

		gomap.setOnClickListener(listener);
		hellobtn.setOnClickListener(listener);
		
        /*hellobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView hellotv = (TextView)findViewById(R.id.hellotextView);
                Toast.makeText(MainActivity.this,"Clicked",Toast.LENGTH_SHORT).show();
                hellotv.setText(R.string.interact_message);
            }
        });*/
        
    }
    
    OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.go_map:
				Intent go = new Intent(MainActivity.this, MapActivity.class);
				Bundle data = new Bundle();
				data.putFloat("longitude", (float) 110.00);
				data.putFloat("latitude", (float)30.00);
				go.putExtras(data);
				startActivity(go);
				finish();
				
				break;
			case R.id.hellobutton:
				TextView hellotv = (TextView)findViewById(R.id.hellotextView);
                Toast.makeText(MainActivity.this,"Clicked",Toast.LENGTH_SHORT).show();
                hellotv.setText(R.string.interact_message);				
				break;
			default:
				break;
			}
		}
	};

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
