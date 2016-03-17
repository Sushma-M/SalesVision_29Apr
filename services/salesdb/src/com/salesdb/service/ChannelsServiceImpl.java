/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the source code license agreement you entered into with wavemaker-com*/

package com.salesdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wavemaker.runtime.data.dao.*;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.salesdb.*;


/**
 * ServiceImpl object for domain model class Channels.
 * @see com.salesdb.Channels
 */
@Service("salesdb.ChannelsService")
public class ChannelsServiceImpl implements ChannelsService {


    private static final Logger LOGGER = LoggerFactory.getLogger(ChannelsServiceImpl.class);

    @Autowired
    @Qualifier("salesdb.ChannelsDao")
    private WMGenericDao<Channels, Integer> wmGenericDao;
    public void setWMGenericDao(WMGenericDao<Channels, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "salesdbTransactionManager")
     public Page<Channels> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "salesdbTransactionManager")
    @Override
    public Channels create(Channels channels) {
        LOGGER.debug("Creating a new channels with information: {}" , channels);
        return this.wmGenericDao.create(channels);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "salesdbTransactionManager")
    @Override
    public Channels delete(Integer channelsId) throws EntityNotFoundException {
        LOGGER.debug("Deleting channels with id: {}" , channelsId);
        Channels deleted = this.wmGenericDao.findById(channelsId);
        if (deleted == null) {
            LOGGER.debug("No channels found with id: {}" , channelsId);
            throw new EntityNotFoundException(String.valueOf(channelsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public Page<Channels> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all channelss");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public Page<Channels> findAll(Pageable pageable) {
        LOGGER.debug("Finding all channelss");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public Channels findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding channels by id: {}" , id);
        Channels channels=this.wmGenericDao.findById(id);
        if(channels==null){
            LOGGER.debug("No channels found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return channels;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "salesdbTransactionManager")
    @Override
    public Channels update(Channels updated) throws EntityNotFoundException {
        LOGGER.debug("Updating channels with information: {}" , updated);
        this.wmGenericDao.update(updated);
        return this.wmGenericDao.findById((Integer)updated.getId());
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


