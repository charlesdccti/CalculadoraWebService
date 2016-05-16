package br.ufba.dcc.charles.calculadorawebservice;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by charles on 10/08/16.
 */
public class CalculadoraWS {


    public void CalculaoraWS(){

    }

    public String somar( Integer op1, Integer op2) throws XmlPullParserException, IOException {

        SoapObject soap = new SoapObject("http://default_package/", "somar");
        soap.addProperty("op1", op1);
        soap.addProperty("op2", op2);



        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);

        HttpTransportSE httpTrans = new HttpTransportSE("http://192.168.1.101:8080/CalculadoraSoup/services/CalculadoraPort?wsdl");

        httpTrans.call("somar", envelope);

        Object resultado = envelope.getResponse();



        return resultado.toString();
    }

    //    public String somar( Integer op1, Integer op2){
    //
    //        return String.valueOf(op1 + op2);
    //    }

    //    public String subtrair( Integer op1, Integer op2){
    //
    //        return String.valueOf(op1 + op2);
    //    }
    //
    //    public String multiplicar( Integer op1, Integer op2){
    //
    //        return String.valueOf(op1 * op2);
    //    }
    //
    //    public String dividir( Integer op1, Integer op2){
    //
    //        return String.valueOf(op1 / op2);
    //    }
}
