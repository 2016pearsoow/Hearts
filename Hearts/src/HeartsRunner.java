import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

public class HeartsRunner 
{

	static String twoOfClubs;
	static int nextUp;
	static String suitPlayed;
	static int cardNumber = 1;
	static int positionTwoOfClubs;
	static boolean heartsBroken = false;
	static int firstPlayed;
	static int addTo;
	static int wonTrick;
	
	static ArrayList<Card> playerHand1 = new ArrayList<Card>();
	static ArrayList<Card> playerHand2 = new ArrayList<Card>();
	static ArrayList<Card> playerHand3 = new ArrayList<Card>();
	static ArrayList<Card> playerHand4 = new ArrayList<Card>();
	
	static ArrayList<Card> onTheTable = new ArrayList<Card>();
	
	static ArrayList<Card> player1Collection = new ArrayList<Card>();
	static ArrayList<Card> player2Collection = new ArrayList<Card>();
	static ArrayList<Card> player3Collection = new ArrayList<Card>();
	static ArrayList<Card> player4Collection = new ArrayList<Card>();
	
	static ArrayList<Card> playable1 = new ArrayList<Card>();
	static ArrayList<Card> playable2 = new ArrayList<Card>();
	static ArrayList<Card> playable3 = new ArrayList<Card>();
	static ArrayList<Card> playable4 = new ArrayList<Card>();
	
	public static void main(String[] args) 
	{
	Deck.fillDeck();
	Deck.shuffle();
	deal();
	start();
	gameplay();
	}
	
	public static void deal()
	{
	
	while(Deck.deck.size()>0)	
		{
		playerHand1.add(Deck.deck.get(0));
		Deck.deck.remove(0);
		playerHand2.add(Deck.deck.get(0));
		Deck.deck.remove(0);
		playerHand3.add(Deck.deck.get(0));
		Deck.deck.remove(0);
		playerHand4.add(Deck.deck.get(0));
		Deck.deck.remove(0);
		}
		
	}
	
	public static void start()
	{
	System.out.println("Welcome to Hearts! Press ENTER to begin.");	
	
	Scanner userInput1 = new Scanner(System.in);
	String wait = userInput1.nextLine();
	
	userHand();	
	System.out.println();
	System.out.println("The player who posesses the two of clubs goes first.");	
	twoOfClubs();
	try 
		{
		Thread.sleep(1000);
		} 
	catch (InterruptedException e) 
		{
		e.printStackTrace();
		}
	System.out.println();
	System.out.println(twoOfClubs + " played the two of clubs.");
	suitPlayed = "clubs";
	}
	
	public static void gameplay()
	{
	System.out.println();	
	System.out.println("The suit played is " + suitPlayed + ".");	
	nextUp();
	}
	
	public static void twoOfClubs()
	{
	for(int i=0; i<13; i++)
		{
		if((playerHand1.get(i).getRank().equals("two")) && (playerHand1.get(i).getSuit().equals("clubs")))
			{
			positionTwoOfClubs = i;
			twoOfClubs = "You have";
			nextUp = 2;
			onTheTable.add(playerHand1.get(positionTwoOfClubs));
			playerHand1.remove(positionTwoOfClubs);
			firstPlayed = 1;
			break;
			}
		}
	
	for(int i=0; i<13; i++)
		{
		if((playerHand2.get(i).getRank().equals("two")) && (playerHand2.get(i).getSuit().equals("clubs")))
			{
			positionTwoOfClubs = i;
			twoOfClubs = "Player 2 has";
			nextUp = 3;
			onTheTable.add(playerHand2.get(positionTwoOfClubs));
			playerHand2.remove(positionTwoOfClubs);
			firstPlayed = 2;
			break;
			}
		}
	for(int i=0; i<13; i++)
		{
		if((playerHand3.get(i).getRank().equals("two")) && (playerHand3.get(i).getSuit().equals("clubs")))
			{
			positionTwoOfClubs = i;
			twoOfClubs = "Player 3 has";
			nextUp = 4;
			onTheTable.add(playerHand3.get(positionTwoOfClubs));
			playerHand3.remove(positionTwoOfClubs);
			firstPlayed = 3;
			break;
			}
		}
	for(int i=0; i<13; i++)
		{
		if((playerHand4.get(i).getRank().equals("two")) && (playerHand4.get(i).getSuit().equals("clubs")))
			{
			positionTwoOfClubs = i;
			twoOfClubs = "Player 4 has";
			nextUp = 1;
			onTheTable.add(playerHand4.get(positionTwoOfClubs));
			playerHand4.remove(positionTwoOfClubs);
			firstPlayed = 4;
			break;
			}
		}
	}
	
	public static void userHand()
	{
	System.out.println("You were delt the following cards:");
	for(Card c: playerHand1)
		{
		System.out.println(cardNumber + ". " + c.getRank() + " of " + c.getSuit());
		cardNumber+=1;
		}
	System.out.println();
	System.out.println("Press ENTER to continue.");
	
	Scanner userInput1 = new Scanner(System.in);
	String wait = userInput1.nextLine();
	
	System.out.println("Would you like to sort your cards? Y or N");
	
	Scanner userInput2 = new Scanner(System.in);
	String sort = userInput2.nextLine();
	
	if(sort.equals("Y")||sort.equals("y"))
		{
		sortHand();
		}
	else
		{
		
		}
	
	}
	
	public static void viewHand()
	{
	System.out.println("Your hand:");	
	System.out.println();
	cardNumber = 1;
	for(Card c: playerHand1)
		{
		System.out.println(cardNumber + ". " + c.getRank() + " of " + c.getSuit());
		cardNumber+=1;
		}
	}
	
	public static void sortHand()
	{
	System.err.println("this function is not yet available");	
	}
	
	public static void onTheTable()
	{
	System.out.println("The suit played is: " + suitPlayed + ".");
	for(Card c: onTheTable)
		{
		System.out.println(c.getRank() + " of " + c.getSuit());
		}
	}
	
	public static void endRound()
	{
	if(onTheTable.size() == 4)
		{
		String suit = onTheTable.get(0).getSuit(); 
		
		if((onTheTable.get(1).getSuit().equals(suit)) && (onTheTable.get(2).getSuit().equals(suit)) && (onTheTable.get(3).getSuit().equals(suit)))   /* if 1, 2, and 3 match suit */
			{
			if((onTheTable.get(0).getNumber() > onTheTable.get(1).getNumber()) && (onTheTable.get(0).getNumber() > onTheTable.get(2).getNumber()) && (onTheTable.get(0).getNumber() > onTheTable.get(3).getNumber()))
				{
				addTo = 0;
				}
			else if((onTheTable.get(1).getNumber() > onTheTable.get(0).getNumber()) && (onTheTable.get(1).getNumber() > onTheTable.get(2).getNumber()) && (onTheTable.get(1).getNumber() > onTheTable.get(3).getNumber()))
				{
				addTo = 1;
				}
			else if((onTheTable.get(2).getNumber() > onTheTable.get(0).getNumber()) && (onTheTable.get(2).getNumber() > onTheTable.get(1).getNumber()) && (onTheTable.get(2).getNumber() > onTheTable.get(3).getNumber()))
				{
				addTo = 2;
				}
			else if((onTheTable.get(3).getNumber() > onTheTable.get(0).getNumber()) && (onTheTable.get(3).getNumber() > onTheTable.get(1).getNumber()) && (onTheTable.get(3).getNumber() > onTheTable.get(2).getNumber()))
				{
				addTo = 3;
				}
			}
		else if((onTheTable.get(1).getSuit().equals(suit)) && (onTheTable.get(2).getSuit().equals(suit)))      /* if 1 and 2 match suit */
			{
			if((onTheTable.get(0).getNumber() > onTheTable.get(1).getNumber()) && (onTheTable.get(0).getNumber() > onTheTable.get(2).getNumber()))
				{
				addTo = 0;
				}
			else if((onTheTable.get(1).getNumber() > onTheTable.get(0).getNumber()) && (onTheTable.get(1).getNumber() > onTheTable.get(2).getNumber()))
				{
				addTo = 1;
				}
			else if((onTheTable.get(2).getNumber() > onTheTable.get(0).getNumber()) && (onTheTable.get(2).getNumber() > onTheTable.get(1).getNumber()))
				{
				addTo = 2;
				}
			}
		else if((onTheTable.get(2).getSuit().equals(suit)) && (onTheTable.get(3).getSuit().equals(suit)))    /* if 2 and 3 match suit */
			{
			if((onTheTable.get(0).getNumber() > onTheTable.get(2).getNumber()) && (onTheTable.get(0).getNumber() > onTheTable.get(3).getNumber()))
				{
				addTo = 0;
				}
			else if((onTheTable.get(2).getNumber() > onTheTable.get(0).getNumber()) && (onTheTable.get(2).getNumber() > onTheTable.get(3).getNumber()))
				{
				addTo = 2;
				}
			else if((onTheTable.get(3).getNumber() > onTheTable.get(0).getNumber()) && (onTheTable.get(3).getNumber() > onTheTable.get(2).getNumber()))
				{
				addTo = 3;
				}
			}
		else if((onTheTable.get(1).getSuit().equals(suit)) && (onTheTable.get(3).getSuit().equals(suit)))    /* if 1 and 3 match suit */
			{
			if((onTheTable.get(0).getNumber() > onTheTable.get(1).getNumber()) && (onTheTable.get(0).getNumber() > onTheTable.get(3).getNumber()))
				{
				addTo = 0;
				}
			else if((onTheTable.get(1).getNumber() > onTheTable.get(0).getNumber()) && (onTheTable.get(1).getNumber() > onTheTable.get(3).getNumber()))
				{
				addTo = 1;
				}
			else if((onTheTable.get(3).getNumber() > onTheTable.get(0).getNumber()) && (onTheTable.get(3).getNumber() > onTheTable.get(1).getNumber()))
				{
				addTo = 3;
				}
			}
		else if((onTheTable.get(1).getSuit().equals(suit)))   /* if 1 matches suit */
			{
			if(onTheTable.get(0).getNumber() > onTheTable.get(1).getNumber())
				{
				addTo = 0;
				}
			else
				{
				addTo = 1;
				}
			}
		else if((onTheTable.get(2).getSuit().equals(suit)))   /* if 2 matches suit */
			{
			if(onTheTable.get(0).getNumber() > onTheTable.get(2).getNumber())
				{
				addTo = 0;
				}
			else
				{
				addTo = 2;
				}
			}
		else if((onTheTable.get(3).getSuit().equals(suit)))   /* if 3 matches suit */
			{
			if(onTheTable.get(0).getNumber() > onTheTable.get(3).getNumber())
				{
				addTo = 0;
				}
			else
				{
				addTo = 3;
				}
			}
		else    /* if none match suit */
			{
			addTo = 0;
			}
		
		addTo();
		}
	else
		{
		nextUp();
		}
	}
	
	public static void waiting()
	{
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}
	
	public static void wonTrick()
	{
	waiting();	
	System.out.println();	
	if(wonTrick == 1)
		{
		System.err.println("You won the trick.");
		nextUp = 1;
		}
	else if(wonTrick == 2)
		{
		System.err.println("Player 2 won the trick.");
		nextUp = 2;
		}
	else if(wonTrick == 3)
		{
		System.err.println("Player 3 won the trick.");
		nextUp = 3;
		}
	else if(wonTrick == 4)
		{
		System.err.println("Player 4 won the trick.");
		nextUp = 4;
		}
	nextUp();
	}
	
	public static void addTo()
	{
	if(firstPlayed == 1)
		{
		if(addTo == 0)
			{
			for(int i=0; i<4; i++)
				{
				player1Collection.add(onTheTable.get(0));
				onTheTable.remove(0);
				wonTrick = 1;
				}
			}
		else if(addTo == 1)
			{
			for(int i=0; i<4; i++)
				{
				player2Collection.add(onTheTable.get(0));
				onTheTable.remove(0);
				wonTrick = 2;
				}
			}
		else if(addTo == 2)
			{
			for(int i=0; i<4; i++)
				{
				player3Collection.add(onTheTable.get(0));
				onTheTable.remove(0);
				wonTrick = 3;
				}
			}
		else if(addTo == 3)
			{
			for(int i=0; i<4; i++)
				{
				player4Collection.add(onTheTable.get(0));
				onTheTable.remove(0);
				wonTrick = 4;
				}
			}
		}
	else if(firstPlayed == 2)
		{
		if(addTo == 0)
		{
		for(int i=0; i<4; i++)
			{
			player2Collection.add(onTheTable.get(0));
			onTheTable.remove(0);
			wonTrick = 2;
			}
		}
	else if(addTo == 1)
		{
		for(int i=0; i<4; i++)
			{
			player3Collection.add(onTheTable.get(0));
			onTheTable.remove(0);
			wonTrick = 3;
			}
		}
	else if(addTo == 2)
		{
		for(int i=0; i<4; i++)
			{
			player4Collection.add(onTheTable.get(0));
			onTheTable.remove(0);
			wonTrick = 4;
			}
		}
	else if(addTo == 3)
		{
		for(int i=0; i<4; i++)
			{
			player1Collection.add(onTheTable.get(0));
			onTheTable.remove(0);
			wonTrick = 1;
			}
		}
		}
	else if(firstPlayed == 3)
		{
		if(addTo == 0)
		{
		for(int i=0; i<4; i++)
			{
			player3Collection.add(onTheTable.get(0));
			onTheTable.remove(0);
			wonTrick = 3;
			}
		}
	else if(addTo == 1)
		{
		for(int i=0; i<4; i++)
			{
			player4Collection.add(onTheTable.get(0));
			onTheTable.remove(0);
			wonTrick = 4;
			}
		}
	else if(addTo == 2)
		{
		for(int i=0; i<4; i++)
			{
			player1Collection.add(onTheTable.get(0));
			onTheTable.remove(0);
			wonTrick = 1;
			}
		}
	else if(addTo == 3)
		{
		for(int i=0; i<4; i++)
			{
			player2Collection.add(onTheTable.get(0));
			onTheTable.remove(0);
			wonTrick = 2;
			}
		}
		}
	else if(firstPlayed == 4)
		{
		if(addTo == 0)
		{
		for(int i=0; i<4; i++)
			{
			player4Collection.add(onTheTable.get(0));
			onTheTable.remove(0);
			wonTrick = 4;
			}
		}
	else if(addTo == 1)
		{
		for(int i=0; i<4; i++)
			{
			player1Collection.add(onTheTable.get(0));
			onTheTable.remove(0);
			wonTrick = 1;
			}
		}
	else if(addTo == 2)
		{
		for(int i=0; i<4; i++)
			{
			player2Collection.add(onTheTable.get(0));
			onTheTable.remove(0);
			wonTrick = 2;
			}
		}
	else if(addTo == 3)
		{
		for(int i=0; i<4; i++)
			{
			player3Collection.add(onTheTable.get(0));
			onTheTable.remove(0);
			wonTrick = 3;
			}
		}
		}
	wonTrick();
	}
	
	public static void nextUp()
	{
	System.out.println();	
	if(nextUp == 1)
		{
		System.out.println("It is your turn.");
		userTurn();
		nextUp = 2;
		endRound();
		}
	else if(nextUp == 2)
		{
		System.out.println("Player 2 is up.");
		ai2();
		nextUp = 3;
		endRound();
		}
	else if(nextUp == 3)
		{
		System.out.println("Player 3 is up.");
		ai3();
		nextUp = 4;
		endRound();
		}
	else if(nextUp == 4)
		{
		System.out.println("Player 4 is up.");
		ai4();
		nextUp = 1;
		endRound();
		}
	
	}
	
	public static void play()
	{
	
	}
	
	
	
	
	
	public static void userTurn()
	{
		if(onTheTable.size() == 0)
			{
			firstPlayed = 1;
			if(heartsBroken == true)
				{
				
				}
			else
				{
				System.out.println("You are starting the round. Type the number of the card you want to play.");
				System.out.println();
				viewHand();
				
				Scanner userInput1 = new Scanner(System.in);
				int choice = userInput1.nextInt();
				
				onTheTable.add(playerHand1.get(choice-1));
				playerHand1.remove(choice-1);
				}
			}
		else
			{
			if(onTheTable.get(0).getSuit().equals("clubs"))
				{
				for(int i=0; i<playerHand1.size(); i++)
					{
					if(playerHand1.get(i).getSuit().equals("clubs"))
						{
						playable1.add(playerHand1.get(i));
						playerHand1.remove(i);
						i++;
						}
					else
						{
						
						}
					}
				if(playable1.size() > 0)
				{
					System.out.println("You can play any of the following cards. Type the number of the card you want to play.");
					System.out.println();
					cardNumber = 1;
					for(Card c: playable1)
						{
						System.out.println(cardNumber + ". " + c.getRank() + " of " + c.getSuit());
						cardNumber+=1;
						}
					System.out.println();
					Scanner userInput1 = new Scanner(System.in);
					int choice = userInput1.nextInt();
					onTheTable.add(playable1.get(choice-1));
					playable1.remove(choice-1);
			
					for(int i=0; i<playable1.size(); i++)
						{
						playerHand1.add(playable1.get(i));
						playable1.remove(i);
						i++;
						}
					}
				else
					{
					System.out.println("You can play any of the following cards. Type the number of the card you want to play.");
					System.out.println();
					cardNumber = 1;
					for(Card c: playerHand1)
						{
						System.out.println(cardNumber + ". " + c.getRank() + " of " + c.getSuit());
						cardNumber+=1;
						}
					System.out.println();
					Scanner userInput1 = new Scanner(System.in);
					int choice = userInput1.nextInt();
					onTheTable.add(playerHand1.get(choice));
					playerHand1.remove(choice);
					}
				}
			else if(onTheTable.get(0).getSuit().equals("spades"))
				{
					for(int i=0; i<playerHand1.size(); i++)
						{
						if(playerHand1.get(i).getSuit().equals("spades"))
							{
							playable1.add(playerHand1.get(i));
							playerHand1.remove(i);
							i++;
							}
						else
							{
							
							}
						}
					if(playable1.size() > 0)
					{
						System.out.println("You can play any of the following cards. Type the number of the card you want to play.");
						System.out.println();
						cardNumber = 1;
						for(Card c: playable1)
							{
							System.out.println(cardNumber + ". " + c.getRank() + " of " + c.getSuit());
							cardNumber+=1;
							}
						System.out.println();
						Scanner userInput1 = new Scanner(System.in);
						int choice = userInput1.nextInt();
						onTheTable.add(playable1.get(choice-1));
						playable1.remove(choice-1);
				
						for(int i=0; i<playable1.size(); i++)
							{
							playerHand1.add(playable1.get(i));
							playable1.remove(i);
							i++;
							}
						}
					else
						{
						System.out.println("You can play any of the following cards. Type the number of the card you want to play.");
						System.out.println();
						cardNumber = 1;
						for(Card c: playerHand1)
							{
							System.out.println(cardNumber + ". " + c.getRank() + " of " + c.getSuit());
							cardNumber+=1;
							}
						System.out.println();
						Scanner userInput1 = new Scanner(System.in);
						int choice = userInput1.nextInt();
						onTheTable.add(playerHand1.get(choice));
						playerHand1.remove(choice);
						}
				}
			else if(onTheTable.get(0).getSuit().equals("hearts"))
				{
					for(int i=0; i<playerHand1.size(); i++)
						{
							if(playerHand1.get(i).getSuit().equals("hearts"))
								{
								playable1.add(playerHand1.get(i));
								playerHand1.remove(i);
								i++;
								}
							else
								{
					
								}
						}
					if(playable1.size() > 0)
						{
						System.out.println("You can play any of the following cards. Type the number of the card you want to play.");
						System.out.println();
						cardNumber = 1;
						for(Card c: playable1)
							{
							System.out.println(cardNumber + ". " + c.getRank() + " of " + c.getSuit());
							cardNumber+=1;
							}
						System.out.println();
						Scanner userInput1 = new Scanner(System.in);
						int choice = userInput1.nextInt();
						onTheTable.add(playable1.get(choice-1));
						playable1.remove(choice-1);
				
						for(int i=0; i<playable1.size(); i++)
							{
							playerHand1.add(playable1.get(i));
							playable1.remove(i);
							i++;
							}
						}
					else
						{
						System.out.println("You can play any of the following cards. Type the number of the card you want to play.");
						System.out.println();
						cardNumber = 1;
						for(Card c: playerHand1)
							{
							System.out.println(cardNumber + ". " + c.getRank() + " of " + c.getSuit());
							cardNumber+=1;
							}
						System.out.println();
						Scanner userInput1 = new Scanner(System.in);
						int choice = userInput1.nextInt();
						onTheTable.add(playerHand1.get(choice));
						playerHand1.remove(choice);
						}
				}
			else if(onTheTable.get(0).getSuit().equals("diamonds"))
			{
				for(int i=0; i<playerHand1.size(); i++)
					{
						if(playerHand1.get(i).getSuit().equals("diamonds"))
							{
							playable1.add(playerHand1.get(i));
							playerHand1.remove(i);
							i++;
							}
						else
							{
				
							}
					}
				if(playable1.size() > 0)
				{
					System.out.println("You can play any of the following cards. Type the number of the card you want to play.");
					System.out.println();
					cardNumber = 1;
					for(Card c: playable1)
						{
						System.out.println(cardNumber + ". " + c.getRank() + " of " + c.getSuit());
						cardNumber+=1;
						}
					System.out.println();
					Scanner userInput1 = new Scanner(System.in);
					int choice = userInput1.nextInt();
					onTheTable.add(playable1.get(choice-1));
					playable1.remove(choice-1);
			
					for(int i=0; i<playable1.size(); i++)
						{
						playerHand1.add(playable1.get(i));
						playable1.remove(i);
						i++;
						}
					}
				else
					{
					System.out.println("You can play any of the following cards. Type the number of the card you want to play.");
					System.out.println();
					cardNumber = 1;
					for(Card c: playerHand1)
						{
						System.out.println(cardNumber + ". " + c.getRank() + " of " + c.getSuit());
						cardNumber+=1;
						}
					System.out.println();
					Scanner userInput1 = new Scanner(System.in);
					int choice = userInput1.nextInt();
					onTheTable.add(playerHand1.get(choice));
					playerHand1.remove(choice);
					}
			}
			}
		}
	
	public static void ai2()
	{
	if(onTheTable.size() == 0)
		{
		firstPlayed = 2;
		if(heartsBroken == true)
			{
			
			}
		else
			{
			int random = ((int) Math.random()*playerHand2.size());
			onTheTable.add(playerHand2.get(random));
			playerHand2.remove(random);
			}
		}
	else
		{
		if(onTheTable.get(0).getSuit().equals("clubs"))
			{
			for(int i=0; i<playerHand2.size(); i++)
				{
				if(playerHand2.get(i).getSuit().equals("clubs"))
					{
					playable2.add(playerHand2.get(i));
					playerHand2.remove(i);
					i++;
					}
				else
					{
					
					}
				}
			if(playable2.size() > 0)
				{
				int random = ((int) Math.random()*playable2.size());
				onTheTable.add(playable2.get(random));
				playable2.remove(random);
				
				for(int i=0; i<playable2.size(); i++)
					{
					playerHand2.add(playable2.get(i));
					playable2.remove(i);
					i++;
					}
				}
			else
				{
				int random = ((int) Math.random()*playerHand2.size());
				onTheTable.add(playerHand2.get(random));
				playerHand2.remove(random);
				}
			}
		else if(onTheTable.get(0).getSuit().equals("spades"))
			{
				for(int i=0; i<playerHand2.size(); i++)
					{
					if(playerHand2.get(i).getSuit().equals("spades"))
						{
						playable2.add(playerHand2.get(i));
						playerHand2.remove(i);
						i++;
						}
					else
						{
						
						}
					}
				if(playable2.size() > 0)
					{
					int random = ((int) Math.random()*playable2.size());
					onTheTable.add(playable2.get(random));
					playable2.remove(random);
					
					for(int i=0; i<playable2.size(); i++)
						{
						playerHand2.add(playable2.get(i));
						playable2.remove(i);
						i++;
						}
					}
				else
					{
					int random = ((int) Math.random()*playerHand2.size());
					onTheTable.add(playerHand2.get(random));
					playerHand2.remove(random);
					}
			}
		else if(onTheTable.get(0).getSuit().equals("hearts"))
			{
				for(int i=0; i<playerHand2.size(); i++)
					{
						if(playerHand2.get(i).getSuit().equals("hearts"))
							{
							playable2.add(playerHand2.get(i));
							playerHand2.remove(i);
							i++;
							}
						else
							{
				
							}
					}
				if(playable2.size() > 0)
					{
					int random = ((int) Math.random()*playable2.size());
					onTheTable.add(playable2.get(random));
					playable2.remove(random);
			
					for(int i=0; i<playable2.size(); i++)
						{
						playerHand2.add(playable2.get(i));
						playable2.remove(i);
						i++;
						}
					}
				else
					{
					int random = ((int) Math.random()*playerHand2.size());
					onTheTable.add(playerHand2.get(random));
					playerHand2.remove(random);
					}
			}
		else if(onTheTable.get(0).getSuit().equals("diamonds"))
		{
			for(int i=0; i<playerHand2.size(); i++)
				{
					if(playerHand2.get(i).getSuit().equals("diamonds"))
						{
						playable2.add(playerHand2.get(i));
						playerHand2.remove(i);
						i++;
						}
					else
						{
			
						}
				}
			if(playable2.size() > 0)
				{
				int random = ((int) Math.random()*playable2.size());
				onTheTable.add(playable2.get(random));
				playable2.remove(random);
		
				for(int i=0; i<playable2.size(); i++)
					{
					playerHand2.add(playable2.get(i));
					playable2.remove(i);
					i++;
					}
				}
			else
				{
				int random = ((int) Math.random()*playerHand2.size());
				onTheTable.add(playerHand2.get(random));
				playerHand2.remove(random);
				}
		}
		}
	System.out.println();
	System.out.println("Player 2 played the " + onTheTable.get(onTheTable.size()-1).getRank() + " of " + onTheTable.get(onTheTable.size()-1).getSuit() + ".");
	}
	
	public static void ai3()
	{
		if(onTheTable.size() == 0)
			{
			firstPlayed = 3;
			if(heartsBroken == true)
				{
				
				}
			else
				{
				int random = ((int) Math.random()*playerHand3.size());
				onTheTable.add(playerHand3.get(random));
				playerHand3.remove(random);
				}
			}
		else
			{
			if(onTheTable.get(0).getSuit().equals("clubs"))
				{
				for(int i=0; i<playerHand3.size(); i++)
					{
					if(playerHand3.get(i).getSuit().equals("clubs"))
						{
						playable3.add(playerHand3.get(i));
						playerHand3.remove(i);
						i++;
						}
					else
						{
						
						}
					}
				if(playable3.size() > 0)
					{
					int random = ((int) Math.random()*playable3.size());
					onTheTable.add(playable3.get(random));
					playable3.remove(random);
					
					for(int i=0; i<playable3.size(); i++)
						{
						playerHand3.add(playable3.get(i));
						playable3.remove(i);
						i++;
						}
					}
				else
					{
					int random = ((int) Math.random()*playerHand3.size());
					onTheTable.add(playerHand3.get(random));
					playerHand3.remove(random);
					}
				}
			else if(onTheTable.get(0).getSuit().equals("spades"))
				{
					for(int i=0; i<playerHand3.size(); i++)
						{
						if(playerHand3.get(i).getSuit().equals("spades"))
							{
							playable3.add(playerHand3.get(i));
							playerHand3.remove(i);
							i++;
							}
						else
							{
							
							}
						}
					if(playable3.size() > 0)
						{
						int random = ((int) Math.random()*playable3.size());
						onTheTable.add(playable3.get(random));
						playable3.remove(random);
						
						for(int i=0; i<playable3.size(); i++)
							{
							playerHand3.add(playable3.get(i));
							playable3.remove(i);
							i++;
							}
						}
					else
						{
						int random = ((int) Math.random()*playerHand3.size());
						onTheTable.add(playerHand3.get(random));
						playerHand3.remove(random);
						}
				}
			else if(onTheTable.get(0).getSuit().equals("hearts"))
				{
					for(int i=0; i<playerHand3.size(); i++)
						{
							if(playerHand3.get(i).getSuit().equals("hearts"))
								{
								playable3.add(playerHand3.get(i));
								playerHand3.remove(i);
								i++;
								}
							else
								{
					
								}
						}
					if(playable3.size() > 0)
						{
						int random = ((int) Math.random()*playable3.size());
						onTheTable.add(playable3.get(random));
						playable3.remove(random);
				
						for(int i=0; i<playable3.size(); i++)
							{
							playerHand3.add(playable3.get(i));
							playable3.remove(i);
							i++;
							}
						}
					else
						{
						int random = ((int) Math.random()*playerHand3.size());
						onTheTable.add(playerHand3.get(random));
						playerHand3.remove(random);
						}
				}
			else if(onTheTable.get(0).getSuit().equals("diamonds"))
			{
				for(int i=0; i<playerHand3.size(); i++)
					{
						if(playerHand3.get(i).getSuit().equals("diamonds"))
							{
							playable3.add(playerHand3.get(i));
							playerHand3.remove(i);
							i++;
							}
						else
							{
				
							}
					}
				if(playable3.size() > 0)
					{
					int random = ((int) Math.random()*playable3.size());
					onTheTable.add(playable3.get(random));
					playable3.remove(random);
			
					for(int i=0; i<playable3.size(); i++)
						{
						playerHand3.add(playable3.get(i));
						playable3.remove(i);
						i++;
						}
					}
				else
					{
					int random = ((int) Math.random()*playerHand3.size());
					onTheTable.add(playerHand3.get(random));
					playerHand3.remove(random);
					}
			}
			}
		System.out.println();
		System.out.println("Player 3 played the " + onTheTable.get(onTheTable.size()-1).getRank() + " of " + onTheTable.get(onTheTable.size()-1).getSuit() + ".");
		}
	
	public static void ai4()
	{
		if(onTheTable.size() == 0)
			{
			firstPlayed = 4;
			if(heartsBroken == true)
				{
				
				}
			else
				{
				int random = ((int) Math.random()*playerHand4.size());
				onTheTable.add(playerHand4.get(random));
				playerHand4.remove(random);
				}
			}
		else
			{
			if(onTheTable.get(0).getSuit().equals("clubs"))
				{
				for(int i=0; i<playerHand4.size(); i++)
					{
					if(playerHand4.get(i).getSuit().equals("clubs"))
						{
						playable4.add(playerHand4.get(i));
						playerHand4.remove(i);
						i++;
						}
					else
						{
						
						}
					}
				if(playable4.size() > 0)
					{
					int random = ((int) Math.random()*playable4.size());
					onTheTable.add(playable4.get(random));
					playable4.remove(random);
					
					for(int i=0; i<playable4.size(); i++)
						{
						playerHand4.add(playable4.get(i));
						playable4.remove(i);
						i++;
						}
					}
				else
					{
					int random = ((int) Math.random()*playerHand4.size());
					onTheTable.add(playerHand4.get(random));
					playerHand4.remove(random);
					}
				}
			else if(onTheTable.get(0).getSuit().equals("spades"))
				{
					for(int i=0; i<playerHand4.size(); i++)
						{
						if(playerHand4.get(i).getSuit().equals("spades"))
							{
							playable4.add(playerHand4.get(i));
							playerHand4.remove(i);
							i++;
							}
						else
							{
							
							}
						}
					if(playable4.size() > 0)
						{
						int random = ((int) Math.random()*playable4.size());
						onTheTable.add(playable4.get(random));
						playable4.remove(random);
						
						for(int i=0; i<playable4.size(); i++)
							{
							playerHand4.add(playable4.get(i));
							playable4.remove(i);
							i++;
							}
						}
					else
						{
						int random = ((int) Math.random()*playerHand4.size());
						onTheTable.add(playerHand4.get(random));
						playerHand4.remove(random);
						}
				}
			else if(onTheTable.get(0).getSuit().equals("hearts"))
				{
					for(int i=0; i<playerHand4.size(); i++)
						{
							if(playerHand4.get(i).getSuit().equals("hearts"))
								{
								playable4.add(playerHand4.get(i));
								playerHand4.remove(i);
								i++;
								}
							else
								{
					
								}
						}
					if(playable4.size() > 0)
						{
						int random = ((int) Math.random()*playable4.size());
						onTheTable.add(playable4.get(random));
						playable4.remove(random);
				
						for(int i=0; i<playable4.size(); i++)
							{
							playerHand4.add(playable4.get(i));
							playable4.remove(i);
							i++;
							}
						}
					else
						{
						int random = ((int) Math.random()*playerHand4.size());
						onTheTable.add(playerHand4.get(random));
						playerHand4.remove(random);
						}
				}
			else if(onTheTable.get(0).getSuit().equals("diamonds"))
			{
				for(int i=0; i<playerHand4.size(); i++)
					{
						if(playerHand4.get(i).getSuit().equals("diamonds"))
							{
							playable4.add(playerHand4.get(i));
							playerHand4.remove(i);
							i++;
							}
						else
							{
				
							}
					}
				if(playable4.size() > 0)
					{
					int random = ((int) Math.random()*playable4.size());
					onTheTable.add(playable4.get(random));
					playable4.remove(random);
			
					for(int i=0; i<playable4.size(); i++)
						{
						playerHand4.add(playable4.get(i));
						playable4.remove(i);
						i++;
						}
					}
				else
					{
					int random = ((int) Math.random()*playerHand4.size());
					onTheTable.add(playerHand4.get(random));
					playerHand4.remove(random);
					}
			}
			}
		System.out.println();
		System.out.println("Player 4 played the " + onTheTable.get(onTheTable.size()-1).getRank() + " of " + onTheTable.get(onTheTable.size()-1).getSuit() + ".");
		}

}
