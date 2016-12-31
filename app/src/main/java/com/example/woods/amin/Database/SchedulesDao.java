package com.example.woods.amin.Database;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SCHEDULES".
*/
public class SchedulesDao extends AbstractDao<Schedules, Long> {

    public static final String TABLENAME = "SCHEDULES";

    /**
     * Properties of entity Schedules.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Title = new Property(1, String.class, "title", false, "TITLE");
        public final static Property Description = new Property(2, String.class, "description", false, "DESCRIPTION");
        public final static Property Unix_time = new Property(3, String.class, "unix_time", false, "UNIX_TIME");
        public final static Property Enable = new Property(4, boolean.class, "enable", false, "ENABLE");
        public final static Property User_id = new Property(5, long.class, "user_id", false, "USER_ID");
    }

    private DaoSession daoSession;


    public SchedulesDao(DaoConfig config) {
        super(config);
    }
    
    public SchedulesDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SCHEDULES\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"TITLE\" TEXT NOT NULL ," + // 1: title
                "\"DESCRIPTION\" TEXT," + // 2: description
                "\"UNIX_TIME\" TEXT NOT NULL ," + // 3: unix_time
                "\"ENABLE\" INTEGER NOT NULL ," + // 4: enable
                "\"USER_ID\" INTEGER NOT NULL );"); // 5: user_id
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SCHEDULES\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Schedules entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getTitle());
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(3, description);
        }
        stmt.bindString(4, entity.getUnix_time());
        stmt.bindLong(5, entity.getEnable() ? 1L: 0L);
        stmt.bindLong(6, entity.getUser_id());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Schedules entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getTitle());
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(3, description);
        }
        stmt.bindString(4, entity.getUnix_time());
        stmt.bindLong(5, entity.getEnable() ? 1L: 0L);
        stmt.bindLong(6, entity.getUser_id());
    }

    @Override
    protected final void attachEntity(Schedules entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Schedules readEntity(Cursor cursor, int offset) {
        Schedules entity = new Schedules( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // title
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // description
            cursor.getString(offset + 3), // unix_time
            cursor.getShort(offset + 4) != 0, // enable
            cursor.getLong(offset + 5) // user_id
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Schedules entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTitle(cursor.getString(offset + 1));
        entity.setDescription(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setUnix_time(cursor.getString(offset + 3));
        entity.setEnable(cursor.getShort(offset + 4) != 0);
        entity.setUser_id(cursor.getLong(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Schedules entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Schedules entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Schedules entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getUsersDao().getAllColumns());
            builder.append(" FROM SCHEDULES T");
            builder.append(" LEFT JOIN USERS T0 ON T.\"USER_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Schedules loadCurrentDeep(Cursor cursor, boolean lock) {
        Schedules entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Users userSchedules = loadCurrentOther(daoSession.getUsersDao(), cursor, offset);
         if(userSchedules != null) {
            entity.setUserSchedules(userSchedules);
        }

        return entity;    
    }

    public Schedules loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Schedules> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Schedules> list = new ArrayList<Schedules>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Schedules> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Schedules> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
