package johnsUtil.model.SharedResources;

import org.mindrot.jbcrypt.BCrypt;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

/**
 * Created by John on 4/21/2017.
 */
public class Account {

    private static Account account = new Account();

    private int accountID;
    private String userName;
    private int userType;
    private String name;
    private String address;
    private String email;
    private String phoneNum;
    private File picPath;
    private boolean loggedIn;

    private Account(){
        this.accountID  = -1;
        this.userName = "";
        this.userType = 3;
        this.name = "";
        this.address =  "";
        this.email = "";
        this.phoneNum = "";
        this.picPath = null;
        loggedIn = false;
    }

    /**Tries to gather account info from usrName
     * Yea I realize holding a password in a string is a vulnerability but, this is software security engineering class and not
     *  a functional requirement given we have a shit ton of stuff to do in such little time....
     * @param usrName
     * @param password
     */
    public boolean login(String usrName, String password) throws SQLException {
        if(Database.getInstance().logIn(usrName,password)){
            loggedIn = true;
            return true;
        }
        else {
            return false;
        }
    }

    public void logout(){
        this.accountID  = -1;
        this.userName = "";
        this.userType = 3;
        this.name = "";
        this.address =  "";
        this.email = "";
        this.phoneNum = "";
        this.picPath = null;
        loggedIn = false;
    }

    /**
     * Adds account to databse
     * @param account
     */
    @Deprecated
    public  void createAccount(Account account){

    }

    private static String sha256NoSaltPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        StringBuffer hexString = new StringBuffer();
        for (int i=0;i<byteData.length;i++) {
            String hex =Integer.toHexString(0xff & byteData[i]);
            if(hex.length()==1){
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }

    /**
     * Generates a BCrypted Salted hash for a password
     * @param password
     * @return hash
     */
    public static String bCryptSaltedPassword(String password){
        String hashed =  BCrypt.hashpw(password,BCrypt.gensalt());
        return hashed;
    }



    public int getAccountID() {
        return accountID;
    }

    public File getPicPath() {
        return picPath;
    }

    public void setPicPath(File picPath) {
        this.picPath = picPath;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public static Account getInstance(){ return account; }

}
