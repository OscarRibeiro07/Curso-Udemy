package br.com.erudio.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/math")
public class MathController {

    // http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{num1}/{num2}")
    public Double sum(@PathVariable("num1") String num1,@PathVariable("num2") String num2) throws Exception {
        if(!isNumeric(num1)||!isNumeric(num2)) throw new UnsupportedOperationException("Please set a numeric value!");
        return convertToDoble(num1 ) + convertToDoble(num2);
    }

    private Double convertToDoble(String strNumero) throws Exception {
        if(strNumero==null||strNumero.isEmpty())  throw new UnsupportedOperationException("Please set a numeric value!");
        //formata tipo de ocorrencia de virgula para ponto.
        String numero = strNumero.replace(",",".");//R$ 5,00 para R$ 5.00
        return Double.parseDouble(numero);

    }



    private boolean isNumeric(String strNumero) throws Exception {
        if(strNumero==null||strNumero.isEmpty())  throw new Exception();
        //formata tipo de ocorrencia de virgula para ponto.
        String numero = strNumero.replace(",",".");//R$ 5,00 para R$ 5.00
        return  (numero.matches("[-+]?[0-9]*\\.?[0-9]+"));// definindo parametros aceitos

    }




    // http://localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{num1}/{num2}")
    public Double subtraction(@PathVariable("num1") String num1,@PathVariable("num2") String num2) throws Exception {
        if(!isNumeric(num1)||!isNumeric(num2)) throw new UnsupportedOperationException("Please set a numeric value!");
        return convertToDoble(num1 ) - convertToDoble(num2);
    }
    // http://localhost:8080/math/division/3/5
    @RequestMapping("/division/{num1}/{num2}")
    public Double division(@PathVariable("num1") String num1,@PathVariable("num2") String num2) throws Exception {
        if(!isNumeric(num1)||!isNumeric(num2)) throw new UnsupportedOperationException("Please set a numeric value!");
        return convertToDoble(num1 ) / convertToDoble(num2);
    }


    // http://localhost:8080/math/media/3/5
    @RequestMapping("/media/{num1}/{num2}")
    public Double media(@PathVariable("num1") String num1,@PathVariable("num2") String num2) throws Exception {
        if (!isNumeric(num1) || !isNumeric(num2))
            throw new UnsupportedOperationException("Please set a numeric value!");
        Double soma = convertToDoble(num1) + convertToDoble(num2);
        ArrayList quantidades = new ArrayList();
        quantidades.add(num1);
        quantidades.add(num2);

        return soma / quantidades.size() ;

    }


    // http://localhost:8080/math/division/3/5
    @RequestMapping("/raizQuad/{num1}")
    public Double raizQuad(@PathVariable("num1") String num1) throws Exception {
        if (!isNumeric(num1))
            throw new UnsupportedOperationException("Please set a numeric value!");
        return convertToDoble(num1) * convertToDoble(num1) ;


    }
}
