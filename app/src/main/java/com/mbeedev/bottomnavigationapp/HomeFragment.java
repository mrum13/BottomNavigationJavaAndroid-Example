package com.mbeedev.bottomnavigationapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment implements View.OnClickListener {
    Button btnKeSms;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        btnKeSms = root.findViewById(R.id.btn_ke_sms);

        btnKeSms.setOnClickListener(this);

        return root;
    }


    @Override
    public void onClick(View v) {
        Intent keSMS = new Intent(getActivity(), MainActivity.class);
        keSMS.putExtra("sms","sms");
        startActivity(keSMS);
//        getActivity().finish();
    }
}