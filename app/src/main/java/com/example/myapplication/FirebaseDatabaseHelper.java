package com.example.myapplication;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private List<movie> movieDesc=new ArrayList<>();
    public interface DataStatus{
        void DataIsLoaded(List<movie> movieDesc,List<String> keys);
        void DataisInserted();
        void DataisUpdated();
        void DataisDeleted();
    }
    public FirebaseDatabaseHelper() {
        mDatabase =FirebaseDatabase.getInstance();
        mReference= mDatabase.getReference("/movieDesc");

    }
    public void moviedescription(final DataStatus dataStatus){
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                movieDesc.clear();
                List<String> keys= new ArrayList<>();
                for(DataSnapshot keyNode : snapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    movie Movie=keyNode.getValue(movie.class);
                    movieDesc.add(Movie);
                }
                dataStatus.DataIsLoaded(movieDesc,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
