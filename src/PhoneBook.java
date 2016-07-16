import java.sql.*;
import java.util.ArrayList;

/**
 * Created by VYA on 02.07.2016.
 */
public class PhoneBook {

    private Connection connection;

    private PreparedStatement preparedStatement;

    public PhoneBook(String url, String user, String password) {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        try {
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void createContactTable(){
        try {
            preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS CONTACTS (ID INT PRIMARY KEY AUTO_INCREMENT,CONTACTNAME VARCHAR (20),LASTNAME VARCHAR(40),MIDLNAME VARCHAR (40),PHONENUMBER VARCHAR (20))");
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void addContact(String contactName, String lastName, String midlName, String phoneNumber){
        Contact contact = new Contact(contactName, lastName, midlName, phoneNumber);
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO CONTACTS (contactName, lastName, midlName, phoneNumber) VALUES (?,?,?,?)");
            preparedStatement.setString(1, contactName);
            preparedStatement.setString(2,lastName);
            preparedStatement.setString(3,midlName);
            preparedStatement.setString(4,phoneNumber);
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public ArrayList<Contact> findAllContacts(){
        ArrayList<Contact> contacts = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM CONTACTS");
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            while (resultSet.next()){
                Contact contact;
                contact = new Contact(resultSet.getString("contactName"), resultSet.getString("lastName"), resultSet.getString("midlName"), resultSet.getString("phoneNumber"));
                contact.setId(resultSet.getInt("id"));
                contacts.add(contact);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return contacts;
    }



    //    private ArrayList<Contact> phonebook = new ArrayList<>();
//
//    Scanner scanner = new Scanner(System.in);
//
//    Contact c = new Contact();
//
//
//    public void addContact (){
//
//        System.out.println("Enter name");
//
//        c.setContactName(scanner.next());
//
//        System.out.println("Enter last name");
//
//        c.setLastName(scanner.next());
//
//        System.out.println("Enter midl name");
//
//        c.setMidlName(scanner.next());
//
//        System.out.println("Enter phone number");
//
//        c.setPhoneNumber(scanner.next());
//
//        phonebook.add(c);
//    }
//
//    public void showContact(){
//
//        System.out.println("Name" + "" + c.getContactName());
//
//    }



//    @Override
//    public String toString() {
//        return "PhoneBook{" +
//                "phonebook=" + phonebook +
//                '}';
//    }





}
