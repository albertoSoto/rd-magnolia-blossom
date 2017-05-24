package com.deicos.magnolia.resolver;
import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
/**
 * backoffice-magnolia
 * com.deicos.magnolia.resolver
 * Created by Alberto Soto Fernandez in 22/05/2017.
 * Description:
 */
public class PdfViewResolver implements ViewResolver{

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        PdfView view = new PdfView();
        //return view;
        return null;
    }
}
