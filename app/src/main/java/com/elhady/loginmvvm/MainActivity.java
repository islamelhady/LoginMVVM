package com.elhady.loginmvvm;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.elhady.loginmvvm.Interface.LoginResultCallbacks;
import com.elhady.loginmvvm.ViewModel.LoginViewModel;
import com.elhady.loginmvvm.ViewModel.LoginViewModelFactory;
import com.elhady.loginmvvm.databinding.ActivityMainBinding;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements LoginResultCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(ViewModelProviders.of(this,new LoginViewModelFactory(this))
        .get(LoginViewModel.class));
    }

    @Override
    public void onSuccess(String message) {
        Toasty.success(this,"Login Sucdess", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onError(String message) {
        Toasty.success(this,"Login Erorr", Toast.LENGTH_LONG).show();


    }
}
