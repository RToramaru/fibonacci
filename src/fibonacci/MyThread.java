/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 *
 * @author Rafael Almeida Soares
 */
public class MyThread extends SwingWorker<Object, Object> {

    private int tamanho;
    private JLabel resultado;
    private JProgressBar barra;

    public MyThread() {

    }

    public MyThread(int tamanho, JLabel resultado, JProgressBar barra) {
        this.tamanho = tamanho;
        this.resultado = resultado;
        this.barra = barra;
    }

    public JLabel getResultado() {
        return resultado;
    }

    public void setResultado(JLabel resultado) {
        this.resultado = resultado;
    }

    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    protected Object doInBackground() throws Exception {
        double atual = 1;
        double anterior = 0;
        double proximo = 0;
        for (int i = 0; i < tamanho; i++) {
            switch (i) {
                case 0:
                    atual = 0;
                    break;
                case 1:
                    atual = 1;
                    break;
                case 2:
                    atual = 1;
                    anterior = 0;
                    break;
                default:
                    break;
            }
            proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
            Thread.sleep(100);
            barra.setMaximum(tamanho - 1);
            barra.setValue(i);

        }
        resultado.setText(Double.toString(proximo));
        
        return null;
    }
    protected void done() {

    }
}
