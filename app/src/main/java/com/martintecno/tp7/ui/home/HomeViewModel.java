package com.martintecno.tp7.ui.home;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends AndroidViewModel {

    private Context context;


    public HomeViewModel(@NonNull Application application) {
        super(application);
        this.context = application;
    }

    




}