package com.example.myapplication;

import static android.os.FileObserver.DELETE;
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
    //AFEGIR UN UPDATE


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
                            Cotxe cotxe = result.getData().getParcelableExtra("afegirCotxe");
                            llistaCotxes.add(cotxe);
                            cotxeAdapter.notifyDataSetChanged();
                            break;
                        case DELETE:
                            Cotxe deleteCar = result.getData().getParcelableExtra("eliminarCotxe");
                            int positionDeleteCar = positionOfCar(deleteCar);
                            llistaCotxes.remove(positionDeleteCar);
                            cotxeAdapter.notifyItemRemoved(positionDeleteCar);
                            break;
                        /*case UPDATE:
                            Cotxe modifyCar = result.getData().getParcelableExtra("actualitzarCotxe");
                            int positionModifyCar = positionOfCar(modifyCar);
                            llistaCotxes.remove(positionModifyCar);
                            cotxeAdapter.notifyItemRemoved(positionModifyCar);
                            llistaCotxes.add(modifyCar);
                            cotxeAdapter.notifyDataSetChanged();
                        */
                    }
                }
            }
        });

        if (savedInstanceState == null) {
            createDummyContent();
            cotxeAdapter = new CotxeAdapter(llistaCotxes);
            cotxeAdapter.setClickListener(this);
            recyclerView.setAdapter(cotxeAdapter);

        }

    }

    private void createDummyContent() {
        llistaCotxes.add(new Cotxe("1234DYD", "SEAT", "IBIZA", 23, "64323232", false, 444, 444));
        llistaCotxes.add(new Cotxe("9843FFF", "SEAT", "LEON", 40, "64323232", true, 444, 444));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(getApplicationContext(), AfegirCotxe.class);
        intent.putExtra("llista_cotxes",llistaCotxes);
        intent.putExtra("tipus", ADD);
        activityResultLauncher.launch(intent);

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view, int position){
      Intent intent = new Intent(getApplicationContext(), infoCotxe.class);
      intent.putExtra("cotxe", llistaCotxes.get(position));
      activityResultLauncher.launch(intent);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            layoutManager = new GridLayoutManager(this, 2);
        } else {
            layoutManager = new LinearLayoutManager(this);
        }
        recyclerView.setLayoutManager(layoutManager);
    }

    private int positionOfCar(Cotxe cotxe) {
        String carId = cotxe.getAlias();
        int position = 0;
        for (int index = 0; index < llistaCotxes.size(); index++) {
            if (llistaCotxes.get(index).getAlias().equals(carId)) {
                position = index;
            }
        }
        return position;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelableArrayList("llistaCotxes", llistaCotxes);
        super.onSaveInstanceState(outState);
    }
}