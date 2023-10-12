package com.example.nicapps;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class menu_local extends AppCompatActivity {

    String Nlocal_menu;
    TextView n1, n2, b1, b2, p1, p2, p3, p4;
    ImageView i1, i2, i3, i4;

    TextView Nombrelomen;

    RatingBar ratingBar;

    ImageView BotonRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_local);
        n1= findViewById(R.id.platillo1);
        n2= findViewById(R.id.platillo2);
        b1= findViewById(R.id.bedida1);
        b2= findViewById(R.id.bebida2);
        p1= findViewById(R.id.precio1);
        p2= findViewById(R.id.precio2);
        p3= findViewById(R.id.precio3);
        p4= findViewById(R.id.precio4);
        i1= findViewById(R.id.img1);
        i2= findViewById(R.id.img2);
        i3= findViewById(R.id.img3);
        i4= findViewById(R.id.img4);

        Nombrelomen = findViewById(R.id.et_NomLocal2);

        Bundle data = this.getIntent().getExtras();
        Nlocal_menu = data.getString("sitio");
        Nombrelomen.setText(Nlocal_menu);

        if(!Nlocal_menu.isEmpty()){
            String platillo1="", platillo2="", bebida1="", bebida2="", precio1="",precio2="",precio3="",precio4="";

            switch (Nlocal_menu){
                case "Comedor El Pinolero": //Guadalupe
                    platillo1="Pollo a la Plancha";
                    platillo2="Brocheta de Pollo";
                    bebida1= "Fresco de Naranja";
                    bebida2= "Soda";
                    precio1="C$ 190";
                    precio2="C$ 110";
                    precio3="C$ 50";
                    precio4="C$ 30";
                    i1.setImageResource(R.drawable.polloalaplancha);
                    i2.setImageResource(R.drawable.brochetadepollo);
                    i3.setImageResource(R.drawable.naranja);
                    i4.setImageResource(R.drawable.soda);
                        break;
                case "Rincon Pinolero": //Guadalupe
                    platillo1="Pollo al Vino";
                    platillo2="Alitas de Pollo";
                    bebida1= "Soda";
                    bebida2= "Monster";
                    precio1="C$ 130";
                    precio2="C$ 120";
                    precio3="C$ 30";
                    precio4="C$ 90";
                    i1.setImageResource(R.drawable.polloalbino);
                    i2.setImageResource(R.drawable.alitasempanizadas);
                    i3.setImageResource(R.drawable.soda);
                    i4.setImageResource(R.drawable.monster);
                    break;
                case "El Sopon": //San Felipe
                    platillo1="Pasta con Camarones";
                    platillo2="Sopa de Queso";
                    bebida1= "Fresco de Melon";
                    bebida2= "Rojita";
                    precio1="C$ 150";
                    precio2="C$ 150";
                    precio3="C$ 50";
                    precio4="C$ 40";
                    i1.setImageResource(R.drawable.pasta);
                    i2.setImageResource(R.drawable.sopadequeso);
                    i3.setImageResource(R.drawable.melon);
                    i4.setImageResource(R.drawable.rojita);
                    break;
                case "TaPadrisimo Nicaragua": //San Felipe
                    platillo1="Fajita de Pollo";
                    platillo2="Pollo a la Plancha";
                    bebida1= "Monster";
                    bebida2= "Rojita";
                    precio1="C$ 120";
                    precio2="C$ 140";
                    precio3="C$ 100";
                    precio4="C$ 50";
                    i1.setImageResource(R.drawable.fajitasdepollo);
                    i2.setImageResource(R.drawable.polloalaplancha);
                    i3.setImageResource(R.drawable.monster);
                    i4.setImageResource(R.drawable.rojita);
                    break;
                case "La Basilica": //El Sagrario
                    platillo1="Combo de alitas";
                    platillo2="Parrillada la Basilica";
                    bebida1= "Fresco de Melon";
                    bebida2= "gaseosa rojita";
                    precio1="C$ 350";
                    precio2="C$ 270";
                    precio3="C$ 40";
                    precio4="C$ 30";
                    i1.setImageResource(R.drawable.alitasconpapa);
                    i2.setImageResource(R.drawable.parrilladalabasilica);
                    i3.setImageResource(R.drawable.melon);
                    i4.setImageResource(R.drawable.rojita);
                    break;
                case "La Avenida": //El Sagrario
                    platillo1="Fajitas de pollo";
                    platillo2="Pollo a la plancha";
                    bebida1= "Fresco de naranja";
                    bebida2= "Fresco de melon";
                    precio1="C$ 130";
                    precio2="C$ 110";
                    precio3="C$ 60";
                    precio4="C$ 60";
                    i1.setImageResource(R.drawable.fajitasdepollo);
                    i2.setImageResource(R.drawable.polloalaplancha);
                    i3.setImageResource(R.drawable.naranja);
                    i4.setImageResource(R.drawable.melon);
                    break;
                case "23 Bar": //El Sagrario
                    platillo1="Fajitas de Pollo";
                    platillo2="Hamburguesa de Res";
                    bebida1= "Monster";
                    bebida2= "Fresco de Limonada";
                    precio1="C$ 130";
                    precio2="C$ 210";
                    precio3="C$ 100";
                    precio4="C$ 50";
                    i1.setImageResource(R.drawable.fajitasdepollo);
                    i2.setImageResource(R.drawable.hamburguesaderes);
                    i3.setImageResource(R.drawable.monster);
                    i4.setImageResource(R.drawable.limonada);
                    break;
                case "Napoles": //El Sagrario
                    platillo1="Alitas picantes ";
                    platillo2="Pollo a la plancha";
                    bebida1= "Fresco de Limonada";
                    bebida2= "Fresco de Melon";
                    precio1="C$ 330";
                    precio2="C$ 220";
                    precio3="C$ 50";
                    precio4="C$ 50";
                    i1.setImageResource(R.drawable.alitasconpapa);
                    i2.setImageResource(R.drawable.polloalaplancha);
                    i3.setImageResource(R.drawable.limonada);
                    i4.setImageResource(R.drawable.melon);
                    break;
                case "El Sesteo": //El Sagrario
                    platillo1="Hamburguesas de res";
                    platillo2="Chancho con yuca";
                    bebida1= "Refresco de mente";
                    bebida2= "Soda roja milca";
                    precio1="C$ 270";
                    precio2="C$ 170";
                    precio3="C$ 120";
                    precio4="C$ 70";
                    i1.setImageResource(R.drawable.hamburguesaderes);
                    i2.setImageResource(R.drawable.chancho);
                    i3.setImageResource(R.drawable.menta);
                    i4.setImageResource(R.drawable.milca);
                    break;
                case "El Mediterraneo": //El Sagrario
                    platillo1="Pizza";
                    platillo2="Coctel de Camarones";
                    bebida1= "Fresco de limonada";
                    bebida2= "Monster";
                    precio1="C$ 450";
                    precio2="C$ 240";
                    precio3="C$ 60";
                    precio4="C$ 100";
                    i1.setImageResource(R.drawable.pizza);
                    i2.setImageResource(R.drawable.camarones);
                    i3.setImageResource(R.drawable.limonada);
                    i4.setImageResource(R.drawable.monster);
                    break;
                case "Jalisco": //El Sagrario
                    platillo1="Ensalada Cesar";
                    platillo2="Tacos de Mexicanos";
                    bebida1= "Michelada";
                    bebida2= "Gaseosa rojita";
                    precio1="C$ 260";
                    precio2="C$ 220";
                    precio3="C$ 110";
                    precio4="C$ 50";
                    i1.setImageResource(R.drawable.ensalada);
                    i2.setImageResource(R.drawable.mexican);
                    i3.setImageResource(R.drawable.mich);
                    i4.setImageResource(R.drawable.rojita);
                    break;
                case "Moncho's Leon": //El Sagrario
                    platillo1="Hamburguesas de res";
                    platillo2="Alitas Picantes";
                    bebida1= "Fresco de melon";
                    bebida2= "Gaseosa rojita";
                    precio1="C$ 270";
                    precio2="C$ 260";
                    precio3="C$ 60";
                    precio4="C$ 50";
                    i1.setImageResource(R.drawable.hamburguesaderes);
                    i2.setImageResource(R.drawable.alitasempanizadas);
                    i3.setImageResource(R.drawable.melon);
                    i4.setImageResource(R.drawable.rojita);
                    break;
                case "El Desayunazo": //El Sagrario
                    platillo1="Churrasco";
                    platillo2="Carne Asada";
                    bebida1= "Café";
                    bebida2= "Cacao";
                    precio1="C$ 370";
                    precio2="C$ 200";
                    precio3="C$ 40";
                    precio4="C$ 75";
                    i1.setImageResource(R.drawable.churrasco);
                    i2.setImageResource(R.drawable.carneasada);
                    i3.setImageResource(R.drawable.cafe);
                    i4.setImageResource(R.drawable.cacao);
                    break;
                case "El Oasis": //San Juan
                    platillo1="Alitas Empanizadas";
                    platillo2="Crepas";
                    bebida1= "Batidos Naturales";
                    bebida2= "Café";
                    precio1="C$ 250";
                    precio2="C$ 150";
                    precio3="C$ 85";
                    precio4="C$ 30";
                    i1.setImageResource(R.drawable.alitasempanizadas);
                    i2.setImageResource(R.drawable.crepas);
                    i3.setImageResource(R.drawable.batidos1);
                    i4.setImageResource(R.drawable.cafeoasis);
                    break;
                case "Waffle King Leon": //San Juan
                    platillo1="Clasico";
                    platillo2="Fruti Fit";
                    bebida1= "Vainilla";
                    bebida2= "Limonada Rosa";
                    precio1="C$ 75";
                    precio2="C$ 125";
                    precio3="C$ 100";
                    precio4="C$ 90";
                    i1.setImageResource(R.drawable.wafteclasico);
                    i2.setImageResource(R.drawable.wafflesfruit);
                    i3.setImageResource(R.drawable.vainilla);
                    i4.setImageResource(R.drawable.limonadarosa);
                    break;
                case "Rolls Nicaragua": //San Sebastian
                    platillo1=" Sushi";
                    platillo2="California Roll";
                    bebida1= "Coca cola 300ml";
                    bebida2= "Frutos Rojos";
                    precio1="$ 14";
                    precio2="$ 11";
                    precio3="C$ 20";
                    precio4="C$ 80";
                    i1.setImageResource(R.drawable.sushi);
                    i2.setImageResource(R.drawable.californiaroll);
                    i3.setImageResource(R.drawable.coca);
                    i4.setImageResource(R.drawable.frutosrojos);
                    break;
                case "Uepa": //San Sebastian
                    platillo1="Arroz con pollo";
                    platillo2="Desayuno Nica";
                    bebida1= "Tamarindo";
                    bebida2= "Pepsi";
                    precio1="C$ 180";
                    precio2="C$ 150";
                    precio3="C$ 30";
                    precio4="C$ 25";
                    i1.setImageResource(R.drawable.arrozpolloensalada);
                    i2.setImageResource(R.drawable.desayunogallopinto);
                    i3.setImageResource(R.drawable.tamarindo);
                    i4.setImageResource(R.drawable.pepsi);
                    break;
                case "SOY Nica": //El Calvario
                    platillo1="Sopa de garrobo";
                    platillo2="Coctel camarones";
                    bebida1= "Limonada";
                    bebida2= "Coca-Cola";
                    precio1="C$ 100";
                    precio2="C$ 120";
                    precio3="C$ 20";
                    precio4="C$ 30";
                    i1.setImageResource(R.drawable.sopagarrobo);
                    i2.setImageResource(R.drawable.coctelcamarones);
                    i3.setImageResource(R.drawable.limonada);
                    i4.setImageResource(R.drawable.coca);
                    break;
                case "Muertos de hambre": //El Calvario
                    platillo1="Jalapeño";
                    platillo2="Vaho";
                    bebida1= "Coca";
                    bebida2= "Limonada";
                    precio1="C$ 150";
                    precio2="C$ 100";
                    precio3="C$ 20";
                    precio4="C$";
                    i1.setImageResource(R.drawable.salasajlapeno);
                    i2.setImageResource(R.drawable.vaho);
                    i3.setImageResource(R.drawable.cocacola);
                    i4.setImageResource(R.drawable.limonada);
                    break;
                case "Comedor La Cucaracha": //El Calvario
                    platillo1="Sopa de Frijoles";
                    platillo2="Carne de Res Asada";
                    bebida1= "Cerveza Toña";
                    bebida2= "Rojita";
                    precio1="C$90";
                    precio2="C$110";
                    precio3="C$45";
                    precio4="C$25";
                    i1.setImageResource(R.drawable.sopafrijoles);
                    i2.setImageResource(R.drawable.carneasadaensalada);
                    i3.setImageResource(R.drawable.tonavidrio);
                    i4.setImageResource(R.drawable.rojita
                    );
                    break;
                case "Punto Y Coma": //El Calvario
                    platillo1="Carne Desmenusada";
                    platillo2="Pollo con Ensalada";
                    bebida1= "Cerveza Toña Enlatada";
                    bebida2= "Coca-Cola";
                    precio1="C$90";
                    precio2="C$120";
                    precio3="C$35";
                    precio4="C$35";
                    i1.setImageResource(R.drawable.carnedesmenuzada);
                    i2.setImageResource(R.drawable.polloconensalada);
                    i3.setImageResource(R.drawable.cervezatona
                    );
                    i4.setImageResource(R.drawable.coca);
                    break;
                case "La Antigua 1620": //Laborio
                    platillo1="Carne a la Plancha";
                    platillo2="Sopa de Res con Punche";
                    bebida1= "Cerveza Victoria Clasica";
                    bebida2= "Seltzer Mandarina";
                    precio1="C$180";
                    precio2="C$160";
                    precio3="C$35";
                    precio4="C$45";
                    i1.setImageResource(R.drawable.carnealaplancha);
                    i2.setImageResource(R.drawable.resconpunche);
                    i3.setImageResource(R.drawable.victoriaclasica);
                    i4.setImageResource(R.drawable.seltzermandarina);
                    break;
                case "A Tu Gusto": //Laborio
                    platillo1="Comida China";
                    platillo2="Pescado Frito";
                    bebida1= "Coca-Cola";
                    bebida2= "Fresco de Melon";
                    precio1="C$90";
                    precio2="C$130";
                    precio3="C$35";
                    precio4="C$20";
                    i1.setImageResource(R.drawable.comidachina);
                    i2.setImageResource(R.drawable.pescadofrito);
                    i3.setImageResource(R.drawable.cocacola);
                    i4.setImageResource(R.drawable.frescodemelon);
                    break;
                case "Delygus Express": //Laborio
                    platillo1="Hamburguesa";
                    platillo2="Pizza";
                    bebida1= "Malteada de Chocolate";
                    bebida2= "Malteada de Fresa";
                    precio1="C$110";
                    precio2="C$50";
                    precio3="C$80";
                    precio4="C$80";
                    i1.setImageResource(R.drawable.hamburguesa);
                    i2.setImageResource(R.drawable.pizza);
                    i3.setImageResource(R.drawable.malteadachocolate);
                    i4.setImageResource(R.drawable.malteadafresa);
                    break;
                case "D'humo": //Sutiaba
                    platillo1="Alitas de Pollo";
                    platillo2="Nachos";
                    bebida1= "Limonada";
                    bebida2= "Cerveza toña";
                    precio1="C$140";
                    precio2="C$180";
                    precio3="C$20";
                    precio4="C$45";
                    i1.setImageResource(R.drawable.alitas);
                    i2.setImageResource(R.drawable.nachos);
                    i3.setImageResource(R.drawable.limonada);
                    i4.setImageResource(R.drawable.cervezatona);
                    break;
                case "Rancho Don Pepe": //Sutiaba
                    platillo1="Churrasco";
                    platillo2="Pescado Frito";
                    bebida1= "Fanta Naranja";
                    bebida2= "Rojita";
                    precio1="C$70";
                    precio2="C$140";
                    precio3="C$35";
                    precio4="C$35";
                    i1.setImageResource(R.drawable.churrasco);
                    i2.setImageResource(R.drawable.pescadofrito);
                    i3.setImageResource(R.drawable.fantanaranja);
                    i4.setImageResource(R.drawable.rojita);
                    break;
                case "El Lobito": //Sutiaba
                    platillo1="Carne Asada de Cerdo";
                    platillo2="Coctel de Concha";
                    bebida1= "Cerveza Toña";
                    bebida2= "Cerveza Victoria Clasica";
                    precio1="C$150";
                    precio2="C$90";
                    precio3="C$35";
                    precio4="C$35";
                    i1.setImageResource(R.drawable.carneasadacerdo);
                    i2.setImageResource(R.drawable.cocteldeconcha);
                    i3.setImageResource(R.drawable.cervezatona);
                    i4.setImageResource(R.drawable.victoriaclasica);
                    break;
                case "Los Pescaditos": //Sutiaba
                    platillo1="Almejas";
                    platillo2="Deditos de Pollo";
                    bebida1= "Cerveza premium";
                    bebida2= "Piña Colada";
                    precio1="C$140";
                    precio2="C$90";
                    precio3="C$50";
                    precio4="C$80";
                    i1.setImageResource(R.drawable.almejas);
                    i2.setImageResource(R.drawable.deditosdepollo);
                    i3.setImageResource(R.drawable.cervezapremium);
                    i4.setImageResource(R.drawable.pinacolada);
                    break;
                case "Comedor Gabejor": //El Calvarito
                    platillo1="Carne Desmenuzada";
                    platillo2="Pollo en Ensalada Jalapeño";
                    bebida1= "Cafe";
                    bebida2= "Coca-Cola";
                    precio1="C$130";
                    precio2="C$140";
                    precio3="C$30";
                    precio4="C$35";
                    i1.setImageResource(R.drawable.carnedesmenuzada);
                    i2.setImageResource(R.drawable.jalapeno);
                    i3.setImageResource(R.drawable.cafe);
                    i4.setImageResource(R.drawable.cocacola);
                    break;
                case "Rinconcito Pinolero": //El Calvarito
                    platillo1="Chuleta";
                    platillo2="Sopa de Res";
                    bebida1= "Coca-Cola";
                    bebida2= "Fresco de Melon";
                    precio1="C$130";
                    precio2="C$150";
                    precio3="C$35";
                    precio4="C$20";
                    i1.setImageResource(R.drawable.chuleta);
                    i2.setImageResource(R.drawable.sopares);
                    i3.setImageResource(R.drawable.cocacola);
                    i4.setImageResource(R.drawable.frescodemelon);
                    break;

            }
            n1.setText(platillo1.toString());
            p1.setText(precio1.toString());
            n2.setText(platillo2.toString());
            p2.setText(precio2.toString());
            b1.setText(bebida1.toString());
            p3.setText(precio3.toString());
            b2.setText(bebida2.toString());
            p4.setText(precio4.toString());
        }


        ratingBar = findViewById(R.id.ratingB1);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                int rating = (int) v;
                String message = null;
                switch (rating){
                    case 1:
                        message = "Siento mucho decepcionarte";
                        break;
                    case 2:
                        message = "Estamos trabajando para ti";
                        break;
                    case 3:
                        message = "Haciendo más facil tu vida";
                        break;
                    case 4:
                        message = "¡Gracias por tu apoyo!";
                        break;
                    case 5:
                        message = "¡Increible! Gracias por tu apoyo continuo";
                        break;
                }
                Toast.makeText(menu_local.this, message, Toast.LENGTH_SHORT).show();
            }
        });

        BotonRegresar = findViewById(R.id.bt_regresar2);
        BotonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(menu_local.this,MainActivity3.class);
                startActivity(i);
            }
        });

    }
}

