import java.util.*;

public class Card 
{
	
	private String rank;
	private String suit;
	private int number;
	
	public Card (String r, String s, int n)
	{
	rank = r;
	suit = s;
	number = n;
	}
	
	public  String getRank() 
		{
		return rank;
		}

	public void setRank(String rank) 
		{
		this.rank = rank;
		}

	public String getSuit() 
		{
		return suit;
		}

	public void setSuit(String suit) 
		{
		this.suit = suit;
		}

	public int getNumber() 
		{
		return number;
		}

	public void setNumber(int number) 
		{
		this.number = number;
		}

	
	
}
