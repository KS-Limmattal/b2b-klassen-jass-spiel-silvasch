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
            Deck playedCards = new Deck(new Card[]{});
            playedCards.addCard(hand1.validCards(playedCards).pop());
            playedCards.addCard(hand2.validCards(playedCards).pop());
            playedCards.addCard(hand3.validCards(playedCards).pop());
            playedCards.addCard(hand4.validCards(playedCards).pop());

            System.out.println(playedCards);

            System.out.println(hand1);
            System.out.println(hand2);
            System.out.println(hand3);
            System.out.println(hand4);
        }
    }
}
