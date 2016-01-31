package monday.thumbnailcreator;

public class CommandLineArguments {
	private String path;
	private int width;
	private int height;
	private String[] args;
	private boolean recursiveOption;

	public CommandLineArguments(String[] args) {
		this.args = args;
		setRecursiveOption();
	}

	public String getPath() {
		path = !recursiveOption ? args[0] : args[1];
		return path;
	}

	public int getWidth() {
		width = !recursiveOption ? Integer.parseInt(args[1]) : Integer
				.parseInt(args[2]);
		return width;
	}

	public int getHeight() {
		height = !recursiveOption ? Integer.parseInt(args[2]) : Integer
				.parseInt(args[3]);
		return height;
	}

	public boolean isRecursiveOption() {
		return recursiveOption;
	}

	private void setRecursiveOption() {
		this.recursiveOption = args[0].equals("-r") ? true : false;
	}

	@Override
	public String toString() {
		return " recursiveOption=" + recursiveOption + " path=" + path
				+ ", width=" + width + ", height=" + height;
	}
}
