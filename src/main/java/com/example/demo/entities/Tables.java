package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;





@Entity
@Table(name = "tables")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Tables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "monto", nullable = false, length = 50)
    private float monto;
    @Column(name = "Saldo", nullable = false, length = 50)
    private float Saldo;
    @Column (name = "TEM", nullable = false, length = 50)
    private float TEM;
    @Column(name = "Portes", nullable = false, length = 20)
    private float Portes;
    @Column (name = "Gps", nullable = false, length = 50)
    private float Gps;
    @Column (name = "pSegDesPer", nullable = false, length = 50)
    private float pSegDesPer;
    @Column (name = "CF", nullable = false, length = 50)
    private float CF;
    @Column (name = "SegRiePer", nullable = false, length = 50)
    private float SegRiePer;
    @Column (name = "GastosAdm", nullable = false, length = 50)
    private float GastosAdm;
    @Column (name = "tipoMoneda", nullable = false, length = 50)
    private String tipoMoneda;
    @Column (name = "tipoPeriodo", nullable = false, length = 50)
    private String tipoPeriodo;
    @Column (name = "cPG", nullable = false, length = 50)
    private float cPG;
    @Column (name = "fechaConsulta", nullable = false, length = 50)
    private String fechaConsulta;
    @Column (name = "N", nullable = false, length = 50)
    private float N;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private users id_user;
}
