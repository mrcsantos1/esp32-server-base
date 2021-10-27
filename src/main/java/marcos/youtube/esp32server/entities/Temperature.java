package marcos.youtube.esp32server.entities;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "temperatures")
public class Temperature implements Serializable {
    private static final Long serialVersion = 1L;

    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTemperature;

    @Column(length = 5)
    private Double temperature;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant date;

    // Missing foreign key "idSensor"

    // Constructors
    public Temperature() {

    }

    public Temperature(Long idTemperature, Double temperature, Instant date) {
        this.idTemperature = idTemperature;
        this.temperature = temperature;
        this.date = date;
    }

    public Long getIdTemperature() {
        return this.idTemperature;
    }

    public void setIdTemperature(Long id) {
        this.idTemperature = id;
    }

    public Double getTemperature() {
        return this.temperature;
    }

    public void setTemperature(Double temp) {
        this.temperature = temp;
    }

    public Instant getDate() {
        return this.date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temperature that = (Temperature) o;
        return idTemperature.equals(that.idTemperature) && temperature.equals(that.temperature) && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTemperature, temperature, date);
    }
}
