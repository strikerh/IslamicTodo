package com.example.hazemnabil.islamictodo2;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.example.hazemnabil.islamictodo2.spinner.Spinner_adapter;

public class AddTask2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    //////////////////////////
    private Typeface myFont;
    public LinearLayout pnl_week;
    /////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task2);
        ViewGroup gr =(ViewGroup)findViewById(R.id.content_add_task2);

        //--- Font ---
        myFont = Typeface.createFromAsset(getAssets(), "NotoKufiArabic-Regular.ttf");
        ChangeFonts hh = new ChangeFonts(this,gr);


        //--- toolbar ---
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //  ArrayAdapter<CharSequence> myadapter = ArrayAdapter.createFromResource(this,R.array.TimeNames,android.R.layout.simple_spinner_item);
        // ArrayAdapter<CharSequence> myadapter = ArrayAdapter.createFromResource(this,R.array.TimeNames,R.layout.tools_spinner_2);

        // myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //myadapter.setDropDownViewResource(R.layout.tools_spinner);

        //--- Spinners ---
        Spinner_adapter myadapter;
        Spinner dd_day = (Spinner)findViewById(R.id.sp_TimeName) ;
        myadapter = new Spinner_adapter(this,R.array.TimeNames,dd_day,myFont,R.layout.my_spinner_style);
        dd_day.setAdapter(myadapter);

        //////////////////////////////////////////

        Spinner RepeatType = (Spinner) findViewById(R.id.sp_RepeatType);
        //String[] mTestArray = getResources().getStringArray(R.array.TimeNames);
        myadapter = new Spinner_adapter(this,R.array.repeatType,RepeatType,myFont,R.layout.my_spinner_style);
        RepeatType.setAdapter(myadapter);
         pnl_week =   (LinearLayout) findViewById(R.id.pnl_week);
        RepeatType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 Spinner spinner = (Spinner) parent;
                 String value = parent.getItemAtPosition(position).toString();

                 if(position == 1)
                 {
                     pnl_week.setVisibility(View.VISIBLE);
                 }
                 else
                 {
                     pnl_week.setVisibility(View.GONE);
                 }
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {

             }
         });


                //////////////////////////////////////////


//        TextView b = (TextView) dd_day.getSelectedItem();
//        b.setText("sfsfsdf");

                //  Toast.makeText(this,b.toString(),Toast.LENGTH_SHORT).show();
                //  hh.overrideFonts(this,gr);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }







    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_task2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onSwitch_time(View view) {
        Switch sw1 = (Switch) findViewById(R.id.sw_time) ;
        LinearLayout group_time = (LinearLayout) findViewById(R.id.group_time);

        if (sw1.isChecked()){
            group_time.setVisibility(View.VISIBLE);
            sw1.setText("");
        }else{
            group_time.setVisibility(View.GONE);
            sw1.setText("ليس لها وقت محدد");
        }
    }

    public void openCalender(View view) {
        FragmentTransaction manager = getSupportFragmentManager().beginTransaction();
        PopDatePiker pop = new PopDatePiker();
        pop.show( manager,null);


    }
    public  void SetDate(int th,int tm) {
        Toast.makeText(getBaseContext(), "Time is:"+th+":"+tm ,Toast.LENGTH_SHORT).show();
    }

/////////////////////////////////////////////////////////////




}



