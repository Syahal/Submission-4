package com.example.submission4.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.submission4.R;
import com.example.submission4.details.DetailItemCatalogue;
import com.example.submission4.models.MoviesData;
import com.example.submission4.models.TVShowsData;

import java.util.ArrayList;

public class CatalgoueAdapter extends RecyclerView.Adapter<CatalgoueAdapter.MyCatalogueHolder> {
    private Context context;
    private ArrayList<MoviesData> moviesData;
    private ArrayList<TVShowsData> tvShowsData;

    public CatalgoueAdapter(Context context, ArrayList<MoviesData> moviesData, ArrayList<TVShowsData> tvShowsData) {
        this.context = context;
        this.moviesData = moviesData;
        this.tvShowsData = tvShowsData;
    }

    public void setMoviesData(ArrayList<MoviesData> movies) {
        moviesData.clear();
        moviesData.addAll(movies);
        notifyDataSetChanged();
    }

    public void setTVShowsData(ArrayList<TVShowsData> tvshows) {
        tvShowsData.clear();
        tvShowsData.addAll(tvshows);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CatalgoueAdapter.MyCatalogueHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.catalogue_list, parent, false);
        return new MyCatalogueHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatalgoueAdapter.MyCatalogueHolder holder, int position) {
        if (moviesData != null) {
            final MoviesData dataMovies = moviesData.get(position);
            holder.title.setText(dataMovies.getTitle());
            holder.date.setText(dataMovies.getRelease_date());
            holder.overview.setText(dataMovies.getOverview());
            Glide.with(context)
                    .load(dataMovies.getPoster_path())
                    .into(holder.poster);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent moviesIntent = new Intent(context, DetailItemCatalogue.class);
                    moviesIntent.putExtra(DetailItemCatalogue.EXTRA_DATA, dataMovies);
                    moviesIntent.putExtra(DetailItemCatalogue.EXTRA_STRING, "movies");
                    context.startActivity(moviesIntent);
                }
            });
        } else {
            final TVShowsData dataTVShows = tvShowsData.get(position);
            holder.title.setText(dataTVShows.getTitle());
            holder.date.setText(dataTVShows.getFirst_airing_date());
            holder.overview.setText(dataTVShows.getOverview());
            Glide.with(context)
                    .load(dataTVShows.getPoster_path())
                    .into(holder.poster);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent tvshowsIntent = new Intent(context, DetailItemCatalogue.class);
                    tvshowsIntent.putExtra(DetailItemCatalogue.EXTRA_DATA, dataTVShows);
                    tvshowsIntent.putExtra(DetailItemCatalogue.EXTRA_STRING, "tvshows");
                    context.startActivity(tvshowsIntent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (moviesData != null) {
            return moviesData.size();
        } else {
            return tvShowsData.size();
        }
    }

    public class MyCatalogueHolder extends RecyclerView.ViewHolder {
        ImageView poster;
        TextView title, overview, date;

        public MyCatalogueHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.img_poster);
            title = itemView.findViewById(R.id.tv_name);
            overview = itemView.findViewById(R.id.tv_description);
            date = itemView.findViewById(R.id.tv_date);
        }
    }
}
