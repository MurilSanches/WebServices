/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.metodista.servicos;

import bd.core.MeuResultSet;
import bd.daos.Filmes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import java.util.*;
import br.metodista.modelo.Filme;
import com.google.gson.*;
import javax.ws.rs.PathParam;

@Path("filmes")
public class FilmesResourse {

    @Context
    private UriInfo context;
    private static List<bd.dbos.Filme> filmes;
    
    
    @GET 
        @Produces("application/json")
        public String getXml() 
        {            
            Gson gson = new Gson();                                    
            return gson.toJson(filmes);
        }

    
    @GET
        @Path("{filmeId}")
            @Produces("application/json")
            public String getFilme(@PathParam("filmeId")String filmeId) 
            {
                for(bd.dbos.Filme f : filmes) 
                {
                    if(f.getId().equals(Long.valueOf(filmeId))) 
                    {
                        Gson gson = new Gson();
                        return gson.toJson(f);
                    }
                }

                return null;
            }



        /**
         * PUT method for updating or creating an instance of FilmesResourse
         * @param content representation for the resource
         */
        @PUT
        @Consumes(MediaType.APPLICATION_JSON)
        public void putJson(String content) {
        }

    public FilmesResourse() throws Exception
    {                
        filmes = new ArrayList<bd.dbos.Filme>();
        
        MeuResultSet resultado = Filmes.getFilmes();
        
        while(resultado.next())
        {       
            filmes.add(new bd.dbos.Filme(resultado.getLong("ID"),resultado.getString("NOME"),resultado.getString("SINOPSE"),resultado.getString("GENERO"),resultado.getInt("DURACAO"),resultado.getString("TRAILER")));            
        }
    }
}
