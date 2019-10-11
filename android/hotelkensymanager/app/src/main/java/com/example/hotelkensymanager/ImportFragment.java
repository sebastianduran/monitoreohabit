package com.example.hotelkensymanager;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImportFragment extends Fragment {

    private ImportAdapter importAdapter;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private TextView textView;
    private Button button;

    private ArrayList<Ocupacion> ocupacionArrayList;

    FirebaseDatabase database;
    DatabaseReference mRef;

    public ImportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_import, container, false);

        textView = view.findViewById(R.id.text_habitacion);
        button = view.findViewById(R.id.btn_presencia);

        database = FirebaseDatabase.getInstance();

        mRef = database.getReference("ocupacion");

        final Ocupacion ocupacion = new Ocupacion();

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ocupacion.setHabitacion(2013);
                ocupacion.setPresencia(dataSnapshot.child("2013").getValue(Integer.class));
                textView.setText(String.valueOf(ocupacion.getHabitacion()));
                if (ocupacion.isPresencia()<173){
                    button.setBackgroundColor(Color.LTGRAY);
                }else {
                    button.setBackgroundColor(Color.GREEN);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    

}
