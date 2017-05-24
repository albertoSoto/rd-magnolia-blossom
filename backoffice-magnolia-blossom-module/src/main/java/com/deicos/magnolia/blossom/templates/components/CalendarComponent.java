package com.deicos.magnolia.blossom.templates.components;

import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.annotation.Template;
import info.magnolia.module.blossom.annotation.TemplateDescription;
import info.magnolia.ui.form.config.OptionBuilder;
import info.magnolia.ui.form.config.SelectFieldBuilder;
import info.magnolia.ui.form.config.TabBuilder;
import info.magnolia.ui.form.config.TwinColSelectFieldBuilder;
import info.magnolia.ui.framework.config.UiConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jcr.Node;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * backoffice-magnolia
 * com.deicos.magnolia.blossom.templates.components
 * Created by Alberto Soto Fernandez in 22/05/2017.
 * Description:
 */
@Controller
@Template(title = "Calendar BTK (Blossom)", id = "backoffice-magnolia:components/calendar-bltk")
@TemplateDescription("Calendar with business data")
public class CalendarComponent {

    @TabFactory("Content")
    public void contentTab(UiConfig cfg, TabBuilder tab) {
        SelectFieldBuilder optionField = cfg.fields.select("url").label("Events Repository");
        optionField.options(new OptionBuilder().label("Employees meetings").value("/api/rest/v1/calendar/list.json"));
        TwinColSelectFieldBuilder twin = cfg.fields.twinColSelect("calendarOptions");
        twin.options(new OptionBuilder().label("Activar navegacion").value("navigation"));
        twin.options(new OptionBuilder().label("Activar vista mes").value("month"));
        twin.options(new OptionBuilder().label("Activar vista semana").value("week"));
        twin.options(new OptionBuilder().label("Activar vista dia").value("day"));
        tab.fields(
                cfg.fields.text("title").label("Title"),
                optionField,
                twin,
                cfg.fields.hidden("enableCtx").defaultValue("true").type("Boolean")
        );
    }

    @RequestMapping(value = "/calendar-bltk", method = RequestMethod.GET)
    public String viewForm(ModelMap model, HttpSession session, HttpServletRequest request, Node content) {
        return "components/fullcalendar-btk.ftl";
    }
}
