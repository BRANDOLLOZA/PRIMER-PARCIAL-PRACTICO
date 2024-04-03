package com.emergentes.controlador;

import com.emergentes.modelo.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String op = request.getParameter("op");
        Persona objper = new Persona();
        int id, pos;
        
        HttpSession ses = request.getSession();
        ArrayList<Persona> lista = (ArrayList<Persona>)ses.getAttribute("listaper");
        
        switch (op) {
            case "nuevo":
                //Enviar un objeto vacio a editar
                request.setAttribute("miobjper",objper);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "editar":
                //Enviar un objeto a editar pero con contenido
                id = Integer.parseInt(request.getParameter("id"));
                //
                pos = buscarPorIndice(request,id);
                //
                objper = lista.get(pos);
                request.setAttribute("miobjper", objper);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "eliminar":
                //Eliminar reg.
                id = Integer.parseInt(request.getParameter("id"));
                 //
                pos = buscarPorIndice(request,id);
                if (pos>=0) {
                    lista.remove(pos);                   
                }
                request.setAttribute("listaper", lista);
                response.sendRedirect("index.jsp");                
                break;
            default:
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        HttpSession ses = request.getSession();
        ArrayList<Persona> lista = (ArrayList<Persona>)ses.getAttribute("listaper");
        Persona objper = new Persona();
        objper.setId(id);
        objper.setNombres(request.getParameter("nombres"));
        objper.setP1(Integer.parseInt(request.getParameter("P1")));
        objper.setP2(Integer.parseInt(request.getParameter("P2")));
        objper.setP3(Integer.parseInt(request.getParameter("P3")));
        // Sumar las notas
         // Calcula la nota sumando P1, P2 y P3
        int nota = objper.getP1() + objper.getP2() + objper.getP3();
        objper.setNota(nota);
        
        if (id == 0) {
            //new
            int idNuevo = obtenerId(request);
            objper.setId(idNuevo);
            lista.add(objper);
            
        }
        else{
            //edition
            int pos = buscarPorIndice(request,id);
            lista.set(pos, objper);
            // Recalcula la nota después de editar
            nota = objper.getP1() + objper.getP2() + objper.getP3();
            lista.get(pos).setNota(nota);
        }
          
        request.setAttribute("listaper", lista);
        response.sendRedirect("index.jsp");
    }
    
    public int buscarPorIndice(HttpServletRequest request,int id){
        HttpSession ses = request.getSession();
        ArrayList<Persona> lista = (ArrayList<Persona>)ses.getAttribute("listaper");
        
        int pos = -1;
        
        if (lista != null) {
            for (Persona ele: lista) {
                ++pos;
                if (ele.getId() == id) {
                    break;
                }
            }
        }
        return pos;
    }
    
    public int obtenerId(HttpServletRequest request){
        HttpSession ses = request.getSession();
        ArrayList<Persona> lista = (ArrayList<Persona>) ses.getAttribute("listaper");
        //buscar
        int idn = 0;
        for (Persona ele: lista) {
            idn = ele.getId();            
        }
        return idn + 1;
    }
}