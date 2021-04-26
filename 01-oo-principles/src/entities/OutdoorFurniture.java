package entities;

public class OutdoorFurniture extends Furniture  {

    private String material;
    private double maxTemperatureInDegrees;
    private double minTemperatureInDegrees;

    public OutdoorFurniture(String name, String description, int price, String material, double maxTemperatureInDegrees, double minTemperatureInDegrees) {
        super(name, description, price);
        this.material = material;
        this.maxTemperatureInDegrees = maxTemperatureInDegrees;
        this.minTemperatureInDegrees = minTemperatureInDegrees;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getMaxTemperatureInDegrees() {
        return maxTemperatureInDegrees;
    }

    public void setMaxTemperatureInDegrees(double maxTemperatureInDegrees) {
        this.maxTemperatureInDegrees = maxTemperatureInDegrees;
    }

    public double getMinTemperatureInDegrees() {
        return minTemperatureInDegrees;
    }

    public void setMinTemperatureInDegrees(double minTemperatureInDegrees) {
        this.minTemperatureInDegrees = minTemperatureInDegrees;
    }

    @Override
    public String toString() {
        return super.toString() + " OutdoorFurniture [material=" + material + ", maxTemperatureInDegrees=" + maxTemperatureInDegrees
                + ", minTemperatureInDegrees=" + minTemperatureInDegrees + "]";
    }

    
}
