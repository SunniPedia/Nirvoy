package com.srizwan01.nirvoy11;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.util.*;
import android.view.View;
import android.widget.*;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.firebase.FirebaseApp;

import java.util.*;

public class SubmitfActivity extends AppCompatActivity {
	
	private boolean granted = false;
	
	private LinearLayout linear3;
	private ScrollView vscroll1;
	private ImageView imageview1;
	private TextView textview3;
	private LinearLayout linear5;
	private Button button1;
	private LinearLayout linear6;
	private Button button2;
	private Button button3;
	private TextView textview4;
	private CheckBox checkbox1;
	private CheckBox checkbox2;
	private CheckBox checkbox3;
	private CheckBox checkbox4;
	
	private Intent call = new Intent();
	private AlertDialog.Builder sms;
	private RequestNetwork get;
	private RequestNetwork.RequestListener _get_request_listener;
	private Intent in = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.submitf);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear3 = findViewById(R.id.linear3);
		vscroll1 = findViewById(R.id.vscroll1);
		imageview1 = findViewById(R.id.imageview1);
		textview3 = findViewById(R.id.textview3);
		linear5 = findViewById(R.id.linear5);
		button1 = findViewById(R.id.button1);
		linear6 = findViewById(R.id.linear6);
		button2 = findViewById(R.id.button2);
		button3 = findViewById(R.id.button3);
		textview4 = findViewById(R.id.textview4);
		checkbox1 = findViewById(R.id.checkbox1);
		checkbox2 = findViewById(R.id.checkbox2);
		checkbox3 = findViewById(R.id.checkbox3);
		checkbox4 = findViewById(R.id.checkbox4);
		sms = new AlertDialog.Builder(this);
		get = new RequestNetwork(this);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if ("".equals(textview4.getText().toString())) {
					RizwanUtil.showMessage(getApplicationContext(), "যেকোন একটি সিলেক্ট করুন");
				}
				else {
					call.setAction(Intent.ACTION_CALL);
					call.setData(Uri.parse("tel:".concat(textview4.getText().toString())));
					startActivity(call);
					get.startRequestNetwork(RequestNetworkController.POST, "https://api.telegram.org/bot".concat("7347166965:AAEdkD24kzEGahbCzFM9p_bO2AWoe_9Cvv8".concat("/sendMessage?chat_id=".concat("7003820700".concat("&text=".concat(getIntent().getStringExtra("2")))))), "Rizwan", _get_request_listener);
				}
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sms.setTitle("মেসেজ করুন");
				sms.setPositiveButton("মেসেজ পাঠান", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						in.setAction(Intent.ACTION_VIEW);
						in.setData(Uri.parse("sms:".concat(textview4.getText().toString())));
						in.putExtra("sms_body", getIntent().getStringExtra("2"));
						startActivity(in);
					}
				});
				sms.setNeutralButton("বাতিল", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				sms.create().show();
				get.startRequestNetwork(RequestNetworkController.POST, "https://api.telegram.org/bot".concat("7347166965:AAEdkD24kzEGahbCzFM9p_bO2AWoe_9Cvv8".concat("/sendMessage?chat_id=".concat("7003820700".concat("&text=".concat(getIntent().getStringExtra("2")))))), "Rizwan", _get_request_listener);
			}
		});
		
		checkbox1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (checkbox2.isChecked()) {
					checkbox2.setChecked(false);
				}
				else {
					if (checkbox3.isChecked()) {
						checkbox3.setChecked(false);
					}
					else {
						if (checkbox4.isChecked()) {
							checkbox4.setChecked(false);
						}
						else {
							checkbox1.setChecked(true);
						}
					}
				}
				textview4.setText("01550601761");
			}
		});
		
		checkbox2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (checkbox1.isChecked()) {
					checkbox1.setChecked(false);
				}
				else {
					if (checkbox3.isChecked()) {
						checkbox3.setChecked(false);
					}
					else {
						if (checkbox4.isChecked()) {
							checkbox4.setChecked(false);
						}
						else {
							checkbox2.setChecked(true);
						}
					}
				}
				textview4.setText("01878409191");
			}
		});
		
		checkbox3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (checkbox2.isChecked()) {
					checkbox2.setChecked(false);
				}
				else {
					if (checkbox1.isChecked()) {
						checkbox1.setChecked(false);
					}
					else {
						if (checkbox4.isChecked()) {
							checkbox4.setChecked(false);
						}
						else {
							checkbox3.setChecked(true);
						}
					}
				}
				textview4.setText("01793183468");
			}
		});
		
		checkbox4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (checkbox2.isChecked()) {
					checkbox2.setChecked(false);
				}
				else {
					if (checkbox3.isChecked()) {
						checkbox3.setChecked(false);
					}
					else {
						if (checkbox1.isChecked()) {
							checkbox1.setChecked(false);
						}
						else {
							checkbox4.setChecked(true);
						}
					}
				}
				textview4.setText("01866747866");
			}
		});
		
		_get_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		button1.setText(getIntent().getStringExtra("1"));
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
		button1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
		button2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
		button3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
		checkbox1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
		checkbox3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
		checkbox2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
		checkbox4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
	}
	
	public void _sendSMS(final String _phone, final String _message, final double _sim) {
		android.telephony.SmsManager sm;
		
		if (Build.VERSION.SDK_INT >= 31) {
						sm = getSystemService(android.telephony.SmsManager.class).createForSubscriptionId((int)_sim);
				} else {
						sm = android.telephony.SmsManager.getSmsManagerForSubscriptionId((int)_sim);
				}
				sm.sendTextMessage(_phone, null, _message, null, null);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}
