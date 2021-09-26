package com.example.productivityapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        getActivity().setTitle("Home");
        TextView tvUser= (TextView) view.findViewById(R.id.tvUser);
        TextView tvAssigned = (TextView) view.findViewById(R.id.tvAssigned);

        tvUser.setText("Shelly");
        tvAssigned.setText("Task: Relax:15 min");


        return view;
    }


}
