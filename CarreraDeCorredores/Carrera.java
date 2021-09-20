import hsa.Console;
class Carrera
{
 static Console c;
 
 String[]nombres;
 float[]tiempo;
 
 Carrera()
  {
  int n;
  c.print("Cantidad de corredores: ");
  n = c.readInt();
  nombres = new String[n];
  tiempo = new float[n];
  }
  
 void punto1()
  {
  c.println("Cargue los datos de los corredores");
  c.println();
  for(int i=0;i<nombres.length;i++)
   {
   c.print("Ingrese Nombre["+(i+1)+"]: ");
   nombres[i] = c.readLine();
   c.print("Tiempo obtenido: ");
   tiempo[i] = c.readFloat(); 
   c.println();
   }
  }

  
 void punto2()
  {
  int posicion;
  String nombresAux;
  char op;
  do
   {
   c.clear();
   c.println("Consultas por nombres de corredores");
   c.println("-----------------------------------");
   posicion =-1;
   c.println();
   c.print("Ingrese el nombre de corredor: ");
   nombresAux = c.readLine();
   for(int i=0;i<nombres.length;i++)
    {
     if(nombresAux.equalsIgnoreCase(nombres[i]))
      {
      posicion = i;
      }
    }
   c.println();
   if(posicion!=-1)
    {
    c.print("Le corresponde el tiempo de: ");
    c.println(tiempo[posicion]);
    }
   else
    {
    c.println("Ese nombre no esta registrado");
    }
   c.println();
   c.println();
   c.print("Desea realizar otra consulta(s/n): ");
   op = c.readChar();
  }
  while(op=='S'||op=='s');
 }

 void punto3A()
  {
  c.println();
  String n1 = nombres[0];
  float m = tiempo[0];
  float p = 0;
  for(int i=1;i<tiempo.length&&i<nombres.length;i++)
   {
    if(tiempo[i]>m)
     {
     n1 = nombres[i];
     m = tiempo[i];
     }
   }
  c.println();
  c.println("Ganador de la carrera: " +  n1 + "Tiempo: " + m);
  }
  
 void punto3B()
  {
  c.println();
  String n2 = nombres[0];
  float me = tiempo[0];
  float p1 = 0;
  for(int i=1;i<tiempo.length;i++)
   {
    if(tiempo[i]<me)
     {
     n2 = nombres[i];
     me = tiempo[i];
     }
   }
  c.println();
  c.println("Ganador de la carrera: " +  n2 + "Tiempo: " + me);
  }

   
 void imprimir()
  {
  int fila;
  c.setCursor(3,10);c.print("Corredores");
  c.setCursor(4,10);c.print("----------");
  c.setCursor(3,30);c.print("Tiempos");
  c.setCursor(4,30);c.print("------");
  fila = 5;
  for(int i=0;i<nombres.length;i++)
   {
   c.setCursor(fila,10);
   c.print(nombres[i]);
   c.setCursor(fila,30);
   c.print(tiempo[i],4,1);
   fila++;
   }
   c.println();
   c.println();
   c.print("Presione [Enter] para retornar al Menu");
   c.readChar();
  }
 



  
 void punto4()
  {
  int no = nombres.length; 
  String auxiNombres;
  float auxiTiempo;
   for(int k=1;k<no;k++)
    {
     for(int i=0;i<no-k;i++)
      {
       if(nombres[i].compareTo(nombres[i+1])>0)
	{
	auxiNombres = nombres[i];
	nombres[i] = nombres[i+1];
	nombres[i+1] = auxiNombres;
	
	auxiTiempo = tiempo[i];
	tiempo[i] = tiempo[i+1];
	tiempo[i+1] = auxiTiempo;
	}
      }
    }
  }
 

 
 
 public static void main(String arg[])
  {
  c = new Console();
  Carrera e = new Carrera();
  int op;
  do
   {
   c.clear();
  
   c.setCursor(3,10);
   c.print("Menu de Opciones");
   c.setCursor(4,10);
   c.print("----------------");
   c.setCursor(5,10);
   c.print("1-Cargar datos de los corredores");
   c.setCursor(6,10);
   c.print("2-Pedir el tiempo realizado por el nombre de un corredor");
   c.setCursor(7,10);
   c.print("3-Ver el nombre de ganador y el que salio ultimo en la carrera");
   c.setCursor(8,10);
   c.print("4-Tabla ordenada de los corredores alfabeticamente");
   c.setCursor(9,10);
   c.print("5-Finalizar programa");
   c.setCursor(13,10);
   c.print("Digite la opcion: ");
   op = c.readInt();
   switch(op)
    {
    case 1:e.punto1();break;
    case 2:c.clear();
	   c.setCursor(1,10);
	   e.punto2();break;
    case 3:c.clear();
	   c.setCursor(1,10);
	   c.print("Datos de la carrera");
	   e.punto3A();
	   e.punto3B();
	   break;
    case 4:c.clear();
	   c.setCursor(1,10);
	   c.print("Lista de corredores");
	   e.punto4();
	   e.imprimir();
	   break;
    }
   }
  while(op!=5);
  System.exit(0);
  }
}




