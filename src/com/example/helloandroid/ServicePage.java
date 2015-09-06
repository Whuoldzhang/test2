package com.example.helloandroid;

import com.zyq.service.ServiceDemo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ServicePage extends Activity {
	private EditText etext;
	private Button binds;
	private Button starts;
	private TextView rtext;
	private Receiver myreceiver;
	public static final String RECEIVER = "com.zyq.service.ServiceDemo";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.servicepage);
		
		etext = (EditText) findViewById(R.id.etext);
		binds = (Button) findViewById(R.id.sp1_B);
		starts = (Button) findViewById(R.id.sp2_B);
		rtext = (TextView) findViewById(R.id.rtext);
		
		binds.setOnClickListener(listener);
		starts.setOnClickListener(listener);
		
		IntentFilter filter = new IntentFilter();
		filter.addAction(RECEIVER);
		myreceiver = new Receiver();
		ServicePage.this.registerReceiver(myreceiver, filter);
	}
	
	OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.sp1_B:
				Intent bintent = new Intent(ServiceDemo.ACTION);
				bindService(bintent, conn, BIND_AUTO_CREATE);
				break;
			case R.id.sp2_B:
				startService(new Intent(ServiceDemo.ACTION));
				break;
			default:
				break;
			}
		}
	};
	
	ServiceConnection conn = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			Log.i("ServicePage","disconnected");
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			Log.i("ServicePage","connected");
		}
	};
	
	class Receiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			
			Bundle bundle = intent.getExtras();
			int num = bundle.getInt("num");
			Log.i("ServicePage",String.valueOf(num));
			if(rtext.VISIBLE==View.INVISIBLE) rtext.setVisibility(View.VISIBLE);
			rtext.setText(String.valueOf(num));
		}
		
	}
}
