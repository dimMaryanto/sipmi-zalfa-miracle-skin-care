package aplikasi;

import aplikasi.view.MainMenu;
import javax.swing.SwingUtilities;

/**
 *
 * @author dimmaryanto
 */
public class MainAplikasi {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenu mainMenu = new MainMenu();
            mainMenu.setTitle("SIPMI - Zalfa Miracle Skin Care");
            mainMenu.setLocationRelativeTo(null);
            mainMenu.setVisible(true);
        });
    }

}
