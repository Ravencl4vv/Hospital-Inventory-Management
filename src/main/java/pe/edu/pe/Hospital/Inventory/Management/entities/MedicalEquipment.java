package pe.edu.pe.Hospital.Inventory.Management.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "medical_equipment")
@Data
public class MedicalEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "decription_status", length = 60, nullable = false)
    private String descriptionStatus;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(length = 1, nullable = false)
    private String status;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Model> model;




}
