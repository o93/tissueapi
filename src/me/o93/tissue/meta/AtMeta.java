package me.o93.tissue.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-02-11 01:42:18")
/** */
public final class AtMeta extends org.slim3.datastore.ModelMeta<me.o93.tissue.model.At> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.At, java.lang.Integer> day = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.At, java.lang.Integer>(this, "day", "day", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.At, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.At, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.At, java.lang.Long> like = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.At, java.lang.Long>(this, "like", "like", long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.At, java.lang.Integer> month = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.At, java.lang.Integer>(this, "month", "month", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.At, java.lang.Long> timeslot = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.At, java.lang.Long>(this, "timeslot", "timeslot", long.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<me.o93.tissue.model.At, org.slim3.datastore.ModelRef<me.o93.tissue.model.User>, me.o93.tissue.model.User> userRef = new org.slim3.datastore.ModelRefAttributeMeta<me.o93.tissue.model.At, org.slim3.datastore.ModelRef<me.o93.tissue.model.User>, me.o93.tissue.model.User>(this, "userRef", "userRef", org.slim3.datastore.ModelRef.class, me.o93.tissue.model.User.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.At, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.At, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.At, java.lang.Integer> week = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.At, java.lang.Integer>(this, "week", "week", int.class);

    private static final AtMeta slim3_singleton = new AtMeta();

    /**
     * @return the singleton
     */
    public static AtMeta get() {
       return slim3_singleton;
    }

    /** */
    public AtMeta() {
        super("At", me.o93.tissue.model.At.class);
    }

    @Override
    public me.o93.tissue.model.At entityToModel(com.google.appengine.api.datastore.Entity entity) {
        me.o93.tissue.model.At model = new me.o93.tissue.model.At();
        model.setDay(longToPrimitiveInt((java.lang.Long) entity.getProperty("day")));
        model.setKey(entity.getKey());
        model.setLike(longToPrimitiveLong((java.lang.Long) entity.getProperty("like")));
        model.setMonth(longToPrimitiveInt((java.lang.Long) entity.getProperty("month")));
        model.setTimeslot(longToPrimitiveLong((java.lang.Long) entity.getProperty("timeslot")));
        if (model.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) is null.");
        }
        model.getUserRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("userRef"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        model.setWeek(longToPrimitiveInt((java.lang.Long) entity.getProperty("week")));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        me.o93.tissue.model.At m = (me.o93.tissue.model.At) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("day", m.getDay());
        entity.setProperty("like", m.getLike());
        entity.setProperty("month", m.getMonth());
        entity.setProperty("timeslot", m.getTimeslot());
        if (m.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) must not be null.");
        }
        entity.setProperty("userRef", m.getUserRef().getKey());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("week", m.getWeek());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        me.o93.tissue.model.At m = (me.o93.tissue.model.At) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        me.o93.tissue.model.At m = (me.o93.tissue.model.At) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        me.o93.tissue.model.At m = (me.o93.tissue.model.At) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        me.o93.tissue.model.At m = (me.o93.tissue.model.At) model;
        if (m.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) must not be null.");
        }
        m.getUserRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        me.o93.tissue.model.At m = (me.o93.tissue.model.At) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
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
        me.o93.tissue.model.At m = (me.o93.tissue.model.At) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        writer.setNextPropertyName("day");
        encoder0.encode(writer, m.getDay());
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        writer.setNextPropertyName("like");
        encoder0.encode(writer, m.getLike());
        writer.setNextPropertyName("month");
        encoder0.encode(writer, m.getMonth());
        writer.setNextPropertyName("timeslot");
        encoder0.encode(writer, m.getTimeslot());
        if(m.getUserRef() != null && m.getUserRef().getKey() != null){
            writer.setNextPropertyName("userRef");
            encoder0.encode(writer, m.getUserRef(), maxDepth, currentDepth);
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.setNextPropertyName("week");
        encoder0.encode(writer, m.getWeek());
        writer.endObject();
    }

    @Override
    protected me.o93.tissue.model.At jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        me.o93.tissue.model.At m = new me.o93.tissue.model.At();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("day");
        m.setDay(decoder0.decode(reader, m.getDay()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("like");
        m.setLike(decoder0.decode(reader, m.getLike()));
        reader = rootReader.newObjectReader("month");
        m.setMonth(decoder0.decode(reader, m.getMonth()));
        reader = rootReader.newObjectReader("timeslot");
        m.setTimeslot(decoder0.decode(reader, m.getTimeslot()));
        reader = rootReader.newObjectReader("userRef");
        decoder0.decode(reader, m.getUserRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        reader = rootReader.newObjectReader("week");
        m.setWeek(decoder0.decode(reader, m.getWeek()));
        return m;
    }
}