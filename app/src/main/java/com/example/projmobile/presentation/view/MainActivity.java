package com.example.projmobile.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.projmobile.R;
import com.example.projmobile.Singletons;
import com.example.projmobile.presentation.controller.MainController;
import com.example.projmobile.presentation.model.Pokemon;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ListAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new MainController(
                this,
                Singletons.getGson(),
                Singletons.getSharedPreferences(getApplicationContext())
        );
        controller.onStart();
    }



    public void showList(List<Pokemon> pokemonList) {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // define an adapter
        mAdapter = new ListAdapter(pokemonList, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Pokemon item) {
                controller.onItemClick(item);
            }
        });
        recyclerView.setAdapter(mAdapter);
    }




    public void showError() {
        Toast.makeText(getApplicationContext(), "API Error", Toast.LENGTH_SHORT).show();
    }

    public void navigateToDetails(Pokemon pokemon) {
        Toast.makeText(getApplicationContext(), "Navigation à créer", Toast.LENGTH_SHORT).show();
    }
}
