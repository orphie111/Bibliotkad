package Vehicules;

public class Livre {

    private String type;
    private String titre;
    public Livre(String type, String titre){

      this.type = type;
      this.titre = titre;
    }

    public void setMark(String mark) {
        this.titre = titre;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitre() {
        return titre;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Vehicule:" +
                "type='" + type + '\'' +
                ", mark='" + titre + '\'';
    }
}
