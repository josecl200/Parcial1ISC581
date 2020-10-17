package edu.pucmm.isc581.parcial1isc581;

import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link infoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class infoFragment extends Fragment {
    TextView infoText;
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String INFO_STRING = "Bruh";

    private String infoString;

    public infoFragment() {
        // Required empty public constructor
    }

    public static infoFragment newInstance(String param1) {
        infoFragment fragment = new infoFragment();
        Bundle args = new Bundle();
        args.putString(INFO_STRING, fragment.infoString);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            infoString = getArguments().getString(INFO_STRING);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_info, container, false);
        infoText = view.findViewById(R.id.infoText);
        infoText.setText(infoString);
        return view;
    }

    public void newInfo(String info){
        infoText.setText(info);
    }
}