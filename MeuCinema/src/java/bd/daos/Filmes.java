package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Filmes
{
    public static boolean cadastrado (long codigo) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM Filmes " +
                  "WHERE Id = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setLong (1, codigo);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            retorno = resultado.first(); 
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar filme");
        }

        return retorno;
    }

    public static void incluir (Filme filme) throws Exception
    {
        if (filme==null)
            throw new Exception ("Filme nao fornecido");

        try
        {
            String sql;

            sql = "INSERT INTO Filmes " +
                  "(Id, Nome, Sinopse, Genero, Duracao, Trailer) " +
                  "VALUES "; 
                  

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setLong   (1, filme.getId ());
            BDSQLServer.COMANDO.setString (2, filme.getFilme ());
            BDSQLServer.COMANDO.setString (3, filme.getSinopse ());
            BDSQLServer.COMANDO.setString (4, filme.getGenero ());
            BDSQLServer.COMANDO.setInt (5, filme.getDuracao ());
            BDSQLServer.COMANDO.setString (3, filme.getTrailer ());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir filme");
        }
    }

    public static void excluir (int codigo) throws Exception
    {
        if (!cadastrado (codigo))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "DELETE FROM Filmes " +
                  "WHERE Id=?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, codigo);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();        
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao excluir filme");
        }
    }

    public static void alterar (Filme filme) throws Exception
    {
        if (filme==null)
            throw new Exception ("Filme nao fornecido");

        if (!cadastrado (filme.getId()))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "UPDATE Filme " +
                  "SET NOME=? " +
                  "SET Sinopse=? " +
                  "SET Genero=?"+
                  "SET Duracao=?"+
                  "SET Trailer=?"+
                  "WHERE ID = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString (1, filme.getFilme  ());
            BDSQLServer.COMANDO.setString (2, filme.getSinopse ());
            BDSQLServer.COMANDO.setString (3, filme.getGenero  ());
            BDSQLServer.COMANDO.setInt    (4, filme.getDuracao ());
            BDSQLServer.COMANDO.setString (5, filme.getTrailer ());
            BDSQLServer.COMANDO.setLong   (6, filme.getId ());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados de filme");
        }
    }

    public static Filme getFilme(long codigo) throws Exception
    {
        Filme filme = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM Filmes " +
                  "WHERE Id = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setLong (1, codigo);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            filme = new Filme (resultado.getLong   ("Id"),
                               resultado.getString("Nome"),
                               resultado.getString ("Sinopse"),
                               resultado.getString("Genero"),
                               resultado.getInt("Duracao"),
                               resultado.getString("Trailer"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar filme");
        }

        return filme;
    }

    public static MeuResultSet getFilmes () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM Filmes";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar filmes");
        }

        return resultado;
    }
}