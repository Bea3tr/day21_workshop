package paf.day21_workshop.utils;

public class sql {

    public static final String getAllRooms = "SELECT * FROM room";
    public static final String getAllCustomers = "SELECT * FROM customer limit ? offset ?";
    public static final String getAllCustomersAuto = "SELECT * FROM customer";
    public static final String getCustomerById = "SELECT * FROM customer where id = ?";

}
