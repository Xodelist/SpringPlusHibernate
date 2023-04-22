package hiber.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cars")
public class Car implements Serializable {
    @Id
    @JoinColumn(name = "owner_id",referencedColumnName = "id")
    @OneToOne
    private User owner;
    @Column
    private String model;
    @Column
    private int series;

    public Car() {
    }

    public Car(User owner, String model, int series) {
        this.owner = owner;
        this.model = model;
        this.series = series;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}
