/**
 * Diese Klasse repräsentiert eine Karte (Bsp. EICHELN ASS)
 * Sie soll Instanzvariablen von Typ "Suit" und "Rank" haben,
 * einen Konstruktor, eine Methode "toString()" zur Representation
 * als Zeichenkette, sowie eine "equals(Card other)" Methode, welche
 * zurückgibt, ob die aktuelle Karte gleichen Suit und Rank wie die
 * andere Karte hat.
 */
public class Card {

	Suit suit;
	Rank rank;

	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public String toString() {
		return String.format("%s %s", this.suit, this.rank);
	}

	public boolean equals(Card other) {
		return (this.suit == other.suit) && (this.rank == other.rank);
	}
}
