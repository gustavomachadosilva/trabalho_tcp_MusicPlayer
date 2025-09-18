package Controller;

public class MusicalContext {

    private int nota;
    private int instrumento;
    private int volume;
    private int maxVolume;
    private int oitava;

    public MusicalContext(int nota, int instrumento, int volume, int maxVolume, int oitava) {
        this.nota = nota;
        this.instrumento = instrumento;
        this.volume = volume;
        this.maxVolume = maxVolume;
        this.oitava = oitava;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(int instrumento) {
        this.instrumento = instrumento;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(int maxVolume) {
        this.maxVolume = maxVolume;
    }

    public int getOitava() {
        return oitava;
    }

    public void setOitava(int oitava) {
        this.oitava = oitava;
    }
}
