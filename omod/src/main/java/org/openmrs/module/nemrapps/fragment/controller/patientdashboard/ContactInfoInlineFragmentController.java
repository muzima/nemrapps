package org.openmrs.module.nemrapps.fragment.controller.patientdashboard;

import org.openmrs.Person;
import org.openmrs.PersonAttribute;
import org.openmrs.PersonAttributeType;
import org.openmrs.api.PersonService;
import org.openmrs.api.context.Context;
import org.openmrs.module.emrapi.patient.PatientDomainWrapper;
import org.openmrs.module.nemrapps.NemrConstants;
import org.openmrs.ui.framework.annotation.InjectBeans;
import org.openmrs.ui.framework.fragment.FragmentConfiguration;

public class ContactInfoInlineFragmentController extends org.openmrs.module.coreapps.fragment.controller.patientdashboard.ContactInfoInlineFragmentController {
	public void controller(FragmentConfiguration config, @InjectBeans PatientDomainWrapper wrapper) {
		
		super.controller(config, wrapper);
		
		PersonService personService = Context.getPersonService();
		
		// Get the alternative phone numbers.
		Person person = ((PatientDomainWrapper) config.get("patient")).getPatient().getPerson();
		PersonAttributeType altPhonesType = personService.getPersonAttributeTypeByUuid(NemrConstants.ALTERNATIVE_PHONES_UUID);
		PersonAttributeType neighborNameType = personService.getPersonAttributeTypeByUuid(NemrConstants.NEIGHBOR_NAME_UUID);
		PersonAttributeType neighborPhoneNumberType = personService.getPersonAttributeTypeByUuid(NemrConstants.NEIGHBOR_PHONE_NUMBER_UUID);
		
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
