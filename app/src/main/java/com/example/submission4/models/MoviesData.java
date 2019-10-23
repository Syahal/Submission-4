package com.example.submission4.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MoviesData implements Parcelable {

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
    @ColumnInfo(name = "release_date")
    private String release_date;
    @ColumnInfo(name = "original_language")
    private String language;

    public MoviesData() {

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

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    protected MoviesData(Parcel in) {
        prKey = in.readInt();
        id = in.readInt();
        title = in.readString();
        poster_path = in.readString();
        overview = in.readString();
        release_date = in.readString();
    }

    public static final Creator<MoviesData> CREATOR = new Creator<MoviesData>() {
        @Override
        public MoviesData createFromParcel(Parcel in) {
            return new MoviesData(in);
        }

        @Override
        public MoviesData[] newArray(int size) {
            return new MoviesData[size];
        }
    };

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
        parcel.writeString(release_date);
    }
}
