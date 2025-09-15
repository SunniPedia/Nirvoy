package com.srizwan01.nirvoy11;

import android.annotation.SuppressLint;
import android.content.*;
import android.net.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.google.firebase.FirebaseApp;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class AboutUsActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private double num = 0;
	private double position = 0;
	
	private ArrayList<HashMap<String, Object>> img1 = new ArrayList<>();
	
	private ViewPager viewpager_slider;
	
	private RequestNetwork rr;
	private RequestNetwork.RequestListener _rr_request_listener;
	private TimerTask seven;
	private TimerTask timer;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.about_us);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		viewpager_slider = findViewById(R.id.viewpager_slider);
		rr = new RequestNetwork(this);
		
		_rr_request_listener = new RequestNetwork.RequestListener() {
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
		try{
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("img", "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEitPa3XrdOBqgT4syVu-V3G_W30fD1hTN3dRHcfUUNZRGJTMWs-pyVzkPpfpaVPbvEi0GL8BIwusWRAz_d7Vx0uH-v51Fat92_YQcJCXI58munjIZIvKgX0SGE403PfdieOpkAmVuxH0NfdDg67wNQHv2UvCit9c7fQu6DZYIeojLdOfmMEASiKBU0VaMlA/s1004/FB_IMG_17245966278200220.jpg");
				img1.add(_item);
			}
			
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("img", "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgm6M51E2c4pwbCrGJW7zwNPhDY0MlT0ebyFipr0dCA9dnyiNtl08Gm3KXwJij0pVlCmyICMbxPNumXQYO589e1nUKRPID7FdPzO7Q2BwLk3CGt-X7qLFRT33yl5cZ5lsCkju_P3FalMaJcmo1UZ1OLoIzoNONrwYslK2hQU5z3XyVuHzw0qB49B3dU_rPk/s1004/FB_IMG_17245966306624925.jpg");
				img1.add(_item);
			}
			
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("img", "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjd45r7RjcYujb-ZYlYwjaf2w_4yuKPeH7K9jnTex1B4jmFHFoek7hrwjsiiAzjfaQ2XrVs0Yqqymwe70dMgVnYPULzP1cOEjohVIawTm4B5csDi9XODkXvwbIAbz2EuwnqYimY9mdAuNpJ5_ip7XwS9xgkOVPRLmCVqA-ULE_EfY988rkJAieeKDac-Ha1/s1004/FB_IMG_17245966340852458.jpg");
				img1.add(_item);
			}
			
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("img", "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhc93mOArkB5QChzLUt-GQvNa4ajTi3FG-X-qkBfvVtJbUsthk_zuAKq7nNFOgm_6cvicbM-mxDj8moYt94dPyw8AqewXZcxbCwgWs8mul72qKIX5pvRhhmIDRNx3RqwClegTjLrJg2NNNVk_Nv90An80T419Eq3qjrE-S7MsgUBsatNZ_FO2NVMTA-S0-t/s1123/FB_IMG_17245966398990213.jpg");
				img1.add(_item);
			}
			
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("img", "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEie7O5fBVT1VvWmhRA3HjeUZu7Pks_NALQNXt6bsXgWVC-JtSWfaereQUu5VPabLs7MKKMCvEQ3mozUrPv9AS4D6d5LcpfEB_dNVezXQhfs75lCG20BD031xdRa1E4BuLx56-65fMKESD0eg8nNHmbdOfz2lkK0ArHTlLnOq6l2CMF7d8SpMeZBpW8uvnJ5/s1123/FB_IMG_17245966430185475.jpg");
				img1.add(_item);
			}
			
			final float scaleFactor = 0.90f; viewpager_slider.setPageMargin(-30); viewpager_slider.setOffscreenPageLimit(2); viewpager_slider.setPageTransformer(false, new ViewPager.PageTransformer() { @Override public void transformPage(@NonNull View page1, float position) { page1.setScaleY((1 - Math.abs(position) * (1 - scaleFactor))); page1.setScaleX(scaleFactor + Math.abs(position) * (1 - scaleFactor)); } });
			viewpager_slider.setAdapter(new Viewpager_sliderAdapter(img1));
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
							if (num == img1.size()) {
								num = 0;
							}
						}
					});
				}
			};
			_timer.scheduleAtFixedRate(seven, (int)(0), (int)(2000));
		}catch(Exception e){
			 
		}
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
			View _view = LayoutInflater.from(_context).inflate(R.layout.about_usa, _container, false);
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			
			Glide.with(getApplicationContext()).load(Uri.parse(img1.get((int)_position).get("img").toString())).into(imageview1);
			
			_container.addView(_view);
			return _view;
		}
	}
	}
