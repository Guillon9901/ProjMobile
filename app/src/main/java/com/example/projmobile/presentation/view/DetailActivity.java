package com.example.projmobile.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projmobile.R;
import com.example.projmobile.Singletons;
import com.example.projmobile.presentation.model.Pokemon;

public class DetailActivity extends AppCompatActivity {

    private TextView txtDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtDetail = findViewById(R.id.detail_txt);
        Intent intent = getIntent();
        String pokemonJson = intent.getStringExtra(getString(R.string.key_pokemon));
        Pokemon pokemon = Singletons.getGson().fromJson(pokemonJson, Pokemon.class);
        showDetail(pokemon);

    }

    private void showDetail(Pokemon pokemon) {
        txtDetail.setText(pokemon.getName());

    }
}
