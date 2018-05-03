package org.openmrs.module.nemrapps.fragment;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.ui.framework.fragment.FragmentRequest;
import org.openmrs.ui.framework.fragment.FragmentRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class NemrRequestMapper implements FragmentRequestMapper {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	/**
	 * Implementations should call {@link FragmentRequest#setProviderNameOverride(String)} and
	 * {@link FragmentRequest#setFragmentIdOverride(String)}, and return true if they want to remap
	 * a request, or return false if they didn't remap it.
	 * 
	 * @param request may have its providerNameOverride and pageNameOverride set
	 * @return true if this page was mapped (by overriding the provider and/or page), false
	 *         otherwise
	 */
	public boolean mapRequest(FragmentRequest request) {
		log.info("Incoming: " + request);
		if (request.getProviderName().equals("coreapps")) {
			if (request.getFragmentId().equals("contactInfo")) {
				request.setProviderNameOverride("referenceapplication.registrationapp.nigeria");
				log.info("Mapped To: " + request);
				return true;
			}
		}
		if (request.getProviderName().equals("coreapps")) {
			if (request.getFragmentId().equals("patientdashboard/contactInfoInline")) {
				request.setProviderNameOverride("nemrapps");
				log.info("Mapped To: " + request);
				return true;
			}
		}
		return false;
	}
	
}
