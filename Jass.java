import java.util.Arrays;

/**
 * Diese Klasse ist die Hauptklasse und enthält die main-Methode
 * In der main-Methode soll eine neues (vollstänidges) Deck erzeugt
 * und gemischt werden. Dann sollen von diesem Deck 30 Karten entfernt
 * werden und anschliessend das EICHELN ASS hinzugefügt werden
 * Danach sollen alle Karten auf der Konsole ausgegeben werden.
 */
public class Jass {

	public static void main(String[] args) {
		Deck deck = new Deck();
		Deck.trumpSuit = Suit.EICHELN;
		deck.shuffle();
		Deck hand1 = new Deck(new Card[0]);
		Deck hand2 = new Deck(new Card[0]);
		Deck hand3 = new Deck(new Card[0]);
		Deck hand4 = new Deck(new Card[0]);

		for (int i = 0; i < 9; i++) {
			hand1.addCard(deck.pop());
		}

		for (int i = 0; i < 9; i++) {
			hand2.addCard(deck.pop());
		}

		for (int i = 0; i < 9; i++) {
			hand3.addCard(deck.pop());
		}

		for (int i = 0; i < 9; i++) {
			hand4.addCard(deck.pop());
		}

		while (true) {
			System.out.println("Hand 1: " + hand1);
			System.out.println("Hand 1: " + hand2);
			System.out.println("Hand 1: " + hand3);
			System.out.println("Hand 1: " + hand4);

			Deck playedCards = new Deck(new Card[] {});

			playedCards.addCard(playCard(hand1, playedCards));
			playedCards.addCard(playCard(hand2, playedCards));
			playedCards.addCard(playCard(hand3, playedCards));
			playedCards.addCard(playCard(hand4, playedCards));

			System.out.println("Played cards: " + playedCards);
			System.out.println();

			break;
		}
	}

	private static Card playCard(Deck cards, Deck playedCards) {
		int[] validCardIndices = cards.validCards(playedCards);
		System.out.println(Arrays.toString(validCardIndices));
		if (validCardIndices.length == 0) {
			return null;
		}
		int index = validCardIndices[0];
		Card card = cards.removeAt(index);
		return card;
	}
}
