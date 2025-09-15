package com.srizwan01.nirvoy11;



import android.Manifest;

import android.annotation.SuppressLint;
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

import android.net.*;

import android.net.Uri;

import android.os.*;

import android.os.Bundle;

import android.text.*;

import android.text.Editable;

import android.text.TextWatcher;

import android.util.*;

import android.view.*;

import android.view.View;

import android.view.View.*;

import android.view.animation.*;

import android.webkit.*;

import android.widget.*;

import android.widget.BaseAdapter;

import android.widget.EditText;

import android.widget.ImageView;

import android.widget.LinearLayout;

import android.widget.ListView;

import android.widget.ProgressBar;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.app.ActivityCompat;

import androidx.core.content.ContextCompat;

import androidx.viewpager.widget.PagerAdapter;

import androidx.viewpager.widget.ViewPager;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

import com.bumptech.glide.Glide;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.google.firebase.FirebaseApp;

import com.google.firebase.database.ChildEventListener;

import com.google.firebase.database.DataSnapshot;

import com.google.firebase.database.DatabaseError;

import com.google.firebase.database.DatabaseReference;

import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.GenericTypeIndicator;

import com.google.firebase.database.ValueEventListener;

import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;

import java.text.*;

import java.util.*;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.Timer;

import java.util.TimerTask;

import java.util.regex.*;

import org.json.*;

import android.text.method.LinkMovementMethod;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;



public class BlogonlineActivity extends AppCompatActivity {

	

	public final int REQ_CD_PDF = 101;

	

	private Timer _timer = new Timer();

	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();

	

	private FloatingActionButton _fab;

	private String rawdata = "";

	private double ki = 0;

	private String di = "";

	private String daydates = "";

	private HashMap<String, Object> converted = new HashMap<>();

	private String finedimage = "";

	private String post = "";

	private String ptitle = "";

	private String userimage = "";

	private String postcat = "";

	private String username = "";

	private String alldata = "";

	private String error = "";

	private double length = 0;

	private double r = 0;

	private String value1 = "";

	private boolean searchbar_enabled = false;

	private HashMap<String, Object> blogfa = new HashMap<>();

	private String blogger_id = "";

	private String blogger_gen = "";

	private String fontName = "";

	private String typeace = "";

	private HashMap<String, Object> save = new HashMap<>();

	private String savek = "";

	private HashMap<String, Object> map = new HashMap<>();

	private String subtitle = "";

	private String Folder = "";

	private double position = 0;

	private double files_count = 0;

	private double load = 0;

	private String url = "";

	private String pagetoken = "";

	private boolean flag = false;

	private String htmlurl = "";

	private String html = "";

	private double clicklist = 0;

	private String newName = "";

	private double click = 0;

	private String a = "";

	private String b = "";

	private String copyshare = "";

	private double get = 0;
	private InterstitialAd mInterstitialAd;
	private AdView adView;
	

	private ArrayList<HashMap<String, Object>> shut = new ArrayList<>();

	private ArrayList<String> allraw = new ArrayList<>();

	private ArrayList<HashMap<String, Object>> readypost = new ArrayList<>();

	private ArrayList<HashMap<String, Object>> save1 = new ArrayList<>();

	private ArrayList<String> liststring = new ArrayList<>();

	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();

	private ArrayList<String> files = new ArrayList<>();

	private ArrayList<HashMap<String, Object>> mapl = new ArrayList<>();

	private ArrayList<HashMap<String, Object>> listMap = new ArrayList<>();

	private ArrayList<HashMap<String, Object>> mappp = new ArrayList<>();

	

	private LinearLayout linear1;

	private ImageView imageview3;

	private LinearLayout toolbar;

	private LinearLayout searchbar;

	private ViewPager viewpager1;

	private ListView listview1;

	private LinearLayout linear10;

	private ImageView btn_search;

	private LinearLayout linear6;

	private TextView content;

	private LinearLayout pagenumberbox;

	private LinearLayout linear7;

	private LinearLayout linear8;

	private LinearLayout linear9;

	private TextView textview2;

	private TextView page;

	private TextView pagenumber;

	private ImageView imageview2;

	private ImageView imageview4;

	private ImageView imageview5;

	private ImageView btn_back;

	private EditText edittext1;

	private ImageView btn_clear;

	private ProgressBar progressbar1;

	

	private RequestNetwork ra;

	private RequestNetwork.RequestListener _ra_request_listener;

	private AlertDialog.Builder d;

	private Intent i = new Intent();

	private TimerTask timer;

	private TimerTask ta;

	private TimerTask scroll;

	private Intent in = new Intent();

	private RequestNetwork ib;

	private RequestNetwork.RequestListener _ib_request_listener;

	private SharedPreferences on;

	private Intent pdf = new Intent(Intent.ACTION_GET_CONTENT);

	private Intent intent = new Intent();

	private Intent actua = new Intent();

	private SharedPreferences data;

	private TimerTask t;

	private AlertDialog.Builder renameDialog;

	private DatabaseReference blog = _firebase.getReference("blog");

	private ChildEventListener _blog_child_listener;

	

	@Override

	protected void onCreate(Bundle _savedInstanceState) {

		super.onCreate(_savedInstanceState);

		setContentView(R.layout.blogonline);

		initialize(_savedInstanceState);

		FirebaseApp.initializeApp(this);

		

		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED

		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {

			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);

		} else {
			// Initialize Mobile Ads SDK
			MobileAds.initialize(this, initializationStatus -> {});

			// Load the Interstitial Ad
			loadInterstitialAd();

			// Load the Banner Ad
			adView = findViewById(R.id.adView);
			AdRequest adRequest = new AdRequest.Builder().build();
			adView.loadAd(adRequest);

			// Set up AdListener for Banner Ad
			adView.setAdListener(new AdListener() {
				@Override
				public void onAdLoaded() {
					Log.d("AdMob", "Banner Ad loaded successfully.");
				}

				@Override
				public void onAdFailedToLoad(LoadAdError adError) {
					Log.d("AdMob", "Banner Ad failed to load: " + adError.getMessage());
				}
			});

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

	private void loadInterstitialAd() {
		InterstitialAd.load(this, "ca-app-pub-6399302951865878/4911640850", new AdRequest.Builder().build(),
				new InterstitialAdLoadCallback() {
					@Override
					public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
						mInterstitialAd = interstitialAd;
					}

					@Override
					public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
						Log.i("AdMob", loadAdError.getMessage());
						mInterstitialAd = null;
					}
				});
	}

	private void initialize(Bundle _savedInstanceState) {

		_fab = findViewById(R.id._fab);

		

		linear1 = findViewById(R.id.linear1);

		imageview3 = findViewById(R.id.imageview3);

		toolbar = findViewById(R.id.toolbar);

		searchbar = findViewById(R.id.searchbar);

		viewpager1 = findViewById(R.id.viewpager1);

		listview1 = findViewById(R.id.listview1);

		linear10 = findViewById(R.id.linear10);

		btn_search = findViewById(R.id.btn_search);

		linear6 = findViewById(R.id.linear6);

		content = findViewById(R.id.content);

		pagenumberbox = findViewById(R.id.pagenumberbox);

		linear7 = findViewById(R.id.linear7);

		linear8 = findViewById(R.id.linear8);

		linear9 = findViewById(R.id.linear9);

		textview2 = findViewById(R.id.textview2);

		page = findViewById(R.id.page);

		pagenumber = findViewById(R.id.pagenumber);

		imageview2 = findViewById(R.id.imageview2);

		imageview4 = findViewById(R.id.imageview4);

		imageview5 = findViewById(R.id.imageview5);

		btn_back = findViewById(R.id.btn_back);

		edittext1 = findViewById(R.id.edittext1);

		btn_clear = findViewById(R.id.btn_clear);

		progressbar1 = findViewById(R.id.progressbar1);

		ra = new RequestNetwork(this);

		d = new AlertDialog.Builder(this);

		ib = new RequestNetwork(this);

		on = getSharedPreferences("on", Activity.MODE_PRIVATE);

		pdf.setType("*/*");

		pdf.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);

		data = getSharedPreferences("data", Activity.MODE_PRIVATE);

		renameDialog = new AlertDialog.Builder(this);

		

		viewpager1.addOnPageChangeListener(new OnPageChangeListener() {

			@Override

			public void onPageScrolled(int _position, float _positionOffset, int _positionOffsetPixels) {

				

			}

			

			@Override

			public void onPageSelected(int _position) {

				page.setText(_replaceArabicNumber(String.valueOf((long)(_position))));

				pagenumber.setText(_replaceArabicNumber(" / ".concat(String.valueOf((long)(1 - readypost.size())))));

			}

			

			@Override

			public void onPageScrollStateChanged(int _scrollState) {

				

			}

		});

		

		listview1.setOnScrollListener(new AbsListView.OnScrollListener() {

			@Override

			public void onScrollStateChanged(AbsListView abs, int _scrollState) {

				

			}

			

			@Override

			public void onScroll(AbsListView abs, int _firstVisibleItem, int _visibleItemCount, int _totalItemCount) {

				

			}

		});

		

		btn_search.setOnClickListener(new OnClickListener() {

			@Override

			public void onClick(View _view) {

				_btn_search1();

			}

		});

		

		linear6.setOnClickListener(new OnClickListener() {

			@Override

			public void onClick(View _view) {

				

			}

		});

		

		pagenumberbox.setOnClickListener(new OnClickListener() {

			@Override

			public void onClick(View _view) {

				renameDialog.setTitle("Go to page");

				renameDialog.setMessage("সম্মানিত ইউজার নির্দিষ্ট পেইজে যাওয়ার জন্য আপনি যে পৃষ্ঠায় যেতে চাচ্ছেন সেই পৃষ্ঠার ১ সংখ্যা কম লিখুন যেমন আপনি যেতে চাচ্ছেন ১০ নম্বর পেইজে লিখতে হবে ৯ নং পেইজ");

				LinearLayout layout = new LinearLayout(BlogonlineActivity.this);
				layout.setOrientation(LinearLayout.VERTICAL);
				
				LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT); 

				final EditText edittxt3 = new EditText(BlogonlineActivity.this);
				edittxt3.setHint("Enter page number");
				edittxt3.setInputType(InputType.TYPE_CLASS_NUMBER);
				edittxt3.setLayoutParams(lp);
				edittxt3.setElevation(6f);
				layout.addView(edittxt3);
				renameDialog.setView(layout);

				renameDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						RizwanUtil.hideKeyboard(getApplicationContext());
					}
				});

				renameDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						newName = edittxt3.getText().toString();

						if (_REPLACE(newName).equals("") || (Double.parseDouble(_REPLACE(newName)) > readypost.size())) {

							RizwanUtil.showMessage(getApplicationContext(), "No page found");

							RizwanUtil.hideKeyboard(getApplicationContext());

						}

						else {

							viewpager1.setCurrentItem((int)Double.parseDouble(_REPLACE(newName)));

							RizwanUtil.hideKeyboard(getApplicationContext());

						}
					}
				});

				renameDialog.create().show();

			}

		});

		

		linear7.setOnClickListener(new OnClickListener() {

			@Override

			public void onClick(View _view) {

				

			}

		});

		

		linear8.setOnClickListener(new OnClickListener() {

			@Override

			public void onClick(View _view) {

				clicklist++;

				if (clicklist == 1) {

					imageview4.setRotation((float)(180));

					listview1.setVisibility(View.GONE);

					btn_search.setVisibility(View.INVISIBLE);

					viewpager1.setVisibility(View.VISIBLE);

					_fab.setVisibility(View.GONE);

					pagenumberbox.setVisibility(View.VISIBLE);

					linear10.setVisibility(View.GONE);

					

				}

				else {

					if (clicklist == 2) {

						imageview4.setRotation((float)(90));

						listview1.setVisibility(View.VISIBLE);

						viewpager1.setVisibility(View.GONE);

						btn_search.setVisibility(View.VISIBLE);

						_fab.setVisibility(View.VISIBLE);

						pagenumberbox.setVisibility(View.INVISIBLE);

						clicklist = 0;

					}

				}

			}

		});

		

		linear9.setOnClickListener(new OnClickListener() {

			@Override

			public void onClick(View _view) {

				load += 10;

				progressbar1.setVisibility(View.VISIBLE);

				_loadmore();

				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();

				((PagerAdapter)viewpager1.getAdapter()).notifyDataSetChanged();

				listview1.setStackFromBottom(true);

			}

		});

		

		imageview5.setOnClickListener(new OnClickListener() {

			@Override

			public void onClick(View _view) {

				load += 10;

				progressbar1.setVisibility(View.VISIBLE);

				_loadmore();

				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();

				listview1.setStackFromBottom(true);

			}

		});

		

		btn_back.setOnClickListener(new OnClickListener() {

			@Override

			public void onClick(View _view) {

				_byn_back();

			}

		});

		

		edittext1.addTextChangedListener(new TextWatcher() {

			@Override

			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {

				final String _charSeq = _param1.toString();

				_json_search(_charSeq);

			}

			

			@Override

			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {

				

			}

			

			@Override

			public void afterTextChanged(Editable _param1) {

				

			}

		});

		

		btn_clear.setOnClickListener(new OnClickListener() {

			@Override

			public void onClick(View _view) {

				_byn_clear();

			}

		});

		

		_fab.setOnClickListener(new OnClickListener() {

			@Override

			public void onClick(View _view) {

				load += 10;

				linear10.setVisibility(View.VISIBLE);

				

				_loadmore();

				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();

				listview1.setStackFromBottom(true);

				viewpager1.setCurrentItem(viewpager1.getAdapter().getCount() - 1);

			}

		});

		

		_ra_request_listener = new RequestNetwork.RequestListener() {

			@Override

			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {

				final String _tag = _param1;

				final String _response = _param2;

				final HashMap<String, Object> _responseHeaders = _param3;

				_phrase_string(_response, _tag);

				linear10.setVisibility(View.GONE);

				btn_search.setVisibility(View.VISIBLE);

				imageview3.setVisibility(View.GONE);

				pagenumber.setText(_replaceArabicNumber(" / ".concat(String.valueOf((long)(1 - readypost.size())))));

				linear1.setVisibility(View.VISIBLE);

				_fab.setVisibility(View.VISIBLE);

			}

			

			@Override

			public void onErrorResponse(String _param1, String _param2) {

				final String _tag = _param1;

				final String _message = _param2;

				RizwanUtil.showMessage(getApplicationContext(), "নেটওয়ার্ক সমস্যা ইন্টারনেট সেটিং চেক করুন");

				linear10.setVisibility(View.VISIBLE);

				btn_search.setVisibility(View.GONE);

			}

		};

		

		_ib_request_listener = new RequestNetwork.RequestListener() {

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

		

		_blog_child_listener = new ChildEventListener() {

			@Override

			public void onChildAdded(DataSnapshot _param1, String _param2) {

				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};

				final String _childKey = _param1.getKey();

				final HashMap<String, Object> _childValue = _param1.getValue(_ind);

				_update2(_childKey, _childValue);

			}

			

			@Override

			public void onChildChanged(DataSnapshot _param1, String _param2) {

				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};

				final String _childKey = _param1.getKey();

				final HashMap<String, Object> _childValue = _param1.getValue(_ind);

				

			}

			

			@Override

			public void onChildMoved(DataSnapshot _param1, String _param2) {

				

			}

			

			@Override

			public void onChildRemoved(DataSnapshot _param1) {

				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};

				final String _childKey = _param1.getKey();

				final HashMap<String, Object> _childValue = _param1.getValue(_ind);

				

			}

			

			@Override

			public void onCancelled(DatabaseError _param1) {

				final int _errorCode = _param1.getCode();

				final String _errorMessage = _param1.getMessage();

				

			}

		};

		blog.addChildEventListener(_blog_child_listener);

	}

	

	private void initializeLogic() {

		_oncreat_blog();

		

		btn_search.setVisibility(View.GONE);

		_statusbarcolor("#FF4CAF50");

		content.setText(String.valueOf((long)(readypost.size())));

		imageview3.setVisibility(View.GONE);

		linear1.setVisibility(View.VISIBLE);

		clicklist = 0;

		get = 0;

		viewpager1.setVisibility(View.GONE);

		pagenumber.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), Typeface.NORMAL);

		page.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);

		page.setText("০");

		pagenumber.setText(_replaceArabicNumber(" / ".concat(String.valueOf((long)(1 - readypost.size())))));

		click = 16;

		pagenumberbox.setVisibility(View.INVISIBLE);

		_fab.setVisibility(View.GONE);

	}

	

	@SuppressLint("MissingSuperCall")
    @Override

	public void onBackPressed() {

		if (searchbar.getVisibility() == View.VISIBLE) {

			edittext1.setText("");

			_byn_clear();

		}

		else {

			finish();
			if (mInterstitialAd != null) {
				mInterstitialAd.show(this);
			}
		}

	}

	


	public void _Customizar(final View _view, final String _cor, final double _arredondar, final double _elevar) {

		GradientDrawable gd = new GradientDrawable ();
		gd.setColor (Color.parseColor (_cor));
		gd.setCornerRadius ((int)_arredondar);
		_view.setBackground (gd);
		_view.setElevation((int)_elevar);

	}

	

	

	public void _phrase_string(final String _response, final String _tag) {

		try {

			shut.clear();

			allraw.clear();

			readypost.clear();

			
			JSONObject mainn = new JSONObject(_response);
			
			rawdata = mainn.getString("items");

			JSONArray main=new JSONArray(rawdata);

			shut = new Gson().fromJson(rawdata, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());

			ki = get;

			for(int _repeat282 = 0; _repeat282 < (int)(shut.size()); _repeat282++) {

				JSONObject list = main.getJSONObject((int)ki);
				
				//get post user name and img
				
				JSONObject temp = list.getJSONObject("author");
				
				username = temp.getString("displayName");
				
				JSONObject temp2 = temp.getJSONObject("image");
				
				userimage = temp2.getString("url");
				
				//end post user name
				
				//get post title content and img
				
				daydates = list.getString("published");
				post = list.getString("content");
				ptitle=list.getString("title");
				
				try{
					postcat = list.getString("labels");
				}catch (Exception e) { postcat = ("no labels");
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				

				di = daydates.replace("T", "");

				try{
					
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss"); 
					
					SimpleDateFormat df2 = new SimpleDateFormat("dd MMMM yyyy hh:mm a"); 
					
					Date date = format.parse(di);
					
					di = df2.format(date); 
					
				} catch (java.text.ParseException e) {
					
					 // TODO Auto-generated catch block
					
					 e.printStackTrace(); 
				};

				converted = new HashMap<>();

				finedimage = post.replace("\\", "").replace("\n", " ").replace("\\u", " ");

				List<String> allraw = new ArrayList<String>();
				
				
				Pattern pattern = Pattern.compile( "\\b(((ht|f)tp(s?)\\:\\/\\/|~\\/|\\/)|i1.wp.)" + "(\\w+:\\w+@)?(([-\\w]+\\.)+(com|org|net|gov" + "|mil|biz|info|mobi|name|aero|jobs|museum" + "|travel|[a-z]{2}))(:[\\d]{1,5})?" + "(((\\/([-\\w~!$+|.,=]|%[a-f\\d]{2})+)+|\\/)+|\\?|#)?" + "((\\?([-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?" + "([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)" + "(&(?:[-\\w~!$+|.,*:]|%[a-f\\d{2}])+=?" + "([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)*)*" + "(#([-\\w~!$+|.,*:=]|%[a-f\\d]{2})*)?\\b");
				Matcher matcher = pattern.matcher(finedimage);
				
				 while (matcher.find()) {
					
					allraw.add(matcher.group());
					
				};
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				

				if (allraw.size() > 1) {

					converted.put("img", allraw.get((int)(0)));

				}

				converted.put("title", ptitle);

				converted.put("content", post);

				converted.put("date", di);

				converted.put("authorimage", userimage.replace("//", ""));

				converted.put("labels", postcat);

				converted.put("author", username);

				readypost.add(converted);

				listview1.setAdapter(new Listview1Adapter(readypost));

				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();

				viewpager1.setAdapter(new Viewpager1Adapter(readypost));

				((PagerAdapter)viewpager1.getAdapter()).notifyDataSetChanged();

				alldata = new Gson().toJson(readypost);

				ki++;

			}

			
			
			
		} catch(Exception e)
		
		{ 
			error = e.toString(); 
			

			d.setMessage(error.concat("At position ".concat(String.valueOf((long)(ki)))));

			d.create().show();

			
			
		};

	}

	

	

	public void _json_search(final String _charSeq) {

		readypost = new Gson().fromJson(alldata, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());

		length = readypost.size();

		r = length - 1;

		for(int _repeat64 = 0; _repeat64 < (int)(length); _repeat64++) {

			value1 = readypost.get((int)r).get("title").toString();

			if (!(_charSeq.length() > value1.length()) && value1.toLowerCase().contains(_charSeq.toLowerCase())) {

				

			}

			else {

				readypost.remove((int)(r));

			}

			r--;

		}

		listview1.setAdapter(new Listview1Adapter(readypost));

		((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();

		_changeActivityFont("");

	}

	

	

	public void _btn_search1() {

		searchbar_enabled = true;

		searchbar.setVisibility(View.VISIBLE);

		edittext1.requestFocus();

	}

	

	

	public void _byn_clear() {

		if (edittext1.getText().toString().equals("")) {

			searchbar_enabled = false;

			toolbar.setVisibility(View.VISIBLE);

			searchbar.setVisibility(View.GONE);

		}

		else {

			edittext1.setText("");

		}

	}

	

	

	public void _byn_back() {

		searchbar_enabled = false;

		toolbar.setVisibility(View.VISIBLE);

		searchbar.setVisibility(View.GONE);

	}

	

	

	public void _wifi() {

		RizwanUtil.showMessage(getApplicationContext(), "Please check your internet");

		View popupView = getLayoutInflater().inflate(R.layout.popup, null);

		final PopupWindow popup = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

		LinearLayout b0 = popupView.findViewById(R.id.linear3);

		GradientDrawable ICDGIHF = new GradientDrawable();
		ICDGIHF.setColor(Color.parseColor("#FFFFFFFF"));
		ICDGIHF.setCornerRadii(new float[] { 5, 5, 5, 5, 5, 5, 5, 5 });
		ICDGIHF.setStroke(2, Color.parseColor("#FF000000"));
		b0.setBackground(ICDGIHF);
		if(Build.VERSION.SDK_INT >= 21) { b0.setElevation(10f); }

		Button b2 = popupView.findViewById(R.id.button2);
		Button b1 = popupView.findViewById(R.id.button1);
		Button b3 = popupView.findViewById(R.id.button3);

		b2.setOnClickListener(new OnClickListener() { public void onClick(View view) {

				_report();
			} });

		b1.setOnClickListener(new OnClickListener() { public void onClick(View view) {


				blog.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						mappp = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								mappp.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						load = 10;

						blogfa = new HashMap<>();

						blogfa.put("maxResults", String.valueOf((long)(load)));

						blogger_id = mappp.get((int)0).get("id").toString();

						blogger_gen = "https://www.googleapis.com/blogger/v3/blogs/".concat(blogger_id.concat("/posts"));

						blogfa.put("key", mappp.get((int)0).get("api").toString());

						ra.setParams(blogfa, RequestNetworkController.REQUEST_PARAM);

						ra.startRequestNetwork(RequestNetworkController.GET, blogger_gen, "", _ra_request_listener);
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});

				progressbar1.setVisibility(View.VISIBLE);

				ta = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								progressbar1.setVisibility(View.GONE);
							}
						});
					}
				};
				_timer.schedule(ta, (int)(5000));

				popup.dismiss();
			} });
		b3.setOnClickListener(new OnClickListener() { public void onClick(View view) {

				_open();
			} });

		TextView t1 = popupView.findViewById(R.id.one);

		t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/myfont.ttf"), android.graphics.Typeface.NORMAL);

		popup.showAtLocation(popupView, Gravity.CENTER, 0, 0);

	}

	

	

	public void _error() {

		ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE); NetworkInfo activeNetwork = cm.getActiveNetworkInfo(); if (activeNetwork != null) { if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) { _wifi(); } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) { _wifi(); } } else {
			_wifi();
		} 

	}

	

	

	public void _report() {

		in.setAction(Intent.ACTION_VIEW);

		in.setData(Uri.parse("mailto: muhammodrizwan0@gmail.com"));

		startActivity(in);

	}

	

	

	public void _open() {

		in.setAction(Intent.ACTION_VIEW);

		in.setData(Uri.parse(""));

		startActivity(in);

	}

	

	

	public void _oncreat_blog() {

		linear10.setVisibility(View.VISIBLE);

		{
			GradientDrawable SketchUi = new GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFF4CAF50);
			toolbar.setElevation(d*5);
			toolbar.setBackground(SketchUi);
		}
		{
			GradientDrawable SketchUi = new GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFF4CAF50);
			toolbar.setElevation(d*5);
			searchbar.setBackground(SketchUi);
		}

		listview1.setSelector(android.R.color.transparent);
		listview1.setFastScrollEnabled(false);

		searchbar.setVisibility(View.GONE);

		btn_search.setColorFilter(0xFFFFFFFF, PorterDuff.Mode.MULTIPLY);

		btn_back.setColorFilter(0xFFFFFFFF, PorterDuff.Mode.MULTIPLY);

		btn_clear.setColorFilter(0xFFFFFFFF, PorterDuff.Mode.MULTIPLY);

		_changeActivityFont("");

		blog.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot _dataSnapshot) {
				mappp = new ArrayList<>();
				try {
					GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
					for (DataSnapshot _data : _dataSnapshot.getChildren()) {
						HashMap<String, Object> _map = _data.getValue(_ind);
						mappp.add(_map);
					}
				}
				catch (Exception _e) {
					_e.printStackTrace();
				}
				load = 10;

				blogfa = new HashMap<>();

				blogfa.put("maxResults", String.valueOf((long)(load)));

				blogger_id = mappp.get((int)0).get("id").toString();

				blogger_gen = "https://www.googleapis.com/blogger/v3/blogs/".concat(blogger_id.concat("/posts"));

				blogfa.put("key", mappp.get((int)0).get("api").toString());

				ra.setParams(blogfa, RequestNetworkController.REQUEST_PARAM);

				ra.startRequestNetwork(RequestNetworkController.GET, blogger_gen, "", _ra_request_listener);
			}
			@Override
			public void onCancelled(DatabaseError _databaseError) {
			}
		});

	}

	

	

	public void _changeActivityFont(final String _fontname) {

		fontName = "fonts/".concat("solaimanlipi".concat(".ttf"));

		overrideFonts(this,getWindow().getDecorView()); 
	} 
	private void overrideFonts(final Context context, final View v) {
		
		try {
			Typeface 

			typeace = Typeface.createFromAsset(getAssets(), fontName);;

			if ((v instanceof ViewGroup)) {

				ViewGroup vg = (ViewGroup) v;
				for (int i = 0;
				i < vg.getChildCount();
				i++) {
					View child = vg.getChildAt(i);
					overrideFonts(context, child);
				}

			}

			else {

				if ((v instanceof TextView)) {

					((TextView) v).setTypeface(typeace);

				}

				else {

					if ((v instanceof EditText )) {

						((EditText) v).setTypeface(typeace);

					}

					else {

						if ((v instanceof Button)) {

							((Button) v).setTypeface(typeace);
						}

					}

				}

			}

		}

		catch(Exception e)
		
		{

			RizwanUtil.showMessage(getApplicationContext(), "Error Loading Font");

		};

	}

	

	

	public void _loadmore() {

		_fab.setVisibility(View.VISIBLE);

		blog.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot _dataSnapshot) {
				mappp = new ArrayList<>();
				try {
					GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
					for (DataSnapshot _data : _dataSnapshot.getChildren()) {
						HashMap<String, Object> _map = _data.getValue(_ind);
						mappp.add(_map);
					}
				}
				catch (Exception _e) {
					_e.printStackTrace();
				}
				map.clear();

				map = new HashMap<>();

				map.put("maxResults", String.valueOf((long)(load)));

				blogger_id = mappp.get((int)0).get("id").toString();

				blogger_gen = "https://www.googleapis.com/blogger/v3/blogs/".concat(blogger_id.concat("/posts"));

				map.put("key", mappp.get((int)0).get("api").toString());

				ra.setParams(map, RequestNetworkController.REQUEST_PARAM);

				ra.startRequestNetwork(RequestNetworkController.GET, blogger_gen, "b", _ra_request_listener);

				readypost.clear();
			}
			@Override
			public void onCancelled(DatabaseError _databaseError) {
			}
		});

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

		String result = _n.replace("1", "১").replace("2", "২").replace("3", "৩").replace("4", "৪").replace("5", "৫").replace("6", "৬").replace("7", "৭").replace("8", "৮").replace("9", "৯").replace("0", "০").replace("January", "জানুয়ারি").replace("February", "ফেব্রুয়ারী").replace("March", "মার্চ").replace("April", "এপ্রিল").replace("May", "মে").replace("June", "জুন").replace("July", "জুলাই").replace("August", "আগষ্ট").replace("September", "সেপ্টেম্বর").replace("October", "অক্টোবর").replace("November", "নভেম্বর").replace("December", "ডিসেম্বর").replace("-","");
		
		return result;

	}

	

	

	public void _enable_copy_textview(final TextView _tv) {

		_tv.setTextIsSelectable(true);

	}

	

	

	public String _REPLACE(final String _n) {

		String result = _n.replace("১", "1").replace("২", "2").replace("৩", "3").replace("৪", "4").replace("৫", "5").replace("৬", "6").replace("৭", "7").replace("৮", "8").replace("৯", "9").replace("০", "0").replace("/ ", "");
		
		return result;

	}

	

	

	public String _unwanted(final String _n) {

		String result = _n.replace("1", "১").replace("2", "২").replace("3", "৩").replace("4", "৪").replace("5", "৫").replace("6", "৬").replace("7", "৭").replace("8", "৮").replace("9", "৯").replace("0", "০").replace("&#39;", "০");
		
		return result;

	}

	

	

	public void _update2(final String _childKey, final HashMap<String, Object> _childValue) {

		blog.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot _dataSnapshot) {
				mappp = new ArrayList<>();
				try {
					GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
					for (DataSnapshot _data : _dataSnapshot.getChildren()) {
						HashMap<String, Object> _map = _data.getValue(_ind);
						mappp.add(_map);
					}
				}
				catch (Exception _e) {
					_e.printStackTrace();
				}
				blogger_id = mappp.get((int)0).get("id").toString();

				map.put("key", mappp.get((int)0).get("api").toString());
			}
			@Override
			public void onCancelled(DatabaseError _databaseError) {
			}
		});

	}

	

	public class Viewpager1Adapter extends PagerAdapter {

		

		Context _context;

		ArrayList<HashMap<String, Object>> _data;

		

		public Viewpager1Adapter(Context _ctx, ArrayList<HashMap<String, Object>> _arr) {

			_context = _ctx;

			_data = _arr;

		}

		

		public Viewpager1Adapter(ArrayList<HashMap<String, Object>> _arr) {

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

			View _view = LayoutInflater.from(_context).inflate(R.layout.book, _container, false);

			

			final LinearLayout linear8 = _view.findViewById(R.id.linear8);

			final LinearLayout linear10 = _view.findViewById(R.id.linear10);

			final ImageView imageview1 = _view.findViewById(R.id.imageview1);

			final LinearLayout linear7 = _view.findViewById(R.id.linear7);

			final LinearLayout linear2 = _view.findViewById(R.id.linear2);

			final LinearLayout linear5 = _view.findViewById(R.id.linear5);

			final TextView bookname = _view.findViewById(R.id.bookname);

			final Button button1 = _view.findViewById(R.id.button1);

			final TextView textview7 = _view.findViewById(R.id.textview7);

			final ImageView imageview2 = _view.findViewById(R.id.imageview2);

			final TextView date = _view.findViewById(R.id.date);

			final TextView textview4 = _view.findViewById(R.id.textview4);

			final TextView authorname = _view.findViewById(R.id.authorname);

			final ScrollView vscroll1 = _view.findViewById(R.id.vscroll1);

			final LinearLayout Tab = _view.findViewById(R.id.Tab);

			final LinearLayout content = _view.findViewById(R.id.content);

			final TextView textview1 = _view.findViewById(R.id.textview1);

			final WebView webview2 = _view.findViewById(R.id.webview2);

			final LinearLayout back1 = _view.findViewById(R.id.back1);

			final LinearLayout share = _view.findViewById(R.id.share);

			final LinearLayout copy = _view.findViewById(R.id.copy);

			final TextView textview8 = _view.findViewById(R.id.textview8);

			final LinearLayout high = _view.findViewById(R.id.high);

			final LinearLayout low = _view.findViewById(R.id.low);

			final LinearLayout next1 = _view.findViewById(R.id.next1);

			final ImageView imageview4 = _view.findViewById(R.id.imageview4);

			final ImageView imageview3 = _view.findViewById(R.id.imageview3);

			final ImageView imageview5 = _view.findViewById(R.id.imageview5);

			final ImageView imageview6 = _view.findViewById(R.id.imageview6);

			final ImageView imageview7 = _view.findViewById(R.id.imageview7);

			final ImageView imageview8 = _view.findViewById(R.id.imageview8);

			

			try {

				bookname.setText(_unwanted(_data.get((int)_position).get("title").toString()).concat("																																									"));

				date.setText(_replaceArabicNumber(_data.get((int)_position).get("date").toString()));

				authorname.setText(_data.get((int)_position).get("author").toString());

				Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("img").toString())).into(imageview1);

				
				
				
			} catch(Exception e)
			
			{ 
				
				

				Log.e("Error: ", e.toString()); 
				
			} 

			imageview1.setVisibility(View.GONE);

			textview7.setText(_replaceArabicNumber(String.valueOf((long)(1 + _position))));

			date.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);

			textview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);

			bookname.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);

			authorname.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);

			linear8.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View _view) {
					try {

						map = readypost.get((int)_position);

						i.setClass(getApplicationContext(), ViewActivity.class);

						i.putExtra("data", new Gson().toJson(map));

						startActivity(i);

						
						
						
					} catch(Exception e)
					
					{ 
						error = e.toString(); 
						

						RizwanUtil.showMessage(getApplicationContext(), error);

						
						
					};
				}
			});

			button1.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View _view) {
					button1.setBackgroundResource(0);

					save = new HashMap<>();

					save.put("1", readypost.get((int)_position).get("title").toString());

					save.put("2", readypost.get((int)_position).get("content").toString());

					save1.add(save);

					savek = new Gson().toJson(save1);

					if (readypost.get((int)_position).get("title").toString().equals("")) {

						FileUtil.writeFile(FileUtil.getPackageDataDir(getApplicationContext()).concat("/.ইসলামী বিশ্বকোষ ও আল হাদিস/অফলাইন প্রবন্ধ/".concat("অফলাইন প্রবন্ধ".concat(String.valueOf((long)(_position))).concat(""))), savek);

						RizwanUtil.showMessage(getApplicationContext(), "অফলাইনের জন্যেই যোগ করা হয়েছে");

					}

					else {

						FileUtil.writeFile(FileUtil.getPackageDataDir(getApplicationContext()).concat("/.ইসলামী বিশ্বকোষ ও আল হাদিস/অফলাইন প্রবন্ধ/".concat(readypost.get((int)_position).get("title").toString().concat(""))), savek);

						RizwanUtil.showMessage(getApplicationContext(), "অফলাইনের জন্যেই যোগ করা হয়েছে");

					}

					save1.remove(save);
				}
			});

			if (FileUtil.isExistFile(FileUtil.getPackageDataDir(getApplicationContext()).concat("/.ইসলামী বিশ্বকোষ ও আল হাদিস/অফলাইন প্রবন্ধ/".concat(readypost.get((int)_position).get("title").toString().concat(""))))) {

				button1.setBackgroundResource(0);

			}

			else {

				if (!FileUtil.isExistFile(FileUtil.getPackageDataDir(getApplicationContext()).concat("/.ইসলামী বিশ্বকোষ ও আল হাদিস/অফলাইন প্রবন্ধ/".concat(readypost.get((int)_position).get("title").toString().concat(""))))) {

					button1.setBackgroundResource(0);

				}

			}

			if(Build.VERSION.SDK_INT >= 21) {
				GradientDrawable SketchUi = new GradientDrawable();
				int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
				SketchUi.setColor(0xFFFFFFFF);
				SketchUi.setCornerRadius(d*15);
				SketchUi.setStroke(d*1,0xFF009688);
				linear8.setElevation(d*8);
				RippleDrawable SketchUi_RD = new RippleDrawable(new ColorStateList(new int[][]{new int[]{}}, new int[]{0xFF80CBC4}), SketchUi, null);
				linear8.setBackground(SketchUi_RD);
			}

			try {

				map = readypost.get((int)_position);

				htmlurl = "<!DOCTYPE html>\n<html>\n<head>\n\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n\n<meta content=\"width=device-width,initial-scale=1.0,minimum-scale=1.0\" name=\"viewport\">\n\n</head>\n\n<body style=\"width:95%; overflow-wrap: break-word;\">\n".concat(map.get("content").toString().concat("</body>\n</html>"));

				webview2.loadDataWithBaseURL(null,htmlurl, "text/html", "UTF-8", null); 

				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

					html = htmlurl;

					textview1.setText(Html.fromHtml(html, Html.FROM_HTML_MODE_COMPACT));

					textview1.setMovementMethod(LinkMovementMethod.getInstance());

				}

				else {

					html = htmlurl;

					textview1.setText(Html.fromHtml(html));

					textview1.setMovementMethod(LinkMovementMethod.getInstance());

				}

				textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);

				
				
				
			} catch(Exception e)
			
			{ 
				

				RizwanUtil.showMessage(getApplicationContext(), "can't get content");

				
				
			};

			_enable_copy_textview(textview1);

			_enable_copy_textview(bookname);

			Tab.setVisibility(View.VISIBLE);

			back1.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (_position == 0) {

						RizwanUtil.showMessage(getApplicationContext(), "প্রথম পৃষ্ঠা");

					}

					else {

						viewpager1.setCurrentItem((int)_position - 1);

					}
				}
			});

			next1.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (_position == Double.parseDouble(_REPLACE(pagenumber.getText().toString()))) {

						

					}

					else {

						viewpager1.setCurrentItem((int)_position + 1);

					}
				}
			});

			share.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View _view) {
					RizwanUtil.showMessage(getApplicationContext(), bookname.getText().toString().concat(" শেয়ার করা হয়েছে"));

					a = "এপ্সটি শেয়ার করুন";

					b = bookname.getText().toString().concat("\n____________________\n".concat(textview1.getText().toString().concat("\n".concat(textview1.getText().toString().concat(copyshare)))));

					Intent i = new Intent(Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(Intent.EXTRA_SUBJECT, a); i.putExtra(Intent.EXTRA_TEXT, b); startActivity(Intent.createChooser(i,"লেখা গুলো শেয়ার করুন"));
				}
			});

			copy.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View _view) {
					RizwanUtil.showMessage(getApplicationContext(), bookname.getText().toString().concat(" কপি করা হয়েছে"));

					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", bookname.getText().toString().concat("\n".concat(textview1.getText().toString()))));
				}
			});

			high.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View _view) {
					click++;

					textview1.setTextSize((int)click);
				}
			});

			low.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View _view) {
					click--;

					textview1.setTextSize((int)click);
				}
			});

			textview8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);

			

			_container.addView(_view);

			return _view;

		}

	}

	

	public class Listview1Adapter extends BaseAdapter {

		

		ArrayList<HashMap<String, Object>> _data;

		

		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {

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

				_view = _inflater.inflate(R.layout.book, null);

			}

			

			final LinearLayout linear8 = _view.findViewById(R.id.linear8);

			final LinearLayout linear10 = _view.findViewById(R.id.linear10);

			final ImageView imageview1 = _view.findViewById(R.id.imageview1);

			final LinearLayout linear7 = _view.findViewById(R.id.linear7);

			final LinearLayout linear2 = _view.findViewById(R.id.linear2);

			final LinearLayout linear5 = _view.findViewById(R.id.linear5);

			final TextView bookname = _view.findViewById(R.id.bookname);

			final Button button1 = _view.findViewById(R.id.button1);

			final TextView textview7 = _view.findViewById(R.id.textview7);

			final ImageView imageview2 = _view.findViewById(R.id.imageview2);

			final TextView date = _view.findViewById(R.id.date);

			final TextView textview4 = _view.findViewById(R.id.textview4);

			final TextView authorname = _view.findViewById(R.id.authorname);

			final ScrollView vscroll1 = _view.findViewById(R.id.vscroll1);

			final LinearLayout Tab = _view.findViewById(R.id.Tab);

			final LinearLayout content = _view.findViewById(R.id.content);

			final TextView textview1 = _view.findViewById(R.id.textview1);

			final WebView webview2 = _view.findViewById(R.id.webview2);

			final LinearLayout back1 = _view.findViewById(R.id.back1);

			final LinearLayout share = _view.findViewById(R.id.share);

			final LinearLayout copy = _view.findViewById(R.id.copy);

			final TextView textview8 = _view.findViewById(R.id.textview8);

			final LinearLayout high = _view.findViewById(R.id.high);

			final LinearLayout low = _view.findViewById(R.id.low);

			final LinearLayout next1 = _view.findViewById(R.id.next1);

			final ImageView imageview4 = _view.findViewById(R.id.imageview4);

			final ImageView imageview3 = _view.findViewById(R.id.imageview3);

			final ImageView imageview5 = _view.findViewById(R.id.imageview5);

			final ImageView imageview6 = _view.findViewById(R.id.imageview6);

			final ImageView imageview7 = _view.findViewById(R.id.imageview7);

			final ImageView imageview8 = _view.findViewById(R.id.imageview8);

			

			try {

				bookname.setText(_unwanted(_data.get((int)_position).get("title").toString()).concat("																																									"));

				date.setText(_replaceArabicNumber(_data.get((int)_position).get("date").toString()));

				authorname.setText(_data.get((int)_position).get("author").toString());

				if (_data.get((int)_position).get("img").toString().equals("")) {

					imageview1.setImageResource(R.drawable.nirvoy01);

				}

				else {

					Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("img").toString())).into(imageview1);

				}

				
				
				
			} catch(Exception e)
			
			{ 
				
				

				Log.e("Error: ", e.toString()); 
				
			} 

			imageview1.setVisibility(View.VISIBLE);

			textview7.setText(_replaceArabicNumber(String.valueOf((long)(1 + _position))));

			date.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);

			textview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), Typeface.NORMAL);

			bookname.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), Typeface.NORMAL);

			authorname.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), Typeface.NORMAL);

			linear8.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View _view) {
					try {

						map = readypost.get((int)_position);

						i.setClass(getApplicationContext(), ViewActivity.class);

						i.putExtra("data", new Gson().toJson(map));

						startActivity(i);

						
						
						
					} catch(Exception e)
					
					{ 
						error = e.toString(); 
						

						RizwanUtil.showMessage(getApplicationContext(), error);

						
						
					};
				}
			});

			button1.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View _view) {
					button1.setBackgroundResource(0);

					save = new HashMap<>();

					save.put("1", readypost.get((int)_position).get("title").toString());

					save.put("2", readypost.get((int)_position).get("content").toString());

					save1.add(save);

					savek = new Gson().toJson(save1);

					if (readypost.get((int)_position).get("title").toString().equals("")) {

						FileUtil.writeFile(FileUtil.getPackageDataDir(getApplicationContext()).concat("/.ইসলামী বিশ্বকোষ ও আল হাদিস/অফলাইন প্রবন্ধ/".concat("অফলাইন প্রবন্ধ".concat(String.valueOf((long)(_position))).concat(""))), savek);

						RizwanUtil.showMessage(getApplicationContext(), "অফলাইনের জন্যেই যোগ করা হয়েছে");

					}

					else {

						FileUtil.writeFile(FileUtil.getPackageDataDir(getApplicationContext()).concat("/.ইসলামী বিশ্বকোষ ও আল হাদিস/অফলাইন প্রবন্ধ/".concat(readypost.get((int)_position).get("title").toString().concat(""))), savek);

						RizwanUtil.showMessage(getApplicationContext(), "অফলাইনের জন্যেই যোগ করা হয়েছে");

					}

					save1.remove(save);
				}
			});

			if (FileUtil.isExistFile(FileUtil.getPackageDataDir(getApplicationContext()).concat("/.ইসলামী বিশ্বকোষ ও আল হাদিস/অফলাইন প্রবন্ধ/".concat(readypost.get((int)_position).get("title").toString().concat(""))))) {

				button1.setBackgroundResource(0);

			}

			else {

				if (!FileUtil.isExistFile(FileUtil.getPackageDataDir(getApplicationContext()).concat("/.ইসলামী বিশ্বকোষ ও আল হাদিস/অফলাইন প্রবন্ধ/".concat(readypost.get((int)_position).get("title").toString().concat(""))))) {

					button1.setBackgroundResource(0);

				}

			}

			if(Build.VERSION.SDK_INT >= 21) {
				GradientDrawable SketchUi = new GradientDrawable();
				int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
				SketchUi.setColor(0xFFFFFFFF);
				linear8.setElevation(d*8);
				RippleDrawable SketchUi_RD = new RippleDrawable(new ColorStateList(new int[][]{new int[]{}}, new int[]{0xFF80CBC4}), SketchUi, null);
				linear8.setBackground(SketchUi_RD);
			}

			Animation animation = new ScaleAnimation(0f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 1f);
			animation.setFillAfter(true);
			animation.setDuration(300);
			linear8.setAnimation(animation);

			vscroll1.setVisibility(View.GONE);

			Tab.setVisibility(View.GONE);

			

			return _view;

		}

	}

}
