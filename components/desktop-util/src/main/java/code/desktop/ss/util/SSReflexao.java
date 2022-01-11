package code.desktop.ss.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class SSReflexao {
    public static Object buscarValorCampo(Object objeto, String nomeCampo) throws NoSuchFieldException, IllegalAccessException {
        Field campo = null;
        Class classe = objeto.getClass();
        while (classe != null && campo == null) {
            try {
                campo = classe.getDeclaredField(nomeCampo);
            }catch(NoSuchFieldException nse) {
                classe = classe.getSuperclass();
            }
        }
        
        String nomeMetodo = "get";
        Method metodo;
        Object valor = null;
        
        if (campo != null) {
            if (campo.getType().equals(Boolean.class) || campo.getType().equals(boolean.class)) {
                nomeMetodo = "is";            
            }
        }
        
        nomeMetodo += nomeCampo.substring(0, 1).toUpperCase() + nomeCampo.substring(1);
        if (classe == null)
            classe = objeto.getClass();
        try {
            metodo = classe.getMethod(nomeMetodo);
            valor = metodo.invoke(objeto);
        } catch (InvocationTargetException e) {
            throw new IllegalAccessException(e.getTargetException().getMessage());
        } catch (NoSuchMethodException e) {
            throw new IllegalAccessException(e.getMessage());
        }

        return valor;
    }
    public static Object buscarValorCampoRecursivo(Object objeto, String nomeCampo) throws NoSuchFieldException, IllegalAccessException {        
        StringTokenizer token = new StringTokenizer(nomeCampo, ".", false);
        Object valor = null;
        String nomeMetodo = null;
        boolean simNao = false;
        
        while(token.hasMoreElements()) {
            nomeCampo = (String)token.nextElement();
            if (objeto == null)
                return null;
            if (nomeCampo != null) {                                
                valor = buscarValorCampo(objeto, nomeCampo);   
                objeto = valor;
            }
        }
        return valor;
    }
    
    public static Object definirValorCampo(Object objeto, String nomeCampo, Object valor) throws NoSuchFieldException, IllegalAccessException {
        Field campo = null;
        Class classe = objeto.getClass();
        while (classe != null && campo == null) {
            try {
                campo = classe.getDeclaredField(nomeCampo);
            }catch(NoSuchFieldException nse) {
                classe = classe.getSuperclass();
            }
        }
        
        String nomeMetodo = "set";
        Method metodo, metodoGet;
        String nomeMetodoGet = "get";
          if (campo != null) {
              if (campo.getType().equals(Boolean.class) || campo.getType().equals(boolean.class)) {
                  nomeMetodoGet = "is";            
              }
          }
        nomeMetodoGet += nomeCampo.substring(0, 1).toUpperCase() + nomeCampo.substring(1);

        nomeMetodo += nomeCampo.substring(0, 1).toUpperCase() + nomeCampo.substring(1);
        if (classe == null)
            classe = objeto.getClass();
        try {
            metodoGet = classe.getMethod(nomeMetodoGet);
            metodo = classe.getMethod(nomeMetodo, metodoGet.getReturnType());
            valor = metodo.invoke(objeto, converterParaTipoEspecifico(metodoGet.getReturnType(), valor));
        } catch (InvocationTargetException e) {
            throw new IllegalAccessException(e.getTargetException().getMessage());
        } catch (NoSuchMethodException e) {
            throw new IllegalAccessException(e.getMessage());
        }
  
        return valor;
    }
    
    private static void definirValorCampo(Object objeto, Method metodo, Object valor) {
        
    }
    
    public static void definirValorCampoRecursivo(Object objeto, String nomeCampo, Object valor) throws NoSuchFieldException, IllegalAccessException {        
        StringTokenizer token = new StringTokenizer(nomeCampo, ".", false);        
        int quantCampos = token.countTokens();
        
        int i = 1;
        while(token.hasMoreElements()) {
            nomeCampo = (String)token.nextElement();
            if (nomeCampo != null) {
                if (i == quantCampos)
                    definirValorCampo(objeto, nomeCampo, valor);
                else
                    objeto = buscarValorCampoRecursivo(objeto, nomeCampo);
            }
            i++;
        }
    }
    
    private static <T> T converterParaTipoEspecifico(Class<T> tipo, Object valor) {
        
        if (valor == null)
            return null;
        
        if (tipo.isInstance(valor))
            return (T)valor;
        
        if (tipo == String.class)
            return (T)valor.toString();
        
        if (Number.class.isAssignableFrom(tipo) && valor.toString().trim().length() == 0)
            return null;
        
        if (tipo == Integer.class)
            return (T)SSConversao.inteiro(valor);
            
        if (tipo == Long.class)
            return (T)SSConversao.longo(valor);
        
        if (tipo == Double.class)
            return (T)SSConversao.duplo(valor);
        
        if (tipo == Float.class)
            return (T)SSConversao.flutuante(valor);
        
        if (tipo == Date.class)
            try {
                return (T)SSConversao.data(valor);
            } catch (ParseException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        
        return (T)valor;
    }
    
    public static void copiarAtributos(Object origem, Object destino, String[] atributos) throws Exception {
        Object valorOrigem;
        Object valorDestino;
        for (String atributo : atributos) {        
            valorOrigem = SSReflexao.buscarValorCampo(origem, atributo);
            
            System.out.println(atributo + ": " + valorOrigem);
            definirValorCampo(destino, atributo, valorOrigem);            
        }
    }
    
    public static void copiarTodosAtributos(Object origem, Object destino) throws Exception {
        copiarTodosAtributosComExcecao(origem, destino, null);
    }
    
    public static List<String> pegarAtributos(Class classe) {
        List<String> atributos = new ArrayList();
        Method[] methods = classe.getDeclaredMethods();
        String atributo;
        Method methodGet;
        for (Method method : methods) {
            if (!method.getName().startsWith("set"))
                continue;
            atributo = method.getName().substring(3);
            if (method.getGenericParameterTypes().length != 1)
                continue;
            //pega metodo get
            try {
                //verifica se eh metodo booleando ou normal
                if (method.getGenericParameterTypes()[0] == Boolean.TYPE)
                    methodGet = classe.getDeclaredMethod("is" + atributo, null);
                else
                    methodGet = classe.getDeclaredMethod("get" + atributo, null);
            }catch(NoSuchMethodException nsme) {
                //se nao houver metodo get eh porque nao eh um atributo com set e get, passa para o proximo item
                continue;
            }
            atributos.add(SSTexto.primeiraMinuscula(atributo));
        }
        return atributos;
    }
    
    public static void copiarTodosAtributosComExcecao(Object origem, Object destino, String[] excecao) throws Exception {
          List<String> atributos = pegarAtributos(origem.getClass());
          
          //remove excecao
          if (excecao != null) {
              for (String atributo : excecao) {
                  atributos.remove(atributo);
              }
          }
          
          copiarAtributos(origem, destino, atributos.toArray(new String[]{}));
    }
    
    
}
