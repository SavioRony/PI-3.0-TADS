<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Filial</title>
    </head>
    <style>
        div h1{
            text-align: center;
            margin-bottom: 50px;
            margin-top: 50px;
        }
        p{
            font-weight: bolder;
            font-size: 18px;
        }
    </style>
    <body>
        <%@include file="../../cabecalho.jsp" %>         
        <div class="container">
            <h1> Alteração da Filial: ${filial.nomeFilial}</h1>
            <form action="AlterarFilial" method="POST">
                <input name="codFilial" type="hidden" class="form-control" value="${filial.codFilial}" readonly="true" />
                <div class="row">                    
                    <div class="form-group col-lg-6">
                        <p>Nome da filial</p>
                        <input name="nomeFilial"  class="form-control" value="${filial.nomeFilial}" required="true"/>
                    </div>
                    <div class="form-group col-lg-3">
                        <p>Estado</p>
                        <select name="estado" class="browser-default custom-select" required="true">
                            <option value="${fifial.nomeFilial}" disabled selected>Selecione</option>
                            <option value="AC">Acre</option>
                            <option value="AL">Alagoas</option>
                            <option value="AP">Amapá</option>
                            <option value="AM">Amazonas</option>
                            <option value="BA">Bahia</option>
                            <option value="CE">Ceará</option>
                            <option value="DF">Distrito Federal</option>
                            <option value="ES">Espirito Santo</option>
                            <option value="GO">Goiás</option>
                            <option value="MA">Maranhão</option>
                            <option value="MS">Mato Grosso do Sul</option>
                            <option value="MT">Mato Grosso</option>
                            <option value="MG">Minas Gerais</option>
                            <option value="PA">Pará</option>
                            <option value="PB">Paraíba</option>
                            <option value="PR">Paraná</option>
                            <option value="PE">Pernambuco</option>
                            <option value="PI">Piauí</option>
                            <option value="RJ">Rio de Janeiro</option>
                            <option value="RN">Rio Grande do Norte</option>
                            <option value="RS">Rio Grande do Sul</option>
                            <option value="RO">Rondônia</option>
                            <option value="RR">Roraima</option>
                            <option value="SC">Santa Catarina</option>
                            <option value="SP">São Paulo</option>
                            <option value="SE">Sergipe</option>
                            <option value="TO">Tocantins</option>
                        </select>
                    </div>
                    <div class="form-group col-lg-3">
                        <p>Cidade</p>
                        <input name="cidade" onkeypress="return event.charCode >= 65 && event.charCode <= 90 || event.charCode >= 97 && event.charCode <= 122 || event.charCode == 32" class="form-control" value="${filial.cidade}" required="true"/>
                    </div>
                </div>
                <br/>
                <button type="submit" style="float: right" class="btn btn-primary">Salvar</button>
            </form>
        </div>
    </body> 
</html>
