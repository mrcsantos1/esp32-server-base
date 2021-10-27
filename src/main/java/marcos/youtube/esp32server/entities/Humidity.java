package marcos.youtube.esp32server.entities;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "humidities")
public class Humidity implements Serializable {
    private static final Long serialVersion = 1L;

    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHumidity;

    @Column(length = 5)
    private Double humidity;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant date;

    // Missing foreign key "idSensor"

    // Constructors
    public Humidity() {

    }

    public Humidity(Long idHumidity, Double humidity, Instant date) {
        this.idHumidity = idHumidity;
        this.humidity = humidity;
        this.date = date;
    }

    public Long getIdHumidity() {
        return this.idHumidity;
    }

    public void setIdHumidity(Long id) {
        this.idHumidity = id;
    }

    public Double getHumidity() {
        return this.humidity;
    }

    public void setHumidity(Double hum) {
        this.humidity = hum;
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
        Humidity that = (Humidity) o;
        return idHumidity.equals(that.idHumidity) && humidity.equals(that.humidity) && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHumidity, humidity, date);
    }
}
