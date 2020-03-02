package com.example.myapplication;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class favoriteFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<modelPahlawan> pahlawans = new ArrayList<>();
    public favoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View tampil = inflater.inflate(R.layout.fragment_favorite, container, false);
        recyclerView = tampil.findViewById(R.id.pahlawanku);
        recyclerView.setHasFixedSize(true);
        pahlawans.addAll(dataPahlawan.getListData());

        showRecyclerList();
        return tampil;
    }
    private  void  showRecyclerList(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterPahlawan Adapterpahlawan = new adapterPahlawan(getActivity());
        Adapterpahlawan.setPahlawan(pahlawans);
        recyclerView.setAdapter(Adapterpahlawan);
    }

}
