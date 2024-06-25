package com.example.appnghenhac.fregment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;

import com.example.appnghenhac.R;
import com.example.appnghenhac.activity.PlayListActivity;
import com.example.appnghenhac.adapter.PlayListAdapter;
import com.example.appnghenhac.asynctask.musicService;
import com.example.appnghenhac.model.PlayList;
import com.example.appnghenhac.model.Song;
import com.example.appnghenhac.model.user;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentThuVien#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentThuVien extends Fragment {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public FragmentThuVien() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentThuVien.
     */
    public static FragmentThuVien newInstance(String param1, String param2) {
        FragmentThuVien fragment = new FragmentThuVien();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thu_vien, container, false);
    }

    private FirebaseDatabase data ;
    private DatabaseReference reference ;

    private String root;
    private String leaf = "";

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //        firebase
        root = "user";
        leaf = getUserName(savedInstanceState);
        data = FirebaseDatabase.getInstance();
        reference = data.getReference();

//        button them play list
        Button imageButtonAddPlayList = view.findViewById(R.id.imgbPlayList);
        imageButtonAddPlayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO chức năng thêm play list
                Toast.makeText(getActivity(), "Them playList", Toast.LENGTH_SHORT).show();
            }
        });
//      ListVIew
        ArrayList<PlayList> pl = new ArrayList<>();
        ListView listView = view.findViewById(R.id.listViewPlayList);

        reference.child(root).child(leaf).child("playList").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    PlayList playList = new PlayList(snapshot.getKey(), (String) snapshot.getValue());
                    pl.add(playList);
                }
                PlayListAdapter playListAdapter = new PlayListAdapter(getActivity(), R.layout.list_item_playlist, pl);
                listView.setAdapter(playListAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        PlayList p = pl.get(position);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("playList",p);

                        Intent intent = new Intent(getActivity(),PlayListActivity.class);
                        intent.putExtras(bundle);

                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Firebase", "Error loading data: " + error.getMessage());
            }
        });




////        ghi du lieu
//        Map<String, String> pl = new ArrayMap<>();
//        pl.put("pl001", "s001");
//        pl.put("pl002", "s001,s002");
//
//        user u = new user("tam2", new Date("14/04/2003"), "", "013131313", pl);
//        reference.child("user").child(u.getFullName()).setValue(u);
//
////         Đọc dữ liệu từ Firebase
//        reference.child(root).child(leaf).addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
//                    user user = dataSnapshot.getValue(com.example.appnghenhac.model.user.class);
//                    Log.d("home", user.toString());
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
    }



    private String getUserName(Bundle bundle) {
//        TODO lay user name cua login
        return "tam2";
    }

    public void setSong(Song song) {
//        TODO do no thing
    }
}