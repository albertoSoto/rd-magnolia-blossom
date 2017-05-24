package com.deicos.magnolia.blossom.templates.components;

import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.annotation.Template;
import info.magnolia.module.blossom.annotation.TemplateDescription;
import info.magnolia.ui.form.config.OptionBuilder;
import info.magnolia.ui.form.config.SelectFieldBuilder;
import info.magnolia.ui.form.config.TabBuilder;
import info.magnolia.ui.framework.config.UiConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@Template(title = "Highcharts BTK (Blossom)", id = "backoffice-magnolia:components/highchart-bltk")
@TemplateDescription("Highcarts with business data")
public class HighchartComponent {

    @TabFactory("Content")
    public void contentTab(UiConfig cfg, TabBuilder tab) {
        SelectFieldBuilder optionField = cfg.fields.select("url").label("Stats Repository");
        optionField.options(new OptionBuilder().label("Employees salary").value("/api/rest/v1/stats/salary.json"));
        tab.fields(
                cfg.fields.text("title").label("Title"),
                cfg.fields.text("subtitle").label("Subtitle"),
                cfg.fields.text("yaxisLabel").label("Vertical Label (Y Axis)"),
                optionField
                //cfg.fields.text("xaxisLabel").label("Horizontal Label (X Axis)")
        );
    }

    @RequestMapping(value = "/highchart-bltk", method = RequestMethod.GET)
    public String viewForm(ModelMap model, HttpSession session, HttpServletRequest request, Node content) {
        //model.put("shoppingCart", shoppingCart);
        return "components/highchart-btk.ftl";
    }
}
