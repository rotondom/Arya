package arya;

import org.newdawn.slick.Image;

public class FrameAnimation implements Runnable {
	
	Image[] sprite;
	
	int x;
	int y;
	int time;

	public FrameAnimation(Image[] sprite, int xPos, int yPos, int delay) {
		this.sprite = sprite;
		this.x = xPos;
		this.y = yPos;
		this.time = delay;
	}
	
	@Override
	public void run() {
		for(Image i : sprite) {
			i.draw(x, y);
			try {
				this.wait(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
