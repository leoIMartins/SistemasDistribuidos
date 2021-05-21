package leo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class Fornecedor implements Serializable {

    @Id
    private int _id;
    private String nome;
    private String telefone;
    private String cnpj;

    public Fornecedor() {
    }

    public Fornecedor(int _id, String nome, String telefone, String cnpj) {
        this._id = _id;
        this.nome = nome;
        this.telefone = telefone;
        this.cnpj = cnpj;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
