package com.manu.ejemplo2mvp.Presenter;

import com.manu.ejemplo2mvp.Interactors.LoginInteractorImpl;
import com.manu.ejemplo2mvp.Interfaces.LoginInteractor;
import com.manu.ejemplo2mvp.Interfaces.LoginPresenter;
import com.manu.ejemplo2mvp.Interfaces.LoginView;
import com.manu.ejemplo2mvp.Interfaces.OnLoginFinishListener;

public class LoginPresenterImpl implements LoginPresenter , OnLoginFinishListener {

    // El presentador es el puente que comunica la VISTA con el INTERACTOR(COMO UN LISTENER)
    private LoginView view;
    private LoginInteractor interactor;

    // Al constructor le pasamos la VISTA
    public LoginPresenterImpl(LoginView view) {
        this.view = view;
        // Inicializamos con la CLASE y le pasamos como parametro
        interactor = new LoginInteractorImpl();
    }

    @Override
    public void validarUsuario(String user, String password) {
        if(view!=null) {
            view.hideProgress();
            // Llamamos al metodo del interactor y le pasamos esta clase que es el presentador
            // para que puedan comunicarse
            interactor.validarUser(user,password,this);
        }
    }

    @Override
    public void usernameError() {
        if(view!=null){
            view.hideProgress();
            view.setErrorUser();
        }
    }

    @Override
    public void passwordError() {
        if(view!=null){
            view.hideProgress();
            view.setErrorPassword();
        }
    }

    @Override
    public void exitoOperacion() {
        if(view!=null){
            view.hideProgress();
            view.navigateToHome();
        }
    }
}
