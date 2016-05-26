package se.brokenpipe.main;

import se.brokenpipe.database.Database;
import se.brokenpipe.database.DatabaseType;
import se.brokenpipe.database.item.Item;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Database db = new Database(DatabaseType.POSTGRES, "10.20.96.18", 5432, "newwws");
        try {
            for (Item item : db.getItems()) {
                System.out.println(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
