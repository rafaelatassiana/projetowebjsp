package model;

public class Cliente {
    private Long id;
    private String nome;
    private String matricula;
    private String endereco;
    private Integer tipoPessoa;

    public Cliente(Long id, String nome, String matricula, String endereco, Integer tipoPessoa) {
        this.id = id;
        this.endereco = endereco;
        this.nome = nome;
        this.tipoPessoa = tipoPessoa;
        this.matricula = matricula;
    }

    public Cliente(String nome, String matricula, String endereco, Integer tipoPessoa) {
        this(null, nome, matricula, endereco, tipoPessoa);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(Integer tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}
