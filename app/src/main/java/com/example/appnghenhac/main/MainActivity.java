package com.example.appnghenhac.main;
/*
@Author :Thanh Tan
 */

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.appnghenhac.R;
import com.example.appnghenhac.fragment.TestPlayFragment;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageSlider imageSlider;
    ImageView playbuttonicon;
    //    GetArtist getArtist = new GetArtist(this);
//    GetUserTop getUserTop = new GetUserTop(this);
//    private TextView textView;
//    private Button btn;
//    private Button btnhistory;
//
//    public void initView() {
//        btn = findViewById(R.id.chuyenhuong);
//        btn.setOnClickListener(v -> {
//            Intent intent = new Intent(this, RatingActivity.class);
//            startActivity(intent);
//        });
//        btnhistory = findViewById(R.id.chuyenhuonglichsu);
//        btnhistory.setOnClickListener(v -> {
//            Intent intent = new Intent(this, HistoryActivity.class);
//            startActivity(intent);
//        });
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initView();
//        initView();
    }
//    public void initView(){
//        /*
//        Dữ liệu để test
//
//         */
//        imageSlider=findViewById(R.id.slider);
//        ArrayList<SlideModel> slideModels=new ArrayList<>();
//        slideModels.add(new SlideModel("https://laodong.vn/van-hoa-giai-tri/lyly-duoc-gi-sau-khi-sang-trung-quoc-nhu-chi-pu-1248302.ldo#&gid=1&pid=1","Lyly", ScaleTypes.CENTER_CROP));
//        slideModels.add(new SlideModel("https://thanhnien.vn/suni-ha-linh-xuat-hien-trong-chuong-trinh-cua-ba-trum-showbiz-xu-trung-185240604004944538.htm#img-lightbox-1","Suni Hạ Linh",ScaleTypes.CENTER_CROP));
//        slideModels.add(new SlideModel("https://www.sggp.org.vn/trang-phap-tru-vung-top-3-nu-nghe-si-anh-huong-nhat-mxh-dau-nam-2024-post742789.html#lg=1&slide=0","Trang Pháp",ScaleTypes.CENTER_CROP));
//        imageSlider.setImageList(slideModels);
//
//    }
//        getArtist.execute();
//        try {
//            FirebaseApp.initializeApp(this);
//            getUserTop.execute();
//        } catch (Exception e) {
//            Log.e("FirebaseInit", "Firebase initialization failed: " + e.getMessage());
//        }
//        addDatatoFirebase();
//        getDatafromFirebase();
//        DeleteDatafromFirebase();
    public void initView(){
    playbuttonicon=findViewById(R.id.playbuttonicon);
    playbuttonicon.setOnClickListener(v -> {
        TestPlayFragment testPlayFragment=new TestPlayFragment();
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragement_playicon,testPlayFragment);
        fragmentTransaction.commit();
    });
    }
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        startMedia();
//    }

//    public void startMedia(){
//        MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.emcuangayhomqua);
//        mediaPlayer.start();
//    }



//    public void getDataFromAsyncTask(JsonObject jsonObject) {
//        if (jsonObject != null) {
//            ArrayList<Music> musicList = new ArrayList<>();
//            // Kiểm tra xem đối tượng JSON có thuộc tính "popularity" không
//            if (jsonObject.has("external_url")) {
//                int popularity = jsonObject.get("external_url").getAsInt();
//                Music musicItem = new Music();
//                musicItem.setPopularity(popularity);
//                musicList.add(musicItem);
//            } else {
//                Log.e("JSON", "Object does not contain 'popularity' attribute");
//            }
//            // Xử lý dữ liệu ở đây
//        }
//    public void getDatafromAsyncTask(String result) {
//        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//        DatabaseReference dbref = firebaseDatabase.getReference("data");
//        dbref.setValue(result, new DatabaseReference.CompletionListener() {
//            @Override
//            public void onComplete(@Nullable @org.jetbrains.annotations.Nullable DatabaseError databaseError, @NonNull @NotNull DatabaseReference databaseReference) {
//                Toast.makeText(MainActivity.this, "them thanh cong", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//}

//    public void addDatatoFirebase() {
//        //tao doi tuong firebasedatabase
//        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//        //doi tuong nay dung de truy van den realtimedatabase
//        DatabaseReference databaseReference = firebaseDatabase.getReference("artist");
//        databaseReference.setValue("Ly ly", new DatabaseReference.CompletionListener() {
//            @Override
//            public void onComplete(@Nullable @org.jetbrains.annotations.Nullable DatabaseError databaseError, @NonNull @NotNull DatabaseReference databaseReference) {
//                Toast.makeText(MainActivity.this, "Them du lieu thanh cong", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
//    public void DeleteDatafromFirebase() {
//        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//        //doi tuong nay dung de truy van den realtimedatabase
//        DatabaseReference databaseReference = firebaseDatabase.getReference("artist");
//        databaseReference.removeValue(new DatabaseReference.CompletionListener() {
//            @Override
//            public void onComplete(@Nullable @org.jetbrains.annotations.Nullable DatabaseError databaseError, @NonNull @NotNull DatabaseReference databaseReference) {
//                Toast.makeText(MainActivity.this,"Xoa thanh cong",Toast.LENGTH_SHORT).show();
//            }
//        });

//doi tuong lang nghe su kien lien quan den truy xuat du lieu trong realtimedatabase
//        ValueEventListener postListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String post = dataSnapshot.getValue(String.class);
//                textView = findViewById(R.id.textdata);
//                textView.setText(post);
//            }
//
//            @Override
//            public void onCancelled(@NonNull @NotNull DatabaseError databaseError) {
//
//            }
//        };

//lay du lieu tu firebase len UI
//    public void getDatafromFirebase() {
//        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//        //doi tuong nay dung de truy van den realtimedatabase
//        DatabaseReference databaseReference = firebaseDatabase.getReference("artist");
//        //doi tuong lang nghe su kien lien quan den truy xuat du lieu trong realtimedatabase
//        ValueEventListener postListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String post = dataSnapshot.getValue(String.class);
//                textView=findViewById(R.id.textdata);
//                textView.setText(post);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                // Hien thi loi trong log
//                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//            }
//        };
//        databaseReference.addValueEventListener(postListener);

