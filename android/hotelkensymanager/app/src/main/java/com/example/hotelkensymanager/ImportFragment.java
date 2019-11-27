package com.example.hotelkensymanager;


import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
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
    private Button btn00, btn01, btn02, btn03, btn10, btn11, btn12, btn13, btn20, btn21, btn22, btn23, btn30, btn31, btn32, btn33;


    private ArrayList<Ocupacion> ocupacionArrayList;

    float temp = 22.0f;

    FirebaseDatabase database;
    DatabaseReference mRef, refhab213, refHumo;

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
        btn00 = view.findViewById(R.id.hab213_m00);
        btn01 = view.findViewById(R.id.hab213_m01);
        btn02 = view.findViewById(R.id.hab213_m02);
        btn03 = view.findViewById(R.id.hab213_m03);
        btn10 = view.findViewById(R.id.hab213_m10);
        btn11 = view.findViewById(R.id.hab213_m11);
        btn12 = view.findViewById(R.id.hab213_m12);
        btn13 = view.findViewById(R.id.hab213_m13);
        btn20 = view.findViewById(R.id.hab213_m20);
        btn21 = view.findViewById(R.id.hab213_m21);
        btn22 = view.findViewById(R.id.hab213_m22);
        btn23 = view.findViewById(R.id.hab213_m23);
        btn30 = view.findViewById(R.id.hab213_m30);
        btn31 = view.findViewById(R.id.hab213_m31);
        btn32 = view.findViewById(R.id.hab213_m32);
        btn33 = view.findViewById(R.id.hab213_m33);

        database = FirebaseDatabase.getInstance();

        mRef = database.getReference("ocupacion");
        refhab213 = database.getReference("ocupacion").child("213");
        refHumo = database.getReference("Alerta");

        final Ocupacion ocupacion = new Ocupacion();
        final d6t44l ocu213 = new d6t44l();

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ocupacion.setHabitacion(2013);
                ocupacion.setPresencia(dataSnapshot.child("2013").getValue(Integer.class));
                textView.setText(String.valueOf(ocupacion.getHabitacion()));
                temp = (ocupacion.isPresencia() * 0.10f )+ 4.0f;
                if (ocupacion.isPresencia()<220){
                    button.setBackgroundColor(Color.LTGRAY);
                }else {
                    button.setBackgroundColor(Color.GREEN);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        refhab213.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ocu213.setHabitacion("213");
                ocu213.setM00(dataSnapshot.child("00").getValue(Float.class));
                if (ocu213.getM00()<temp){
                    btn00.setBackgroundColor(Color.LTGRAY);
                }else {
                    btn00.setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        refhab213.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ocu213.setHabitacion("213");
                ocu213.setM01(dataSnapshot.child("01").getValue(Float.class));
                if (ocu213.getM01()<temp){
                    btn01.setBackgroundColor(Color.LTGRAY);
                }else {
                    btn01.setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        refhab213.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ocu213.setHabitacion("213");
                ocu213.setM02(dataSnapshot.child("02").getValue(Float.class));
                if (ocu213.getM02()<temp){
                    btn02.setBackgroundColor(Color.LTGRAY);
                }else {
                    btn02.setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        refhab213.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ocu213.setHabitacion("213");
                ocu213.setM03(dataSnapshot.child("03").getValue(Float.class));
                if (ocu213.getM03()<temp){
                    btn03.setBackgroundColor(Color.LTGRAY);
                }else {
                    btn03.setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        refhab213.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ocu213.setHabitacion("213");
                ocu213.setM10(dataSnapshot.child("10").getValue(Float.class));
                if (ocu213.getM10()<temp){
                    btn10.setBackgroundColor(Color.LTGRAY);
                }else {
                    btn10.setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        refhab213.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ocu213.setHabitacion("213");
                ocu213.setM11(dataSnapshot.child("11").getValue(Float.class));
                if (ocu213.getM11()<temp){
                    btn11.setBackgroundColor(Color.LTGRAY);
                }else {
                    btn11.setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        refhab213.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ocu213.setHabitacion("213");
                ocu213.setM12(dataSnapshot.child("12").getValue(Float.class));
                if (ocu213.getM12()<temp){
                    btn12.setBackgroundColor(Color.LTGRAY);
                }else {
                    btn12.setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        refhab213.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ocu213.setHabitacion("213");
                ocu213.setM13(dataSnapshot.child("13").getValue(Float.class));
                if (ocu213.getM13()<temp){
                    btn13.setBackgroundColor(Color.LTGRAY);
                }else {
                    btn13.setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        refhab213.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ocu213.setHabitacion("213");
                ocu213.setM20(dataSnapshot.child("20").getValue(Float.class));
                if (ocu213.getM20()<temp){
                    btn20.setBackgroundColor(Color.LTGRAY);
                }else {
                    btn20.setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        refhab213.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ocu213.setHabitacion("213");
                ocu213.setM21(dataSnapshot.child("21").getValue(Float.class));
                if (ocu213.getM21()<temp){
                    btn21.setBackgroundColor(Color.LTGRAY);
                }else {
                    btn21.setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        refhab213.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ocu213.setHabitacion("213");
                ocu213.setM22(dataSnapshot.child("22").getValue(Float.class));
                if (ocu213.getM22()<temp){
                    btn22.setBackgroundColor(Color.LTGRAY);
                }else {
                    btn22.setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        refhab213.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ocu213.setHabitacion("213");
                ocu213.setM23(dataSnapshot.child("23").getValue(Float.class));
                if (ocu213.getM23()<temp){
                    btn23.setBackgroundColor(Color.LTGRAY);
                }else {
                    btn23.setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        refhab213.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ocu213.setHabitacion("213");
                ocu213.setM30(dataSnapshot.child("30").getValue(Float.class));
                if (ocu213.getM30()<temp){
                    btn30.setBackgroundColor(Color.LTGRAY);
                }else {
                    btn30.setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        refhab213.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ocu213.setHabitacion("213");
                ocu213.setM31(dataSnapshot.child("31").getValue(Float.class));
                if (ocu213.getM31()<temp){
                    btn31.setBackgroundColor(Color.LTGRAY);
                }else {
                    btn31.setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        refhab213.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ocu213.setHabitacion("213");
                ocu213.setM32(dataSnapshot.child("32").getValue(Float.class));
                if (ocu213.getM32()<temp){
                    btn32.setBackgroundColor(Color.LTGRAY);
                }else {
                    btn32.setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        refhab213.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ocu213.setHabitacion("213");
                ocu213.setM33(dataSnapshot.child("33").getValue(Float.class));
                if (ocu213.getM33()<temp){
                    btn33.setBackgroundColor(Color.LTGRAY);
                }else {
                    btn33.setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        refHumo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.getValue(Integer.class)!= -1){
                    Log.d("Mensaje","did it");
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Humo en la Habitación: ");
                    builder.setMessage(dataSnapshot.getValue(Integer.class).toString());
                    builder.setPositiveButton("Atendida", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            refHumo.setValue(-1);
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User clicked the "Keep editing" button, so dismiss the dialog
                            // and continue editing the pet.
                            if (dialog != null) {
                                dialog.dismiss();
                            }
                        }
                    });

                    // Create and show the AlertDialog
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
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
        refHumo = database.getReference("Alerta");
        refHumo.setValue(-1);
    }

}
