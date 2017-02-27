package com.example.goldenblue.fragmentwithimagesmanual;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.goldenblue.fragmentwithimagesmanual.fragments.FragmentImage;
import com.example.goldenblue.fragmentwithimagesmanual.fragments.FragmentLogin;
import com.example.goldenblue.fragmentwithimagesmanual.fragments.FragmentMaterial;
import com.example.goldenblue.fragmentwithimagesmanual.fragments.FragmentRating;
import com.example.goldenblue.fragmentwithimagesmanual.fragments.FragmentScrolling;
import com.example.goldenblue.fragmentwithimagesmanual.fragments.FragmentSignUp;
import com.example.goldenblue.fragmentwithimagesmanual.fragments.FragmentSquares;
import com.example.goldenblue.fragmentwithimagesmanual.fragments.FragmentTime;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar fragment_rating clicks here. The action bar will
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


        Class fragmentClass = null;

        // Handle navigation view fragment_rating clicks here.
        int id = item.getItemId();

        if (id == R.id.blocks) {
            fragmentClass = FragmentMaterial.class;

        } else if (id == R.id.picture) {
            fragmentClass = FragmentImage.class;

        } else if (id == R.id.squares) {
            fragmentClass = FragmentSquares.class;

        } else if (id == R.id.scrolling) {
            fragmentClass = FragmentScrolling.class;

        } else if (id == R.id.login) {
            fragmentClass = FragmentLogin.class;

        } else if (id == R.id.signup) {
            fragmentClass = FragmentSignUp.class;

        } else if (id == R.id.ratingBar){
            fragmentClass = FragmentRating.class;

        } else if (id == R.id.Time) {
            fragmentClass = FragmentTime.class;
        }

        replaceFragment(fragmentClass);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void replaceFragment (Class fragmentClass)
    {
        Fragment fragment = null;

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    public void replaceWithSignup (View view) {
        replaceFragment(FragmentSignUp.class);
    }

    public void replaceWithLogin (View view) {
        replaceFragment(FragmentLogin.class);
    }
}


