package org.openmrs.module.nemrapps.page;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.ui.framework.page.PageRequest;
import org.openmrs.ui.framework.page.PageRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class NemrPageRequestMapper implements PageRequestMapper {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	/**
	 * Implementations should call {@link PageRequest#setProviderNameOverride(String)} and
	 * {@link PageRequest#setPageNameOverride(String)}, and return true if they want to remap a
	 * request, or return false if they didn't remap it.
	 * 
	 * @param pageRequest may have its providerNameOverride and pageNameOverride set
	 * @return true if this page was mapped (by overriding the provider and/or page), false
	 *         otherwise
	 */
	@Override
	public boolean mapRequest(PageRequest pageRequest) {
		
		if (pageRequest.getProviderName().equals("coreapps") && pageRequest.getPageName().equals("clinicianfacing/patient")) {
			pageRequest.setProviderNameOverride("nemrapps");
			log.info("Mapped To: " + pageRequest);
			return true;
		}
		return false;
	}
}
