package se.brokenpipe.database.item;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class Item implements Serializable {
    public static final String TABLE_NAME = "item";
    public static final String AUTHOR_COL = "author";
    public static final String DESCRIPTION_COL = "description";
    public static final String LINK_COL = "link";
    public static final String PUBDATE_COL = "pubdate";
    public static final String TITLE_COL = "title";
    public static final String CHANNELID_COL = "channel_Id";
    public static final String SELECT_ALL = "SELECT * from " + TABLE_NAME;

    private String author;
    private String description;
    private String link;
    private OffsetDateTime pubDate;
    private String title;
    private int channelId;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public OffsetDateTime getPubDate() {
        return pubDate;
    }

    public void setPubDate(OffsetDateTime pubDate) {
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getAuthor() != null) {
            sb.append(getAuthor()).append(", ");
        }
        if (getTitle() != null) {
            sb.append(getTitle()).append(", ");
        }
        if (getDescription() != null) {
            sb.append(getDescription()).append(", ");
        }
        if (getLink() != null) {
            sb.append(getLink()).append(", ");
        }
        if (getPubDate() != null) {
            sb.append(getPubDate());
        }
        return sb.toString();
    }
}
