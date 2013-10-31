/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.com.window;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;

/**
 *
 * @author Hismahil Escarvalhar Pereira Dinis
 */
public class Window{

    //dimensões da tela
    private int width = 0; //largura
    private int height = 0; //altura
    private Dimension resolution = null; //largura/altura
    
    /**
     * <p><h3>Cria janela com configurações gerais</h3></p>
     * @param title Título da janela.<br/>
     * @param resolution Dimensões da janela.<br/>
     * @param resize <code>true</code> Para permitir redimensionar a janela, <code>false</code> para não permitir.<br/>
     * @param maximized <code>true</code> Para janela iniciar maximizada, <code>false</code> para tamanho normal.<br/>
     * @param center <code>true</code> Para deixar a janela no centro da tela, <code>false</code> para não.<br/>
     * @param deafultCloseOperation Tipo de encerramento da janela.<br/>
     * @param menuBar Para adicionar barra de menu a janela, pode ser feito pela instância da janela<br/>
     * @param toolBar Para adicionar barra de ferramentas a janela, pode ser feito pela instância da janela<br/>
     * @return Instância da janela criada<br/>
     */
    public JFrame createWindow(String title, 
                               Dimension resolution, 
                               Boolean resize, 
                               Boolean maximized,
                               Boolean center,
                               int deafultCloseOperation,
                               JMenuBar menuBar,
                               JToolBar toolBar){
        JFrame form = new JFrame(title); //instância da janela
        form.setSize(resolution); //tamanho da janela
        form.setDefaultCloseOperation(deafultCloseOperation); //tipo de encerramento
        this.resolution = resolution; //mantem referência para as dimensões da janela
        width = resolution.width; //idem apenas largura
        height = resolution.height; //idem apenas altura
        //----------------------------------------------------------------------------
        if(resize != null && resize == true){//se pode redimensionar a janela
            form.setResizable(true);
        }
        else{
            form.setResizable(false);
        }
        //----------------------------------------------------------------------------
        if(maximized != null && maximized == true){ //se a janela inicia maximizada
            form.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        //----------------------------------------------------------------------------
        if(center != null && center == true){ //se a janela inicia centralizada
            form.setLocationRelativeTo(null);
        }
        //----------------------------------------------------------------------------
        if(menuBar != null){//barra de menu
            form.setJMenuBar(menuBar);
        }
        //----------------------------------------------------------------------------
        if(toolBar != null){//barra de ferramentas
            form.getContentPane().add(toolBar);
        }
        //----------------------------------------------------------------------------
        return form;
    }
    
    /**
     * <p><h3>Cria janela com configurações gerais</h3></p>
     * @param title Título da janela.<br/>
     * @param resolution Dimensões da janela.<br/>
     * @return Instância da janela criada<br/>
     */
    public JFrame createWindow(String title, Dimension resolution){
        return createWindow(title, resolution, null, null, null, JFrame.EXIT_ON_CLOSE, null, null);
    }
    /**
     * <p><h3>Cria janela com configurações gerais</h3></p>
     * @param title Título da janela.<br/>
     * @param width Largura da janela. <br/>
     * @param height Altura da janela. <br/>
     * @return Instância da janela criada<br/>
     */
    public JFrame createWindow(String title, int width, int height){
        Dimension d = new Dimension(width, height);
        return createWindow(title, d, null, null, null, JFrame.EXIT_ON_CLOSE, null, null);
    }
    /**
     * <p><h3>Cria janela com configurações gerais</h3></p>
     * @param title Título da janela.<br/>
     * @param resolution Dimensões da janela.<br/>
     * @param deafultCloseOperation Tipo de encerramento da janela.<br/>
     * @return Instância da janela criada<br/>
     */
    public JFrame createWindow(String title, Dimension resolution, int deafultCloseOperation){
        return createWindow(title, resolution, null, null, null, deafultCloseOperation, null, null);
    }
    /**
     * <p><h3>Cria janela com configurações gerais</h3></p>
     * @param title Título da janela.<br/>
     * @param width Largura da janela. <br/>
     * @param height Altura da janela. <br/>
     * @param deafultCloseOperation Tipo de encerramento da janela.<br/>
     * @return Instância da janela criada<br/>
     */
    public JFrame createWindow(String title, int width, int height, int deafultCloseOperation){
        Dimension d = new Dimension(width, height);
        return createWindow(title, d, null, null, null, deafultCloseOperation, null, null);
    }
    /**
     * <p><h3>Cria janela com configurações gerais</h3></p>
     * @param title Título da janela.<br/>
     * @param resolution Dimensões da janela.<br/>
     * @param resize <code>true</code> Para permitir redimensionar a janela, <code>false</code> para não permitir.<br/>
     * @return Instância da janela criada<br/>
     */
    public JFrame createWindow(String title, Dimension resolution, boolean resize){
        return createWindow(title, resolution, resize, null, null, JFrame.EXIT_ON_CLOSE, null, null);
    }
    /**
     * <p><h3>Cria janela com configurações gerais</h3></p>
     * @param title Título da janela.<br/>
     * @param width Largura da janela. <br/>
     * @param height Altura da janela. <br/>
     * @param resize <code>true</code> Para permitir redimensionar a janela, <code>false</code> para não permitir.<br/>
     * @return Instância da janela criada<br/>
     */
    public JFrame createWindow(String title, int width, int height, boolean resize){
        Dimension d = new Dimension(width, height);
        return createWindow(title, d, resize, null, null, JFrame.EXIT_ON_CLOSE, null, null);
    }
    /**
     * <p><h3>Cria janela com configurações gerais</h3></p>
     * @param title Título da janela.<br/>
     * @param resolution Dimensões da janela.<br/>
     * @param resize <code>true</code> Para permitir redimensionar a janela, <code>false</code> para não permitir.<br/>
     * @param deafultCloseOperation Tipo de encerramento da janela.<br/>
     * @return Instância da janela criada<br/>
     */
    public JFrame createWindow(String title, Dimension resolution, boolean resize, int deafultCloseOperation){
        return createWindow(title, resolution, resize, null, null, deafultCloseOperation, null, null);
    }
    /**
     * <p><h3>Cria janela com configurações gerais</h3></p>
     * @param title Título da janela.<br/>
     * @param width Largura da janela. <br/>
     * @param height Altura da janela. <br/>
     * @param resize <code>true</code> Para permitir redimensionar a janela, <code>false</code> para não permitir.<br/>
     * @param deafultCloseOperation Tipo de encerramento da janela.<br/>
     * @return Instância da janela criada<br/>
     */
    public JFrame createWindow(String title, int width, int height, boolean resize, int deafultCloseOperation){
        Dimension d = new Dimension(width, height);
        return createWindow(title, d, resize, null, null, deafultCloseOperation, null, null);
    }
    /**
     * <p><h3>Cria janela com configurações gerais</h3></p>
     * @param title Título da janela.<br/>
     * @param resolution Dimensões da janela.<br/>
     * @param resize <code>true</code> Para permitir redimensionar a janela, <code>false</code> para não permitir.<br/>
     * @param maximized <code>true</code> Para janela iniciar maximizada, <code>false</code> para tamanho normal.<br/>
     * @return Instância da janela criada<br/>
     */
    public JFrame createWindow(String title, Dimension resolution, boolean resize, boolean maximized){
        return createWindow(title, resolution, resize, maximized, null, JFrame.EXIT_ON_CLOSE, null, null);
    }
    /**
     * <p><h3>Cria janela com configurações gerais</h3></p>
     * @param title Título da janela.<br/>
     * @param width Largura da janela. <br/>
     * @param height Altura da janela. <br/>
     * @param resize <code>true</code> Para permitir redimensionar a janela, <code>false</code> para não permitir.<br/>
     * @param maximized <code>true</code> Para janela iniciar maximizada, <code>false</code> para tamanho normal.<br/>
     * @return Instância da janela criada<br/>
     */
    public JFrame createWindow(String title, int width, int height, boolean resize, boolean maximized){
        Dimension d = new Dimension(width, height);
        return createWindow(title, d, resize, maximized, null, JFrame.EXIT_ON_CLOSE, null, null);
    }
    /**
     * <p><h3>Cria janela com configurações gerais</h3></p>
     * @param title Título da janela.<br/>
     * @param resolution Dimensões da janela.<br/>
     * @param resize <code>true</code> Para permitir redimensionar a janela, <code>false</code> para não permitir.<br/>
     * @param maximized <code>true</code> Para janela iniciar maximizada, <code>false</code> para tamanho normal.<br/>
     * @param deafultCloseOperation Tipo de encerramento da janela.<br/>
     * @return Instância da janela criada<br/>
     */
    public JFrame createWindow(String title, Dimension resolution, boolean resize, boolean maximized, int deafultCloseOperation){
        return createWindow(title, resolution, resize, maximized, null, deafultCloseOperation, null, null);
    }
    /**
     * <p><h3>Cria janela com configurações gerais</h3></p>
     * @param title Título da janela.<br/>
     * @param width Largura da janela. <br/>
     * @param height Altura da janela. <br/>
     * @param resize <code>true</code> Para permitir redimensionar a janela, <code>false</code> para não permitir.<br/>
     * @param maximized <code>true</code> Para janela iniciar maximizada, <code>false</code> para tamanho normal.<br/>
     * @param deafultCloseOperation Tipo de encerramento da janela.<br/>
     * @return Instância da janela criada<br/>
     */
    public JFrame createWindow(String title, int width, int height, boolean resize, boolean maximized, int deafultCloseOperation){
        Dimension d = new Dimension(width, height);
        return createWindow(title, d, resize, maximized, null, deafultCloseOperation, null, null);
    }
    /**
     * <p><h3>Cria janela com configurações gerais</h3></p>
     * @param title Título da janela.<br/>
     * @param resolution Dimensões da janela.<br/>
     * @param resize <code>true</code> Para permitir redimensionar a janela, <code>false</code> para não permitir.<br/>
     * @param maximized <code>true</code> Para janela iniciar maximizada, <code>false</code> para tamanho normal.<br/>
     * @param center <code>true</code> Para deixar a janela no centro da tela, <code>false</code> para não.<br/>
     * @return Instância da janela criada<br/>
     */
    public JFrame createWindow(String title, Dimension resolution, boolean resize, boolean maximized, boolean center){
        return createWindow(title, resolution, resize, maximized, center, JFrame.EXIT_ON_CLOSE, null, null);
    }
    /**
     * <p><h3>Cria janela com configurações gerais</h3></p>
     * @param title Título da janela.<br/>
     * @param width Largura da janela. <br/>
     * @param height Altura da janela. <br/>
     * @param resize <code>true</code> Para permitir redimensionar a janela, <code>false</code> para não permitir.<br/>
     * @param maximized <code>true</code> Para janela iniciar maximizada, <code>false</code> para tamanho normal.<br/>
     * @param center <code>true</code> Para deixar a janela no centro da tela, <code>false</code> para não.<br/>
     * @return Instância da janela criada<br/>
     */
    public JFrame createWindow(String title, int width, int height, boolean resize, boolean maximized, boolean center){
        Dimension d = new Dimension(width, height);
        return createWindow(title, d, resize, maximized, center, JFrame.EXIT_ON_CLOSE, null, null);
    }
    /**
     * <p><h3>Cria janela com configurações gerais</h3></p>
     * @param title Título da janela.<br/>
     * @param resolution Dimensões da janela.<br/>
     * @param resize <code>true</code> Para permitir redimensionar a janela, <code>false</code> para não permitir.<br/>
     * @param maximized <code>true</code> Para janela iniciar maximizada, <code>false</code> para tamanho normal.<br/>
     * @param center <code>true</code> Para deixar a janela no centro da tela, <code>false</code> para não.<br/>
     * @param deafultCloseOperation Tipo de encerramento da janela.<br/>
     * @return Instância da janela criada<br/>
     */
    public JFrame createWindow(String title, 
                               Dimension resolution, 
                               boolean resize, 
                               boolean maximized, 
                               boolean center,
                               int deafultCloseOperation){
        return createWindow(title, resolution, resize, maximized, center, deafultCloseOperation, null, null);
    }
    /**
     * <p><h3>Cria janela com configurações gerais</h3></p>
     * @param title Título da janela.<br/>
     * @param width Largura da janela. <br/>
     * @param height Altura da janela. <br/>
     * @param resize <code>true</code> Para permitir redimensionar a janela, <code>false</code> para não permitir.<br/>
     * @param maximized <code>true</code> Para janela iniciar maximizada, <code>false</code> para tamanho normal.<br/>
     * @param center <code>true</code> Para deixar a janela no centro da tela, <code>false</code> para não.<br/>
     * @param deafultCloseOperation Tipo de encerramento da janela.<br/>
     * @return Instância da janela criada<br/>
     */
    public JFrame createWindow(String title, 
                               int width, 
                               int height, 
                               boolean resize, 
                               boolean maximized, 
                               boolean center,
                               int deafultCloseOperation){
        Dimension d = new Dimension(width, height);
        return createWindow(title, d, resize, maximized, center, deafultCloseOperation, null, null);
    }
    /**
     * <p><h3>Cria janela com configurações gerais</h3></p>
     * @param title Título da janela.<br/>
     * @param resolution Dimensões da janela.<br/>
     * @param resize <code>true</code> Para permitir redimensionar a janela, <code>false</code> para não permitir.<br/>
     * @param maximized <code>true</code> Para janela iniciar maximizada, <code>false</code> para tamanho normal.<br/>
     * @param center <code>true</code> Para deixar a janela no centro da tela, <code>false</code> para não.<br/>
     * @param menuBar Para adicionar barra de menu a janela, pode ser feito pela instância da janela<br/>
     * @return Instância da janela criada<br/>
     */
    public JFrame createWindow(String title, 
                               Dimension resolution, 
                               boolean resize, 
                               boolean maximized, 
                               boolean center, 
                               JMenuBar menuBar){
        return createWindow(title, resolution, resize, maximized, center, JFrame.EXIT_ON_CLOSE, menuBar, null);
    }
    /**
     * <p><h3>Cria janela com configurações gerais</h3></p>
     * @param title Título da janela.<br/>
     * @param width Largura da janela. <br/>
     * @param height Altura da janela. <br/>
     * @param resize <code>true</code> Para permitir redimensionar a janela, <code>false</code> para não permitir.<br/>
     * @param maximized <code>true</code> Para janela iniciar maximizada, <code>false</code> para tamanho normal.<br/>
     * @param center <code>true</code> Para deixar a janela no centro da tela, <code>false</code> para não.<br/>
     * @param menuBar Para adicionar barra de menu a janela, pode ser feito pela instância da janela<br/>
     * @return Instância da janela criada<br/>
     */
    public JFrame createWindow(String title, 
                               int width,
                               int height,
                               boolean resize, 
                               boolean maximized, 
                               boolean center, 
                               JMenuBar menuBar){
        Dimension d = new Dimension(width, height);
        return createWindow(title, d, resize, maximized, center, JFrame.EXIT_ON_CLOSE, menuBar, null);
    }
    /**
     * <p><h3>Cria janela com configurações gerais</h3></p>
     * @param title Título da janela.<br/>
     * @param resolution Dimensões da janela.<br/>
     * @param resize <code>true</code> Para permitir redimensionar a janela, <code>false</code> para não permitir.<br/>
     * @param maximized <code>true</code> Para janela iniciar maximizada, <code>false</code> para tamanho normal.<br/>
     * @param center <code>true</code> Para deixar a janela no centro da tela, <code>false</code> para não.<br/>
     * @param deafultCloseOperation Tipo de encerramento da janela.<br/>
     * @param menuBar Para adicionar barra de menu a janela, pode ser feito pela instância da janela<br/>
     * @return Instância da janela criada<br/>
     */
    public JFrame createWindow(String title, 
                               Dimension resolution, 
                               boolean resize, 
                               boolean maximized, 
                               boolean center, 
                               JMenuBar menuBar,
                               int deafultCloseOperation){
        return createWindow(title, resolution, resize, maximized, center, deafultCloseOperation, menuBar, null);
    }
    /**
     * <p><h3>Cria janela com configurações gerais</h3></p>
     * @param title Título da janela.<br/>
     * @param width Largura da janela. <br/>
     * @param height Altura da janela. <br/>
     * @param resize <code>true</code> Para permitir redimensionar a janela, <code>false</code> para não permitir.<br/>
     * @param maximized <code>true</code> Para janela iniciar maximizada, <code>false</code> para tamanho normal.<br/>
     * @param center <code>true</code> Para deixar a janela no centro da tela, <code>false</code> para não.<br/>
     * @param menuBar Para adicionar barra de menu a janela, pode ser feito pela instância da janela<br/>
     * @param deafultCloseOperation Tipo de encerramento da janela.<br/>
     * @return Instância da janela criada<br/>
     */
    public JFrame createWindow(String title, 
                               int width,
                               int height,
                               boolean resize, 
                               boolean maximized, 
                               boolean center, 
                               JMenuBar menuBar,
                               int deafultCloseOperation){
        Dimension d = new Dimension(width, height);
        return createWindow(title, d, resize, maximized, center, deafultCloseOperation, menuBar, null);
    }
    /**
     * Largura da janela
     * @return WIDTH
     */
    public int getWidth(){
        return this.width;
    }
    
    /**
     * Altura da janela
     * @return HEIGHT
     */
    public int getHeight(){
        return this.height;
    }
    /**
     * Dimensão da janela
     * @return RESOLUTION;
     */
    public Dimension getResolution(){
        return resolution;
    }
}
