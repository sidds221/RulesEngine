package com.idexcel.service;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idexcel.model.CompanyEligibility;

@RestController
@RequestMapping("/api")
class ProductController{
	
	@RequestMapping("/bankruptcy/{check}/{years}")
	public CompanyEligibility getProduct(@PathVariable String check , @PathVariable int years) {
	
		KieServices kieService = KieServices.Factory.get();
		Resource dt 
		  = ResourceFactory
		    .newClassPathResource("com/idexcel/drools/rules/rules.xls", getClass());
		
		KieFileSystem kieFileSystem = kieService.newKieFileSystem().write(dt);
		
		KieBuilder kieBuilder = kieService.newKieBuilder(kieFileSystem);
		kieBuilder.buildAll();
		
		KieRepository kieRepository = kieService.getRepository();
		
		ReleaseId krDefaultReleaseId = kieRepository.getDefaultReleaseId();
		KieContainer kieContainer 
		  = kieService.newKieContainer(krDefaultReleaseId);
		
		KieSession kieSession = kieContainer.newKieSession();
		
		CompanyEligibility eligibility = new CompanyEligibility();

		eligibility.setBankruptcy(check);
		
		eligibility.setYearsInBusiness(years);
		
		kieSession.insert(eligibility);
		
		kieSession.fireAllRules();
		
		System.out.println("Bankruptcy is "
				+ eligibility.getBankruptcy() + " therefore, riskScore is  " + eligibility.getRiskScore());
		
		return eligibility;
	
	}
	
	
}