package com.srizwan01.nirvoy11;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.os.*;
import android.os.Bundle;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.widget.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;

import java.util.*;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;


public class AmbulanceActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private boolean granted = false;
	
	private LinearLayout linear3;
	private ScrollView vscroll1;
	private ImageView imageview1;
	private TextView textview3;
	private LinearLayout linear1;
	private TextView textview1;
	private LinearLayout r1;
	private LinearLayout r3;
	private LinearLayout r2;
	private LinearLayout linear4;
	private LinearLayout dob_field;
	private LinearLayout linear5;
	private Button button1;
	private EditText name;
	private EditText address;
	private EditText problem;
	private EditText gotoo;
	private TextView dob_title;
	private LinearLayout dob_wrapper;
	private LinearLayout date_field;
	private LinearLayout month_field;
	private EditText edittext1;
	private LinearLayout date_base;
	private LinearLayout month_base;
	private EditText edittext2;
	private EditText number;
	
	private AlertDialog.Builder sms;
	private TimerTask time;
	private RequestNetwork get;
	private RequestNetwork.RequestListener _get_request_listener;
	private Calendar cal = Calendar.getInstance();
	private Intent call = new Intent();
	private AlertDialog.Builder select;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.ambulance);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear3 = findViewById(R.id.linear3);
		vscroll1 = findViewById(R.id.vscroll1);
		imageview1 = findViewById(R.id.imageview1);
		textview3 = findViewById(R.id.textview3);
		linear1 = findViewById(R.id.linear1);
		textview1 = findViewById(R.id.textview1);
		r1 = findViewById(R.id.r1);
		r3 = findViewById(R.id.r3);
		r2 = findViewById(R.id.r2);
		linear4 = findViewById(R.id.linear4);
		dob_field = findViewById(R.id.dob_field);
		linear5 = findViewById(R.id.linear5);
		button1 = findViewById(R.id.button1);
		name = findViewById(R.id.name);
		address = findViewById(R.id.address);
		problem = findViewById(R.id.problem);
		gotoo = findViewById(R.id.gotoo);
		dob_title = findViewById(R.id.dob_title);
		dob_wrapper = findViewById(R.id.dob_wrapper);
		date_field = findViewById(R.id.date_field);
		month_field = findViewById(R.id.month_field);
		edittext1 = findViewById(R.id.edittext1);
		date_base = findViewById(R.id.date_base);
		month_base = findViewById(R.id.month_base);
		edittext2 = findViewById(R.id.edittext2);
		number = findViewById(R.id.number);
		sms = new AlertDialog.Builder(this);
		get = new RequestNetwork(this);
		select = new AlertDialog.Builder(this);
		
		imageview1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		edittext1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// বর্তমান তারিখ নেওয়া হচ্ছে
				final Calendar cal = Calendar.getInstance();
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH);
				int day = cal.get(Calendar.DAY_OF_MONTH);

				// ডেট পিকার ডায়লগ দেখানোর জন্য
				DatePickerDialog datePickerDialog = new DatePickerDialog(AmbulanceActivity.this, new DatePickerDialog.OnDateSetListener() {
					@Override
					public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
						// যেহেতু মাস ০ থেকে শুরু হয়, তাই ১ যোগ করা হয়েছে
						selectedMonth = selectedMonth + 1;

						// ডেট ফরম্যাট করে EditText7 এ বসানো হচ্ছে
						String date = selectedDay + "/" + selectedMonth + "/" + selectedYear;
						edittext1.setText(date);
					}
				}, year, month, day);

				datePickerDialog.show();
			}
		});
		edittext1.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// বর্তমান তারিখ নেওয়া হচ্ছে
					final Calendar cal = Calendar.getInstance();
					int year = cal.get(Calendar.YEAR);
					int month = cal.get(Calendar.MONTH);
					int day = cal.get(Calendar.DAY_OF_MONTH);

					// ডেট পিকার ডায়লগ দেখানোর জন্য
					DatePickerDialog datePickerDialog = new DatePickerDialog(AmbulanceActivity.this, new DatePickerDialog.OnDateSetListener() {
						@Override
						public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
							// যেহেতু মাস ০ থেকে শুরু হয়, তাই ১ যোগ করা হয়েছে
							selectedMonth = selectedMonth + 1;

							// ডেট ফরম্যাট করে EditText7 এ বসানো হচ্ছে
							String date = selectedDay + "/" + selectedMonth + "/" + selectedYear;
							edittext1.setText(date);
						}
					}, year, month, day);

					datePickerDialog.show();
					return true;  // এখানে true রিটার্ন করলে এটি টাচ ইভেন্টকে শেষ করবে
				}
				return false;
			}
		});
		// Time picker dialog for edittext2
		edittext2.setOnClickListener(v -> showTimePicker());

// To ensure touch event on edittext2 brings the time picker
		edittext2.setOnTouchListener((v, event) -> {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				showTimePicker();
				return true; // Consume the touch event
			}
			return false;
		});



		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				if ("".equals(name.getText().toString()) || ("".equals(address.getText().toString()) || ("".equals(problem.getText().toString()) || ("".equals(gotoo.getText().toString()) || ("".equals(number.getText().toString()) || "".equals(edittext1.getText().toString())))))) {
					RizwanUtil.showMessage(getApplicationContext(), "খালি ঘর পূরন করুন");
				}
				else {
					call.setClass(getApplicationContext(), SubmitActivity.class);
					call.putExtra("1", "বান্দরবানের আশে পাশের আ্যম্বুলেন্স পরিসেবা সমূহ:");
					call.putExtra("2", "রোগীর নাম:	".concat(name.getText().toString().concat(" 	রোগীর সমস্যা: ".concat(problem.getText().toString().concat("	 গন্তব্য :".concat(gotoo.getText().toString().concat(" ".concat("\n   তারিখ: ".concat(edittext1.getText().toString().concat("   ".concat(edittext2.getText().toString().concat("\n".concat("  বর্তমান ঠিকানা: ".concat(address.getText().toString().concat(" মোবাইল নাম্বার: ".concat(number.getText().toString().concat("   সাহায্য চাওয়া ব্যক্তির তথ্য:  ".concat(getIntent().getStringExtra("0")))))))))))))))))));
					call.putExtra("3", "জরুরি আ্যম্বুলেন্স লাগবে। মোবাইল নাম্বার: ".concat(number.getText().toString()));
					startActivity(call);
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

	// Method to show the Time Picker dialog
	private void showTimePicker() {
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);

		TimePickerDialog timePickerDialog = new TimePickerDialog(
				this,
				(view, selectedHour, selectedMinute) -> {
					// Format time to display in edittext2
					String formattedTime = String.format("%02d:%02d", selectedHour, selectedMinute);
					edittext2.setText(formattedTime);
				},
				hour,
				minute,
				true // Use 24-hour format
		);
		timePickerDialog.show();
	}
	private void initializeLogic() {
		cal = Calendar.getInstance();
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
		gotoo.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
		number.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
		button1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
		_strock(linear4);
		_statusbarcolor("#FF4CAF50");
		_strock(linear5);
		_strock(dob_field);
		_strock(r1);
		_strock(r2);
		_strock(r3);
		{
			GradientDrawable SketchUi = new GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFF4CAF50);
			SketchUi.setCornerRadius(d*37);
			SketchUi.setStroke(d*3,0xFFFFFFFF);
			button1.setElevation(d*7);
			RippleDrawable SketchUi_RD = new RippleDrawable(new ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFA5D6A7}), SketchUi, null);
			button1.setBackground(SketchUi_RD);
			button1.setClickable(true);
		}
		textview1.setText(getIntent().getStringExtra("1"));
	}
	
	
	@Override
	public void onBackPressed() {
		finish();
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
	
	
	public void _strock(final View _m) {
		{
			GradientDrawable SketchUi = new GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFFFFFFFF);
			SketchUi.setCornerRadius(d*11);
			SketchUi.setStroke(d*5,0xFF4CAF50);
			_m.setElevation(d*5);
			_m.setBackground(SketchUi);
		}
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
