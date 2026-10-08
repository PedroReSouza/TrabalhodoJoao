package Cliente;

public class Cliente {

    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public Cliente(String nome, String cpf, String telefone, String email) {
        setNome(nome);
        setCpf(cpf);
        setTelefone(telefone);
        setEmail(email);
    }

    // =========================
    // NOME
    // =========================

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "O nome nao pode ser vazio."
            );
        }

        this.nome = nome;
    }

    // =========================
    // CPF
    // =========================

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {

        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "O CPF nao pode ser vazio."
            );
        }

        this.cpf = cpf;
    }

    // =========================
    // TELEFONE
    // =========================

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {

        if (telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "O telefone nao pode ser vazio."
            );
        }

        this.telefone = telefone;
    }

    // =========================
    // EMAIL
    // =========================

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException(
                "Email invalido."
            );
        }

        this.email = email;
    }

    // =========================
    // EXIBIR DADOS
    // =========================

    public void exibirDados() {

        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Telefone: " + telefone);
        System.out.println("Email: " + email);
    }
}
```
