import lombok.Data;

@Data
public class Nissan {

    String color;

    int maxSpeed;

    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Nissan{" +
                "color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
