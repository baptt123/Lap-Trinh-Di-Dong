package com.example.appnghenhac.fregment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.appnghenhac.R;
import com.example.appnghenhac.activity.PlayListActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentThuVien#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentThuVien extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public fragmentThuVien() {
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
    public static fragmentThuVien newInstance(String param1, String param2) {
        fragmentThuVien fragment = new fragmentThuVien();
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Play list
        LinearLayout ln =  view.findViewById(R.id.layoutPlayList);
        setNumberPlay();
        ImageButton imgbPlayList = view.findViewById(R.id.imgbPlayList);

        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PlayListActivity.class);
                startActivity(intent);
            }
        });

        imgbPlayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO chức năng thêm play list
                TextView tv = view.findViewById(R.id.tvPlayList);
                tv.setText(tv.getText()+"+ 1");
            }
        });

    }

    private void setNumberPlay() {
//        TODO thiết lập số lượng play list
    }
}