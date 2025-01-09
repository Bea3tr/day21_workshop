package paf.day21_workshop.model;

import java.sql.Date;

public class Reservation {

    private int id;
    private Date startDate;
    private Date endDate;
    private float cost;

    private Customer customer;
    private Room room;
    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public Date getStartDate() {return startDate;}
    public void setStartDate(Date startDate) {this.startDate = startDate;}

    public Date getEndDate() {return endDate;}
    public void setEndDate(Date endDate) {this.endDate = endDate;}

    public float getCost() {return cost;}
    public void setCost(float cost) {this.cost = cost;}

    public Customer getCustomer() {return customer;}
    public void setCustomer(Customer customer) {this.customer = customer;}
    
    public Room getRoom() {return room;}
    public void setRoom(Room room) {this.room = room;}
    
    public Reservation(int id, Date startDate, Date endDate, float cost, Customer customer, Room room) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
        this.customer = customer;
        this.room = room;
    }
}
