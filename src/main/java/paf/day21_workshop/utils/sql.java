package paf.day21_workshop.utils;

public class sql {

    public static final String getAllCustomers = "SELECT * FROM customer limit ? offset ?";
    public static final String getAllCustomersAuto = "SELECT * FROM customer";
    public static final String getCustomerById = "SELECT * FROM customer where id = ?";
    public static final String deleteCustomerById = "DELETE FROM customer WHERE id = ?";
    public static final String updateCustomerById = "UPDATE customer set fullname = ?, email = ? WHERE id = ?";
    public static final String insertCustomer = "INSERT INTO customer (fullName, email) VALUES (?, ?)";

    public static final String getAllRooms = "SELECT * FROM room";
    public static final String getRoomById = "SELECT * FROM room where id = ?";
    public static final String deleteRoomById = "DELETE FROM room WHERE id = ?";
    public static final String updateRoomById = "UPDATE room set room_type = ?, price = ? WHERE id = ?";
    public static final String insertRoom = "INSERT INTO room (room_type, price) VALUES (?, ?)";
}
