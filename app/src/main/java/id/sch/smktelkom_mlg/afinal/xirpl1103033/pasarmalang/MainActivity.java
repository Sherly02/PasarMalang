package id.sch.smktelkom_mlg.afinal.xirpl1103033.pasarmalang;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import id.sch.smktelkom_mlg.afinal.xirpl1103033.pasarmalang.fragment.FavoriteFragment;
import id.sch.smktelkom_mlg.afinal.xirpl1103033.pasarmalang.fragment.MapFragment;
import id.sch.smktelkom_mlg.afinal.xirpl1103033.pasarmalang.fragment.PriceFragment;

public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_price:
                    toolbar.setTitle("Pasar Malang");
                    fragment = new PriceFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_favorite:
                    toolbar.setTitle("Pasar Malang - Favorit");
                    fragment = new FavoriteFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_map:
                    toolbar.setTitle("Pasar Malang - Lokasi");
                    fragment = new MapFragment();
                    loadFragment(fragment);
                    return true;
            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportActionBar().setTitle("Pasar Malang");
        loadFragment(new PriceFragment());

    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
