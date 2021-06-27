package com.example.afinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.ornach.nobobutton.NoboButton;

import Api.EndUserApi;
import Dto.AuthenticateUserDto;
import Model.EndUser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class LoginFragment extends Fragment {

    private NoboButton btnLogin;
    private EditText edtUserName;
    private EditText edtPassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        btnLogin = v.findViewById(R.id.btnLogin);
        edtUserName = v.findViewById(R.id.edtUsername);
        edtPassword = v.findViewById(R.id.edtPassword);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authenticate(v);
            }
        });
    }

    private void authenticate(View v) {
        AuthenticateUserDto authenticateUserDto = new AuthenticateUserDto(edtUserName.getText().toString(), edtPassword.getText().toString());

        EndUserApi.endUserApi.authenticate(authenticateUserDto).enqueue(new Callback<EndUser>() {
            @Override
            public void onResponse(Call<EndUser> call, Response<EndUser> response) {
                Toast.makeText(getContext(), "oke", Toast.LENGTH_SHORT).show();
                EndUser endUserResult = response.body();
                if ( endUserResult != null ) {
                   navigateToHomeFragment(v);
                }
            }
            @Override
            public void onFailure(Call<EndUser> call, Throwable t) {
                Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void navigateToHomeFragment(View v) {
        AppCompatActivity activity = (AppCompatActivity) v.getContext();
        NavController navController = Navigation.findNavController(activity, R.id.host_fragment);
        navController.navigate(R.id.action_loginFragment_to_homeFragment);
    }
}