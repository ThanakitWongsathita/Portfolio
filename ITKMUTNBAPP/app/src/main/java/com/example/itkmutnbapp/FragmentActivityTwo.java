package com.example.itkmutnbapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentActivityTwo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentActivityTwo extends Fragment {

    private TextView textActivityTwo;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentActivityTwo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentActivityTwo.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentActivityTwo newInstance(String param1, String param2) {
        FragmentActivityTwo fragment = new FragmentActivityTwo();
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

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_activity_two, container, false);

        textActivityTwo = rootView.findViewById(R.id.textActivity2);
        textActivityTwo.setText("การสร้างพื้นที่เพื่อการเรียนรู้และแบ่งปันความรู้ ระหว่างนักศึกษาในมหาวิทยาลัยเป็นการสร้างโอกาสให้นักศึกษาได้แลกเปลี่ยนความรู้และแนวคิดใหม่ๆ อันเป็นประโยชน์ต่อผู้เข้าร่วม" +
                " โดยการจัดกิจกรรมอบรมผ่านสื่อการสอนต่างๆ ที่จะส่งเสริมการเรียนรู้และการพัฒนาทักษะ และอาจเป็นแรงจูงใจให้นักศึกษามีส่วนร่วมในการสร้างนวัตกรรมและแก้ปัญหาที่มีอยู่ในสังคมด้วยเทคโนโลยีในอนาคต");

        return rootView;
    }
}