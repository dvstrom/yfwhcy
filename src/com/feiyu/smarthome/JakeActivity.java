package com.feiyu.smarthome;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class JakeActivity extends Activity {

	private ImageView imageView;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jake);   
        imageView=(ImageView)this.findViewById(R.id.door);
        imageView.setOnClickListener(new OnClickListener() {
        	int i=0;
        	@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(i%2==0)
				{
					imageView.setImageResource(R.drawable.device_jake_on);
					i++;
				}else
				{
					imageView.setImageResource(R.drawable.device_jake_off);
					i++;
				}
			}
		});
	}
}

