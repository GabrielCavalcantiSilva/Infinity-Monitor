package com.mycompany.exemplobanco;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class VerificacaoCredenciais {

    public Boolean verCre(String login, String senha) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();
        
        Boolean verficacaoFinal = false;

        Empresa user = con.queryForObject("IF NOT EXISTS (select idEmpresa from Empresa where cnpj = ?)"
                + " BEGIN"
                + " SELECT -9 AS mensagem"
                + " END"
                + " ELSE"
                + " BEGIN"
                + "  select idEmpresa from Empresa where cnpj = ? "
                + "END ", new BeanPropertyRowMapper<>(Empresa.class), login, login);
        
        System.out.println(user.getIdEmpresa());
        
        if(user.getIdEmpresa() != 0){
            Funcionario senhaUser = con.queryForObject("IF NOT EXISTS (select senha from Funcionario where fkEmpresa = ?)"
                + " BEGIN"
                + "  SELECT 'Erro' AS mensagem"
                + " END"
                + " ELSE"
                + " BEGIN"
                + "  select senha from [dbo].[Funcionario] where fkEmpresa = ? "
                + "END ", new BeanPropertyRowMapper<>(Funcionario.class), user.getIdEmpresa(), user.getIdEmpresa());
            

                if (senhaUser.getSenha().equals(senha)) {
                    verficacaoFinal = true;
                } 
        } else {
            System.out.println("Login não encontrado!");
        }
        
        return verficacaoFinal;
    }
}
