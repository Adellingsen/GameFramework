import windowmanager.*;
import player.*;
import sound.*;

public class Main {

static int WIDTH = 1000;
static int HEIGHT = 1000;

public static void main(String args[]) {
    WindowManager windowManager = new WindowManager("GameFramework", WIDTH, HEIGHT);
    Player player = new Player("Mario", "assets/Mario.png");
    Sound sound = new Sound("assets/MarioTheme.wav");
    
    sound.start();
    windowManager.addPlayer(player);
    windowManager.showWindow();
    while (true) {
    	windowManager.update();
    }
    
}

}