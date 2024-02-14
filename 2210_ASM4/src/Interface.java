/**
 * Interface creates an Interface that uses the BST
 * @author Sangjae Lee
 * @version 1.0
 * Due Date : November 17  2023
 * Last Edited : November 17 2023
 * Professor : Professor Narayan
 */

import java.io.File;  
import java.util.Scanner;
import java.io.FileNotFoundException;  

public class Interface 
{
	public static void main(String[] args)
	{
		// get info from file and put it in the Dictionary
		try 
		{
			String inputFile = args[0];
			File file = new File(inputFile);
			int type;
			Key k;
			Record r;
			BSTDictionary orderedDic = new BSTDictionary();
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNextLine()) 
			{
				// get label and data
				String label = scanner.nextLine();
				String data = scanner.nextLine();
				
				// sound file
				if (data.charAt(0) == '-')
				{
					type = 3;
					k = new Key(label.toLowerCase(),type);
					r = new Record(k,data.substring(1));
					orderedDic.put(r);
				}
				// music file
				else if (data.charAt(0) == '+')
				{
					type = 4;
					k = new Key(label.toLowerCase(),type);
					r = new Record(k,data.substring(1));
					orderedDic.put(r);
				}
				//voice file
				else if (data.charAt(0) == '*')
				{
					type = 5;
					k = new Key(label.toLowerCase(),type);
					r = new Record(k,data.substring(1));
					orderedDic.put(r);
				}
				// translation
				else if (data.charAt(0) == '/')
				{
					type = 2;
					k = new Key(label.toLowerCase(),type);
					r = new Record(k,data.substring(1));
					orderedDic.put(r);
				}
				// check for potential null pointer exception
				else if (data.length() > 4)
				{
					// image file
					if (data.substring(data.length() - 4).equalsIgnoreCase(".gif"))
					{
						type = 7;
						k = new Key(label.toLowerCase(),type);
						r = new Record(k,data);
						orderedDic.put(r);
					}
					// animation file
					else if (data.substring(data.length() - 4).equalsIgnoreCase(".jpg"))
					{
						type = 6;
						k = new Key(label.toLowerCase(),type);
						r = new Record(k,data);
						orderedDic.put(r);
					}
					// URL
					else if (data.length() > 5 && data.substring(data.length() - 5).equalsIgnoreCase(".html"))
					{
						type = 8;
						k = new Key(label.toLowerCase(),type);
						r = new Record(k,data);
						orderedDic.put(r);
					}
					// definition
					else
					{
						type = 1;
						k = new Key(label.toLowerCase(),type);
						r = new Record(k,data);
						orderedDic.put(r);
					}
				}
				// definition with label shorter than 5 
				else
				{
					type = 1;
					k = new Key(label.toLowerCase(),type);
					r = new Record(k,data);
					orderedDic.put(r);
				}
			}
			
			scanner.close();
			
			while(true)
			{
				StringReader keyboard = new StringReader();
				String line = keyboard.read("Enter next command: ");
				
		
				if(line.equalsIgnoreCase("exit"))
				{
					break;
				}
				else if(line.toLowerCase().startsWith("define "))
				{
					String target = line.substring(7);
					r = orderedDic.get(new Key(target, 1));
					
					if (r == null)
					{
						System.out.println("The word " + target + " is not in the ordered dictionary");
					}
					else
					{
						System.out.println(r.getDataItem());
					}
				}
				else if (line.toLowerCase().startsWith("translate "))
				{
					String target = line.substring(10);
					r = orderedDic.get(new Key(target, 2));
					
					if (r == null)
					{
						System.out.println("There is no definition for the word " + target);
					}
					else
					{
						System.out.println(r.getDataItem());
					}
				}
				else if (line.toLowerCase().startsWith("sound "))
				{
					String target = line.substring(6);
					r = orderedDic.get(new Key(target, 3));
					
					if (r == null)
					{
						System.out.println("There is no sound file for " + target);
					}
					else
					{
						SoundPlayer player = new SoundPlayer();
						player.play(r.getDataItem());
					}
				}
				else if (line.toLowerCase().startsWith("play "))
				{
					String target = line.substring(5);
					r = orderedDic.get(new Key(target, 4));
					
					if (r == null)
					{
						System.out.println("There is no music file for " + target);
					}
					else
					{
						SoundPlayer player = new SoundPlayer();
						player.play(r.getDataItem());
					}
				}
				else if (line.toLowerCase().startsWith("say "))
				{
					String target = line.substring(4);
					r = orderedDic.get(new Key(target, 5));
					
					if (r == null)
					{
						System.out.println("There is no voice file for " + target);
					}
					else
					{
						SoundPlayer player = new SoundPlayer();
						player.play(r.getDataItem());
					}
				}
				else if (line.toLowerCase().startsWith("show "))
				{
					String target = line.substring(5);
					r = orderedDic.get(new Key(target, 6));
					
					if (r == null)
					{
						System.out.println("There is no image file for " + target);
					}
					else
					{
						PictureViewer viewer = new PictureViewer();
						viewer.show(r.getDataItem());
					}
				}
				else if (line.toLowerCase().startsWith("animate "))
				{
					String target = line.substring(8);
					r = orderedDic.get(new Key(target, 7));
					
					if (r == null)
					{
						System.out.println("There is no animation image file for " + target);
					}
					else
					{
						PictureViewer viewer = new PictureViewer();
						viewer.show(r.getDataItem());
					}
				}
				else if (line.toLowerCase().startsWith("browse "))
				{
					String target = line.substring(7);
					r = orderedDic.get(new Key(target, 8));
					
					if (r == null)
					{
						System.out.println("There is no webpage called " + target);
					}
					else
					{
						ShowHTML webViewer = new ShowHTML();
						webViewer.show(r.getDataItem());
					}
				}
				else if (line.toLowerCase().startsWith("delete "))
				{
					String[] parts = line.split(" ");
		            String label = parts[1];
		            type = Integer.parseInt(parts[2]);
		            
		            try 
		            {
		            	orderedDic.remove(new Key(label,type));
		            }
		            catch (DictionaryException e)
		            {
		    			System.out.println("No record in the ordered dictionary has key (" + 
		            			label +  "," + type +")");
		    		}
				}
				else if (line.toLowerCase().startsWith("add "))
				{
					String[] parts = line.split(" ", 4);
					String label = parts[1];
		            type = Integer.parseInt(parts[2]);
		            String data = parts[3];
		            
		            try 
		            {
		            	orderedDic.put(new Record (new Key(label,type),data));
		            }
		            catch (DictionaryException e)
		    		{
		    			System.out.println("A record with the given key (" + 
		            			label +  "," + type +") is already in the ordered dictionary.");
		    		}
				}
				else if (line.toLowerCase().startsWith("list "))
				{
					String target = line.substring(5);
					r = orderedDic.successor(new Key(target,0));
					
		            if (r == null || r.getKey().getLabel().startsWith(target) == false)
		            {
		    			System.out.println("No label attributes in the ordered dictionary start with prefix " + 
		            			target);
		            }
		            else
		            {
		            	System.out.print(r.getKey().getLabel());
		            	r = orderedDic.successor(r.getKey());
		            	
		            	while (r != null && r.getKey().getLabel().startsWith(target))
		            	{
		            		System.out.print(", " + r.getKey().getLabel());
			            	r = orderedDic.successor(r.getKey());
		            	}
		            	System.out.println("");
		            }
				}
				else if(line.toLowerCase().equals("first"))
				{
					r = orderedDic.smallest();
					
					System.out.print(r.getKey().getLabel() + ",");
					System.out.print(r.getKey().getType() + ",");
					System.out.println(r.getDataItem() + ".");
				}
				else if(line.toLowerCase().equals("last"))
				{
					r = orderedDic.largest();
					
					System.out.print(r.getKey().getLabel() + ",");
					System.out.print(r.getKey().getType() + ",");
					System.out.println(r.getDataItem() + ".");
				}
				else
				{
					System.out.println("invalid command");
				}
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("file not found");
		}
		catch (DictionaryException e)
		{
			System.out.println(e.getMessage());
		}
		catch (MultimediaException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
