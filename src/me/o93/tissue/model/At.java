package me.o93.tissue.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;

@Model(schemaVersion = 1)
public class At implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final String LIKE = "L";
    private static final String DATE = "D";
    
    private static final String LIKE_FORMAT = "00000000000";
    private static final String DATE_FORMAT = "0000000000000000000";
    
    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;
    
    private ModelRef<User> userRef = new ModelRef<User>(User.class);
    
    private List<String> ranges;
    
    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        At other = (At) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public ModelRef<User> getUserRef() {
        return userRef;
    }

    public void setRanges(List<String> ranges) {
        this.ranges = ranges;
    }

    public List<String> getRanges() {
        return ranges;
    }

    public void refreshDate(Date date) {
        DecimalFormat dateFormat = new DecimalFormat(DATE_FORMAT);
        String dateString = DATE + dateFormat.format(date.getTime());
        
        List<String> ranges = getRanges();
        if (ranges == null) {
            ranges = new ArrayList<String>();
            ranges.add(dateString);
            DecimalFormat likeFormat = new DecimalFormat(LIKE_FORMAT);
            ranges.add(LIKE + likeFormat.format(0));
        } else {
            ranges.set(0, dateString);
        }
        setRanges(ranges);
    }
    
    public void refreshLike(long like) {
        DecimalFormat likeFormat = new DecimalFormat(LIKE_FORMAT);
        String likeString = LIKE + likeFormat.format(like);
        
        List<String> ranges = getRanges();
        ranges.set(1, likeString);
    }
    
    public long getLike() {
        if (ranges.size() < 2) return 0;
        
        DecimalFormat likeFormat = new DecimalFormat(LIKE + LIKE_FORMAT);
        try {
            return likeFormat.parse(ranges.get(1)).longValue();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
