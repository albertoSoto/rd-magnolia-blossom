package com.deicos.magnolia.blossom.templates.components;

import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.annotation.Template;
import info.magnolia.module.blossom.annotation.TemplateDescription;
import info.magnolia.ui.form.config.OptionBuilder;
import info.magnolia.ui.form.config.SelectFieldBuilder;
import info.magnolia.ui.form.config.TabBuilder;
import info.magnolia.ui.form.config.TwinColSelectFieldBuilder;
import info.magnolia.ui.framework.config.UiConfig;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Template(title = "Datatable BTK (Blossom)", id = "backoffice-magnolia:components/datatable-bltk")
        //, dialog = "backoffice-light-module:components/datatable-btk")   //works!
@TemplateDescription("Datatable with business data")
public class DataTableComponent {
    //protected final Logger log = LoggerFactory.getLogger(this.getClass());
    @TabFactory("Content")
    public void contentTab(UiConfig cfg, TabBuilder tab) {
        SelectFieldBuilder optionField = cfg.fields.select("url").label("Repository");
        optionField.options(new OptionBuilder().label("Employees repository").value("/api/rest/v1/dt/employee.json"));
        /*TwinColSelectFieldBuilder twin = cfg.fields.twinColSelect("order");
        twin.options(new OptionBuilder().label("Name").value("name"));
        twin.options(new OptionBuilder().label("Salary").value("salary"));*/
        tab.fields(
                cfg.fields.text("title").label("Title"),
                optionField,
                cfg.fields.checkbox("enableCustomConfig").defaultValue("true").type("Boolean").description("Check if you want to set  your own table config"),
                cfg.fields.text("columnList").label("Columns").description("Column identifiers separated by comma as appears it server response"),
                cfg.fields.text("labelList").label("Labels").description("Column Labels separated by comma. Uses same column identifier order."),
                cfg.fields.hidden("enableCtx").defaultValue("true").type("Boolean"),
                cfg.fields.hidden("enableAjax").defaultValue("true").type("Boolean")
        );
    }

    @RequestMapping(value = "/datatable-bltk", method = RequestMethod.GET)
    public String viewForm(ModelMap model, HttpSession session, HttpServletRequest request, Node content) {
        try{
            String columns =content.getProperty("columnList").getString();
            String labels= content.getProperty("labelList").getString();
            model.put("customColumns",StringUtils.split(columns,","));
            model.put("customLabels",StringUtils.split(labels,","));
        }catch (Exception e){
            //log.error("Loading dialog data",e);
        }
        return "components/datatable-btk.ftl";
    }

}
