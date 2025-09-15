package com.srizwan01.nirvoy11;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Help0Activity extends AppCompatActivity {
	
	private HashMap<String, Object> map = new HashMap<>();
	private String string = "";
	
	private ArrayList<HashMap<String, Object>> map2 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> list = new ArrayList<>();
	
	private LinearLayout linear1;
	private GridView gridview1;
	private ImageView imageview1;
	private TextView textview1;
	
	private Intent in = new Intent();
	private SharedPreferences data;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.help0);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		gridview1 = findViewById(R.id.gridview1);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
	}
	
	private void initializeLogic() {
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFF4CAF50);
			linear1.setElevation(d*5);
			linear1.setBackground(SketchUi);
		}
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), Typeface.NORMAL);
		_statusbarcolor("#FF4CAF50");
		_contentlist("জঙ্গিবাদ বন্ধ করতে \nপদক্ষেপ নিন।", "terrorism");
		_contentlist("মাদক দ্রব্য ব্যবহার বন্ধ করতে \nপদক্ষেপ নিন।", "drugs");
		_contentlist("চোরাচালান বন্ধ করতে \nপদক্ষেপ নিন।", "smuggling");
		_contentlist("হত্যা ও ধর্ষণ বন্ধ করতে \nপদক্ষেপ নিন।", "pico_9");
		_contentlist("ছিনতাই বন্ধ করতে \nপদক্ষেপ নিন।", "pico_10");
		_contentlist("সন্ত্রাসী কার্যক্রম বন্ধ করতে \nপদক্ষেপ নিন।", "pico_3");
		_contentlist("প্রতারক ও জালিয়াতি বন্ধ করতে \nপদক্ষেপ নিন।", "pico_6");
		_contentlist("অস্ত্র ও বিস্ফোরক দ্রব্য বন্ধ করতে \nপদক্ষেপ নিন।", "pico_1");
		_contentlist("অপহরণ বন্ধ করতে \nপদক্ষেপ নিন। ", "pico_2");
		_contentlist("মানব পাচার বন্ধ করতে \nপদক্ষেপ নিন। ", "pico_7");
		_contentlist("শিশুশ্রম বন্ধ করতে \nপদক্ষেপ নিন।", "shishu");
		_contentlist("কিশোর গ্যাং বন্ধ করতে \nপদক্ষেপ নিন। ", "pic_1");
		_contentlist("বাল্যবিবাহ বন্ধ করতে \nপদক্ষেপ নিন। ", "ballubibah");
		_contentlist("পলিথিনের ব্যবহার বন্ধ করতে \nপদক্ষেপ নিন। ", "pic_2");
		_contentlist("শিক্ষা প্রতিষ্ঠান (স্কুল, কলেজ) এ শিক্ষক বা অন্যান্য কর্তৃক শিক্ষার্থী  নির্যাতন বা এ হেনো কোনো ঘটনার সুষ্ঠু বিচার পেতে পদক্ষেপ নিন", "school");
		_contentlist("ধর্মীয় শিক্ষা প্রতিষ্ঠান (মাদ্রাসা, মন্দির, লার্নিং সেন্টার) এ শিক্ষক বা অন্যান্য কর্তৃক, শিক্ষার্থী  নির্যাতন বা এ হেনো কোনো ঘটনার সুষ্ঠু বিচার পেতে পদক্ষেপ নিন", "mosque");
		_contentlist("অজ্ঞাত লাশ দাফন কাফন ও জরুরি সেবায় গাউছিয়া কমিটির সেবা পেতে যোগাযোগ করুন।", "gausiys");
		_contentlist("অন্যান্য অপরাধ বন্ধ করতে \nপদক্ষেপ নিন।\n", "pico_8");
	}
	
	@SuppressLint("MissingSuperCall")
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
	
	
	public void _moveon(final TextView _b) {
		in.setClass(getApplicationContext(), HelpActivity.class);
		in.putExtra("1", _b.getText().toString());
		startActivity(in);
	}
	
	
	public void _contentlist(final String _add, final String _add1) {
		map = new HashMap<>();
		map.put("1", _add);
		map.put("2", _add1);
		list.add(map);
		gridview1.setAdapter(new Gridview1Adapter(list));
		((BaseAdapter)gridview1.getAdapter()).notifyDataSetChanged();
		gridview1.setNumColumns((int)2);
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
	
	public class Gridview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Gridview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.custom, null);
			}
			
			final LinearLayout box1 = _view.findViewById(R.id.box1);
			final de.hdodenhof.circleimageview.CircleImageView circleimageview15 = _view.findViewById(R.id.circleimageview15);
			final LinearLayout linear48 = _view.findViewById(R.id.linear48);
			final TextView textview20 = _view.findViewById(R.id.textview20);
			
			android.view.animation.Animation animation = new android.view.animation.ScaleAnimation(0f, 1f, 0f, 1f, android.view.animation.Animation.RELATIVE_TO_SELF, 0f, android.view.animation.Animation.RELATIVE_TO_SELF, 1f);
			animation.setFillAfter(true);
			animation.setDuration(300);
			box1.setAnimation(animation);
			_stock(box1);
			_border(linear48);
			textview20.setText(list.get((int)_position).get("1").toString());
			circleimageview15.setImageResource(getResources().getIdentifier(list.get((int)_position).get("2").toString(), "drawable", getPackageName()));
			box1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					in.setClass(getApplicationContext(), HelpActivity.class);
					in.putExtra("1", list.get((int)_position).get("1").toString());
					in.putExtra("2", getIntent().getStringExtra("1"));
					startActivity(in);
				}
			});
			textview20.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);
			
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
