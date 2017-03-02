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

import com.example.hazemnabil.islamictodo2.spinner.Spinner_adapter;

public class AddTask2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    //////////////////////////
    private Typeface myFont;
    public LinearLayout pnl_week;

    private GroupSection sTime ;

    private GroupSection sRepeat ;
    private GroupSection sImportant ;
    private GroupSection sSubtasks;

    /////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task2);
        ViewGroup gr =(ViewGroup)findViewById(R.id.content_add_task2);


          sTime = new GroupSection(
                R.id.TimeSection, R.id.TimeTitle, R.id.TimeTitleTxt, R.id.TimeTitleSw, R.id.TimeBox);

          sRepeat = new GroupSection(
                R.id.RepeatSection, R.id.RepeatTitle, R.id.RepeatTitleTxt, R.id.RepeatTitleSw, R.id.RepeatBox);

          sImportant = new GroupSection(
                R.id.ImportantSection, R.id.ImportantTitle, R.id.ImportantTitleTxt, R.id.ImportantTitleSw, R.id.ImportantBox);

          sSubtasks = new GroupSection(
                R.id.SubTasksSection, R.id.SubTasksTitle, R.id.SubTasksTitleTxt, R.id.SubTasksTitleSw, R.id.SubTasksBox);



        //--- Font ---
        myFont = Typeface.createFromAsset(getAssets(), "NotoKufiArabic-Regular.ttf");
        ChangeFonts hh = new ChangeFonts(this,gr);


        //--- toolbar ---
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //--- Close Groups ---
        CloseAllGroups();


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


    // ---- Group Switchs (Show & Hide Groups)  -----
    private void CloseAllGroups() {  //in OnCreate up
        LinearLayout h1 = (LinearLayout) findViewById(sTime.secBox_id);
        LinearLayout h2 = (LinearLayout) findViewById(sRepeat.secBox_id);
        LinearLayout h3 = (LinearLayout) findViewById(sImportant.secBox_id);
        LinearLayout h4 = (LinearLayout) findViewById(sSubtasks.secBox_id);
        h1.setVisibility(View.GONE);
        h2.setVisibility(View.GONE);
        h3.setVisibility(View.GONE);
        h4.setVisibility(View.GONE);

    }

class  GroupSection {
    public int mainSec_id;
    public int secTitle_id;
    public int title_txt_id;
    public int title_switch_id;
    public int title_icon_id;
    public int secBox_id;

    public String title_swich_txt;
    public String title_txt_txt;

    public GroupSection(int mainSec_id){

    }
    public GroupSection(int mainSec_id,int secTitle_id, int title_txt_id, int title_switch_id, int secBox_id) {
        this.mainSec_id = mainSec_id;
        this.secTitle_id = secTitle_id;
        this.title_txt_id = title_txt_id;
        this.title_switch_id = title_switch_id;
        this.title_icon_id = title_icon_id;
        this.secBox_id = secBox_id;
    }
}


    public void onSwitch_time(View view) {
        Switchat(sTime.title_switch_id,sTime.secBox_id,"ليس لها وقت محدد");
    }
    public void onSwitch_repeat(View view) {
        Switchat(sRepeat.title_switch_id,sRepeat.secBox_id,"غير مكرر");
    }
    public void onSwitch_important(View view) {
        Switchat(sImportant.title_switch_id,sImportant.secBox_id,"غير محدد");
    }
    public void onSwitch_subtasks(View view) {
        Switchat(sSubtasks.title_switch_id,sSubtasks.secBox_id,"ليس بها مهام فرعية");
    }

    private void Switchat(int swichName,int parentGroup,String txt){
        Switch sw1 = (Switch) findViewById(swichName) ;
        LinearLayout group_time = (LinearLayout) findViewById(parentGroup);

        if (sw1.isChecked()){
            group_time.setVisibility(View.VISIBLE);
            sw1.setText("");

        }else{
            group_time.setVisibility(View.GONE);
            sw1.setText(txt);
        }
    }
    // --------- END -------------- Group Switchs (Show & Hide Groups)  ----- /\


    // ---- Show POPs windows (DatePiker - TimePiker)  ----- \/
    public void openCalender(View view) {
        FragmentTransaction manager = getSupportFragmentManager().beginTransaction();
        PopDatePiker pop = new PopDatePiker();
        pop.SetOutputLocation(R.id.txt_date);
        pop.show( manager,null);


    }

    public void openCalender2(View view) {
        FragmentTransaction manager = getSupportFragmentManager().beginTransaction();
        PopDatePiker pop = new PopDatePiker();
        pop.SetOutputLocation(R.id.repeatDate);
        pop.show( manager,null);


    }

    public void openTimePiker(View view) {
        FragmentTransaction manager = getSupportFragmentManager().beginTransaction();
        PopTimePiker pop = new PopTimePiker();
        pop.SetOutputLocation(R.id.txt_time);
        pop.show( manager,null);


    }


/////////////////////////////////////////////////////////////




}



