package utility;

public class DistanceConverter {
  public static double toKilometers(double miles) {
    miles = Math.abs(miles);
    return miles * 1.609;
  }

  public static double toMiles(double kilometers) {
    kilometers = Math.abs(kilometers);
    return kilometers * 0.6215;
  }

  public static double toFathoms(double miles) {
    miles = Math.abs(miles);
    return miles * 880;
  }

  public static double toLeagues(double miles) {
    miles = Math.abs(miles);
    return miles * 3;
  }
}


