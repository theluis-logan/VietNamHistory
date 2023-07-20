package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class quiz_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Quiz</title>\n");
      out.write("        <link href=\"css/reset.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/header.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/home.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/quiz.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("            <div id=\"quiz\" class=\"container\">\n");
      out.write("\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "left.jsp", out, false);
      out.write("\n");
      out.write("            <div class =\"right\">\n");
      out.write("                <form action=\"teststart\" method=\"post\">\n");
      out.write("                    <div class=\"form--field\">\n");
      out.write("                        <p class=\"form--text\">This quiz will give you randomly quiz of Viet Nam History</p>\n");
      out.write("                        <label for=\"numOfQuestion\" class=\"form--label\">Enter number of questions: </label>\n");
      out.write("                        <input type=\"number\" name=\"numOfQuestion\" id=\"numOfQuestion\" class=\"form--input\" >\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <br>\n");
      out.write("                    <input type=\"submit\" value=\"Start attempt\" class=\"form--btn\">\n");
      out.write("                </form>\n");
      out.write("                <div id=\"form--test\">\n");
      out.write("                    <form class=\"form--test__card\" >\n");
      out.write("                        <p class=\"test--card__question\">...</p>\n");
      out.write("                        <div class=\"test--card__answer\">\n");
      out.write("                            <input id=\"ans1\" name=\"q1\" type=\"radio\" value=\"1\">\n");
      out.write("                            <label for=\"ans1\" class=\"test--card__label\">A...</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"test--card__answer\">\n");
      out.write("                            <input id=\"ans2\" name=\"q1\" type=\"radio\" value=\"1\">\n");
      out.write("                            <label for=\"ans2\" class=\"test--card__label\">A...</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"test--card__answer\">\n");
      out.write("                            <input id=\"ans3\" name=\"q1\" type=\"radio\" value=\"1\">\n");
      out.write("                            <label for=\"ans3\" class=\"test--card__label\">A...</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"test--card__answer\">\n");
      out.write("                            <input id=\"ans4\" name=\"q1\" type=\"radio\" value=\"1\">\n");
      out.write("                            <label for=\"ans4\" class=\"test--card__label\">A...</label>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                    <button type=\"button\" onclick=\"submitAllForm()\">Finish attempt</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
