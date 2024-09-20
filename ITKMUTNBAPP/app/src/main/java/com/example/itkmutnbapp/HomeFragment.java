package com.example.itkmutnbapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ViewPager viewPager;
    private ImagePagerAdapterHome adapter;
    private int[] images = {R.drawable.news1, R.drawable.news3, R.drawable.news2};

    public HomeFragment() {
        // Required empty public constructor
    }

    private TextView btnLink1, btnLink2, btnLink3, btnLink4, btnLink5, btnLink6, btnLink7, btnLink8, btnLink9, btnLink10;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = rootView.findViewById(R.id.viewPager);
        adapter = new ImagePagerAdapterHome(getContext(), images);
        viewPager.setAdapter(adapter);

        // เริ่มการเปลี่ยนภาพโดยอัตโนมัติทุกๆ 3 วินาที
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 3000);

        btnLink1 = rootView.findViewById(R.id.btnLink1);
        btnLink1.setMovementMethod(LinkMovementMethod.getInstance());
        btnLink1.setOnClickListener(this);
        btnLink2 = rootView.findViewById(R.id.btnLink2);
        btnLink2.setMovementMethod(LinkMovementMethod.getInstance());
        btnLink2.setOnClickListener(this);
        btnLink3 = rootView.findViewById(R.id.btnLink3);
        btnLink3.setMovementMethod(LinkMovementMethod.getInstance());
        btnLink3.setOnClickListener(this);
        btnLink4 = rootView.findViewById(R.id.btnLink4);
        btnLink4.setMovementMethod(LinkMovementMethod.getInstance());
        btnLink4.setOnClickListener(this);
        btnLink5 = rootView.findViewById(R.id.btnLink5);
        btnLink5.setMovementMethod(LinkMovementMethod.getInstance());
        btnLink5.setOnClickListener(this);
        btnLink6 = rootView.findViewById(R.id.btnLink6);
        btnLink6.setMovementMethod(LinkMovementMethod.getInstance());
        btnLink6.setOnClickListener(this);
        btnLink7 = rootView.findViewById(R.id.btnLink7);
        btnLink7.setMovementMethod(LinkMovementMethod.getInstance());
        btnLink7.setOnClickListener(this);
        btnLink8 = rootView.findViewById(R.id.btnLink8);
        btnLink8.setMovementMethod(LinkMovementMethod.getInstance());
        btnLink8.setOnClickListener(this);
        btnLink9 = rootView.findViewById(R.id.btnLink9);
        btnLink9.setMovementMethod(LinkMovementMethod.getInstance());
        btnLink9.setOnClickListener(this);
        btnLink10 = rootView.findViewById(R.id.btnLink10);
        btnLink10.setMovementMethod(LinkMovementMethod.getInstance());
        btnLink10.setOnClickListener(this);


        return rootView;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnLink1) {

            Uri uri = Uri.parse("https://reg.kmutnb.ac.th/registrar/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (id == R.id.btnLink2) {

            Uri uri = Uri.parse("https://reg.kmutnb.ac.th/registrar/timetable");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (id == R.id.btnLink3) {

            Uri uri = Uri.parse("https://acdserv.kmutnb.ac.th/downloads-for-students");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (id == R.id.btnLink4) {

            Uri uri = Uri.parse("https://acdserv.kmutnb.ac.th/academic-calendar");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (id == R.id.btnLink5) {

            Uri uri = Uri.parse("http://202.28.17.14/stdcheck/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (id == R.id.btnLink6) {

            Uri uri = Uri.parse("http://services.regis.kmutnb.ac.th/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (id == R.id.btnLink7) {

            Uri uri = Uri.parse("http://e-service.acdserv.kmutnb.ac.th/regReqDoc/login/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (id == R.id.btnLink8) {

            Uri uri = Uri.parse("https://rco.kmutnb.ac.th/?fbclid=IwAR3yGZdTsAoXls8YSmj19QlxbNCyv95H0tOzTAKk0UFh1-bD0obqzBxWCbc");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (id == R.id.btnLink9) {

            Uri uri = Uri.parse("https://eservices.studentloan.or.th/SLFSTUDENT/html/index.html");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if (id == R.id.btnLink10) {

            Uri uri = Uri.parse("https://software.kmutnb.ac.th/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    }


    class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            if (getActivity() != null) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (viewPager.getCurrentItem() < images.length - 1) {
                            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                        } else {
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        }
    }
}