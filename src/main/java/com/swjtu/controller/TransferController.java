package com.swjtu.controller;

import com.swjtu.lang.LANG;
import com.swjtu.querier.Querier;
import com.swjtu.trans.AbstractTranslator;
import com.swjtu.trans.impl.GoogleTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TransferController {
    @Autowired
    private GoogleTranslator googleTranslator;

    private Querier<AbstractTranslator> querier = new Querier<>();

    @RequestMapping("/transfer")
    @ResponseBody
    public Map<String, String> transfer(String text) {
        querier.setParams(LANG.EN, LANG.ZH, text);
        querier.attach(googleTranslator);
        return new HashMap<String, String>() {{
            put("text", querier.execute().get(0));
        }};
    }

    @RequestMapping("/test")
    public void testMore() {
        String[] s = new String[]{
                "If you have been using the Spring Framework for some time, you will be aware that Spring has just undergone a major revision.",
                "This revision includes a host of new features, and a lot of the existing functionality has been reviewed and improved.",
                "In fact, so much of Spring is shiny and improved that the Spring development team decided that the next release of Spring merited an increment of the version number; and so Spring 2.0 was announced in December 2005 at the Spring Experience conference in Florida.",
                "This chapter is a guide to the new and improved features of Spring 2.0. It is intended to provide a high-level summary so that seasoned Spring architects and developers can become immediately familiar with the new Spring 2.0 functionality.",
                "For more in-depth information on the features, please refer to the corresponding sections hyperlinked from within this chapter.\n",
                "Some of the new and improved functionality described below has been (or will be) backported into the Spring 1.2.x release line.",
                "Please do consult the changelogs for the 1.2.x releases to see if a feature has been backported.",
                "One of the areas that contains a considerable number of 2.0 improvements is Spring's IoC container.",
                "Spring XML configuration is now even easier, thanks to the advent of the new XML configuration syntax based on XML Schema. ",
                "If you want to take advantage of the new tags that Spring provides (and the Spring team certainly suggest that you do because they make configuration less verbose and easier to read), then do read the section entitled Appendix A, XML Schema-based configuration.",
                "On a related note, there is a new, updated DTD for Spring 2.0 that you may wish to reference if you cannot take advantage of the XML Schema-based configuration.",
                "he DOCTYPE declaration is included below for your convenience, but the interested reader should definitely read the 'spring-beans-2.0.dtd' DTD included in the 'dist/resources' directory of the Spring 2.0 distribution.",
                "Previous versions of Spring had IoC container level support for exactly two distinct bean scopes (singleton and prototype). Spring 2.0 improves on this by not only providing a number of additional scopes depending on the environment in which Spring is being deployed (for example, request and session scoped beans in a web environment), but also by providing integration points so that Spring users can create their own scopes.",
                "It should be noted that although the underlying (and internal) implementation for singleton- and prototype-scoped beans has been changed, this change is totally transparent to the end user... no existing configuration needs to change, and no existing configuration will break.需要注意的是，虽然单例和原",
                "Both the new and the original scopes are detailed in the section entitled Section 3.4, “Bean scopes”.",
                "Not only is XML configuration easier to write, it is now also extensible.",
                "What 'extensible' means in this context is that you, as an application developer, or (more likely) as a third party framework or product vendor",
                "can write custom tags that other developers can then plug into their own Spring configuration files.",
                "Implementing custom Spring tags may not be of interest to every single application developer or enterprise architect using Spring in their own projects.",
                "We expect third-party vendors to be highly interested in developing custom configuration tags for use in Spring configuration files.",
                "The extensible configuration mechanism is documented in Appendix B, Extensible XML authoring.",
        };
        for (String s1 : s) {
            querier.setParams(LANG.EN, LANG.ZH, s1);
            querier.attach(googleTranslator);
            System.out.println(querier.execute().get(0));
        }

    }
}
