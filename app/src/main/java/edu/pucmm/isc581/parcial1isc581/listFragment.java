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

    String[] conceptNames = {"SDK","NDK","JVM","Actividad","Fragmento","Ciclo de vida", "NullPointerException", "API Level"};
    String[] conceptInfos = {
            "Un kit de desarrollo de software (en inglés, software development kit o SDK) es generalmente un conjunto de herramientas de desarrollo de software que permite a un desarrollador de software crear una aplicación informática para un sistema concreto,",
            "El NDK permite instalar bibliotecas escritas en C, C++ y otros lenguajes, una vez compiladas para ARM, MIPS o código nativo x86.",
            " es una máquina virtual de proceso nativo, es decir, ejecutable en una plataforma específica, capaz de interpretar y ejecutar instrucciones expresadas en un código binario especial (el bytecode Java), el cual es generado por el compilador del lenguaje Java.",
            "La clase Activity es un componente crucial de una aplicación de Android, y la forma en que se inician y combinan las actividades es una parte fundamental del modelo de aplicación de la plataforma.",
            "Android introdujo fragmentos en Android 3.0 (API nivel 11), principalmente para admitir diseños de IU más dinámicos y flexibles en pantallas grandes, como tabletas. Debido a que la pantalla de una tableta es mucho más grande que la de un teléfono, hay más espacio para combinar e intercambiar componentes de la interfaz de usuario. Los fragmentos permiten este tipo de diseños sin la necesidad de administrar cambios complejos en la jerarquía de vistas. Al dividir el diseño de una actividad en fragmentos, puede modificar la apariencia de la actividad en tiempo de ejecución y conservar esos cambios en una pila de actividades administrada por la actividad.",
            "A lo largo de su vida, una actividad pasa por varios estados. Utiliza una serie de callbacks para manejar las transicones entre estados.",
            "Excepción lanzada cuando una aplicación trata de utilizar null donde se necesita algún objeto.",
            "Esto se refiere a la minima version del sistema operativo donde se soporta una caracteristica o una aplicación."
    };

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
                intent.putExtra("TITLE", conceptNames[i]);

                startActivity(intent);
            }else{
                infoFragment infoFragment = (edu.pucmm.isc581.parcial1isc581.infoFragment) getFragmentManager().findFragmentById(R.id.fragment2);
                infoFragment.newInfo(conceptInfos[i]);
            }

        });

        return view;
    }
}