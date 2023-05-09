package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AfegirCotxe extends AppCompatActivity{

    EditText etAlias, etMarca, etModel, etCilindrada, etTelefon, etLongitud, etLatitud;

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
