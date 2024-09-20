package com.example.itkmutnbapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CrewStaffFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrewStaffFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    GridView listviewStaff;
    String [] items = {
            "นายไกรมิตร พงษ์นิยะกูล", "นายกฤษณ์ เผือกงาม", "นางลัดดา ตั้งเกียรติศิริ", "นางอุไรวรรณ วัตรยิ่ง", "นายวิวัช รุ่งสว่าง"
    };

    String [] email = {
            "E-mail : kaimit.p@itm.kmutnb.ac.th", "E-mail : krit.p@itm.kmutnb.ac.th" ,
            "E-mail : ladda.t@itm.kmutnb.ac.th" , "E-mail : uraiwan.w@itm.kmutnb.ac.th" , "E-mail : wivach.r@itm.kmutnb.ac.th"
    };

    String [] category = {
            "เจ้าหน้าที่ในภาควิชา", "เจ้าหน้าที่ในภาควิชา", "เจ้าหน้าที่ในภาควิชา",
            "เจ้าหน้าที่ในภาควิชา", "เจ้าหน้าที่ในภาควิชา"
    };
    Integer [] logos = {
            R.drawable.staff1, R.drawable.staff2, R.drawable.staff3,
            R.drawable.staff4, R.drawable.staff5};


    public CrewStaffFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CrewStaffFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CrewStaffFragment newInstance(String param1, String param2) {
        CrewStaffFragment fragment = new CrewStaffFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_crew_staff, container, false);
        // Inflate the layout for this fragment
        CrewStaffFragment.CustomAdapter adapter = new CrewStaffFragment.CustomAdapter(getContext(),items, logos, email, category);
        listviewStaff = rootView.findViewById(R.id.listviewStaff);
        listviewStaff.setAdapter(adapter);
        return rootView;
    }

    class CustomAdapter extends ArrayAdapter<String>
    {
        private final Context context;
        private final String [] items;
        private final Integer [] logos;
        private final String [] email;
        private final String [] category;
        public CustomAdapter(Context ctx, String []items, Integer [] logos, String []email, String []category) {
            super(ctx,R.layout.custom_layout_crew, items);
            this.context = ctx;
            this.items = items;
            this.logos = logos;
            this.email = email;
            this.category = category;
        }
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.custom_layout_crew, null, true);
             TextView title =(TextView) rowView.findViewById(R.id.textView);
             ImageView image = (ImageView) rowView.findViewById(R.id.imageView);
             TextView emailCrew =(TextView) rowView.findViewById(R.id.textViewEmail);
             TextView categoryCrew = (TextView) rowView.findViewById(R.id.textViewCategory);

            title.setText(items[position]);
            image.setImageResource(logos[position]);
            emailCrew.setText(email[position]);
            categoryCrew.setText(category[position]);

            return rowView;
        }
    }
}