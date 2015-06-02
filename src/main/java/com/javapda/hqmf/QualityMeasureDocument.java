package com.javapda.hqmf;

public interface QualityMeasureDocument {
	String getMeasureIdentifier();

	String getNqf();

	String getDescription();

	String getCodeDisplayName();

	String getVersionNumber();

	String getVersionSpecificIdentifier();

	String getVersionNeutralIdentifier();

	String getNumeratorGuid();

	String getDenominatorGuid();

	String getDenominatorExclusionsGuid();

	String getDenominatorExceptionsGuid();

	String getSupplementalFields();

	String getEthnicityGuid();

	String getRaceGuid();

	String getSexGuid();

	String getPayerGuid();

}
