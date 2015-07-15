package com.xylu.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	
	private EditText inputEt;
	private TextView sumTv;
	private Button submitBtn;
	
	private double d1,d2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		inputEt = (EditText)findViewById(R.id.input_et);
		sumTv = (TextView)findViewById(R.id.sum_tv);
		submitBtn = (Button)findViewById(R.id.submit_btn);
		
		submitBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == submitBtn) {
			Intent intent = new Intent(this, SubPageActivity.class);
			String s = inputEt.getText().toString();
			if (s.equals("")) {
				d1 = 0;
			} else {
				d1 = Double.parseDouble(s);
			}
			intent.putExtra("d1", d1);
			this.startActivityForResult(intent, 0);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		System.out.println("m50");
		super.onActivityResult(requestCode, resultCode, data);
		System.out.println(resultCode);
		System.out.println(requestCode);
		if (resultCode == RESULT_OK && requestCode == 0) {
			d2 = data.getDoubleExtra("d2", 0);
			System.out.println(d2);
			double sum = d1 + d2;
			sumTv.setText("sum=" + String.valueOf(sum));
			sumTv.setVisibility(View.VISIBLE);
		}
	}
}
