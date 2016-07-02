import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

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
            preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS CONTACT (ID INT PRIMARY KEY AUTO_INCREMENT,NAME VARCHAR (20)),LASTNAME VARCHAR(40),MIDLNAME VARCHAR (40),PHJNENUMBER VARCHAR (20)");
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
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
//        c.setName(scanner.next());
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
//        System.out.println("Name" + "" + c.getName());
//
//    }



//    @Override
//    public String toString() {
//        return "PhoneBook{" +
//                "phonebook=" + phonebook +
//                '}';
//    }





}
