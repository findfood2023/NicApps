package com.example.nicapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class vista_locales extends AppCompatActivity {

        private ArrayList<String> Guadalupe, San_Felipe,El_Sagrario, San_Juan, San_Sebastian, El_Calvario, Laborio, Sutiaba, El_Calvarito;
        private ListView lista;

        int numero_lista = 0;

        private Spinner spinnerlocales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_locales);

        lista = findViewById(R.id.lista_local);

        spinnerlocales = findViewById(R.id.spinnerlocales);

        Guadalupe = new ArrayList<>();
        Guadalupe.add("Comedor El Pinolero");
        Guadalupe.add("Rincon Pinolero");

        San_Felipe = new ArrayList<>();
        San_Felipe.add("El Sopon");
        San_Felipe.add("TaPadrisimo Nicaragua");

        El_Sagrario = new ArrayList<>();
        El_Sagrario.add("La Basilica");
        El_Sagrario.add("La Avenida");
        El_Sagrario.add("23 Bar");
        El_Sagrario.add("Napoles");
        El_Sagrario.add("El Sesteo");
        El_Sagrario.add("El Mediterraneo");
        El_Sagrario.add("Jalisco");
        El_Sagrario.add("Moncho's Leon");
        El_Sagrario.add("El Desayunazo");

        San_Juan = new ArrayList<>();
        San_Juan.add("El Oasis");
        San_Juan.add("Waffle King Leon");

        San_Sebastian = new ArrayList<>();
        San_Sebastian.add("Rolls Nicaragua");
        San_Sebastian.add("Uepa");

        El_Calvario = new ArrayList<>();
        El_Calvario.add("SOY Nica");
        El_Calvario.add("Muertos de hambre");
        El_Calvario.add("Comedor La Cucaracha");
        El_Calvario.add("Punto Y Coma");

        Laborio = new ArrayList<>();
        Laborio.add("La Antigua 1620");
        Laborio.add("A Tu Gusto");
        Laborio.add("Delygus Express");

        Sutiaba = new ArrayList<>();
        Sutiaba.add("D'humo");
        Sutiaba.add("Rancho Don Pepe");
        Sutiaba.add("El Lobito");
        Sutiaba.add("Los Pescaditos");

        El_Calvarito = new ArrayList<>();
        El_Calvarito.add("Comedor Gabejor");
        El_Calvarito.add("Rinconcito Pinolero");

        spinnerlocales.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String local = (String) spinnerlocales.getSelectedItem();
                if (local.equals("Guadalupe")) {
                    ArrayAdapter<String> adaptador = new ArrayAdapter<String>(vista_locales.this, android.R.layout.simple_list_item_1, Guadalupe);
                    lista.setAdapter(adaptador);
                    numero_lista = 1;
                } else if (local.equals("San Felipe")) {
                    ArrayAdapter<String> adaptador = new ArrayAdapter<String>(vista_locales.this, android.R.layout.simple_list_item_1, San_Felipe);
                    lista.setAdapter(adaptador);
                    numero_lista = 2;
                } else if (local.equals("El Sagrario (centro León)")) {
                    ArrayAdapter<String> adaptador = new ArrayAdapter<String>(vista_locales.this, android.R.layout.simple_list_item_1, El_Sagrario);
                    lista.setAdapter(adaptador);
                    numero_lista = 3;
                } else if (local.equals("San Juan")) {
                    ArrayAdapter<String> adaptador = new ArrayAdapter<String>(vista_locales.this, android.R.layout.simple_list_item_1, San_Juan);
                    lista.setAdapter(adaptador);
                    numero_lista = 4;
                } else if (local.equals("San Sebastian")) {
                    ArrayAdapter<String> adaptador = new ArrayAdapter<String>(vista_locales.this, android.R.layout.simple_list_item_1, San_Sebastian);
                    lista.setAdapter(adaptador);
                    numero_lista = 5;
                } else if (local.equals("El Calvario")) {
                    ArrayAdapter<String> adaptador = new ArrayAdapter<String>(vista_locales.this, android.R.layout.simple_list_item_1, El_Calvario);
                    lista.setAdapter(adaptador);
                    numero_lista = 6;
                } else if (local.equals("Laborio")) {
                    ArrayAdapter<String> adaptador = new ArrayAdapter<String>(vista_locales.this, android.R.layout.simple_list_item_1, Laborio);
                    lista.setAdapter(adaptador);
                    numero_lista = 7;
                } else if (local.equals("Sutiaba")) {
                    ArrayAdapter<String> adaptador = new ArrayAdapter<String>(vista_locales.this, android.R.layout.simple_list_item_1, Sutiaba);
                    lista.setAdapter(adaptador);
                    numero_lista = 8;
                } else if (local.equals("El Calvarito")) {
                    ArrayAdapter<String> adaptador = new ArrayAdapter<String>(vista_locales.this, android.R.layout.simple_list_item_1, El_Calvarito);
                    lista.setAdapter(adaptador);
                    numero_lista = 9;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String sitio="";
                switch (numero_lista){
                    case 1: //Guadalupe
                        if(i == 0) sitio = "Comedor El Pinolero";
                        else sitio = "Rincon Pinolero";
                        break;
                    case 2: //san felipe
                        if(i == 0) sitio = "El Sopon";
                        else sitio = "TaPadrisimo Nicaragua";
                        break;
                    case 3: //El Sagrario (centro León)
                        if(i == 0) sitio = "La Basilica";
                        else if(i == 1) sitio = "La Avenida";
                        else if(i == 2) sitio = "23 Bar";
                        else if(i == 3) sitio = "Napoles";
                        else if(i == 4) sitio = "El Sesteo";
                        else if(i == 5) sitio = "El Mediterraneo";
                        else if(i == 6) sitio = "Jalisco";
                        else if(i == 7) sitio = "Moncho's Leon";
                        else sitio = "El Desayunazo";
                        break;
                    case 4: //San Juan
                        if(i == 0) sitio = "El Oasis";
                        else sitio = "Waffle King Leon";
                        break;
                    case 5: //San Sebastian
                        if(i == 0) sitio = "Rolls Nicaragua";
                        else sitio = "Uepa";
                        break;
                    case 6: //El Calvario
                        if(i == 0) sitio = "SOY Nica";
                        else if(i == 1) sitio = "Muertos de hambre";
                        else if(i == 2) sitio = "Comedor La Cucaracha";
                        else sitio = "Punto Y Coma";
                        break;
                    case 7: //Laborio
                        if(i == 0) sitio ="La Antigua 1620";
                        else if(i == 1) sitio = "A Tu Gusto";
                        else sitio = "Delygus Express";
                        break;
                    case 8: //Sutiaba
                        if(i == 0) sitio ="D'humo";
                        else if(i == 1) sitio = "Rancho Don Pepe";
                        else if(i == 2) sitio = "El Lobito";
                        else sitio = "Los Pescaditos";
                        break;
                    case 9: //El  Calvario
                        if(i == 0) sitio = "Comedor Gabejor";
                        else sitio = "Rinconcito Pinolero";
                        break;
                }
                Intent intent = new Intent(vista_locales.this,MainActivity3.class);
                intent.putExtra("sitio",sitio);
                startActivity(intent);
            }
        });


    }
}