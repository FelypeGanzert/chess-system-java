package chess;

import boardgame.Position;

public class ChessPosition {

	private String column;
	private int row;
	
	public ChessPosition(String column, int row) {
		/// StringA.compareToIgnoreCase(StringB));
		// if the letter is ANTES then, < 0
		// if is equal, than 0
		// if is DEPOIS, > 0
		column = column.substring(0, 1);
		if(column.compareToIgnoreCase("A") < 0 || 
				column.compareToIgnoreCase("H") > 0 ||
				row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}

	public String getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	
	protected Position toPosition() {
		return new Position(8 - row, column.toLowerCase().charAt(0) - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) {
		char diffColumn = (char) ('a' + position.getColumn());
		return new ChessPosition(Character.toString(diffColumn), 8 - position.getRow());
	}

	
}
