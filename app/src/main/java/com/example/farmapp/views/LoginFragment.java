package com.example.farmapp.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.farmapp.R;
import com.example.farmapp.viewmodels.AuthViewModel;
import com.google.firebase.auth.FirebaseUser;


public class LoginFragment extends Fragment {

    private EditText phoneEmailField, passwordField;
    private Button buttonLogin, createNewUser;
    private TextView textView4;
    private ImageView imageView3;
    private AuthViewModel viewModel;
    private NavController navController;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory
                .getInstance(getActivity().getApplication())).get(AuthViewModel.class);
        viewModel.getUserData().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if (firebaseUser != null){
                    navController.navigate(R.id.action_login_to_shopFragment);
                }
            }
        });
    }

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        phoneEmailField = view.findViewById(R.id.phoneEmailField);
        //editEmailUsername = view.findViewById(R.id.editEmailUsername);
        passwordField = view.findViewById(R.id.passwordField);
        buttonLogin = view.findViewById(R.id.buttonLogin);
        textView4 = view.findViewById(R.id.textView4);
        imageView3 = view.findViewById(R.id.imageView3);
        createNewUser = view.findViewById(R.id.createNewUser);

        navController = Navigation.findNavController(view);

        createNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_signUpFragment_to_login);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = phoneEmailField.getText().toString();
                String pass = passwordField.getText().toString();
                if (!email.isEmpty() && !pass.isEmpty()){
                    viewModel.signIn(email, pass);
                }
            }
        });
    }

}
