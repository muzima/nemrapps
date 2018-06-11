package org.openmrs.module.nemrapps.fragment.controller;

import org.openmrs.Person;
import org.openmrs.PersonAttribute;
import org.openmrs.module.appframework.context.AppContextModel;
import org.openmrs.module.appframework.service.AppFrameworkService;
import org.openmrs.module.appui.UiSessionContext;
import org.openmrs.module.coreapps.CoreAppsProperties;
import org.openmrs.module.emrapi.EmrApiProperties;
import org.openmrs.module.emrapi.adt.AdtService;
import org.openmrs.module.emrapi.patient.PatientDomainWrapper;
import org.openmrs.module.idgen.service.IdentifierSourceService;
import org.openmrs.module.nemrapps.NemrConstants;
import org.openmrs.ui.framework.UiUtils;
import org.openmrs.ui.framework.annotation.FragmentParam;
import org.openmrs.ui.framework.annotation.InjectBeans;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentConfiguration;
import org.openmrs.ui.framework.fragment.FragmentModel;

/**
 * Ideally you pass in a PatientDomainWrapper as the "patient" config parameter. But if you pass in
 * a Patient, then this controller will wrap that for you.
 */
public class PatientHeaderFragmentController extends org.openmrs.module.coreapps.fragment.controller.PatientHeaderFragmentController {
	
	@Override
	public void controller(FragmentConfiguration config, @SpringBean("emrApiProperties") EmrApiProperties emrApiProperties,
	        @SpringBean("coreAppsProperties") CoreAppsProperties coreAppsProperties,
	        @SpringBean("baseIdentifierSourceService") IdentifierSourceService identifierSourceService,
	        @FragmentParam(required = false, value = "appContextModel") AppContextModel appContextModel,
	        @SpringBean("appFrameworkService") AppFrameworkService appFrameworkService,
	        @FragmentParam("patient") Object patient, @InjectBeans PatientDomainWrapper wrapper,
	        @SpringBean("adtService") AdtService adtService, UiSessionContext sessionContext, UiUtils uiUtils,
	        FragmentModel model) {
		
		super.controller(config, emrApiProperties, coreAppsProperties, identifierSourceService, appContextModel,
		    appFrameworkService, patient, wrapper, adtService, sessionContext, uiUtils, model);
		
		// Add required person attribute types.
		Person person = ((PatientDomainWrapper) config.get("patient")).getPatient().getPerson();
		PersonAttribute ethnicity = person.getAttribute(NemrConstants.ETHNICITY);
		PersonAttribute religion = person.getAttribute(NemrConstants.RELIGION);
		PersonAttribute fatherEducation = person.getAttribute(NemrConstants.FATHER_EDUCATION);
		PersonAttribute motherEducation = person.getAttribute(NemrConstants.MOTHER_EDUCATION);
		PersonAttribute fatherOccupation = person.getAttribute(NemrConstants.FATHER_OCCUPATION);
		PersonAttribute familyAnnualIncome = person.getAttribute(NemrConstants.FAMILY_ANNUAL_INCOME);
		PersonAttribute numberOfChildren = person.getAttribute(NemrConstants.NUMBER_OF_CHILDREN);
		PersonAttribute numberOfSiblingsWithSCD = person.getAttribute(NemrConstants.NUMBER_OF_SIBLINGS_WITH_SCD);
		
		// Put them in the configuration.
		config.addAttribute("ethnicity", ethnicity == null ? "" : ethnicity.getValue());
		config.addAttribute("religion", religion == null ? "" : religion.getValue());
		config.addAttribute("fatherEducation", fatherEducation == null ? "" : fatherEducation.getValue());
		config.addAttribute("motherEducation", motherEducation == null ? "" : motherEducation.getValue());
		config.addAttribute("fatherOccupation", fatherOccupation == null ? "" : fatherOccupation.getValue());
		config.addAttribute("familyAnnualIncome", familyAnnualIncome == null ? "" : familyAnnualIncome.getValue());
		config.addAttribute("numberOfChildren", numberOfChildren == null ? "" : numberOfChildren.getValue());
		config.addAttribute("numberOfSiblingsWithSCD",
		    numberOfSiblingsWithSCD == null ? "" : numberOfSiblingsWithSCD.getValue());
	}
	
}
