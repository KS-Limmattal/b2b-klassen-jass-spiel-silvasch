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
        for (int i = 0; i < 30; i++) {
            deck.pop();
        }
        deck.addCard(new Card(Suit.EICHELN, Rank.ASS));
        for (Card card: deck.getCards()) {
            System.out.println(card);
        }
    }
}
