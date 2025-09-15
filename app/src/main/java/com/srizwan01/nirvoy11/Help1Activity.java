package com.srizwan01.nirvoy11;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.*;
import android.graphics.Typeface;
import android.os.*;
import android.os.Bundle;
import android.util.*;
import android.view.*;
import android.view.View;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;

import de.hdodenhof.circleimageview.*;

import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

public class Help1Activity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private boolean granted = false;
	private String strAdd = "";
	private String strCity = "";
	private String strState = "";
	private String strCountry = "";
	private String strPC = "";
	private String strKN = "";
	private String packageName = "";
	private boolean isAppInstalled = false;
	private String newName = "";
	
	private LinearLayout linear1;
	private ScrollView vscroll1;
	private ImageView imageview1;
	private TextView textview1;
	private TextView location;
	private LinearLayout linear15;
	private ImageView sos;
	private TextView location2;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear11;
	private TextView textview10;
	private TextView textview11;
	private TextView help;
	private LinearLayout help1;
	private LinearLayout linear5;
	private LinearLayout help2;
	private CircleImageView circleimageview1;
	private TextView textview2;
	private CircleImageView circleimageview2;
	private TextView textview4;
	private LinearLayout help3;
	private LinearLayout linear13;
	private LinearLayout help4;
	private CircleImageView circleimageview3;
	private TextView textview6;
	private CircleImageView circleimageview4;
	private TextView textview12;
	
	private Intent call = new Intent();
	private AlertDialog.Builder dialog;
	private AlertDialog.Builder sms;
	private TimerTask time;
	private RequestNetwork get;
	private RequestNetwork.RequestListener _get_request_listener;
	private ObjectAnimator ani = new ObjectAnimator();
	private TimerTask locstion;
	private AlertDialog.Builder renameDialog;
	private SharedPreferences details;
	private Intent in = new Intent();
	private SharedPreferences data;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.help1);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		vscroll1 = findViewById(R.id.vscroll1);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		location = findViewById(R.id.location);
		linear15 = findViewById(R.id.linear15);
		sos = findViewById(R.id.sos);
		location2 = findViewById(R.id.location2);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear11 = findViewById(R.id.linear11);
		textview10 = findViewById(R.id.textview10);
		textview11 = findViewById(R.id.textview11);
		help = findViewById(R.id.help);
		help1 = findViewById(R.id.help1);
		linear5 = findViewById(R.id.linear5);
		help2 = findViewById(R.id.help2);
		circleimageview1 = findViewById(R.id.circleimageview1);
		textview2 = findViewById(R.id.textview2);
		circleimageview2 = findViewById(R.id.circleimageview2);
		textview4 = findViewById(R.id.textview4);
		help3 = findViewById(R.id.help3);
		linear13 = findViewById(R.id.linear13);
		help4 = findViewById(R.id.help4);
		circleimageview3 = findViewById(R.id.circleimageview3);
		textview6 = findViewById(R.id.textview6);
		circleimageview4 = findViewById(R.id.circleimageview4);
		textview12 = findViewById(R.id.textview12);
		dialog = new AlertDialog.Builder(this);
		sms = new AlertDialog.Builder(this);
		get = new RequestNetwork(this);
		renameDialog = new AlertDialog.Builder(this);
		details = getSharedPreferences("details", Activity.MODE_PRIVATE);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		linear1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		location.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", location.getText().toString()));
			}
		});
		
		//OnTouch
		help1.setOnTouchListener(new View.OnTouchListener(){
				@Override
				public boolean onTouch(View v, MotionEvent event){
						int ev = event.getAction();
						switch (ev) {
								case MotionEvent.ACTION_DOWN:
								
								 in.setClass(getApplicationContext(), SosActivity.class);
					in.putExtra("1", getIntent().getStringExtra("1"));
					startActivity(in);
								
								break;
								case MotionEvent.ACTION_UP:
								
								 
								
								break;
						} return true;
				}
		});
		
		help1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), SosActivity.class);
				in.putExtra("1", getIntent().getStringExtra("1"));
				startActivity(in);
			}
		});
		
		help2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), BloodDonateActivity.class);
				in.putExtra("1", location.getText().toString());
				startActivity(in);
			}
		});
		
		help3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), AmbulanceActivity.class);
				in.putExtra("1", "জরুরি অ্যাম্বুলেন্স এর জন্যেই তথ্য দিন");
				in.putExtra("0", location.getText().toString());
				startActivity(in);
			}
		});
		
		help4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), FireActivity.class);
				in.putExtra("1", "জরুরি ফায়ার সার্ভিসের জন্যেই তথ্য দিন");
				in.putExtra("0", location.getText().toString());
				startActivity(in);
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
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/myfont.ttf"), 1);
		
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/myfont.ttf"), 0);
		
		textview6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/myfont.ttf"), 0);
		
		
		
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFF4CAF50);
			linear1.setElevation(d*5);
			linear1.setBackground(SketchUi);
		}
		_statusbarcolor("#FF4CAF50");
		sos.setVisibility(View.GONE);
		boolean isAppInstalled = appInstalledOrNot("com.facebook.lite");
		if(isAppInstalled) {
			packageName = "com.facebook.lite";
		} else {
			    packageName = "com.facebook.katana";
		}
		location.setText(getIntent().getStringExtra("1"));
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
	}
	
	@Override
	public void onBackPressed() {
		finish();
	}
	public void _stock(final View _m) {
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFFFFFFFF);
			_m.setElevation(d*5);
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFB3E5FC}), SketchUi, null);
			_m.setBackground(SketchUi_RD);
		}
	}
	
	
	public void _border(final View _b) {
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int clrs [] = {0xFF03A9F4,0xFF009688};
			SketchUi= new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, clrs);
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFB3E5FC}), SketchUi, null);
			_b.setBackground(SketchUi_RD);
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
	
	
	public void _statusbarcolor(final String _color) {
		try {
			if(Build.VERSION.SDK_INT >= 21) {
				Window w = this.getWindow();
				w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
				w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
				w.setStatusBarColor(Color.parseColor(_color));
			}
		} catch (Exception e) {}
	}
	
	
	public void _Share(final String _str1) {
		//Copied From Universal SketchCode.
		
		try{
			Intent sharingIntent = new Intent(Intent.ACTION_SEND);
			sharingIntent.setType("text/plain");
			sharingIntent.putExtra(Intent.EXTRA_TEXT, _str1);
			sharingIntent.setPackage("com.facebook.lite");
			startActivity(sharingIntent);
		} catch (Exception e) {
		}
		
		/*   ,   com.whatsapp      . 
  :
* com.vkontakte.android - 
* com.whatsapp - WhatsApp
* com.facebook.katana - Facebook
* org.telegram.multi - Multigram
* org.tel+gram.messenger - Tl+grm
* advanced.twitter.android - Twitter
* com.google.android.apps.plus - Google+
*/
	}
	
	
	public void _extra() {
	}
	
	private boolean appInstalledOrNot(String uri) { android.content.pm.PackageManager pm = getPackageManager(); try { pm.getPackageInfo(uri, android.content.pm.PackageManager.GET_ACTIVITIES); return true; } catch (android.content.pm.PackageManager.NameNotFoundException e) { } return false;
	}
	
	
	public void _strock(final View _m) {
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFFFFFFFF);
			SketchUi.setCornerRadius(d*360);
			_m.setElevation(d*5);
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFF4CAF50}), SketchUi, null);
			_m.setBackground(SketchUi_RD);
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
