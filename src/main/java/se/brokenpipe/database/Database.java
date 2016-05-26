package se.brokenpipe.database;

import se.brokenpipe.database.item.Item;

import java.sql.*;
import java.text.MessageFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private final DatabaseType dbType;
    private final String ip;
    private final int port;
    private final String databaseName;

    public Database(DatabaseType type, String ip, int port, String databaseName) {
        dbType = type;
        this.ip = ip;
        this.port = port;
        this.databaseName = databaseName;
        try {
            Class.forName(type.getDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        if (dbType == DatabaseType.POSTGRES) {
            String url = MessageFormat.format(dbType.getUrlTemplate(), ip, String.valueOf(port), databaseName);
            Connection conn = DriverManager.getConnection(url, "postgres", "admin");
            return conn;
        } else {
            return null;
        }
    }

    public List<Item> getItems() throws SQLException {
        Connection conn = getConnection();
        List<Item> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(Item.SELECT_ALL)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Item item = new Item();
                    item.setAuthor(rs.getString(Item.AUTHOR_COL));
                    item.setChannelId(rs.getInt(Item.CHANNELID_COL));
                    item.setDescription(rs.getString(Item.DESCRIPTION_COL));
                    item.setLink(rs.getString(Item.LINK_COL));
                    try {
                        String pubDate = rs.getString(Item.PUBDATE_COL);
                        if (pubDate != null) {
                            item.setPubDate(OffsetDateTime.parse(pubDate, DateTimeFormatter.RFC_1123_DATE_TIME));
                        }
                    } catch (DateTimeParseException ex) {
                    }
                    item.setTitle(rs.getString(Item.TITLE_COL));
                    list.add(item);
                }
            }
        }
        conn.close();
        return list;
    }
}
