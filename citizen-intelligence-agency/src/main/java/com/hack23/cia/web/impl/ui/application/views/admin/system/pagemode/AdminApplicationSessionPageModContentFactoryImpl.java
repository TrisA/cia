/*
 * Copyright 2014 James Pether Sörling
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
package com.hack23.cia.web.impl.ui.application.views.admin.system.pagemode;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.hack23.cia.model.internal.application.system.impl.ApplicationActionEvent;
import com.hack23.cia.model.internal.application.system.impl.ApplicationEventGroup;
import com.hack23.cia.model.internal.application.system.impl.ApplicationSession;
import com.hack23.cia.model.internal.application.system.impl.ApplicationSession_;
import com.hack23.cia.service.api.DataContainer;
import com.hack23.cia.web.impl.ui.application.action.ViewAction;
import com.hack23.cia.web.impl.ui.application.views.common.converters.ListPropertyConverter;
import com.hack23.cia.web.impl.ui.application.views.common.labelfactory.LabelFactory;
import com.hack23.cia.web.impl.ui.application.views.common.sizing.ContentRatio;
import com.hack23.cia.web.impl.ui.application.views.common.sizing.ContentSize;
import com.hack23.cia.web.impl.ui.application.views.common.viewnames.AdminViews;
import com.hack23.cia.web.impl.ui.application.views.pageclicklistener.PageItemPropertyClickListener;
import com.vaadin.ui.Layout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Panel;
import com.vaadin.v7.data.util.BeanItem;
import com.vaadin.v7.data.util.BeanItemContainer;
import com.vaadin.v7.ui.HorizontalLayout;
import com.vaadin.v7.ui.VerticalLayout;

/**
 * The Class AdminApplicationSessionPageModContentFactoryImpl.
 */
@Component
public final class AdminApplicationSessionPageModContentFactoryImpl extends AbstractAdminSystemPageModContentFactoryImpl {

	/** The Constant ADMIN_APPLICATION_SESSION. */
	private static final String ADMIN_APPLICATION_SESSION = "Admin Application Session";

	/** The Constant NAME. */
	public static final String NAME = AdminViews.ADMIN_APPLICATIONS_SESSION_VIEW_NAME;

	/**
	 * Instantiates a new admin application session page mod content factory
	 * impl.
	 */
	public AdminApplicationSessionPageModContentFactoryImpl() {
		super();
	}

	@Override
	public boolean matches(final String page, final String parameters) {
		return NAME.equals(page);
	}

	@Secured({ "ROLE_ADMIN" })
	@Override
	public Layout createContent(final String parameters, final MenuBar menuBar, final Panel panel) {
		final VerticalLayout content = createPanelContent();

		final String pageId = getPageId(parameters);
		final int pageNr= getPageNr(parameters);

		getMenuItemFactory().createMainPageMenuBar(menuBar);

		LabelFactory.createHeader2Label(content,ADMIN_APPLICATION_SESSION);

		final DataContainer<ApplicationSession, Long> dataContainer = getApplicationManager()
				.getDataContainer(ApplicationSession.class);


		final BeanItemContainer<ApplicationSession> dataSource = new BeanItemContainer<>(
				ApplicationSession.class, dataContainer.getPageOrderBy(pageNr,DEFAULT_RESULTS_PER_PAGE, ApplicationSession_.createdDate));

		createPagingControls(content,NAME,pageId, dataContainer.getSize(), pageNr, DEFAULT_RESULTS_PER_PAGE);

		getGridFactory().createBasicBeanItemGrid(content, dataSource,
				"ApplicationSession",
				new String[] { "hjid", "createdDate", "sessionType", "userId", "events", "operatingSystem", "locale",
						"ipInformation", "userAgentInformation", "sessionId" }, new String[] { "hjid", "modelObjectId", "modelObjectVersion" ,"userAgentInformation", "sessionId","ipInformation"},
				new PageItemPropertyClickListener(AdminViews.ADMIN_APPLICATIONS_SESSION_VIEW_NAME, "hjid"), null, new ListPropertyConverter[] { new ListPropertyConverter(List.class, "page", "events","actionName")});

		if (pageId != null && !pageId.isEmpty()) {

			final ApplicationSession applicationSession = dataContainer.load(Long.valueOf(pageId));

			if (applicationSession != null) {

				final VerticalLayout rightLayout = new VerticalLayout();
				rightLayout.setSizeFull();
				final HorizontalLayout horizontalLayout = new HorizontalLayout();
				horizontalLayout.setWidth(ContentSize.FULL_SIZE);
				content.addComponent(horizontalLayout);
				content.setExpandRatio(horizontalLayout, ContentRatio.GRID);


				getFormFactory().addFormPanelTextFields(horizontalLayout, new BeanItem<>(applicationSession),
						ApplicationSession.class,
						Arrays.asList(new String[] { "createdDate","sessionType", "userId", "sessionId", "operatingSystem", "locale",
								"ipInformation", "userAgentInformation"}));

				horizontalLayout.addComponent(rightLayout);
				horizontalLayout.setExpandRatio(rightLayout, ContentRatio.GRID);

				final BeanItemContainer<ApplicationActionEvent> eventsItemContainer = new BeanItemContainer<>(
						ApplicationActionEvent.class, applicationSession.getEvents());

				getGridFactory().createBasicBeanItemGrid(rightLayout,
						eventsItemContainer,
						"ApplicationActionEvent",
						new String[] { "hjid", "createdDate", "eventGroup", "actionName", "applicationOperation", "page", "pageMode",
								"elementId", "errorMessage", "applicationMessage",
								"modelObjectVersion" }, new String[] { "hjid", "modelObjectId","modelObjectVersion","userId", "sessionId" },
						new PageItemPropertyClickListener(AdminViews.ADMIN_APPLICATIONS_EVENTS_VIEW_NAME, "hjid"),
						null, null);
			}

		}

		getPageActionEventHelper().createPageEvent(ViewAction.VISIT_ADMIN_APPLICATION_SESSION_VIEW, ApplicationEventGroup.ADMIN,
				NAME, null, pageId);

		return content;

	}

}
