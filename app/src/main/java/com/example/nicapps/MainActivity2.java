package com.example.nicapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {

    EditText CT_Correo, CT_contrasena;

    Button BT_Inicio, BT_Registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        CT_Correo = findViewById(R.id.ct_correo);
        CT_contrasena = findViewById(R.id.ct_contrasena);
        BT_Inicio = findViewById(R.id.bt_inicio);
        BT_Registro = findViewById(R.id.bt_registro);
        BT_Inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Consultar_Usuario(v);
            }
        });
        //verificamos si tenemos conexion
        boolean conexion = verificar_conexion();
        if (conexion == true){
            FirebaseAuth mAuth;
            mAuth = FirebaseAuth.getInstance();
            //verificar si ya se había iniciado sesion
            if (mAuth.getCurrentUser() != null) {
                Intent intent = new Intent(MainActivity2.this, busqueda.class);
                startActivity(intent);
                finish();
            }
        }
        BT_Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this,registro.class);
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
    public void Consultar_Usuario(View view) {
        boolean Estado = verificar_conexion();
        if (Estado == true) {

            String correo = CT_Correo.getText().toString();
            String contrasena = CT_contrasena.getText().toString();

            if (correo.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(this, "Por favor rellene todos los campos", Toast.LENGTH_LONG).show();
                CT_Correo.requestFocus(); //poner el foco en la caja de texto usuario
                return;
            } else {

                //validar el correo electronico
                boolean respuesta = correo.matches("^[a-zA-Z_!#$%'*+/=?`{}~^.-]+@[a-zA-Z0-9.-]+$");
                if (respuesta == true) {

                    //verificar conraseña
                    if (contrasena.length() < 8) {
                        Toast.makeText(MainActivity2.this, "La contraseña debe tener al menos 8 caracteres", Toast.LENGTH_SHORT).show();
                        CT_contrasena.requestFocus();
                    }else {
                        FirebaseAuth mAuth;
                        mAuth = FirebaseAuth.getInstance();
                        mAuth.signInWithEmailAndPassword(correo, contrasena)
                                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            Intent intent = new Intent(MainActivity2.this, busqueda.class);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            Toast.makeText(MainActivity2.this, "Correo y/o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                                            CT_Correo.requestFocus();
                                        }
                                    }
                                });//Codigo para autenticar
                    }
                }else {
                    Toast.makeText(MainActivity2.this, "El correo no tiene el formato correcto", Toast.LENGTH_SHORT).show();
                    CT_Correo.requestFocus();
                }
            }
        } else {
            Toast.makeText(this, "Por Favor Conectese a Internet", Toast.LENGTH_SHORT).show();
        }
    }
}
