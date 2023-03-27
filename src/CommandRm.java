import java.io.File;
import java.util.Scanner;

public class CommandRm extends AbstractCommand {

	protected String[] directory = commandLine.split(" ", 2);
	protected File newFile = new File(currentDirectory + "\\" + directory[1]);
	protected Scanner scanner;

	public CommandRm(File currentDirectory, String commandLine) {
		super(currentDirectory, commandLine);
		scanner = new Scanner(System.in);
	}

	@Override
	public File executeCommand() {
		directory = commandLine.split(" ", 2);
		newFile = new File(currentDirectory + "\\" + directory[1]);

		if(newFile.isDirectory()) {
			System.out.println("파일이 아닙니다.");
		} else {
			if(!newFile.exists()) {
				System.out.println("지정된 파일을 찾을 수 없습니다.");
			} else {
				System.out.println("계속하시겠습니까(Y/N)?");
				String chk = scanner.nextLine();
				if(chk.equals("y")||chk.equals("Y")||chk.equals("yes")||chk.equals("YES")) {
					newFile.delete();
					System.out.println("삭제되었습니다.");
				}
			}
		}


		return currentDirectory;
	}

}