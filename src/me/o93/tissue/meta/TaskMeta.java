package me.o93.tissue.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-02-13 09:07:27")
/** */
public final class TaskMeta extends org.slim3.datastore.ModelMeta<me.o93.tissue.model.Task> {

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<me.o93.tissue.model.Task, org.slim3.datastore.ModelRef<me.o93.tissue.model.At>, me.o93.tissue.model.At> atRef = new org.slim3.datastore.ModelRefAttributeMeta<me.o93.tissue.model.Task, org.slim3.datastore.ModelRef<me.o93.tissue.model.At>, me.o93.tissue.model.At>(this, "atRef", "atRef", org.slim3.datastore.ModelRef.class, me.o93.tissue.model.At.class);

    /** */
    public final org.slim3.datastore.CoreUnindexedAttributeMeta<me.o93.tissue.model.Task, java.util.Date> beginAt = new org.slim3.datastore.CoreUnindexedAttributeMeta<me.o93.tissue.model.Task, java.util.Date>(this, "beginAt", "beginAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Task, java.util.Date> createdAt = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Task, java.util.Date>(this, "createdAt", "createdAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreUnindexedAttributeMeta<me.o93.tissue.model.Task, java.util.Date> endAt = new org.slim3.datastore.CoreUnindexedAttributeMeta<me.o93.tissue.model.Task, java.util.Date>(this, "endAt", "endAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Task, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Task, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<me.o93.tissue.model.Task> name = new org.slim3.datastore.StringAttributeMeta<me.o93.tissue.model.Task>(this, "name", "name");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<me.o93.tissue.model.Task, org.slim3.datastore.ModelRef<me.o93.tissue.model.Task>, me.o93.tissue.model.Task> parentRef = new org.slim3.datastore.ModelRefAttributeMeta<me.o93.tissue.model.Task, org.slim3.datastore.ModelRef<me.o93.tissue.model.Task>, me.o93.tissue.model.Task>(this, "parentRef", "parentRef", org.slim3.datastore.ModelRef.class, me.o93.tissue.model.Task.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Task, com.google.appengine.api.datastore.GeoPt> point = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Task, com.google.appengine.api.datastore.GeoPt>(this, "point", "point", com.google.appengine.api.datastore.GeoPt.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Task, java.lang.Long> repeat = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Task, java.lang.Long>(this, "repeat", "repeat", long.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<me.o93.tissue.model.Task> spotName = new org.slim3.datastore.StringAttributeMeta<me.o93.tissue.model.Task>(this, "spotName", "spotName");

    /** */
    public final org.slim3.datastore.StringCollectionAttributeMeta<me.o93.tissue.model.Task, java.util.List<java.lang.String>> tags = new org.slim3.datastore.StringCollectionAttributeMeta<me.o93.tissue.model.Task, java.util.List<java.lang.String>>(this, "tags", "tags", java.util.List.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Task, java.util.Date> updatedAt = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Task, java.util.Date>(this, "updatedAt", "updatedAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<me.o93.tissue.model.Task, org.slim3.datastore.ModelRef<me.o93.tissue.model.User>, me.o93.tissue.model.User> userRef = new org.slim3.datastore.ModelRefAttributeMeta<me.o93.tissue.model.Task, org.slim3.datastore.ModelRef<me.o93.tissue.model.User>, me.o93.tissue.model.User>(this, "userRef", "userRef", org.slim3.datastore.ModelRef.class, me.o93.tissue.model.User.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Task, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Task, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdAtAttributeListener = new org.slim3.datastore.CreationDate();

    private static final org.slim3.datastore.ModificationDate slim3_updatedAtAttributeListener = new org.slim3.datastore.ModificationDate();

    private static final TaskMeta slim3_singleton = new TaskMeta();

    /**
     * @return the singleton
     */
    public static TaskMeta get() {
       return slim3_singleton;
    }

    /** */
    public TaskMeta() {
        super("Task", me.o93.tissue.model.Task.class);
    }

    @Override
    public me.o93.tissue.model.Task entityToModel(com.google.appengine.api.datastore.Entity entity) {
        me.o93.tissue.model.Task model = new me.o93.tissue.model.Task();
        if (model.getAtRef() == null) {
            throw new NullPointerException("The property(atRef) is null.");
        }
        model.getAtRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("atRef"));
        model.setBeginAt((java.util.Date) entity.getProperty("beginAt"));
        model.setCreatedAt((java.util.Date) entity.getProperty("createdAt"));
        model.setEndAt((java.util.Date) entity.getProperty("endAt"));
        model.setKey(entity.getKey());
        model.setName((java.lang.String) entity.getProperty("name"));
        if (model.getParentRef() == null) {
            throw new NullPointerException("The property(parentRef) is null.");
        }
        model.getParentRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("parentRef"));
        model.setPoint((com.google.appengine.api.datastore.GeoPt) entity.getProperty("point"));
        model.setRepeat(longToPrimitiveLong((java.lang.Long) entity.getProperty("repeat")));
        model.setSpotName((java.lang.String) entity.getProperty("spotName"));
        model.setTags(toList(java.lang.String.class, entity.getProperty("tags")));
        model.setUpdatedAt((java.util.Date) entity.getProperty("updatedAt"));
        if (model.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) is null.");
        }
        model.getUserRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("userRef"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        me.o93.tissue.model.Task m = (me.o93.tissue.model.Task) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        if (m.getAtRef() == null) {
            throw new NullPointerException("The property(atRef) must not be null.");
        }
        entity.setProperty("atRef", m.getAtRef().getKey());
        entity.setUnindexedProperty("beginAt", m.getBeginAt());
        entity.setProperty("createdAt", m.getCreatedAt());
        entity.setUnindexedProperty("endAt", m.getEndAt());
        entity.setProperty("name", m.getName());
        if (m.getParentRef() == null) {
            throw new NullPointerException("The property(parentRef) must not be null.");
        }
        entity.setProperty("parentRef", m.getParentRef().getKey());
        entity.setProperty("point", m.getPoint());
        entity.setProperty("repeat", m.getRepeat());
        entity.setProperty("spotName", m.getSpotName());
        entity.setProperty("tags", m.getTags());
        entity.setProperty("updatedAt", m.getUpdatedAt());
        if (m.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) must not be null.");
        }
        entity.setProperty("userRef", m.getUserRef().getKey());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        me.o93.tissue.model.Task m = (me.o93.tissue.model.Task) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        me.o93.tissue.model.Task m = (me.o93.tissue.model.Task) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        me.o93.tissue.model.Task m = (me.o93.tissue.model.Task) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        me.o93.tissue.model.Task m = (me.o93.tissue.model.Task) model;
        if (m.getAtRef() == null) {
            throw new NullPointerException("The property(atRef) must not be null.");
        }
        m.getAtRef().assignKeyIfNecessary(ds);
        if (m.getParentRef() == null) {
            throw new NullPointerException("The property(parentRef) must not be null.");
        }
        m.getParentRef().assignKeyIfNecessary(ds);
        if (m.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) must not be null.");
        }
        m.getUserRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        me.o93.tissue.model.Task m = (me.o93.tissue.model.Task) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        me.o93.tissue.model.Task m = (me.o93.tissue.model.Task) model;
        m.setCreatedAt(slim3_createdAtAttributeListener.prePut(m.getCreatedAt()));
        m.setUpdatedAt(slim3_updatedAtAttributeListener.prePut(m.getUpdatedAt()));
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        me.o93.tissue.model.Task m = (me.o93.tissue.model.Task) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getAtRef() != null && m.getAtRef().getKey() != null){
            writer.setNextPropertyName("atRef");
            encoder0.encode(writer, m.getAtRef(), maxDepth, currentDepth);
        }
        if(m.getBeginAt() != null){
            writer.setNextPropertyName("beginAt");
            encoder0.encode(writer, m.getBeginAt());
        }
        if(m.getCreatedAt() != null){
            writer.setNextPropertyName("createdAt");
            encoder0.encode(writer, m.getCreatedAt());
        }
        if(m.getEndAt() != null){
            writer.setNextPropertyName("endAt");
            encoder0.encode(writer, m.getEndAt());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        writer.setNextPropertyName("likeCount");
        encoder0.encode(writer, m.getLikeCount());
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder0.encode(writer, m.getName());
        }
        if(m.getParentRef() != null && m.getParentRef().getKey() != null){
            writer.setNextPropertyName("parentRef");
            encoder0.encode(writer, m.getParentRef(), maxDepth, currentDepth);
        }
        if(m.getPoint() != null){
            writer.setNextPropertyName("point");
            encoder0.encode(writer, m.getPoint());
        }
        writer.setNextPropertyName("repeat");
        encoder0.encode(writer, m.getRepeat());
        if(m.getSpotName() != null){
            writer.setNextPropertyName("spotName");
            encoder0.encode(writer, m.getSpotName());
        }
        if(m.getTags() != null){
            writer.setNextPropertyName("tags");
            writer.beginArray();
            for(java.lang.String v : m.getTags()){
                encoder0.encode(writer, v);
            }
            writer.endArray();
        }
        if(m.getUpdatedAt() != null){
            writer.setNextPropertyName("updatedAt");
            encoder0.encode(writer, m.getUpdatedAt());
        }
        if(m.getUser() != null){
            writer.setNextPropertyName("user");
            encoder0.encode(writer, m.getUser());
        }
        if(m.getUserRef() != null && m.getUserRef().getKey() != null){
            writer.setNextPropertyName("userRef");
            encoder0.encode(writer, m.getUserRef(), maxDepth, currentDepth);
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected me.o93.tissue.model.Task jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        me.o93.tissue.model.Task m = new me.o93.tissue.model.Task();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("atRef");
        decoder0.decode(reader, m.getAtRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("beginAt");
        m.setBeginAt(decoder0.decode(reader, m.getBeginAt()));
        reader = rootReader.newObjectReader("createdAt");
        m.setCreatedAt(decoder0.decode(reader, m.getCreatedAt()));
        reader = rootReader.newObjectReader("endAt");
        m.setEndAt(decoder0.decode(reader, m.getEndAt()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("likeCount");
        m.setLikeCount(decoder0.decode(reader, m.getLikeCount()));
        reader = rootReader.newObjectReader("name");
        m.setName(decoder0.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("parentRef");
        decoder0.decode(reader, m.getParentRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("point");
        m.setPoint(decoder0.decode(reader, m.getPoint()));
        reader = rootReader.newObjectReader("repeat");
        m.setRepeat(decoder0.decode(reader, m.getRepeat()));
        reader = rootReader.newObjectReader("spotName");
        m.setSpotName(decoder0.decode(reader, m.getSpotName()));
        reader = rootReader.newObjectReader("tags");
        {
            java.util.ArrayList<java.lang.String> elements = new java.util.ArrayList<java.lang.String>();
            org.slim3.datastore.json.JsonArrayReader r = rootReader.newArrayReader("tags");
            if(r != null){
                reader = r;
                int n = r.length();
                for(int i = 0; i < n; i++){
                    r.setIndex(i);
                    java.lang.String v = decoder0.decode(reader, (java.lang.String)null)                    ;
                    if(v != null){
                        elements.add(v);
                    }
                }
                m.setTags(elements);
            }
        }
        reader = rootReader.newObjectReader("updatedAt");
        m.setUpdatedAt(decoder0.decode(reader, m.getUpdatedAt()));
        reader = rootReader.newObjectReader("user");
        m.setUser(decoder0.decode(reader, m.getUser(), me.o93.tissue.model.User.class));
        reader = rootReader.newObjectReader("userRef");
        decoder0.decode(reader, m.getUserRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}