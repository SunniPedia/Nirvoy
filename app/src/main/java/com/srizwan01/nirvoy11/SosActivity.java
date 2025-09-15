package com.srizwan01.nirvoy11;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.util.*;
import android.view.*;
import android.view.View;
import android.widget.*;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.firebase.FirebaseApp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SosActivity extends AppCompatActivity {
	
	private boolean granted = false;
	
	private ArrayList<HashMap<String, Object>> map1 = new ArrayList<>();
	
	private LinearLayout linear3;
	private ScrollView vscroll1;
	private ImageView imageview1;
	private TextView textview3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private TextView textview4;
	private TextView textview5;
	private LinearLayout thana;
	private TextView textview8;
	private LinearLayout linear13;
	private LinearLayout linear15;
	private TextView thaan;
	private LinearLayout linear17;
	private Spinner spinner2;
	private LinearLayout linear12;
	private LinearLayout linear10;
	private TextView textview6;
	private LinearLayout linear9;
	private TextView number;
	private LinearLayout linear11;
	private ImageView imageview2;
	private TextView textview7;
	
	private Intent call = new Intent();
	private RequestNetwork get;
	private RequestNetwork.RequestListener _get_request_listener;
	private AlertDialog.Builder sms;
	private Intent in = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.sos);
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
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		linear6 = findViewById(R.id.linear6);
		linear7 = findViewById(R.id.linear7);
		textview4 = findViewById(R.id.textview4);
		textview5 = findViewById(R.id.textview5);
		thana = findViewById(R.id.thana);
		textview8 = findViewById(R.id.textview8);
		linear13 = findViewById(R.id.linear13);
		linear15 = findViewById(R.id.linear15);
		thaan = findViewById(R.id.thaan);
		linear17 = findViewById(R.id.linear17);
		spinner2 = findViewById(R.id.spinner2);
		linear12 = findViewById(R.id.linear12);
		linear10 = findViewById(R.id.linear10);
		textview6 = findViewById(R.id.textview6);
		linear9 = findViewById(R.id.linear9);
		number = findViewById(R.id.number);
		linear11 = findViewById(R.id.linear11);
		imageview2 = findViewById(R.id.imageview2);
		textview7 = findViewById(R.id.textview7);
		get = new RequestNetwork(this);
		sms = new AlertDialog.Builder(this);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		linear15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				spinner2.performClick();
			}
		});
		
		linear9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if ("থানা".equals(thaan.getText().toString())) {
					RizwanUtil.showMessage(getApplicationContext(), "থানা সিলেক্ট করুন");
				}
				else {
					call.setAction(Intent.ACTION_CALL);
					call.setData(Uri.parse("tel:".concat(number.getText().toString())));
					startActivity(call);
					get.startRequestNetwork(RequestNetworkController.POST, "https://api.telegram.org/bot".concat("7275857559:AAGoEmGnvivwQyWTp59xYjfH5-lM1lWabPc".concat("/sendMessage?chat_id=".concat("7003820700".concat("&text=".concat(getIntent().getStringExtra("1")))))), "Rizwan", _get_request_listener);
					in.setAction(Intent.ACTION_VIEW);
					in.setData(Uri.parse("sms:".concat(number.getText().toString())));
					in.putExtra("sms_body", getIntent().getStringExtra("1"));
					startActivity(in);
				}
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
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), Typeface.NORMAL);
		textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);
		textview6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), Typeface.NORMAL);
		textview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);
		textview4.setText(getIntent().getStringExtra("1"));
		try{
			java.io.InputStream inputstream1 = getAssets().open("৯. বান্দরবান পার্বত্য জেলা");
			map1 = new Gson().fromJson(RizwanUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			spinner2.setAdapter(new Spinner2Adapter(map1));
			((ArrayAdapter)spinner2.getAdapter()).notifyDataSetChanged();
		}catch(Exception e){
			 
		}
		_strock(thana);
	}
	
	public String _replaceArabicNumber(final String _n) {
		String result = _n.replace("1", "১").replace("2", "২").replace("3", "৩").replace("4", "৪").replace("5", "৫").replace("6", "৬").replace("7", "৭").replace("8", "৮").replace("9", "৯").replace("0", "০");
		
		return result;
	}
	
	
	public void _strock(final View _m) {
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFFFFFFFF);
			SketchUi.setCornerRadius(d*11);
			SketchUi.setStroke(d*5,0xFF4CAF50);
			_m.setElevation(d*5);
			_m.setBackground(SketchUi);
		}
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
	
	public class Spinner2Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Spinner2Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.select_thana, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			if (map1.get((int)_position).containsKey("thana")) {
				textview1.setText(_replaceArabicNumber(map1.get((int)_position).get("thana").toString()));
			}
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/myfont.ttf"), Typeface.NORMAL);
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					thaan.setText(_replaceArabicNumber(map1.get((int)_position).get("thana").toString()));
					number.setText(map1.get((int)_position).get("number").toString());
				}
			});
			{
				android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
				int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
				SketchUi.setColor(0xFFFFFFFF);
				SketchUi.setCornerRadius(d*0);
				SketchUi.setStroke(d*1,0xFF4CAF50);
				linear1.setElevation(d*7);
				android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFE0E0E0}), SketchUi, null);
				linear1.setBackground(SketchUi_RD);
			}
			
			return _view;
		}
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
