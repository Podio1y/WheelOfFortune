/*
Ethan Bitnun
Mr. Rosen
October, 19, 2018
The purpose of this assignment is to animate the Flamingo in MyCreation
*/
import java.awt.*;
import hsa.Console;
import java.lang.*;

public class SplashScreen extends Thread
{
    private Console c;

    //Colour vars
    Color yellow = new Color (255, 255, 0);
    Color yellowGreen = new Color (104, 155, 51);
    Color green = new Color (0, 255, 0);
    Color babyBlue = new Color (0, 153, 255);
    Color blue = new Color (0, 64, 255);
    Color purple = new Color (153, 0, 204);
    Color lightPurple = new Color (255, 51, 255);
    Color beige = new Color (255, 151, 153);
    Color red = new Color (255, 0, 0);
    Color darkRed = new Color (105, 2, 0);
    Color gold = new Color (255, 153, 0);
    Color lightGold = new Color (255, 204, 0);

    public void splashScreen ()
    {
	int x, y, z;

	//Logo animation
	for (x = 0 ; x <= 380 ; x++)
	{
	    //Erase
	    c.setColor (Color.white);
	    c.fillOval (716 - x, 147, 210, 210);

	    //Logo
	    //Black body
	    c.setColor (Color.black);
	    c.fillOval (716 - x, 147, 206, 206);

	    c.setColor (yellow);
	    c.fillArc (719 - x, 150, 200, 200, 330 + x, 30);

	    c.setColor (yellowGreen);
	    c.fillArc (719 - x, 150, 200, 200, x, 30);

	    c.setColor (green);
	    c.fillArc (719 - x, 150, 200, 200, 30 + x, 30);

	    c.setColor (babyBlue);
	    c.fillArc (719 - x, 150, 200, 200, 60 + x, 30);

	    c.setColor (blue);
	    c.fillArc (719 - x, 150, 200, 200, 90 + x, 30);

	    c.setColor (purple);
	    c.fillArc (719 - x, 150, 200, 200, 120 + x, 30);

	    c.setColor (lightPurple);
	    c.fillArc (719 - x, 150, 200, 200, 150 + x, 30);

	    c.setColor (beige);
	    c.fillArc (719 - x, 150, 200, 200, 180 + x, 30);

	    c.setColor (red);
	    c.fillArc (719 - x, 150, 200, 200, 210 + x, 30);

	    c.setColor (darkRed);
	    c.fillArc (719 - x, 150, 200, 200, 240 + x, 30);

	    c.setColor (gold);
	    c.fillArc (719 - x, 150, 200, 200, 270 + x, 30);

	    c.setColor (Color.darkGray);
	    c.fillArc (719 - x, 150, 200, 200, 300 + x, 30);

	    try
	    {
		Thread.sleep (10);
	    }
	    catch (Exception e)
	    {
	    }
	}


	//"Wheel of Fortune" words
	for (x = 0 ; x < 3 ; x++)
	{
	    //Delay in between text appearances
	    try
	    {
		Thread.sleep (1000);
	    }
	    catch (Exception e)
	    {
	    }

	    if (x == 0)
	    {
		for (y = 0 ; y < 60 ; y++)
		{
		    //Erase
		    for (z = 0 ; z < 243 ; z++)
		    {
			c.setColor (Color.white);
			c.drawLine (10 + z, 180, 10 + z, 130);
		    }
		    Font wheel = new Font ("ComicSans", Font.BOLD, y);
		    c.setFont (wheel);
		    c.setColor (lightGold);
		    c.drawString ("Wheel", 10 + y, 180);

		    //Delay
		    try
		    {
			Thread.sleep (5);
		    }
		    catch (Exception e)
		    {
		    }
		}
	    }
	    else if (x == 1)
	    {
		for (y = 0 ; y < 41 ; y++)
		{
		    //Erase
		    for (z = 0 ; z < 243 ; z++)
		    {
			c.setColor (Color.white);
			c.drawLine (10 + z, 220, 10 + z, 180);
		    }

		    Font of = new Font ("ComicSans", Font.BOLD, y);
		    c.setFont (of);
		    c.setColor (lightGold);
		    c.drawString ("of", 150 + y, 220);

		    //Delay
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (Exception e)
		    {
		    }
		}
	    }
	    else if (x == 2)
	    {
		for (y = 0 ; y < 76 ; y++)
		{
		    //Erase
		    for (z = 0 ; z < 300 ; z++)
		    {
			c.setColor (Color.white);
			c.drawLine (0 + z, 280, 0 + z, 220);
		    }

		    Font fortune = new Font ("ComicSans", Font.BOLD, y);
		    c.setFont (fortune);
		    c.setColor (lightGold);
		    c.drawString ("Fortune", -55 + y, 280);

		    //Delay
		    try
		    {
			Thread.sleep (10);
		    }
		    catch (Exception e)
		    {
		    }
		}
	    }
	}
    }


    public SplashScreen (Console con)
    {
	c = con;
    }


    public void run ()
    {
	splashScreen ();
    }
}
