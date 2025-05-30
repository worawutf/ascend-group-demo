package ascend.group.demo.entity;

import lombok.Data;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "BOOKS")
@Data
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(name = "publishedDate")
    private Date publishedDate;
}