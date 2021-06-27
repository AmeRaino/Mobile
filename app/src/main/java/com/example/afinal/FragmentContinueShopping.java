package com.example.afinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.ornach.nobobutton.NoboButton;

import org.jetbrains.annotations.NotNull;

public class FragmentContinueShopping extends Fragment {

    private NoboButton btnContinueShopping;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_continue_shopping, container, false);
        btnContinueShopping = v.findViewById(R.id.btnContinueShopping);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnContinueShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                NavController navController = Navigation.findNavController(activity, R.id.host_fragment);
                navController.navigate(R.id.action_fragmentContinueShopping_to_homeFragment);
            }
        });
    }
}