package sample;

import java.util.Date;

/**

 * Beer-specific application data.

 */

public class BeerApplicationData extends ApplicationData{


    /**
     * Constructs a beer application data object. All parameters are taken from
     * ApplicationData; see the ApplicationData class for more information.
     */
    public BeerApplicationData(String ttbID, int repid, String serial, String address, String permitNo, String phoneNumber, String email, String applicantName, int type1, String type2, int type3, String permitAddress, java.sql.Date submittedDate) {
        super(ttbID, repid, serial, address, permitNo, phoneNumber, email, applicantName, type1, type2, type3, permitAddress, submittedDate);
    }
}
