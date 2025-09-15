package com.srizwan01.nirvoy11;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.widget.*;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;


public class HelpActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private boolean granted = false;
	private HashMap<String, Object> all_months = new HashMap<>();
	private boolean isDOBChoosed = false;
	
	private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> map1 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> map2 = new ArrayList<>();
	
	private LinearLayout linear3;
	private ScrollView vscroll1;
	private ImageView imageview1;
	private TextView textview3;
	private LinearLayout linear1;
	private TextView textview1;
	private LinearLayout thana;
	private LinearLayout linear4;
	private LinearLayout dob_field;
	private LinearLayout linear5;
	private Button button1;
	private TextView number;
	private TextView textview4;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private LinearLayout linear12;
	private LinearLayout linear15;
	private TextView area;
	private LinearLayout linear13;
	private Spinner spinner1;
	private TextView thaan;
	private LinearLayout linear14;
	private Spinner spinner2;
	private TextView jela;
	private LinearLayout linear16;
	private Spinner spinner3;
	private EditText edittext1;
	private TextView dob_title;
	private LinearLayout dob_wrapper;
	private LinearLayout date_field;
	private LinearLayout month_field;
	private EditText edittext3;
	private LinearLayout date_base;
	private LinearLayout month_base;
	private EditText edittext4;
	private EditText edittext2;
	
	private AlertDialog.Builder sms;
	private TimerTask time;
	private RequestNetwork get;
	private RequestNetwork.RequestListener _get_request_listener;
	private Calendar cal = Calendar.getInstance();
	private Intent call = new Intent();
	private AlertDialog.Builder select;
	private SharedPreferences data;
	private AlertDialog.Builder team;
	private AlertDialog.Builder police;
	private Intent in = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.help);
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
		thana = findViewById(R.id.thana);
		linear4 = findViewById(R.id.linear4);
		dob_field = findViewById(R.id.dob_field);
		linear5 = findViewById(R.id.linear5);
		button1 = findViewById(R.id.button1);
		number = findViewById(R.id.number);
		textview4 = findViewById(R.id.textview4);
		linear10 = findViewById(R.id.linear10);
		linear11 = findViewById(R.id.linear11);
		linear12 = findViewById(R.id.linear12);
		linear15 = findViewById(R.id.linear15);
		area = findViewById(R.id.area);
		linear13 = findViewById(R.id.linear13);
		spinner1 = findViewById(R.id.spinner1);
		thaan = findViewById(R.id.thaan);
		linear14 = findViewById(R.id.linear14);
		spinner2 = findViewById(R.id.spinner2);
		jela = findViewById(R.id.jela);
		linear16 = findViewById(R.id.linear16);
		spinner3 = findViewById(R.id.spinner3);
		edittext1 = findViewById(R.id.edittext1);
		dob_title = findViewById(R.id.dob_title);
		dob_wrapper = findViewById(R.id.dob_wrapper);
		date_field = findViewById(R.id.date_field);
		month_field = findViewById(R.id.month_field);
		edittext3 = findViewById(R.id.edittext3);
		date_base = findViewById(R.id.date_base);
		month_base = findViewById(R.id.month_base);
		edittext4 = findViewById(R.id.edittext4);
		edittext2 = findViewById(R.id.edittext2);
		sms = new AlertDialog.Builder(this);
		get = new RequestNetwork(this);
		select = new AlertDialog.Builder(this);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		team = new AlertDialog.Builder(this);
		police = new AlertDialog.Builder(this);
		
		imageview1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		linear5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext2.performClick();
			}
		});
		
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (thaan.getText().toString().equals("") && jela.getText().toString().equals("")) {
					RizwanUtil.CustomToast(getApplicationContext(), "ঘর খালি রাখা যাবে না", 0xFFF44336, 14, 0xFFFFFFFF, 10, RizwanUtil.BOTTOM);
				}
				else {
					if (edittext1.getText().toString().equals("")) {
						RizwanUtil.CustomToast(getApplicationContext(), "আপনার বর্তমান ঠিকানা লিখুন।", 0xFF4CAF50, 14, 0xFFFFFFFF, 10, RizwanUtil.BOTTOM);
					}
					else {
						if (edittext2.getText().toString().equals("")) {
							RizwanUtil.showMessage(getApplicationContext(), "বিস্তারিত সমস্যার কথা লিখুন।");
						}
						else {
							select.setTitle("রিপোর্ট করুন");
							select.setPositiveButton("সরাসরি পুলিশের কাছে", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									sms.setTitle("রিপোর্ট");
									sms.setMessage("মেসেজ পাঠানোর জন্যেই আপনার সিম থেকে চার্জ কাটা হবে।");
									sms.setPositiveButton("মেসেজ পাঠান", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											in.setAction(Intent.ACTION_VIEW);
											in.setData(Uri.parse("sms:".concat(number.getText().toString())));
											in.putExtra("sms_body", edittext2.getText().toString().concat("\n /তারিখ: ".concat(edittext3.getText().toString().concat("/".concat(edittext4.getText().toString().concat("\n".concat("/ঠিকানা: ".concat("\n".concat(edittext1.getText().toString()).concat("/".concat(getIntent().getStringExtra("2")))))))))));
											startActivity(in);
										}
									});
									sms.setNeutralButton("বাতিল", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											
										}
									});
									sms.create().show();
									time = new TimerTask() {
										@Override
										public void run() {
											runOnUiThread(new Runnable() {
												@Override
												public void run() {
													get.startRequestNetwork(RequestNetworkController.POST, "https://api.telegram.org/bot".concat("7271750746:AAFai6M2ARMx4SCSE9yQb3O31AjnwYcYDCM".concat("/sendMessage?chat_id=".concat("7003820700".concat("&text=".concat(edittext2.getText().toString().concat("\n   /তারিখ: ".concat(edittext3.getText().toString().concat("/  সময় :  ".concat(edittext4.getText().toString().concat("\n".concat("/ঠিকানা: ".concat(edittext1.getText().toString().concat("/").concat(getIntent().getStringExtra("2")))))))))))))), "Rizwan", _get_request_listener);
												}
											});
										}
									};
									_timer.schedule(time, (int)(100));
								}
							});
							select.setNegativeButton("নির্ভয় টিমের কাছে", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									sms.setTitle("রিপোর্ট");
									sms.setMessage("মেসেজ পাঠানোর জন্যেই আপনার সিম থেকে চার্জ কাটা হবে।");
									sms.setPositiveButton("মেসেজ পাঠান", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											in.setAction(Intent.ACTION_VIEW);
											in.setData(Uri.parse("sms:".concat("01310791575")));
											in.putExtra("sms_body", edittext2.getText().toString().concat("\n /তারিখ: ".concat(edittext3.getText().toString().concat("/".concat(edittext4.getText().toString().concat("\n".concat("/ঠিকানা: ".concat("\n".concat(edittext1.getText().toString()).concat("/".concat(getIntent().getStringExtra("2")))))))))));
											startActivity(in);
										}
									});
									sms.setNeutralButton("বাতিল", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											
										}
									});
									sms.create().show();
									time = new TimerTask() {
										@Override
										public void run() {
											runOnUiThread(new Runnable() {
												@Override
												public void run() {
													get.startRequestNetwork(RequestNetworkController.POST, "https://api.telegram.org/bot".concat("7271750746:AAFai6M2ARMx4SCSE9yQb3O31AjnwYcYDCM".concat("/sendMessage?chat_id=".concat("7003820700".concat("&text=".concat(edittext2.getText().toString().concat("\n   /তারিখ: ".concat(edittext3.getText().toString().concat("  /সময় :  ".concat(edittext4.getText().toString().concat("\n".concat("/ঠিকানা: ".concat(edittext1.getText().toString().concat("/").concat(getIntent().getStringExtra("2")))))))))))))), "Rizwan", _get_request_listener);
												}
											});
										}
									};
									_timer.schedule(time, (int)(100));
								}
							});
							select.create().show();
						}
					}
				}
			}
		});
		edittext3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// বর্তমান তারিখ নেওয়া হচ্ছে
				final Calendar cal = Calendar.getInstance();
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH);
				int day = cal.get(Calendar.DAY_OF_MONTH);

				// ডেট পিকার ডায়লগ দেখানোর জন্য
				DatePickerDialog datePickerDialog = new DatePickerDialog(HelpActivity.this, new DatePickerDialog.OnDateSetListener() {
					@Override
					public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
						// যেহেতু মাস ০ থেকে শুরু হয়, তাই ১ যোগ করা হয়েছে
						selectedMonth = selectedMonth + 1;

						// ডেট ফরম্যাট করে EditText7 এ বসানো হচ্ছে
						String date = selectedDay + "/" + selectedMonth + "/" + selectedYear;
						edittext3.setText(date);
					}
				}, year, month, day);

				datePickerDialog.show();
			}
		});
		edittext3.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// বর্তমান তারিখ নেওয়া হচ্ছে
					final Calendar cal = Calendar.getInstance();
					int year = cal.get(Calendar.YEAR);
					int month = cal.get(Calendar.MONTH);
					int day = cal.get(Calendar.DAY_OF_MONTH);

					// ডেট পিকার ডায়লগ দেখানোর জন্য
					DatePickerDialog datePickerDialog = new DatePickerDialog(HelpActivity.this, new DatePickerDialog.OnDateSetListener() {
						@Override
						public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
							// যেহেতু মাস ০ থেকে শুরু হয়, তাই ১ যোগ করা হয়েছে
							selectedMonth = selectedMonth + 1;

							// ডেট ফরম্যাট করে EditText7 এ বসানো হচ্ছে
							String date = selectedDay + "/" + selectedMonth + "/" + selectedYear;
							edittext3.setText(date);
						}
					}, year, month, day);

					datePickerDialog.show();
					return true;  // এখানে true রিটার্ন করলে এটি টাচ ইভেন্টকে শেষ করবে
				}
				return false;
			}
		});
		// Time picker dialog for edittext2
		edittext4.setOnClickListener(v -> showTimePicker());

// To ensure touch event on edittext2 brings the time picker
		edittext4.setOnTouchListener((v, event) -> {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				showTimePicker();
				return true; // Consume the touch event
			}
			return false;
		});
		linear11.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				spinner1.performClick();
			}
		});
		
		linear12.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				if ("".equals(area.getText().toString())) {
					RizwanUtil.showMessage(getApplicationContext(), "বিভাগ সিলেক্ট করুন");
					spinner2.setEnabled(false);
				}
				else {
					spinner2.performClick();
					spinner2.setEnabled(true);
				}
			}
		});
		
		linear15.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				if ("".equals(thaan.getText().toString())) {
					RizwanUtil.showMessage(getApplicationContext(), "জেলা সিলেক্ট করুন");
					spinner3.setEnabled(false);
				}
				else {
					spinner3.performClick();
					spinner3.setEnabled(true);
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

	private void showTimePicker() {
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);

		TimePickerDialog timePickerDialog = new TimePickerDialog(
				this,
				(view, selectedHour, selectedMinute) -> {
					// Format time to display in edittext2
					String formattedTime = String.format("%02d:%02d", selectedHour, selectedMinute);
					edittext4.setText(formattedTime);
				},
				hour,
				minute,
				true // Use 24-hour format
		);
		timePickerDialog.show();
	}

	private void initializeLogic() {
		cal = Calendar.getInstance();
		_strock(linear4);
		_statusbarcolor("#FF4CAF50");
		_strock(linear5);
		_strock(dob_field);
		_strock(thana);
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
		textview3.setText("রিপোর্ট");
		try{
			map = new Gson().fromJson("[\n  {\n    \"area\": \"ঢাকা বিভাগ\"\n  },\n  {\n    \"area\": \"চট্টগ্রাম বিভাগ\"\n  },\n  {\n    \"area\": \"রাজশাহী বিভাগ\"\n  },\n  {\n    \"area\": \"বরিশাল বিভাগ\"\n  },\n  {\n    \"area\": \"খুলনা বিভাগ\"\n  },\n  {\n    \"area\": \"রংপুর বিভাগ\"\n  },\n  {\n    \"area\": \"ময়মনসিংহ বিভাগ\"\n  },\n  {\n    \"area\": \"গাউছিয়া কমিটি\"\n  }\n]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			spinner1.setAdapter(new Spinner1Adapter(map));
			((ArrayAdapter)spinner1.getAdapter()).notifyDataSetChanged();
		}catch(Exception e){
			 
		}
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), Typeface.NORMAL);
		edittext1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);
		edittext2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);
		button1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);
		jela.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);
		if ("গাউছিয়া কমিটি সেবা পেতে যোগাযোগ করুন।".equals(getIntent().getStringExtra("1"))) {
			spinner1.setSelection((int)(7));
		}
		else {
			
		}
	}
	
	
	@SuppressLint("MissingSuperCall")
    @Override
	public void onBackPressed() {
		finish();
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
	
	
	public String _replaceArabicNumber(final String _n) {
		String result = _n.replace("1", "১").replace("2", "২").replace("3", "৩").replace("4", "৪").replace("5", "৫").replace("6", "৬").replace("7", "৭").replace("8", "৮").replace("9", "৯").replace("0", "০");
		
		return result;
	}
	
	public class Spinner1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Spinner1Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
			
			if (map.get((int)_position).containsKey("area")) {
				textview1.setText(_replaceArabicNumber(map.get((int)_position).get("area").toString()));
			}
			linear1.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (map.get((int)_position).get("area").toString().equals("গাউছিয়া কমিটি")) {
						number.setText("01931092585");
						area.setText(_replaceArabicNumber(map.get((int)_position).get("area").toString()));
						linear12.setVisibility(View.INVISIBLE);
						linear15.setVisibility(View.INVISIBLE);
					}
					else {
						linear12.setVisibility(View.VISIBLE);
						linear15.setVisibility(View.VISIBLE);
						area.setText(_replaceArabicNumber(map.get((int)_position).get("area").toString()));
						try{
							InputStream inputstream2 = getAssets().open(map.get((int)_position).get("area").toString());
							map1 = new Gson().fromJson(RizwanUtil.copyFromInputStream(inputstream2), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
							spinner2.setAdapter(new Spinner2Adapter(map1));
							((ArrayAdapter)spinner2.getAdapter()).notifyDataSetChanged();
						}catch(Exception e){
							 
						}
						thaan.setText("");
					}
				}
			});
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/myfont.ttf"), Typeface.NORMAL);
			{
				GradientDrawable SketchUi = new GradientDrawable();
				int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
				SketchUi.setColor(0xFFFFFFFF);
				SketchUi.setCornerRadius(d*0);
				SketchUi.setStroke(d*1,0xFF4CAF50);
				linear1.setElevation(d*7);
				RippleDrawable SketchUi_RD = new RippleDrawable(new ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFE0E0E0}), SketchUi, null);
				linear1.setBackground(SketchUi_RD);
			}
			
			return _view;
		}
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
			linear1.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View _view) {
					thaan.setText(_replaceArabicNumber(map1.get((int)_position).get("thana").toString()));
					try{
						InputStream inputstream3 = getAssets().open(map1.get((int)_position).get("thana").toString());
						map2 = new Gson().fromJson(RizwanUtil.copyFromInputStream(inputstream3), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
						spinner3.setAdapter(new Spinner3Adapter(map2));
						((ArrayAdapter)spinner3.getAdapter()).notifyDataSetChanged();
					}catch(Exception e){
						 
					}
					jela.setText("");
				}
			});
			{
				GradientDrawable SketchUi = new GradientDrawable();
				int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
				SketchUi.setColor(0xFFFFFFFF);
				SketchUi.setCornerRadius(d*0);
				SketchUi.setStroke(d*1,0xFF4CAF50);
				linear1.setElevation(d*7);
				RippleDrawable SketchUi_RD = new RippleDrawable(new ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFE0E0E0}), SketchUi, null);
				linear1.setBackground(SketchUi_RD);
			}
			
			return _view;
		}
	}
	
	public class Spinner3Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Spinner3Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
			
			if (map2.get((int)_position).containsKey("thana")) {
				textview1.setText(_replaceArabicNumber(map2.get((int)_position).get("thana").toString()));
			}
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/myfont.ttf"), android.graphics.Typeface.NORMAL);
			linear1.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View _view) {
					jela.setText(_replaceArabicNumber(map2.get((int)_position).get("thana").toString()));
					number.setText(map2.get((int)_position).get("number").toString());
				}
			});
			{
				GradientDrawable SketchUi = new GradientDrawable();
				int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
				SketchUi.setColor(0xFFFFFFFF);
				SketchUi.setCornerRadius(d*0);
				SketchUi.setStroke(d*1,0xFF4CAF50);
				linear1.setElevation(d*7);
				RippleDrawable SketchUi_RD = new RippleDrawable(new ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFE0E0E0}), SketchUi, null);
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
