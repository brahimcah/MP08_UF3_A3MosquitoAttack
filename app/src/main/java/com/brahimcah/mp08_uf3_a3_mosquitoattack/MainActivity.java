package com.brahimcah.mp08_uf3_a3_mosquitoattack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView puntuacio;
    ImageView iv_mosquit;
    AnimationDrawable mosquit_animat;
    ConstraintLayout main_screen;
    int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        puntuacio = (TextView) findViewById(R.id.puntuacio);

        animacioMosquit();
        cambiarPosicio();
    }
    private void animacioMosquit() {
        mosquit_animat = new AnimationDrawable();
        iv_mosquit = (ImageView) findViewById(R.id.mosquit);

        iv_mosquit.setX(100);
        iv_mosquit.setY(150);

        iv_mosquit.setBackgroundResource(R.drawable.mosquit_animat);

        mosquit_animat = (AnimationDrawable) iv_mosquit.getBackground();

        mosquit_animat.start();

        iv_mosquit.setOnClickListener(view -> {
            //do{
            iv_mosquit.setBackgroundResource(R.drawable.sang_animat);
            mosquit_animat = (AnimationDrawable) iv_mosquit.getBackground();
            mosquit_animat.start();
            contador++;
            String s = String.valueOf(contador);
            puntuacio.setText(s);
            //} while(contador != 10); e intetntar fer un dowhile perque es generi un cop i despres cambi pero no men surtu
        });
    }

    public void cambiarPosicio(){

        Random r = new Random();

        float X = 600;
        float Y = 1200;

        float random = X + r.nextFloat() * (X - Y);
        float random2 = X + r.nextFloat() * (X - Y);

        iv_mosquit.setX(random);
        iv_mosquit.setY(random2);

    }

}
