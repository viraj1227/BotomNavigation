package com.example.botomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {
    MeowBottomNavigation meowBottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        meowBottomNavigation=findViewById(R.id.bottom_nav);
        meowBottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_baseline_home_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.ic_baseline_location_on_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.ic_baseline_person_24));
        meowBottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
           @Override
           public void onShowItem(MeowBottomNavigation.Model item) {
               Fragment fragment=null;
               switch(item.getId()){
                   case 1:
                       fragment=new Home_Fragment();
                       break;
                   case 2:
                       fragment=new Location_Fragment();
                       break;
                   case 3:
                       fragment=new User_Fragment();
                       break;
               }
               loadFragment(fragment);
           }
       });
       meowBottomNavigation.show(1,true);
       meowBottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
           @Override
           public void onClickItem(MeowBottomNavigation.Model item) {
               Toast.makeText(getApplicationContext(), "You Clicked" + item.getId(), Toast.LENGTH_SHORT).show();
           }
       });

    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }
}