package com.martintecno.tp7;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.Manifest;
import com.martintecno.tp7.databinding.ActivityLoginBinding;
import com.martintecno.tp7.databinding.ActivityMainBinding;

import com.martintecno.tp7.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private LoginActivityViewModel VmLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M
                && (checkSelfPermission(ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED)  ||
                (checkSelfPermission(ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED)){
            requestPermissions(new String[]{ACCESS_FINE_LOCATION,ACCESS_COARSE_LOCATION},1000);
        }



        ActivityLoginBinding binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        VmLogin = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginActivityViewModel.class);
        binding.BTNLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VmLogin.LogearUsuario(binding.ITUsuario.getText().toString(),binding.ITContraseA.getText().toString());
            }
        });

        VmLogin.CartelM().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.TVNotificaciones.setText(s);
            }
        });

    }
}