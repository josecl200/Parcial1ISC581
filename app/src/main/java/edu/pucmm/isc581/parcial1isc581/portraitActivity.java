package edu.pucmm.isc581.parcial1isc581;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class portraitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portrait);
        infoFragment infoFragment = new infoFragment();
        infoFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction()
                .add(android.R.id.content, infoFragment).commit();

    }
}