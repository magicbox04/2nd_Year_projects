/**
 * Configuration implements all the methods needed by algorithm computerPlay
 * @author Sangjae Lee
 * @version 1.0
 * Due Date : Oct 18 2023
 * Last Edited : Oct 18 2023
 * Professor : Professor Solis-Oba
 */

public class Configurations 
{
	/**
     * instance variables
     */ 
	private int board_size, lengthToWin, max_levels;
	private char[][] board;
	
	/**
	 * Constructor for Configurations
	 * 
	 * @param board_size size of the row and col
	 * @param lengthToWin length required to win
	 * @param max_levels depth of the tree
	 */
	public Configurations (int board_size, int lengthToWin, int max_levels)
	{
		this.board_size = board_size;
		this.lengthToWin = lengthToWin;
		this.max_levels = max_levels;
		this.board = new char[board_size][board_size];
		
		/**
		 * fill the board with ' '
		 */
		for (int i = 0; i < board_size; i++)
		{
			for (int j = 0; j < board_size; j++)
			{
				board[i][j] = ' ';
			}
		}
	}
	/**
	 * method that creats empty HashDictionary
	 * 
	 * @return an empty HashDictionary
	 */
	public HashDictionary createDictionary()
	{
		return new HashDictionary(7031);
	}
	
	/**
	 * method store the characters in String check if it is already inhashTable
	 * 
	 * @param hashTable a hash table to check 
	 * @return If not in hashTable returns -1, else return its associated score
	 */
	
	public int repeatedConfiguration(HashDictionary hashTable)
	{
		String config = "";
		
		for (int i = 0; i < this.board_size; i++)
		{
			config += new String( this.board[i]);
		}
		int score = hashTable.get(config);
		
		if (score == -1)
		{
			return -1;
		}
		else
		{
			return score;
		}
	}
	
	/**
	 * method represents the board as String then inserts String and score in hashDictionary
	 * 
	 * @param hashDictionary the hash dictionary where the String is stored
	 * @param score the score of the record
	 */
	public void addConfiguration(HashDictionary hashDictionary, int score)
	{
		String config = "";
		
		for (int i = 0; i < this.board_size; i++)
		{
			config += new String(this.board[i]);
		}
		Data record = new Data (config, score); 
		
		hashDictionary.put(record);
	}
	
	/**
	 * Stores symbol in board[row][col].
	 * 
	 * @param row row value of the board
 	 * @param col column value of the board
	 * @param symbol 'O' or 'X' or ' ' that is getting added
	 */
	public void savePlay(int row, int col, char symbol)
	{
		this.board[row][col] = symbol;
	}
	
	/**
	 * checks if the square is empty
	 * 
	 * @param row row value of the board
	 * @param col column value of the board
	 * @return true if board[row][col] is ' '; otherwise it returns false.
	 */
	public boolean squareIsEmpty (int row, int col)
	{
		if (this.board[row][col] == ' ')
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	/**
	 * checks if there is a winner for the given symbol
	 * 
	 * @param symbol the symbol that is being checked
	 * @return true if the given symbol won, false if not
	 */
	public boolean wins (char symbol)
	{
		int k = this.lengthToWin;
		int n = this.board_size;
		int count = 0;
		
		for (int row =0; row < n; row++)
		{
			for (int col = 0; col < n; col++)
			{
				if (row - 1 >= 0 && col - 1 >= 0 && row + 1 < n &&  col + 1 < n)
				{
					/**
					 * check for +
					 * if found, increase counter equal to the size 
					 */
					if (this.board[row][col] == symbol && this.board[row+1][col] == symbol && 
							this.board[row-1][col] == symbol && this.board[row][col+1] == symbol && 
							this.board[row][col - 1] == symbol)
					{
						count++;
						for (int i = 1;  col + i < n && board[row][col + i] == symbol; i++)
						{
							count++;
						}
						for (int i = 1; col - i >= 0 && board[row][col - i] == symbol; i++)
						{
							count++;
						}
						for (int i = 1; row + i < n && board[row + i][col] == symbol; i++)
						{
							count++;
						}
						for (int i = 1;  row - i >= 0 && board[row - i][col] == symbol; i++)
						{
							count++;
						}
					}
					if (count >= k)
					{
						return true;
					}
					count = 0;
				
					/**
					 * check for x
					 * if found, increase counter equal to the size 
					 */
					if (this.board[row][col] == symbol && this.board[row+1][col+1] == symbol && 
							this.board[row + 1][col - 1] == symbol && 
							this.board[row - 1][col + 1] == symbol && this.board[row - 1][col - 1] == symbol)
					{
						count++;
						for (int i = 1; row + i < n && col + i < n 
								&& board[row + i][col + i] == symbol; i++)
						{
							count++;
						}
						for (int i = 1; row + i < n && col - i >= 0 
								&& board[row + i][col - i] == symbol; i++)
						{
							count++;
						}
						for (int i = 1; row - i >= 0 && col + i < n 
								&& board[row - i][col + i] == symbol; i++)
						{
							count++;
						}
						for (int i = 1; row - i >= 0 && col - i >= 0 
								&& board[row - i][col - i] == symbol; i++)
						{
							count++;
						}
					}
					if (count >= k)
					{
						return true;
					}
					count = 0;
				}
			}
		}
		return false;
	}
	
	/**
	 * check if the board is a draw
	 *
	 * @return true if board has no empty positions left and no player has won the game
	 */
	public boolean isDraw()
	{
		if (wins('O') || wins('X'))
		{
			return false;
		}

		for (int row = 0; row < this.board_size; row++)
		{
			for (int col = 0; col < this.board_size; col++)
			{
				if (squareIsEmpty (row, col) == true)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * check the board and find who one
	 * 
	 * @return 3 if computer won
	 * @return 0 if player won
	 * @return 2 if draw
	 * @return 1 if game has not ended
	 */
	public int evalBoard()
	{
		if (wins('O'))
		{
			return 3;
		}
		else if (wins('X'))
		{
			return 0;
		}
		else if (isDraw())
		{
			return 2;
		}
		else 
		{
			return 1;	
		}
	}
}
