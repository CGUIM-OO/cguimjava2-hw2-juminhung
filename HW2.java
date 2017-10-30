import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: please add student ID and name here:B0544207,洪如旻
 * Try to write some comments for your codes (methods, 15 points)
 * 總共3個class,分別為HW2,Deck,Card
 * System.out.println請你輸入有幾副牌，輸入的數字會存在testn裡面
 * 設一個int變數叫nDeck，等於剛剛輸入的數字，但是因為剛剛輸入為String，所以要用Integer.parseInt轉換
 * 呼叫method Deck算出輸入的牌數，接著把deck裡面輸入的牌，不論幾副牌都印出來
 * 如果isAllCardsCorrect是成立的，就會print出Well done!
 * 如果isAllCardsCorrect是不成立的，就會print出Error, please check your sourse code
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards �������
	 * @param nDeck 蝮賢��嗾����
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO: please add description here
 * class Deck
 * 把cards設成private，以免讓別人亂改
 * constructor為Deck (nDeck)
 * cards新增為一個ArrayList
 * 跑三個for迴圈，第一個:從n(幾副牌)等於nDeck到n>0，每次減一，第二個:從suit(花色)=1到4，每次加一，第三個:從rank(數字)=1到13，每次加一
 * 迴圈裡跑出一張card，就會放進cards裡面，直到迴圈結束
 * printDeck將放在a裡面的卡片都印出來
 * getAllCards回傳cards
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		for(int n=nDeck;n>0;n--){
			for(int suit=1;suit<=4;suit++){
				for(int rank=1;rank<=13;rank++){
					Card card=new Card(suit,rank);
					cards.add(card);
				}
			}
		}
	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		for(Card a : cards){
			a.printCard();
		}
		
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO: please add description here
 * class Card
 * 設private的suit跟rank變數(型態是int)
 * 設private的suitname跟rankname的String陣列，把花色跟數字都放入裡面
 * constructor為Card (s , r)
 * printCard印出卡片的花色與數字
 * getSuit回傳suit
 * getRank回傳rank
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	private String[] suitname={"Clubs","Diamonds","Hearts","Spades",};
	//定義suitname:梅花是1,方塊是2,紅心是3,黑桃是4
	private String[] rankname={"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
	//定義rankname代表牌的1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
		System.out.println(suitname[suit-1]+" "+rankname[rank-1]);//印出(花色,數字)
		
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
