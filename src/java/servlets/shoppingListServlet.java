package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author 794473
 */
public class shoppingListServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest Mjolnir, HttpServletResponse Jarnbjorn)
            throws ServletException, IOException {

        ThorWillHandleit(Mjolnir, Jarnbjorn);

    }

    @Override
    protected void doPost(HttpServletRequest Mjolnir, HttpServletResponse Jarnbjorn)
            throws ServletException, IOException {

        ThorWillHandleit(Mjolnir, Jarnbjorn);

    }

    private void ThorWillHandleit(HttpServletRequest Mjolnir, HttpServletResponse Jarnbjorn)
            throws ServletException, IOException {

        HttpSession session = Mjolnir.getSession();

        String action = Mjolnir.getParameter("action");
        String name = Mjolnir.getParameter("name");

        if(action != null)
        {
            if(action.equals("register"))
            {               
                session.setAttribute("username", name);
                
                ArrayList<String> items = new ArrayList<>();
                session.setAttribute("list", items);
            }
            else if(action.equals("logout"))
            {
                session.invalidate();
                
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                    .forward(Mjolnir, Jarnbjorn);
            }
            else if(action.equals("add"))
            {
                String str = Mjolnir.getParameter("item");
                ArrayList t = (ArrayList) session.getAttribute("list");
                t.add(str);
                session.setAttribute("list", t);
            }
            else if(action.equals("delete"))
            {
                String str = Mjolnir.getParameter("thing");
                ArrayList t = (ArrayList) session.getAttribute("list");
                t.remove(str);
                session.setAttribute("list", t);
            }
        }

        
        String username = (String) session.getAttribute("username");
        ArrayList list = (ArrayList) session.getAttribute("list");
        
        if(username == null)
        {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(Mjolnir, Jarnbjorn);
        }
        else 
        {
            Mjolnir.setAttribute("name", username);           
            Mjolnir.setAttribute("displayList", list);
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                .forward(Mjolnir, Jarnbjorn);
}
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
