import br.com.alura.luraBuy.Principal.LogicaMenu;
import br.com.alura.luraBuy.Principal.Principal;

public class Main {
    public static void main(String[] args) {
        Principal principal = new Principal();
        LogicaMenu logicaMenu = new LogicaMenu(principal);

        // Inicia o menu (LogicaMenu cria seu próprio Scanner internamente)
        logicaMenu.logicaMenu();
    }
}
