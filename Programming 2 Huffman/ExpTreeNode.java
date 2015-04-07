/**
 * Basic node for a binary expression tree. Contains information the data structure holds
 * and the links to the right and left children. Also contains information about whether the node
 * is an operator or an operand.
 *
 */
public class ExpTreeNode 
{
   private Object data;
   private int freq;
   private String HuffmanCode;
   private ExpTreeNode left;
   private ExpTreeNode right;
   
   public ExpTreeNode( Object d, int f, ExpTreeNode l, ExpTreeNode r)
   {
	   data = d;
	   freq = f;
	   left = l;
	   right = r;
   }
   
   public void setHuffmanCode(String h)
   {
	     HuffmanCode = h;
   }
   
   public String getHuffmanCode()
   {
	   return HuffmanCode;
   }
   
   public Object getData()
   {
	   return data;
   }
   
   public ExpTreeNode getLChild()
   {
	   return left;
   }
   
   public ExpTreeNode getRChild()
   {
	   return right;
   }
   
   public int getFreq()
   {
	   return freq;
   }
   
   public void setData(Object d)
   {
	   data = d;
   }
   
   public void setLChild(ExpTreeNode l)
   {
	   left = l;
   }
   
   public void setRChild(ExpTreeNode r)
   {
	   right = r;
   }
   
}
