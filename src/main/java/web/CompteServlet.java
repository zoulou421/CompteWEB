package web;

import java.io.IOException;
import java.util.Date;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.entities.Compte;
import metier.session.ICompteLocal;

@WebServlet("/compte")
public class CompteServlet extends HttpServlet{
	
	@EJB
	private ICompteLocal metier;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getParameter("action");
        if(!action.equals(null)) {
        	if(action.equals("delete")) {
    			Long code=Long.parseLong(req.getParameter("code"));
    			metier.supprimerCompte(code);

            }
        }
		
		req.setAttribute("list_ejb", metier.getAllComptes());
		req.getRequestDispatcher("compte.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getParameter("action");
		
		if(action.equals("Verser")) {
			Long code=Long.parseLong(req.getParameter("code1"));
			double montant=Double.parseDouble(req.getParameter("montant"));
			metier.verser(montant, code);
		}else if(action.equals("Retirer")) {
			Long code=Long.parseLong(req.getParameter("code1"));
			double montant=Double.parseDouble(req.getParameter("montant"));
			metier.retirer(montant, code);
		}else if(action.equals("Virement")) {
			Long code1=Long.parseLong(req.getParameter("code1"));
			Long code2=Long.parseLong(req.getParameter("code2"));
			double montant=Double.parseDouble(req.getParameter("montant"));
            metier.virement(montant, code1, code2);

		}else if(action.equals("Ajouter")) {
			metier.addCompte(new Compte(0,new Date(),true));

		}else {
			System.out.println("Something went wrong!");
		}
		
		req.setAttribute("list_ejb", metier.getAllComptes());
		req.getRequestDispatcher("compte.jsp").forward(req, resp);
		
	}
}












