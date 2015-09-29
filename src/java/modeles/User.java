package modeles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author alpottie
 */

public class User 
{
    private String nom; 
    private String prenom; 
    private String mdp; 
    
    public User(String nom, String prenom, String mdp)
    {
        this.nom = nom; 
        this.prenom = prenom; 
        this.mdp = mdp; 
    }
    
   public String getNom()
   {
       return this.nom; 
   }
   
   public String getPrenom()
   {
       return this.prenom; 
   }
   
   public String getMdp()
   {
       return this.mdp; 
   }
   
   public void setNom(String nom)
   {
       this.nom = nom; 
   }
   
   public void setPrenom(String prenom)
   {
       this.prenom = prenom; 
   }
   
   public void setMdp(String mdp)
   {
       this.mdp = mdp; 
   }
   
   public boolean comparaison(String chemin)
   {
        Properties prop = new Properties();
        FileInputStream in;
        try 
        {
            // Ouverture et chargement du fichier .properties
            in = new FileInputStream(chemin);
            prop.load(in);
            in.close();
        } catch (FileNotFoundException e) 
        {
            System.out.println(e.toString());
        } catch (IOException e) 
        {
            System.out.println(e.toString());
        }
        
        String propnom = prop.getProperty("nom"); 
        String propprenom = prop.getProperty("prenom"); 
        String propmdp = prop.getProperty("mdp"); 
        
        if(this.nom.equals(propnom) && this.prenom.equals(propprenom) && this.mdp.equals(propmdp))
        {
            return true; 
        }
        else
            return false; 
   }
}
