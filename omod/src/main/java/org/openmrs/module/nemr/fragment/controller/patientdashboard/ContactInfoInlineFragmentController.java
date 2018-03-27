package org.openmrs.module.nemr.fragment.controller.patientdashboard;

import org.openmrs.Person;
import org.openmrs.PersonAttribute;
import org.openmrs.PersonAttributeType;
import org.openmrs.api.PersonService;
import org.openmrs.api.context.Context;
import org.openmrs.module.emrapi.patient.PatientDomainWrapper;
import org.openmrs.ui.framework.annotation.InjectBeans;
import org.openmrs.ui.framework.fragment.FragmentConfiguration;

public class ContactInfoInlineFragmentController extends org.openmrs.module.coreapps.fragment.controller.patientdashboard.ContactInfoInlineFragmentController {
	
	// TODO: Make this a global property or something else easily configurable.
	private static final String ALTERNATIVE_PHONES_UUID = "4b01cce2-a56b-44ad-b6dd-68cc31127e93";
	
	private static final String NEIGHBOR_NAME_UUID = "12048766-d478-4f31-b9e1-88630198b1c1";
	
	private static final String NEIGHBOR_PHONE_NUMBER_UUID = "57963f24-9127-499f-86fe-dd8b87110b19";
	
	public void controller(FragmentConfiguration config, @InjectBeans PatientDomainWrapper wrapper) {
		
		super.controller(config, wrapper);
		
		PersonService personService = Context.getPersonService();
		
		// Get the alternative phone numbers.
		Person person = ((PatientDomainWrapper) config.get("patient")).getPatient().getPerson();
		PersonAttributeType altPhonesType = personService.getPersonAttributeTypeByUuid(ALTERNATIVE_PHONES_UUID);
		PersonAttributeType neighborNameType = personService.getPersonAttributeTypeByUuid(NEIGHBOR_NAME_UUID);
		PersonAttributeType neighborPhoneNumberType = personService.getPersonAttributeTypeByUuid(NEIGHBOR_PHONE_NUMBER_UUID);
		
		PersonAttribute altPhones = altPhonesType == null ? null : person.getAttribute(altPhonesType);
		PersonAttribute neighborName = neighborNameType == null ? null : person.getAttribute(neighborNameType);
		PersonAttribute neighborPhoneNumbers = neighborPhoneNumberType == null ? null : person
		        .getAttribute(neighborPhoneNumberType);
		
		config.addAttribute("altPhoneNumbers", altPhones != null ? altPhones.getValue() : "");
		config.addAttribute("neighborName", neighborName != null ? neighborName.getValue() : "");
		config.addAttribute("neighborPhoneNumbers", neighborPhoneNumbers != null ? neighborPhoneNumbers.getValue() : "");
		config.addAttribute("patientId", person.getUuid());
	}
}
