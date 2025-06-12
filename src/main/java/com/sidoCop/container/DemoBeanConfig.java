package com.sidoCop.container;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sidoCop.sysPharma.dao.MedicamentDao;
import com.sidoCop.sysPharma.dao.MedicamentDaoJpa;
import com.sidoCop.sysPharma.service.ServiceMedicament;

@Configuration
public class DemoBeanConfig {

	@Bean(initMethod = "initialisation", destroyMethod = "destruction")
	public ServiceMedicament serviceMedicament() {
		return new ServiceMedicament(MedicamentDaoJpa());
	}

	@Bean(initMethod = "initialisation", destroyMethod = "destruction")
	public MedicamentDaoJpa MedicamentDaoJpa() {
		return new MedicamentDaoJpa();
	}

	@Bean(initMethod = "initialisation", destroyMethod = "destruction")
	public MedicamentDao MedicamentDao() {
		return new MedicamentDao();
	}

}
