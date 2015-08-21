package com.example.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MapActivity extends Activity {
	private Button backButton;
	private Button vchange;
	private ImageView map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		 backButton = (Button) findViewById(R.id.map_backB);
		 vchange = (Button) findViewById(R.id.map_changeB);
		 map = (ImageView) findViewById(R.id.map_image1);
		
		
		backButton.setOnClickListener(listener);
		vchange.setOnClickListener(listener);
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.map_backB:
				Intent goback = new Intent(MapActivity.this,MainActivity.class);
				Toast.makeText(getApplicationContext(), "bye", Toast.LENGTH_LONG).show();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				startActivity(goback);
				finish();
				break;
			case R.id.map_changeB:
				//set widget properties
				/*if(map.getVisibility()==View.INVISIBLE)
					map.setVisibility(View.VISIBLE);
				else map.setVisibility(View.INVISIBLE);*/
				
				//preset action
				/*Intent i = new Intent();
				i.setAction(Intent.ACTION_DIAL);
				Uri uri = Uri.parse("tel:13554979984");
				i.setData(uri);
				startActivity(i);*/
				
				//receive parameters
				/*Bundle getbundle = getIntent().getExtras();
				String latitude = String.valueOf(getbundle.getFloat("latitude"));
				String longitude = String.valueOf(getbundle.getFloat("longitude"));
				
				Toast.makeText(MapActivity.this, longitude+latitude, Toast.LENGTH_LONG).show();*/
				
				//service page
				Intent serivce = new Intent(MapActivity.this, ServicePage.class);
				startActivity(serivce);
				finish();
				break;
			default:
				break;
			}
		}
	};
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
