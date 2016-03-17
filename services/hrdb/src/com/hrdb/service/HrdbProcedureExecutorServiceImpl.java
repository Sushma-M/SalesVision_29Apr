
package com.hrdb.service;


import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.wavemaker.runtime.data.model.CustomProcedure;
import com.wavemaker.runtime.data.dao.procedure.WMProcedureExecutor;
import com.wavemaker.runtime.data.exception.QueryParameterMismatchException;

@Service
public class HrdbProcedureExecutorServiceImpl implements HrdbProcedureExecutorService {
	private static final Logger LOGGER = LoggerFactory.getLogger(HrdbProcedureExecutorServiceImpl.class);

	@Autowired
	@Qualifier("hrdbWMProcedureExecutor")
	private WMProcedureExecutor procedureExecutor;


	@Transactional(value = "hrdbTransactionManager")
	@Override
	public List<Object> executeWMCustomProcedure(CustomProcedure procedure) {
	    return procedureExecutor.executeCustomProcedure(procedure);
	}


}

