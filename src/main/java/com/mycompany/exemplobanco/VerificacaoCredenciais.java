package com.mycompany.exemplobanco;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class VerificacaoCredenciais {
    public Boolean verCre(String login, String senha) {
      Conexao conexao = new Conexao();
      JdbcTemplate con = conexao.getConexaoDoBanco();
      
      Empresa user = con.queryForObject("select idEmpresa from Empresa where cnpj = ?", new BeanPropertyRowMapper<>(Empresa.class),  login);
      
      Funcionario senhaUser = con.queryForObject("select senha from Funcionario where fkEmpresa = ?", new BeanPropertyRowMapper<>(Funcionario.class),  user.getIdEmpresa());
      
      if(user == null){
          System.out.println("Deu null");
      }
      
      if(senhaUser.getSenha().equals(senha)) {
          return true;
      } else {
          return false;
      }
      
    }
}
