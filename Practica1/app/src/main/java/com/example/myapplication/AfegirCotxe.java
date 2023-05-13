package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AfegirCotxe extends AppCompatActivity{

    EditText etAlias, etMarca, etModel, etCilindrada, etTelefon, etLongitud, etLatitud;
    CheckBox chBoxAutomatic;

    private ArrayList<Cotxe> data;

    public AfegirCotxe(ArrayList<Cotxe> data){
        this.data=data;
    }
    public AfegirCotxe(){
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_cotxe);

        etAlias= findViewById(R.id.etAlias);
        etMarca= findViewById(R.id.etMarca);
        etModel= findViewById(R.id.etModel);
        etCilindrada= findViewById(R.id.etCilindrada);
        etTelefon= findViewById(R.id.etTelefon);

        chBoxAutomatic = findViewById(R.id.chBoxAutomatic);

        etLongitud= findViewById(R.id.etLongitud);
        etLatitud= findViewById(R.id.etLatitud);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_datail_cotxe,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_back:
                Log.v("Menú","menu clicked");

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void recollirDadesCotxe(View view){
        String alias = etAlias.getText().toString();
        String marca = etMarca.getText().toString();
        String model = etModel.getText().toString();
        String cilindrada = etCilindrada.getText().toString();
        String telefon =etTelefon.getText().toString();
        String longitud =etLongitud.getText().toString();
        String latitud = etLatitud.getText().toString();
        //BOOLEAN
        //FALTA BOOLEAN AUTOMATIC
        boolean a = chBoxAutomatic.isChecked();
        double dCilindrada = Double.parseDouble(cilindrada);
        Long lTelefon = Long.parseLong(telefon);

        double dLongitud = Double.parseDouble(longitud);
        double dLatitud = Double.parseDouble(latitud);

        //Cotxe cotxe = new Cotxe(alias,marca,model,dCilindrada,lTelefon,a,dLongitud,dLatitud);


        Intent resultat = new Intent();
        //mirar

        //resultat.putExtra("text_resultat",);
        setResult(RESULT_OK,resultat);
        finish(); //tanca la pantalla


        data.add(new Cotxe(alias,marca,model,dCilindrada,lTelefon,a,dLongitud,dLatitud));


    }

    public void deleteBtn(View view){

    }


    public void cancelBtn(View view){
        finish();
    }


}
