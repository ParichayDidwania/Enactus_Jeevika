package android.com.jeevika;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class HomeActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener,
        BookFragment.OnFragmentInteractionListener,HelpFragment.OnFragmentInteractionListener,ProfileFragment.OnFragmentInteractionListener{


    private Toolbar mToolbar;
    private HomeFragment mHomeFragment;
    private ProfileFragment mProfileFragment;
    private BookFragment mBookFragment;
    private HelpFragment mHelpFragment;
    private BottomNavigationView mBottomNavigationView;

    public void gotoAdd(View view)
    {
        Intent i = new Intent(this,AddressActivity.class);
        startActivity(i);
    }

    public void cook(View view)
    {
        Intent i = new Intent(this,AddressActivity.class);
        startActivity(i);
    }

    public void clean(View view)
    {
        Intent i = new Intent(this,AddressActivity.class);
        startActivity(i);
    }

    public void logout(View view)
    {
        Intent i = new Intent(this,StartPage.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mToolbar = findViewById(R.id.home_toolbar);
        mHomeFragment = new HomeFragment();
        mBookFragment = new BookFragment();
        mHelpFragment = new HelpFragment();
        mProfileFragment = new ProfileFragment();
        mBottomNavigationView = findViewById(R.id.home_bottom_nav);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Services");

        if(getIntent().getIntExtra("mode",0)==1) {
            replaceFragment(mBookFragment);
            mBottomNavigationView.getMenu().getItem(1).setChecked(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setTitle("Bookings");
        }
        else
        {
            getSupportActionBar().setTitle("Services");
            replaceFragment(mHomeFragment);
        }

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch(id){
                    case R.id.menu_home_item:
                        getSupportActionBar().setDisplayShowTitleEnabled(false);
                        replaceFragment(mHomeFragment);
                        break;
                    case R.id.menu_booking_item:
                        replaceFragment(mBookFragment);
                        getSupportActionBar().setDisplayShowTitleEnabled(true);
                        getSupportActionBar().setTitle("Bookings");
                        break;
                    case R.id.menu_help_item:
                        replaceFragment(mHelpFragment);
                        getSupportActionBar().setTitle("Contact Us");
                        break;
                    case R.id.menu_profile_item:
                        replaceFragment(mProfileFragment);
                        getSupportActionBar().setTitle("Profile");
                        break;
                    default:
                        return true;


                }
                return true;
            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container,fragment);
        fragmentTransaction.commit();
    }
}
