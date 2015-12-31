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
package com.hack23.cia.web.impl.ui.application.views.admin.system;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hack23.cia.model.internal.application.system.impl.ApplicationEventGroup;
import com.hack23.cia.model.internal.application.system.impl.LanguageContentData;
import com.hack23.cia.service.api.ApplicationManager;
import com.hack23.cia.service.api.DataContainer;
import com.hack23.cia.web.impl.ui.application.action.ViewAction;
import com.hack23.cia.web.impl.ui.application.views.admin.common.AbstractAdminView;
import com.hack23.cia.web.impl.ui.application.views.common.formfactory.FormFactory;
import com.hack23.cia.web.impl.ui.application.views.common.gridfactory.GridFactory;
import com.hack23.cia.web.impl.ui.application.views.common.labelfactory.LabelFactory;
import com.hack23.cia.web.impl.ui.application.views.common.viewnames.AdminViews;
import com.hack23.cia.web.impl.ui.application.views.pageclicklistener.PageItemPropertyClickListener;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

import ru.xpoft.vaadin.VaadinView;

/**
 * The Class AdminDataSummaryView.
 */
@Service
@Scope("prototype")
@VaadinView(AdminLanguageContentView.NAME)
public final class AdminLanguageContentView extends AbstractAdminView {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant NAME. */
	public static final String NAME = AdminViews.ADMIN_LANGUAGE_CONTENT_VIEW_NAME;

	/** The application manager. */
	@Autowired
	@Qualifier("ApplicationManager")
	private transient ApplicationManager applicationManager;

	/** The grid factory. */
	@Autowired
	private transient GridFactory gridFactory;

	/** The form factory. */
	@Autowired
	private transient FormFactory formFactory;

	/**
	 * Post construct.
	 */
	@PostConstruct
	public void postConstruct() {
		createListAndForm(null);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener.
	 * ViewChangeEvent)
	 */
	@Override
	public void enter(final ViewChangeEvent event) {
		final String parameters = event.getParameters();

		if (parameters != null) {
			createListAndForm(parameters.substring(parameters.lastIndexOf('/') + "/".length(), parameters.length()));
		}
	}

	/**
	 * Creates the list and form.
	 *
	 * @param pageId
	 *            the page id
	 */
	private void createListAndForm(final String pageId) {
		final VerticalLayout content = new VerticalLayout();

		content.addComponent(LabelFactory.createHeader2Label("Admin Language Content"));

		final DataContainer<LanguageContentData, Long> dataContainer = applicationManager.getDataContainer(LanguageContentData.class);

		final BeanItemContainer<LanguageContentData> politicianDocumentDataSource = new BeanItemContainer<LanguageContentData>(LanguageContentData.class,
				dataContainer.getAll());

		content.addComponent(gridFactory.createBasicBeanItemGrid(politicianDocumentDataSource, "LanguageContentData",
				new String[] { "hjid", "languageContentType","refKey","fromLanguage", "toLanguage", "createdDate", "languageValue","modelObjectVersion" },
				new String[] { "modelObjectId" }, "hjid",
				new PageItemPropertyClickListener(AdminViews.ADMIN_LANGUAGE_CONTENT_VIEW_NAME, "hjid"), null));

		if (pageId != null && !pageId.isEmpty()) {

			final LanguageContentData languageContentData = dataContainer.load(Long.valueOf(pageId));

			formFactory.addTextFields(content, new BeanItem<LanguageContentData>(languageContentData), LanguageContentData.class,
					Arrays.asList(new String[] { "hjid","refKey","fromLanguage", "toLanguage", "createdDate", "languageValue","modelObjectVersion" }));

		}

		content.addComponent(pageLinkFactory.createMainViewPageLink());

		setContent(content);
		pageActionEventHelper.createPageEvent(ViewAction.VISIT_ADMIN_LANGUAGE_CONTENT_VIEW, ApplicationEventGroup.ADMIN, NAME, null, pageId);

	}
}
