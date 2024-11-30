/**
 * Aufzählung der möglichen Farben einer Karte (ist vorgegeben)
 */
public enum Suit {
    SCHELLEN, SCHILTEN, ROSEN, EICHELN;

    public String toString() {
        switch (this) {
            case SCHELLEN:
                return "Schellen";
            case SCHILTEN:
                return "Schilten"; 
            case ROSEN:
                return "Rosen";
            case EICHELN:
                return "Eicheln";
            default:
                return "unreachable";
        }
    }
}
