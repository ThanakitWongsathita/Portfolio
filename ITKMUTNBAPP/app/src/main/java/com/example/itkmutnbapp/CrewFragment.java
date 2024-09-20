package com.example.itkmutnbapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CrewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrewFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView textTopic, textCategoryAll, textCategoryTeacher, textCategoryStaff;

    public CrewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CrewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CrewFragment newInstance(String param1, String param2) {
        CrewFragment fragment = new CrewFragment();
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
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_crew, container, false);

        textTopic = rootView.findViewById(R.id.textTopic);
        textCategoryAll = rootView.findViewById(R.id.textCategoryAll);
        textCategoryAll.setOnClickListener(this);

        textCategoryTeacher = rootView.findViewById(R.id.textCategoryTeacher);
        textCategoryTeacher.setOnClickListener(this);

        textCategoryStaff = rootView.findViewById(R.id.textCategoryStaff);
        textCategoryStaff.setOnClickListener(this);

        CrewAllFragment crewAllFragment = new CrewAllFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container_crew, crewAllFragment);
        transaction.addToBackStack(null);
        transaction.commit();


        return rootView;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.textCategoryAll) {

            textCategoryTeacher.setTextColor(Color.WHITE);
            textCategoryStaff.setTextColor(Color.WHITE);

            textTopic.setText("บุคลากรทั้งหมด");
            textCategoryAll.setTextColor(Color.BLACK);

            CrewAllFragment crewAllFragment = new CrewAllFragment();
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container_crew, crewAllFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

        else if  (id == R.id.textCategoryTeacher) {

            textCategoryAll.setTextColor(Color.WHITE);
            textCategoryStaff.setTextColor(Color.WHITE);

            textTopic.setText("อาจารย์ในภาควิชา");
            textCategoryTeacher.setTextColor(Color.BLACK);

            CrewTeacherFragment crewTeacherFragment = new CrewTeacherFragment();
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container_crew, crewTeacherFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

        else if  (id == R.id.textCategoryStaff) {

            textCategoryTeacher.setTextColor(Color.WHITE);
            textCategoryAll.setTextColor(Color.WHITE);

            textTopic.setText("เจ้าหน้าที่ในภาควิชา");
            textCategoryStaff.setTextColor(Color.BLACK);

            CrewStaffFragment crewStaffFragment = new CrewStaffFragment();
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container_crew, crewStaffFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }


}