package utils;

import javax.swing.*;
import java.awt.*;

public class FieldUtils {

    private static FieldUtils fieldUtilsUnico;

    private FieldUtils() {
    }

    public static FieldUtils criaFieldUtilsUnico(){
        if (fieldUtilsUnico == null){
            fieldUtilsUnico = new FieldUtils();
        }
        return fieldUtilsUnico;
    }


    public void limpaCampos(JFrame frame){
        for(int i = 0; i < frame.getContentPane().getComponentCount(); i++){
            Component c = frame.getContentPane().getComponent(i);
            if(c instanceof JTextField){
                JTextField field = (JTextField)c;
                field.setText("");
            }
            if(c instanceof JFormattedTextField){
                JFormattedTextField field = (JFormattedTextField)c;
                field.setText("");
            }
        }
    }

    public void bloqueiaCampos(JFrame frame){
        for(int i = 0; i < frame.getContentPane().getComponentCount(); i++){
            Component c = frame.getContentPane().getComponent(i);
            if(c instanceof JTextField){
                JTextField field = (JTextField)c;
                field.setEditable(false);
            }
            if(c instanceof JFormattedTextField){
                JFormattedTextField field = (JFormattedTextField)c;
                field.setEditable(false);
            }
        }
    }

    public void liberaCampos(JFrame frame){
        for(int i = 0; i < frame.getContentPane().getComponentCount(); i++){
            Component c = frame.getContentPane().getComponent(i);
            if(c instanceof JTextField){
                JTextField field = (JTextField)c;
                field.setEditable(true);
            }
            if(c instanceof JFormattedTextField){
                JFormattedTextField field = (JFormattedTextField)c;
                field.setEditable(true);
            }
        }
    }
}
