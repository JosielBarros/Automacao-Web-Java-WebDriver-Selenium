package support.spec_helper;

import features.pages.lojinha.LoginPage;

public class InitializePage {
    public static LoginPage paginaLogin(){
        return new LoginPage();
    }
}
