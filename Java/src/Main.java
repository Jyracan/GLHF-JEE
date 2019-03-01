import java.sql.*;

public class Main {
    public static void main(String[] args){
        /* Connexion à la base de données */
        String database = "testJEE";
        String hostName = "localhost";
        String port = "3306";
        String user = "root";
        String pswd = "root";
        Connection connexion = null;
        String url = "jdbc:mysql://"+hostName+":"+port+"/"+database;
        try {
            connexion = DriverManager.getConnection( url, user, pswd );
            System.out.println("Connexion établie avec la base de donnée avec succés");

        } catch ( SQLException e ) {
            //TODO : faire des messages plus personnalisé en fonction de l'erreur
            System.err.println("Impossible d'ouvrir une connection à la base de données !");
            System.err.println(e);
        } finally {
            if ( connexion != null )
                try {
                    connexion.close();
                    System.out.println("Fermeture de la connexion à la base de données avec succés");
                } catch ( SQLException ignore ) {
                    //TODO : faire des messages plus personnalisé en fonction de l'erreur
                    System.err.println("Impossible de fermer la connexion la base de données !");
                }
        }
    }
}
