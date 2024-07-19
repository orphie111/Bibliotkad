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
	public void getData(){

        String fileName = "stock.txt"; // Nom du fichier à lire
        Map<Integer,Vehicule> dt = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {

                String[] tab = line.split(",");
                Vehicule v = null;
                if(tab[1].equals("voiture")) v = new Romqn(tab[2]);
                else if(tab[1].equals("moto")) v = new Fable(tab[2]);
                else if(tab[1].equals("camion")) v = new BD(tab[2]);
                dt.put(Integer.parseInt(tab[0]),v);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier: " + e.getMessage());
        }

        this.stock = dt;
    }
    public void saveData(){
        Map<Integer,Vehicule> dt = this.stock;
        try{

            FileWriter f = new FileWriter("stock.txt",true);
            for(Map.Entry<Integer,Vehicule> v:dt.entrySet()){

                String chaine = v.getKey().toString()+""+v.getValue().toCSVType();
                f.write(chaine);
            }
            f.close();

        }catch (IOException e){

            System.out.println("Impossible D'ecrire dans le fichier :"+e.getMessage());
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
