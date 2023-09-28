package com.example.nicapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class pantalla_perfil extends AppCompatActivity {
    ImageView bt_atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_perfil);
        bt_atras = findViewById(R.id.bt_atras_perfil);

        bt_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla_perfil.this,busqueda.class);
                startActivity(i);
            }
        });
    }
}