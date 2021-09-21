public class Burrow {
    double lat;
    double lng;



    public Burrow(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;

    }


    /* Endrer getters så de returnerer faktiske
     lat og lng verdier istedenfor 0.0 */
    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
