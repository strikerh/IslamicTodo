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
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class AddTask2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task2);
        ReplaceFont.replaceDefaultFont(this,"DEFAULT","NotoKufiArabic-Regular.ttf");
        Typeface myfont =  Typeface.createFromAsset(this.getAssets(),"NotoKufiArabic-Regular.ttf");
        TextView t = (TextView) findViewById(R.id.textView2);
        t.setTypeface(myfont);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner dd_day = (Spinner)findViewById(R.id.sp_TimeName) ;
        ArrayAdapter<CharSequence> myadapter = ArrayAdapter.createFromResource(this,R.array.TimeNames,android.R.layout.simple_spinner_item);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dd_day.setAdapter(myadapter);




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

}
