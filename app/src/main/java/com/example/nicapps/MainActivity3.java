package com.example.nicapps;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.protobuf.Value;

import java.util.HashMap;

public class MainActivity3 extends AppCompatActivity {
    String nombre_local, NombreLocal;;
    TextView Nlocal, Direccion_local,Telefono_local, CantidadLocales,Sugerencias;
    Button botonMenu, botonlistalocales, botonsalirbusque;

    String restaurantQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Nlocal = findViewById(R.id.et_nombrelocal);
        Direccion_local = findViewById(R.id.direccion_local);
        Telefono_local = findViewById(R.id.telefono_local);
        CantidadLocales = findViewById(R.id.cantidadlocales);
        Sugerencias = findViewById(R.id.sugerencias);

        Intent intent = getIntent();
        if (intent != null) {
            restaurantQuery = intent.getStringExtra("nombre");
            if (restaurantQuery != null) {
                nombre_local = restaurantQuery;
            } else {
                nombre_local = intent.getStringExtra("sitio");
            }
        }
        Nlocal.setText(nombre_local);

        if (nombre_local.equals("Comedor El Pinolero")) NombreLocal = "Comedor El Pinolero";
        else if (nombre_local.equals("Rincon Pinolero")) NombreLocal = "Rincón Pinolero";
        else if (nombre_local.equals("El Sopon")) NombreLocal = "El Sopón";
        else if (nombre_local.equals("TaPadrisimo Nicaragua")) NombreLocal = "TaPadrisimo Nicaragua";
        else if (nombre_local.equals("La Basilica")) NombreLocal = "La Basílica";
        else if (nombre_local.equals("23 Bar")) NombreLocal = "23 Bar";
        else if (nombre_local.equals("Napoles")) NombreLocal = "Napoles";
        else if (nombre_local.equals("El Sesteo")) NombreLocal = "El Sesteo";
        else if (nombre_local.equals("El Mediterraneo")) NombreLocal = "El Mediterraneo";
        else if (nombre_local.equals("Jalisco")) NombreLocal = "Jalisco";
        else if (nombre_local.equals("Moncho's Leon")) NombreLocal = "Moncho’s Leon";
        else if (nombre_local.equals("El Desayunazo")) NombreLocal = "El Desayunazo";
        else if (nombre_local.equals("El Oasis")) NombreLocal = "El Oasis";
        else if (nombre_local.equals("Waffle King Leon")) NombreLocal = "Waffle King Leon";
        else if (nombre_local.equals("Rolls Nicaragua")) NombreLocal = "Rolls Nicaragua";
        else if (nombre_local.equals("Uepa")) NombreLocal = "Uepa";
        else if (nombre_local.equals("SOY Nica")) NombreLocal = "SOY Nica";
        else if (nombre_local.equals("Muertos de hambre")) NombreLocal = "Muertos de Hambre";
        else if (nombre_local.equals("Comedor La Cucaracha")) NombreLocal = "Comedor La Cucaracha";
        else if (nombre_local.equals("Punto Y Coma")) NombreLocal = "Punto y Coma";
        else if (nombre_local.equals("La Antigua 1620")) NombreLocal = "La Antigua 1620";
        else if (nombre_local.equals("A Tu Gusto")) NombreLocal = "A tu Gusto";
        else if (nombre_local.equals("Delygus Express")) NombreLocal = "Delygus Express";
        else if (nombre_local.equals("D'humo")) NombreLocal = "D’humo";
        else if (nombre_local.equals("Rancho Don Pepe")) NombreLocal = "Asados Don Pepe";
        else if (nombre_local.equals("El Lobito")) NombreLocal = "El Lobito";
        else if (nombre_local.equals("Los Pescaditos")) NombreLocal = "Los Pescaditos";
        else if (nombre_local.equals("Comedor Gabejor")) NombreLocal = "Comedor Gabejor";
        else if (nombre_local.equals("Rinconcito Pinolero")) NombreLocal = "Rinconcito Pinolero";
        else if (nombre_local.equals("La Avenida")) NombreLocal = "La Avenida";

        boolean conexion = verificar_conexion();
        if (conexion) {
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            db.collection("restaurantes").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            if(document.getId().equals(NombreLocal)){
                                Direccion_local.setText(document.getData().get("direccion").toString());
                                Telefono_local.setText(document.getData().get("telefono").toString());
                                CantidadLocales.setText(document.getData().get("cantidadLocales").toString());
                                Sugerencias.setText(document.getData().get("sugerencias").toString());
                                break;
                            }
                        }
                    }
                }
            });

        }



        /*Bundle data = this.getIntent().getExtras();
        nombre_local = data.getString("sitio");
        Nlocal.setText(nombre_local);*/

        botonMenu = findViewById(R.id.bt_menu);
        botonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity3.this, menu_local.class);
                i.putExtra("sitio", nombre_local);
                startActivity(i);
            }
        });

        botonlistalocales = findViewById(R.id.bt_listalocales);
        botonlistalocales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(MainActivity3.this, vista_locales.class);
                startActivity(k);
            }
        });

        botonsalirbusque = findViewById(R.id.bt_salirprincip);
        botonsalirbusque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity3.this, busqueda.class);
                startActivity(i);
            }
        });

    }

    public boolean verificar_conexion() {

        ConnectivityManager cm = (ConnectivityManager)
                this.getSystemService(MainActivity.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();
        if (isConnected == true) return true;
        else return false;
    }

}