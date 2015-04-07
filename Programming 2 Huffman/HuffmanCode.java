import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HuffmanCode extends JFrame
{
	private String infix;
	private int[] charFreq = new int[128];
	BinaryHeap heap = new BinaryHeap(128);
	private JTree tree;
	ExpTreeNode rt;
	
	public HuffmanCode()
	{
		initialize();
	}
	
    private void initialize()
    {
    	   final JTextArea result = new JTextArea(12,12);
    	   final JTextArea treeArea = new JTextArea(20, 20);
    	   final JScrollPane rScroll = new JScrollPane(treeArea);
    	   
    	   final JTextField inputA = new JTextField(); 
    	   inputA.setText("Please press enter after input for input to be accepted");
    	   inputA.addActionListener(new ActionListener() {
    		    @Override
    		    public void actionPerformed(ActionEvent e) {
    		       result.setText(null);
    		       treeArea.setText(null);
    		       infix = inputA.getText();
    		       
    		       findFreq(infix);
    		       printFreq(result);
    		       
    		       createPriorityQueue();
    		       createTree();
    		       
    		       huffmanCode(rt.getLChild(), "1");
    		       huffmanCode(rt.getRChild(), "0");
    		       
    		       printTree(rt, 5, treeArea);
    		    }
    		});
    	   
    	   Container p = getContentPane();
    	   
    	   
    	   p.add(inputA, BorderLayout.NORTH);
    	   p.add(result, BorderLayout.CENTER);
    	   p.add(rScroll, BorderLayout.SOUTH);
    	   
    	   setTitle("Huffman Code");
    	   setSize(500, 500);
    	   setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
   
    public void createTree()
    {
    	HeapNode leftN = (HeapNode) heap.deleteMin();
    	HeapNode rightN = (HeapNode) heap.deleteMin();
    	
    	ExpTreeNode leftNode = new ExpTreeNode( leftN.getCharacter(), leftN.getFreq(),null,null);
    	ExpTreeNode rightNode = new ExpTreeNode( rightN.getCharacter(), rightN.getFreq(),null,null);
    	
    	
    	
    	rt = new ExpTreeNode(null, leftNode.getFreq() + rightNode.getFreq(), leftNode, rightNode);
 
    	while(heap.isEmpty() == false)
    	{
    		rt = createT(rt, (HeapNode)heap.deleteMin());
    	}
    }
    
    private ExpTreeNode createT(ExpTreeNode left, HeapNode right)
    {
    	ExpTreeNode leftN = left;
    	ExpTreeNode rightN = new ExpTreeNode(right.getCharacter(), right.getFreq(),null,null);
    	
    	return new ExpTreeNode(null, leftN.getFreq() + rightN.getFreq(), leftN, rightN);
    }
    
    public void printTree(ExpTreeNode t, int indent, JTextArea r) 
	{
		if (t != null) 
		{
			printTree(t.getRChild(), indent + 5, r);
			
			for (int i = 0; i < indent; i++)
			{
				r.append("    ");
				System.out.print(" ");
			}
			
			if(t.getData() != null)
			{
				r.append(t.getData() + ": " + t.getFreq() + "Code: " + t.getHuffmanCode() + "\n");
			}
			else
			{
				r.append(t.getData() + ": " + t.getFreq() + "\n");
			}
			
			printTree(t.getLChild(), indent + 3, r);
		}
	}
    
	public void findFreq(String input)
    {
    	for(int x = 0; x < input.length(); x++)
    	{
    		charFreq[(int)input.charAt(x)]++;
    	}
    }
    
    private void printFreq(JTextArea r)
    {
    	String temp;
    	
    	r.append("Message: " + infix + "\n");
    	r.append("CHAR ASCII FREQ\n");
    	
    	for(int x = 0; x < charFreq.length; x++)
    	{
    		if(charFreq[x] > 0)
    		{
    			temp = Character.toString((char)x);
    			r.append("    " + temp + "      " + x + "      " + charFreq[x] + "\n");
    		}
    	}
    }
    
    private void createPriorityQueue()
    {
    	for(int x = 0; x < charFreq.length; x++)
    	{
    		if(charFreq[x] > 0)
    		{
    			heap.insert(new HeapNode(Character.toString((char)x), charFreq[x]));
    		}
    	}	
    }
    
    public int huffmanCode(ExpTreeNode n, String inc)
    {
    	if(n == null)
    	{
    		return 0;
    	}
    	else
    	{
    		n.setHuffmanCode(inc);
    		huffmanCode(n.getLChild(), inc + "1");
    		huffmanCode(n.getRChild(), inc + "0");
    	}
    	
    	return 0;
    }
    
    public static void main(String[] args)
    {
 	   JFrame f = new HuffmanCode();
 	   f.setVisible(true);
    }
}
