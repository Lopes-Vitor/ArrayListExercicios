package Ex01;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex01Main {

	public static void main(String[] args) {
		int opcao = 0;
        Scanner tec = new Scanner(System.in);
        ArrayList<Curso> cursos = new ArrayList<>();

        while (opcao != 6) {
            System.out.println("Escolha um número");
            System.out.println("1 – Criar Curso");
            System.out.println("2 - Criar Aluno");
            System.out.println("3 – Remover Aluno");
            System.out.println("4 – Mostrar Todos os Cursos");
            System.out.println("5 – Mostrar alunos do curso");
            System.out.println("6 – Sair");
            opcao = Integer.parseInt(tec.nextLine());
            
            switch (opcao) {
                case 1 -> {
                    Curso c = new Curso();
                    System.out.println("Digite o código do curso");
                    c.setCodigo(Integer.parseInt(tec.nextLine()));
                    System.out.println("Digite o nome do curso");
                    c.setNome(tec.nextLine());
                    System.out.println("Digite a carga horária");
                    c.setCargaHoraria(Integer.parseInt(tec.nextLine()));
                    cursos.add(c);
                }
                case 2 -> {
                    Aluno a = new Aluno();
                    System.out.println("Digite o RA");
                    a.setRa(tec.nextLine());
                    System.out.println("Digite o nome");
                    a.setNome(tec.nextLine());
                    System.out.println("Selecione o curso");
                    for (int i = 0; i < cursos.size(); i++) {
                        int x = i + 1;
                        System.out.println(x +" - " + cursos.get(i).getNome());
                    }
                    int opcaoDeCurso = Integer.parseInt(tec.nextLine());
                    cursos.get(opcaoDeCurso - 1).setAlunos(a);
                }
                case 3 -> {
                    System.out.println("Digite o nome do aluno a ser removido");
                    String nomeAlunoRemover = tec.nextLine();
                    for (Curso curso : cursos) {
                        for (int i = 0; i < curso.getAlunos().size(); i++) {
                            if (nomeAlunoRemover.
                                    equals(curso.getAlunos().get(i).getNome())) {
                                curso.removerAluno(i);
                            }
                        }
                    }
                }
                case 4 -> {
                    for (Curso curso : cursos) {
                        System.out.println(curso.imprimir());
                    }
                }
                case 5 -> {
                    for (Curso curso : cursos) {
                        System.out.println(curso.imprimirCompleto());
                    }
                }
                case 6 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
            
        }
    }
}