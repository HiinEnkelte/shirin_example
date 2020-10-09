package cc.mallet.types.tests;

	import java.util.Arrays;
	import java.util.HashMap;
	import java.io.*;

	import cc.mallet.types.*;
	import cc.mallet.util.Randoms;
	import java.util.ArrayList;
	import java.util.List;

	import cc.mallet.types.InstanceList;

	public class word {
			public static void main (String[] args) throws IOException
				    {
					    	 InstanceList ilist = InstanceList.load (new File(args[0]));
						      String filename = "data/voc.txt";
						           File fw= new File(filename);
							        OutputStream out1 = new FileOutputStream(fw, false);
								     BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out1, "utf-8"));
								          writer.write(ilist.getAlphabet().toString());
									       writer.close();
									            out1.close();
										         System.out.println(ilist.getDataAlphabet());

											      File f = new File("data/voc.txt");
											           BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));
												        String line = "";
													     List<String> vocab = new ArrayList<String>();
													          String sb;
														       int i=0;
														            String filenames = "data/vocx.txt";
															         File result = new File(filenames);
																      OutputStream out = new FileOutputStream(result, false);                                                                                                                                                                                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out,                                                                                                                                                                                                                                                                       "utf-8"));
																           while ((line = reader.readLine()) != null) {
																		         sb=i+":"+line;
																			      bw.write(sb+"\n");
																			           i++;
																				        }
																	        bw.close();
																		     reader.close();
				    }
	}

