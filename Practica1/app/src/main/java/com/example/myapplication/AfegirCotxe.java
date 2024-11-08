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

    private ArrayList<Cotxe> llistaCotxes;
    private boolean modificar = false;
    public AfegirCotxe(){
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_cotxe);
//fletxa enrere (esquerra)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etAlias= findViewById(R.id.etAlias);
        etMarca= findViewById(R.id.etMarca);
        etModel= findViewById(R.id.etModel);
        etCilindrada= findViewById(R.id.etCilindrada);
        etTelefon= findViewById(R.id.etTelefon);
        chBoxAutomatic = findViewById(R.id.chBoxAutomatic);
        etLongitud= findViewById(R.id.etLongitud);
        etLatitud= findViewById(R.id.etLatitud);

        llistaCotxes = new ArrayList<>();

        /*Cotxe cotxeModificar = getIntent().getParcelableExtra("cotxe_modificar");
        if(cotxeModificar!=null){
            etAlias.setText(cotxeModificar.getAlias());
            etMarca.setText(cotxeModificar.getMarca());
            etModel.setText(cotxeModificar.getModel());
            etCilindrada.setText(String.valueOf(cotxeModificar.getCilindrada()));
            etTelefon.setText(cotxeModificar.getTelefon());
            chBoxAutomatic.setChecked(cotxeModificar.isAutomatic());
            etLatitud.setText(String.valueOf(cotxeModificar.getLatitud()));
            etLongitud.setText(String.valueOf(cotxeModificar.getLongitud()));
            modificar=true;
        }else{
            modificar=false;
        }

         */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_datail_cotxe,menu);
        return true;
    }



    public void recollirDadesCotxe(View view){
        String alias = etAlias.getText().toString();
        String marca = etMarca.getText().toString();
        String model = etModel.getText().toString();
        String telefon =etTelefon.getText().toString();
        String longitud =etLongitud.getText().toString();
        String latitud = etLatitud.getText().toString();
        boolean a = chBoxAutomatic.isChecked();
        double dCilindrada = Double.parseDouble(etCilindrada.getText().toString());

        double dLongitud = Double.parseDouble(longitud);
        double dLatitud = Double.parseDouble(latitud);

        Cotxe cotxe = new Cotxe(alias,marca,model,dCilindrada,telefon,a,dLongitud,dLatitud);

        if(modificar){
            Intent intentModificat = new Intent();
            intentModificat.putExtra("car_modificar",cotxe);
            setResult(RESULT_OK, intentModificat);
        }else{
            Intent intentAfegir = new Intent(getApplicationContext(), MainActivity.class);
            //MIRAR COM FER EL ADD, ells el add el tenen com un CASE de un activityResult
            intentAfegir.putExtra("tipus", MainActivity.ADD);
            intentAfegir.putExtra("afegirCotxe",cotxe);
            setResult(RESULT_OK, intentAfegir);
        }
        finish(); //tanca la pantalla
    }

    public void deleteBtn(View view){

    }



  /* @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_back:
                Log.v("Menú","menu clicked");

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                break;
        }
        return super.onOptionsItemSelected(item);
    }*/
}
