package support.spec_helper;

import features.pages.lojinha.ListaProdutosPage;
import features.pages.lojinha.LoginPage;

public class InitializePage {
    public static LoginPage paginaLogin(){
        return new LoginPage();
    }
    public static ListaProdutosPage paginaListaProdutos(){
        return new ListaProdutosPage();
    }
}
