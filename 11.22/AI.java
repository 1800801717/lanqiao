import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public void ChangePicAndMove(int diction)
{
	if(flag==1)
	{
		currentImg=heroImg[diction][0];
		flag++;
	}
		else if(flag==2)
	{
        currentImg=heroImg[diction][2];
		flag--
	}

}

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
	Image heroImg[][]=new Image[4][3];//left0[] right1[]  up2[]  down3[]
	int a=1,x=100,y=120;
	Image currentImg;
	public MainCanvas(){
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
		   ChangePicAndMove(0);
		   x=x-3;
		    repaint();
		   }
	   else if(action==RIGHT)
		    {
		   ChangePicAndMove(1);
		   x=x+3;
		    repaint();
		   }

	   else if(action==UP)
		    {
		   ChangePicAndMove(2);
		  y=y-3;
		    repaint();
		   }
	   else if(action==DOWN)
		    {
		   ChangePicAndMove(3);
		   y=y+3;
		    repaint();
		   }
	}
}