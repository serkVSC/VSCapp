package vitoriasc;

/**
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */
public class Tipos{
    public enum Categoria {
        AFONSINHO,      // -10 % de desconto - 1º Categoria
        CONQUISTADOR,   // -15 % de desconto - 2º Categoria
        HONORARIO;      // -25 % de desconto - 3º Categoria

        public static Categoria getAFONSINHO() {
            return AFONSINHO;
        }

        public static Categoria getCONQUISTADOR() {
            return CONQUISTADOR;
        }

        public static Categoria getHONORARIO() {
            return HONORARIO;
        }

    }
    
    public enum Estado{
        RESERVADO,
        APROVADO,
        REPROVADO
    }
}