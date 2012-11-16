package aryaCharacters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import arya.FrameAnimation;
import arya.Unit;

/**
 * 
 * @author youngb2
 * @since Alpha.02
 */
public class Zombie extends Unit {
	
	
	//Overworld frame set ID
	private static final int WAIT = 0;
	private static final int DOWN = 1;
	private static final int SIDE = 2;
	private static final int UP = 3;
	private static final int FOCUS = 4;
	
	//Static coordinate ID
	private static final int X1 = 0;
	private static final int Y1 = 1;
	private static final int X2 = 2;
	private static final int Y2 = 3;
	
	//Number of frames, tracking constants
	public static final int WAIT_FRAMES = 2;
	public static final int MOTION_FRAMES = 4;
	public static final int FOCUS_FRAMES = 3;
	public static final int ATTACK_FRAMES = 24;
	public static final int DODGE_FRAMES = 2;
	
	public static final int FRAME_DURRATION = 250;
	
	Thread frameAnimate;
	
	//Temporary variables
	private int i = 0;
	private int frameX;
	private int frameY;
	private int frameW;
	private int frameH;	
	private Image snip;
	private Image flipped;
	
	//variables for primary animation rendering method
	public Image icon;
	public Animation attack;
	public Animation dodge;
	public Animation down;
	public Animation focus;
	public Animation left;
	public Animation right;
	public Animation up;
	public Animation waitStance;
	
	//variables for animation rendering method 2
	public FrameAnimation animator;
	public Image[] attack2;
	public Image[] dodge2;
	public Image[] down2;
	public Image[] focus2;
	public Image[] left2;
	public Image[] right2;
	public Image[] up2;
	public Image[] waitStance2;
	
	
	//TODO research Image class. Is it possible to search for pixels of a certain color?
	//		If so, see if we can automate the formation of these COORD tables...
	
	/**Data tracking table for the frames of the attack animation
	 * Tracks vertices of individual frames in the form x1,y1,x2,y2 */
	private static final int[][] ATTACK_COORDS =     { {  34,  27,  64,  59 },
		                                               {  69,  27, 106,  59 },
		                                               { 117,  26, 150,  59 },
		                                               { 154,  27, 182,  59 },
		                                               { 190,  25, 220,  59 },
		                                               { 231,  26, 262,  59 },
		                                               { 275,  27, 304,  59 },
		                                               { 314,  23, 343,  59 },
		                                               { 355,  20, 382,  59 },
		                                               { 390,  19, 421,  59 },
		                                               { 433,   6, 463,  59 },
        	                                           { 481,   9, 509,  59 },
		                                               {  13,  73,  62, 123 },
		                                               {  74, 104, 125, 123 },
		                                               { 132, 103, 182, 123 },
		                                               { 188,  98, 235, 123 },
		                                               { 246,  84, 273, 122 },
		                                               { 280,  86, 307, 124 },
		                                               { 312,  85, 123, 123 },
		                                               { 342,  88, 367, 122 },
		                                               { 378,  86, 404, 121 },
		                                               { 411,  86, 439, 121 },
		                                               { 448,  87, 473, 121 },
		                                               { 482,  89, 514, 122 } };
	
	/**Data tracking table for the frames of the dodge animation
	 * Tracks vertices of individual frames in the form x1,y1,x2,y2*/
	private static final int[][] DODGE_COORDS = {  { 218, 232, 248, 267 },
		                                               { 256, 232, 285, 267 } };
	/**Data tracking table for the unit's icon frame
	 * Tracks vertices of individual frames in the form x1,y1,x2,y2*/
	private static final int[] ICON_COORDS = { 296, 250, 338, 311 };
	
	/**Data tracking table for the frames of the unit's overworld sprite
	 * Tracks vertices of individual frames in the form x1,y1,x2,y2*/
	private static final int[][][] OVERWORLD_COORDS = { { {  10, 250,  24, 265 },	//Wait frames
		                                                      {  30, 249,  44, 265 } }, 
		                                                    { {  53, 247,  73, 265 },	//Front frames
		                                                      {  78, 247,  97, 265 },
		                                                      { 108, 247, 127, 265 },
		                                                      { 133, 147, 153, 265 } },
		                                                    { {   7, 273,  27, 289 },   //Left side frames
		                                                      {  31, 271,  50, 288 },	//Mirror for right
		                                                      {  55, 272,  74, 288 },
		                                                      {  78, 271,  98, 288 } },
		                                                    { { 104, 270, 123, 287 },   //Back Frames
		                                                      { 128, 270, 147, 288 },
		                                                      { 151, 270, 170, 287 },
		                                                      { 174, 270, 193, 288 } },
		                                                    { {  84, 293, 101, 311 },	//Focus frames
		                                                      { 106, 293, 125, 311 },
		                                                      { 132, 293, 151, 311 } } };
	/**
	 * Default constructor for Zombie
	 * Gets unit sprite sheet and initializes animations from sub-images of the sprite sheet
	 * @throws SlickException
	 */
	public Zombie() throws SlickException {
		characterSheet = new Image("/data/spriteResources/zombie.png");
		
		initAttackAnimation();
		initDodgeAnimation();
		initDownAnimation();
		initFocusAnimation();
		initIconAnimation();
		initLeftAnimation();
		initRightAnimation();
		initUpAnimation();
		initWaitAnimation();
	}

	public void drawAttack(int x, int y) {
		attack.draw(x, y);
		animator = new FrameAnimation(attack2, x, y, FRAME_DURRATION);
	}
	
	public void drawDodge(int x, int y) {
		dodge.draw(x, y);
	}
	
	public void drawDown(int x, int y) {
		down.draw(x, y);
	}
	
	public void drawFocus(int x, int y) {
		focus.draw(x, y);
	}
	
	public void drawLeft(int x, int y) {
		left.draw(x, y);
	}
	
	public void drawRight(int x, int y) {
		right.draw(x, y);
	}
	
	public void drawUp(int x, int y) {
		up.draw(x, y);
	}
	
	public void drawWait(int x, int y) {
		waitStance.draw(x, y);
	}
	
	
	//TODO because these init() are so similarly formatted, research automation.
	//		Is it possible to create a default init() and pass it the unique values
	//		while maintaining the same end results?
	
	private void initAttackAnimation() {
		attack = new Animation();
		attack2 = new Image[ATTACK_FRAMES];
		for (i = 0; i < ATTACK_FRAMES; i++) {
			frameX = ATTACK_COORDS[i][X1];
			frameY = ATTACK_COORDS[i][Y1];
			frameW = ATTACK_COORDS[i][X2] - ATTACK_COORDS[i][X1];
			frameH = ATTACK_COORDS[i][Y2] - ATTACK_COORDS[i][Y1];
			snip = characterSheet.getSubImage(frameX, frameY, frameW, frameH);
			attack2[i] = snip;
			attack.addFrame(snip, FRAME_DURRATION);
		}
	}
	
	private void initDodgeAnimation() {
		dodge = new Animation();
		for (i = 0; i < DODGE_FRAMES; i++) {
			frameX = DODGE_COORDS[i][X1];
			frameY = DODGE_COORDS[i][Y1];
			frameW = DODGE_COORDS[i][X2] - DODGE_COORDS[i][X1];
			frameH = DODGE_COORDS[i][Y2] - DODGE_COORDS[i][Y1];
			snip = characterSheet.getSubImage(frameX, frameY, frameW, frameH);
			dodge.addFrame(snip, FRAME_DURRATION);
		}
	}
	
	private void initDownAnimation() {
		down = new Animation();
		for (i = 0; i < MOTION_FRAMES; i++) {
			frameX = OVERWORLD_COORDS[DOWN][i][X1];
			frameY = OVERWORLD_COORDS[DOWN][i][Y1];
			frameW = OVERWORLD_COORDS[DOWN][i][X2] - OVERWORLD_COORDS[DOWN][i][X1];
			frameH = OVERWORLD_COORDS[DOWN][i][Y2] - OVERWORLD_COORDS[DOWN][i][Y1];
			snip = characterSheet.getSubImage(frameX, frameY, frameW, frameH);
			down.addFrame(snip, FRAME_DURRATION);
		}
	}
	
	private void initFocusAnimation() {
		focus = new Animation();
		for (i = 0; i < FOCUS_FRAMES; i++) {
			frameX = OVERWORLD_COORDS[FOCUS][i][X1];
			frameY = OVERWORLD_COORDS[FOCUS][i][Y1];
			frameW = OVERWORLD_COORDS[FOCUS][i][X2] - OVERWORLD_COORDS[FOCUS][i][X1];
			frameH = OVERWORLD_COORDS[FOCUS][i][Y2] - OVERWORLD_COORDS[FOCUS][i][Y1];
			snip = characterSheet.getSubImage(frameX, frameY, frameW, frameH);
			focus.addFrame(snip, FRAME_DURRATION);
		}
	}
	
	private void initIconAnimation() {
		frameX = ICON_COORDS[X1];
		frameY = ICON_COORDS[Y1];
		frameW = ICON_COORDS[X2] - ICON_COORDS[X1];
		frameH = ICON_COORDS[Y2] - ICON_COORDS[Y1];
		icon = characterSheet.getSubImage(frameX, frameY, frameW, frameH);
	}
	
	private void initLeftAnimation() {
		left = new Animation();
		for (i = 0; i < MOTION_FRAMES; i++) {
			frameX = OVERWORLD_COORDS[SIDE][i][X1];
			frameY = OVERWORLD_COORDS[SIDE][i][Y1];
			frameW = OVERWORLD_COORDS[SIDE][i][X2] - OVERWORLD_COORDS[SIDE][i][X1];
			frameH = OVERWORLD_COORDS[SIDE][i][Y2] - OVERWORLD_COORDS[SIDE][i][Y1];
			snip = characterSheet.getSubImage(frameX, frameY, frameW, frameH);
			left.addFrame(snip, FRAME_DURRATION);
		}
	}
	
	private void initRightAnimation() {
		right = new Animation();
		for (i = 0; i < MOTION_FRAMES; i++) {
			frameX = OVERWORLD_COORDS[SIDE][i][X1];
			frameY = OVERWORLD_COORDS[SIDE][i][Y1];
			frameW = OVERWORLD_COORDS[SIDE][i][X2] - OVERWORLD_COORDS[SIDE][i][X1];
			frameH = OVERWORLD_COORDS[SIDE][i][Y2] - OVERWORLD_COORDS[SIDE][i][Y1];
			snip = characterSheet.getSubImage(frameX, frameY, frameW, frameH);
			flipped = snip.getFlippedCopy(false, true); //Get flipped image on the y axis
			right.addFrame(flipped, FRAME_DURRATION);
		}
	}
	
	private void initUpAnimation() {
		up = new Animation();
		for (i = 0; i < MOTION_FRAMES; i++) {
			frameX = OVERWORLD_COORDS[UP][i][X1];
			frameY = OVERWORLD_COORDS[UP][i][Y1];
			frameW = OVERWORLD_COORDS[UP][i][X2] - OVERWORLD_COORDS[UP][i][X1];
			frameH = OVERWORLD_COORDS[UP][i][Y2] - OVERWORLD_COORDS[UP][i][Y1];
			snip = characterSheet.getSubImage(frameX, frameY, frameW, frameH);
			up.addFrame(snip, FRAME_DURRATION);
		}
	}
	
	private void initWaitAnimation() {
		waitStance = new Animation();
		for (i = 0; i < WAIT_FRAMES; i++) {
			frameX = OVERWORLD_COORDS[WAIT][i][X1];
			frameY = OVERWORLD_COORDS[WAIT][i][Y1];
			frameW = OVERWORLD_COORDS[WAIT][i][X2] - OVERWORLD_COORDS[WAIT][i][X1];
			frameH = OVERWORLD_COORDS[WAIT][i][Y2] - OVERWORLD_COORDS[WAIT][i][Y1];
			snip = characterSheet.getSubImage(frameX, frameY, frameW, frameH);
			waitStance.addFrame(snip, FRAME_DURRATION);
		}
	}
	
	public void paintSprites(int x, int y) {
		characterSheet.draw(x, y);
	}
}
