package  test;



	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.OutputStream;
	import java.io.OutputStreamWriter;
	import java.nio.charset.StandardCharsets;
	import java.nio.file.Files;
	import java.nio.file.Paths;
	import java.util.Arrays;
	import java.util.List;
	import java.util.stream.Stream;

public class GetVocab {
			public static void main (String[] args) throws IOException {
						String[] news=new String[50000] ;
								   File f = new File("/home/shirin/topic_model/data/input.vocab");
								   	         BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));
										 	         String line = "";
												 	        int id=0;
															         while ((line = reader.readLine()) != null) {
																	 	        	 String[] temps=line.split(":");
																		id=Integer.valueOf(temps[0]).intValue();
																									        	news[id]=temps[1];																													         }
																 	         File folder = new File("/home/shirin/topic_model/data/input/");

																		 	 		String[] files = folder.list();
																			 List list = (List) Arrays.asList(news);
															String filename = "/home/shirin/topic_model/data/input.docs";
														 File fw= new File(filename);
																													 	         OutputStream out1 = new FileOutputStream(fw, false);
																															 	         BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out1, "utf-8"));
																																	 	 		for (String file : files)
																																						 		{
															file="/home/shirin/topic_model/data/input/"+file;
															
System.out.println(file);															String text= readLineByLineJava8(file);																									         String[] temp=text.split("\n");
																																													int i=0;
																																																			 		         id=0;
																																																						 		         String word="";
																																																									 		         
																																																									 				for(i=0;i<temp.length-1;i++)
																																																																		{
																																																																									line=temp[i];
																																																																															String[] tempd=line.split(" ");																																																																																					for(int k=0;k<tempd.length-1;k++)
																																																																																												{
																																																																																																				String b=tempd[k];
																																																																																																											if(list.contains(b))
																																																																																																																	          writer.write(list.indexOf(b)+ " ");
																																																																																																																	}
																																																																																											writer.write("\n");
																																																																																																		word=temp[1];
																																																																																																									news[1]=word;
																																																																																																													}		
																																																																	
																																																															        
																																																														 		}
																																					 		 writer.close();
																																							 	         out1.close();
																																									 	          }
				         
				 private static String readLineByLineJava8(String filePath) 
					 	    {
							    	        StringBuilder contentBuilder = new StringBuilder();
										 
										        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)) 
													        {
															System.out.println(filePath);
																            stream.forEach(s -> contentBuilder.append(s).append("\n"));
																	    	        }
												        catch (IOException e) 
															        {
																		            e.printStackTrace();
																			    	        }
														        return contentBuilder.toString();
																    }
	}

