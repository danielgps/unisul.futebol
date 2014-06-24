package br.unisul.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.unisul.entity.enun.HorarioReserva;

@Entity
@Table(name = "reserva")
public class Reserva implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "id_campo")
    private Campo campo;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_reserva")
    private Calendar dataReserva;

    @Enumerated(EnumType.STRING)
    @Column(name = "hora_reserva")
    private HorarioReserva horaReserva;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_cadastro")
    private Calendar dataCadastro;

    private Boolean aprovado;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Usuario getUsuario() {

        return usuario;
    }

    public void setUsuario(Usuario usuario) {

        this.usuario = usuario;
    }

    public Campo getCampo() {

        return campo;
    }

    public void setCampo(Campo campo) {

        this.campo = campo;
    }

    public Calendar getDataReserva() {

        return dataReserva;
    }

    public void setDataReserva(Calendar dataReserva) {

        this.dataReserva = dataReserva;
    }

    public HorarioReserva getHoraReserva() {

        return horaReserva;
    }

    public void setHoraReserva(HorarioReserva horaReserva) {

        this.horaReserva = horaReserva;
    }

    public Calendar getDataCadastro() {

        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {

        this.dataCadastro = dataCadastro;
    }

    public Boolean getAprovado() {

        return aprovado;
    }

    public void setAprovado(Boolean aprovado) {

        this.aprovado = aprovado;
    }
}
