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
        Editable cilindrada = etCilindrada.getText();
        Editable telefon =etTelefon.getText();
        // falta recollir el valor del checkbox
        // boolean automatic = chBoxAutomatic.;
        Editable longitud =etLongitud.getText();
        Editable latitud = etLatitud.getText();


        Intent resultat = new Intent();
        //mirar
        resultat.putExtra("text_resultat", alias);
        setResult(RESULT_OK,resultat);
        finish(); //tanca la pantalla

        //data.add(new Cotxe(alias,marca,model,cilindrada,telefon,longitud,latitud));

        // String alias, String marca, String model, double cilindrada, long telefon, boolean automatic, double longitud, double latitud



        /*
        String text= etTask.getText().toString();
        String marca = etMarca.getText().toString();
        dataSet.add(new Task(text,marca));
        taskAdapter.notifyDataSetChanged();
        etTask.setText("");
        etMarca.setText("");
         */





    }

    public void deleteBtn(View view){

    }


    public void cancelBtn(View view){
        finish();
    }


}
