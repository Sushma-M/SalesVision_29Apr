
package com.wavemaker.testsalesvision.salesdb.service;

import java.util.Map;
import java.util.List;


import com.wavemaker.runtime.data.model.CustomProcedure;
import com.wavemaker.runtime.data.exception.QueryParameterMismatchException;

public interface SalesdbProcedureExecutorService {

	
	List<Object> executeWMCustomProcedure(CustomProcedure procedure) ;


}

