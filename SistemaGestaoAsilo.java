import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Residente {
    private int id;
    private String nome;
    private int idade;
    private String historicoMedico;

    public Residente(int id, String nome, int idade, String historicoMedico) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.historicoMedico = historicoMedico;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getHistoricoMedico() {
        return historicoMedico;
    }

    @Override
    public String toString() {
        return "Residente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", historicoMedico='" + historicoMedico + '\'' +
                '}';
    }
}

// Classe para gerenciar os residentes
class GestaoAsilo {
    private List<Residente> residentes;
    private int nextId;

    public GestaoAsilo() {
        this.residentes = new ArrayList<>();
        this.nextId = 1; // Inicializa IDs sequenciais
    }

    // Adiciona um novo residente
    public Residente adicionarResidente(String nome, int idade, String historicoMedico) {
        Residente novoResidente = new Residente(nextId++, nome, idade, historicoMedico);
        residentes.add(novoResidente);
        return novoResidente;
    }

    // Busca um residente pelo ID
    public Optional<Residente> buscarResidentePorId(int id) {
        return residentes.stream().filter(r -> r.getId() == id).findFirst();
    }

    // Lista todos os residentes
    public List<Residente> listarResidentes() {
        return new ArrayList<>(residentes);
    }
}

// Classe principal para demonstrar o funcionamento do sistema
public class SistemaGestaoAsilo {

    public static void main(String[] args) {
        GestaoAsilo gestao = new GestaoAsilo();

        // Adicionando alguns residentes
        System.out.println("Adicionando residentes...");
        gestao.adicionarResidente("João Silva", 85, "Hipertensão");
        gestao.adicionarResidente("Maria Souza", 78, "Diabetes");
        gestao.adicionarResidente("Antônio Pereira", 90, "Histórico de AVC");

        // Listando todos os residentes
        System.out.println("\nLista de residentes:");
        gestao.listarResidentes().forEach(System.out::println);

        // Buscando um residente por ID
        System.out.println("\nBuscando residente com ID 2...");
        gestao.buscarResidentePorId(2).ifPresentOrElse(
                residente -> System.out.println("Residente encontrado: " + residente),
                () -> System.out.println("Residente não encontrado.")
        );

    }
}
