package com.example.itkmutnbapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClassroomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClassroomFragment extends Fragment {

    private TextView textClassroom;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ClassroomFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClassroomFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClassroomFragment newInstance(String param1, String param2) {
        ClassroomFragment fragment = new ClassroomFragment();
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

        View rootView = inflater.inflate(R.layout.fragment_classroom, container, false);

        textClassroom = rootView.findViewById(R.id.textClassroom);
        textClassroom.setText("ห้องเรียนในมหาวิทยาลัยเป็นพื้นที่สำหรับการเรียนรู้และสอนซึ่งมักจะมีโต๊ะและเก้าอี้ กระดานไวท์บอร์ดหรือจอภาพ เครื่องปรับอากาศ และอุปกรณ์เสริมการเรียนการสอน " +
                "เช่น คอมพิวเตอร์ โปรเจ็กเตอร์ และหนังสือ เพื่อสนับสนุนการศึกษาและการทำงานในห้องเรียนให้มีประสิทธิภาพสูงสุด ทั้งนี้ยังมีการจัดระเบียบพื้นที่เพื่อให้สอดคล้องกับกิจกรรมการเรียนรู้และการสอนอย่างเหมาะสม " +
                "และมักมีสิ่งอำนวยความสะดวกเพิ่มเติมเพื่อสร้างสภาพแวดล้อมที่เอื้อต่อการเรียนรู้ในนักศึกษาในมหาวิทยาลัย");
        return rootView;
    }
}