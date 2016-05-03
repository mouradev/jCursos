
public class Curso {
    private String nome;
    private Aluno[] alunos;
    private int qtdAlunosMatriculados;
    
    public Curso(String nome, int qtdAlunos) {
        this.nome = nome;
        alunos = new Aluno[qtdAlunos];
        this.qtdAlunosMatriculados = 0;
    }
    
    public boolean adicionar(Aluno a) {
        if(alunos.length >= qtdAlunosMatriculados && !pertence(a.getMatricula())){
            
            alunos[qtdAlunosMatriculados] = a;
            this.qtdAlunosMatriculados++;
            
            return true;
        }//endif
        
        return false;
    }
    
    public boolean pertence(int matricula) {
        boolean posicao = posicao(matricula) >= 0;
        
        return posicao;
    }
    
    public void imprimir() {
        System.out.println("--------------------------------------------");
        System.out.printf("Curso:            %s\n", nome);
        System.out.printf("Número de alunos: %d\n", qtdAlunosMatriculados);
        System.out.println("--------------------------------------------");
        
        if(qtdAlunosMatriculados == 0)
            System.out.println("não há alunos");
        else {
            System.out.println("Mátricula    Nome");
            //                  99999999-----nome
            
            for(int i = 0; i < qtdAlunosMatriculados; i++)
                System.out.printf("%9d   %s\n",
                   alunos[i].getMatricula(), alunos[i].getNome());
                    
        }
    }
    
    public boolean remover(int matricula) {
        int posicao = posicao(matricula);
        
        if(posicao >= 0 ) {
            alunos[posicao] = alunos[qtdAlunosMatriculados - 1];
            alunos[qtdAlunosMatriculados -1] = null;
            qtdAlunosMatriculados--;
        }
        
        return false;
    }
    
    public boolean temVaga() {
        if(alunos.length > qtdAlunosMatriculados)
            return true;
        return false;
    }
    
    private int posicao(int matricula) {
        for(int i = 0; i < qtdAlunosMatriculados; i++) {
            if(alunos[i].getMatricula() == matricula)
                return i;
        }
        return -1;
    }
    
}
