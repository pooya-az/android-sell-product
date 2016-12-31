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
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ORDERS".
*/
public class OrdersDao extends AbstractDao<Orders, Long> {

    public static final String TABLENAME = "ORDERS";

    /**
     * Properties of entity Orders.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property First_price = new Property(1, String.class, "first_price", false, "FIRST_PRICE");
        public final static Property Last_price = new Property(2, String.class, "last_price", false, "LAST_PRICE");
        public final static Property Off = new Property(3, String.class, "off", false, "OFF");
        public final static Property Status = new Property(4, int.class, "status", false, "STATUS");
        public final static Property Create = new Property(5, java.util.Date.class, "create", false, "CREATE");
        public final static Property User_id = new Property(6, long.class, "user_id", false, "USER_ID");
    }

    private DaoSession daoSession;

    private Query<Orders> users_UserOrdersQuery;

    public OrdersDao(DaoConfig config) {
        super(config);
    }
    
    public OrdersDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ORDERS\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"FIRST_PRICE\" TEXT," + // 1: first_price
                "\"LAST_PRICE\" TEXT," + // 2: last_price
                "\"OFF\" TEXT," + // 3: off
                "\"STATUS\" INTEGER NOT NULL ," + // 4: status
                "\"CREATE\" INTEGER," + // 5: create
                "\"USER_ID\" INTEGER NOT NULL );"); // 6: user_id
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ORDERS\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Orders entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String first_price = entity.getFirst_price();
        if (first_price != null) {
            stmt.bindString(2, first_price);
        }
 
        String last_price = entity.getLast_price();
        if (last_price != null) {
            stmt.bindString(3, last_price);
        }
 
        String off = entity.getOff();
        if (off != null) {
            stmt.bindString(4, off);
        }
        stmt.bindLong(5, entity.getStatus());
 
        java.util.Date create = entity.getCreate();
        if (create != null) {
            stmt.bindLong(6, create.getTime());
        }
        stmt.bindLong(7, entity.getUser_id());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Orders entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String first_price = entity.getFirst_price();
        if (first_price != null) {
            stmt.bindString(2, first_price);
        }
 
        String last_price = entity.getLast_price();
        if (last_price != null) {
            stmt.bindString(3, last_price);
        }
 
        String off = entity.getOff();
        if (off != null) {
            stmt.bindString(4, off);
        }
        stmt.bindLong(5, entity.getStatus());
 
        java.util.Date create = entity.getCreate();
        if (create != null) {
            stmt.bindLong(6, create.getTime());
        }
        stmt.bindLong(7, entity.getUser_id());
    }

    @Override
    protected final void attachEntity(Orders entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Orders readEntity(Cursor cursor, int offset) {
        Orders entity = new Orders( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // first_price
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // last_price
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // off
            cursor.getInt(offset + 4), // status
            cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)), // create
            cursor.getLong(offset + 6) // user_id
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Orders entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setFirst_price(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setLast_price(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setOff(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setStatus(cursor.getInt(offset + 4));
        entity.setCreate(cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)));
        entity.setUser_id(cursor.getLong(offset + 6));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Orders entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Orders entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Orders entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "userOrders" to-many relationship of Users. */
    public List<Orders> _queryUsers_UserOrders(long user_id) {
        synchronized (this) {
            if (users_UserOrdersQuery == null) {
                QueryBuilder<Orders> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.User_id.eq(null));
                users_UserOrdersQuery = queryBuilder.build();
            }
        }
        Query<Orders> query = users_UserOrdersQuery.forCurrentThread();
        query.setParameter(0, user_id);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getUsersDao().getAllColumns());
            builder.append(" FROM ORDERS T");
            builder.append(" LEFT JOIN USERS T0 ON T.\"USER_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Orders loadCurrentDeep(Cursor cursor, boolean lock) {
        Orders entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Users orderUsers = loadCurrentOther(daoSession.getUsersDao(), cursor, offset);
         if(orderUsers != null) {
            entity.setOrderUsers(orderUsers);
        }

        return entity;    
    }

    public Orders loadDeep(Long key) {
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
    public List<Orders> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Orders> list = new ArrayList<Orders>(count);
        
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
    
    protected List<Orders> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Orders> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
