import java.util.Objects;

public class Banco {

    private String numeroAgencia;
    private String nomeAgencia;
    // protected List<Cliente> clientes = new ArrayList<Cliente>();

    public Banco() {
    }

    public Banco(String numeroAgencia, String nomeAgencia) {
        this.numeroAgencia = numeroAgencia;
        this.nomeAgencia = nomeAgencia;
    }

    public String getNumeroAgencia() {
        return this.numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public String getNomeAgencia() {
        return this.nomeAgencia;
    }

    public void setNomeAgencia(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
    }

    public Banco numeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
        return this;
    }

    public Banco nomeAgencia(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Banco)) {
            return false;
        }
        Banco banco = (Banco) o;
        return Objects.equals(numeroAgencia, banco.numeroAgencia) && Objects.equals(nomeAgencia, banco.nomeAgencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroAgencia, nomeAgencia);
    }

    @Override
    public String toString() {
        return "{" + " numeroAgencia='" + getNumeroAgencia() + "'" + ", nomeAgencia='" + getNomeAgencia() + "'" + "}";
    }

}