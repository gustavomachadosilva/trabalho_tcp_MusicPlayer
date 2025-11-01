package model.instruments;

public enum Instruments {

    PIANO_ACUSTICO(0, "Piano Acústico"),
    PIANO_ELETRICO(4, "Piano Elétrico"),
    VIOLAO(24, "Violão"),
    GUITARRA(26, "Guitarra Elétrica"),
    BAIXO(32, "Baixo Elétrico"),
    HARPA(46, "Harpa"),
    VIOLINO(40, "Violino"),
    VIOLONCELO(42, "Violoncelo"),
    SAX(65, "Saxofone"),
    TROMPETE(56, "Trompete"),
    FLAUTA(73, "Flauta"),
    ORGAO(19, "Órgão"),
    SINTETIZADOR(80, "Sintetizador");

    private final int midiCode;
    private final String name;

    Instruments(int midiCode, String name) {
        this.midiCode = midiCode;
        this.name = name;
    }

    public int getMidiCode() {
        return midiCode;
    }

    public String getName() {
        return name;
    }
}
