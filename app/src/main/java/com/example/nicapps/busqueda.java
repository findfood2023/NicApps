package com.example.nicapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.Toolbar;
import android.widget.ViewFlipper;

import com.google.firebase.auth.FirebaseAuth;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Locale;

public class busqueda extends AppCompatActivity {

    ViewFlipper carrusel1;
    Button bt_vermas;

    SearchView busqueda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);

        int images[] = {R.drawable.asadospeli, R.drawable.charlies, R.drawable.sacuanjoche, R.drawable.sundance, R.drawable.suaiamgen,
                R.drawable.sesteo, R.drawable.desayun};
        carrusel1 = findViewById(R.id.carrusel1);

        for (int image : images) {
            flipperImages(image);
        }

        bt_vermas = findViewById(R.id.bt_vermas);

        bt_vermas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(busqueda.this, vista_locales.class);
                startActivity(i);
            }
        });

        busqueda = findViewById(R.id.barra_busqueda);
        busqueda.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            String query;
           @Override
            public boolean onQueryTextSubmit(String query) {
               Intent intent = new Intent(com.example.nicapps.busqueda.this, MainActivity3.class);
               query = busqueda.getQuery().toString().toLowerCase(Locale.ROOT).trim();
               if(query.equals("comedor el pinolero") || query.equals("rincon pinolero")
                       || query.equals("el sopon") || query.equals("tapadrisimo nicaragua")
                       || query.equals("la basilica")|| query.equals("la avenida")|| query.equals("23 bar")
                       || query.equals("la avaenida")|| query.equals("la avaenida")|| query.equals("la avaenida")
                       || query.equals("la avaenida")|| query.equals("la avaenida")|| query.equals("la avaenida")
                       || query.equals("la avaenida")|| query.equals("la avaenida")|| query.equals("la avaenida")
                       || query.equals("la avaenida")|| query.equals("la avaenida")|| query.equals("la avaenida")
                       || query.equals("la avaenida")|| query.equals("la avaenida")|| query.equals("la avaenida")
                       || query.equals("la avaenida")) {
                   intent.putExtra("nombre", query);
               }else Toast.makeText(busqueda.this, "No se encontro el restaurante", Toast.LENGTH_SHORT).show();
               startActivity(intent);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String query) {

                return true;
            }
        });

        //busqueda.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        //busqueda.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
          //  @Override
         //   public boolean onQueryTextSubmit(String query) {
           //     return true;
           // }

          //  @Override
           // public boolean onQueryTextChange(String query) {
            //    return true;
            //}
        //});

    };

    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        carrusel1.addView(imageView);
        carrusel1.setFlipInterval(3000);
        carrusel1.setAutoStart(true);

        carrusel1.setInAnimation(this, android.R.anim.slide_out_right);
        carrusel1.setOutAnimation(this, android.R.anim.slide_in_left);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_profile:
                //Toast.makeText(this, "Perfil", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(busqueda.this,pantalla_perfil.class);
                startActivity(i);
                break;
            case R.id.action_contacto:
                //Toast.makeText(this, "Contacto", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_exit:
                //Toast.makeText(this, "Salir", Toast.LENGTH_SHORT).show();
                FirebaseAuth.getInstance().signOut();
                Intent I = new Intent(busqueda.this,MainActivity2.class);
                startActivity(I);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}