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


public class BloodDonateActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private boolean granted = false;
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private ScrollView vscroll1;
	private ImageView imageview1;
	private TextView textview1;
	private LinearLayout linear3;
	private TextView textview2;
	private LinearLayout linear4;
	private LinearLayout linear12;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private LinearLayout dob_field;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private TextView textview4;
	private Button button1;
	private EditText edittext1;
	private EditText edittext9;
	private EditText edittext2;
	private EditText edittext3;
	private TextView dob_title;
	private LinearLayout dob_wrapper;
	private LinearLayout date_field;
	private LinearLayout month_field;
	private LinearLayout date_base;
	private EditText edittext10;
	private LinearLayout month_base;
	private EditText edittext11;
	private EditText edittext5;
	private EditText edittext6;
	
	private AlertDialog.Builder dialog;
	private Calendar cal = Calendar.getInstance();
	private Intent in = new Intent();
	private AlertDialog.Builder sim;
	private RequestNetwork get;
	private RequestNetwork.RequestListener _get_request_listener;
	private TimerTask time;
	private AlertDialog.Builder d1;
	private AlertDialog.Builder sms;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.blood_donate);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		vscroll1 = findViewById(R.id.vscroll1);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		linear3 = findViewById(R.id.linear3);
		textview2 = findViewById(R.id.textview2);
		linear4 = findViewById(R.id.linear4);
		linear12 = findViewById(R.id.linear12);
		linear5 = findViewById(R.id.linear5);
		linear6 = findViewById(R.id.linear6);
		dob_field = findViewById(R.id.dob_field);
		linear8 = findViewById(R.id.linear8);
		linear9 = findViewById(R.id.linear9);
		textview4 = findViewById(R.id.textview4);
		button1 = findViewById(R.id.button1);
		edittext1 = findViewById(R.id.edittext1);
		edittext9 = findViewById(R.id.edittext9);
		edittext2 = findViewById(R.id.edittext2);
		edittext3 = findViewById(R.id.edittext3);
		dob_title = findViewById(R.id.dob_title);
		dob_wrapper = findViewById(R.id.dob_wrapper);
		date_field = findViewById(R.id.date_field);
		month_field = findViewById(R.id.month_field);
		date_base = findViewById(R.id.date_base);
		edittext10 = findViewById(R.id.edittext10);
		month_base = findViewById(R.id.month_base);
		edittext11 = findViewById(R.id.edittext11);
		edittext5 = findViewById(R.id.edittext5);
		edittext6 = findViewById(R.id.edittext6);
		dialog = new AlertDialog.Builder(this);
		sim = new AlertDialog.Builder(this);
		get = new RequestNetwork(this);
		d1 = new AlertDialog.Builder(this);
		sms = new AlertDialog.Builder(this);
		
		imageview1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		textview2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		linear5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				RizwanUtil.hideKeyboard(getApplicationContext());
				View popupView = getLayoutInflater().inflate(R.layout.selectblood, null);
				final PopupWindow popup = new PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
				LinearLayout b0 = popupView.findViewById(R.id.linear1);
				LinearLayout b1 = popupView.findViewById(R.id.color1);
				LinearLayout b2 = popupView.findViewById(R.id.color2);
				LinearLayout b3 = popupView.findViewById(R.id.color3);
				LinearLayout b4 = popupView.findViewById(R.id.color4);
				LinearLayout b5 = popupView.findViewById(R.id.color5);
				LinearLayout b6 = popupView.findViewById(R.id.color6);
				LinearLayout b7 = popupView.findViewById(R.id.color7);
				LinearLayout b8 = popupView.findViewById(R.id.color8);
				LinearLayout b9 = popupView.findViewById(R.id.color9);
				LinearLayout b10 = popupView.findViewById(R.id.color10);
				RadioButton R1 = popupView.findViewById(R.id.radiobutton1);
				RadioButton R2 = popupView.findViewById(R.id.radiobutton2);
				RadioButton R3 = popupView.findViewById(R.id.radiobutton3);
				RadioButton R4 = popupView.findViewById(R.id.radiobutton4);
				RadioButton R5 = popupView.findViewById(R.id.radiobutton5);
				RadioButton R6 = popupView.findViewById(R.id.radiobutton6);
				RadioButton R7 = popupView.findViewById(R.id.radiobutton7);
				RadioButton R8 = popupView.findViewById(R.id.radiobutton8);
				{
					GradientDrawable SketchUi = new GradientDrawable();
					int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
					SketchUi.setColor(0xFFFFFFFF);
					SketchUi.setCornerRadius(d*19);
					SketchUi.setStroke(d*1,0xFF4CAF50);
					b0.setElevation(d*7);
					b0.setBackground(SketchUi);
				}
				TextView textview_12 = popupView.findViewById(R.id.textview_12);
				textview_12.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
				TextView textview_11 = popupView.findViewById(R.id.textview_11);
				textview_11.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
				TextView textview_13 = popupView.findViewById(R.id.textview_13);
				textview_13.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
				b1.setOnClickListener(new OnClickListener() { public void onClick(View view) {
						edittext2.setText("A (Positive)");
						popup.dismiss();
					} });
				b2.setOnClickListener(new OnClickListener() { public void onClick(View view) {
						edittext2.setText("A (Negative)");
						popup.dismiss();
					} });
				b3.setOnClickListener(new OnClickListener() { public void onClick(View view) {
						edittext2.setText("B (Positive)");
						popup.dismiss();
					} });
				b4.setOnClickListener(new OnClickListener() { public void onClick(View view) {
						edittext2.setText("B (Negative)");
						popup.dismiss();
					} });
				b5.setOnClickListener(new OnClickListener() { public void onClick(View view) {
						edittext2.setText("AB (Positive)");
						popup.dismiss();
					} });
				b6.setOnClickListener(new OnClickListener() { public void onClick(View view) {
						edittext2.setText("AB (Negative)");
						popup.dismiss();
					} });
				b7.setOnClickListener(new OnClickListener() { public void onClick(View view) {
						edittext2.setText("O (Positive)");
						popup.dismiss();
					} });
				b8.setOnClickListener(new OnClickListener() { public void onClick(View view) {
						edittext2.setText("O (Negative)");
						popup.dismiss();
					} });
				R1.setOnClickListener(new OnClickListener() { public void onClick(View view) {
						edittext2.setText("A (Positive)");
						popup.dismiss();
					} });
				R2.setOnClickListener(new OnClickListener() { public void onClick(View view) {
						edittext2.setText("A (Negative)");
						popup.dismiss();
					} });
				R3.setOnClickListener(new OnClickListener() { public void onClick(View view) {
						edittext2.setText("B (Positive)");
						popup.dismiss();
					} });
				R4.setOnClickListener(new OnClickListener() { public void onClick(View view) {
						edittext2.setText("B (Negative)");
						popup.dismiss();
					} });
				R5.setOnClickListener(new OnClickListener() { public void onClick(View view) {
						edittext2.setText("AB (Positive)");
						popup.dismiss();
					} });
				R6.setOnClickListener(new OnClickListener() { public void onClick(View view) {
						edittext2.setText("AB (Negative)");
						popup.dismiss();
					} });
				R7.setOnClickListener(new OnClickListener() { public void onClick(View view) {
						edittext2.setText("O (Positive)");
						popup.dismiss();
					} });
				R8.setOnClickListener(new OnClickListener() { public void onClick(View view) {
						edittext2.setText("O (Negative)");
						popup.dismiss();
					} });
				b9.setOnClickListener(new OnClickListener() { public void onClick(View view) {
						popup.dismiss();
					} });
				b10.setOnClickListener(new OnClickListener() { public void onClick(View view) {
						popup.dismiss();
					} });
				popup.showAtLocation(popupView, Gravity.CENTER, 0, 0);
			}
		});
		
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				if ("".equals(edittext1.getText().toString()) || ("".equals(edittext9.getText().toString()) || ("".equals(edittext2.getText().toString()) || ("".equals(edittext3.getText().toString()) || ("".equals(edittext5.getText().toString()) || ("".equals(edittext5.getText().toString()) || ("".equals(edittext6.getText().toString()) || "".equals(edittext10.getText().toString())))))))) {
					RizwanUtil.showMessage(getApplicationContext(), "খালি ঘর পূরন করুন");
				}
				else {
					in.setClass(getApplicationContext(), SubmitrActivity.class);
					in.putExtra("1", "বান্দরবান জেলার আশে পাশের ব্লাড ডোনার পরিসেবা সমূহ");
					in.putExtra("2", "আসসালামু আলাইকুম জরুরি রক্ত প্রয়োজন। রোগীর সমস্যা : ".concat(edittext1.getText().toString().concat("		  বর্তমান ঠিকানা : ".concat(edittext9.getText().toString().concat("   রক্তের গ্রুপ :".concat(edittext2.getText().toString().concat("   রক্তের পরিমান : ".concat(edittext3.getText().toString().concat("   রক্ত দানের তারিখ ও সময় :".concat(edittext10.getText().toString().concat("  ".concat(edittext11.getText().toString().concat("    রক্ত দানের স্থান :".concat(edittext5.getText().toString().concat("   মোবাইল নাম্বার :".concat(edittext6.getText().toString().concat("   সাহায্য চাওয়া ব্যক্তির তথ্য:  ".concat(getIntent().getStringExtra("1")))))))))))))))))));
					in.putExtra("3", "আমার জরুরি রক্ত লাগবে	".concat(edittext2.getText().toString().concat("	".concat(edittext6.getText().toString()))));
					startActivity(in);
				}
			}
		});
		edittext10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// বর্তমান তারিখ নেওয়া হচ্ছে
				final Calendar cal = Calendar.getInstance();
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH);
				int day = cal.get(Calendar.DAY_OF_MONTH);

				// ডেট পিকার ডায়লগ দেখানোর জন্য
				DatePickerDialog datePickerDialog = new DatePickerDialog(BloodDonateActivity.this, new DatePickerDialog.OnDateSetListener() {
					@Override
					public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
						// যেহেতু মাস ০ থেকে শুরু হয়, তাই ১ যোগ করা হয়েছে
						selectedMonth = selectedMonth + 1;

						// ডেট ফরম্যাট করে EditText7 এ বসানো হচ্ছে
						String date = selectedDay + "/" + selectedMonth + "/" + selectedYear;
						edittext10.setText(date);
					}
				}, year, month, day);

				datePickerDialog.show();
			}
		});
		edittext10.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// বর্তমান তারিখ নেওয়া হচ্ছে
					final Calendar cal = Calendar.getInstance();
					int year = cal.get(Calendar.YEAR);
					int month = cal.get(Calendar.MONTH);
					int day = cal.get(Calendar.DAY_OF_MONTH);

					// ডেট পিকার ডায়লগ দেখানোর জন্য
					DatePickerDialog datePickerDialog = new DatePickerDialog(BloodDonateActivity.this, new DatePickerDialog.OnDateSetListener() {
						@Override
						public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
							// যেহেতু মাস ০ থেকে শুরু হয়, তাই ১ যোগ করা হয়েছে
							selectedMonth = selectedMonth + 1;

							// ডেট ফরম্যাট করে EditText7 এ বসানো হচ্ছে
							String date = selectedDay + "/" + selectedMonth + "/" + selectedYear;
							edittext10.setText(date);
						}
					}, year, month, day);

					datePickerDialog.show();
					return true;  // এখানে true রিটার্ন করলে এটি টাচ ইভেন্টকে শেষ করবে
				}
				return false;
			}
		});
		// Time picker dialog for edittext2
		edittext11.setOnClickListener(v -> showTimePicker());

// To ensure touch event on edittext2 brings the time picker
		edittext11.setOnTouchListener((v, event) -> {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				showTimePicker();
				return true; // Consume the touch event
			}
			return false;
		});
		edittext2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear5.performClick();
			}
		});
		edittext2.setOnTouchListener((v, event) -> {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				linear5.performClick();
				return true; // Consume the touch event
			}
			return false;
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

	private void showTimePicker() {
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);

		TimePickerDialog timePickerDialog = new TimePickerDialog(
				this,
				(view, selectedHour, selectedMinute) -> {
					// Format time to display in edittext2
					String formattedTime = String.format("%02d:%02d", selectedHour, selectedMinute);
					edittext11.setText(formattedTime);
				},
				hour,
				minute,
				true // Use 24-hour format
		);
		timePickerDialog.show();
	}

	private void initializeLogic() {
		RizwanUtil.hideKeyboard(getApplicationContext());
		cal = Calendar.getInstance();
		_statusbarcolor("#FF4CAF50");
		_strock(linear4);
		_strock(linear5);
		_strock(linear6);
		_strock(dob_field);
		_strock(linear8);
		_strock(linear9);
		_strock(linear12);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
		edittext1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
		edittext2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
		edittext3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
		dob_title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
		
		
		edittext5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
		edittext6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
		edittext9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
		button1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
		{
			GradientDrawable SketchUi = new GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFF4CAF50);
			SketchUi.setCornerRadius(d*37);
			SketchUi.setStroke(d*3,0xFFFFFFFF);
			button1.setElevation(d*7);
			RippleDrawable SketchUi_RD = new RippleDrawable(new ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFA5D6A7}), SketchUi, null);
			button1.setBackground(SketchUi_RD);
		}
		{
			GradientDrawable SketchUi = new GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFF4CAF50);
			linear2.setElevation(d*7);
			linear2.setBackground(SketchUi);
		}
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
