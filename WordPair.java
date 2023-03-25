
public class WordPair implements Comparable<WordPair>{

	private String word;
	private String wordMeanings;

	
//	WordPair(){
//		
//		
//	}
	
	WordPair(){
		
	}
	WordPair(String word, String wordMeanings){
		
		this.word = word;
		this.wordMeanings  = wordMeanings;
		
	}
	
	public WordPair(WordPair wordpair) {
		this.word = wordpair.getWord();
		this.wordMeanings = wordpair.getMeaning();
	}
	public int compareTo(WordPair o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public String getWord(){
		return word;
	}
	public String getMeaning() {
		return wordMeanings;
	}
	public void SetWord(String word) {
		this.word = word;
	}
	public void SetMeaning(String meaning){
		this.wordMeanings = meaning;
	}

	}
	

