/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.salesdb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Qualifier;
import com.salesdb.service.SalesdbQueryExecutorService;
import com.wavemaker.runtime.data.model.CustomQuery;
import com.wavemaker.runtime.data.exception.QueryParameterMismatchException;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

@RestController(value = "Salesdb.QueryExecutionController")
@RequestMapping("/salesdb/queryExecutor")
@Api(description = "Controller class for query execution", value = "QueryExecutionController")
public class QueryExecutionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryExecutionController.class);

    @Autowired
    private SalesdbQueryExecutorService queryService;

    @RequestMapping(value = "/queries/wm_custom", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Process request to execute customer queries")
    public Page<Object> executeWMCustomQuery(@RequestBody CustomQuery query, Pageable pageable) {
        Page<Object> result = queryService.executeWMCustomQuerySelect(query, pageable);
        LOGGER.debug("got the result {}" + result);
        return result;
    }

    @RequestMapping(value = "/queries/weeklyQuotes", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Process request to execute queries")
    public Page<Object> executeWeeklyQuotes(@RequestParam(value = "year", required = true) java.lang.Integer year, @RequestParam(value = "month", required = true) java.lang.Integer month, Pageable pageable) throws QueryParameterMismatchException {
        LOGGER.debug("Executing named query weeklyQuotes");
        Page<Object> result = queryService.executeWeeklyQuotes(pageable, year, month);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @RequestMapping(value = "/queries/weeklyLeads", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Process request to execute queries")
    public Page<Object> executeWeeklyLeads(@RequestParam(value = "year", required = true) java.lang.Integer year, @RequestParam(value = "month", required = true) java.lang.Integer month, Pageable pageable) throws QueryParameterMismatchException {
        LOGGER.debug("Executing named query weeklyLeads");
        Page<Object> result = queryService.executeWeeklyLeads(pageable, year, month);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @RequestMapping(value = "/queries/weeklyFollowUps", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Process request to execute queries")
    public Page<Object> executeWeeklyFollowUps(@RequestParam(value = "year", required = true) java.lang.Integer year, @RequestParam(value = "month", required = true) java.lang.Integer month, Pageable pageable) throws QueryParameterMismatchException {
        LOGGER.debug("Executing named query weeklyFollowUps");
        Page<Object> result = queryService.executeWeeklyFollowUps(pageable, year, month);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @RequestMapping(value = "/queries/leadsCount", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Process request to execute queries")
    public Page<Object> executeLeadsCount(@RequestParam(value = "channel", required = true) java.lang.Integer channel, Pageable pageable) throws QueryParameterMismatchException {
        LOGGER.debug("Executing named query leadsCount");
        Page<Object> result = queryService.executeLeadsCount(pageable, channel);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @RequestMapping(value = "/queries/repsCount", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Process request to execute queries")
    public Page<Object> executeRepsCount(@RequestParam(value = "channel", required = true) java.lang.Integer channel, Pageable pageable) throws QueryParameterMismatchException {
        LOGGER.debug("Executing named query repsCount");
        Page<Object> result = queryService.executeRepsCount(pageable, channel);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @RequestMapping(value = "/queries/salesRevenueAndCount", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Process request to execute queries")
    public Page<Object> executeSalesRevenueAndCount(@RequestParam(value = "channel", required = true) java.lang.Integer channel, Pageable pageable) throws QueryParameterMismatchException {
        LOGGER.debug("Executing named query salesRevenueAndCount");
        Page<Object> result = queryService.executeSalesRevenueAndCount(pageable, channel);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @RequestMapping(value = "/queries/topTrendingProducts", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Process request to execute queries")
    public Page<Object> executeTopTrendingProducts(@RequestParam(value = "year", required = true) java.lang.Integer year, @RequestParam(value = "month", required = true) java.lang.Integer month, Pageable pageable) throws QueryParameterMismatchException {
        LOGGER.debug("Executing named query topTrendingProducts");
        Page<Object> result = queryService.executeTopTrendingProducts(pageable, year, month);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @RequestMapping(value = "/queries/salesByReps", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Process request to execute queries")
    public Page<Object> executeSalesByReps(@RequestParam(value = "channel", required = true) java.lang.Integer channel, Pageable pageable) throws QueryParameterMismatchException {
        LOGGER.debug("Executing named query salesByReps");
        Page<Object> result = queryService.executeSalesByReps(pageable, channel);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @RequestMapping(value = "/queries/salesByChannels", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Process request to execute queries")
    public Page<Object> executeSalesByChannels(@RequestParam(value = "year", required = true) java.lang.Integer year, @RequestParam(value = "month", required = true) java.lang.Integer month, Pageable pageable) throws QueryParameterMismatchException {
        LOGGER.debug("Executing named query salesByChannels");
        Page<Object> result = queryService.executeSalesByChannels(pageable, year, month);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @RequestMapping(value = "/queries/weeklyConverted", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Process request to execute queries")
    public Page<Object> executeWeeklyConverted(@RequestParam(value = "year", required = true) java.lang.Integer year, @RequestParam(value = "month", required = true) java.lang.Integer month, Pageable pageable) throws QueryParameterMismatchException {
        LOGGER.debug("Executing named query weeklyConverted");
        Page<Object> result = queryService.executeWeeklyConverted(pageable, year, month);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @RequestMapping(value = "/queries/revenueHeatMap", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Process request to execute queries")
    public Page<Object> executeRevenueHeatMap(@RequestParam(value = "year", required = true) java.lang.Integer year, @RequestParam(value = "month", required = true) java.lang.Integer month, Pageable pageable) throws QueryParameterMismatchException {
        LOGGER.debug("Executing named query revenueHeatMap");
        Page<Object> result = queryService.executeRevenueHeatMap(pageable, year, month);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @RequestMapping(value = "/queries/customersRatio", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Process request to execute queries")
    public Page<Object> executeCustomersRatio(@RequestParam(value = "year", required = true) java.lang.Integer year, @RequestParam(value = "month", required = true) java.lang.Integer month, Pageable pageable) throws QueryParameterMismatchException {
        LOGGER.debug("Executing named query customersRatio");
        Page<Object> result = queryService.executeCustomersRatio(pageable, year, month);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @RequestMapping(value = "/queries/leadsByChannel", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Process request to execute queries")
    public Page<Object> executeLeadsByChannel(@RequestParam(value = "channel", required = true) java.lang.Integer channel, Pageable pageable) throws QueryParameterMismatchException {
        LOGGER.debug("Executing named query leadsByChannel");
        Page<Object> result = queryService.executeLeadsByChannel(pageable, channel);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @RequestMapping(value = "/queries/salesByEachRep", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Process request to execute queries")
    public Page<Object> executeSalesByEachRep(@RequestParam(value = "id", required = true) java.lang.Integer id, Pageable pageable) throws QueryParameterMismatchException {
        LOGGER.debug("Executing named query salesByEachRep");
        Page<Object> result = queryService.executeSalesByEachRep(pageable, id);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @RequestMapping(value = "/queries/eachRepCustomerWiseSales", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Process request to execute queries")
    public Page<Object> executeEachRepCustomerWiseSales(@RequestParam(value = "id", required = true) java.lang.Integer id, Pageable pageable) throws QueryParameterMismatchException {
        LOGGER.debug("Executing named query eachRepCustomerWiseSales");
        Page<Object> result = queryService.executeEachRepCustomerWiseSales(pageable, id);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @RequestMapping(value = "/queries/weeklySales", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Process request to execute queries")
    public Page<Object> executeWeeklySales(@RequestParam(value = "year", required = true) java.lang.Integer year, @RequestParam(value = "month", required = true) java.lang.Integer month, Pageable pageable) throws QueryParameterMismatchException {
        LOGGER.debug("Executing named query weeklySales");
        Page<Object> result = queryService.executeWeeklySales(pageable, year, month);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @RequestMapping(value = "/queries/wm_custom_update", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Process request to execute customer queries")
    public int executeWMCustomQuery(@RequestBody CustomQuery query) {
        int result = queryService.executeWMCustomQueryUpdate(query);
        LOGGER.debug("got the result {}" + result);
        return result;
    }
}
