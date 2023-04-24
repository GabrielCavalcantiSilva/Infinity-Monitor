package com.mycompany.exemplobanco;

public class Empresa {
    private int idEmpresa;
    private String cnpj;
    
    @Override
    public String toString() {
      return "Empresa [idEmpresa=" + idEmpresa + ", cnpj=" + cnpj + "]";
    }

    public int getIdEmpresa() {
      return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
      this.idEmpresa = idEmpresa;
    }

    public String getCnpj() {
      return cnpj;
    }

    public void setCnpj(String cnpj) {
      this.cnpj = cnpj;
    }
    
    
}
