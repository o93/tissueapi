package me.o93.tissue.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-02-12 00:26:57")
/** */
public final class AtMeta extends org.slim3.datastore.ModelMeta<me.o93.tissue.model.At> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.At, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.At, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringCollectionAttributeMeta<me.o93.tissue.model.At, java.util.List<java.lang.String>> ranges = new org.slim3.datastore.StringCollectionAttributeMeta<me.o93.tissue.model.At, java.util.List<java.lang.String>>(this, "ranges", "ranges", java.util.List.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<me.o93.tissue.model.At, org.slim3.datastore.ModelRef<me.o93.tissue.model.User>, me.o93.tissue.model.User> userRef = new org.slim3.datastore.ModelRefAttributeMeta<me.o93.tissue.model.At, org.slim3.datastore.ModelRef<me.o93.tissue.model.User>, me.o93.tissue.model.User>(this, "userRef", "userRef", org.slim3.datastore.ModelRef.class, me.o93.tissue.model.User.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.At, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<me.o93.tissue.model.At, java.lang.Long>(this, "version", "version", java.lang.Long.class);

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
        model.setKey(entity.getKey());
        model.setRanges(toList(java.lang.String.class, entity.getProperty("ranges")));
        if (model.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) is null.");
        }
        model.getUserRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("userRef"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
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
        entity.setProperty("ranges", m.getRanges());
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
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getRanges() != null){
            writer.setNextPropertyName("ranges");
            writer.beginArray();
            for(java.lang.String v : m.getRanges()){
                encoder0.encode(writer, v);
            }
            writer.endArray();
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
    protected me.o93.tissue.model.At jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        me.o93.tissue.model.At m = new me.o93.tissue.model.At();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("ranges");
        {
            java.util.ArrayList<java.lang.String> elements = new java.util.ArrayList<java.lang.String>();
            org.slim3.datastore.json.JsonArrayReader r = rootReader.newArrayReader("ranges");
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
                m.setRanges(elements);
            }
        }
        reader = rootReader.newObjectReader("userRef");
        decoder0.decode(reader, m.getUserRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}