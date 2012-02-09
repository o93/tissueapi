package me.o93.tissue.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-02-09 23:22:19")
/** */
public final class NotifyMeta extends org.slim3.datastore.ModelMeta<me.o93.tissue.model.Notify> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Notify, java.util.Date> createdAt = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Notify, java.util.Date>(this, "createdAt", "createdAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Notify, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Notify, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<me.o93.tissue.model.Notify> text = new org.slim3.datastore.StringUnindexedAttributeMeta<me.o93.tissue.model.Notify>(this, "text", "text");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<me.o93.tissue.model.Notify, org.slim3.datastore.ModelRef<me.o93.tissue.model.User>, me.o93.tissue.model.User> userRef = new org.slim3.datastore.ModelRefAttributeMeta<me.o93.tissue.model.Notify, org.slim3.datastore.ModelRef<me.o93.tissue.model.User>, me.o93.tissue.model.User>(this, "userRef", "userRef", org.slim3.datastore.ModelRef.class, me.o93.tissue.model.User.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Notify, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Notify, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final org.slim3.datastore.CreationDate slim3_createdAtAttributeListener = new org.slim3.datastore.CreationDate();

    private static final NotifyMeta slim3_singleton = new NotifyMeta();

    /**
     * @return the singleton
     */
    public static NotifyMeta get() {
       return slim3_singleton;
    }

    /** */
    public NotifyMeta() {
        super("Notify", me.o93.tissue.model.Notify.class);
    }

    @Override
    public me.o93.tissue.model.Notify entityToModel(com.google.appengine.api.datastore.Entity entity) {
        me.o93.tissue.model.Notify model = new me.o93.tissue.model.Notify();
        model.setCreatedAt((java.util.Date) entity.getProperty("createdAt"));
        model.setKey(entity.getKey());
        model.setText((java.lang.String) entity.getProperty("text"));
        if (model.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) is null.");
        }
        model.getUserRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("userRef"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        me.o93.tissue.model.Notify m = (me.o93.tissue.model.Notify) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("createdAt", m.getCreatedAt());
        entity.setUnindexedProperty("text", m.getText());
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
        me.o93.tissue.model.Notify m = (me.o93.tissue.model.Notify) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        me.o93.tissue.model.Notify m = (me.o93.tissue.model.Notify) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        me.o93.tissue.model.Notify m = (me.o93.tissue.model.Notify) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        me.o93.tissue.model.Notify m = (me.o93.tissue.model.Notify) model;
        if (m.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) must not be null.");
        }
        m.getUserRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        me.o93.tissue.model.Notify m = (me.o93.tissue.model.Notify) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        me.o93.tissue.model.Notify m = (me.o93.tissue.model.Notify) model;
        m.setCreatedAt(slim3_createdAtAttributeListener.prePut(m.getCreatedAt()));
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
        me.o93.tissue.model.Notify m = (me.o93.tissue.model.Notify) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getCreatedAt() != null){
            writer.setNextPropertyName("createdAt");
            encoder0.encode(writer, m.getCreatedAt());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getText() != null){
            writer.setNextPropertyName("text");
            encoder0.encode(writer, m.getText());
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
    protected me.o93.tissue.model.Notify jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        me.o93.tissue.model.Notify m = new me.o93.tissue.model.Notify();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("createdAt");
        m.setCreatedAt(decoder0.decode(reader, m.getCreatedAt()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("text");
        m.setText(decoder0.decode(reader, m.getText()));
        reader = rootReader.newObjectReader("userRef");
        decoder0.decode(reader, m.getUserRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}