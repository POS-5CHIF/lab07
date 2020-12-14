package at.michaelkoenig.lab0701.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Michael König
 */
@Entity
@Table(name = "hobby")
@Getter
@Setter
@ToString
public class Hobby implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hobby_id")
    private Integer id;

    @Column(name = "hobby_description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "hobby_person")
    private Person person;
}