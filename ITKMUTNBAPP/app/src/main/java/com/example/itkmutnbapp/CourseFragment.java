package com.example.itkmutnbapp;

import android.content.Intent;
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
 * Use the {@link CourseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CourseFragment extends Fragment implements View.OnClickListener {

    private TextView link_course1, link_course2;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CourseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CourseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CourseFragment newInstance(String param1, String param2) {
        CourseFragment fragment = new CourseFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_course, container, false);

        link_course1 = rootView.findViewById(R.id.link_course1);
        link_course1.setMovementMethod(LinkMovementMethod.getInstance());
        link_course1.setOnClickListener(this);

        link_course2 = rootView.findViewById(R.id.link_course2);
        link_course2.setMovementMethod(LinkMovementMethod.getInstance());
        link_course2.setOnClickListener(this);


        link_course2.setText("หลักสูตรอุตสาหกรรมศาสตรบัณฑิต สาขาวิชาเทคโนโลยีสารสนเทศ (ต่อเนื่อง)(หลักสูตรปรับปรุง พ.ศ. 2566)รายละเอียดเป็นPDF");
        link_course1.setText("หลักสูตร 4 ปี จำนวน 127 หน่วยกิต รับผู้สำเร็จการศึกษาระดับ มัธยมศึกษาปีที่ 6 และประกาศนียบัตรวิชาชีพ (ปวช.) รายละเอียดเป็นPDF");

        return rootView;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.link_course1) {

            Uri uri = Uri.parse("https://drive.google.com/file/d/1PkomciSpFhaKyS8lZ3PHlII2b_z5knVz/view");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (id == R.id.link_course2) {

            Uri uri = Uri.parse("https://drive.google.com/file/d/1tKTmxarjSWgGPG-XI0aIe9QwL4OV1ZWM/view");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    }

}