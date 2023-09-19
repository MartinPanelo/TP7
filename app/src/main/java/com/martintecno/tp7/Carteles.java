package com.martintecno.tp7;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

public class Carteles {


    public static void CartelSalir(Activity activity){

        new AlertDialog.Builder(activity)
                .setTitle("Salir de la aplicacion")
                .setMessage("Esta seguro que quiere salir?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        activity.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(activity,"Continua la aplicacion", Toast.LENGTH_LONG).show();
                    }
                })
                .show();
    }
}