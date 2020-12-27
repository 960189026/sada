package com.example.a12_27;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.a12_27.fragment.ClassifyFragment;
import com.example.a12_27.fragment.HomeFragment;
import com.example.a12_27.fragment.MyFragment;
import com.example.a12_27.fragment.ShoppingFragment;
import com.example.a12_27.fragment.SpecialFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private HomeFragment homeFragment;
    private SpecialFragment specialFragment;
    private ClassifyFragment classifyFragment;
    private ShoppingFragment shoppingFragment;
    private MyFragment myFragment;
    private Fragment[] fragments;
    private int lastFragments;
    private ViewPager mVp;
    private TabLayout mTab;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        specialFragment = new SpecialFragment();
        classifyFragment = new ClassifyFragment();
        shoppingFragment = new ShoppingFragment();
        myFragment = new MyFragment();
        fragments = new Fragment[]{homeFragment, specialFragment, classifyFragment, shoppingFragment, myFragment};
        lastFragments = 0;
        getSupportFragmentManager().beginTransaction().replace(R.id.ll,homeFragment).show(homeFragment).commit();
        bottomNavigationView = findViewById(R.id.bnv);
        bottomNavigationView.setOnNavigationItemSelectedListener(changeFragment);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener changeFragment= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId())
            {
                case R.id.menu1:
                {
                    if(lastFragments!=0)
                    {
                        switchFragment(lastFragments,0);
                        lastFragments=0;
                    }
                    return true;
                }
                case R.id.menu2:
                {
                    if(lastFragments!=1)
                    {
                        switchFragment(lastFragments,1);
                        lastFragments=1;

                    }

                    return true;
                }
                case R.id.menu3:
                {
                    if(lastFragments!=2)
                    {
                        switchFragment(lastFragments,2);
                        lastFragments=2;

                    }

                    return true;
                }
                case R.id.menu4:
                {
                    if(lastFragments!=3)
                    {
                        switchFragment(lastFragments,3);
                        lastFragments=3;

                    }

                    return true;
                }
                case R.id.menu5:
                {
                    if(lastFragments!=4)
                    {
                        switchFragment(lastFragments,4);
                        lastFragments=4;

                    }

                    return true;
                }

            }


            return false;
        }
    };


    //切换Fragment
    private void switchFragment(int lastfragment,int index)
    {
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);//隐藏上个Fragment

        if(fragments[index].isAdded()==false)
        {
            transaction.add(R.id.ll,fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }
}