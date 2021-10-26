package vitoriasc;

/**
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */
public class Repositorio {
    private static Repositorio repositorio;
    private Sociofilesandothers sociosfiles;
    private Gestorfilesandothers gestorfiles;
    private static final int precoquotas = 13;
    
    
    public static Repositorio getInstance(){
        if(repositorio == null){
            repositorio = new Repositorio();
        }
        return repositorio;
    }
    
    public Repositorio(){            
        sociosfiles = new Sociofilesandothers();
        gestorfiles = new Gestorfilesandothers();
    }

    public static Repositorio getRepositorio() {
        return repositorio;
    }

    public static void setRepositorio(Repositorio repositorio) {
        Repositorio.repositorio = repositorio;
    }

    public Sociofilesandothers getSociosfiles() {
        return sociosfiles;
    }

    public void setSociosfiles(Sociofilesandothers sociosfiles) {
        this.sociosfiles = sociosfiles;
    }

    public Gestorfilesandothers getGestorfiles() {
        return gestorfiles;
    }

    public void setGestorfiles(Gestorfilesandothers gestorfiles) {
        this.gestorfiles = gestorfiles;
    }

    public static int getPrecoquotas() {
        return precoquotas;
    }
   
}
