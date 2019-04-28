package com.manu.ejemplo2mvp.Interfaces;

public interface LoginView {
    // Aqui solo habrá metodos que controlen acciones en la VISTA

    void showProgress();
    void hideProgress();

    void setErrorUser();
    void setErrorPassword();
    void navigateToHome();

}
