package br.com.erudio.controllers;

import br.com.erudio.math.SimpleMath;
import br.com.erudio.requestConverters.ConversorNumero;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    private final SimpleMath math = new SimpleMath();


    // http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{num1}/{num2}")
    public Double sum(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {

        return math.sum(ConversorNumero.convertToDoble(num1), ConversorNumero.convertToDoble(num2));
    }


    // http://localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{num1}/{num2}")
    public Double subtraction(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {

        return math.subtraction(ConversorNumero.convertToDoble(num1), ConversorNumero.convertToDoble(num2));
    }

    // http://localhost:8080/math/division/3/5
    @RequestMapping("/division/{num1}/{num2}")
    public Double division(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {

        return math.division(ConversorNumero.convertToDoble(num1), ConversorNumero.convertToDoble(num2));
    }


    // http://localhost:8080/math/media/3/5
    @RequestMapping("/media/{num1}/{num2}")
    public Double media(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {

        return math.division(ConversorNumero.convertToDoble(num1), ConversorNumero.convertToDoble(num2));

    }


    // http://localhost:8080/math/division/3/5
    @RequestMapping("/raizQuad/{num1}")
    public Double raizQuad(@PathVariable("num1") String num1) throws Exception {

        return Math.sqrt(ConversorNumero.convertToDoble(num1));


    }
//    public Double convertToDoble(String strNumero) throws Exception {
//        if(strNumero==null||strNumero.isEmpty())  throw new UnsupportedOperationException("Please set a numeric value!");
//        //formata tipo de ocorrencia de virgula para ponto.
//        String numero = strNumero.replace(",",".");//R$ 5,00 para R$ 5.00
//        return Double.parseDouble(numero);
//
//    }
//
//
//
//    public boolean isNumeric(String strNumero) throws Exception {
//        if(strNumero==null||strNumero.isEmpty())  throw new Exception();
//        //formata tipo de ocorrencia de virgula para ponto.
//        String numero = strNumero.replace(",",".");//R$ 5,00 para R$ 5.00
//        return  (numero.matches("[-+]?[0-9]*\\.?[0-9]+"));// definindo parametros aceitos
//
//    }

}

