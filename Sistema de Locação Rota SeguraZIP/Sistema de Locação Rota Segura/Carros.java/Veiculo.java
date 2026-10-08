package Carros.java;

public abstract class Veiculo {

    private String placa;
    private String modelo;
    private int ano;
    private boolean disponivel;

    public Veiculo(String placa, String modelo, int ano) {
        setPlaca(placa);
        setModelo(modelo);
        setAno(ano);
        this.disponivel = true;
    }

    // Getter e Setter da placa
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "A placa nao pode ser vazia."
            );
        }

        this.placa = placa;
    }

    // Getter e Setter do modelo
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "O modelo nao pode ser vazio."
            );
        }

        this.modelo = modelo;
    }

    // Getter e Setter do ano
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (ano < 1900) {
            throw new IllegalArgumentException(
                "Ano do veiculo invalido."
            );
        }

        this.ano = ano;
    }

    // Getter e Setter da disponibilidade
    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    // Métodos abstratos
    public abstract double calcularDiaria();

    public abstract double calcularSeguro();

    public abstract double calcularManutencao();

    // Exibição dos dados
    public void exibirDados() {
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println(
            "Disponivel: " + (disponivel ? "Sim" : "Nao")
        );
    }
}