package com.example.farmapp.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.farmapp.repositories.AuthenticationRepo;
import com.google.firebase.auth.FirebaseUser;

public class AuthViewModel extends AndroidViewModel {

    //creating variables
    private AuthenticationRepo repo;
    private MutableLiveData<FirebaseUser> userData;
    private MutableLiveData<Boolean> loggedStatus;

    public MutableLiveData<FirebaseUser> getUserData() {
        return userData;
    }

    public MutableLiveData<Boolean> getLoggedStatus() {
        return loggedStatus;
    }

    public AuthViewModel(@NonNull Application application) {
        super(application);
        repo = new AuthenticationRepo(application);
        userData = repo.getFirebaseUserMutableLiveData();
        loggedStatus = repo.getUserLoggedMutableLiveData();
    }

    public void register(String email, String pass){
        repo.register(email, pass);
    }

    public void signIn(String email, String pass){
        repo.login(email, pass);
    }

    public void signOut(){
        repo.signOut();
    }
}
