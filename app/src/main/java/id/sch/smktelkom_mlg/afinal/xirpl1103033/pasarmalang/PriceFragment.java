package id.sch.smktelkom_mlg.afinal.xirpl1103033.pasarmalang;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PriceFragment extends Fragment {

    public PriceFragment() {
        // Required empty public constructor
    }

    public static PriceFragment newInstance(String param1, String param2) {
        PriceFragment fragment = new PriceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_price, container, false);
    }

}
