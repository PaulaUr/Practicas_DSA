package Modelo;

/**
 * Created by pauli on 11/03/2017.
 */
public class Location {


    private double longitud;
    private double latitude;
    private int idLocation;


    public Location(double longitud, double latitude, int idLocation) {
        this.longitud = longitud;
        this.latitude = latitude;
        this.idLocation = idLocation;
    }

    public Location() {
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }
}

