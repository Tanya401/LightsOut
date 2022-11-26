package com.example.myapplication;

public class movie {
    String censor;
    String duration;
    String movieName;
    String poster;
    String releaseDate;
    String synopsis;
    String available;
    public movie(){

    }

    public movie(String censor,  String duration, String movieName, String poster, String releaseDate, String synopsis, String available) {
        this.censor = censor;
        this.duration = duration;
        this.movieName = movieName;
        this.poster = poster;
        this.releaseDate = releaseDate;
        this.synopsis = synopsis;
        this.available = available;
    }

    public String getCensor() {
        return censor;
    }

    public void setCensor(String censor) {
        this.censor = censor;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

}
