package Ex02;

import java.util.ArrayList;

public class Pessoa {
	int codigo;
    String nome;
    ArrayList<Automovel> automoveis = new ArrayList<>();

    public Pessoa() {
    }

    public Pessoa(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public void inserirAutomovel(Automovel automovel) {
        this.automoveis.add(automovel);
    }

    public void removerAutomovel(int index) {
        this.automoveis.remove(index);
    }

    public String imprimirPessoa() {
        return "Código: " + this.codigo + "\nNome: " + this.nome;
    }

    public String imprimirCompleto() {
        StringBuilder sb = new StringBuilder();
        sb.append("Código: ").append(codigo).append("\n");
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Automóveis: \n");
        for (Automovel automovel : automoveis) {
            sb.append(automovel.imprimir()).append("\n");
        }
        return sb.toString();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Automovel> getAutomoveis() {
        return automoveis;
    }

    public void setAutomoveis(ArrayList<Automovel> automoveis) {
        this.automoveis = automoveis;
    }


}