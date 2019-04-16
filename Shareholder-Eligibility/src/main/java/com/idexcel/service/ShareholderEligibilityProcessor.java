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

import com.idexcel.model.ShareholderEligibility;


@RestController
@RequestMapping("/api")
class ShareholderEligibilityProcessor {

		
		@RequestMapping("/ShEligibility/{fico}/{anyDelinquencies}/{anyDelinquenciesIn24months}/{personalBankruptcy}/{anyPersonalLiens}/{anyCriminalCharges}/{anyOFACCheck}")
		public ShareholderEligibility getProduct(@PathVariable int fico, @PathVariable String anyDelinquencies,
												@PathVariable String anyDelinquenciesIn24months,@PathVariable String personalBankruptcy,
												@PathVariable String anyPersonalLiens,
												@PathVariable String anyCriminalCharges, @PathVariable String anyOFACCheck) {
		
			
			
			KieServices kieService = KieServices.Factory.get();
			Resource dt 
			  = ResourceFactory
			    .newClassPathResource("com/idexcel/drools/rules/rulesSE.xls", getClass());
			
			KieFileSystem kieFileSystem = kieService.newKieFileSystem().write(dt);
			
			KieBuilder kieBuilder = kieService.newKieBuilder(kieFileSystem);
			kieBuilder.buildAll();
			
			KieRepository kieRepository = kieService.getRepository();
			
			ReleaseId krDefaultReleaseId = kieRepository.getDefaultReleaseId();
			KieContainer kieContainer 
			  = kieService.newKieContainer(krDefaultReleaseId);
			
			KieSession kieSession = kieContainer.newKieSession();
			
			ShareholderEligibility eligibility = new ShareholderEligibility(fico, anyDelinquencies, anyDelinquenciesIn24months,personalBankruptcy, anyPersonalLiens, anyCriminalCharges, anyOFACCheck);

			if(eligibility.getPersonalBankruptcy().equals("TRUE")) {
				System.out.println("loan denied ");
				return new ShareholderEligibility();
			}
			
			kieSession.insert(eligibility);
			
			kieSession.fireAllRules();
					
			return eligibility;
		
		}
		
		
}
	

