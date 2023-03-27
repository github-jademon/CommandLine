package kr.pe.batang.javaClass.exam;

import java.io.File;
import java.util.Scanner;

public class CommandRmdir extends AbstractCommand {

	protected String[] directory = commandLine.split(" ", 2);
	protected File newDirectory = new File(currentDirectory + "\\" + directory[1]);
	protected File[] directories = newDirectory.listFiles();
	protected Scanner scanner;

	public CommandRmdir(File currentDirectory, String commandLine) {
		super(currentDirectory, commandLine);
		scanner = new Scanner(System.in);
	}

	@Override
	public File executeCommand() {

		if(!newDirectory.isDirectory()) {
			System.out.println("디렉토리가 아닙니다.");
		} else {
			if(!newDirectory.exists()) {
				System.out.println("지정된 파일을 찾을 수 없습니다.");
			} else {
				if(directories.length>0) {
					System.out.println("디렉터리가 비어 있지 않습니다.");
				} else {
					System.out.println("계속하시겠습니까(Y/N)?");
					String chk = scanner.nextLine();
					if(chk.equals("y")||chk.equals("Y")||chk.equals("yes")||chk.equals("YES")) {
						newDirectory.delete();
						System.out.println("삭제되었습니다.");
					}
				}
			}
		}

		return currentDirectory;
	}

}