package aplikasi;

import aplikasi.view.MainMenuView;
import javax.swing.SwingUtilities;

/**
 *
 * @author dimmaryanto
 */
public class MainAplikasi {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenuView mainMenu = new MainMenuView();
            mainMenu.setTitle("SIPMI - Zalfa Miracle Skin Care");
            mainMenu.setLocationRelativeTo(null);
            mainMenu.setVisible(true);
        });
    }

}
