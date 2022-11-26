package com.example.myapplication;

import java.util.List;

public class ParentModelBottomSlider {
    public ParentModelBottomSlider(String gname, List<ChildModelBottomSlider> posters) {
        this.Gname = gname;
        this.Posters = posters;
    }

    public ParentModelBottomSlider() {
    }

    public String getGname() {
        return Gname;
    }

    public void setGname(String gname) {
        this.Gname = gname;
    }

    public List<ChildModelBottomSlider> getPosters() {
        return Posters;
    }

    public void setPosters(List<ChildModelBottomSlider> posters) {
        this.Posters = posters;
    }

    String Gname;
    List<ChildModelBottomSlider> Posters;





}
