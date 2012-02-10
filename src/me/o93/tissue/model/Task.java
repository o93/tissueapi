package me.o93.tissue.model;

import java.io.Serializable;
import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.CreationDate;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;
import org.slim3.datastore.ModificationDate;

import com.google.appengine.api.datastore.Key;

@Model(schemaVersion = 1)
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    private String name;
    
    @Attribute(unindexed = true)
    private Date beginAt;

    @Attribute(unindexed = true)
    private Date endAt;
    
    private long repeat;
    
    private ModelRef<Category> categoryRef = new ModelRef<Category>(Category.class);
    private ModelRef<User> userRef = new ModelRef<User>(User.class);

    @Attribute(listener = CreationDate.class)
    private Date createdAt;
    @Attribute(listener = ModificationDate.class)
    private Date updatedAt;

    @Attribute(persistent = false)
    private Category category;
    @Attribute(persistent = false)
    private User user;
    @Attribute(persistent = false)
    private Spot spot;
    
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
        Task other = (Task) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Date getBeginAt() {
        return beginAt;
    }

    public void setBeginAt(Date beginAt) {
        this.beginAt = beginAt;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public long getRepeat() {
        return repeat;
    }

    public void setRepeat(long repeat) {
        this.repeat = repeat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ModelRef<User> getUserRef() {
        return userRef;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ModelRef<Category> getCategoryRef() {
        return categoryRef;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }
}
