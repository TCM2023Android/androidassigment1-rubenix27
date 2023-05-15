package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;

public class infoCotxe extends AppCompatActivity {

    CheckBox chBoxAutomatic;

    TextView tvPlate, tvMarca, tvModel, tvCilindrada, tvTelefon, tvLongitud, tvLatitud;

    ActivityResultLauncher<Intent> activityResultLauncher;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_cotxe);

        tvPlate = findViewById(R.id.tvPlate);
        tvMarca = findViewById(R.id.tvMarca);
        tvModel = findViewById(R.id.tvModel);
        tvCilindrada = findViewById(R.id.tvCilindrada);
        tvTelefon = findViewById(R.id.tvTelefon);
        chBoxAutomatic = findViewById(R.id.chBoxAutomatic);
        tvLongitud = findViewById(R.id.tvLongitud);
        tvLatitud = findViewById(R.id.tvLatitud);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        activity = this;

        Cotxe cotxe = getIntent().getParcelableExtra("cotxe");

        //agafem dades del objecte i les mostrem als tv
        tvPlate.setText(cotxe.getAlias());
        tvMarca.setText(cotxe.getMarca());
        tvModel.setText(cotxe.getModel());
        tvCilindrada.setText(String.valueOf(cotxe.getCilindrada()));
        tvTelefon.setText(String.valueOf(cotxe.getTelefon()));
        chBoxAutomatic.setChecked(cotxe.isAutomatic());
        tvLongitud.setText(String.valueOf(cotxe.getLongitud()));
        tvLatitud.setText(String.valueOf(cotxe.getLatitud()));

        //cridar cotxe seleccionat
        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode()==RESULT_OK){
                    Cotxe infoCotxe = result.getData().getParcelableExtra("cotxe_modificar");
                    tvPlate.setText(infoCotxe.getAlias());
                    tvMarca.setText(infoCotxe.getMarca());
                    tvModel.setText(infoCotxe.getModel());
                    tvCilindrada.setText(String.valueOf(infoCotxe.getCilindrada()));
                    tvTelefon.setText(infoCotxe.getTelefon());
                    chBoxAutomatic.setChecked(infoCotxe.isAutomatic());
                    tvLatitud.setText(String.valueOf(infoCotxe.getLatitud()));

                    Intent resultat = new Intent(getApplicationContext(), MainActivity.class);
                    //resultat.putExtra("tipus", MainActivity.UPDATE);
                    resultat.putExtra("modifyCotxe", infoCotxe);
                    setResult(RESULT_OK, resultat);
                    activity.finish();

                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_datail_cotxe, menu);
        return true;
    }
}