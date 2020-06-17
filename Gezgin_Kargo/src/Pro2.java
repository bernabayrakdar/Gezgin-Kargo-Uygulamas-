import java.io.*;
import java.util.*; 
import java.util.Random;

 public class Pro2{
 
	 static int [] [] yol = new int [15000] [2];
	 static int [] yollar = new int [100000];
	 static int [][] dizi=  new int[81][81];
	 static int [] dene = new int[81];
	 int dist[] = new int[V];
	 
	 static  ArrayList<Integer> plaka = new ArrayList<Integer>();	
	 static  ArrayList<Integer> sinirlar = new ArrayList<Integer>();	 
	 static  ArrayList<Integer> ana_sehirler = new ArrayList<Integer>();
	 static  ArrayList<Integer> yeni_plaka = new ArrayList<Integer>();
	 static  ArrayList<Integer> toplam_mesafe = new ArrayList<Integer>();
	 static  ArrayList<Integer> donus = new ArrayList<Integer>();
	 
	 static int uzaklik = 0;
	 static final int V = 81; 
	 
    int minDistance(int dist[], Boolean sptSet[]) 
    { 
    	 
        int min = Integer.MAX_VALUE, min_index = -1; 
  
        for (int v = 0; v < V; v++) 
        {
        	if (sptSet[v] == false && dist[v] <= min)
        	{ 
                min = dist[v]; 
                min_index = v; 
            }  
        }
           
        return min_index; 
    } 
  
    void printSolution(int dist[], int n) 
    { 
        for (int i = 0; i < V; i++) 
        {        	        	
        	dene[i] = dist[i];               	    	      	
        }
     } 
  
    void dijkstra(int graph[][], int src,int sinir, String Sehir []) 
    { 
    	int i=0,k=0,j=0;       
        Boolean sptSet[] = new Boolean[V]; 
  
        for (i = 0; i <V; i++) { 
            dist[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        } 
    
               
        dist[src] = 0; 
  
        for (int count = 0; count < V ; count++)
        { 

            int u = minDistance(dist, sptSet); 
            plaka.add(u);
  
            sptSet[u] = true; 

          j=0;
            for (int v = 0; v < V; v++) 
            {
                if (!sptSet[v] && graph[u][v] != 0 &&  dist[u] != Integer.MAX_VALUE) 
                {
                	
                	dist[v] = dist[u] + graph[u][v];                 
                	yol[k][j] = u;
                  	j++;
                	                
                	yol[k][j] = v;  
                	k++;     
                	j=0;          	       
                } 	
            }              
        } 

        ana_sehirler.add(40);
        ana_sehirler.add(sinir);
        
        int m=0;
        i=0;     
      
       for(i=0; i<k; i++)
        {
        	if(yol[i][1] == sinir)
        	{
        		 yollar[m] = yol[i][1];
    		     m++;
    		     break;
        	}
        }
        
       int  a=0;
        int bas = 0;
        int boyut = 0;
        sinirlar.clear();
       
        while(a < k)
        {          	
        	for(j=0; j<1; j++)
        	{     		
        	  for(i=0; i<k; i++)
                {
        		  
               	if(yol[i][1] == sinir)
            		{ 
            		   sinirlar.add(yol[i][0]);                     		   
               		}          	
                }
        	
        		if(sinir != -1) 
        		{
        		 	 boyut = sinirlar.size();         		       		     
                     int sayi = (int)(Math.random()*(sinirlar.size()-bas))+bas;
     		         yollar[m] = sinirlar.get(sayi);     		  
  		             m++;    
                
                    bas = boyut;               
        			sinir = sinirlar.get(sayi);        			         			
   			
        			for(i=0; i<ana_sehirler.size(); i++)
        			{

           			 if(sinir == ana_sehirler.get(i))
              		  {
              			 sayi = boyut -1;              		             			
              			 sinirlar.add(40);           			
              			 a=k;
              		  }
        			}     		   			     	
        		}        	      		
          	}
           	a++;                      	
        }        
   
       
        for(i=m-1 ; i>=0 ;i--)
        {
            uzaklik = (uzaklik + dizi[yollar[i]][yollar[i+1]]);
        	donus.add(yollar[i]);
        	
        }             
        
    printSolution(dist, V); 
    }  
	
public static void main(String[] args) throws IOException {
	
	
	File file = new File("sonuc.txt");
	file.createNewFile();
    PrintWriter writer = new PrintWriter(file);

	  
	  String dosyaAdi1 = "komsu.txt";
      String satir;
      String satir2;
      String [] Sehir =  new String [81];
     
      int j=0,i=0,k=0,m=0,sonuc=0,a=0,b=0,c=0,e=0,n=0;
     	
      Scanner scan = new Scanner(System.in);
      ArrayList<Integer> gir_plaka = new ArrayList<Integer>();     
      
      System.out.print("Kac sehire kargo gidecek?");
     
      int sayi = scan.nextInt();

	  String [] isim = new String[sayi];
	  int [] ilk_yol = new int[sayi];
	  int [] ilk_yol2 = new int[sayi];
	      
	  System.out.println("Gidilecek sehirleri girin (ilk harfi buuyuk):");
		writer.println("Gidilecek sehirleri girin (ilk harfi buuyuk):");
		
		

	      for(i=0;i<sayi;i++)
	      {
	    	  isim[i]=scan.next();
	    		writer.println(isim[i]);
	    		
	    	  	    	  
	      }
	         
      try{
          BufferedReader oku = new BufferedReader(new FileReader(dosyaAdi1 ));
          satir = oku.readLine();
        while(satir != null)
        {  
          	while(i<81)
          	{
          		
          	String[] bol = satir.split(" ");
          	sonuc = Integer.parseInt(bol[i]);          
          		
          	dizi[a][b]=sonuc;
          	b++;          	      	
        
      
	        i++;
          }
          	
          	a++;
          	b=0;
          	i=0;
          	
         satir = oku.readLine();	
          	
       }
                 
      }
      catch (IOException iox){
          System.out.println(dosyaAdi1 +" adli dosya okunamiyor."); 
         
      }
      
      String dosyaAdi = "sehirler.txt";
        
   
	try {
		BufferedReader oku2 = new BufferedReader(new FileReader(dosyaAdi));
		
		satir2 = oku2.readLine();
       while(satir2 != null)
     {  
      
      	 Sehir[c] = satir2;      	 
         satir2 = oku2.readLine();
         c++;
	        
     }
	        		
	} 
	
	catch (FileNotFoundException e1) {
		e1.printStackTrace();
	}
    
	  Pro2 t = new Pro2();
	  t.dijkstra(dizi, 40,-1,Sehir);

	while(n<81)
	{ 
		if(Sehir[n].compareTo(isim[e])== 0)
		{
					
			ilk_yol[e]= dene[n];
			ilk_yol2[e] = n;
			n=0;
			 e++;
			
			if(e==sayi)
			{
				break;
			}			
		}		
		  n++;
	}
	 
	int temp1 =0;
	int temp2 = 0;
	
	for(i=0;i<sayi;i++)
	{	
		for(j=sayi-1;j>i; j--)
		{
			if(ilk_yol[j-1]  > ilk_yol[j] )
			{
			
				temp1 = ilk_yol[j-1];
				temp2 = ilk_yol2[j-1];
				
				ilk_yol[j-1] = ilk_yol[j];
				ilk_yol2[j-1] = ilk_yol2[j];
				
				ilk_yol[j] = temp1;
				ilk_yol2[j] = temp2;				
			}
		}		
	}
	
	for(i =0 ; i<sayi ; i++)
	{
		gir_plaka.add(ilk_yol2[i]);
	}
		  
	  int boyut;
	  k=0;
	 	 
	  while(k<5)
	  {
		  yeni_plaka.clear();
		  t.dijkstra(dizi, 40,gir_plaka.get(0),Sehir);
		  
		  b=0;
		  j=0;
		  
		  while(j< sayi)
		  {
			   boyut = plaka.size();
			   
			  for(i=(81+b); i<boyut ;i++)
			  {
				  b++;			  						  			 
			  }
			  System.out.println();
				  	t.dijkstra(dizi,gir_plaka.get(0),gir_plaka.get(1),Sehir);
				  
				  		yeni_plaka.add(gir_plaka.get(0));
				  		gir_plaka.remove(0);				  		
				  		 
						  if(gir_plaka.size()<2)
						     {
							   boyut = plaka.size();
							   System.out.println();
							
						    	 break;
						     }				 
	               j++;     
		  } 
		  
		  for(i=0; i<donus.size(); i++)
		  {
			  System.out.print(Sehir[donus.get(i)]+"-->");
				writer.print(Sehir[donus.get(i)]+"-->");
			
		  }
			writer.println();
		  System.out.println();
		  for(i=donus.size()-1; i>=0; i--)
		  {
			  System.out.print(Sehir[donus.get(i)]+"-->");
				writer.print(Sehir[donus.get(i)]+"-->");
						
		  }
		  writer.println();	  
		  System.out.println();
		  System.out.println("Gidis donus arasý uzaklik: "+(uzaklik*2));
			writer.println("Gidis donus arasý uzaklik: "+(uzaklik*2));
			 writer.println();	  
		  
		  donus.clear();
		  
		  yeni_plaka.add(gir_plaka.get(0));
	  	  gir_plaka.remove(0);
		  
		  for(i=0; i<yeni_plaka.size(); i++)
		  {
			  gir_plaka.add(yeni_plaka.get(i));
		  }		    
		 		  
		  k++;
		  toplam_mesafe.add(uzaklik);
		  uzaklik = 0;
	  }	  

	  Collections.sort(toplam_mesafe);
	  System.out.println();
	  System.out.println("En kisa mesafe : " + toplam_mesafe.get(0)*2);	 
		writer.println("En kisa mesafe : " + toplam_mesafe.get(0)*2);
		writer.close();
	  
	  
	  }
} 