package com.example.nicapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    String nombre_local;
    TextView Nlocal;
    Button botonMenu;
    Button botonSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Nlocal = findViewById(R.id.et_nombrelocal);

        Intent intent = getIntent();
        if (intent != null) {
            String restaurantQuery = intent.getStringExtra("nombre");
            if (restaurantQuery != null) {
                nombre_local=restaurantQuery;
            }else {
                nombre_local = intent.getStringExtra("sitio");
            }
        }
        Nlocal.setText(nombre_local);
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

        botonSalir = findViewById(R.id.bt_salirM3);
        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(MainActivity3.this, busqueda.class);
                startActivity(k);
            }
        });

    }
}