package me.o93.tissue.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-02-09 23:31:32")
/** */
public final class CountMeta extends org.slim3.datastore.ModelMeta<me.o93.tissue.model.Count> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Count, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Count, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<me.o93.tissue.model.Count, org.slim3.datastore.ModelRef<me.o93.tissue.model.Task>, me.o93.tissue.model.Task> taskRef = new org.slim3.datastore.ModelRefAttributeMeta<me.o93.tissue.model.Count, org.slim3.datastore.ModelRef<me.o93.tissue.model.Task>, me.o93.tissue.model.Task>(this, "taskRef", "taskRef", org.slim3.datastore.ModelRef.class, me.o93.tissue.model.Task.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Count, java.lang.Integer> value = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Count, java.lang.Integer>(this, "value", "value", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Count, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Count, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final CountMeta slim3_singleton = new CountMeta();

    /**
     * @return the singleton
     */
    public static CountMeta get() {
       return slim3_singleton;
    }

    /** */
    public CountMeta() {
        super("Count", me.o93.tissue.model.Count.class);
    }

    @Override
    public me.o93.tissue.model.Count entityToModel(com.google.appengine.api.datastore.Entity entity) {
        me.o93.tissue.model.Count model = new me.o93.tissue.model.Count();
        model.setKey(entity.getKey());
        if (model.getTaskRef() == null) {
            throw new NullPointerException("The property(taskRef) is null.");
        }
        model.getTaskRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("taskRef"));
        model.setValue(longToPrimitiveInt((java.lang.Long) entity.getProperty("value")));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        me.o93.tissue.model.Count m = (me.o93.tissue.model.Count) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        if (m.getTaskRef() == null) {
            throw new NullPointerException("The property(taskRef) must not be null.");
        }
        entity.setProperty("taskRef", m.getTaskRef().getKey());
        entity.setProperty("value", m.getValue());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        me.o93.tissue.model.Count m = (me.o93.tissue.model.Count) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        me.o93.tissue.model.Count m = (me.o93.tissue.model.Count) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        me.o93.tissue.model.Count m = (me.o93.tissue.model.Count) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        me.o93.tissue.model.Count m = (me.o93.tissue.model.Count) model;
        if (m.getTaskRef() == null) {
            throw new NullPointerException("The property(taskRef) must not be null.");
        }
        m.getTaskRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        me.o93.tissue.model.Count m = (me.o93.tissue.model.Count) model;
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
        me.o93.tissue.model.Count m = (me.o93.tissue.model.Count) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getTaskRef() != null && m.getTaskRef().getKey() != null){
            writer.setNextPropertyName("taskRef");
            encoder0.encode(writer, m.getTaskRef(), maxDepth, currentDepth);
        }
        writer.setNextPropertyName("value");
        encoder0.encode(writer, m.getValue());
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected me.o93.tissue.model.Count jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        me.o93.tissue.model.Count m = new me.o93.tissue.model.Count();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("taskRef");
        decoder0.decode(reader, m.getTaskRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("value");
        m.setValue(decoder0.decode(reader, m.getValue()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}