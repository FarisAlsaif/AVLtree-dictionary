import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

import javax.xml.crypto.Data;

public class dictionary{
		
	
	
	
	AVLTree tree = new AVLTree();
	
	
	WordPair wordpair = new WordPair();
	
	
	dictionary() throws IOException{
		File reader = new File("dictionary.txt");
		Scanner scan = new Scanner(reader);
		
		while(scan.hasNext()) {
		String word = scan.next();// read the word.
		String meaning = scan.nextLine(); //read the definition;
		wordpair.SetWord(word); // set the word.
		wordpair.SetMeaning(meaning); // set its meaning.
		tree.insertAVL(wordpair.getWord()+wordpair.getMeaning()); // insert it in the AVLtree.
		}
		scan.close();
			
	}
	@SuppressWarnings("unchecked")
	
	// insert method.
	public boolean insert(WordPair wordpair) throws IOException { 
		
		// return false if the word already in the dictionary.
		if(find(wordpair.getWord()) != null) {
			System.out.println("The word is already in the dictionary");
			return false;
			}
		

		
		return tree.insertAVL(wordpair.getWord() +" "+wordpair.getMeaning());// Add the new word to the tree and return true if the insertion is successful.
	}
	
	// isEmpty method.
	public boolean isEmpty(){
		return tree.root == null; // if the root of the tree is empty then the dictionary is empty.
	}
	
	// getSize method.
	public int getSize(){
		
		return getSize(tree.root);
	}
	private int getSize(BTNode node) {
			
		if (node == null) 
            return 0; 

        return 1+ getSize(node.right) + getSize(node.left);
	}

	// Find method
	public WordPair find(String word) {
		
		BTNode node = tree.root;
		String inWord = ((String) node.data); // T
		String wantedWord = inWord.split(" ",0)[0]; // T
        while (node != null) {
	 
            if (word.equals(wantedWord)) { 
            	String wantedMeaning = inWord.split(" ",2)[1]; 
            	WordPair wordpair = new WordPair(wantedWord, wantedMeaning);
                 return  wordpair; 
                 }                   
            else if (word.compareTo(wantedWord) < 0)
                 node = node.left;
            else 
                 node = node.right;
            if(node != null) {
            inWord = ((String) node.data);
            wantedWord = inWord.split(" ",0)[0];
            }
    		}
        
        return null;  
		
	}
	
	// Delete method.
	public boolean delete(String word) throws IOException{
		
		
		WordPair wordpair = find(word);
		
		if(wordpair == null)
			return false;
		else 
			tree.deleteAVL(wordpair.getWord()+" " + wordpair.getMeaning()); // delete the node with having the specified word.
		
//		 writeInfile(); // Updating the text file.
		
		
		return true;
		
	}
	
	
	// Modify Word method
	public boolean modifyWord(String word, String newMeanings) throws IOException{

		BTNode node = tree.root;
		String inWord = ((String) node.data); // T
		String wantedWord = inWord.split(" ",0)[0]; // T
        while (node != null) {
	 
            if (word.equals(wantedWord)) { 
            	String wantedMeaning = inWord.split(" ",2)[1]; 
            	WordPair wordpair = new WordPair(word, newMeanings);
            	node.data = wordpair.getWord() +" "+ wordpair.getMeaning();
            	writeInfile();
                 return  true;  }                   
            else if (word.compareTo(wantedWord) < 0)
                 node = node.left;
            else 
                 node = node.right;
            if(node != null) {
            inWord = ((String) node.data);
            wantedWord = inWord.split(" ",0)[0];
            }
    		}
        System.out.println("Word not in dictionary.");
        return false;}
	
	
	// Write in file method.
	public void writeInfile() throws IOException{
		FileWriter writer = new FileWriter("dictionary.txt");
		 BTNode p = tree.root;
	        Stack<BTNode> travStack = new Stack<BTNode>();
	        while (p != null) {
	            while(p != null) {               // stack the right child (if any)
	                 if (p.right != null)        // and the node itself when going
	                    travStack.push(p.right); // to the left;
	                 travStack.push(p);
	                 p = p.left;
	            }
	            p = travStack.pop();             // pop a node with no left child
	            while (!travStack.isEmpty() && p.right == null) { // write it and all
	                 writer.write(p.data+"\n");                  // nodes with no right child;
	                 p =  travStack.pop();
	            }
	            writer.write(p.data+"\n");                        // write also the first node with
	            if (!travStack.isEmpty())        // a right child (if any);
	                 p = travStack.pop();
	            else 
	                p = null;
	        }
	        writer.close();
		
	}
	public void printAll(String prefix){  
		
	       printAll(tree.root, prefix);   
	     } 

	    private void printAll(BTNode node, String prefix) { 
	        if (node == null) 
	            return; 
	  String word = (String) node.data;
	  
	        printAll(node.left,prefix); 
	        if(word.startsWith(prefix)) 
	        System.out.println(node.data);
	        printAll(node.right,prefix); 
	    } 
	public void printSorted(){
		
		tree.inorderTraversal();// to traverse in lexicographic order.
	}

	
}
