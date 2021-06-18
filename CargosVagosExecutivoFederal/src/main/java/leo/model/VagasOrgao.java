package leo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class VagasOrgao implements Serializable {

    @Id
    private String _id;
    private String NOME_MES;
    private int ORGAO;
    private String NOME_ORGAO;
    private String SIGLA_ORGAO;
    private int APROVADA;
    private int DISTRIBUIDA;
    private int OCUPADA;
    private int VAGAS;

    public VagasOrgao() {
    }

    public VagasOrgao(String _id, String NOME_MES, int ORGAO, String NOME_ORGAO, String SIGLA_ORGAO, int APROVADA, int DISTRIBUIDA, int OCUPADA) {
        this._id = _id;
        this.NOME_MES = NOME_MES;
        this.ORGAO = ORGAO;
        this.NOME_ORGAO = NOME_ORGAO;
        this.SIGLA_ORGAO = SIGLA_ORGAO;
        this.APROVADA = APROVADA;
        this.DISTRIBUIDA = DISTRIBUIDA;
        this.OCUPADA = OCUPADA;
        this.VAGAS = APROVADA - OCUPADA;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNOME_MES() {
        return NOME_MES;
    }

    public void setNOME_MES(String NOME_MES) {
        this.NOME_MES = NOME_MES;
    }

    public int getORGAO() {
        return ORGAO;
    }

    public void setORGAO(int ORGAO) {
        this.ORGAO = ORGAO;
    }

    public String getNOME_ORGAO() {
        return NOME_ORGAO;
    }

    public void setNOME_ORGAO(String NOME_ORGAO) {
        this.NOME_ORGAO = NOME_ORGAO;
    }

    public String getSIGLA_ORGAO() {
        return SIGLA_ORGAO;
    }

    public void setSIGLA_ORGAO(String SIGLA_ORGAO) {
        this.SIGLA_ORGAO = SIGLA_ORGAO;
    }

    public int getAPROVADA() {
        return APROVADA;
    }

    public void setAPROVADA(int APROVADA) {
        this.APROVADA = APROVADA;
    }

    public int getDISTRIBUIDA() {
        return DISTRIBUIDA;
    }

    public void setDISTRIBUIDA(int DISTRIBUIDA) {
        this.DISTRIBUIDA = DISTRIBUIDA;
    }

    public int getOCUPADA() {
        return OCUPADA;
    }

    public void setOCUPADA(int OCUPADA) {
        this.OCUPADA = OCUPADA;
    }

    public int getVAGAS() {
        return VAGAS;
    }

    public void setVAGAS(int VAGAS) {
        this.VAGAS = VAGAS;
    }
}
