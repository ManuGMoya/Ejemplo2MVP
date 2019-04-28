package com.manu.ejemplo2mvp.Vistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.manu.ejemplo2mvp.Interfaces.LoginPresenter;
import com.manu.ejemplo2mvp.Interfaces.LoginView;
import com.manu.ejemplo2mvp.Presenter.LoginPresenterImpl;
import com.manu.ejemplo2mvp.R;

public class Login extends AppCompatActivity implements LoginView {

    private EditText user,password;
    private ProgressBar progressBar;

    //Nos traemos la INTERFACE(no la clase) del presentador para comunicacion Vista-Presenter
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        user = findViewById(R.id.edtUsername);
        password = findViewById(R.id.edtPassword);
        progressBar = findViewById(R.id.pbCarga);

        // OJO!! Inicializamos una CLASE(No de la Interface) que implementa LoginPresenter
        // Le pasamos la vista al presentador por pasametro
        presenter = new LoginPresenterImpl(this);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setErrorUser() {
        user.setError("Campo obligatorio");
    }

    @Override
    public void setErrorPassword() {
        password.setError("Campo obligatorio");
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(Login.this,PrincipalMenu.class);
        startActivity(intent);
    }


    public void onClickValidacion(View view) {
        // Llamamos al metodo del presenter
        presenter.validarUsuario(user.getText().toString(),password.getText().toString());
    }
}
