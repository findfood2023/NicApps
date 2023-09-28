package com.example.nicapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class menu_local extends AppCompatActivity {

    String Nlocal_menu;

    TextView Nombrelomen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_local);

        Nombrelomen = findViewById(R.id.et_NomLocal2);

        Bundle data = this.getIntent().getExtras();
        Nlocal_menu = data.getString("sitio");
        Nombrelomen.setText(Nlocal_menu);
    }
}
