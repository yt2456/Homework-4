import java.io.*;
import java.util.LinkedList;


public class ReservedHash
{
	private final int tableSize = 46;
	int index;
	static int collisions;
	String[] hashtable = new String[tableSize];
	private String reservedW[] = {"abstract", "default", "if", "private", "throw", "boolean", "do",
			"implements", "protected", "throws", "break", "double", "import",
			"public", "transient", "byte", "else", "instanceof", "return", "try",
			"case", "extends", "int", "short", "void", "catch", "final",
			"interface", "static", "volatile", "char", "finally", "long", "super",
			"while", "class", "float", "native", "switch", "true", "const", "for",
			"new", "synchronized", "false", "null"};
	
	public void readLine() throws IOException
	{
		int hashCode;
		
		for(int x = 0; x < tableSize; x++)
		{
			hashtable[x] = null;
		}
		
		for(int x = 0; x < reservedW.length; x++)
		{
			hashCode = hash(reservedW[x], tableSize);
			
			if(hashtable[hashCode] != null) 
			{ // is it a collision?
				collisions++;
				//System.out.println("word=" + reservedW[x] + " index=" + index +
				//" collisions=" + collisions);
			    
				if(hashtable[hashCode].substring(0,1).equals("*"))
				{
					hashtable[hashCode] = hashtable[hashCode] + " " + reservedW[x];
				}
				else
				{
					hashtable[hashCode] = "*" + hashtable[hashCode] + " " + reservedW[x]; 
				}
			}
			else
			{
				hashtable[hashCode] = reservedW[x];
			}
		}
		
	}
	
	public int hash(String word, int tableSize)
	{
		int hashVal = 997;
		
		for( int i = 0; i < word.length(); i++)
		{
			hashVal = 63 * hashVal + word.charAt(i);
		}
		
		hashVal %= tableSize;
		
		if( hashVal < 0)
			hashVal += tableSize;
		
		return hashVal;
	}
	
	public void printHash()
	{
		for(int x = 0; x < hashtable.length; x++)
		{
			if(hashtable[x] != null)
			{
				if( String.valueOf(hashtable[x].charAt(0)).equals("*"))
				{
					System.out.println(hashtable[x].substring(1, hashtable[x].length()) + " " + x + " " + "collision");
				}
				else
				{
					System.out.println(hashtable[x] + " " + x);
				}
			}
			else
			{
				System.out.println("null" + " " + x);
			}
		}
		
		System.out.println("Total collisions = " + collisions);
	}
	
	public static void main(String[] args) throws Exception
	{
		ReservedHash app = new ReservedHash();
		app.readLine();
		app.printHash();
	}

}
