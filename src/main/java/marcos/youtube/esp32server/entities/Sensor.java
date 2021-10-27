package marcos.youtube.esp32server.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "sensors")
public class Sensor implements Serializable {
    private static final Long serialVersion = 1L;

    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sensor;

    @Column(nullable = false, unique = true)
    private Integer code;

    @Column(nullable = false, length = 7)
    private String name;

    @Column(length = 5)
    private Float latestTemp;

    @Column(length = 5)
    private Float latestHum;

    // Constructors
    public Sensor() {

    }

    public Sensor(Long id_sensor, Integer code, String name, Float latestTemp, Float latestHum) {
        this.id_sensor = id_sensor;
        this.code = code;
        this.name = name;
        this.latestTemp = latestTemp;
        this.latestHum = latestHum;
    }


    public Long getId_sensor() {
        return this.id_sensor;
    }

    public void setId_sensor(Long id) {
        this.id_sensor = id;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getlatestTemp() {
        return this.latestTemp;
    }

    public void setlatestTemp(Float temp) {
        this.latestTemp = temp;
    }

    public Float getlatestHum() {
        return this.latestHum;
    }

    public void setlatestHum(Float hum) {
        this.latestHum = hum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sensor sensor = (Sensor) o;
        return id_sensor.equals(sensor.id_sensor) &&
                code.equals(sensor.code) &&
                name.equals(sensor.name) &&
                latestTemp.equals(sensor.latestTemp) &&
                latestHum.equals(sensor.latestHum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_sensor, code, name, latestTemp, latestHum);
    }
}
