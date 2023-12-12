package com.example.work.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "tmuestra")
public class Muestra {

    @Id
    @SequenceGenerator(name = "tmuestra_sequence", sequenceName = "tmuestra_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tmuestra_sequence")
    private Integer id;

    @Column(name = "NIF_Paciente")
    private String nifPaciente;

    private String cultivo;

    @ManyToOne
    @JoinColumn(name = "Solucion", referencedColumnName = "ID")
    private Solucion solucion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNifPaciente() {
        return nifPaciente;
    }

    public void setNifPaciente(String nifPaciente) {
        this.nifPaciente = nifPaciente;
    }

    public String getCultivo() {
        return cultivo;
    }

    public void setCultivo(String cultivo) {
        this.cultivo = cultivo;
    }

    public Solucion getSolucion() {
        return solucion;
    }

    public void setSolucion(Solucion solucion) {
        this.solucion = solucion;
    }
}

