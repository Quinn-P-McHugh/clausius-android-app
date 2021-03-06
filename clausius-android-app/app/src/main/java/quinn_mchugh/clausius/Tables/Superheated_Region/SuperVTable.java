package quinn_mchugh.clausius.Tables.Superheated_Region;

import java.io.InputStream;

/**
 * Represents the super_v_table CSV file.
 */
public class SuperVTable extends SuperTable {

    private Double[][] specificVolArr;  // The array of entropy values bounded by the temperature and pressure values in the CSV file

    /**
     * Required public constructor for SuperVTable class.
     *
     * @param inputStream The input stream used to read the super_v_table CSV file
     */
    public SuperVTable(InputStream inputStream) {
        super(inputStream, 32);
        specificVolArr = super.getGridArr();
    }

    public Double[][] getSpecificVolArr() {
        return specificVolArr;
    }

    /**
     * Calculates specific volume using the super_v_table CSV file, given temperature and pressure.
     *
     * @param temperature [°C]
     * @param pressure [MPa]
     * @return The calculated specific volume [m^3/kg]
     */
    public Double calculateSpecificVolume (double temperature, double pressure) {
        return calculateGridValue(temperature, pressure, getSpecificVolArr());
    }
}
