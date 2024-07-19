import Vehicules.Livre;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Bibliotheque {

    private Map<Integer, Livre> stock = new HashMap<>();
    private int key = 0;

    public void nvivre(Livre l){

        this.stock.put(this.key,l);
        this.key = this.key+1;
    }
    public void rmLivre(int ID){

        boolean exist = this.stock.containsKey(ID);
        if(exist == true){

            this.stock.remove(ID);
        }
    }

    public void modifLivre(int ID,String mark,String type){

        boolean exist = this.stock.containsKey(ID);
        if(exist){

            this.stock.get(ID).setMark(mark);
            this.stock.get(ID).setType(type);
        }
    }

    public void printl(){


        for(Map.Entry<Integer, Livre> v:this.stock.entrySet()){

            System.out.println(v.getKey().toString()+",ID"+v.getValue());
        }


    }

    public void lookLivre(String titre){

        boolean trouver = false;
        for(Map.Entry<Integer, Livre> v:this.stock.entrySet()){

            if(v.getValue().getTitre().equals(titre)){

                System.out.println(v.getValue().toString());
                trouver = true;
                break;
            }
        }
        if(trouver == false){

            System.out.println("Aucun livre ne correspond a votre Recherche");
        }
    }

    public  void lookLivreL(char l){

        for(Map.Entry<Integer, Livre> v:this.stock.entrySet()){

            if(v.getValue().getTitre().charAt(0) == l){

                System.out.println(v.getValue().toString());
            }
        }
    }
    public void nbrLire(){

        System.out.println("Il y'a "+this.key+" livre(l) en stock");
    }
    public void nbrLivreType(String titre){

        int nombre = 0;
        for(Map.Entry<Integer, Livre> v:this.stock.entrySet()){

            if(v.getValue().getType().equals(titre)){
                nombre = nombre+1;
            }
        }
        System.out.println("il y'a "+nombre+" livre(l) de titre "+titre);
    }
    public void listeLivreType(String l){

        System.out.println(l.toUpperCase(Locale.ROOT));
        for(Map.Entry<Integer, Livre> v:this.stock.entrySet()){

            if(v.getValue().gettitre().equals(l)){

                System.out.println(v.getValue().toString());
            }
        }
    }
}
