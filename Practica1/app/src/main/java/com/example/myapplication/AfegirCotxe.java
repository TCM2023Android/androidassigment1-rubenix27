package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AfegirCotxe extends AppCompatActivity{

    EditText etAlias, etMarca, etModel, etCilindrada, etTelefon, etLongitud, etLatitud;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_cotxe);

        etAlias= findViewById(R.id.etAlias);
        etMarca= findViewById(R.id.etMarca);
        etModel= findViewById(R.id.etModel);
        etCilindrada= findViewById(R.id.etCilindrada);
        etTelefon= findViewById(R.id.etTelefon);
        etLongitud= findViewById(R.id.etLongitud);
        etLatitud= findViewById(R.id.etLatitud);

    }

    public void recollirDadesCotxe(View view){
        String alias = etAlias.getText().toString();
        String marca = etMarca.getText().toString();
        String model = etModel.getText().toString();
        String cilindrada =etCilindrada.getText().toString();
        String telefon =etTelefon.getText().toString();
        String longitud =etLongitud.getText().toString();
        String latitud = etLatitud.getText().toString();


        Intent resultat = new Intent();
        //mirar
        resultat.putExtra("text_resultat", alias);
        setResult(RESULT_OK,resultat);
        finish(); //tanca la pantalla
    }

    public void deleteBtn(View view){

    }


    public void cancelBtn(View view){
        finish();
    }


}
