package me.o93.tissue.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-02-11 21:38:30")
/** */
public final class UserMeta extends org.slim3.datastore.ModelMeta<me.o93.tissue.model.User> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.User, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.User, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<me.o93.tissue.model.User> name = new org.slim3.datastore.StringAttributeMeta<me.o93.tissue.model.User>(this, "name", "name");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.User, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.User, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final UserMeta slim3_singleton = new UserMeta();

    /**
     * @return the singleton
     */
    public static UserMeta get() {
       return slim3_singleton;
    }

    /** */
    public UserMeta() {
        super("User", me.o93.tissue.model.User.class);
    }

    @Override
    public me.o93.tissue.model.User entityToModel(com.google.appengine.api.datastore.Entity entity) {
        me.o93.tissue.model.User model = new me.o93.tissue.model.User();
        model.setKey(entity.getKey());
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        me.o93.tissue.model.User m = (me.o93.tissue.model.User) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("name", m.getName());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        me.o93.tissue.model.User m = (me.o93.tissue.model.User) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        me.o93.tissue.model.User m = (me.o93.tissue.model.User) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        me.o93.tissue.model.User m = (me.o93.tissue.model.User) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        me.o93.tissue.model.User m = (me.o93.tissue.model.User) model;
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
        me.o93.tissue.model.User m = (me.o93.tissue.model.User) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder0.encode(writer, m.getName());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected me.o93.tissue.model.User jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        me.o93.tissue.model.User m = new me.o93.tissue.model.User();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("name");
        m.setName(decoder0.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}