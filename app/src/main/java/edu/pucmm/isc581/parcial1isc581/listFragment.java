package edu.pucmm.isc581.parcial1isc581;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class listFragment extends Fragment {

    String[] conceptNames = {"SDK","NDK","JVM","Actividad","Fragmento","Ciclo de vida"};
    String[] conceptInfos = {"Lo del SDK", "Lo del NDK", "Lo del JVM", "Lo del Actividad", "Lo del fragmento", "Lo del CDV"};

    public listFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ListView lista = view.findViewById(R.id.conceptoNameList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,conceptNames);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener((adapterView,v,i,l) -> {
            if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){
                Intent intent = new Intent();
                intent.setClass(getActivity(), portraitActivity.class);
                intent.putExtra("INFO", conceptInfos[i]);
                startActivity(intent);
            }else{
                infoFragment infoFragment = (edu.pucmm.isc581.parcial1isc581.infoFragment) getFragmentManager().findFragmentById(R.id.fragment2);
                infoFragment.newInfo(conceptInfos[i]);
            }

        });

        return view;
    }
}