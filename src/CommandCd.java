import java.io.File;

public class CommandCd extends AbstractCommand {

	protected File newDirectory = currentDirectory;

	public CommandCd(File currentDirectory, String commandLine) {
		super(currentDirectory, commandLine);
	}

	@Override
	public File executeCommand() {
		String[] directory = commandLine.split(" ", 2);
		boolean back = (directory[1].equals("..")||directory[1].equals("\\..")||directory[1].equals("/..")||directory[1].equals("..\\")||directory[1].equals("../"));
		boolean now = (!directory[1].equals(".")&&!directory[1].equals("\\.")&&!directory[1].equals("/.")&&!directory[1].equals(".\\")&&!directory[1].equals("./"));
		if(currentDirectory.getParent()!=null&&back) {
			newDirectory = new File(currentDirectory.getParent());
		} else if(now&&!back) {
			newDirectory = new File(currentDirectory + "\\" + directory[1]);
			if(!newDirectory.exists()) {
				System.out.println(directory[0] + " : '" + newDirectory + "' 경로는 존재하지 않으므로 찾을 수 없습니다.");
				newDirectory = currentDirectory;
			}
		}
		return newDirectory;
	}

}