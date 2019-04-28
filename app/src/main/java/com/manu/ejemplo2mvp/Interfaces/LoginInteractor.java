package com.manu.ejemplo2mvp.Interfaces;

public interface LoginInteractor {

    // OJO!! Como tercer parametro un objeto de tipo OnLoginFinishListener para acceder
    // al presentador desde el Interactor
    void validarUser(String user,String pass, OnLoginFinishListener listener);
}
