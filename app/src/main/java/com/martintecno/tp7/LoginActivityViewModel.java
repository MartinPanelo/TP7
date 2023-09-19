package com.martintecno.tp7;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class LoginActivityViewModel extends AndroidViewModel {
    String user = "martin"; //taria para usar un modelo
    String pass = "123456";

    private Context context;

    private MutableLiveData<String> UsuariovalidoM;

    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
        context = application;
    }

    public void LogearUsuario(String u,String p){

        if(user.equals(u) && pass.equals(p) ){
            Intent intent = new Intent(context,MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //  UsuariovalidoM.setValue("Usuario o/y contraseña Correctos");
            context.startActivity(intent);


        }else{

            UsuariovalidoM.setValue("Usuario o/y contraseña incorrectos");

            /* Toast.makeText(context, "Usuario incorrecto", Toast.LENGTH_LONG).show();*/
        }

    }




    public LiveData<String> CartelM(){
        if(UsuariovalidoM == null){
            UsuariovalidoM = new MutableLiveData<String>();
        }
        return UsuariovalidoM;
    }







}
