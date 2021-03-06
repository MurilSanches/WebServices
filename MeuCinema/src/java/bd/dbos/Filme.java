package bd.dbos;

public class Filme 
{
  private Long id;
  private String filme;
  private String sinopse;
  private String genero;
  private Integer duracao;
  private String trailer;

  public Filme(Long id, String filme, String sinopse, 
    String genero, Integer duracao, String trailer) throws Exception{

    this.setId(id);
    this.setFilme(filme);
    this.setSinopse(sinopse);
    this.setGenero(genero);
    this.setDuracao(duracao);
    this.setTrailer(trailer);
  }
  
      public Long getId() {
        return id;
    }

    public void setId(Long id) throws Exception{
        if(id < 0 || id == null)
            throw new Exception ("ERRO");
        this.id = id;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) throws Exception{
        if(filme == "" || filme == null)
            throw new Exception ("ERRO");
        this.filme = filme;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) throws Exception{
        if(sinopse == "" || sinopse == null)
            throw new Exception ("ERRO");
        this.sinopse = sinopse;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) throws Exception{
        if(genero == "" || genero == null)
            throw new Exception ("ERRO");
        this.genero = genero;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) throws Exception{
        if(duracao < 0 || duracao == null)
            throw new Exception ("ERRO");
        this.duracao = duracao;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) throws Exception
    {
        if(trailer == "" || trailer == null)
            throw new Exception ("ERRO");
        this.trailer = trailer;
    }
}
