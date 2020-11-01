package pe.edu.pe.Hospital.Inventory.Management.entities;


import lombok.Data;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "brands")
@Data



public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_brand;

    @Column(length = 60, nullable = false)
    private String name_brand;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(length = 1, nullable = false)
    private String status;


}
