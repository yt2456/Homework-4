
public class HeapNode implements Comparable
{
   private String character;
   private int freq;
   
   public HeapNode(String c, int f)
   {
	   character = c;
	   freq = f;
   }
   
   public String getCharacter()
   {
	   return character;
   }
   
   public int getFreq()
   {
	   return freq;
   }
   
   public void setCharacter(String c)
   {
	   character = c;
   }
   
   public void setFreq(int f)
   {
	   freq = f;
   }

   public int compareTo(Object h) 
   {
	   if(this.getFreq() > ((HeapNode) h).getFreq())
	   {
		   return 1;
	   }
	   else
	   {
	      if(this.getFreq() == ((HeapNode) h).getFreq())
	      {
	    	  return 0;
	      }
	      else
	      {
	    	  return -1;
	      }
	   }
   }

}
