package com.srizwan01.nirvoy11;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.widget.*;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.*;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import android.provider.Settings;
import android.net.wifi.WifiManager;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class Main1Activity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private FloatingActionButton _fab;
	private DrawerLayout _drawer;
	private String strAdd = "";
	private String strCity = "";
	private String strState = "";
	private String strCountry = "";
	private String strPC = "";
	private String strKN = "";
	private double position = 0;
	private double num = 0;
	private boolean granted = false;
	private String newName = "";
	private String packageName = "";
	private boolean isAppInstalled = false;
	private String a = "";
	private String b = "";
	private String sharecopy = "";
	private HashMap<String, Object> map = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> list = new ArrayList<>();
	private ArrayList<String> city = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> inf = new ArrayList<>();
	
	private LinearLayout linear1;
	private ScrollView vscroll1;
	private ImageView Menu;
	private LinearLayout linear3;
	private ImageView imageview1;
	private ImageView linear5;
	private TextView location;
	private ImageView imageview7;
	private CircleImageView imageview6;
	private LinearLayout linear2;
	private LinearLayout silder;
	private LinearLayout linear10;
	private TextView Longitude;
	private TextView Latitude;
	private LinearLayout linear12;
	private Button button1;
	private TextView text_debug;
	private RelativeLayout linear7;
	private ViewPager viewpager_slider;
	private TextView textview6;
	private TextView nidname;
	private TextView nidnumber;
	private TextView dob;
	private TextView phonenumber;
	private TextView verified;
	private TextView adress;
	private LinearLayout urgent;
	private LinearLayout help;
	private LinearLayout help1;
	private LinearLayout blog;
	private TextView getall;
	private ImageView imageview2;
	private TextView textview2;
	private ImageView imageview3;
	private TextView textview3;
	private ImageView imageview4;
	private TextView textview4;
	private ImageView imageview5;
	private TextView textview5;
	private ScrollView _drawer_vscroll1;
	private LinearLayout _drawer_linear2;
	private LinearLayout _drawer_linear_1;
	private LinearLayout _drawer_linear_3;
	private LinearLayout _drawer_linear_5;
	private LinearLayout _drawer_linear15;
	private LinearLayout _drawer_linear_6;
	private LinearLayout _drawer_linear_9;
	private LinearLayout _drawer_linear16;
	private LinearLayout _drawer_about_us;
	private LinearLayout _drawer_linear_2;
	private LinearLayout _drawer_linear_10;
	private LinearLayout _drawer_share;
	private LinearLayout _drawer_emergency1;
	private LinearLayout _drawer_emergency2;
	private LinearLayout _drawer_setting;
	private LinearLayout _drawer_policy;
	private LinearLayout _drawer_linear_11;
	private ImageView _drawer_imageview1;
	private TextView _drawer_textview1_1;
	private ImageView _drawer_imageview3;
	private TextView _drawer_textview1_3;
	private ImageView _drawer_imageview5;
	private TextView _drawer_textview1_4;
	private ImageView _drawer_imageview6;
	private TextView _drawer_textview1_5;
	private ImageView _drawer_imageview9;
	private TextView _drawer_textview1_6;
	private ImageView _drawer_imageview13;
	private TextView _drawer_about_us2;
	private ImageView _drawer_imageview2;
	private TextView _drawer_textview1_2;
	private ImageView _drawer_imageview10;
	private TextView _drawer_textview1_7;
	private ImageView _drawer_imageview12;
	private TextView _drawer_textview1_0;
	private ImageView _drawer_imageview14;
	private TextView _drawer_textview2_0;
	private ImageView _drawer_imageview15;
	private TextView _drawer_textview3_0;
	private ImageView _drawer_imageview16;
	private TextView _drawer_textview4_0;
	private ImageView _drawer_imageview11;
	private TextView _drawer_textview1_8;
	private ImageView _drawer_imageview17;
	private TextView _drawer_textview1;
	
	private RequestNetwork internet;
	private RequestNetwork.RequestListener _internet_request_listener;
	private LocationManager l;
	private LocationListener _l_location_listener;
	private Intent help0 = new Intent();
	private TimerTask timer;
	private TimerTask seven;
	private Intent intent = new Intent();
	private Intent call = new Intent();
	private TimerTask time;
	private RequestNetwork get;
	private RequestNetwork.RequestListener _get_request_listener;
	private TimerTask goal_location;
	private Intent locationdialog = new Intent();
	private AlertDialog.Builder loc;
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private OnCompleteListener<Void> auth_updateEmailListener;
	private OnCompleteListener<Void> auth_updatePasswordListener;
	private OnCompleteListener<Void> auth_emailVerificationSentListener;
	private OnCompleteListener<Void> auth_deleteUserListener;
	private OnCompleteListener<Void> auth_updateProfileListener;
	private OnCompleteListener<AuthResult> auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> auth_googleSignInListener;
	
	private SharedPreferences locate;
	private DatabaseReference db = _firebase.getReference("db");
	private ChildEventListener _db_child_listener;
	private AlertDialog.Builder renameDialog;
	private AlertDialog.Builder dialog;
	private AlertDialog.Builder sms;
	private AlertDialog.Builder kop;
	private SharedPreferences details;
	private AlertDialog.Builder login;
	private Intent in = new Intent();
	private Intent email = new Intent();
	private AlertDialog.Builder gps;
	private Intent mail = new Intent();
	private Intent go = new Intent();
	private Intent emergency = new Intent();
	private AlertDialog.Builder verify;
	private SharedPreferences language;
	private Intent message = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main1);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE, Manifest.permission.ACCESS_FINE_LOCATION}, 1000);
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
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		_fab = findViewById(R.id._fab);
		
		_drawer = findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(Main1Activity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		linear1 = findViewById(R.id.linear1);
		vscroll1 = findViewById(R.id.vscroll1);
		Menu = findViewById(R.id.Menu);
		linear3 = findViewById(R.id.linear3);
		imageview1 = findViewById(R.id.imageview1);
		linear5 = findViewById(R.id.linear5);
		location = findViewById(R.id.location);
		imageview7 = findViewById(R.id.imageview7);
		imageview6 = findViewById(R.id.imageview6);
		linear2 = findViewById(R.id.linear2);
		silder = findViewById(R.id.silder);
		linear10 = findViewById(R.id.linear10);
		Longitude = findViewById(R.id.Longitude);
		Latitude = findViewById(R.id.Latitude);
		linear12 = findViewById(R.id.linear12);
		button1 = findViewById(R.id.button1);
		text_debug = findViewById(R.id.text_debug);
		linear7 = findViewById(R.id.linear7);
		viewpager_slider = findViewById(R.id.viewpager_slider);
		textview6 = findViewById(R.id.textview6);
		nidname = findViewById(R.id.nidname);
		nidnumber = findViewById(R.id.nidnumber);
		dob = findViewById(R.id.dob);
		phonenumber = findViewById(R.id.phonenumber);
		verified = findViewById(R.id.verified);
		adress = findViewById(R.id.adress);
		urgent = findViewById(R.id.urgent);
		help = findViewById(R.id.help);
		help1 = findViewById(R.id.help1);
		blog = findViewById(R.id.blog);
		getall = findViewById(R.id.getall);
		imageview2 = findViewById(R.id.imageview2);
		textview2 = findViewById(R.id.textview2);
		imageview3 = findViewById(R.id.imageview3);
		textview3 = findViewById(R.id.textview3);
		imageview4 = findViewById(R.id.imageview4);
		textview4 = findViewById(R.id.textview4);
		imageview5 = findViewById(R.id.imageview5);
		textview5 = findViewById(R.id.textview5);
		_drawer_vscroll1 = _nav_view.findViewById(R.id.vscroll1);
		_drawer_linear2 = _nav_view.findViewById(R.id.linear2);
		_drawer_linear_1 = _nav_view.findViewById(R.id.linear_1);
		_drawer_linear_3 = _nav_view.findViewById(R.id.linear_3);
		_drawer_linear_5 = _nav_view.findViewById(R.id.linear_5);
		_drawer_linear15 = _nav_view.findViewById(R.id.linear15);
		_drawer_linear_6 = _nav_view.findViewById(R.id.linear_6);
		_drawer_linear_9 = _nav_view.findViewById(R.id.linear_9);
		_drawer_linear16 = _nav_view.findViewById(R.id.linear16);
		_drawer_about_us = _nav_view.findViewById(R.id.about_us);
		_drawer_linear_2 = _nav_view.findViewById(R.id.linear_2);
		_drawer_linear_10 = _nav_view.findViewById(R.id.linear_10);
		_drawer_share = _nav_view.findViewById(R.id.share);
		_drawer_emergency1 = _nav_view.findViewById(R.id.emergency1);
		_drawer_emergency2 = _nav_view.findViewById(R.id.emergency2);
		_drawer_setting = _nav_view.findViewById(R.id.setting);
		_drawer_policy = _nav_view.findViewById(R.id.policy);
		_drawer_linear_11 = _nav_view.findViewById(R.id.linear_11);
		_drawer_imageview1 = _nav_view.findViewById(R.id.imageview1);
		_drawer_textview1_1 = _nav_view.findViewById(R.id.textview1_1);
		_drawer_imageview3 = _nav_view.findViewById(R.id.imageview3);
		_drawer_textview1_3 = _nav_view.findViewById(R.id.textview1_3);
		_drawer_imageview5 = _nav_view.findViewById(R.id.imageview5);
		_drawer_textview1_4 = _nav_view.findViewById(R.id.textview1_4);
		_drawer_imageview6 = _nav_view.findViewById(R.id.imageview6);
		_drawer_textview1_5 = _nav_view.findViewById(R.id.textview1_5);
		_drawer_imageview9 = _nav_view.findViewById(R.id.imageview9);
		_drawer_textview1_6 = _nav_view.findViewById(R.id.textview1_6);
		_drawer_imageview13 = _nav_view.findViewById(R.id.imageview13);
		_drawer_about_us2 = _nav_view.findViewById(R.id.about_us2);
		_drawer_imageview2 = _nav_view.findViewById(R.id.imageview2);
		_drawer_textview1_2 = _nav_view.findViewById(R.id.textview1_2);
		_drawer_imageview10 = _nav_view.findViewById(R.id.imageview10);
		_drawer_textview1_7 = _nav_view.findViewById(R.id.textview1_7);
		_drawer_imageview12 = _nav_view.findViewById(R.id.imageview12);
		_drawer_textview1_0 = _nav_view.findViewById(R.id.textview1_0);
		_drawer_imageview14 = _nav_view.findViewById(R.id.imageview14);
		_drawer_textview2_0 = _nav_view.findViewById(R.id.textview2_0);
		_drawer_imageview15 = _nav_view.findViewById(R.id.imageview15);
		_drawer_textview3_0 = _nav_view.findViewById(R.id.textview3_0);
		_drawer_imageview16 = _nav_view.findViewById(R.id.imageview16);
		_drawer_textview4_0 = _nav_view.findViewById(R.id.textview4_0);
		_drawer_imageview11 = _nav_view.findViewById(R.id.imageview11);
		_drawer_textview1_8 = _nav_view.findViewById(R.id.textview1_8);
		_drawer_imageview17 = _nav_view.findViewById(R.id.imageview17);
		_drawer_textview1 = _nav_view.findViewById(R.id.textview1);
		internet = new RequestNetwork(this);
		l = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		get = new RequestNetwork(this);
		loc = new AlertDialog.Builder(this);
		auth = FirebaseAuth.getInstance();
		locate = getSharedPreferences("locate", Activity.MODE_PRIVATE);
		renameDialog = new AlertDialog.Builder(this);
		dialog = new AlertDialog.Builder(this);
		sms = new AlertDialog.Builder(this);
		kop = new AlertDialog.Builder(this);
		details = getSharedPreferences("details", Activity.MODE_PRIVATE);
		login = new AlertDialog.Builder(this);
		gps = new AlertDialog.Builder(this);
		verify = new AlertDialog.Builder(this);
		language = getSharedPreferences("lang", Activity.MODE_PRIVATE);
		
		Menu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		imageview1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		linear5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
				startActivity(intent);
			}
		});
		
		location.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", location.getText().toString()));
				RizwanUtil.showMessage(getApplicationContext(), "কপি করা হয়েছে  ".concat(location.getText().toString()));
				// Open map and search text address from textview1 by Rizwan
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location.getText().toString()));
				intent.setPackage("com.google.android.apps.maps");
				startActivity(intent);
			}
		});
		
		imageview7.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				help0.setClass(getApplicationContext(), NewsActivity.class);
				startActivity(help0);
			}
		});
		
		imageview6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					intent.setClass(getApplicationContext(), ProfileActivity.class);
					startActivity(intent);
				}
				else {
					if (location.getText().toString().equals("")) {
						intent.setClass(getApplicationContext(), Main0Activity.class);
						startActivity(intent);
					}
					else {
						locate.edit().putString("locate", location.getText().toString()).commit();
						intent.setClass(getApplicationContext(), Main0Activity.class);
						startActivity(intent);
					}
				}
			}
		});
		
		urgent.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (verified.getText().toString().equals("TextView")) {
					RizwanUtil.showMessage(getApplicationContext(), "ভেরিফিকেশন করুন");
					verify.setTitle("জরুরি সেবা ব্যবহার করার জন্যেই ভেরিফিকেশন করতে হবে।");
					verify.setPositiveButton("প্রোফাইল ভেরিফিকেশন", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							in.setClass(getApplicationContext(), ProfileActivity.class);
							startActivity(in);
						}
					});
					verify.setNeutralButton("বাতিল", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					verify.create().show();
				}
				else {
					if (verified.getText().toString().equals("Non verified")) {
						RizwanUtil.showMessage(getApplicationContext(), "ভেরিফিকেশন করুন");
						verify.setTitle("জরুরি সেবা ব্যবহার করার জন্যেই ভেরিফিকেশন করতে হবে।");
						verify.setPositiveButton("প্রোফাইল ভেরিফিকেশন", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								in.setClass(getApplicationContext(), ProfileActivity.class);
								startActivity(in);
							}
						});
						verify.setNeutralButton("বাতিল", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						verify.create().show();
					}
					else {
						if (nidnumber.getText().toString().equals("TextView")) {
							RizwanUtil.showMessage(getApplicationContext(), "প্রোফাইলে তথ্য ঠিক ভাবে দেওয়া নেই।");
						}
						else {
							if (!location.getText().toString().contains("Bandarban")) {
								RizwanUtil.showMessage(getApplicationContext(), "বান্দরবান জেলার জন্যেই প্রযোজ্য।");
							}
							else {
								if (phonenumber.getText().toString().equals("TextView")) {
									RizwanUtil.showMessage(getApplicationContext(), "প্রোফাইলে তথ্য ঠিক ভাবে দেওয়া নেই।");
								}
								else {
									if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
										help0.setClass(getApplicationContext(), Help1Activity.class);
										help0.putExtra("1", "আসসালামু আলাইকুম আমি বিপদে আছি সাহায্য করুন।".concat("\nআইডি কার্ডের নাম : ".concat(nidname.getText().toString().concat("/  বর্তমান ঠিকানা: ".concat(location.getText().toString().concat("/	মোবাইল নাম্বার: ".concat(phonenumber.getText().toString())))))));
										startActivity(help0);
									}
									else {
										login.setTitle("জরুরি সেবা ব্যবহার করার জন্যেই লগ ইন বা সাইন আপ করতে হবে।");
										login.setPositiveButton("লগ ইন", new DialogInterface.OnClickListener() {
											@Override
											public void onClick(DialogInterface _dialog, int _which) {
												in.setClass(getApplicationContext(), LoginActivity.class);
												startActivity(in);
											}
										});
										login.setNegativeButton("সাইন আপ", new DialogInterface.OnClickListener() {
											@Override
											public void onClick(DialogInterface _dialog, int _which) {
												in.setClass(getApplicationContext(), SingupActivity.class);
												startActivity(in);
											}
										});
										login.setNeutralButton("বাতিল", new DialogInterface.OnClickListener() {
											@Override
											public void onClick(DialogInterface _dialog, int _which) {
												
											}
										});
										login.create().show();
									}
								}
							}
						}
					}
				}
			}
		});
		
		help.setOnLongClickListener(new OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				
				return true;
			}
		});
		
		help.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					help0.setClass(getApplicationContext(), Help0Activity.class);
					help0.putExtra("1", "\nআইডি কার্ডের নাম : ".concat(nidname.getText().toString().concat("  বর্তমান ঠিকানা".concat(location.getText().toString().concat("	মোবাইল নাম্বার: ".concat(phonenumber.getText().toString()))))));
					startActivity(help0);
				}
				else {
					login.setTitle("জরুরি সেবা ব্যবহার করার জন্যেই লগ ইন বা সাইন আপ করতে হবে।");
					login.setPositiveButton("লগ ইন", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							in.setClass(getApplicationContext(), LoginActivity.class);
							startActivity(in);
						}
					});
					login.setNegativeButton("সাইন আপ", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							in.setClass(getApplicationContext(), SingupActivity.class);
							startActivity(in);
						}
					});
					login.setNeutralButton("বাতিল", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					login.create().show();
				}
			}
		});
		
		help1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), XpolicenumberbookActivity.class);
				startActivity(in);
			}
		});
		
		blog.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				help0.setClass(getApplicationContext(), BlogonlineActivity.class);
				startActivity(help0);
				@SuppressLint("WifiManagerLeak") WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
				wifiManager.setWifiEnabled(true);
			}
		});
		
		_internet_request_listener = new RequestNetwork.RequestListener() {
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
		
		_l_location_listener = new LocationListener() {
			@Override
			public void onLocationChanged(Location _param1) {
				final double _lat = _param1.getLatitude();
				final double _lng = _param1.getLongitude();
				final double _acc = _param1.getAccuracy();
				_getLocation(_lat, _lng);
				location.setText(strAdd);
				GPSLocationProvider gpsLocationProvider = new GPSLocationProvider(Main1Activity.this, Latitude, Longitude);
				gpsLocationProvider.requestLocationUpdates();
				timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								try{
									_getLocation1(Double.parseDouble(Latitude.getText().toString()), Double.parseDouble(Longitude.getText().toString()));
									location.setText(strAdd);
								}catch(Exception e){
									 
								}
							}
						});
					}
				};
				_timer.scheduleAtFixedRate(timer, (int)(0), (int)(1000));
			}
			
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
			}
			
			@Override
			public void onProviderEnabled(String provider) {
			}
			
			@Override
			public void onProviderDisabled(String provider) {
			}
		};
		
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
		
		_db_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					db.addListenerForSingleValueEvent(new ValueEventListener() {
						@Override
						public void onDataChange(DataSnapshot _dataSnapshot) {
							inf = new ArrayList<>();
							try {
								GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
								for (DataSnapshot _data : _dataSnapshot.getChildren()) {
									HashMap<String, Object> _map = _data.getValue(_ind);
									inf.add(_map);
								}
							}
							catch (Exception _e) {
								_e.printStackTrace();
							}
							if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
								Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("avatar").toString())).into(imageview6);
								nidname.setText(_childValue.get("nidname").toString());
								phonenumber.setText(_childValue.get("phonenumber").toString());
								nidnumber.setText(_childValue.get("nidnumber").toString());
								adress.setText(_childValue.get("address").toString());
								dob.setText(_childValue.get("dob").toString());
								verified.setText(_childValue.get("verified").toString());
							}
						}
						@Override
						public void onCancelled(DatabaseError _databaseError) {
						}
					});
				}
				else {
					
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					db.addListenerForSingleValueEvent(new ValueEventListener() {
						@Override
						public void onDataChange(DataSnapshot _dataSnapshot) {
							inf = new ArrayList<>();
							try {
								GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
								for (DataSnapshot _data : _dataSnapshot.getChildren()) {
									HashMap<String, Object> _map = _data.getValue(_ind);
									inf.add(_map);
								}
							}
							catch (Exception _e) {
								_e.printStackTrace();
							}
							if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
								Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("avatar").toString())).into(imageview6);
								nidname.setText(_childValue.get("nidname").toString());
								phonenumber.setText(_childValue.get("phonenumber").toString());
								nidnumber.setText(_childValue.get("nidnumber").toString());
								adress.setText(_childValue.get("address").toString());
								dob.setText(_childValue.get("dob").toString());
								verified.setText(_childValue.get("verified").toString());
							}
						}
						@Override
						public void onCancelled(DatabaseError _databaseError) {
						}
					});
				}
				else {
					
				}
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					db.addListenerForSingleValueEvent(new ValueEventListener() {
						@Override
						public void onDataChange(DataSnapshot _dataSnapshot) {
							inf = new ArrayList<>();
							try {
								GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
								for (DataSnapshot _data : _dataSnapshot.getChildren()) {
									HashMap<String, Object> _map = _data.getValue(_ind);
									inf.add(_map);
								}
							}
							catch (Exception _e) {
								_e.printStackTrace();
							}
							if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
								Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("avatar").toString())).into(imageview6);
								nidname.setText(_childValue.get("nidname").toString());
								phonenumber.setText(_childValue.get("phonenumber").toString());
								nidnumber.setText(_childValue.get("nidnumber").toString());
								adress.setText(_childValue.get("address").toString());
								dob.setText(_childValue.get("dob").toString());
								verified.setText(_childValue.get("verified").toString());
							}
						}
						@Override
						public void onCancelled(DatabaseError _databaseError) {
						}
					});
				}
				else {
					
				}
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		db.addChildEventListener(_db_child_listener);
		
		_drawer_linear2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), BlogActivity.class);
				startActivity(in);
			}
		});
		
		_drawer_linear_1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview6.performClick();
			}
		});
		
		_drawer_linear_3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				go.setClass(getApplicationContext(), PhonenumberActivity.class);
				go.putExtra("1", "নির্ভয় কি ও কেন?");
				go.putExtra("2", "এবাউট আসঃ \nনির্ভয় অ্যাপ কি ? \n= নির্ভয় একটি স্মার্টফোন বেইজড মোবাইল অ্যাপ। অ্যাপটির সহায়তায় বাংলাদেশের নিত্যঘটমান বিভিন্ন সামাজিক সমস্যা থেকে দ্রুত পার্শ্ববর্তী থানায় বিপদ এবং সহায়তা বার্তা প্রেরণের পাশাপাশি নির্ভয় টিমএর সহায়তায় সামাজিক সমস্যা থেকে নিস্তার পেতে এওয়ারনেস ক্রিয়েশন/সচেতনতা তৈরি করতে পারবে যে কেউ যাতে ধীরে ধীরে সমস্যাগুলি কমে আসে এবং এবং সবাই সচেতন হয়। ঘরে বসেই বা যেকোনো স্থান থেকে অ্যাপটির মাধ্যমে সহায়তা চাওয়া যাবে। এছাড়াও এই অ্যাপএর কয়েকটি বিশেষ ফিচার রয়েছে যেমন ইমারজেন্সি ইভটিজিং, ধর্ষণ, হামলা ছিনতাই থেকে  বাচার উপায়। কারো ইমারজেন্সি রক্ত প্রয়োজন হলে অ্যাপটির মাধ্যমে তাঁর লোকেশনের আশেপাশে থাকা ব্লাড ডোনারদের সাথে যোগাযোগ করতে পারবে। একই ভাবে এম্বুল্যান্স এবং ফায়ার সার্ভিস এর তথ্য ও অ্যাপটির মাধ্যমে পাওয়া যাবে।সর্বোপরি টিনেজারসহ বাংলাদেশের যেকোনো বয়সের মানুষের বিপদে পাশে পাওয়া যাবে নির্ভয় অ্যাপকে !");
				startActivity(go);
			}
		});
		
		_drawer_linear_5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview7.performClick();
			}
		});
		
		_drawer_linear_6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				call.setAction(Intent.ACTION_VIEW);
					call.setData(Uri.parse("https://facebook.com/groups/1315851425747654/"));
					startActivity(call);
			}
		});
		
		_drawer_linear_9.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				renameDialog.setTitle("রিপোর্ট লিখুন");
				LinearLayout layout = new LinearLayout(Main1Activity.this);
				layout.setOrientation(LinearLayout.VERTICAL);
				
				LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT); 
				final EditText edittxt3 = new EditText(Main1Activity.this);
				edittxt3.setHint("রিপোর্ট লিখুন");
				edittxt3.setLayoutParams(lp);
				edittxt3.setElevation(6f);
				layout.addView(edittxt3);
				renameDialog.setView(layout);
				renameDialog.setNegativeButton("বাতিল করুন", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						RizwanUtil.hideKeyboard(getApplicationContext());
					}
				});
				renameDialog.setPositiveButton("নির্ভয় টিমকে রিপোর্ট পাঠান", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						if (newName.equals("")) {
							RizwanUtil.showMessage(getApplicationContext(), "ঘর খালি রাখা যাবে না");
						}
						else {
							newName = edittxt3.getText().toString();
							get.startRequestNetwork(RequestNetworkController.POST, "https://api.telegram.org/bot".concat("7354217155:AAHQnDb_p395tp0Ny3BUYRkLLom3bibq730".concat("/sendMessage?chat_id=".concat("7003820700".concat("&text=".concat(newName))))), "Rizwan", _get_request_listener);
							RizwanUtil.showMessage(getApplicationContext(), "রিপোর্ট পাঠানো হয়েছে");
						}
					}
				});
				renameDialog.setNeutralButton("G-mail", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						message.setAction(Intent.ACTION_VIEW);
						message.setData(Uri.parse("mailto:nirvhoyappandteam@gmail.com"));
						startActivity(message);
					}
				});
				renameDialog.create().show();
			}
		});
		
		_drawer_about_us.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), AboutUsActivity.class);
				startActivity(in);
			}
		});
		
		_drawer_linear_10.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				_rate1();
			}
		});
		
		_drawer_share.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				_share1();
			}
		});
		
		_drawer_emergency1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				_floating(200, 200);
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
					if (Settings.canDrawOverlays(Main1Activity.this)) {
						_showFloatingWindow();
					}
					else {
						_checkPermission();
					}
				}
			}
		});
		
		_drawer_emergency2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				RizwanUtil.showMessage(getApplicationContext(), "Coming Soon...");
			}
		});
		
		_drawer_setting.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), WelcomeUiActivity.class);
				startActivity(in);
			}
		});
		
		_drawer_policy.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				go.setClass(getApplicationContext(), PhonenumberActivity.class);
				go.putExtra("1", "Privacy Policy");
				go.putExtra("2", " **Privacy Policy**\n\n\nEffective Date: October 07, 2024\n\n\n**Introduction**\n\n\nWelcome to নির্ভয় - The Protector. Your privacy is critically important to us. This Privacy Policy outlines the types of information we collect, how we use it, and how we safeguard your data when you use our mobile application, available at the Google Play Store.\n\n\n**1. Information We Collect**\n\n\nWhen you use our app, we collect the following information:\n\n- **Personal Information**: When you sign up, we require you to provide your full name, email address, password, mobile number, national ID or birth certificate number, permanent address, and date of birth.\n\n- **Location Information**: We collect your real-time location using GPS and mobile network data to provide emergency services.\n\n- **Device Information**: We may collect information about your device, including hardware model, operating system, and mobile network information.\n\n  \n\n**2. How We Use Your Information**\n\n\nThe information we collect is used for the following purposes:\n\n- **To Provide Emergency Services**: Your personal and location data is used to provide services like SOS alerts, emergency calls, and messages to nearby police stations, ambulances, fire services, and blood donation facilities.\n\n- **Verification**: We use your national ID or birth certificate number to verify your identity before granting access to critical features.\n\n- **Communication**: Your contact details are used to communicate with emergency services or people in your phone book.\n\n  \n\n**3. Sharing Your Information**\n\n\nWe do not sell or rent your personal information to third parties. However, we may share your data with:\n\n- **Emergency Services**: In emergency situations, we will share your location and contact details with police stations, hospitals, or other emergency services.\n\n- **Law Enforcement**: If required by law, we may disclose your information to government authorities or law enforcement officials.\n\n\n**4. Data Security**\n\n\nWe implement strict security measures to protect your personal information, including encryption of sensitive data. However, no security system is completely secure, and we cannot guarantee the absolute security of your data.\n\n\n**5. Your Rights**\n\n\nYou have the right to:\n\n- **Access Your Data**: You can request access to the personal information we hold about you.\n\n- **Delete Your Data**: You may request that we delete your account and personal information from our systems.\n\n\n**6. Changes to This Privacy Policy**\n\n\nWe may update this Privacy Policy from time to time. Any changes will be communicated to you via email or through the app.\n\n\"If you wish to request the deletion of your account and associated data, you can do so by navigating to the account settings in the app and selecting the 'Delete Account' option. For further assistance, please nirvoyappandteam1@gmail.com.\"\n\n**7. Contact Us**\n\n\nIf you have any questions or concerns about this Privacy Policy, please contact us at nirvoyappandteam1@gmail.com.\n\n\n---\n\n");
				startActivity(go);
			}
		});
		
		_drawer_linear_11.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				final ProgressDialog prog = new ProgressDialog(Main1Activity.this);
				prog.setMax(100);
				prog.setMessage("Log out");
				prog.setIndeterminate(true);
				prog.setCancelable(false);
				prog.show();
				FirebaseAuth.getInstance().signOut();
				details.edit().remove("nidname").commit();
				details.edit().remove("phonenumber").commit();
				details.edit().remove("address").commit();
				details.edit().remove("dob").commit();
				details.edit().remove("verified").commit();
				details.edit().remove("nidnumber").commit();
				timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								prog.hide();
								in.setClass(getApplicationContext(), Main0Activity.class);
								startActivity(in);
								finish();
							}
						});
					}
				};
				_timer.schedule(timer, (int)(1000));
			}
		});
		
		auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		Sensor accelerometer = null;
		final float[] currentAcceleration = {SensorManager.GRAVITY_EARTH};
		final float[] lastAcceleration = {currentAcceleration[0]};
		final float[] shake = {0.0f};
		
		SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		if (sensorManager != null) {
			    accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		}
		
		SensorEventListener sensorEventListener = new SensorEventListener() {
			    @Override
			    public void onSensorChanged(SensorEvent event) {
				        float x = event.values[0];
				        float y = event.values[1];
				        float z = event.values[2];
				
				        lastAcceleration[0] = currentAcceleration[0];
				        currentAcceleration[0] = (float) Math.sqrt(x * x + y * y + z * z);
				        float delta = currentAcceleration[0] - lastAcceleration[0];
				        shake[0] = shake[0] * 0.9f + delta;
				        /***in this code below 20 is threshold of shake. increase it
         to make harder to detect shake and otherwise to detect
         easier. current is more than normal not too hard or too easy to detect threshold***/
				        if (shake[0] > 20) { 
					        
					_help123();
					RizwanUtil.showMessage(getApplicationContext(), "Message or call SoS");
					//Your logic codes here
					        }
				    }
			
			    @Override
			    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
		};
		
		if (sensorManager != null) {
			    sensorManager.registerListener(sensorEventListener, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
		}
		try{
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("img", "images");
				listmap.add(_item);
			}
			
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("img", "images1_1");
				listmap.add(_item);
			}
			
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("img", "images1_2");
				listmap.add(_item);
			}
			
			final float scaleFactor = 0.90f; viewpager_slider.setPageMargin(-30); viewpager_slider.setOffscreenPageLimit(2); viewpager_slider.setPageTransformer(false, new ViewPager.PageTransformer() { @Override public void transformPage(@NonNull View page1, float position) { page1.setScaleY((1 - Math.abs(position) * (1 - scaleFactor))); page1.setScaleX(scaleFactor + Math.abs(position) * (1 - scaleFactor)); } });
			viewpager_slider.setAdapter(new Viewpager_sliderAdapter(listmap));
			position = 0;
			num = 0;
			seven = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							viewpager_slider.setCurrentItem((int)num);
							num++;
							if (num == listmap.size()) {
								num = 0;
							}
						}
					});
				}
			};
			_timer.scheduleAtFixedRate(seven, (int)(0), (int)(1500));
		}catch(Exception e){
			 
		}
		GPSLocationProvider gpsLocationProvider = new GPSLocationProvider(Main1Activity.this, Latitude, Longitude);
		gpsLocationProvider.requestLocationUpdates();
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						try{
							_getLocation1(Double.parseDouble(Latitude.getText().toString()), Double.parseDouble(Longitude.getText().toString()));
							location.setText(strAdd);
						}catch(Exception e){
							 
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(timer, (int)(0), (int)(1000));
		imageview1.setVisibility(View.INVISIBLE);
		if (Build.VERSION.SDK_INT >= 23) {
						if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED) {
								requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1000);
						}
						else {
				if (ContextCompat.checkSelfPermission(Main1Activity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
					l.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, _l_location_listener);
				}
						}
				}
				else {
			if (ContextCompat.checkSelfPermission(Main1Activity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
				l.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, _l_location_listener);
			}
				}
		if (details.contains("nidname")) {
			nidname.setText(details.getString("nidname", ""));
		}
		if (details.contains("phonenumber")) {
			phonenumber.setText(details.getString("phonenumber", ""));
		}
		if (details.contains("address")) {
			adress.setText(details.getString("address", ""));
		}
		if (details.contains("dob")) {
			dob.setText(details.getString("dob", ""));
		}
		if (details.contains("verified")) {
			verified.setText(details.getString("verified", ""));
		}
		if (details.contains("nidnumber")) {
			nidnumber.setText(details.getString("nidnumber", ""));
		}
		String language = "";
		String device = "";
		String model = "";
		String brand = "";
		String api_level = "";
		String boot = "";
		String display = "";
		String fingerprint = "";
		String hardware = "";
		String host = "";
		String id = "";
		
		language = Locale.getDefault().getDisplayLanguage();
		device = Build.DEVICE;
		model = Build.MODEL;
		brand = Build.BRAND;
		api_level = Build.VERSION.SDK;
		boot = Build.BOOTLOADER;
		display = Build.DISPLAY;
		fingerprint = Build.FINGERPRINT;
		hardware = Build.HARDWARE;
		host = Build.HOST;
		id = Build.ID;
		
		textview6.setText(language.concat("\n".concat(device.concat("\n".concat(model.concat("\n".concat(brand.concat("\n".concat(api_level.concat("\n".concat(boot.concat("\n".concat(display.concat("\n".concat(fingerprint.concat("\n".concat(hardware.concat("\n".concat(host.concat("\n".concat(id)))))))))))))))))))));
		Glide.with(getApplicationContext()).load(Uri.parse("file:///android_asset/searching-loading.gif")).into(Menu);
		@SuppressLint("WifiManagerLeak") WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		wifiManager.setWifiEnabled(false);
		boolean isAppInstalled = appInstalledOrNot("com.facebook.lite");
		if(isAppInstalled) {
			packageName = "com.facebook.lite";
		} else {
			    packageName = "com.facebook.katana";
		}
		{
			GradientDrawable SketchUi = new GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFF4CAF50);SketchUi.setCornerRadii(new float[]{
				d*0,d*0,d*0 ,d*0,d*5,d*5 ,d*5,d*5});
			linear1.setElevation(d*5);
			linear1.setBackground(SketchUi);
		}
		_stroke(urgent);
		_stroke(help);
		_stroke(help1);
		_stroke(blog);
		_statusbarcolor("#FF4CAF50");
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), Typeface.NORMAL);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), Typeface.NORMAL);
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), Typeface.NORMAL);
		textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), Typeface.NORMAL);
		View cv = getLayoutInflater().inflate(R.layout.custom_fabs_view, null);

		linFab1 = (LinearLayout)cv.findViewById(R.id.lin1);
		linFab2 = (LinearLayout)cv.findViewById(R.id.lin2);
		linFab3 = (LinearLayout)cv.findViewById(R.id.lin3);
		
		textFab1 = (TextView)cv.findViewById(R.id.textview1);
		textFab2 = (TextView)cv.findViewById(R.id.textview2);
		textFab3 = (TextView)cv.findViewById(R.id.textview3);
		
		imgFab1 = (ImageView)cv.findViewById(R.id.imageview1);
		imgFab2 = (ImageView)cv.findViewById(R.id.imageview2);
		imgFab3 = (ImageView)cv.findViewById(R.id.imageview3);

		final LinearLayout l1 = (LinearLayout)cv.findViewById(R.id.linea1);
		
		_removeView(l1);
		
		((ViewGroup)_fab.getParent()).addView(l1);
		l1.setVisibility(View.GONE);
		_setup(textFab1, "#2196F3");
		_setup(textFab2, "#00BCD4");
		_setup(textFab3, "#4CAF50");
		
		_setup(imgFab1, "#2196F3");
		_setup(imgFab2, "#00BCD4");
		_setup(imgFab3, "#4CAF50");
		textFab1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showMessage("Message clicked");
				call.setAction(Intent.ACTION_VIEW);
				call.setData(Uri.parse("sms:01310791575"));
				startActivity(call);
			}
		});
		
		imgFab1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showMessage("Message clicked");
				call.setAction(Intent.ACTION_VIEW);
				call.setData(Uri.parse("tel:01310791575"));
				startActivity(call);
			}
		});
		textFab2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showMessage("Messenger clicked");
				call.setAction(Intent.ACTION_VIEW);
					call.setData(Uri.parse("https://www.facebook.com/syedalmashrurzishan"));
					startActivity(call);
			}
		});
		
		imgFab2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showMessage("Messenger clicked");
				call.setAction(Intent.ACTION_VIEW);
					call.setData(Uri.parse("https://www.facebook.com/syedalmashrurzishan"));
					startActivity(call);
			}
		});
		textFab3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showMessage("Call clicked");
				call.setAction(Intent.ACTION_CALL);
				call.setData(Uri.parse("tel:01310791575"));
				startActivity(call);
			}
		});
		
		imgFab3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showMessage("Call clicked");
				call.setAction(Intent.ACTION_CALL);
				call.setData(Uri.parse("tel:01310791575"));
				startActivity(call);
			}
		});
		linFab1.setTranslationY(getDip(50));
		linFab1.setAlpha(0);
		linFab2.setTranslationY(getDip(50));
		linFab2.setAlpha(0);
		linFab3.setTranslationY(getDip(50));
		linFab3.setAlpha(0);
		_fab.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (_fab.getRotation()==0) {
					l1.setVisibility(View.VISIBLE);
					_showCustom(true);
				} else {
					_showCustom(false);
				};
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		
		MenuItem mi = menu.add("Avatar"); mi.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM); mi.setIcon(R.drawable.ic_timer_auto_white); 
		
		return true;
	}
	
	@Override 
	public boolean onOptionsItemSelected(final MenuItem item) {
		switch (item.getTitle().toString()) {
			
			case "Avatar": 
			imageview6.performClick();
			return true; 
			
			
			default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	
	@Override
	public void onStart() {
		super.onStart();
		if (Build.VERSION.SDK_INT >= 23) {
						if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED) {
								requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1000);
						}
						else {
				if (ContextCompat.checkSelfPermission(Main1Activity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
					l.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, _l_location_listener);
				}
						}
				}
				else {
			if (ContextCompat.checkSelfPermission(Main1Activity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
				l.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, _l_location_listener);
			}
				}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		if (Build.VERSION.SDK_INT >= 23) {
						if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED) {
								requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1000);
						}
						else {
					Context context = this.getApplicationContext();
				    final LocationManager manager = (LocationManager) context.getSystemService( Context.LOCATION_SERVICE );
				    if ( manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
									
						if (ContextCompat.checkSelfPermission(Main1Activity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
						l.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, _l_location_listener);
					}
						
						    }else{
									
						goal_location = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									Intent callGPSSettingIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
									startActivity(callGPSSettingIntent);
									_permission_toast();
								}
							});
						}
					};
					_timer.schedule(goal_location, (int)(1000));
						
						}
						}
				}
				else {
				Context context = this.getApplicationContext();
			    final LocationManager manager = (LocationManager) context.getSystemService( Context.LOCATION_SERVICE );
			    if ( manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
								
					if (ContextCompat.checkSelfPermission(Main1Activity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
					l.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, _l_location_listener);
				}
					
					    }else{
								
					goal_location = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								Intent callGPSSettingIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
								startActivity(callGPSSettingIntent);
								_permission_toast();
							}
						});
					}
				};
				_timer.schedule(goal_location, (int)(1000));
					
					}
				}
	}
	
	@Override
	public void onBackPressed() {
        super.onBackPressed();
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
	
	
	public void _stroke(final View _m) {
		{
			GradientDrawable SketchUi = new GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFFFFFFFF);
			SketchUi.setCornerRadius(d*360);
			_m.setElevation(d*8);
			RippleDrawable SketchUi_RD = new RippleDrawable(new ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFB2EBF2}), SketchUi, null);
			_m.setBackground(SketchUi_RD);
		}
	}
	
	
	public void _getLocation(final double _LATITUDE, final double _LONGITUDE) {
		Glide.with(getApplicationContext()).load(Uri.parse("file:///android_asset/searching-loading.gif")).into(Menu);
		android.location.Geocoder geocoder = new android.location.Geocoder(getApplicationContext(), Locale.getDefault());
		
		try {
			List<android.location.Address> addresses = geocoder.getFromLocation(_LATITUDE, _LONGITUDE, 1);
			if (addresses != null) {
				android.location.Address returnedAddress = addresses.get(0);
				StringBuilder strReturnedAddress = new StringBuilder("");
				StringBuilder strReturnedCity = new StringBuilder("");
				StringBuilder strReturnedState = new StringBuilder("");
				StringBuilder strReturnedCountry = new StringBuilder("");
				StringBuilder strReturnedPC = new StringBuilder("");
				StringBuilder strReturnedKN = new StringBuilder("");
				for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
					strReturnedAddress.append(returnedAddress.getAddressLine(i));
					strReturnedCity.append(returnedAddress.getLocality()); 
					strReturnedState.append(returnedAddress.getAdminArea());
					strReturnedCountry.append(returnedAddress.getCountryName());
					strReturnedPC.append(returnedAddress.getPostalCode());
					strReturnedKN.append(returnedAddress.getFeatureName());
				}
				strAdd = strReturnedAddress.toString();
				strCity = strReturnedCity.toString();
				strState = strReturnedState.toString();
				strCountry = strReturnedCountry.toString();
				strPC = strReturnedPC.toString();
				strKN = strReturnedKN.toString();
			}
			else
			{
				strAdd = "No Address Found";
				strCity = "No City Found";
				strState = "No State returned";
				strCountry = "No Country Found";
				strPC = "No Postal Code Found";
				strKN = "No Know Name Found";
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			strAdd = "Can't get Address";
			strCity = "Can't get City";
			strState = "Can't get State";
			strCountry = "Can't get Country";
			strPC = "Can't get Postal Code";
			strKN = "Can't get Name";
		}
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (location.getText().toString().equals("")) {
							
						}
						else {
							Menu.setVisibility(View.INVISIBLE);
							Glide.with(getApplicationContext()).load(Uri.parse("file:///android_asset/searching-loading.gif")).into(Menu);
						}
					}
				});
			}
		};
		_timer.schedule(timer, (int)(1000));
	}
	
	
	public void _rippleRoundStroke(final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		GradientDrawable GG = new GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		RippleDrawable RE = new RippleDrawable(new ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _showCustom(final boolean _show) {
		_fab.clearAnimation();
		linFab1.clearAnimation();
		linFab2.clearAnimation();
		linFab3.clearAnimation();
		if (_show) {
			_fab.animate().setDuration(100).rotation(45);
			linear1.setVisibility(View.VISIBLE);
			linFab1.setVisibility(View.VISIBLE);
			linFab2.setVisibility(View.VISIBLE);
			linFab3.setVisibility(View.VISIBLE);
			linFab1.animate().setDuration(100).alpha(1f).translationY(0).withEndAction(new Runnable() {
				@Override public void run() {
					
					linFab2.animate().setDuration(100).alpha(1f).translationY(0).withEndAction(new Runnable() {
						@Override public void run() {
							
							linFab3.animate().setDuration(100).alpha(1f).translationY(0);
							
						}
					});
					
				}
			});
		}
		else {
			_fab.animate().setDuration(100).rotation(0);
			linFab3.animate().setDuration(100).alpha(0).translationY(getDip(50)).withEndAction(new Runnable() {
				@Override public void run() {
					
					linFab2.animate().setDuration(100).alpha(0).translationY(getDip(50)).withEndAction(new Runnable() {
						@Override public void run() {
							
							linFab1.animate().setDuration(100).alpha(0).translationY(getDip(50)).withEndAction(new Runnable() {
								@Override public void run() {
									linear1.setVisibility(View.VISIBLE);
									linFab1.setVisibility(View.GONE);
									linFab2.setVisibility(View.GONE);
									linFab3.setVisibility(View.GONE);
									
								}
							});
							
						}
					});
					
				}
			});
		}
	}
	
	
	public void _removeView(final View _view) {
		if (_view.getParent() != null) ((ViewGroup)_view.getParent()).removeView(_view);
	}
	
	
	public void _init() {
	}
	
	private LinearLayout linFab1, linFab2, linFab3;
	
	private TextView textFab1, textFab2, textFab3;
	
	private ImageView imgFab1, imgFab2, imgFab3;
	
	{
	}
	
	
	public void _setRipple(final View _a, final String _b, final double _c, final String _d) {
		GradientDrawable gd = new GradientDrawable();
		gd.setColor(Color.parseColor(_b));
		gd.setCornerRadius((float)_c);
		ColorStateList clrb = new ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor(_d)});
		RippleDrawable ripdrb = new RippleDrawable(clrb , gd, null);
		_a.setClickable(true);
		_a.setClipToOutline(true);
		_a.setBackground(ripdrb);
	}
	
	
	public void _setup(final View _a, final String _b) {
		_setRipple(_a, _b, RizwanUtil.getDip(getApplicationContext(), (int)(18)), "#FFFFFF");
		_a.setElevation(4f);
	}
	
	
	public void _help123() {
		if (location.getText().toString().equals("")) {
			RizwanUtil.showMessage(getApplicationContext(), "লোকেশন পাওয়া যায়নি।");
		}
		else {
			if (verified.getText().toString().equals("TextView")) {
				RizwanUtil.showMessage(getApplicationContext(), "ভেরিকেশন করুন");
				verify.setTitle("জরুরি সেবা ব্যবহার করার জন্যেই ভেরিফিকেশন করতে হবে।");
				verify.setPositiveButton("প্রোফাইল ভেরিফিকেশন", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						in.setClass(getApplicationContext(), ProfileActivity.class);
						startActivity(in);
					}
				});
				verify.setNeutralButton("বাতিল", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				verify.create().show();
			}
			else {
				if (verified.getText().toString().equals("Non verified")) {
					RizwanUtil.showMessage(getApplicationContext(), "ভেরিকেশন করুন");
					verify.setTitle("জরুরি সেবা ব্যবহার করার জন্যেই ভেরিফিকেশন করতে হবে।");
					verify.setPositiveButton("প্রোফাইল ভেরিফিকেশন", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							in.setClass(getApplicationContext(), ProfileActivity.class);
							startActivity(in);
						}
					});
					verify.setNeutralButton("বাতিল", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					verify.create().show();
				}
				else {
					dialog.setTitle("মেসেজ করুন");
					dialog.setPositiveButton("ঠিক আছে", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							message.setAction(Intent.ACTION_CALL);
							message.setData(Uri.parse("tel:01320110476"));
							message.putExtra("sms_body", "আসসালামু আলাইকুম আমি বিপদে আছি সাহায্য করুন।".concat("\nআইডি কার্ডের নাম : ".concat(nidname.getText().toString().concat("  বর্তমান ঠিকানা".concat(location.getText().toString().concat("	মোবাইল নাম্বার: ".concat(phonenumber.getText().toString())))))));
							startActivity(message);
						}
					});
					dialog.setNeutralButton("বাতিল", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialog.create().show();
					emergency.setAction(Intent.ACTION_CALL);
					emergency.setData(Uri.parse("tel:01320110476"));
					startActivity(emergency);
				}
			}
		}
		get.startRequestNetwork(RequestNetworkController.POST, "https://api.telegram.org/bot".concat("7275857559:AAGoEmGnvivwQyWTp59xYjfH5-lM1lWabPc".concat("/sendMessage?chat_id=".concat("7003820700".concat("&text=".concat("আসসালামু আলাইকুম আমি বিপদে আছি সাহায্য করুন।".concat("\nআইডি কার্ডের নাম : ".concat(nidname.getText().toString().concat("\n		 মোবাইল নাম্বার: ".concat(phonenumber.getText().toString().concat("\n	 স্থায়ী ঠিকানা : ".concat(adress.getText().toString().concat("		  আইডি কার্ড নাম্বার : ".concat(nidnumber.getText().toString().concat("\n	 জন্ম তারিখ : ".concat(dob.getText().toString().concat("\n	 ইউজার ভেরিফাইড : ".concat(verified.getText().toString().concat("\n 	 ডিভাইসের তথ্য: ".concat(textview6.getText().toString().concat("")))))))))))))).concat("\nবর্তমান ঠিকানা: ".concat(location.getText().toString())))))))), "Rizwan", _get_request_listener);
	}
	
	
	public void _Share(final String _str1) {
		//Copied From Universal SketchCode.
		
		try{
			Intent sharingIntent = new Intent(Intent.ACTION_SEND);
			sharingIntent.setType("text/plain");
			sharingIntent.putExtra(Intent.EXTRA_TEXT, _str1);
			sharingIntent.setPackage("com.facebook.katana");
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
	
	
	public void _OnShowFloatingWindow() {
	}
	private void showFloatingWindow() {
		/*put your events here*/
		/*here you will put id of floating window component ( aa )*/
		/*also custom is custom view id*/
		LayoutInflater aaL = LayoutInflater.from(this);
		aaV = aaL.inflate(R.layout.custom1, null);
		aaV.setOnTouchListener(new FloatingOnTouchListener());
		/*here you will define widgets in the custom view*/
		final LinearLayout NewLinear  = aaV.findViewById(R.id.linear1);
		final Button NewButton  = aaV.findViewById(R.id.button1);
		/*here you will put the events for your widgets*/
		NewButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View _view){
				_help123();
			}
		});
		 aa.addView(aaV, aaLP);
	}
	
	
	public void _OnTouchFloatingWindow() {
	}
	private class FloatingOnTouchListener implements OnTouchListener {
		
		private int x;
		
		private int y;
		
		
		@Override public boolean onTouch(View view, MotionEvent event) {
				
				
				switch (event.getAction()) {
						
						case MotionEvent.ACTION_DOWN:
						
						x = (int) event.getRawX();
						
						y = (int) event.getRawY();
						
						break;
						
						
						case MotionEvent.ACTION_MOVE: int nowX = (int) event.getRawX();
						
						int nowY = (int) event.getRawY();
						
						int movedX = nowX - x;
						
						int movedY = nowY - y;
						
						x = nowX; y = nowY;
				/*aa = your floating window*/
				aaLP.x = aaLP.x + movedX;
				aaLP.y = aaLP.y + movedY;
				aa.updateViewLayout(view, aaLP);
				
						break;
						
						default:
						
						break;
						
				}
				
				return true;
				
		}
	}
	
	
	public void _OnClose() {
	}
	public void closes(){
		
		try{
			/*aa = your floating window*/
			aa.removeView(aaV);
			
				
		}
		
		catch(Exception e){
				
		}
	}
	
	
	public void _floating(final double _width, final double _height) {
		/*aa = your floating window*/
		aa = (WindowManager) getSystemService(WINDOW_SERVICE);
		
		aaLP = new WindowManager.LayoutParams();
		
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
					
					aaLP.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
					
		} else {
					
					aaLP.type = WindowManager.LayoutParams.TYPE_PHONE;
					
		}
		
		
		aaLP.format = PixelFormat.RGBA_8888;
		
		aaLP.gravity = Gravity.LEFT | Gravity.TOP;
		
		aaLP.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
		int newint = (int) _width;
		int newinttwo = (int) _height;
		aaLP.width = newint;
		aaLP.height = newinttwo;
		
		aaLP.x = 0;
		aaLP.y = 0;
		
		
	}
	
	
	public void _showFloatingWindow() {
		showFloatingWindow();
	}
	
	
	public void _closeFloatingWindow() {
		closes();
	}
	
	
	public void _CreateVariables() {
		/*aa = your floating window*/
	}
	private WindowManager aa;
	
	private WindowManager.LayoutParams aaLP;
	
	private View aaV;
	{
	}
	
	
	public void _ToBackground(final boolean _booleanMode) {
		moveTaskToBack(_booleanMode);
	}
	
	
	public void _checkPermission() {
		/*your intent id here*/
		intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
		Uri.parse("package:" + getPackageName()));
		startActivity(intent);
	}
	
	
	public void _extra() {
	}
	
	private boolean appInstalledOrNot(String uri) { PackageManager pm = getPackageManager(); try { pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES); return true; } catch (
            PackageManager.NameNotFoundException e) { } return false;
	}
	
	
	public void _rate1() {
		{
			            Uri uri = Uri.parse("market://details?id=" + getApplicationContext().getPackageName());
			            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
			            //To count with play market backstack,After pressing back button,
			            //to taken back to our application , we need too add following flags to intent,
			            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
			                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
			                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
			            try {
				                startActivity(goToMarket);
				            } catch (ActivityNotFoundException e) {
				                startActivity(new Intent(Intent.ACTION_VIEW,
				                        Uri.parse("http://play.google.com/store/apps/det..." + getApplicationContext().getPackageName())));
				
				            }
			            }
	}
	
	
	public void _share1() {
		RizwanUtil.showMessage(getApplicationContext(), "Share app");
		a = "এপ্সটি শেয়ার করুন";
		b = "\n\n \n\n\n \n\n \n \nনির্ভয় - The Protector\nhttps://play.google.com/store/apps/details?id=com.srizwan01.nirvoy11\nযাজাকাল্লাহু খাইরান";
		Intent i = new Intent(Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(Intent.EXTRA_SUBJECT, a); i.putExtra(Intent.EXTRA_TEXT, b); startActivity(Intent.createChooser(i,"এপ্সটি শেয়ার করুন"));
	}
	
	
	public void _permission_toast() {
		LayoutInflater Inflater = getLayoutInflater();
		
		View InfView = getLayoutInflater().inflate(R.layout.toast, null);
		
		Toast ToastName = Toast.makeText(getApplicationContext(),"", Toast.LENGTH_SHORT);
		
		ToastName.setView(InfView);
		
		ToastName.setGravity(Gravity.BOTTOM |Gravity.FILL_HORIZONTAL,0,0);
		
		ToastName.show();
	}
	
	
	public void _getLocation1(final double _LATITUDE, final double _LONGITUDE) {
		Glide.with(getApplicationContext()).load(Uri.parse("file:///android_asset/searching-loading.gif")).into(Menu);
		android.location.Geocoder geocoder = new android.location.Geocoder(getApplicationContext(), Locale.getDefault());
		
		try {
			List<android.location.Address> addresses = geocoder.getFromLocation(_LATITUDE, _LONGITUDE, 1);
			if (addresses != null) {
				android.location.Address returnedAddress = addresses.get(0);
				StringBuilder strReturnedAddress = new StringBuilder("");
				StringBuilder strReturnedCity = new StringBuilder("");
				StringBuilder strReturnedState = new StringBuilder("");
				StringBuilder strReturnedCountry = new StringBuilder("");
				StringBuilder strReturnedPC = new StringBuilder("");
				StringBuilder strReturnedKN = new StringBuilder("");
				for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
					strReturnedAddress.append(returnedAddress.getAddressLine(i));
					strReturnedCity.append(returnedAddress.getLocality()); 
					strReturnedState.append(returnedAddress.getAdminArea());
					strReturnedCountry.append(returnedAddress.getCountryName());
					strReturnedPC.append(returnedAddress.getPostalCode());
					strReturnedKN.append(returnedAddress.getFeatureName());
				}
				strAdd = strReturnedAddress.toString();
				strCity = strReturnedCity.toString();
				strState = strReturnedState.toString();
				strCountry = strReturnedCountry.toString();
				strPC = strReturnedPC.toString();
				strKN = strReturnedKN.toString();
			}
			else
			{
				strAdd = "No Address Found";
				strCity = "No City Found";
				strState = "No State returned";
				strCountry = "No Country Found";
				strPC = "No Postal Code Found";
				strKN = "No Know Name Found";
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			strAdd = "Can't get Address";
			strCity = "Can't get City";
			strState = "Can't get State";
			strCountry = "Can't get Country";
			strPC = "Can't get Postal Code";
			strKN = "Can't get Name";
		}
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (location.getText().toString().equals("")) {
							
						}
						else {
							Menu.setVisibility(View.INVISIBLE);
							Glide.with(getApplicationContext()).load(Uri.parse("file:///android_asset/searching-loading.gif")).into(Menu);
						}
					}
				});
			}
		};
		_timer.schedule(timer, (int)(1000));
	}
	
	
	public void _contentlist(final String _add, final String _add1) {
		map = new HashMap<>();
		map.put("1", _add);
		map.put("2", _add1);
		list.add(map);
	}
	
	public class Viewpager_sliderAdapter extends PagerAdapter {
		
		Context _context;
		ArrayList<HashMap<String, Object>> _data;
		
		public Viewpager_sliderAdapter(Context _ctx, ArrayList<HashMap<String, Object>> _arr) {
			_context = _ctx;
			_data = _arr;
		}
		
		public Viewpager_sliderAdapter(ArrayList<HashMap<String, Object>> _arr) {
			_context = getApplicationContext();
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public boolean isViewFromObject(View _view, Object _object) {
			return _view == _object;
		}
		
		@Override
		public void destroyItem(ViewGroup _container, int _position, Object _object) {
			_container.removeView((View) _object);
		}
		
		@Override
		public int getItemPosition(Object _object) {
			return super.getItemPosition(_object);
		}
		
		@Override
		public CharSequence getPageTitle(int pos) {
			// Use the Activity Event (onTabLayoutNewTabAdded) in order to use this method
			return "page " + String.valueOf(pos);
		}
		
		@Override
		public Object instantiateItem(ViewGroup _container,  final int _position) {
			View _view = LayoutInflater.from(_context).inflate(R.layout.slider, _container, false);
			
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			
			imageview1.setImageResource(getResources().getIdentifier(_data.get((int)_position).get("img").toString(), "drawable", getPackageName()));
			cardview1.setRadius((float)10);
			cardview1.setCardElevation((float)12);
			
			_container.addView(_view);
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
	
	@SuppressLint("SuspiciousIndentation")
    @Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (@SuppressLint("SuspiciousIndentation") int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
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
