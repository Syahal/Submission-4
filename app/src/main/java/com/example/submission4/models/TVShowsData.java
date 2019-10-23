package com.example.submission4.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TVShowsData implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int prKey;
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "poster_path")
    private String poster_path;
    @ColumnInfo(name = "overview")
    private String overview;
    @ColumnInfo(name = "first_airing_date")
    private String first_airing_date;
    @ColumnInfo(name = "original_language")
    private String language;

    public TVShowsData() {

    }

    public int getPrKey() {
        return prKey;
    }

    public void setPrKey(int prKey) {
        this.prKey = prKey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getFirst_airing_date() {
        return first_airing_date;
    }

    public void setFirst_airing_date(String first_airing_date) {
        this.first_airing_date = first_airing_date;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(prKey);
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(poster_path);
        parcel.writeString(overview);
        parcel.writeString(first_airing_date);
        parcel.writeString(language);
    }

    protected TVShowsData(Parcel in) {
        prKey = in.readInt();
        id = in.readInt();
        title = in.readString();
        poster_path = in.readString();
        overview = in.readString();
        first_airing_date = in.readString();
        language = in.readString();
    }

    public static final Creator<TVShowsData> CREATOR = new Creator<TVShowsData>() {
        @Override
        public TVShowsData createFromParcel(Parcel in) {
            return new TVShowsData(in);
        }

        @Override
        public TVShowsData[] newArray(int size) {
            return new TVShowsData[size];
        }
    };
}
