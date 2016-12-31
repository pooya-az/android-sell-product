package com.example.woods.amin.Database;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.woods.amin.Database.Users;
import com.example.woods.amin.Database.Products;
import com.example.woods.amin.Database.Orders;
import com.example.woods.amin.Database.OrderProducts;
import com.example.woods.amin.Database.Schedules;
import com.example.woods.amin.Database.Settings;
import com.example.woods.amin.Database.Images;

import com.example.woods.amin.Database.UsersDao;
import com.example.woods.amin.Database.ProductsDao;
import com.example.woods.amin.Database.OrdersDao;
import com.example.woods.amin.Database.OrderProductsDao;
import com.example.woods.amin.Database.SchedulesDao;
import com.example.woods.amin.Database.SettingsDao;
import com.example.woods.amin.Database.ImagesDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig usersDaoConfig;
    private final DaoConfig productsDaoConfig;
    private final DaoConfig ordersDaoConfig;
    private final DaoConfig orderProductsDaoConfig;
    private final DaoConfig schedulesDaoConfig;
    private final DaoConfig settingsDaoConfig;
    private final DaoConfig imagesDaoConfig;

    private final UsersDao usersDao;
    private final ProductsDao productsDao;
    private final OrdersDao ordersDao;
    private final OrderProductsDao orderProductsDao;
    private final SchedulesDao schedulesDao;
    private final SettingsDao settingsDao;
    private final ImagesDao imagesDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        usersDaoConfig = daoConfigMap.get(UsersDao.class).clone();
        usersDaoConfig.initIdentityScope(type);

        productsDaoConfig = daoConfigMap.get(ProductsDao.class).clone();
        productsDaoConfig.initIdentityScope(type);

        ordersDaoConfig = daoConfigMap.get(OrdersDao.class).clone();
        ordersDaoConfig.initIdentityScope(type);

        orderProductsDaoConfig = daoConfigMap.get(OrderProductsDao.class).clone();
        orderProductsDaoConfig.initIdentityScope(type);

        schedulesDaoConfig = daoConfigMap.get(SchedulesDao.class).clone();
        schedulesDaoConfig.initIdentityScope(type);

        settingsDaoConfig = daoConfigMap.get(SettingsDao.class).clone();
        settingsDaoConfig.initIdentityScope(type);

        imagesDaoConfig = daoConfigMap.get(ImagesDao.class).clone();
        imagesDaoConfig.initIdentityScope(type);

        usersDao = new UsersDao(usersDaoConfig, this);
        productsDao = new ProductsDao(productsDaoConfig, this);
        ordersDao = new OrdersDao(ordersDaoConfig, this);
        orderProductsDao = new OrderProductsDao(orderProductsDaoConfig, this);
        schedulesDao = new SchedulesDao(schedulesDaoConfig, this);
        settingsDao = new SettingsDao(settingsDaoConfig, this);
        imagesDao = new ImagesDao(imagesDaoConfig, this);

        registerDao(Users.class, usersDao);
        registerDao(Products.class, productsDao);
        registerDao(Orders.class, ordersDao);
        registerDao(OrderProducts.class, orderProductsDao);
        registerDao(Schedules.class, schedulesDao);
        registerDao(Settings.class, settingsDao);
        registerDao(Images.class, imagesDao);
    }
    
    public void clear() {
        usersDaoConfig.clearIdentityScope();
        productsDaoConfig.clearIdentityScope();
        ordersDaoConfig.clearIdentityScope();
        orderProductsDaoConfig.clearIdentityScope();
        schedulesDaoConfig.clearIdentityScope();
        settingsDaoConfig.clearIdentityScope();
        imagesDaoConfig.clearIdentityScope();
    }

    public UsersDao getUsersDao() {
        return usersDao;
    }

    public ProductsDao getProductsDao() {
        return productsDao;
    }

    public OrdersDao getOrdersDao() {
        return ordersDao;
    }

    public OrderProductsDao getOrderProductsDao() {
        return orderProductsDao;
    }

    public SchedulesDao getSchedulesDao() {
        return schedulesDao;
    }

    public SettingsDao getSettingsDao() {
        return settingsDao;
    }

    public ImagesDao getImagesDao() {
        return imagesDao;
    }

}