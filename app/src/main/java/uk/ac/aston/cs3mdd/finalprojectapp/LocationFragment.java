package uk.ac.aston.cs3mdd.finalprojectapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import uk.ac.aston.cs3mdd.finalprojectapp.Tracks.BrandsHatchFragment;
import uk.ac.aston.cs3mdd.finalprojectapp.Tracks.Brands_Hatch_GPFragment;
import uk.ac.aston.cs3mdd.finalprojectapp.Tracks.CroftFragment;
import uk.ac.aston.cs3mdd.finalprojectapp.Tracks.DonningtonFragment;
import uk.ac.aston.cs3mdd.finalprojectapp.Tracks.Donnington_GPFragment;
import uk.ac.aston.cs3mdd.finalprojectapp.Tracks.KnockhillFragment;
import uk.ac.aston.cs3mdd.finalprojectapp.Tracks.Oulton_ParkFragment;
import uk.ac.aston.cs3mdd.finalprojectapp.Tracks.SilverstoneFragment;
import uk.ac.aston.cs3mdd.finalprojectapp.Tracks.SnettertonFragment;
import uk.ac.aston.cs3mdd.finalprojectapp.Tracks.ThruxtonFragment;

public class LocationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_location, container, false);

        Button btnDonnington = view.findViewById(R.id.button_Donnington);
        Button btnBH = view.findViewById(R.id.button_BH);
        Button btnSnetterton = view.findViewById(R.id.button_Snetterton);
        Button btnThruxton = view.findViewById(R.id.button_Thruxton);
        Button btnOP = view.findViewById(R.id.button_Oulton_Park);
        Button btnCroft = view.findViewById(R.id.button_Croft);
        Button btnKnockhill = view.findViewById(R.id.button_Knockhill);
        Button btnDPGP = view.findViewById(R.id.button_Donnington_Park_GP);
        Button btnSilverstone = view.findViewById(R.id.button_Silverstone);
        Button btnBHGP = view.findViewById(R.id.button_Brands_Hatch_GP);

        btnDonnington.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = requireActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout, new DonningtonFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });

        btnBH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = requireActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout, new BrandsHatchFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });

        btnSnetterton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = requireActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout, new SnettertonFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });

        btnThruxton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = requireActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout, new ThruxtonFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });

        btnOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = requireActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout, new Oulton_ParkFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });

        btnCroft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = requireActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout, new CroftFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });

        btnKnockhill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = requireActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout, new KnockhillFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });

        btnDPGP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = requireActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout, new Donnington_GPFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });

        btnSilverstone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = requireActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout, new SilverstoneFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });

        btnBHGP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = requireActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.frame_layout, new Brands_Hatch_GPFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });

        return view;
    }
}