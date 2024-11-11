import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
    private ArrayList<Card> cards;

    public Deck(Card[] cards) {
        this.cards = new ArrayList<Card>(Arrays.asList(cards));
    }

    public Deck() {
        ArrayList<Card> cards = new ArrayList<Card>();
    
        for (Suit suit: Suit.values()) {
            for (Rank rank: Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }

        this.cards = cards;
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public void addCard(Card card) {
        if (this.cards.contains(card)) {
            System.out.println("deck already contains this card.");
            return;
        }

        this.cards.add(card);
    }

    public void pop() {
        this.cards.removeLast();
    }

    public Card[] getCards() {
        return this.cards.toArray(new Card[this.cards.size()]);
    }
}
