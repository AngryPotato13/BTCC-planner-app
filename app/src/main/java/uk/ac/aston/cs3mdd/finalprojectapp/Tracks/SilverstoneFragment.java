package uk.ac.aston.cs3mdd.finalprojectapp.Tracks;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import uk.ac.aston.cs3mdd.finalprojectapp.LocationFragment;
import uk.ac.aston.cs3mdd.finalprojectapp.R;

public class SilverstoneFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_silverstone,container, false);

        Button btnback = view.findViewById(R.id.button_back);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = requireActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout, new LocationFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });

        return view;

    }
}