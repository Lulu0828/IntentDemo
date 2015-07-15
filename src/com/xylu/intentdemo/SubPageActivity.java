package com.xylu.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SubPageActivity extends Activity implements OnClickListener{
	
	private TextView dTv;
	private Button returnBtn;
	
	private double d1,d2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.subpage);
		
		dTv = (TextView)findViewById(R.id.d_txt);
		returnBtn = (Button)findViewById(R.id.return_btn);
		
		returnBtn.setOnClickListener(this);
		
		d1 = getIntent().getDoubleExtra("d1", 0);
		dTv.setText("n=" + d1);
		d2 = getAddNum(d1);
	}

	private double getAddNum(double d) {
		// TODO Auto-generated method stub
		if (d <= 0) {
			return 0;
		} else if (d > 10) {
			return 10;
		}
		return 1;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == returnBtn) {
			Intent intent = new Intent();
			intent.putExtra("d2", d2);
			setResult(RESULT_OK, intent);
			this.finish();
		}
	}

}
