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
	Image imgdown,imgleft,imgright,imgup,currentImg,imgl1,imgl2,imgr1,imgr2,imgu1,imgu2,imgd1,imgd2;
	int a=1,x=100,y=120;
	public MainCanvas(){
	try
	{
		imgdown=Image.createImage("/sayo10.png");
		imgup=Image.createImage("/sayo14.png");
		imgleft=Image.createImage("/sayo12.png");
		imgright=Image.createImage("/sayo16.png");
		imgl1=Image.createImage("/sayo02.png");
		imgl2=Image.createImage("/sayo22.png");
		imgr1=Image.createImage("/sayo06.png");
		imgr2=Image.createImage("/sayo26.png");
		imgu1=Image.createImage("/sayo04.png");
		imgu2=Image.createImage("/sayo24.png");
		imgd1=Image.createImage("/sayo00.png");
		imgd2=Image.createImage("/sayo20.png");
		currentImg=imgdown;
	}

	catch (IOException e)
	{
		e.printStackTrace();
	}
	}
	public void paint(Graphics g){
		g.setColor(255,125,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
	   int action=getGameAction(keyCode);
	   if(action==LEFT)
		   {
		   if(a==1){a++;currentImg=imgl1;}
		   else if(a==2){a--;currentImg=imgl2;}
		   x=x-3;
		    repaint();
		   }
	   else if(action==RIGHT)
		    {
		   if(a==1){a++;currentImg=imgr1;}
		   else if(a==2){a--;currentImg=imgr2;}
		   x=x+3;
		    repaint();
		   }

	   else if(action==UP)
		    {
		   if(a==1){a++;currentImg=imgu1;}
		   else if(a==2){a--;currentImg=imgu2;}
		  y=y-3;
		    repaint();
		   }
	   else if(action==DOWN)
		    {
		   if(a==1){a++;currentImg=imgd1;}
		   else if(a==2){a--;currentImg=imgd2;}
		   y=y+3;
		    repaint();
		   }
	}
}