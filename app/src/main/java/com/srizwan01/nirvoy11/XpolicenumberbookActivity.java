package com.srizwan01.nirvoy11;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.widget.*;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.FirebaseApp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
public class XpolicenumberbookActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	
	private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> map1 = new ArrayList<>();
	
	private ListView listview1;
	
	private Intent in = new Intent();
	private InterstitialAd mInterstitialAd;
	private AdView adView;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.xpolicenumberbook);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
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
		listview1 = findViewById(R.id.listview1);
	}
	
	private void initializeLogic() {
		setTitle("ফোন বুক");
		try{
			InputStream inputstream1 = getAssets().open("area.json");
			map = new Gson().fromJson(RizwanUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			listview1.setAdapter(new Listview1Adapter(map));
			((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		}catch(Exception e){
			 
		}
	}
	
	@SuppressLint({"MissingSuperCall", "GestureBackNavigation"})
    @Override
	public void onBackPressed() {
		finish();
		/*
		if (mInterstitialAd != null) {
			mInterstitialAd.show(this);
		}

		 */
	}
	public void _stock(final View _m) {
		{
			GradientDrawable SketchUi = new GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFFFFFFFF);
			_m.setElevation(d*5);
			RippleDrawable SketchUi_RD = new RippleDrawable(new ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFB3E5FC}), SketchUi, null);
			_m.setBackground(SketchUi_RD);
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
				_view = _inflater.inflate(R.layout.policephone, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			
			_stock(linear1);
			Animation animation = new ScaleAnimation(0f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 1f);
			animation.setFillAfter(true);
			animation.setDuration(300);
			linear1.setAnimation(animation);
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/myfont.ttf"), Typeface.NORMAL);
			textview1.setText(map.get((int)_position).get("area").toString());
			linear1.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View _view) {
					in.setClass(getApplicationContext(), XphonenumberActivity.class);
					in.putExtra("heading", map.get((int)_position).get("area").toString());
					startActivity(in);
				}
			});
			if (map.get((int)_position).get("area").toString().equals("গাউছিয়া কমিটি")) {
				linear1.setVisibility(View.GONE);
			}
			else {
				linear1.setVisibility(View.VISIBLE);
			}
			
			return _view;
		}
	}
	}
