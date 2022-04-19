package com.example.farmapp.views;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.farmapp.R;
import com.google.firebase.auth.FirebaseAuth;


public class SignUpFragment extends Fragment {
    //Initialize the variables
    EditText editTextTextPersonName3, editTextTextPersonName4, editTextTextPassword4, editTextTextPassword5 ;
    Button sign_up;

    FirebaseAuth mAuth;


    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_sign_up);

//        EditText editTextTextPersonName3 = (EditText) findViewById(R.layout.editTextTextPersonName3);
//        editTextTextPersonName4 = (EditText) findViewById(R.layout.editTextTextPersonName4);
//        editTextTextPassword4 = (EditText) findViewById(R.layout.editTextPassword4);
//        editTextTextPassword5 = (EditText) findViewById(R.layout.editTextTextPassword5);
//        sign_up = (Button) findViewById(R.layout.sign_up);

    }

    private void setContentView(int fragment_sign_up) {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }
}