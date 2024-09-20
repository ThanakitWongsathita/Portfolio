package com.example.itkmutnbapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    ImageButton menuBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment())
                .commit();


        /*getSupportActionBar().setDisplayShowTitleEnabled(false);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.crew) {
                } else if (id == R.id.course) {
                } else if (id == R.id.lab) {
                } else if (id == R.id.classroom) {
                } else if (id == R.id.activity) {
                } else if (id == R.id.location) {
                }
                return false;
            }
        });*/

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        menuBtn = findViewById(R.id.menuBtn);

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle navigation view item clicks here.
                int id = item.getItemId();

                if (id == R.id.menu_crew) {
                    getSupportFragmentManager().popBackStack();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new CrewFragment())
                            .commit();
                } else if (id == R.id.menu_course) {
                    getSupportFragmentManager().popBackStack();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new CourseFragment())
                            .commit();
                } else if (id == R.id.menu_lab) {
                    getSupportFragmentManager().popBackStack();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new LabFragment())
                            .commit();
                } else if (id == R.id.menu_classroom) {
                    getSupportFragmentManager().popBackStack();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new ClassroomFragment())
                            .commit();
                }
                else if (id == R.id.menu_activity) {
                    getSupportFragmentManager().popBackStack();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new ActivityFragment())
                            .commit();
                }

                else if (id == R.id.menu_location) {
                    getSupportFragmentManager().popBackStack();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new LocationFragment())
                            .commit();
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });





        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.menu_home) {
                   //getSupportFragmentManager().popBackStack();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new HomeFragment())
                            .commit();
                    //return true;
                }
                else if (id == R.id.menu_crew) {
                    //getSupportFragmentManager().popBackStack();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new CrewFragment())
                            .commit();
                   // return true;
                }
                else if (id == R.id.menu_course) {
                    //getSupportFragmentManager().popBackStack();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new CourseFragment())
                            .commit();
                    //return true;
                }
                else if (id == R.id.menu_lab) {
                    //getSupportFragmentManager().popBackStack();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new LabFragment())
                            .commit();
                    //return true;
                }
                else if (id == R.id.menu_classroom) {
                    //getSupportFragmentManager().popBackStack();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new ClassroomFragment())
                            .commit();
                    //return true;
                }
                return true;
            }
        });
    }

    /*@Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.head, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}
