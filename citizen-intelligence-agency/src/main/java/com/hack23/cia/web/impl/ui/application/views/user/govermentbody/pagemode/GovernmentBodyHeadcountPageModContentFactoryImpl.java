/*
 * Copyright 2010-2021 James Pether Sörling
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
package com.hack23.cia.web.impl.ui.application.views.user.govermentbody.pagemode;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.hack23.cia.model.internal.application.system.impl.ApplicationEventGroup;
import com.hack23.cia.service.external.esv.api.GovernmentBodyAnnualSummary;
import com.hack23.cia.web.impl.ui.application.action.ViewAction;
import com.hack23.cia.web.impl.ui.application.views.common.chartfactory.api.GovernmentBodyChartDataManager;
import com.hack23.cia.web.impl.ui.application.views.common.labelfactory.LabelFactory;
import com.hack23.cia.web.impl.ui.application.views.common.viewnames.GovernmentBodyPageMode;
import com.vaadin.ui.Layout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 * The Class GovernmentBodyHeadcountPageModContentFactoryImpl.
 */
@Component
public final class GovernmentBodyHeadcountPageModContentFactoryImpl extends AbstractGovernmentBodyPageModContentFactoryImpl {

	/** The Constant GOVERNMENT_BODIES. */
	private static final String GOVERNMENT_BODIES = "Government bodies";

	/** The Constant GOVERNMENT_BODY. */
	private static final String GOVERNMENT_BODY = "GovernmentBody:";

	/** The government body chart data manager. */
	@Autowired
	private GovernmentBodyChartDataManager governmentBodyChartDataManager;

	/**
	 * Instantiates a new government body headcount page mod content factory impl.
	 */
	public GovernmentBodyHeadcountPageModContentFactoryImpl() {
		super();
	}

	@Secured({ "ROLE_ANONYMOUS", "ROLE_USER", "ROLE_ADMIN" })
	@Override
	public Layout createContent(final String parameters, final MenuBar menuBar, final Panel panel) {
		final VerticalLayout panelContent = createPanelContent();

		final String pageId = getPageId(parameters);
		final List<GovernmentBodyAnnualSummary> list = getItem(parameters);

		if (list != null && !list.isEmpty()) {
			final Optional<GovernmentBodyAnnualSummary> governmentBodyAnnualSummary = list.stream().findFirst();

			if (governmentBodyAnnualSummary.isPresent()) {
				getGovernmentBodyMenuItemFactory().createGovernmentBodyMenuBar(menuBar, pageId);
				LabelFactory.createHeader2Label(panelContent,GOVERNMENT_BODIES);
				governmentBodyChartDataManager.createGovernmentBodyHeadcountSummaryChart(panelContent, governmentBodyAnnualSummary.get().getName());
				panel.setCaption(NAME + "::" + GOVERNMENT_BODY + governmentBodyAnnualSummary.get().getName());
			}
			getPageActionEventHelper().createPageEvent(ViewAction.VISIT_MINISTRY_VIEW, ApplicationEventGroup.USER, NAME,
					parameters, pageId);

		}

		return panelContent;

	}

	@Override
	public boolean matches(final String page, final String parameters) {
		return NAME.equals(page) && StringUtils.contains(parameters, GovernmentBodyPageMode.HEADCOUNT.toString());
	}

}
