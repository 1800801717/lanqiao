import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	Image imgdown,imgleft,imgright,imgup,currentImg;
	public MainCanvas(){
	try
	{
		imgdown=Image.createImage("/sayo10.png");
		imgup=Image.createImage("/sayo14.png");
		imgleft=Image.createImage("/sayo12.png");
		imgright=Image.createImage("/sayo16.png");
		currentImg=imgdown;
	}

	catch (IOException e)
	{
		e.printStackTrace();
	}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,120,100,0);
	}
	public void keyPressed(int keyCode){
	   int action=getGameAction(keyCode);
	   if(action==LEFT){currentImg=imgleft; repaint();}
	   else if(action==RIGHT){currentImg=imgright; repaint();}
	   else if(action==UP){currentImg=imgup; repaint();}
	   else if(action==DOWN){currentImg=imgdown; repaint();}
	}
}