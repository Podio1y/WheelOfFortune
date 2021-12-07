// The "WheelOfFortune" class.
import java.awt.*;
import hsa.Console;
import hsa.Message;
import java.io.*;

public class WheelOfFortune
{
    static Console c;           // The output console

    //Declaration section//////////////////////////////////
    //Non-Colour vars
    char key;
    static boolean done = false;
    static String title1 = "Wheel of Fortune";
    static char choice;
    static int total = 0;
    static int numOfLetters;
    static int letterValue;
    static int totalCorrect = 0;
    String highscoresFile = "Highscores.txt";
    String fullWord;

    static final int arrayNum = 3;
    static String[] wordArray = new String [arrayNum];

    Font otherWords = new Font ("ComicSans", Font.BOLD, 10);

    //For-loop varsr1hvh
    static int x, y, z;

    //Colour vars
    Color boardGreen = new Color (32, 96, 64);
    Color boardLightBlue = new Color (0, 255, 255);
    Color boardDarkBlue = new Color (0, 0, 255);

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
    ////////////////end of declaration section////////////


    public static void title ()
    {
	//Clear screan
	c.clear ();

	//Spacing
	c.print (' ', 40 - title1.length () / 2);

	//Title
	c.println (title1);
    }


    public void splashScreen ()
    {
	//Title and clear screen
	title ();

	//Creates the thread
	SplashScreen v = new SplashScreen (c);
	//Starts the thread
	v.run ();

	//Pause Program
	pauseProgram ();
    }


    public void mainMenu ()
    {
	//Title and clear screen
	title ();

	//Intro
	c.println ("Welcome to the main menu!");

	//Options
	c.print (' ', 3);
	c.println ("Press 'e' to exit...");

	c.print (' ', 3);
	c.println ("Press 'i' for the instructions...");

	c.print (' ', 3);
	c.println ("Press 'p' to play...");

	c.print (' ', 3);
	c.println ("Press 'h' to view the highscores...");

	choice = c.getChar ();
    }


    public void pauseProgram ()
    {
	c.setColor (Color.black);
	c.setFont (otherWords);
	c.drawString ("Press any key to continue...", 460, 490);
	key = c.getChar ();
    }


    public void instructions ()
    {
	//Title and clear screen
	title ();

	//Instructions
	c.println ("Welcome to the instructions page!");

	c.print (' ', 3);
	c.println ("1.  You will have three options, spin the wheel and call a consonant, buy a");
	c.print (' ', 7);
	c.println ("vowel for $250, or solve the puzzle.");

	//Line for spacing
	c.println ("");

	c.print (' ', 3);
	c.println ("2.  Each consonant is worth the cash value of the wedge the wheel lands on.");

	//Line for spacing
	c.println ("");

	c.print (' ', 3);
	c.println ("3.  You can keep spinning the wheel until you run out of lives or spin a");
	c.print (' ', 7);
	c.println ("'Bankrupt' wedge.");

	//Line for spacing
	c.println ("");

	pauseProgram ();
    }


    public void display ()
    {
	//Declaration Section
	String levelFile;
	int extraLives;
	String word = "";
	String firstWord = "";
	String secondWord = "";
	String thirdWord = "";
	int fileLineNum = (int) (Math.random () * ((24 - 1) + 1) + 1);
	int wordNum = 0;
	Font wordsOnBoard = new Font ("ComicSans", Font.BOLD, 45);
	//Font wordsOnBoardWhite = new Font ("ComicSans", Font.BOLD, 45);
	char gameChoice;
	char consonant = '.';
	String consonantStr = "";
	char vowel;
	String vowelStr = "";
	String sentence;
	boolean bankrupt = false;
	String category = "";
	int correct = 0;
	boolean solved = false;
	String letterGuesses = "";
	String name;
	total = 0;

	int arcAngle1 = 0;
	int arcAngle2 = 30;
	int arcAngle3 = 60;
	int arcAngle4 = 90;
	int arcAngle5 = 120;
	int arcAngle6 = 150;
	int arcAngle7 = 180;
	int arcAngle8 = 210;
	int arcAngle9 = 240;
	int arcAngle10 = 270;
	int arcAngle11 = 300;
	int arcAngle12 = 330;

	BufferedReader br;
	PrintWriter pr;

	//Users name
	c.print ("Please enter your name(this will appear on the highscore page): ");
	name = c.readLine ();

	//Title and clear screen
	title ();
	c.println ("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

	//Game board/////////////////////////////
	//Border
	for (x = 0 ; x < 6 ; x++)
	{
	    //Dark blue boarder///////////////////
	    c.setColor (boardDarkBlue);
	    //Left
	    c.drawLine (15 + x, 35, 15 + x, 245);
	    //Top
	    c.drawLine (15, 35 + x, 630, 35 + x);
	    //Right
	    c.drawLine (630 - x, 35, 630 - x, 245);
	    //Bottom
	    c.drawLine (15, 245 - x, 630, 245 - x);
	    //////////////////////////////////////

	    //Light blue boarder//////////////////
	    c.setColor (boardLightBlue);
	    //Left
	    c.drawLine (5 + x, 25, 5 + x, 255);
	    //Top
	    c.drawLine (5, 25 + x, 640, 25 + x);
	    //Right
	    c.drawLine (640 - x, 25, 640 - x, 255);
	    //Bottom
	    c.drawLine (5, 255 - x, 640, 255 - x);
	    //////////////////////////////////////
	}

	//Squares
	for (z = 0 ; z <= 130 ; z = z + 65)
	{
	    for (y = 0 ; y < 600 ; y = y + 60)
	    {
		for (x = 0 ; x < 46 ; x++)
		{
		    c.setColor (Color.black);
		    c.drawLine (25 + x + y, 45 + z, 25 + x + y, 105 + z);
		    c.drawLine (35 + x + y, 45 + z, 35 + x + y, 105 + z);
		}
		for (x = 0 ; x < 46 ; x++)
		{
		    c.setColor (boardGreen);
		    c.drawLine (30 + x + y, 50 + z, 30 + x + y, 100 + z);
		}
	    }
	}
	/////////////////////////////////////////

	//Game Board Entry////////////////////////
	for (x = 0 ; x <= 700 ; x++)
	{
	    //Erase
	    c.setColor (Color.white);
	    c.fillOval (715 - x, 256, 209, 209);

	    //Logo
	    c.setColor (Color.black);
	    c.fillOval (716 - x, 257, 206, 206);

	    c.setColor (yellow);
	    c.fillArc (719 - x, 260, 200, 200, 330 + x, 30);

	    c.setColor (yellowGreen);
	    c.fillArc (719 - x, 260, 200, 200, 0 + x, 30);

	    c.setColor (green);
	    c.fillArc (719 - x, 260, 200, 200, 30 + x, 30);

	    c.setColor (babyBlue);
	    c.fillArc (719 - x, 260, 200, 200, 60 + x, 30);

	    c.setColor (blue);
	    c.fillArc (719 - x, 260, 200, 200, 90 + x, 30);

	    c.setColor (purple);
	    c.fillArc (719 - x, 260, 200, 200, 120 + x, 30);

	    c.setColor (lightPurple);
	    c.fillArc (719 - x, 260, 200, 200, 150 + x, 30);

	    c.setColor (beige);
	    c.fillArc (719 - x, 260, 200, 200, 180 + x, 30);

	    c.setColor (red);
	    c.fillArc (719 - x, 260, 200, 200, 210 + x, 30);

	    c.setColor (darkRed);
	    c.fillArc (719 - x, 260, 200, 200, 240 + x, 30);

	    c.setColor (gold);
	    c.fillArc (719 - x, 260, 200, 200, 270 + x, 30);

	    c.setColor (Color.darkGray);
	    c.fillArc (719 - x, 260, 200, 200, 300 + x, 30);

	    try
	    {
		Thread.sleep (1);
	    }
	    catch (Exception e)
	    {
	    }
	}

	//Black outlines for colour boxes
	for (x = 0 ; x < 101 ; x = x + 100)
	{
	    for (y = 0 ; y < 120 ; y = y + 20)
	    {
		for (z = 0 ; z < 12 ; z++)
		{
		    c.setColor (Color.black);
		    c.drawLine (259 + z + x, 269 + y, 259 + z + x, 281 + y);
		}
	    }
	}
	//Colour filling for colour boxes
	for (x = 0 ; x < 10 ; x++)
	{
	    c.setColor (yellow);
	    c.drawLine (260 + x, 270, 260 + x, 280);

	    c.setColor (yellowGreen);
	    c.drawLine (260 + x, 290, 260 + x, 300);

	    c.setColor (green);
	    c.drawLine (260 + x, 310, 260 + x, 320);

	    c.setColor (babyBlue);
	    c.drawLine (260 + x, 330, 260 + x, 340);

	    c.setColor (blue);
	    c.drawLine (260 + x, 350, 260 + x, 360);

	    c.setColor (purple);
	    c.drawLine (260 + x, 370, 260 + x, 380);

	    c.setColor (lightPurple);
	    c.drawLine (360 + x, 270, 360 + x, 280);

	    c.setColor (beige);
	    c.drawLine (360 + x, 290, 360 + x, 300);

	    c.setColor (red);
	    c.drawLine (360 + x, 310, 360 + x, 320);

	    c.setColor (darkRed);
	    c.drawLine (360 + x, 330, 360 + x, 340);

	    c.setColor (gold);
	    c.drawLine (360 + x, 350, 360 + x, 360);

	    c.setColor (Color.darkGray);
	    c.drawLine (360 + x, 370, 360 + x, 380);
	}

	//All values for colour boxes
	c.drawString ("$100", 280, 280);
	c.drawString ("$300", 280, 300);
	c.drawString ("$500", 280, 320);
	c.drawString ("$450", 280, 340);
	c.drawString ("$700", 280, 360);
	c.drawString ("$350", 280, 380);
	c.drawString ("$400", 380, 280);
	c.drawString ("$550", 380, 300);
	c.drawString ("$1000", 380, 320);
	c.drawString ("$600", 380, 340);
	c.drawString ("$650", 380, 360);
	c.drawString ("BANKRUPT", 380, 380);

	/////////////////////////////////////////
	while (true)
	{
	    if (choice == 'a')
	    {
		levelFile = "EasyLevels.txt";
		extraLives = 7;
		break;
	    }
	    else if (choice == 'm')
	    {
		levelFile = "MediumLevels.txt";
		extraLives = 5;
		break;
	    }
	    else if (choice == 'x')
	    {
		levelFile = "ExpertLevels.txt";
		extraLives = 3;
		break;
	    }
	}

	//Random selection of word in selected file
	try
	{
	    br = new BufferedReader (new FileReader (levelFile));
	    while (wordNum < fileLineNum)
	    {
		word = br.readLine ();
		wordNum++;
	    }

	}
	catch (IOException e)
	{
	}

	for (x = 0 ; x < word.length () ; x++)
	{
	    if (word.charAt (x) != ' ')
	    {
		firstWord = firstWord + word.charAt (x);
	    }
	    else
		break;
	}
	for (x = firstWord.length () + 1 ; x < word.length () ; x++)
	{
	    if (word.charAt (x) != ' ')
	    {
		secondWord = secondWord + word.charAt (x);
	    }
	    else
		break;
	}
	for (x = firstWord.length () + secondWord.length () + 2 ; x < word.length () ; x++)
	{
	    if (word.charAt (x) != ' ')
	    {
		thirdWord = thirdWord + word.charAt (x);
	    }
	    else
		break;
	}
	for (x = firstWord.length () + secondWord.length () + thirdWord.length () + 3 ; x < word.length () ; x++)
	{
	    category = category + word.charAt (x);
	}

	wordArray [0] = firstWord.toUpperCase ();
	wordArray [1] = secondWord.toUpperCase ();
	wordArray [2] = thirdWord.toUpperCase ();

	int[] xcoordArray1 = new int [wordArray [0].length ()];
	int[] xcoordArray2 = new int [wordArray [1].length ()];
	int[] xcoordArray3 = new int [wordArray [2].length ()];

	int coordNum = 0;
	for (x = 150 ; x < 150 + 60 * wordArray [0].length () ; x = x + 60)
	{
	    xcoordArray1 [coordNum] = x;
	    coordNum++;
	}

	coordNum = 0;
	for (x = 90 ; x < 90 + 60 * wordArray [1].length () ; x = x + 60)
	{
	    xcoordArray2 [coordNum] = x;
	    coordNum++;
	}

	coordNum = 0;
	for (x = 150 ; x < 150 + 60 * wordArray [2].length () ; x = x + 60)
	{
	    xcoordArray3 [coordNum] = x;
	    coordNum++;
	}

	for (x = 0 ; x < wordArray [0].length () ; x++)
	{
	    for (y = 0 ; y < 46 ; y++)
	    {
		c.setColor (yellow);
		c.drawLine (xcoordArray1 [x] + y, 50, xcoordArray1 [x] + y, 100);
	    }
	    c.setColor (Color.black);
	}

	for (x = 0 ; x < wordArray [1].length () ; x++)
	{
	    for (y = 0 ; y < 46 ; y++)
	    {
		c.setColor (yellow);
		c.drawLine (xcoordArray2 [x] + y, 115, xcoordArray2 [x] + y, 165);
	    }
	}

	for (x = 0 ; x < wordArray [2].length () ; x++)
	{
	    for (y = 0 ; y < 46 ; y++)
	    {
		c.setColor (yellow);
		c.drawLine (xcoordArray3 [x] + y, 180, xcoordArray3 [x] + y, 230);
	    }
	}

	do
	{

	    c.setColor (Color.black);
	    c.setFont (otherWords);
	    c.drawString ("Press 's' to spin the wheel...", 450, 320);
	    c.drawString ("Press 'b' to buy a vowel for $250", 450, 340);
	    c.drawString ("Press 'v' to solve the puzzle...", 450, 360);

	    c.drawString ("Category: " + category, 450, 270);

	    gameChoice = c.getChar ();

	    c.setColor (Color.white);
	    c.drawString ("Press 's' to spin the wheel...", 450, 320);
	    c.drawString ("Press 'b' to buy a vowel for $250", 450, 340);
	    c.drawString ("Press 'v' to solve the puzzle...", 450, 360);

	    c.setFont (wordsOnBoard);
	    c.drawString ("CORRECT!", 200, 500);
	    c.drawString ("WRONG!", 200, 500);
	    if (gameChoice == 's')
	    {

		for (x = 0 ; x < (int) (Math.random () * ((400 - 1) + 1) + 1) * 100 ; x++)
		{
		    //Logo
		    c.setColor (Color.black);
		    c.fillOval (16, 257, 206, 205);

		    c.setColor (yellow);
		    c.fillArc (19, 260, 200, 200, arcAngle12, 30);

		    c.setColor (yellowGreen);
		    c.fillArc (19, 260, 200, 200, arcAngle1, 30);

		    c.setColor (green);
		    c.fillArc (19, 260, 200, 200, arcAngle2, 30);

		    c.setColor (babyBlue);
		    c.fillArc (19, 260, 200, 200, arcAngle3, 30);

		    c.setColor (blue);
		    c.fillArc (19, 260, 200, 200, arcAngle4, 30);

		    c.setColor (purple);
		    c.fillArc (19, 260, 200, 200, arcAngle5, 30);

		    c.setColor (lightPurple);
		    c.fillArc (19, 260, 200, 200, arcAngle6, 30);

		    c.setColor (beige);
		    c.fillArc (19, 260, 200, 200, arcAngle7, 30);

		    c.setColor (red);
		    c.fillArc (19, 260, 200, 200, arcAngle8, 30);

		    c.setColor (darkRed);
		    c.fillArc (19, 260, 200, 200, arcAngle9, 30);

		    c.setColor (gold);
		    c.fillArc (19, 260, 200, 200, arcAngle10, 30);

		    c.setColor (Color.darkGray);
		    c.fillArc (19, 260, 200, 200, arcAngle11, 30);

		    c.setColor (Color.black);
		    for (y = 0 ; y < 11 ; y++)
		    {
			c.drawLine (205, 360, 240, 355 + y);
		    }

		    try
		    {
			Thread.sleep (7);
		    }
		    catch (Exception e)
		    {
		    }

		    //Making sure arcAngle never passes 360 to help know how much the slice which the wheel lands on is worth
		    if (x >= 360)
		    {
			arcAngle1 = x - 360;
		    }
		    else
		    {
			arcAngle1 = x;
		    }

		    if (x >= 330)
		    {
			arcAngle2 = 30 + x - 360;
		    }
		    else
		    {
			arcAngle2 = x + 30;
		    }


		    if (x >= 300)
		    {
			arcAngle3 = 60 + x - 360;
		    }
		    else
		    {
			arcAngle3 = x + 60;
		    }

		    if (x >= 270)
		    {
			arcAngle4 = 90 + x - 360;
		    }
		    else
		    {
			arcAngle4 = x + 90;
		    }

		    if (x >= 240)
		    {
			arcAngle5 = 120 + x - 360;
		    }
		    else
		    {
			arcAngle5 = x + 120;
		    }


		    if (x >= 210)
		    {
			arcAngle6 = 150 + x - 360;
		    }
		    else
		    {
			arcAngle6 = x + 150;
		    }

		    if (x >= 180)
		    {
			arcAngle7 = 180 + x - 360;
		    }
		    else
		    {
			arcAngle7 = x + 180;
		    }

		    if (x >= 150)
		    {
			arcAngle8 = 210 + x - 360;
		    }
		    else
		    {
			arcAngle8 = x + 210;
		    }

		    if (x >= 120)
		    {
			arcAngle9 = 240 + x - 360;
		    }
		    else
		    {
			arcAngle9 = x + 240;
		    }

		    if (x >= 90)
		    {
			arcAngle10 = 270 + x - 360;
		    }
		    else
		    {
			arcAngle10 = x + 270;
		    }

		    if (x >= 60)
		    {
			arcAngle11 = 300 + x - 360;
		    }
		    else
		    {
			arcAngle11 = x + 300;
		    }

		    if (x >= 30)
		    {
			arcAngle12 = 330 + x - 360;
		    }
		    else
		    {
			arcAngle12 = x + 330;
		    }
		}

		if (arcAngle1 >= 330 && arcAngle1 < 360 || arcAngle1 == 0)
		{
		    letterValue = 300;
		    bankrupt = false;
		}
		else if (arcAngle2 >= 330 && arcAngle2 < 360 || arcAngle2 == 0)
		{
		    letterValue = 500;
		    bankrupt = false;
		}
		else if (arcAngle3 >= 330 && arcAngle3 < 360 || arcAngle3 == 0)
		{
		    letterValue = 450;
		    bankrupt = false;
		}
		else if (arcAngle4 >= 330 && arcAngle4 < 360 || arcAngle4 == 0)
		{
		    letterValue = 700;
		    bankrupt = false;
		}
		else if (arcAngle5 >= 330 && arcAngle5 < 360 || arcAngle5 == 0)
		{
		    letterValue = 350;
		    bankrupt = false;
		}
		else if (arcAngle6 >= 330 && arcAngle6 < 360 || arcAngle6 == 0)
		{
		    letterValue = 400;
		    bankrupt = false;
		}
		else if (arcAngle7 >= 330 && arcAngle7 < 360 || arcAngle7 == 0)
		{
		    letterValue = 550;
		    bankrupt = false;
		}
		else if (arcAngle8 >= 330 && arcAngle8 < 360 || arcAngle8 == 0)
		{
		    letterValue = 1000;
		    bankrupt = false;
		}
		else if (arcAngle9 >= 330 && arcAngle9 < 360 || arcAngle9 == 0)
		{
		    letterValue = 600;
		    bankrupt = false;
		}
		else if (arcAngle10 >= 330 && arcAngle10 < 360 || arcAngle10 == 0)
		{
		    letterValue = 650;
		    bankrupt = false;
		}
		else if (arcAngle11 >= 330 && arcAngle11 < 360 || arcAngle11 == 0)
		{
		    letterValue = 0;
		    bankrupt = true;
		}
		else if (arcAngle12 >= 330 && arcAngle12 < 360 || arcAngle12 == 0)
		{
		    letterValue = 100;
		    bankrupt = false;
		}

		if (bankrupt == true)
		{
		    c.drawString ("BANKRUPT!", 200, 500);
		    break;
		}

		c.setColor (Color.black);
		c.setFont (otherWords);
		c.drawString ("Enter any consonant!", 450, 370);

		while (true)
		{
		    c.setCursor (24, 3);
		    consonantStr = c.readLine ();
		    consonantStr = consonantStr.toUpperCase ();
		    consonant = consonantStr.charAt (0);
		    if (letterGuesses.length () > 0)
		    {
			for (x = 0 ; x < letterGuesses.length () ; x++)
			{
			    if (letterGuesses.charAt (x) == consonant)
			    {
				new Message ("Sorry! You already guessed that letter!");
			    }
			}
		    }
		    letterGuesses = letterGuesses + consonant;
		    if (consonant == 'a' || consonant == 'e' || consonant == 'i' || consonant == 'o' || consonant == 'u' || consonant == 'A' || consonant == 'E' || consonant == 'I' || consonant == 'O' || consonant == 'U')
		    {
			extraLives--;
			new Message ("Sorry! That was not a consonant! Please enter a consonant!");
		    }
		    else
			break;
		}

		//Erase
		c.setColor (Color.white);
		c.drawString ("Enter any consonant!", 450, 370);

		c.setFont (wordsOnBoard);

		correct = 0;

		for (x = 0 ; x < 3 ; x++)
		{
		    for (y = 0 ; y < wordArray [x].length () ; y++)
		    {
			if (consonant == wordArray [x].charAt (y))
			{
			    correct++;
			    totalCorrect++;
			    if (x == 0)
			    {
				for (z = 0 ; z < 46 ; z++)
				{
				    c.setColor (Color.white);
				    c.drawLine (xcoordArray1 [y] + z, 50, xcoordArray1 [y] + z, 100);
				}
				c.setColor (Color.black);
				String letter = "";
				letter = letter + wordArray [x].charAt (y);
				c.drawString (letter, xcoordArray1 [y], 100);
			    }
			    else if (x == 1)
			    {
				for (z = 0 ; z < 46 ; z++)
				{
				    c.setColor (Color.white);
				    c.drawLine (xcoordArray2 [y] + z, 115, xcoordArray2 [y] + z, 165);
				}
				c.setColor (Color.black);
				String letter = "";
				letter = letter + wordArray [x].charAt (y);
				c.drawString (letter, xcoordArray2 [y], 165);

			    }
			    else if (x == 2)
			    {
				for (z = 0 ; z < 46 ; z++)
				{
				    c.setColor (Color.white);
				    c.drawLine (xcoordArray3 [y] + z, 180, xcoordArray3 [y] + z, 230);
				}
				c.setColor (Color.black);
				String letter = "";
				letter = letter + wordArray [x].charAt (y);
				c.drawString (letter, xcoordArray3 [y], 230);
			    }
			}
		    }
		}

		numOfLetters = correct;

		//Extra lives erase
		c.setColor (Color.white);
		c.setFont (otherWords);
		c.drawString ("Lives: " + extraLives, 550, 290);
		extraLives--;
		c.drawString ("Lives: " + extraLives, 550, 290);
		extraLives++;

		if (correct > 0)
		{
		    //Total score erase
		    c.drawString ("Money: $" + total, 550, 300);
		}

		if (correct == 0)
		{
		    extraLives--;
		}

		//Extra lives
		c.setColor (Color.black);
		c.drawString ("Lives: " + extraLives, 550, 290);

		if (correct > 0)
		{
		    //Total score output
		    c.drawString ("Money: $" + spin (total), 550, 300);
		}

		if (extraLives <= 0)
		{
		    break;
		}

	    }


	    /////////////////////////////////////////////////////////////////////////
	    /////////////////////////////////////////////////////////////////////////
	    else if (gameChoice == 'b')
	    {
		c.setColor (Color.black);
		c.setFont (otherWords);
		c.drawString ("Enter any vowel!", 450, 370);
		while (true)
		{
		    c.setCursor (24, 3);
		    vowelStr = c.readLine ();
		    vowelStr = vowelStr.toUpperCase ();
		    vowel = vowelStr.charAt (0);
		    if (vowel != 'a' && vowel != 'e' && vowel != 'i' && vowel != 'o' && vowel != 'u' && vowel != 'A' && vowel != 'E' && vowel != 'I' && vowel != 'O' && vowel != 'U')
		    {
			new Message ("Sorry! That was not a vowel! Please enter a vowel!");
		    }
		    else
			break;
		}

		//Erase
		c.setColor (Color.white);
		c.drawString ("Enter any vowel!", 450, 370);

		//Total money erase
		c.drawString ("Money: $" + total, 550, 300);

		c.setFont (wordsOnBoard);

		correct = 0;

		for (x = 0 ; x < 3 ; x++)
		{
		    for (y = 0 ; y < wordArray [x].length () ; y++)
		    {
			if (vowel == wordArray [x].charAt (y))
			{
			    correct++;
			    totalCorrect++;
			    if (x == 0)
			    {
				for (z = 0 ; z < 46 ; z++)
				{
				    c.setColor (Color.white);
				    c.drawLine (xcoordArray1 [y] + z, 50, xcoordArray1 [y] + z, 100);
				}
				c.setColor (Color.black);
				String letter = "";
				letter = letter + wordArray [x].charAt (y);
				c.drawString (letter, xcoordArray1 [y], 100);
			    }
			    else if (x == 1)
			    {
				for (z = 0 ; z < 46 ; z++)
				{
				    c.setColor (Color.white);
				    c.drawLine (xcoordArray2 [y] + z, 115, xcoordArray2 [y] + z, 165);
				}
				c.setColor (Color.black);
				String letter = "";
				letter = letter + wordArray [x].charAt (y);
				c.drawString (letter, xcoordArray2 [y], 165);

			    }
			    else if (x == 2)
			    {
				for (z = 0 ; z < 46 ; z++)
				{
				    c.setColor (Color.white);
				    c.drawLine (xcoordArray3 [y] + z, 180, xcoordArray3 [y] + z, 230);
				}
				c.setColor (Color.black);
				String letter = "";
				letter = letter + wordArray [x].charAt (y);
				c.drawString (letter, xcoordArray3 [y], 230);
			    }
			}
		    }
		}

		//Extra lives erase
		c.setColor (Color.white);
		c.setFont (otherWords);
		c.drawString ("Lives: " + extraLives, 550, 290);

		if (correct > 0)
		{
		    //Total score erase
		    c.drawString ("Money: $" + total, 550, 300);
		}

		if (correct == 0)
		{
		    extraLives--;
		}

		//Extra lives
		c.setColor (Color.black);
		c.drawString ("Lives: " + extraLives, 550, 290);

		if (correct > 0)
		{
		    //Total score output
		    c.drawString ("Money: $" + vowel (total), 550, 300);
		}

		if (extraLives <= 0)
		{
		    solved = false;
		    break;
		}
	    }

	    //////////////////////////////////////////////////////////////
	    //////////////////////////////////////////////////////////////
	    else if (gameChoice == 'v')
	    {
		String editedSentence = "";
		correct = 0;


		c.setColor (Color.black);
		c.setFont (otherWords);
		c.drawString ("Enter your guess.", 550, 460);

		c.drawString ("Lives: " + extraLives, 550, 290);
		c.drawString ("Money: $" + total, 550, 300);

		c.setCursor (24, 3);
		sentence = c.readLine ();

		sentence = sentence.toUpperCase ();

		if (wordArray [0] == "" || wordArray [0] == null)
		{
		    if (wordArray [1] == "")
		    {
			fullWord = wordArray [2];
			editedSentence = "  " + sentence;
		    }
		    else if (wordArray [2] == "" || wordArray [2] == null)
		    {
			fullWord = wordArray [1];
			editedSentence = sentence;
		    }
		    else
		    {
			fullWord = wordArray [1] + " " + wordArray [2];
			editedSentence = sentence;
		    }
		}
		else
		{
		    if (wordArray [2] == null || wordArray [2] == "" && wordArray [1] == "")
		    {
			fullWord = wordArray [0];
			editedSentence = sentence + " ";
		    }
		    else if (wordArray [2] == null || wordArray [2] == "")
		    {
			fullWord = wordArray [0] + " " + wordArray [1];
			editedSentence = sentence;
		    }
		    else
		    {
			fullWord = wordArray [0] + " " + wordArray [1] + " " + wordArray [2];
			editedSentence = sentence;
		    }

		}

		if (editedSentence.length () == fullWord.length ())
		{
		    for (x = 0 ; x < fullWord.length () ; x++)
		    {
			if (editedSentence.charAt (x) == fullWord.charAt (x))
			{
			    correct++;
			}
		    }
		}
		else
		{
		    c.setFont (wordsOnBoard);
		    c.drawString ("WRONG!", 200, 500);
		    extraLives--;
		}
		if (correct == fullWord.length ())
		{
		    c.setColor (Color.white);
		    c.drawString ("Money: $" + total, 550, 300);

		    c.setColor (Color.black);
		    c.drawString ("Money: $" + solve (total), 550, 300);

		    c.setFont (wordsOnBoard);
		    c.drawString ("CORRECT!", 200, 500);
		    solved = true;

		    //Drawing the full word after soving
		    for (x = 0 ; x < 3 ; x++)
		    {
			for (y = 0 ; y < wordArray [x].length () ; y++)
			{
			    if (x == 0)
			    {
				if (wordArray [0] != "")
				{
				    for (z = 0 ; z < 46 ; z++)
				    {
					c.setColor (Color.white);
					c.drawLine (xcoordArray1 [y] + z, 50, xcoordArray1 [y] + z, 100);
				    }
				    c.setColor (Color.black);
				    String letter = "";
				    letter = letter + wordArray [0].charAt (y);
				    c.drawString (letter, xcoordArray1 [y], 100);
				}
			    }
			    else if (x == 1)
			    {
				if (wordArray [1] != "")
				{
				    for (z = 0 ; z < 46 ; z++)
				    {
					c.setColor (Color.white);
					c.drawLine (xcoordArray2 [y] + z, 115, xcoordArray2 [y] + z, 165);
				    }
				    c.setColor (Color.black);
				    String letter = "";
				    letter = letter + wordArray [1].charAt (y);
				    c.drawString (letter, xcoordArray2 [y], 165);

				}
			    }
			    else if (x == 2)
			    {
				if (wordArray [2] != "")
				{
				    for (z = 0 ; z < 46 ; z++)
				    {
					c.setColor (Color.white);
					c.drawLine (xcoordArray3 [y] + z, 180, xcoordArray3 [y] + z, 230);
				    }
				    c.setColor (Color.black);
				    String letter = "";
				    letter = letter + wordArray [2].charAt (y);
				    c.drawString (letter, xcoordArray3 [y], 230);
				}
			    }
			}
		    }
		    break;
		}
	    }
	    c.setFont (otherWords);
	    c.setColor (Color.black);
	    c.drawString ("Lives: " + extraLives, 550, 290);
	    c.drawString ("Money: $" + total, 550, 300);
	}
	while (1 == 1);

	c.setFont (otherWords);

	c.drawString ("Would you like to save your highscore under the name " + name + "?", 285, 400);
	c.drawString ("Press 'c' to change your name and save your highscore...", 290, 415);
	c.drawString ("Press 's' to save without changing your name...", 290, 430);
	c.drawString ("Press any other key to return to the main menu without saving...", 290, 445);

	gameChoice = c.getChar ();

	final int scoreArrayNum = 11;
	String[] highscoresArray = new String [scoreArrayNum];
	final int scoreCoordArrayNum = 11;
	int[] highscoreTotalArray = new int [scoreCoordArrayNum];

	String highscoreNum1Str = "";
	String highscoreNum2Str = "";
	int highscoreNum1 = 0;
	int highscoreNum2 = 0;
	boolean intChecker = false;
	int arrayStopper = 0;

	if (gameChoice == 'c' || gameChoice == 's')
	{
	    if (gameChoice == 'c')
	    {
		c.drawString ("Please enter your new name: ", 430, 470);
		name = c.readLine ();
	    }

	    try
	    {
		br = new BufferedReader (new FileReader (highscoresFile));
		for (x = 0 ; x < 10 ; x++)
		{
		    highscoresArray [x] = br.readLine ();
		    highscoreNum1Str = "";
		    highscoreNum1 = 0;
		    if (highscoresArray [x] != null)
		    {
			for (y = 0 ; y > -10 ; y--)
			{
			    if (highscoresArray [x].charAt (y + highscoresArray [x].length () - 1) != '$')
			    {
				highscoreNum1Str = highscoresArray [x].charAt (y + highscoresArray [x].length () - 1) + highscoreNum1Str;
			    }
			    else
			    {
				break;
			    }
			}
			try
			{
			    Integer.parseInt (highscoreNum1Str);
			    intChecker = true;
			}
			catch (NumberFormatException e)
			{
			    intChecker = false;
			}

			if (intChecker == true)
			{
			    highscoreNum1 = Integer.parseInt (highscoreNum1Str);
			}
			highscoreTotalArray [x] = highscoreNum1;
		    }
		    else
		    {
			highscoresArray [x] = "No Current Score";
		    }
		}

		for (x = 0 ; x < 10 ; x++)
		{
		    if (total <= highscoreTotalArray [x] && total >= highscoreTotalArray [x + 1])
		    {
			arrayStopper = x + 1;
			break;
		    }

		}

		for (x = 9 ; x > arrayStopper ; x--)
		{
		    highscoreTotalArray [x] = highscoreTotalArray [x - 1];
		    highscoresArray [x] = highscoresArray [x - 1];
		}
		highscoresArray [arrayStopper] = name + " made $" + total;
		highscoreTotalArray [arrayStopper] = total;

		try
		{
		    pr = new PrintWriter (new FileWriter (highscoresFile));
		    for (x = 0 ; x < 10 ; x++)
		    {
			pr.println (highscoresArray [x]);
		    }
		    pr.close ();
		}
		catch (IOException e)
		{
		}
	    }
	    catch (IOException e)
	    {
	    }
	}

	pauseProgram ();
    }


    private static int spin (int total1)
    {
	total1 = total + numOfLetters * letterValue;
	total = total1;
	return total1;
    }


    private static int vowel (int total1)
    {
	total1 = total - 250;
	total = total1;
	return total1;
    }


    private int solve (int total1)
    {
	int lengthOfFullWord = (wordArray [0] + wordArray [1] + wordArray [2]).length ();

	total1 = total + ((lengthOfFullWord - totalCorrect) * 1000);
	total = total1;
	return total1;
    }


    public void highscores ()
    {
	//Declaration section
	String nameScore;

	BufferedReader br;
	PrintWriter pr;

	//Title and clear screen
	title ();

	c.println ("Welcome to the highscore page!");

	try
	{
	    br = new BufferedReader (new FileReader (highscoresFile));
	    for (x = 0 ; x < 10 ; x++)
	    {
		nameScore = br.readLine ();
		c.println ((x + 1) + "." + " " + nameScore);
	    }
	}


	catch (IOException e)
	{
	}


	//Line for spacing
	c.println ("");

	c.println ("Would you like to clear the highscores?");

	//Line for spacing
	c.println ("");

	c.println ("Press 'c' to clear the highscores...");
	c.println ("Press any other key to return the main menu...");

	choice = c.getChar ();

	if (choice == 'c')
	{
	    try
	    {
		pr = new PrintWriter (new FileWriter (highscoresFile));
		for (x = 0 ; x < 10 ; x++)
		{
		    pr.println ("No Current Score");
		}
		pr.close ();
	    }
	    catch (IOException e)
	    {
	    }

	    //Line for spacing
	    c.println ("");

	    c.println ("Highscores cleared!");

	    pauseProgram ();
	}
    }


    public void goodbye ()
    {
	//Title and clear screen
	title ();

	c.println ("\n\n\n\n\n\n\n\n\n");

	c.print (' ', 36);
	c.println ("Goodbye!");

	//Line for spacing
	c.println ("");

	c.print (' ', 28);
	c.println ("Created by: Ethan Bitnun");
    }


    public static void main (String[] args)
    {
	c = new Console ();
	WheelOfFortune w = new WheelOfFortune ();
	w.splashScreen ();
	while (done != true)
	{
	    w.mainMenu ();
	    if (choice == 'e')
		done = true;
	    else if (choice == 'i')
		w.instructions ();
	    else if (choice == 'p')
	    {
		c.println ("Press 'a' for an easy level...");
		c.println ("Press 'm' for a medium level...");
		c.println ("Press 'x' for an expert level...");

		while (true)
		{
		    choice = c.getChar ();

		    if (choice == 'a' || choice == 'm' || choice == 'x')
		    {
			break;
		    }
		    else
			new Message ("Sorry! That was an invalid input! Try pressing 'a', 'm', or 'x'.");
		}
		w.display ();
	    }
	    else if (choice == 'h')
		w.highscores ();
	    else
		new Message ("Sorry! That was an invalid input! Try pressing 'e', 'i', 'p', or 'h'.");
	}
	w.goodbye ();


	// Place your program here.  'c' is the output console
    } // main method
} // WheelOfFortune class


