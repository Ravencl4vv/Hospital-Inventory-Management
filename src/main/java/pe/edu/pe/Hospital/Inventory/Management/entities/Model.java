package pe.edu.pe.Hospital.Inventory.Management.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "models")
@Data

public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_model;

    @Column(length = 60, nullable = false)
    private String name_model;

    @Column(nullable = false)
    private Integer velocity;

    @Column(nullable = false)
    private Integer voltage;

    @Column(nullable = false)
    private Integer weight;

    @Column(nullable = false)
    private Integer tall;

    //Buena Practica DDD

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(length = 1, nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_brand", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Brand brand;

}