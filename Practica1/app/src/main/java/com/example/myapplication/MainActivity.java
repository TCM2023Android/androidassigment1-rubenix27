package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;




import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;



import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CotxeAdapter.OnItemClickListener{

    ArrayList<Cotxe> llistaCotxes;
    RecyclerView recyclerView;

    CotxeAdapter cotxeAdapter;

    RecyclerView.LayoutManager layoutManager;

    ActivityResultLauncher<Intent> activityResultLauncher, passingTextResult;
    public static final int ADD = R.id.action_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llistaCotxes = new ArrayList<>();

        recyclerView = findViewById(R.id.list);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        activityResultLauncher= registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode()==RESULT_OK){
                    switch (result.getData().getIntExtra("tipus",0)){
                        case ADD:
                            Cotxe cotxe = result.getData().getParcelableExtra("afegir_cotxe");
                            llistaCotxes.add(cotxe);
                            cotxeAdapter.notifyDataSetChanged();
                            break;
                    }
                }
            }
        });

        if (savedInstanceState == null) {
            createDummyContent();
            cotxeAdapter = new CotxeAdapter(llistaCotxes);
            recyclerView.setAdapter(cotxeAdapter);

        }

    }

    private void createDummyContent() {
        llistaCotxes.add(new Cotxe("1234DYD", "SEAT", "IBIZA", 23, 64323232, false, 444, 444));
        llistaCotxes.add(new Cotxe("9843FFF", "SEAT", "LEON", 40, 64323232, true, 444, 444));
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

                Intent intent = new Intent(this, AfegirCotxe.class);
                intent.putExtra("llista_cotxes",llistaCotxes);
                intent.putExtra("tipus", ADD);
                activityResultLauncher.launch(intent);

                //startActivity(intent);


                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view, int position){
      Intent intent = new Intent(getApplicationContext(), infoCotxe.class);
      intent.putExtra("cotxe", llistaCotxes.get(position));
      activityResultLauncher.launch(intent);
    }









}