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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignUpFragment extends Fragment {

    private EditText editPhoneNumber, editEmailUsername, signUpPassword;
    private Button sign_up, buttonHaveAccount;
    private TextView textView4;
    private ImageView tractor_logo;
    private AuthViewModel viewModel;
    private NavController navController;

    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory
                .getInstance(getActivity().getApplication())).get(AuthViewModel.class);
        viewModel.getUserData().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if (firebaseUser != null){
                    navController.navigate(R.id.action_signUpFragment_to_login);
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editPhoneNumber = view.findViewById(R.id.editPhoneNumber);
        editEmailUsername = view.findViewById(R.id.editEmailUsername);
        signUpPassword = view.findViewById(R.id.signUpPassword);
        sign_up = view.findViewById(R.id.sign_up);
        textView4 = view.findViewById(R.id.textView4);
        tractor_logo = view.findViewById(R.id.tractor_logo);
        buttonHaveAccount = view.findViewById(R.id.buttonHaveAccount);

        navController = Navigation.findNavController(view);

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_signUpFragment_to_login);
            }
        });

        buttonHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmailUsername.getText().toString();
                String pass = signUpPassword.getText().toString();
                if (!email.isEmpty() && !pass.isEmpty()){
                    viewModel.register(email, pass);
                }
            }
        });
    }

}