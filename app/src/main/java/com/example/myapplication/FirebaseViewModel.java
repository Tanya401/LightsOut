package com.example.myapplication;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class FirebaseViewModel extends ViewModel implements FirebaseMethods.OnRealtimeDbTaskComplete {

    private MutableLiveData<List<ParentModelBottomSlider>> parentItemMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<DatabaseError> databaseErrorMutableLiveData = new MutableLiveData<>();
    private FirebaseMethods firebaseMethods;

    public MutableLiveData<DatabaseError> getDatabaseErrorMutableLiveData() {
        return databaseErrorMutableLiveData;
    }

    public MutableLiveData<List<ParentModelBottomSlider>> getParentItemMutableLiveData() {
        return parentItemMutableLiveData;
    }

    public FirebaseMethods getFirebaseMethods() {
        return firebaseMethods;
    }

    public FirebaseViewModel(){
        firebaseMethods = new FirebaseMethods(this);
    }
    public void getAllData()
        {
        firebaseMethods.FetchData();
    }

    @Override
    public void onSucess(List<ParentModelBottomSlider> parentList) {
        parentItemMutableLiveData.setValue(parentList);
    }

    @Override
    public void onFailure(DatabaseError error) {
        databaseErrorMutableLiveData.setValue(error);

    }
}
