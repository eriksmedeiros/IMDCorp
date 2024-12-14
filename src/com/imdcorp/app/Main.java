package src.com.imdcorp.app;

import src.com.imdcorp.app.dao.BancoDAO;
import src.com.imdcorp.app.view.Menu;

public class Main {
    public static void main(String[] args) {
        BancoDAO banco = BancoDAO.getInstance();
        Menu.menu(banco);
    }
}