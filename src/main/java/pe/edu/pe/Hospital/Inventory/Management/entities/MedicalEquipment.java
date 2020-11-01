package pe.edu.pe.Hospital.Inventory.Management.entities;


import lombok.Data;



import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "medical_equipments")
@Data


public class MedicalEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_medical_equipment;

    @Column(length = 60, nullable = false)
    private String description_status;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(length = 1, nullable = false)
    private String status;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Model> model;

}
