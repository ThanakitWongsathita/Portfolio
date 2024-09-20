package com.example.itkmutnbapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ActivityFirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActivityFirstFragment extends Fragment {

    private TextView textActivityFirst;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ActivityFirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ActivityFirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ActivityFirstFragment newInstance(String param1, String param2) {
        ActivityFirstFragment fragment = new ActivityFirstFragment();
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

        View rootView = inflater.inflate(R.layout.fragment_activity_first, container, false);

        textActivityFirst = rootView.findViewById(R.id.textActivityFirst);
        textActivityFirst.setText("   มหาวิทยาลัยเทคโนโลยีพระจอมเกล้าพระนครเหนือ ได้จัดทำโครงการสถาบันเทคโนโลยีพระจอมเกล้าพระนครเหนือ วิทยาเขตปราจีนบุรี " +
                "โดยมีวัตถุประสงค์เพื่อขยายโอกาสทางการศึกษาและกระจายฐานบริการระดับอุดมศึกษาด้านวิทยาศาสตร์และเทคโนโลยี ไปสู่จังหวัดปราจีนบุรีและภูมิภาคใกล้เคียงรวมทั้งดำเนินการวิจัยและพัฒนาการฝึกอบรม" +
                "การถ่ายทอดเทคโนโลยีต่างๆ แก่ชุมชนและภาคอุตสาหกรรม");
        return rootView;
    }
}