package com.example.nicapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class registro extends AppCompatActivity {

    EditText CT_NombreCompleto, CT_Telefono2, CT_Contrasena2, CT_ConfirmarContrasena,Correo_Electronico;

    RadioButton RB_Registrarse;

    Button BT_Registro2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        CT_NombreCompleto = findViewById(R.id.ct_nombrecompleto);
        CT_Telefono2 = findViewById(R.id.ct_telefono2);
        CT_Contrasena2 = findViewById(R.id.ct_contrasena2);
        CT_ConfirmarContrasena = findViewById(R.id.ct_confirmarcontrasena);
        RB_Registrarse = findViewById(R.id.rb_registrarse);
        BT_Registro2 = findViewById(R.id.bt_registro2);
        Correo_Electronico = findViewById(R.id.email);


        BT_Registro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = CT_NombreCompleto.getText().toString();
                String telefono = CT_Telefono2.getText().toString();
                String contrasena = CT_Contrasena2.getText().toString();
                String confirmar = CT_ConfirmarContrasena.getText().toString();
                String correo = Correo_Electronico.getText().toString().toLowerCase(Locale.ROOT);

                if (nombre.isEmpty() && telefono.isEmpty() && contrasena.isEmpty() && confirmar.isEmpty() && correo.isEmpty()) {
                    Toast.makeText(registro.this, "Por favor rellene todo los campos", Toast.LENGTH_SHORT).show();
                    Correo_Electronico.requestFocus();

                } else if (nombre.isEmpty()) {
                    Toast.makeText(registro.this, "Ingrese el nombre completo", Toast.LENGTH_SHORT).show();
                    CT_NombreCompleto.requestFocus();

                } else if (telefono.isEmpty()) {
                    Toast.makeText(registro.this, "Ingrese el telefono", Toast.LENGTH_SHORT).show();
                    CT_Telefono2.requestFocus();

                } else if (contrasena.isEmpty()) {
                    Toast.makeText(registro.this, "Ingrese la contraseña", Toast.LENGTH_SHORT).show();
                    CT_Contrasena2.requestFocus();

                } else if (confirmar.isEmpty()) {
                    Toast.makeText(registro.this, "Ingrese la confirmacion de la contraseña", Toast.LENGTH_SHORT).show();
                    CT_ConfirmarContrasena.requestFocus();

                } else if (correo.isEmpty()) {
                    Toast.makeText(registro.this, "Ingrese el correo", Toast.LENGTH_SHORT).show();
                    Correo_Electronico.requestFocus();
                } else {

                    //validar el correo electronico
                    boolean respuesta = correo.matches("^[a-zA-Z0-9_!#$%'*+/=?`{}~^.-]+@[a-zA-Z.-]+$");
                    if (respuesta == true) {

                        //verificacion del telefono
                        if (telefono.length() < 8) {
                            Toast.makeText(registro.this, "El número telefonico debe tener 8 dígitos exactos", Toast.LENGTH_SHORT).show();
                            CT_Telefono2.requestFocus();
                        } else {
                            //verificar contraseñas: min 8 max 12
                            if (contrasena.length() < 7 || contrasena.length() > 13) {
                                Toast.makeText(registro.this, "La contraseña debe tener al menos 8 caracteres", Toast.LENGTH_SHORT).show();
                                CT_Contrasena2.requestFocus();
                            } else if (confirmar.length() < 7 || confirmar.length() > 13) {
                                Toast.makeText(registro.this, "La segunda contraseña debe tener al menos 8 caracteres", Toast.LENGTH_SHORT).show();
                                CT_ConfirmarContrasena.requestFocus();

                            } else {//verificar si ambas contraseñas son iguales
                                if (contrasena.equals(confirmar) == true) {

                                    //verificar que se aceptan los terminos y condiciones
                                    if (RB_Registrarse.isChecked() == true) {

                                        boolean conexion= verificar_conexion();

                                        if (conexion == true) {

                                            BT_Registro2.setEnabled(false);
                                            BT_Registro2.setText("Espere...");

                                            //guardar el usuario en Autentication
                                            FirebaseAuth mAuth = FirebaseAuth.getInstance();
                                            mAuth.createUserWithEmailAndPassword(correo, contrasena).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                @Override
                                                public void onComplete(@NonNull Task<AuthResult> task) {
                                                    if (task.isSuccessful()) {
                                                       // Toast.makeText(registro.this, "Usuario creado correctamente", Toast.LENGTH_SHORT).show();
                                                        //FirebaseUser user = mAuth.getCurrentUser();
                                                    } else {
                                                        Toast.makeText(registro.this, "Ocurrió un fallo", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });

                                            //guardar el nombre y telefono en firebase firestore
                                            FirebaseFirestore db = FirebaseFirestore.getInstance();

                                            Map<String,Object> datosUsuario = new HashMap<>();
                                            datosUsuario.put("nombre",nombre);
                                            datosUsuario.put("telefono",telefono);
                                            datosUsuario.put("correo",correo);

                                            db.collection("usuarios").add(datosUsuario).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                                @Override
                                                public void onSuccess(DocumentReference documentReference) {
                                                    Toast.makeText(registro.this, "Usuario creado correctamente", Toast.LENGTH_LONG).show();
                                                    Intent i = new Intent(registro.this, MainActivity2.class);
                                                    startActivity(i);
                                                }
                                            }).addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    Toast.makeText(registro.this, "ERROR: "+e.getMessage(), Toast.LENGTH_LONG).show();
                                                }
                                            });

                                        }else
                                            Toast.makeText(registro.this, "Por favor conectese a internet", Toast.LENGTH_SHORT).show();
                                    }else Toast.makeText(registro.this, "Tiene que aceptar los terminos y condiciones", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(registro.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                                    CT_Contrasena2.requestFocus();
                                }
                            }
                        }
                    }else{
                        Toast.makeText(registro.this, "El correo no tiene el formato correcto", Toast.LENGTH_SHORT).show();
                        Correo_Electronico.requestFocus();
                    }
                }
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
