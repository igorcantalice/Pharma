package model;

/**
 *
 * @author icant
 */
public class ModelClientes {

    private long cliCPF;
    private String cliNome;
    private String cliEndereco;
    private String cliBairro;
    private String cliContato;

    // RETORNA VALOR DE CLICPF //
    public long getCliCPF() {
        return cliCPF;
    }

    // RETORNA VALOR DE CLINOME //
    public String getCliNome() {
        return cliNome;
    }

    // RETORNA VALOR DE CLIENDERECO //
    public String getCliEndereco() {
        return cliEndereco;
    }

    // RETORNA VALOR DE CLIBAIRRO //
    public String getCliBairro() {
        return cliBairro;
    }

    // RETORNA VALOR DE CLICONTATO //
    public String getCliContato() {
        return cliContato;
    }

    // SETA VALOR DE CLICPF //
    public void setCliCPF(long cliCPF) {
        this.cliCPF = cliCPF;
    }

    // SETA VALOR DE CLINOME //
    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }


    // SETA VALOR DE CLIENDERECO //
    public void setCliEndereco(String cliEndereco) {
        this.cliEndereco = cliEndereco;
    }

    // SETA VALOR DE CLIBAIRRO //
    public void setCliBairro(String cliBairro) {
        this.cliBairro = cliBairro;
    }

    // SETA VALOR DE CLICONTATO //
    public void setCliContato(String cliContato) {
        this.cliContato = cliContato;
    }

}
