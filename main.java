import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class main {
	
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		dictionary dictionary = new dictionary();
		
//		WordPair wordpair = new WordPair("Faris", "Abdulraham Alsaif");
//		WordPair wordpair2 = new WordPair("AB", "Mohammad Alnasser");
//		WordPair wordpair3 = new WordPair("AC", "saeed flah");
//		WordPair wordpair4 = new WordPair("B", "jehad malaka");
//		WordPair wordpair5 = new WordPair("AD", "mohammed majed");
////		
////		System.out.println(wordpair2);
//		dictionary.insert(wordpair);
//		dictionary.insert(wordpair2);
//		dictionary.insert(wordpair3);
//		dictionary.insert(wordpair4);
//		dictionary.insert(wordpair5);


		int choosenOption; 
		String word; 
		String meaning;
		boolean flage = true;
		
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Choose an operation to perform");
			System.out.println("1. Insert a new word with its meanings");
			System.out.println("2. Search for a word");
			System.out.println("3. Delete a word and its meanings");
			System.out.println("4. Modify the meanings of a word");
			System.out.println("5. Print all words with a given prefix and their meanings");
			System.out.println("6. Print the contents of the dictionary sorted in lexicographic order");
			System.out.println("7. Exit");
			choosenOption = scanner.nextInt();
			
			switch(choosenOption){
			case 1:
				System.out.println("Write the word");
				 word = scanner.next();
				System.out.println("Write it's meanings");
				scanner.nextLine(); 
				meaning = scanner.nextLine();
				WordPair wordpair1 = new WordPair(word,meaning);
				dictionary.insert(wordpair1);
				break;
			case 2: 
				System.out.println("Enter a word to look for");
				 word = scanner.next();
				 if(dictionary.find(word) == null)
					 System.out.println("Word not in the dictionary");
				 else {
					 WordPair wordpair = new WordPair(dictionary.find(word));
					 System.out.println(wordpair.getWord() +" "+wordpair.getMeaning());}
				 break;
			case 3:
				System.out.println("Write the word to be deleted.");
				 word = scanner.next();
				dictionary.delete(word);
				break;
			case 4:
				System.out.println("Write the word to be Modified.");
				 word = scanner.next();
				 System.out.println("Write the new definition");
				 scanner.nextLine();
				 meaning = scanner.nextLine();
				 dictionary.modifyWord(word, meaning);
				 break;
			case 5:
				System.out.println("Write the prefix.");
				 word = scanner.next();
				 dictionary.printAll(word);
				break;
			case 6:
				dictionary.printSorted();
				break;
				
			case 7: 
				dictionary.writeInfile();
				flage = false;
				break;
			}
			
			
		}
		while(flage);
			
//		dictionary.printSorted();
		
		 
	}

}
