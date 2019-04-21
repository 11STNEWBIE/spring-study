/*
 * Copyright (c) 2019.
 * Made by jjwonyop
 */

// FINAL
package com.springrecipes.ch03.ch031.court.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ExtensionInterceptor extends HandlerInterceptorAdapter {

    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           //Model model) throws Exception {
                           ModelAndView modelAndView) throws Exception {
        // Report date is present in request
        String reportName = null;
        String reportDate = request.getQueryString().replace("date=", "").replace("-", "_");
        if (request.getServletPath().endsWith(".pdf")) {
            reportName = "ReservationSummary_" + reportDate + ".pdf";
        }
        if (request.getServletPath().endsWith(".xls")) {
            reportName = "ReservationSummary_" + reportDate + ".xls";
        }
        // ONLY if its a PDF or XLS extension rewrite response URL
        // If reportName name was modified, its PDF or XLS
        if (reportName != null) {
            // Set "Content-Disposition" HTTP Header so a user gets a pretty 'Save as' address
            response.setHeader("Content-Disposition", "attachment; filename=" + reportName);
        }
    }
}
