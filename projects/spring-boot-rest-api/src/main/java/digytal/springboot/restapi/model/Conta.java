package digytal.springboot.restapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_conta")
public class Conta {
    @Id
    private Long numero;
    private Double saldo;
    @Column(name = "id_correntista")
    private Integer idCorrentista;

    public Integer getIdCorrentista() {
        return idCorrentista;
    }
    public void setIdCorrentista(Integer idCorrentista) {
        this.idCorrentista = idCorrentista;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

}
