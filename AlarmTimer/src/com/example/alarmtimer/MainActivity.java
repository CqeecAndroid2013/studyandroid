package com.example.alarmtimer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	private Button mBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mBtn = (Button)this.findViewById(R.id.btnStartAlarm);
        this.mBtn.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v) {
    	// TODO Auto-generated method stub
    	if(v.getId() == R.id.btnStartAlarm){
    		Intent intent = new Intent();
    		intent.setAction(AlarmClock.ACTION_SET_ALARM);
    		intent.putExtra(AlarmClock.EXTRA_MESSAGE, "起床");
    		intent.putExtra(AlarmClock.EXTRA_HOUR, 6);
    		intent.putExtra(AlarmClock.EXTRA_MINUTES, 30);
    		if(intent.resolveActivity(getPackageManager()) != null){
    			startActivity(Intent.createChooser(
    					intent,
    					getString(R.string.choose_app)));
    		}
    	}
    }
}
