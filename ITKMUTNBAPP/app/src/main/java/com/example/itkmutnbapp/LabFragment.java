package com.example.itkmutnbapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LabFragment extends Fragment {

    private TextView textLab;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LabFragment newInstance(String param1, String param2) {
        LabFragment fragment = new LabFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_lab, container, false);

        textLab = rootView.findViewById(R.id.textLab);
        textLab.setText("ห้องปฎิบัติการในมหาวิทยาลัยเป็นพื้นที่ที่มีอุปกรณ์และเทคโนโลยีที่ใช้ในการศึกษาและปฏิบัติการที่เกี่ยวข้องกับสาขาวิชาเทคโนโลยีสารสนเทศ เช่น คอมพิวเตอร์, " +
                "และโปรแกรมต่างๆ สร้างขึ้นเพื่อให้นักศึกษาได้ฝึกฝนและประยุกต์ใช้ความรู้ในการทำงานตามหลักการเรียนรู้ที่ได้รับ ลักษณะของห้องปฎิบัติการ มักจะเน้นการทดลองและปฏิบัติจริง" +
                " เพื่อเสริมสร้างทักษะและความเข้าใจที่เกี่ยวข้องกับวิชาชีพในอุตสาหกรรม อีกทั้งยังมีการให้บริการอุปกรณ์และสิ่งอำนวยความสะดวกเพื่อสนับสนุนการเรียนการสอนให้มีประสิทธิภาพสูงสุด");
        return rootView;
    }
}