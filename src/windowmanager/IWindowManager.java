package windowmanager;

import player.*;

public interface IWindowManager {
    // Rendering the window.
    void update();
    
    void addPlayer(Player player);
    void showWindow();
}