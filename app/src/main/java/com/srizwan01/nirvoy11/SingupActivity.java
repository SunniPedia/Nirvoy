package com.srizwan01.nirvoy11;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import de.hdodenhof.circleimageview.*;

import java.io.File;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;


public class SingupActivity extends AppCompatActivity {
	
	public final int REQ_CD_PICTURE = 101;
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	private String imageName = "";
	private double imagePath = 0;
	private String image = "";
	private String fontName = "";
	private String typeace = "";
	
	private ArrayList<HashMap<String, Object>> inf = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear4;
	private TextInputLayout textinputlayout1;
	private TextInputLayout textinputlayout2;
	private TextInputLayout textinputlayout3;
	private TextInputLayout textinputlayout6;
	private TextInputLayout textinputlayout4;
	private TextInputLayout textinputlayout8;
	private TextInputLayout textinputlayout7;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear5;
	private TextView textview3;
	private TextView textview4;
	private CircleImageView circleimageview1;
	private EditText edittext1;
	private EditText edittext2;
	private EditText edittext3;
	private EditText edittext6;
	private EditText edittext4;
	private EditText edittext8;
	private EditText edittext7;
	private Button button1;
	private TextView textview1;
	private TextView textview2;
	
	private Intent picture = new Intent(Intent.ACTION_GET_CONTENT);
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
	
	private DatabaseReference db = _firebase.getReference("db");
	private ChildEventListener _db_child_listener;
	private Intent intetent = new Intent();
	private Intent intent = new Intent();
	private StorageReference storage = _firebase_storage.getReference("storage");
	private OnCompleteListener<Uri> _storage_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _storage_download_success_listener;
	private OnSuccessListener _storage_delete_success_listener;
	private OnProgressListener _storage_upload_progress_listener;
	private OnProgressListener _storage_download_progress_listener;
	private OnFailureListener _storage_failure_listener;
	
	private SharedPreferences locate;
	private SharedPreferences details;
	private Calendar cal = Calendar.getInstance();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.singup);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
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
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		linear4 = findViewById(R.id.linear4);
		textinputlayout1 = findViewById(R.id.textinputlayout1);
		textinputlayout2 = findViewById(R.id.textinputlayout2);
		textinputlayout3 = findViewById(R.id.textinputlayout3);
		textinputlayout6 = findViewById(R.id.textinputlayout6);
		textinputlayout4 = findViewById(R.id.textinputlayout4);
		textinputlayout8 = findViewById(R.id.textinputlayout8);
		textinputlayout7 = findViewById(R.id.textinputlayout7);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear5 = findViewById(R.id.linear5);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		circleimageview1 = findViewById(R.id.circleimageview1);
		edittext1 = findViewById(R.id.edittext1);
		edittext2 = findViewById(R.id.edittext2);
		edittext3 = findViewById(R.id.edittext3);
		edittext6 = findViewById(R.id.edittext6);
		edittext4 = findViewById(R.id.edittext4);
		edittext8 = findViewById(R.id.edittext8);
		edittext7 = findViewById(R.id.edittext7);
		button1 = findViewById(R.id.button1);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		picture.setType("image/*");
		picture.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		auth = FirebaseAuth.getInstance();
		locate = getSharedPreferences("locate", Activity.MODE_PRIVATE);
		details = getSharedPreferences("details", Activity.MODE_PRIVATE);
		
		circleimageview1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(picture, REQ_CD_PICTURE);
			}
		});

		
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext1.getText().toString().equals("") && (edittext2.getText().toString().equals("") && (edittext3.getText().toString().equals("") && (edittext6.getText().toString().equals("") && (edittext7.getText().toString().equals("") && edittext8.getText().toString().equals("")))))) {
					RizwanUtil.showMessage(getApplicationContext(), "ঘর খালি রাখা যাবে না");
				}
				else {
					if (edittext1.getText().toString().equals("")) {
						RizwanUtil.showMessage(getApplicationContext(), "এন আই ডি কার্ডের নাম লিখুন");
					}
					else {
						if (edittext2.getText().toString().equals("")) {
							RizwanUtil.showMessage(getApplicationContext(), "ইমেইল এড্রেস লিখুন");
						}
						else {
							if (edittext3.getText().toString().equals("")) {
								RizwanUtil.showMessage(getApplicationContext(), "পাসওয়ার্ড লিখুন");
							}
							else {
								if (edittext6.getText().toString().equals("")) {
									RizwanUtil.showMessage(getApplicationContext(), "মোবাইল নাম্বার লিখুন");
								}
								else {
									if (edittext6.getText().toString().equals("")) {
										RizwanUtil.showMessage(getApplicationContext(), "মোবাইল নাম্বার লিখুন");
									}
									else {
										if (image.equals("")) {
											RizwanUtil.showMessage(getApplicationContext(), "প্রোফাইলের ছবি আপলোড করুন");
										}
										else {
											auth.createUserWithEmailAndPassword(edittext2.getText().toString().trim(), edittext3.getText().toString()).addOnCompleteListener(SingupActivity.this, _auth_create_user_listener);
										}
									}
								}
							}
						}
					}
				}
			}
		});
		edittext7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// বর্তমান তারিখ নেওয়া হচ্ছে
				final Calendar cal = Calendar.getInstance();
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH);
				int day = cal.get(Calendar.DAY_OF_MONTH);

				// ডেট পিকার ডায়লগ দেখানোর জন্য
				DatePickerDialog datePickerDialog = new DatePickerDialog(SingupActivity.this, new DatePickerDialog.OnDateSetListener() {
					@Override
					public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
						// যেহেতু মাস ০ থেকে শুরু হয়, তাই ১ যোগ করা হয়েছে
						selectedMonth = selectedMonth + 1;

						// ডেট ফরম্যাট করে EditText7 এ বসানো হচ্ছে
						String date = selectedDay + "/" + selectedMonth + "/" + selectedYear;
						edittext7.setText(date);
					}
				}, year, month, day);

				datePickerDialog.show();
			}
		});
		edittext7.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// বর্তমান তারিখ নেওয়া হচ্ছে
					final Calendar cal = Calendar.getInstance();
					int year = cal.get(Calendar.YEAR);
					int month = cal.get(Calendar.MONTH);
					int day = cal.get(Calendar.DAY_OF_MONTH);

					// ডেট পিকার ডায়লগ দেখানোর জন্য
					DatePickerDialog datePickerDialog = new DatePickerDialog(SingupActivity.this, new DatePickerDialog.OnDateSetListener() {
						@Override
						public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
							// যেহেতু মাস ০ থেকে শুরু হয়, তাই ১ যোগ করা হয়েছে
							selectedMonth = selectedMonth + 1;

							// ডেট ফরম্যাট করে EditText7 এ বসানো হচ্ছে
							String date = selectedDay + "/" + selectedMonth + "/" + selectedYear;
							edittext7.setText(date);
						}
					}, year, month, day);

					datePickerDialog.show();
					return true;  // এখানে true রিটার্ন করলে এটি টাচ ইভেন্টকে শেষ করবে
				}
				return false;
			}
		});

		textview2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivity(new Intent(SingupActivity.this, LoginActivity.class));
				finish();
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
		db.addChildEventListener(_db_child_listener);
		
		_storage_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				final ProgressDialog prog = new ProgressDialog(SingupActivity.this);
				prog.setMax(100);
				prog.setMessage("Creating new profile");
				prog.setIndeterminate(true);
				prog.setCancelable(false);
				prog.show();
				if (_progressValue == 100) {
					prog.hide();
				}
				else {
					
				}
			}
		};
		
		_storage_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_storage_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				map = new HashMap<>();
				map.put("avatar", _downloadUrl);
				map.put("nidname", edittext1.getText().toString());
				details.edit().putString("nidname", edittext1.getText().toString()).commit();
				map.put("phonenumber", edittext6.getText().toString());
				details.edit().putString("phonenumber", edittext6.getText().toString()).commit();
				map.put("nidnumber", edittext4.getText().toString());
				details.edit().putString("nidnumber", edittext4.getText().toString()).commit();
				map.put("address", edittext8.getText().toString());
				details.edit().putString("address", edittext8.getText().toString()).commit();
				map.put("dob", edittext7.getText().toString());
				details.edit().putString("dob", edittext7.getText().toString()).commit();
				map.put("verified", "Non verified");
				details.edit().putString("verified", "Non verified").commit();
				db.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
				map.clear();
				intent.setClass(getApplicationContext(), Main1Activity.class);
				startActivity(intent);
				finish();
			}
		};
		
		_storage_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_storage_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_storage_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
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
				if (_success) {
					RizwanUtil.showMessage(getApplicationContext(), "Email Verification Sent. Verify your email address.");
				}
				else {
					RizwanUtil.showMessage(getApplicationContext(), _errorMessage);
				}
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
				if (_success) {
					storage.child(imageName).putFile(Uri.fromFile(new File(image))).addOnFailureListener(_storage_failure_listener).addOnProgressListener(_storage_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
						@Override
						public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
							return storage.child(imageName).getDownloadUrl();
						}}).addOnCompleteListener(_storage_upload_success_listener);
				}
				else {
					RizwanUtil.showMessage(getApplicationContext(), _errorMessage);
				}
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
		cal = Calendar.getInstance();
		textinputlayout1.setBoxCornerRadii((float)100, (float)100, (float)100, (float)100);
		textinputlayout1.setBoxBackgroundColor(0xFFFFFFFF);
		textinputlayout2.setBoxCornerRadii((float)100, (float)100, (float)100, (float)100);
		textinputlayout2.setBoxBackgroundColor(0xFFFFFFFF);
		textinputlayout3.setBoxCornerRadii((float)100, (float)100, (float)100, (float)100);
		textinputlayout3.setBoxBackgroundColor(0xFFFFFFFF);
		textinputlayout6.setBoxCornerRadii((float)100, (float)100, (float)100, (float)100);
		textinputlayout6.setBoxBackgroundColor(0xFFFFFFFF);
		textinputlayout4.setBoxCornerRadii((float)100, (float)100, (float)100, (float)100);
		textinputlayout4.setBoxBackgroundColor(0xFFFFFFFF);
		textinputlayout8.setBoxCornerRadii((float)100, (float)100, (float)100, (float)100);
		textinputlayout8.setBoxBackgroundColor(0xFFFFFFFF);
		textinputlayout7.setBoxCornerRadii((float)100, (float)100, (float)100, (float)100);
		textinputlayout7.setBoxBackgroundColor(0xFFFFFFFF);
		button1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)100, 0xFFFFE8F3));
		_changeActivityFont("");
		edittext1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), Typeface.NORMAL);
		edittext2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);
		edittext3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);
		edittext6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);
		edittext4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);
		edittext7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), Typeface.NORMAL);
		edittext8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), Typeface.NORMAL);
		if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
					    setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
					            | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, true);
		}
		if (Build.VERSION.SDK_INT >= 19) {
					    getWindow().getDecorView().setSystemUiVisibility(
					            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
					                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
					                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
					    );
		}
		if (Build.VERSION.SDK_INT >= 21) {
					    setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
					            | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, false);
					    getWindow().setStatusBarColor(Color.TRANSPARENT);
					    getWindow().setNavigationBarColor(Color.TRANSPARENT);
		}
	}

	private void setWindowFlag(final int bits, boolean on) {
		    Window win = getWindow();
		    WindowManager.LayoutParams winParams = win.getAttributes();
		    if (on) {
					        winParams.flags |= bits;
					    } else {
					        winParams.flags &= ~bits;
					    }
		    win.setAttributes(winParams);
	}
	{
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_PICTURE:
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
				image = _filePath.get((int)(0));
				imageName = Uri.parse(_filePath.get((int)(0))).getLastPathSegment();
				circleimageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(image, 1024, 1024));
				details.edit().putString("image", image).commit();
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	
	@SuppressLint("MissingSuperCall")
    @Override
	public void onBackPressed() {
		finish();
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
