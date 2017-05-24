package com.deicos.magnolia.blossom.config;

/*

TODO: Asoto It breaks the rendering process and blossom components do not work.
Is mandatory setting it up by xml config, or place it outside of com.deicos.magnolia.blossom

@Configuration
@ComponentScan(basePackages = {"com.deicos.magnolia.spring"})
@EnableWebMvc*/
public class BackofficeMvcConfig /*extends WebMvcConfigurerAdapter */{
    /*
         * Configure ContentNegotiationManager
         */
    /*@Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.ignoreAcceptHeader(true).defaultContentType(
                MediaType.APPLICATION_JSON);
    }

    *//*
         * Configure ContentNegotiatingViewResolver
         *//*
    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        List<ViewResolver> resolver = new ArrayList<ViewResolver>();
*//*
        InternalResourceViewResolver r1 = new InternalResourceViewResolver();
        r1.setPrefix("/WEB-INF/pages/");
        r1.setSuffix(".jsp");
        r1.setViewClass(JstlView.class);
        resolver.add(r1);
*//*
        JsonViewResolver r2 = new JsonViewResolver();
        resolver.add(r2);

        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setViewResolvers(resolver);
        resolver.setContentNegotiationManager(manager);

        return resolver;
    }

    *//*
     * Configure View resolver to provide JSON output using JACKSON library to
     * convert object in JSON format.
     *//*
    @Bean
    public ViewResolver jsonViewResolver() {
        return new JsonViewResolver();
    }

    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping mapping = new RequestMappingHandlerMapping();
        // add properties here
        return mapping;
    }

    @Bean
    public WebMvcConfigurer CORSConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/spring/v1*//**");
            }
        };
    }*/

}
