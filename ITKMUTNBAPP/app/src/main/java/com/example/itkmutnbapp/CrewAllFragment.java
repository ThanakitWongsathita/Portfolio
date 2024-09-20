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
 * Use the {@link CrewAllFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrewAllFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    GridView listviewAll;
    String [] items = {"ผศ.ดร.ขนิษฐา นามี", "ผศ.ดร.วันทนี ประจวบศุภกิจ", "ผศ.ดร.พาฝัน ดวงไพศาล", "ผศ.สิวาลัย จินเจือ", "ผศ.ดร.สุพาภรณ์ ซิ้มเจริญ",
            "ผศ.พีระศักดิ์ เสรีกุล", "ผศ.สุปีติ กุลจันทร์", "ผศ.ดร. นัฎฐพันธ์ นาคพงษ์", "ผศ.ดร.บีสุดา ดาวเรือง", "รศ.ดร.อนิราช  มิ่งขวัญ",
            "ผศ.สมชัย เชียงพงศ์พันธุ์", "รศ.ดร. ยุพิน สรรพคุณ", "ผศ.อรบุษป์ วุฒิกมลชัย", "อ.ดร.ประดิษฐ์ พิทักษ์เสถียรกุล", "ผศ.นิมิต ศรีคำทา",
            "ผศ.นพดล บูรณ์กุศล", "อ.ดร.วัชรชัย คงศิริวัฒนา", "ผศ.นิติการ นาคเจือทอง", "ผศ.นพเก้า ทองใบ", "อ.ดร.ศรายุทธ ธเนศสกุลวัฒนา",
            "อ.ดร.ศิรินทรา แว่วศรี", "อ.ดร.กาญจน์ ณ ศรีธะ",

            "นายไกรมิตร พงษ์นิยะกูล", "นายกฤษณ์ เผือกงาม", "นางลัดดา ตั้งเกียรติศิริ", "นางอุไรวรรณ วัตรยิ่ง", "นายวิวัช รุ่งสว่าง"




    };

    String [] email = {"E-mail : khanista.n@itm.kmutnb.ac.th ", "E-mail : wanthanee.p@itm.kmutnb.ac.th" , "E-mail : pafan.d@itm.kmutnb.ac.th"
            , "E-mail : siwalai.s@itm.kmutnb.ac.th" , "E-mail : supaporn.s@itm.kmutnb.ac.th" , "E-mail : peerasak.s@itm.kmutnb.ac.th"
            , "E-mail : supeeti.k@itm.kmutnb.ac.th" , "E-mail : nuttapun.n@itm.kmutnb.ac.th" , "E-mail : beesuda.d@itm.kmutnb.ac.th"
            , "E-mail : anirach.m@itm.kmutnb.ac.th" , "E-mail : somchai.c@itm.kmutnb.ac.th" , "E-mail : yupin.s@itm.kmutnb.ac.th"
            , "E-mail : oraboot.w@itm.kmutnb.ac.th" , "E-mail : pradit.p@itm.kmutnb.ac.th" , "E-mail : nimit.s@itm.kmutnb.ac.th"
            , "E-mail : noppadon.b@itm.kmutnb.ac.th" , "E-mail : watcharachai.k@itm.kmutnb.ac.th" , "E-mail : nitigan.n@itm.kmutnb.ac.th"
            , "E-mail : nopphagaw.t@itm.kmutnb.ac.th" , "E-mail : sarayoot.t@itm.kmutnb.ac.th" , "E-mail : sirintra.v@itm.kmutnb.ac.th"
            , "E-mail : karn.n@itm.kmutnb.ac.th",
            "E-mail : kaimit.p@itm.kmutnb.ac.th", "E-mail : krit.p@itm.kmutnb.ac.th" ,
            "E-mail : ladda.t@itm.kmutnb.ac.th" , "E-mail : uraiwan.w@itm.kmutnb.ac.th" , "E-mail : wivach.r@itm.kmutnb.ac.th"




    };

    String [] category = {"หัวหน้าภาควิชา", "อาจารย์ทำหน้าที่ธุรการด้านวิจัย", "อาจารย์ทำหน้าที่ธุรการด้านวิชาการ", "อาจารย์ทำหน้าที่ธุรการด้านกิจการนักศึกษา", "อาจารย์ทำหน้าที่ธุรการด้านงานประกันคุณภาพการศึกษา",
            "รองอธิการบดีวิทยาเขตปราจีนบุรี", "รองคณบดีฝ่ายสื่อสารองค์กรและอุตสาหกรรมสัมพันธ์", "รองคณบดีฝ่ายกิจการพิเศษ", "ผู้ช่วยผู้อำนวยการฝ่ายเทคโนโลยีสารสนเทศ วิทยาเขตปราจีนบุรี", "อาจารย์ในภาควิชา ",
            "อาจารย์ในภาควิชา ", "อาจารย์ในภาควิชา ", "อาจารย์ในภาควิชา ", "อาจารย์ในภาควิชา ", "อาจารย์ในภาควิชา ",
            "อาจารย์ในภาควิชา ", "อาจารย์ในภาควิชา ", "อาจารย์ในภาควิชา ", "อาจารย์ในภาควิชา ", "อาจารย์ในภาควิชา ",
            "อาจารย์ในภาควิชา ", "อาจารย์ในภาควิชา ",
            "เจ้าหน้าที่ในภาควิชา", "เจ้าหน้าที่ในภาควิชา", "เจ้าหน้าที่ในภาควิชา",
            "เจ้าหน้าที่ในภาควิชา", "เจ้าหน้าที่ในภาควิชา"




    };
    Integer [] logos = {
            R.drawable.personnel0, R.drawable.personnel1, R.drawable.personnel2, R.drawable.personnel3, R.drawable.personnel4,
            R.drawable.personnel5, R.drawable.personnel6, R.drawable.personnel7, R.drawable.personnel8, R.drawable.personnel9,
            R.drawable.personnel10, R.drawable.personnel11, R.drawable.personnel12, R.drawable.personnel13, R.drawable.personnel14,
            R.drawable.personnel15, R.drawable.personnel16, R.drawable.personnel17, R.drawable.personnel18, R.drawable.personnel19,
            R.drawable.personnel20, R.drawable.personnel21,
            R.drawable.staff1, R.drawable.staff2, R.drawable.staff3,
            R.drawable.staff4, R.drawable.staff5};



    public CrewAllFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CrewAllFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CrewAllFragment newInstance(String param1, String param2) {
        CrewAllFragment fragment = new CrewAllFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_crew_all, container, false);
        // Inflate the layout for this fragment
        CustomAdapter adapter = new CustomAdapter(getContext(),items, logos, email, category);
        listviewAll = rootView.findViewById(R.id.listviewAll);
        listviewAll.setAdapter(adapter);
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
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView title =(TextView) rowView.findViewById(R.id.textView);
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView image = (ImageView) rowView.findViewById(R.id.imageView);
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView emailCrew =(TextView) rowView.findViewById(R.id.textViewEmail);
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView categoryCrew = (TextView) rowView.findViewById(R.id.textViewCategory);

            title.setText(items[position]);
            image.setImageResource(logos[position]);
            emailCrew.setText(email[position]);
            categoryCrew.setText(category[position]);

            return rowView;
        }
    }
}