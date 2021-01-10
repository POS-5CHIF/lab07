package at.michaelkoenig.lab0701.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Michael König
 */
@Entity
@Table(name = "person")
@Getter
@Setter
@ToString
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer id;

    @Column(name = "person_first_name")
    @Pattern(regexp = "[A-ZÄÖÜ][a-zäöü]{1,19}")
    private String firstName;

    @Column(name = "person_last_name")
    @Pattern(regexp = "[A-ZÄÖÜ][a-zäöü]{1,19}")
    private String lastName;

    @Column(name = "person_birth_day")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private LocalDate birthDay;

    @ManyToMany
    @JoinTable(name = "person_hobby",
            joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "hobby_id")})
    private List<Hobby> hobbies = new ArrayList<>();

    @Column(name = "person_sex")
    @Enumerated(value = EnumType.STRING)
    private Sex sex;

    public String getFormattedHobbies() {
        return hobbies.stream().map(h -> h.getDescription()).collect(Collectors.joining(", "));
    }

    public String getFormattedBirthday() {
        return birthDay.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
