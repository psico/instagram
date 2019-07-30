package com.parse.starter.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.ViewGroup;

import com.parse.starter.R;
import com.parse.starter.fragments.HomeFragment;
import com.parse.starter.fragments.UsuariosFragment;

import java.util.HashMap;

public class TabsAdapter extends FragmentStatePagerAdapter {

    private Context context;
    //    private String[] abas = new String[]{"HOME", "USUÁRIOS"};
    private int[] icones = new int[]{R.drawable.ic_action_home, R.drawable.ic_people};
    private int tamanhoIcone;
    private HashMap<Integer, Fragment> fragmentUtilizados;

    public TabsAdapter(FragmentManager fm, Context c) {
        super(fm);
        this.context = c;
        double escala = this.context.getResources().getDisplayMetrics().density;
        tamanhoIcone = (int) (36 * escala);

        this.fragmentUtilizados = new HashMap<>();

    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new HomeFragment();
                fragmentUtilizados.put(position, fragment);
                break;
            case 1:
                fragment = new UsuariosFragment();
                break;
        }

        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        fragmentUtilizados.remove(position);
    }

    public Fragment getFragment(Integer indice) {
        return fragmentUtilizados.get(indice);
    }

    @Override
    public CharSequence getPageTitle(int position) {
////        //Recuperar o icone de acordo com a posição
////        Drawable drawable = ContextCompat.getDrawable(this.context, icones[position]);
////        drawable.setBounds(0,0,96,96);
////
////        //Permite colocar uma imagem dentro de um texto
////        ImageSpan imageSpan = new ImageSpan(drawable);
////
////        //Classe utilizada para retornar CharSequence
////        SpannableString spannableString = new SpannableString(" ");
////        spannableString.setSpan(imageSpan, 0, spannableString.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
///*
//        return spannableString;*/

        return String.valueOf(icones[position]);
    }

    @Override
    public int getCount() {

        return icones.length;
    }
}
