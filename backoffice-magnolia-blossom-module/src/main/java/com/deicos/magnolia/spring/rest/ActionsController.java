package com.deicos.magnolia.spring.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * backoffice-magnolia
 * com.deicos.magnolia.spring
 * Created by Alberto Soto Fernandez in 21/05/2017.
 * Description:
 *
 * To be done: Future container to create a method for listing crud actions and manage automatic containers
 *
 */
@RestController
@RequestMapping("/actions")
public class ActionsController {
/*
 Not able to autowire to check all actions
    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;
*/

    @RequestMapping(path = "/list", method = RequestMethod.GET , headers = "Accept=*/*")
    public ResponseEntity<List<String>> getActions(HttpServletRequest request, HttpServletResponse response){
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        List<String> nodeList = new ArrayList<>();
        nodeList.add("to be done");
        /* TODO 21/05/2017 Asoto: Make this return all mappings inside this servlet to list actions properly
        ServletContext servletContext = request.getSession().getServletContext();
        WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        Map<String, HandlerMapping> allRequestMappings = BeanFactoryUtils.beansOfTypeIncludingAncestors(appContext, HandlerMapping.class, true, false);
        for (HandlerMapping handlerMapping : allRequestMappings.values()) {
            if (handlerMapping instanceof RequestMappingHandlerMapping) {
                RequestMappingHandlerMapping requestMappingHandlerMapping = (RequestMappingHandlerMapping) handlerMapping;
                Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
                for (Map.Entry<RequestMappingInfo, HandlerMethod> requestMappingInfoHandlerMethodEntry : handlerMethods.entrySet()) {
                    RequestMappingInfo requestMappingInfo = requestMappingInfoHandlerMethodEntry.getKey();
                    PatternsRequestCondition patternsCondition = requestMappingInfo.getPatternsCondition();
                    nodeList.add(patternsCondition.toString());
                    //String requestUrl = SetUtils.first(patternsCondition.getPatterns());
                    //System.out.println(requestUrl);
                }
            }
        }
        */
        return new ResponseEntity<>(nodeList, httpHeaders, HttpStatus.OK);
    }
}
