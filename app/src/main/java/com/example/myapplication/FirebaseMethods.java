package com.example.myapplication;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseMethods {
    private DatabaseReference databaseReference;
    private OnRealtimeDbTaskComplete onRealtimeDbTaskComplete;

    public FirebaseMethods(OnRealtimeDbTaskComplete onRealtimeDbTaskComplete) {
        this.onRealtimeDbTaskComplete = onRealtimeDbTaskComplete;
        databaseReference = FirebaseDatabase.getInstance().getReference().child("/Dashboard/BottomSliders");
    }
    public void FetchData(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<ParentModelBottomSlider> parentItem = new ArrayList<>();
                for(DataSnapshot ds:snapshot.getChildren())
                {
                    ParentModelBottomSlider parentModelBottomSlider = new ParentModelBottomSlider();
                    parentModelBottomSlider.setGname(ds.child("Gname").getValue(String.class));

                    GenericTypeIndicator<ArrayList<ChildModelBottomSlider>> genericTypeIndicator = new GenericTypeIndicator<ArrayList<ChildModelBottomSlider>>(){};
                    parentModelBottomSlider.setPosters(ds.child("Posters").getValue(genericTypeIndicator));
                    parentItem.add(parentModelBottomSlider);
                }
                onRealtimeDbTaskComplete.onSucess(parentItem);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                onRealtimeDbTaskComplete.onFailure(error);

            }
        });
    }

    public interface OnRealtimeDbTaskComplete{
        void onSucess(List<ParentModelBottomSlider> parentList);
        void onFailure(DatabaseError error);
    }
}
