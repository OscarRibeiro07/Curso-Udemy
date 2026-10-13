package br.com.erudio.requestConverters;

public class ConversorNumero {



    public static Double convertToDoble(String strNumero) throws Exception {
        if(strNumero==null||strNumero.isEmpty())  throw new UnsupportedOperationException("Please set a numeric value!");
        //formata tipo de ocorrencia de virgula para ponto.
        String numero = strNumero.replace(",",".");//R$ 5,00 para R$ 5.00
        return Double.parseDouble(numero);

    }



    public static boolean isNumeric(String strNumero) throws Exception {
        if(strNumero==null||strNumero.isEmpty())  throw new Exception();
        //formata tipo de ocorrencia de virgula para ponto.
        String numero = strNumero.replace(",",".");//R$ 5,00 para R$ 5.00
        return  (numero.matches("[-+]?[0-9]*\\.?[0-9]+"));// definindo parametros aceitos

    }
}
