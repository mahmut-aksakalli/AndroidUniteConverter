package hr.ferit.mahmutaksakalli.unicon;

public class Converter {

    public static float convertCelsius(float fahrenheit)
    {
        return (float) ((5.0 / 9.0) * (fahrenheit - 32));
    }

    public static float convertFahrenheit(float celsius)
    {
        return (float) ((9.0 / 5.0) * celsius + 32);
    }

    public static float convertMetersToKilometers(float meters)
    {
        return (float) meters/1000;
    }

    public static float convertKilometersToMeters(float kilometers)
    {
        return (float)kilometers*1000;
    }

    public static double convertYardToMeters(double yards){
        return (double)yards*0.9144;
    }

    public static double convertMetersToYards(double meters){
        return (double)meters/0.9144;
    }

    public static float convertLitersToMilliliters(float liters)
    {
        return (float)liters*1000;
    }

    public static float convertMillilitersToLiters(float milliliters)
    {
        return (float)milliliters/1000;
    }

    public static float convertKmhToMph(float kmh)
    {
        return (float)0.6214 * kmh;
    }

    public static double convertMphToKmh(float mph)
    {
        return (double) mph/0.6214;
    }
}
