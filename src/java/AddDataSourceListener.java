
import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Web application lifecycle listener.
 *
 * @author Chronical
 */
public class AddDataSourceListener implements ServletContextListener {

        @Resource(name = "project")
    private DataSource project;
        
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("dataSource", project);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
