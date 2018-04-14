/*
 * Copyright 2010 James Pether Sörling
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *	$Id$
 *  $HeadURL$
*/
package com.hack23.cia.service.external.esv.api;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The Class GovernmentBodyAnnualOutcomeSummary.
 */
public final class GovernmentBodyAnnualOutcomeSummary {

	/** The goverment body id. */
	private final String govermentBody;

	/** The org number. */
	private final String orgNumber;

	/** The year. */
	private final int year;
	
	public GovernmentBodyAnnualOutcomeSummary(String govermentBody, String orgNumber, int year) {
		super();
		this.govermentBody = govermentBody;
		this.orgNumber = orgNumber;
		this.year = year;
	}

	public String getGovermentBody() {
		return govermentBody;
	}

	public String getOrgNumber() {
		return orgNumber;
	}

	public int getYear() {
		return year;
	}

	@Override
	public boolean equals(final Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
