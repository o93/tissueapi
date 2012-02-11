package me.o93.tissue.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.CreationDate;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;
import org.slim3.datastore.ModificationDate;

import com.google.appengine.api.datastore.GeoPt;
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
    
    private String spotName;
    private GeoPt point;
    
    private List<String> tags;
    
    private ModelRef<User> userRef = new ModelRef<User>(User.class);
    private ModelRef<Task> parentRef = new ModelRef<Task>(Task.class);
    private ModelRef<At> atRef = new ModelRef<At>(At.class);
    
    @Attribute(listener = CreationDate.class)
    private Date createdAt;
    @Attribute(listener = ModificationDate.class)
    private Date updatedAt;

    @Attribute(persistent = false)
    private User user;
    @Attribute(persistent = false)
    private long likeCount;
    
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
    
    public ModelRef<Task> getParentRef() {
        return parentRef;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public GeoPt getPoint() {
        return point;
    }

    public void setPoint(GeoPt point) {
        this.point = point;
    }

    public ModelRef<At> getAtRef() {
        return atRef;
    }

    public void setLikeCount(long likeCount) {
        this.likeCount = likeCount;
    }

    public long getLikeCount() {
        return likeCount;
    }
}
