/**
 * Aufzählung der möglichen Ränge einer Karte (ist vorgegeben)
 */
public enum Rank {
    SECHS, SIEBEN, ACHT, NEUN, BANNER, UNDER, OBER, KOENIG, ASS;

    public String toString() {
        switch (this) {
            case SECHS:
                return "6";
            case SIEBEN:
                return "7";
            case ACHT:
                return "8";
            case NEUN:
                return "9";
            case BANNER:
                return "Banner";
            case UNDER:
                return "Under";
            case OBER:
                return "Ober";
            case KOENIG:
                return "König";
            case ASS:
                return "Ass";
            default:
                return "unreachable";
        }
    }
}
