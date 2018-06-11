package org.openmrs.module.nemrapps;

import org.openmrs.PersonAttributeType;
import org.openmrs.api.PersonService;
import org.openmrs.api.context.Context;

/**
 * Created by Willa aka Baba Imu on 6/11/18.
 */
public class NemrConstants {
	
	/********* PERSON ATTRIBUTE TYPES UUIDs *************************************************************/
	// TODO: Make these global properties or something else easily configurable.
	public static final String ALTERNATIVE_PHONES_UUID = "4b01cce2-a56b-44ad-b6dd-68cc31127e93";
	
	public static final String NEIGHBOR_NAME_UUID = "12048766-d478-4f31-b9e1-88630198b1c1";
	
	public static final String NEIGHBOR_PHONE_NUMBER_UUID = "57963f24-9127-499f-86fe-dd8b87110b19";
	
	public static final String ETHNICITY_UUID = "b010804e-acbe-4142-83bf-ad24c283d557";
	
	public static final String RELIGION_UUID = "f502804e-4be1-44ea-8ce6-ac851fe5b000";
	
	public static final String FATHER_EDUCATION_UUID = "19f4d331-0230-4fa1-8512-86fb0edde618";
	
	public static final String MOTHER_EDUCATION_UUID = "1c27d249-91e9-4e07-97d1-7561125f7f7d";
	
	public static final String FATHER_OCCUPATION_UUID = "ad7926b2-546d-4220-9642-13e4fa3c6363";
	
	public static final String FAMILY_ANNUAL_INCOME_UUID = "f72c0279-1fcd-481e-adb3-8bd5b417d36f";
	
	public static final String NUMBER_OF_CHILDREN_UUID = "30e17fcd-ff3f-4ff8-9ed8-ebb9a59e55fc";
	
	public static final String NUMBER_OF_SIBLINGS_WITH_SCD_UUID = "25c3ec34-856c-43bd-963c-23a084821062";
	
	/****************** END OF PERSON ATTRIBUTE TYPES UUIDs *******************************************************/
	
	/************************************************************************************************
	 * PERSON ATTRIBUTE TYPE INSTANCES 																*
	 ************************************************************************************************/
	public static final PersonAttributeType ETHNICITY;
	
	public static final PersonAttributeType RELIGION;
	
	public static final PersonAttributeType FATHER_EDUCATION;
	
	public static final PersonAttributeType MOTHER_EDUCATION;
	
	public static final PersonAttributeType FATHER_OCCUPATION;
	
	public static final PersonAttributeType FAMILY_ANNUAL_INCOME;
	
	public static final PersonAttributeType NUMBER_OF_CHILDREN;
	
	public static final PersonAttributeType NUMBER_OF_SIBLINGS_WITH_SCD;
	
	static {
		PersonService personService = Context.getPersonService();
		ETHNICITY = personService.getPersonAttributeTypeByUuid(ETHNICITY_UUID);
		RELIGION = personService.getPersonAttributeTypeByUuid(RELIGION_UUID);
		FATHER_EDUCATION = personService.getPersonAttributeTypeByUuid(FATHER_EDUCATION_UUID);
		MOTHER_EDUCATION = personService.getPersonAttributeTypeByUuid(MOTHER_EDUCATION_UUID);
		FATHER_OCCUPATION = personService.getPersonAttributeTypeByUuid(FATHER_OCCUPATION_UUID);
		FAMILY_ANNUAL_INCOME = personService.getPersonAttributeTypeByUuid(FAMILY_ANNUAL_INCOME_UUID);
		NUMBER_OF_CHILDREN = personService.getPersonAttributeTypeByUuid(NUMBER_OF_CHILDREN_UUID);
		NUMBER_OF_SIBLINGS_WITH_SCD = personService.getPersonAttributeTypeByUuid(NUMBER_OF_SIBLINGS_WITH_SCD_UUID);
	}
}
