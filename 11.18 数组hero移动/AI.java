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
	Image leftImg[]=new Image[3],rightImg[]=new Image[3],upImg[]=new Image[3],downImg[]=new Image[3];
	int a=1,x=100,y=120;
	Image currentImg;
	public MainCanvas(){
	try
	{
		for(int i=0;i<leftImg.length;i++)
		{
			leftImg[i]=Image.createImage("/sayo"+i+"2.png");
		}
		for(int i=0;i<rightImg.length;i++)
		{
			rightImg[i]=Image.createImage("/sayo"+i+"6.png");
		}
		for(int i=0;i<upImg.length;i++)
		{
			upImg[i]=Image.createImage("/sayo"+i+"4.png");
		}
		for(int i=0;i<downImg.length;i++)
		{
			downImg[i]=Image.createImage("/sayo"+i+"0.png");
		}
		
		currentImg=downImg[0];
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
		   if(a==1){a++;currentImg=leftImg[0];}
		   else if(a==2){a--;currentImg=leftImg[2];}
		   x=x-3;
		    repaint();
		   }
	   else if(action==RIGHT)
		    {
		   if(a==1){a++;currentImg=rightImg[0];}
		   else if(a==2){a--;currentImg=rightImg[2];}
		   x=x+3;
		    repaint();
		   }

	   else if(action==UP)
		    {
		   if(a==1){a++;currentImg=upImg[0];}
		   else if(a==2){a--;currentImg=upImg[2];}
		  y=y-3;
		    repaint();
		   }
	   else if(action==DOWN)
		    {
		   if(a==1){a++;currentImg=downImg[0];}
		   else if(a==2){a--;currentImg=downImg[2];}
		   y=y+3;
		    repaint();
		   }
	}
}