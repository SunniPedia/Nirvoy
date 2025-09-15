package com.srizwan01.nirvoy11;

import android.Manifest;
import android.animation.*;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.*;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.util.*;
import android.view.*;
import android.view.View;
import android.widget.*;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
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
import java.util.Timer;
import java.util.TimerTask;

import com.takisoft.datetimepicker.DatePickerDialog;


public class ProfileActivity extends AppCompatActivity {
	
	public final int REQ_CD_IMAGE = 101;
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private HashMap<String, Object> all_months = new HashMap<>();
	private String imagePath = "";
	private String imageName = "";
	private HashMap<String, Object> map = new HashMap<>();
	private String profile_path = "";
	private boolean isDOBChoosed = false;
	private String fontName = "";
	private String typeace = "";
	private double clik = 0;
	
	private ArrayList<HashMap<String, Object>> inf = new ArrayList<>();
	
	private LinearLayout toolbar;
	private LinearLayout content_wrapper;
	private ImageView back_img;
	private TextView toolbar_title;
	private ImageView done_img;
	private RelativeLayout profile_relative;
	private LinearLayout linear9;
	private LinearLayout linear3;
	private LinearLayout username_field;
	private LinearLayout bio_field;
	private LinearLayout email_field;
	private LinearLayout linear6;
	private LinearLayout linear1;
	private LinearLayout dob_field;
	private LinearLayout profile_wrapper;
	private LinearLayout choose_wrapper;
	private CircleImageView profile_image;
	private LinearLayout choose_layout;
	private ImageView choose_image;
	private TextView textview6;
	private TextView verified;
	private TextView textview2;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private TextView textview3;
	private EditText nidname;
	private TextView Phone_number;
	private LinearLayout username_wrapper;
	private LinearLayout username_base;
	private TextView username_error;
	private TextView at_rate;
	private EditText username_edittext;
	private TextView bio_title;
	private EditText nidnumber;
	private LinearLayout bio_base;
	private TextView bio_error;
	private TextView email_title;
	private EditText email_edittext;
	private LinearLayout email_base;
	private TextView email_error;
	private TextView textview4;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private TextView textview5;
	private EditText dob;
	private TextView textview1;
	private EditText Permanet_Adress;
	private LinearLayout linear2;
	private TextView dob_title;
	private LinearLayout dob_wrapper;
	private LinearLayout date_field;
	private LinearLayout month_field;
	private LinearLayout year_field;
	private TextView date_text;
	private LinearLayout date_base;
	private TextView month_text;
	private LinearLayout month_base;
	private TextView year_text;
	private LinearLayout year_base;
	
	private Intent image = new Intent(Intent.ACTION_GET_CONTENT);
	private SharedPreferences date;
	private StorageReference storage = _firebase_storage.getReference("stoarge");
	private OnCompleteListener<Uri> _storage_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _storage_download_success_listener;
	private OnSuccessListener _storage_delete_success_listener;
	private OnProgressListener _storage_upload_progress_listener;
	private OnProgressListener _storage_download_progress_listener;
	private OnFailureListener _storage_failure_listener;
	
	private DatabaseReference db = _firebase.getReference("db");
	private ChildEventListener _db_child_listener;
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
	
	private TimerTask sign;
	private SharedPreferences locate;
	private SharedPreferences details;
	private Calendar cal = Calendar.getInstance();
	private Intent in = new Intent();
	private TimerTask t;
	private AlertDialog.Builder verify;
	private Intent main = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.profile);
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
		toolbar = findViewById(R.id.toolbar);
		content_wrapper = findViewById(R.id.content_wrapper);
		back_img = findViewById(R.id.back_img);
		toolbar_title = findViewById(R.id.toolbar_title);
		done_img = findViewById(R.id.done_img);
		profile_relative = findViewById(R.id.profile_relative);
		linear9 = findViewById(R.id.linear9);
		linear3 = findViewById(R.id.linear3);
		username_field = findViewById(R.id.username_field);
		bio_field = findViewById(R.id.bio_field);
		email_field = findViewById(R.id.email_field);
		linear6 = findViewById(R.id.linear6);
		linear1 = findViewById(R.id.linear1);
		dob_field = findViewById(R.id.dob_field);
		profile_wrapper = findViewById(R.id.profile_wrapper);
		choose_wrapper = findViewById(R.id.choose_wrapper);
		profile_image = findViewById(R.id.profile_image);
		choose_layout = findViewById(R.id.choose_layout);
		choose_image = findViewById(R.id.choose_image);
		textview6 = findViewById(R.id.textview6);
		verified = findViewById(R.id.verified);
		textview2 = findViewById(R.id.textview2);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		textview3 = findViewById(R.id.textview3);
		nidname = findViewById(R.id.nidname);
		Phone_number = findViewById(R.id.Phone_number);
		username_wrapper = findViewById(R.id.username_wrapper);
		username_base = findViewById(R.id.username_base);
		username_error = findViewById(R.id.username_error);
		at_rate = findViewById(R.id.at_rate);
		username_edittext = findViewById(R.id.username_edittext);
		bio_title = findViewById(R.id.bio_title);
		nidnumber = findViewById(R.id.nidnumber);
		bio_base = findViewById(R.id.bio_base);
		bio_error = findViewById(R.id.bio_error);
		email_title = findViewById(R.id.email_title);
		email_edittext = findViewById(R.id.email_edittext);
		email_base = findViewById(R.id.email_base);
		email_error = findViewById(R.id.email_error);
		textview4 = findViewById(R.id.textview4);
		linear7 = findViewById(R.id.linear7);
		linear8 = findViewById(R.id.linear8);
		textview5 = findViewById(R.id.textview5);
		dob = findViewById(R.id.dob);
		textview1 = findViewById(R.id.textview1);
		Permanet_Adress = findViewById(R.id.Permanet_Adress);
		linear2 = findViewById(R.id.linear2);
		dob_title = findViewById(R.id.dob_title);
		dob_wrapper = findViewById(R.id.dob_wrapper);
		date_field = findViewById(R.id.date_field);
		month_field = findViewById(R.id.month_field);
		year_field = findViewById(R.id.year_field);
		date_text = findViewById(R.id.date_text);
		date_base = findViewById(R.id.date_base);
		month_text = findViewById(R.id.month_text);
		month_base = findViewById(R.id.month_base);
		year_text = findViewById(R.id.year_text);
		year_base = findViewById(R.id.year_base);
		image.setType("image/*");
		image.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		date = getSharedPreferences("date", Activity.MODE_PRIVATE);
		auth = FirebaseAuth.getInstance();
		locate = getSharedPreferences("locate", Activity.MODE_PRIVATE);
		details = getSharedPreferences("details", Activity.MODE_PRIVATE);
		verify = new AlertDialog.Builder(this);
		
		back_img.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		done_img.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				clik++;
				if (clik == 1) {
					done_img.setImageResource(R.drawable.ic_check_white);
					nidname.setEnabled(true);
					username_edittext.setEnabled(true);
					nidnumber.setEnabled(true);
					email_edittext.setEnabled(true);
					dob.setEnabled(true);
					choose_layout.setVisibility(View.VISIBLE);
					choose_layout.setEnabled(true);
				}
				else {
					if (clik == 2) {
						if (email_edittext.getText().toString().equals("") && (username_edittext.getText().toString().equals("") && (nidnumber.getText().toString().equals("") && (email_edittext.getText().toString().equals("") && dob.getText().toString().equals(""))))) {
							nidname.setEnabled(false);
							username_edittext.setEnabled(false);
							nidnumber.setEnabled(false);
							email_edittext.setEnabled(false);
							dob.setEnabled(false);
							choose_layout.setEnabled(false);
							choose_layout.setVisibility(View.GONE);
							done_img.setImageResource(R.drawable.ic_mode_edit_white);
							clik = 0;
						}
						else {
							if (imagePath.equals("")) {
								RizwanUtil.showMessage(getApplicationContext(), "নতুন প্রোফাইল পিকচার দিন।");
							}
							else {
								if (email_edittext.getText().toString().equals("")) {
									_email_case();
								}
								else {
									if (username_edittext.getText().toString().equals("")) {
										_username_case();
									}
									else {
										if (nidnumber.getText().toString().equals("")) {
											_bio_case();
										}
										else {
											storage.child(imageName).putFile(Uri.fromFile(new File(imagePath))).addOnFailureListener(_storage_failure_listener).addOnProgressListener(_storage_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
												@Override
												public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
													return storage.child(imageName).getDownloadUrl();
												}}).addOnCompleteListener(_storage_upload_success_listener);
											details.edit().putString("nidname", nidname.getText().toString()).commit();
											details.edit().putString("phonenumber", username_edittext.getText().toString()).commit();
											details.edit().putString("address", email_edittext.getText().toString()).commit();
											details.edit().putString("nidnumber", nidnumber.getText().toString()).commit();
											details.edit().putString("dob", dob.getText().toString()).commit();
											details.edit().putString("verified", verified.getText().toString()).commit();
											RizwanUtil.showMessage(getApplicationContext(), "Successfully Updated");
										}
									}
								}
							}
						}
						nidname.setEnabled(false);
						username_edittext.setEnabled(false);
						nidnumber.setEnabled(false);
						email_edittext.setEnabled(false);
						dob.setEnabled(false);
						choose_layout.setEnabled(false);
						choose_layout.setVisibility(View.GONE);
						done_img.setImageResource(R.drawable.ic_mode_edit_white);
						clik = 0;
					}
				}
			}
		});
		
		choose_layout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(image, REQ_CD_IMAGE);
			}
		});
		
		verified.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (verified.getText().toString().equals("Non verified")) {
					verify.setTitle("একাউন্ট ভেরিফাই করার জন্যেই");
					verify.setMessage("আইডি কার্ডের সামনের ছবি");
					verify.setPositiveButton("ভেরিফাই", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							main.setClass(getApplicationContext(), NidActivity.class);
							main.putExtra("1", FirebaseAuth.getInstance().getCurrentUser().getUid().concat("/".concat(nidname.getText().toString().concat("	 /".concat(username_edittext.getText().toString().concat("	/".concat(nidnumber.getText().toString().concat("	/".concat(email_edittext.getText().toString().concat("/".concat(dob.getText().toString())))))))))));
							startActivity(main);
						}
					});
					verify.setNegativeButton("বাতিল", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					verify.create().show();
				}
				else {
					
				}
			}
		});
		
		nidname.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				
				return true;
			}
		});
		
		dob.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				DatePickerDialog dpd = new DatePickerDialog(ProfileActivity.this, (view1, year, month, dayOfMonth) -> {
					                
					dob.setText(String.format("%d", year) + "-" + String.format("%02d", month + 1) + "-" + String.format("%02d", dayOfMonth));
					 }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
				  
				  dpd.show();
			}
		});
		
		_storage_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
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
				map.put("nidname", nidname.getText().toString());
				details.edit().putString("nidname", nidname.getText().toString()).commit();
				map.put("phonenumber", username_edittext.getText().toString());
				details.edit().putString("phonenumber", username_edittext.getText().toString()).commit();
				map.put("nidnumber", nidnumber.getText().toString());
				details.edit().putString("nidnumber", nidnumber.getText().toString()).commit();
				map.put("address", email_edittext.getText().toString());
				details.edit().putString("address", email_edittext.getText().toString()).commit();
				map.put("dob", dob.getText().toString());
				details.edit().putString("dob", dob.getText().toString()).commit();
				map.put("verified", "Non verified");
				details.edit().putString("verified", "Non verified").commit();
				db.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
				map.clear();
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
		
		_db_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
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
							Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("avatar").toString())).into(profile_image);
							nidname.setText(_childValue.get("nidname").toString());
							username_edittext.setText(_childValue.get("phonenumber").toString());
							nidnumber.setText(_childValue.get("nidnumber").toString());
							email_edittext.setText(_childValue.get("address").toString());
							dob.setText(_childValue.get("dob").toString());
							verified.setText(_childValue.get("verified").toString());
						}
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
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
							Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("avatar").toString())).into(profile_image);
							nidname.setText(_childValue.get("nidname").toString());
							Phone_number.setText(_childValue.get("phonenumber").toString());
							nidnumber.setText(_childValue.get("nidnumber").toString());
							email_edittext.setText(_childValue.get("address").toString());
							dob.setText(_childValue.get("dob").toString());
							verified.setText(_childValue.get("verified").toString());
						}
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
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
							Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("avatar").toString())).into(profile_image);
							nidname.setText(_childValue.get("nidname").toString());
							Phone_number.setText(_childValue.get("phonenumber").toString());
							nidnumber.setText(_childValue.get("nidnumber").toString());
							email_edittext.setText(_childValue.get("address").toString());
							dob.setText(_childValue.get("dob").toString());
							verified.setText(_childValue.get("verified").toString());
						}
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		db.addChildEventListener(_db_child_listener);
		
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
		clik = 0;
		cal = Calendar.getInstance();
		_statusbarcolor("#FF4CAF50");
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFF4CAF50);
			toolbar.setElevation(d*5);
			toolbar.setBackground(SketchUi);
		}
		_changeActivityFont("");
		bio_title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), Typeface.NORMAL);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);
		Phone_number.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);
		bio_title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);
		email_title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);
		dob.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/myfont.ttf"), android.graphics.Typeface.NORMAL);
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), android.graphics.Typeface.NORMAL);
		email_edittext.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), Typeface.NORMAL);
		nidname.setEnabled(false);
		username_edittext.setEnabled(false);
		nidnumber.setEnabled(false);
		email_edittext.setEnabled(false);
		dob.setEnabled(false);
		choose_layout.setEnabled(false);
		choose_layout.setVisibility(View.GONE);
		if ("Non verified".equals(verified.getText().toString())) {
			textview6.setVisibility(View.VISIBLE);
		}
		else {
			textview6.setVisibility(View.GONE);
		}
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_IMAGE:
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
				imagePath = _filePath.get((int)(0));
				imageName = Uri.parse(_filePath.get((int)(0))).getLastPathSegment();
				profile_image.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(imagePath, 1024, 1024));
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
		details.edit().putString("nidname", nidname.getText().toString()).commit();
		details.edit().putString("phonenumber", username_edittext.getText().toString()).commit();
		details.edit().putString("address", email_edittext.getText().toString()).commit();
		details.edit().putString("nidnumber", nidnumber.getText().toString()).commit();
		details.edit().putString("dob", dob.getText().toString()).commit();
		details.edit().putString("verified", verified.getText().toString()).commit();
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						finish();
					}
				});
			}
		};
		_timer.schedule(t, (int)(10));
	}
	public void _TransitionManager(final View _view, final double _duration) {
		LinearLayout viewgroup =(LinearLayout) _view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((long)_duration); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
	}
	
	
	public void _email_case() {
		_TransitionManager(content_wrapper, 200);
		email_error.setVisibility(View.VISIBLE);
		email_title.setTextColor(0xFFF44336);
		email_edittext.setTextColor(0xFFF44336);
		final ObjectAnimator backgroundColorAnimator = ObjectAnimator.ofObject(email_base,
		                                                                       "backgroundColor",
		                                                                       new ArgbEvaluator(),
		                                                                       0xffEEEEEE,
		                                                                       0xffF44336);
		backgroundColorAnimator.setDuration(500);
		backgroundColorAnimator.start();
	}
	
	
	public void _username_case() {
		_TransitionManager(content_wrapper, 200);
		username_error.setVisibility(View.VISIBLE);
		Phone_number.setTextColor(0xFFF44336);
		username_edittext.setTextColor(0xFFF44336);
		email_error.setVisibility(View.GONE);
		email_title.setTextColor(0xFFBDBDBD);
		email_base.setBackgroundColor(0xFFBDBDBD);
		final ObjectAnimator backgroundColorAnimator = ObjectAnimator.ofObject(username_base,
		                                                                       "backgroundColor",
		                                                                       new ArgbEvaluator(),
		                                                                       0xffEEEEEE,
		                                                                       0xffF44336);
		backgroundColorAnimator.setDuration(500);
		backgroundColorAnimator.start();
	}
	
	
	public void _bio_case() {
		_TransitionManager(content_wrapper, 200);
		bio_error.setVisibility(View.VISIBLE);
		bio_title.setTextColor(0xFFF44336);
		nidnumber.setTextColor(0xFFF44336);
		email_error.setVisibility(View.GONE);
		email_title.setTextColor(0xFFBDBDBD);
		email_base.setBackgroundColor(0xFFBDBDBD);
		username_error.setVisibility(View.GONE);
		Phone_number.setTextColor(0xFFBDBDBD);
		username_base.setBackgroundColor(0xFFBDBDBD);
		final ObjectAnimator backgroundColorAnimator = ObjectAnimator.ofObject(bio_base,
		                                                                       "backgroundColor",
		                                                                       new ArgbEvaluator(),
		                                                                       0xffEEEEEE,
		                                                                       0xffF44336);
		backgroundColorAnimator.setDuration(500);
		backgroundColorAnimator.start();
	}
	
	
	public void _changeActivityFont(final String _fontname) {
		fontName = "fonts/".concat("solaimanlipi".concat(".ttf"));
		overrideFonts(this,getWindow().getDecorView()); 
	} 
	private void overrideFonts(final android.content.Context context, final View v) {
		
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
