package sound;

import java.io.IOException;

public interface ISound {
	void start();
	
	void stop() throws IOException;
}
