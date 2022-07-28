package Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "seller")
public class Seller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String tel;

    public Seller(String name, String address, String tel) {
        this.name = name;
        this.address = address;
        this.tel = tel;
    }

    @ManyToMany(mappedBy = "sellerSet")
    private Set<Product> productSet = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return Objects.equals(id, seller.id) && Objects.equals(name, seller.name) && Objects.equals(address, seller.address) && Objects.equals(tel, seller.tel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, tel);
    }
}
