import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.StringJoiner;

/**
 * Diese Klasse repräsentiert einen Kartenstapel mit einer variablen Anzahl
 * Karten
 * Sie soll ein Array von Typ Card als Instanzvariable haben,
 * - einen Konstruktor Deck(Card[] cards), welches eine Instanz bestehend aus
 * den gegebenen Karten kreiert,
 * - einen Konstruktor Deck(), welcher ein vollständiges Kartenset (4x9 Karten)
 * erzeugt,
 * - einen (trivialen) Getter getCards()
 * - eine Methode addCard(Card card), welche zum Deck eine Karte hinzufügt,
 * falls diese noch nicht im Deck enthalten ist und andernfalls eine Warnung auf
 * der Konsole ausgibt
 * - eine Methode pop(), welche die letzte Karte im Array aus dem Deck entfernt,
 * sofern Karten vorhanden sind
 * - eine Methode shuffle(), welche die Karten im Array durchmischt
 *
 * Tipps:
 * - Um ein Array zu redimensionieren, verwende den Befehl "Arrays.copyOf" aus
 * java.util.Arrays
 * - Um eine zufällige Ganzzahl in einem gegebenen Bereich zu erzeugen, verwende
 * "rnd.nextInt", wobei "rnd" eine Instanz der Klasse "Random" aus
 * "java.util.Random" bezeichnet
 *
 */
public class Deck {

	private Card[] cards;

	public static Suit trumpSuit;

	public Deck(Card[] cards) {
		this.cards = cards;
	}

	public Deck() {
		Card[] cards = new Card[36];

		int index = 0;
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards[index] = new Card(suit, rank);
				index++;
			}
		}

		this.cards = cards;
	}

	public int[] validCards(Deck played) {
		Card[] playedCards = played.getCards();
		if (playedCards.length > 3) {
			System.out.println("something went horribly wrong.");
			return new int[0];
		}

		if (playedCards.length == 0) {
			int[] validIndices = new int[this.cards.length];
			for (int i = 0; i < this.cards.length; i++) {
				validIndices[i] = i;
			}
			return validIndices;
		}

		Suit initialSuit = playedCards[0].suit;

		int[] validIndices = new int[0];

		for (int i = 0; i < this.cards.length; i++) {
			Card card = this.cards[i];
			if (card.suit == initialSuit || card.suit == trumpSuit) {
				validIndices = Arrays.copyOf(
					validIndices,
					validIndices.length + 1
				);
				validIndices[validIndices.length - 1] = i;
			}
		}

		if (validIndices.length == 0) {
			for (int i = 0; i < this.cards.length; i++) {
				validIndices[i] = i;
			}
		}

		return validIndices;
	}

	public void shuffle() {
		Collections.shuffle(Arrays.asList(this.cards));
	}

	public void addCard(Card newCard) {
		for (Card card : this.cards) {
			if (card.equals(newCard)) {
				return;
			}
		}

		this.cards = Arrays.copyOf(this.cards, this.cards.length + 1);
		this.cards[this.cards.length - 1] = newCard;
	}

	public Card pop() {
		Card last = this.cards[this.cards.length - 1];
		this.cards = Arrays.copyOf(this.cards, this.cards.length - 1);
		return last;
	}

	public Card removeAt(int indexToRemove) {
		Card[] newCards = new Card[this.cards.length - 1];

		boolean hadSkip = false;
		for (int i = 0; i < this.cards.length; i++) {
			if (i == indexToRemove) {
				hadSkip = true;
				continue;
			}
			int index = i;
			if (hadSkip) {
				index--;
			}
			newCards[index] = this.cards[i];
		}

		Card card = this.cards[indexToRemove];
		this.cards = newCards;
		return card;
	}

	public boolean equals(Deck other) {
		if (this.cards.length != other.cards.length) {
			return false;
		}

		for (int i = 0; i < this.cards.length; i++) {
			if (!(this.cards[i].equals(other.cards[i]))) {
				return false;
			}
		}

		return true;
	}

	public Card[] getCards() {
		return this.cards;
	}

	public String toString() {
		StringJoiner stringJoiner = new StringJoiner(", ");
		for (Card card : this.cards) {
			stringJoiner.add(card.toString());
		}
		return stringJoiner.toString();
	}
}
