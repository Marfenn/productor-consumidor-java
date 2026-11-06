package prac3pcd;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.*;
/**
 *
 * @author Don Daniel
 */
public class CanvasCola  extends Canvas{

     private int ancho;
    private int alto;
    private int head;
    private int tail;
    private int capacidad;
    private int numelementos;
    private Object[] datos;
    private String mensaje = " ";
    private Image buffer;
    
    
    
    public CanvasCola(int capacidad) {
        this.capacidad = capacidad;
        this.datos = new Object[capacidad];
    }
    
    @Override 
    public void update(Graphics g){
    paint(g);}
    //Basicamente con esto evitamos el parpadeo de la pantalla


    @Override
    public synchronized void paint(Graphics g){
    int w = getWidth(); //ancho
    int h = getHeight(); // alto
    if(w<=0 || h <=0){
    return;}
    if (buffer == null || buffer.getWidth(null) != w || buffer.getHeight(null) != h) {
        buffer = createImage(w, h);   // creamos la imagen oculta
    }
    
    Graphics gb = buffer.getGraphics();
    gb.setColor(getBackground()); //Le damos el color blanco cada vez que se pinte para que no quede marca de la iteracion antigua
    gb.fillRect(0, 0, w, h);// desde la (0,0) hasta (w,h)
    gb.setColor(Color.BLUE);
    gb.setFont(new Font("Arial", Font.BOLD,24));
    gb.drawString(mensaje,20,40); //Le ponemos el nombre a la cabecera HEAD 
    
    //Casillas 
    int margen = 20;
    int ancho  = (w-2 * margen)/capacidad;
    int alto = 60;
    int y = h/2 - alto/2;
    
    //dibujar casillas
    
        for (int i = 0; i < capacidad; i++) {
        int x = margen + i * ancho;        
        if (datos[i]==null){
        gb.setColor(Color.green);
        gb.drawRect(x, y, ancho, alto);
        }
        
         gb.setColor(Color.black);
        gb.drawRect(x,y,ancho,alto);
        //NUMEROS
        if (datos[i] != null){
        gb.setFont(new Font("Arial", Font.PLAIN,11));
        String texto = String.format("%2f",((Number)datos[i]).floatValue());
        gb.drawString(texto, x+4 ,y+alto/2+4);}
        
        gb.setFont(new Font("Arial",Font.BOLD,13));
        gb.setColor(Color.red);
       
        gb.drawString("HEAD",margen+head*ancho+4,y+alto+20);
        gb.fillOval(margen+head*ancho-4,y+alto+1 , 10, 10);
        gb.setColor(Color.green);
        gb.drawString("TAIL", margen+tail*ancho+4,y-10);
        gb.fillOval(margen+tail*ancho-4, y-10, 10, 10);
        }
        
        //MARCA HEAD Y TAIL
        
        
        
        //NUMERO DE ELEMENTOS
        
        gb.setColor(Color.black);
        gb.drawString("Elementos: "+numelementos+" / "+capacidad,margen,h-10);
        
        gb.dispose(); //libera el lapiz
        g.drawImage(buffer,0,0,null); //pone la imagen del buffer por pantalla
        
        
        
       
    }
    
    //AVISO DE COLA LLENA O COLAVACIA
    public synchronized void avisa(String mensaje){
    this.mensaje = mensaje;
    repaint();
    }
   
    //Obligatorio antes de pintar para actualizar 
    
    public synchronized void representa (Object[] buf,int head,int tail,int numele){
    this.datos = buf.clone();
    this.head = head;
    this.tail = tail;
    this.numelementos = numele;
    this.mensaje = "";
    repaint();}
    
}
