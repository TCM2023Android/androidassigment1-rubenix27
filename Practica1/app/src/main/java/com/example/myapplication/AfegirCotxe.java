package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AfegirCotxe extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_cotxe);
    }

    public void recollirDadesCotxe(View view){
        String text = editText.getText().toString();
        Intent resultat = new Intent();
        resultat.putExtra("text_resultat",text);
        setResult(RESULT_OK,resultat);
        finish(); //tanca la pantalla
    }


}
