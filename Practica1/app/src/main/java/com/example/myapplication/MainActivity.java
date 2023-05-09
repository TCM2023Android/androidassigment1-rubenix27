package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    CotxeAdapter cotxeAdapter;

    RecyclerView.LayoutManager layoutManager;
    ArrayList<Cotxe> dataSet;

    AfegirCotxe afegirCotxe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSet = new ArrayList<>();

        recyclerView = findViewById(R.id.list);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);


        if (savedInstanceState == null) {
            createDummyContent();
            afegirCotxe = new AfegirCotxe(dataSet);
            recyclerView.setAdapter(cotxeAdapter);

        }

    }

    private void createDummyContent() {
        dataSet.add(new Cotxe("1234DYD", "SEAT", "IBIZA", 23, 64323232, false, 444, 444));
        //String alias, String marca, String model, double cilindrada, long telefon, boolean automatic, double longitud, double latitud
        // dataSet.add(new Task("Task 2", "Seat"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_add:
                Log.v("Menú", "menu clicked");

                Intent intent = new Intent(getApplicationContext(), AfegirCotxe.class);
                startActivity(intent);

                break;
        }
        return super.onOptionsItemSelected(item);
    }

}