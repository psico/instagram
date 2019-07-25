package com.parse.starter.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.parse.starter.fragments.HomeFragment;
import com.parse.starter.fragments.UsuariosFragment;

public class TabsAdapter extends FragmentStatePagerAdapter {

    private Context context;
    private String[] abas = new String[]{"HOME", "USUÁRIOS"};

    public TabsAdapter(FragmentManager fm, Context c) {
        super(fm);
        this.context = c;

    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new UsuariosFragment();
                break;
        }

        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return abas[ position ];
    }

    @Override
    public int getCount() {
        return abas.length;
    }
}
