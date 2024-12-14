package src.com.imdcorp.app.dao;

import src.com.imdcorp.app.model.Pessoa.Pessoa;

import java.io.*;
import java.util.ArrayList;

public class BancoDAO {
    private ArrayList<Pessoa> funcionario;
    public static BancoDAO banco;
    private static final String FILE_PATH = "src/com/imdcorp/resources/database.bin";

    private BancoDAO() {
        funcionario = new ArrayList<>();
    }

    public static BancoDAO getInstance() {
        if (banco == null) {
            banco = new BancoDAO();
            banco.carregarDados();
        }
        return banco;
    }

    public ArrayList<Pessoa> getArrayPessoas() {
        return this.funcionario;
    }

    private void carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            funcionario = (ArrayList<Pessoa>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Classe não encontrada." + e.getMessage());
            e.printStackTrace();
        }
    }

    public void salvarDados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(funcionario);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}