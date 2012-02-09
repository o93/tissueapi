package me.o93.tissue.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-02-09 23:21:31")
/** */
public final class SpotMeta extends org.slim3.datastore.ModelMeta<me.o93.tissue.model.Spot> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Spot, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Spot, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<me.o93.tissue.model.Spot> name = new org.slim3.datastore.StringAttributeMeta<me.o93.tissue.model.Spot>(this, "name", "name");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Spot, com.google.appengine.api.datastore.GeoPt> point = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Spot, com.google.appengine.api.datastore.GeoPt>(this, "point", "point", com.google.appengine.api.datastore.GeoPt.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<me.o93.tissue.model.Spot, org.slim3.datastore.ModelRef<me.o93.tissue.model.Task>, me.o93.tissue.model.Task> taskRef = new org.slim3.datastore.ModelRefAttributeMeta<me.o93.tissue.model.Spot, org.slim3.datastore.ModelRef<me.o93.tissue.model.Task>, me.o93.tissue.model.Task>(this, "taskRef", "taskRef", org.slim3.datastore.ModelRef.class, me.o93.tissue.model.Task.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Spot, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.Spot, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final SpotMeta slim3_singleton = new SpotMeta();

    /**
     * @return the singleton
     */
    public static SpotMeta get() {
       return slim3_singleton;
    }

    /** */
    public SpotMeta() {
        super("Spot", me.o93.tissue.model.Spot.class);
    }

    @Override
    public me.o93.tissue.model.Spot entityToModel(com.google.appengine.api.datastore.Entity entity) {
        me.o93.tissue.model.Spot model = new me.o93.tissue.model.Spot();
        model.setKey(entity.getKey());
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setPoint((com.google.appengine.api.datastore.GeoPt) entity.getProperty("point"));
        if (model.getTaskRef() == null) {
            throw new NullPointerException("The property(taskRef) is null.");
        }
        model.getTaskRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("taskRef"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        me.o93.tissue.model.Spot m = (me.o93.tissue.model.Spot) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("name", m.getName());
        entity.setProperty("point", m.getPoint());
        if (m.getTaskRef() == null) {
            throw new NullPointerException("The property(taskRef) must not be null.");
        }
        entity.setProperty("taskRef", m.getTaskRef().getKey());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        me.o93.tissue.model.Spot m = (me.o93.tissue.model.Spot) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        me.o93.tissue.model.Spot m = (me.o93.tissue.model.Spot) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        me.o93.tissue.model.Spot m = (me.o93.tissue.model.Spot) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        me.o93.tissue.model.Spot m = (me.o93.tissue.model.Spot) model;
        if (m.getTaskRef() == null) {
            throw new NullPointerException("The property(taskRef) must not be null.");
        }
        m.getTaskRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        me.o93.tissue.model.Spot m = (me.o93.tissue.model.Spot) model;
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
        me.o93.tissue.model.Spot m = (me.o93.tissue.model.Spot) model;
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
        if(m.getPoint() != null){
            writer.setNextPropertyName("point");
            encoder0.encode(writer, m.getPoint());
        }
        if(m.getTaskRef() != null && m.getTaskRef().getKey() != null){
            writer.setNextPropertyName("taskRef");
            encoder0.encode(writer, m.getTaskRef(), maxDepth, currentDepth);
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected me.o93.tissue.model.Spot jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        me.o93.tissue.model.Spot m = new me.o93.tissue.model.Spot();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("name");
        m.setName(decoder0.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("point");
        m.setPoint(decoder0.decode(reader, m.getPoint()));
        reader = rootReader.newObjectReader("taskRef");
        decoder0.decode(reader, m.getTaskRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}