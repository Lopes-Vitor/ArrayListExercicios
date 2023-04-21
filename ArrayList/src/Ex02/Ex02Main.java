package Ex02;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        int opcao = 0;
        while (opcao != 6) {
            System.out.println("\nMenu:");
            System.out.println("1 – Criar Pessoa");
            System.out.println("2 – Criar Automóvel");
            System.out.println("3 – Transferir Automóvel");
            System.out.println("4 – Mostrar Todas as Pessoas");
            System.out.println("5 – Mostrar automóvel da pessoa");
            System.out.println("6 – Sair");

            System.out.print("\nEscolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                	Pessoa pessoa = new Pessoa();
                    System.out.print("Digite o código da pessoa: ");
                    pessoa.setCodigo(scanner.nextInt());
                    System.out.print("Digite o nome da pessoa: ");
                    pessoa.setNome(scanner.next());
                    pessoas.add(pessoa);
                }
                case 2 -> {
                	Automovel automovel = new Automovel();
                    System.out.print("Digite a marca do automóvel: ");
                    automovel.setMarca(scanner.next());
                    System.out.print("Digite o modelo do automóvel: ");
                    automovel.setModelo(scanner.next());
                    System.out.println("Selecione a pessoa para associar o automóvel:");
                    for (int i = 0; i < pessoas.size(); i++) {
                        System.out.println((i + 1) + " - " + pessoas.get(i).getNome());
                    }
                    int indexPessoa = scanner.nextInt();
                    pessoas.get(indexPessoa-1).inserirAutomovel(automovel);

                    System.out.println("Automóvel associado à pessoa com sucesso!");
                }

                case 3 -> {
                    System.out.println("Selecione a pessoa de origem:");
                    for (int i = 0; i < pessoas.size(); i++) {
                        System.out.println((i + 1) + " - " + pessoas.get(i).getNome());
                    }
                    int indexPessoaOrigem = scanner.nextInt() - 1;

                    Pessoa pessoaOrigem = pessoas.get(indexPessoaOrigem);

                    System.out.println("Selecione o automóvel a ser transferido:");
                    ArrayList<Automovel> automoveisOrigem = pessoaOrigem.getAutomoveis();
                    for (int i = 0; i < automoveisOrigem.size(); i++) {
                        System.out.println((i + 1) + " - " + automoveisOrigem.get(i).imprimir());
                    }
                    int indexAutomovel = scanner.nextInt() - 1;

                    Automovel automovelTransferido = automoveisOrigem.get(indexAutomovel);

                    System.out.println("Selecione a pessoa de destino:");
                    for (int i = 0; i < pessoas.size(); i++) {
                        if (i != indexPessoaOrigem) {
                            System.out.println((i + 1) + " - " + pessoas.get(i).getNome());
                        }
                    }
                    int indexPessoaDestino = scanner.nextInt() - 1;

                    Pessoa pessoaDestino = pessoas.get(indexPessoaDestino);
                    pessoaOrigem.removerAutomovel(indexAutomovel);
                    pessoaDestino.inserirAutomovel(automovelTransferido);

                    System.out.println("Automóvel transferido com sucesso!");
                }

                case 4 -> {
                    for (Pessoa p : pessoas) {
                        System.out.println(p.imprimirCompleto());
                    }
                }

                case 5 -> {
                    System.out.println("Selecione a pessoa:");
                    for (int i = 0; i < pessoas.size(); i++) {
                        System.out.println((i + 1) + " - " + pessoas.get(i).getNome());
                    }
                    int indexPessoaAutomoveis = scanner.nextInt() - 1;

                    Pessoa pessoaAutomoveis = pessoas.get(indexPessoaAutomoveis);

                    ArrayList<Automovel> automoveis = pessoaAutomoveis.getAutomoveis();
                    System.out.println("Automóveis da pessoa:");
                    for (int i = 0; i < automoveis.size(); i++) {
                        System.out.println((i + 1) + " - " + automoveis.get(i).imprimir());
                    }
                }

                case 6 -> System.out.println("Saindo...");

                default -> System.out.println("Opção inválida.");

            }
        }
    }
}