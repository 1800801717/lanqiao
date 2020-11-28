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
	Image heroImg[][]=new Image[4][3];
	Image currentImg;
	int flag=0,x=100,y=120;
	public MainCanvas()
		{
		try
		{
			for(int i=0;i<heroImg.length;i++)
			{
				for(int j=0;j<heroImg[i].length;j++)
				{
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}
			currentImg=heroImg[3][1];


			
		}
		catch(IOException e)
			{
			   e.printStackTrace();
		    }
	}
	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void PicChangeAndMove(int diction)
	{
		if(flag==0)
		{
		    currentImg=heroImg[diction][0];
		    flag++;
	    }
		else if(flag==1)
	    {
			currentImg=heroImg[diction][2];
			flag--;
		}
		repaint();
    }
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT)
		{
			PicChangeAndMove(0);
			x=x-3;
		}
		else if (action==RIGHT)
		{
			PicChangeAndMove(1);
			x=x+3;
		}
		else if (action==UP)
		{
			PicChangeAndMove(2);
			y=y-3;
		}
		else if (action==DOWN)
		{
			PicChangeAndMove(3);
			y=y+3;
		}
	}
}