/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.metodista.servicos;

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
    private static List<Filme> filmes;
    
      @GET
        @Path("{filmeId}")
        @Produces("application/json")
        public String getFilme(@PathParam("filmeId")String filmeId) 
        {
            for(Filme f : filmes) {
                if(f.getId() == Long.valueOf(filmeId)) {
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
        filmes = new ArrayList<Filme>();
        filmes.add(new Filme(1L, "007: Operação Skyfall", 
        "Em 007 - Operação Skyfall, a lealdade de Bond a M "+
        "é testada quando o seu passado volta a atormetá-la."+
        "Com a MI6 sendo atacada, o 007 precisa rastrear e"+
        "destruir a ameaça, não importando o quão pessoal"+ 
        "será o custo disto.", "Ação", 145, ""));
        filmes.add(new Filme(2L, "Atividade Paranormal 4",
        "Atividade Paranormal 4 se passa em 2011, cinco"+ 
        "anos depois de Katie matar seu namorado Micah, sua"+
        "irmã Kristi e seu marido Daniel e levar seu bebê,"+
        "Hunter. A história centra-se em Alice e sua mãe,"+
        "experimentando atividades estranhas quando os novos"+
        "vizinhos mudam-se para a casa ao lado.", "Suspense",
        89, ""));
        filmes.add(new Filme(3L, "Até Que A Sorte Nos Separe",
        "Livremente inspirado no best-seller Casais Inteligentes"+
        "Enriquecem Juntos, Até que a sorte nos separe é uma"+ 
        "comédia romântica sobre as aventuras de um casal que"+
        "consegue, 2 vezes, o quase impossível: Ganhar na"+
        "loteria e gastar tudo em dez anos...o filme fará com"+
        "que o público se divirta e se identifique com os"+ 
        "segredos e trapalhadas de uma família descobrindo"+           
        "que uma boa conta bancária até ajuda, mas desde que"+
        "você saiba o que fazer com ela.", "Comédia", 104, ""));
        filmes.add(new Filme(4L, "Busca implacável 2", "Em"+
        "Istambul, agente aposentado da CIA, Bryan Mills, e sua"+
        "mulher são feitos reféns pelo pai de um sequestrador"+ 
        "que Mills matou durante o resgate de sua filha no"+ 
        "primeiro filme.", "Ação", 94, ""));
        filmes.add(new Filme(5L, "Gonzaga de Pai para Filho",
        "Um pai e um filho, dois artistas, dois sucessos. Um"+
        "do sertão nordestino, o outro carioca do Morro de São"+
        "Carlos; um de direita, o outro de esquerda. Encontros,"+
        "desencontros e uma trilha sonora que emocionou o Brasil."+ 
        "Esta é a história de Luiz Gonzaga e Gonzaguinha, e de"+
        "um amor que venceu o medo e o preconceito e resistiu à"+
        "distância e ao esquecimento.", "Drama", 130, ""));
        filmes.add(new Filme(6L, "Hotel Transilvânia 3D", 
        "Bem-vindos ao Hotel Transilvânia, o luxuoso resort"+ 
        "'cinco estacas' de Drácula, onde monstros e suas"+ 
        "famílias podem viver livres da intromissão do mundo"+ 
        "humano. Mas há um fato pouco conhecido sobre Drácula:"+
        "ele não é apenas o príncipe das trevas, mas também"+
        "é um pai super-protetor de uma filha adolescente,"+ 
        "Mavis, e inventa contos de perigo para dissuadir"+ 
        "seu espírito aventureiro.", "Infantil", 93, ""));
        filmes.add(new Filme(7L, "Possessão", "Uma jovem"+ 
        "compra uma caixa antiga sem saber que dentro do"+ 
        "objeto existe um espírito malicioso. Os pais da"+
        "menina tentam encontrar uma maneira de acabar com"+
        "a maldição que domina sua filha.", "Terror", 92, 
        ""));
    }
}
