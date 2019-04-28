package com.manu.ejemplo2mvp.Interactors;



import android.os.Handler;

import com.manu.ejemplo2mvp.Interfaces.LoginInteractor;
import com.manu.ejemplo2mvp.Interfaces.OnLoginFinishListener;




public class LoginInteractorImpl implements LoginInteractor{
    @Override
    public void validarUser(final String user, final String pass, final OnLoginFinishListener listener) {
        // AQUI VA TODA LA LOGICA DE LA OPERACION
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!user.equals("")&& !pass.equals("")){
                    // LLAMADA AL METODO DEL PRESENTADOR DESDE EL INTERACTOR
                    listener.exitoOperacion();
                }else{
                    if(user.equals("")){
                        // LLAMADA AL METODO DEL PRESENTADOR DESDE EL INTERACTOR
                        listener.usernameError();
                    }
                    if(pass.equals("")){
                        // LLAMADA AL METODO DEL PRESENTADOR DESDE EL INTERACTOR
                        listener.passwordError();
                    }
                }
            }
        },100);
    }
}
