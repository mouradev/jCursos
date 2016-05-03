
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        String nomeCurso, nomeAluno;
        int numVagas, matr;
        Curso c;
        
        System.out.print("Nome do curso: ");
        nomeCurso = t.nextLine();
        
        System.out.println("Número de vagas: ");
        numVagas = t.nextInt();
        
        c = new Curso(nomeCurso, numVagas);
        
        int opcao = 0;
        
        do {
            System.out.println("---------------Menu de opções----------------");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Remover");
            System.out.println("3 - Imprimir");
            System.out.println("4 - Sair");
            opcao = t.nextInt();
            
            System.out.println("---------------------------------------------");
            
            switch(opcao) {
                case 1:
                    if(c.temVaga()) {
                        System.out.print("Matricula: ");
                        matr = t.nextInt();

                        if(c.pertence(matr)) {
                            System.out.println("Esta mátricula ja existe");
                        }else {

                            //limpar o teclado
                            t.nextLine();

                            System.out.print("Nome do aluno: ");
                            nomeAluno = t.nextLine();

                            //cria o objeto aluno
                            Aluno a = new Aluno(matr, nomeAluno);

                            if(c.adicionar(a))
                                System.out.println("Aluno adicionado com sucesso!");
                            else
                                System.out.println("Erro ao adicionar aluno");
                        }
                    }else {
                        System.out.println("Não há mais vagas :(");
                    }
                    break;
                case 2:
                    System.out.print("Matricula: ");
                    matr = t.nextInt();
                    
                    if(c.remover(matr))
                        System.out.println("Aluno removido!");
                    else
                        System.out.println("Erro ao remover aluno :(");
                    
                    break;
                case 3:
                    c.imprimir();
                    break;
                case 4:
                    break;
                default:
                    opcao = 0;
                    break;
            }
            
        }while(opcao != 4);
       
    }
    
}
