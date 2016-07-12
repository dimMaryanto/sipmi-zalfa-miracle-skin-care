package aplikasi;

import aplikasi.view.MainMenuView;
import java.util.Locale;
import javax.swing.SwingUtilities;

/**
 *
 * @author dimmaryanto
 */
public class MainAplikasi {

    public static void main(String[] args) {
        Locale.setDefault(new Locale("in", "ID"));
        SwingUtilities.invokeLater(() -> {
            MainMenuView mainMenu = new MainMenuView();
            mainMenu.setTitle("SIPMI - Zalfa Miracle Skin Care");
            mainMenu.setLocationRelativeTo(null);
            mainMenu.setVisible(true);
        });
    }

}
