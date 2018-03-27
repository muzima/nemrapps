package org.openmrs.module.nemr.fragment.controller;

import org.openmrs.module.appframework.context.AppContextModel;
import org.openmrs.module.appframework.service.AppFrameworkService;
import org.openmrs.module.appui.UiSessionContext;
import org.openmrs.module.coreapps.CoreAppsProperties;
import org.openmrs.module.emrapi.EmrApiProperties;
import org.openmrs.module.emrapi.adt.AdtService;
import org.openmrs.module.emrapi.patient.PatientDomainWrapper;
import org.openmrs.module.idgen.service.IdentifierSourceService;
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
		
	}
	
}
