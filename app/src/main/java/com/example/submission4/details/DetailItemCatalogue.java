package com.example.submission4.details;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.submission4.FavoriteCatalogueActivity;
import com.example.submission4.R;
import com.example.submission4.models.MoviesData;
import com.example.submission4.models.TVShowsData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

public class DetailItemCatalogue extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_DATA = "extra_data";
    public static final String EXTRA_STRING = "extra_string";

    private MoviesData moviesData;
    private TVShowsData tvShowsData;

    private ArrayList<MoviesData> moviesList = new ArrayList<>();
    private ArrayList<TVShowsData> tvshowsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item_catalogue);
        setTitle(getString(R.string.title_detail));
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        TextView title = findViewById(R.id.detail_name);
        TextView date = findViewById(R.id.detail_date);
        TextView overview = findViewById(R.id.detail_overview);
        ImageView posterblur = findViewById(R.id.detail_poster_blur);
        ImageView poster = findViewById(R.id.detail_poster);

        FloatingActionButton floatingActionButton = findViewById(R.id.btn_favorite);
        floatingActionButton.setOnClickListener(this);

        String string = getIntent().getStringExtra(EXTRA_STRING);
        if (string != null) {
            if (string.equals("movies")) {
                moviesData = getIntent().getParcelableExtra(EXTRA_DATA);
                if (moviesData != null) {
                    title.setText(moviesData.getTitle());
                    date.setText(moviesData.getRelease_date());
                    overview.setText(moviesData.getOverview());
                    Glide.with(this).load(moviesData.getPoster_path()).into(poster);
                }
            } else {
                tvShowsData = getIntent().getParcelableExtra(EXTRA_DATA);
                if (tvShowsData != null) {
                    title.setText(tvShowsData.getTitle());
                    date.setText(tvShowsData.getFirst_airing_date());
                    overview.setText(tvShowsData.getOverview());
                    Glide.with(this).load(tvShowsData.getPoster_path()).into(poster);
                }
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item)
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_favorite) {
            Intent intent = new Intent(DetailItemCatalogue.this, FavoriteCatalogueActivity.class);

            if (moviesData != null) {
                boolean flag = true;
                if (moviesList.size() == 0) {

                }
            }
        }
    }
}
